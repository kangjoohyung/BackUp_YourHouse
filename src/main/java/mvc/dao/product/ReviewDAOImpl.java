package mvc.dao.product;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mvc.dto.product.ReviewDTO;
import mvc.util.DBUtil;

public class ReviewDAOImpl implements ReviewDAO {

	private Properties proFile = new Properties();
	
	public ReviewDAOImpl() {
		try {
			//dbQuery를 준비한 ~.properties파일을 로딩해서 Properties 자료구조에 저장한다.
			
			//현재 프로젝트가 런타임(실행)될때, 즉 서버가 실행될때 classes폴더의 위치를
			//동적으로 가져와서 경로를 설정해야한다.
			InputStream is = getClass().getClassLoader().
					getResourceAsStream("dbAdminProductQuery.properties");
			proFile.load(is);
			
			//System.out.println("출력확인용" +proFile.getProperty("product.selectAll"));
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	@Override
	public int insertReview(ReviewDTO review) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		if(review.getReviewContent()!=null) {
			String sql= proFile.getProperty("review.insertAll");
			//insert into review(review_code, user_code, product_code, rating, review_content, created_reg) values(review_seq.nextval, ? , ? , ? , ? , sysdate+9/24)
			try {
				con = DBUtil.getConnection();
				ps = con.prepareStatement(sql);
				ps.setInt(1, review.getUserCode());
				ps.setInt(2, review.getProductCode());
				ps.setInt(3, review.getRating());
				ps.setString(4, review.getReviewContent());
				
				result = ps.executeUpdate();
			}finally {
				DBUtil.dbClose(con, ps);
			}
		}else {
			String sql= proFile.getProperty("review.insertNull");
			//insert into review(review_code, user_code, product_code, rating, created_reg) values(review_seq.nextval, ?, ?, ?, ?, sysdate+9/24)
			try {
				con = DBUtil.getConnection();
				ps = con.prepareStatement(sql);
				ps.setInt(1, review.getUserCode());
				ps.setInt(2, review.getProductCode());
				ps.setInt(3, review.getRating());
				
				result = ps.executeUpdate();
			}finally {
				DBUtil.dbClose(con, ps);
			}
		}
		return result;
	}
	
	@Override
	public List<ReviewDTO> selectReviewListByProduct(int userCode, int productCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ReviewDTO> reviewList=new ArrayList<ReviewDTO>();
		
		String sql= proFile.getProperty("review.selectAllByCode");
		//select review_code, user_code, product_code, rating, review_content, created_reg from review where product_code = ? order by created_reg desc
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, productCode);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				ReviewDTO review = new ReviewDTO();
				review.setReviewCode(rs.getInt(1));
				review.setUserCode(rs.getInt(2));
				review.setProductCode(rs.getInt(3));
				review.setRating(rs.getInt(4));
				review.setReviewContent(rs.getString(5));
				review.setCreatedReg(rs.getString(6));
				
				review.setAvgRating(this.avgRating(con, productCode));
				review.setCheck(this.possibleCheck(con, userCode, productCode));
				reviewList.add(review);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return reviewList;
	}
	
	@Override
	public boolean possibleCheck(Connection con, int userCode, int productCode) throws SQLException {
		PreparedStatement ps=null;
		ResultSet rs=null;
		ReviewDTO review = new ReviewDTO();
		boolean possibleCheck =false;
		
		String sql= proFile.getProperty("review.selectCheckByUserProduct");
		//select count(product_code) countOne, count(c.review_code) countTwo from orders a full join orders_detail b using(orders_code) full join review c using(product_code) where a.user_code= ? and product_code= ?
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, userCode);
			ps.setInt(2,  productCode);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				review.setCountOne(rs.getInt(1));
				review.setCountTwo(rs.getInt(2));
				
				if(review.getCountOne()>review.getCountTwo()) possibleCheck=true;
			}
		}finally {
			DBUtil.dbClose(null, ps, rs);
		}
		
		return possibleCheck;
	}

	@Override
	public double avgRating(Connection con, int productCode) throws SQLException {
		PreparedStatement ps=null;
		ResultSet rs=null;
		double avgRating=0;
		
		String sql= proFile.getProperty("review.selectAvgRating");
		//select avg(rating) from review
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				avgRating=(Math.round(rs.getDouble(1)*100)/100.0);//소숫점 2자리까지 표시(3번째에서 반올림)
				
			}
		}finally {
			DBUtil.dbClose(null, ps, rs);
		}
		
		return avgRating;
	}

}
