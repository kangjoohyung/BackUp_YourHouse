package mvc.dao.product;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mvc.dto.product.ProductDTO;
import mvc.util.DBUtil;

public class ProductDAOImpl implements ProductDAO {
	private Properties proFile = new Properties();
	
	public ProductDAOImpl() {
		try {
			//dbQuery를 준비한 ~.properties파일을 로딩해서 Properties 자료구조에 저장한다.
			
			//현재 프로젝트가 런타임(실행)될때, 즉 서버가 실행될때 classes폴더의 위치를
			//동적으로 가져와서 경로를 설정해야한다.
			InputStream is = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
			proFile.load(is);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ProductDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "select * from product";

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				list.add(new ProductDTO(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getInt(7),
						rs.getInt(8)
						));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<ProductDTO> selectAllPage(int pageNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO selectByProductCode(int productCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductDTO product = null;
		String sql = "select * from product where product_code = ?";

		try {
			con = DBUtil.getConnection();

			ps = con.prepareStatement(sql);
			ps.setInt(1, productCode);

			rs = ps.executeQuery();

			if(rs.next()) {
				product =new ProductDTO(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getInt(7),
						rs.getInt(8)
						);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return product;
	}

	@Override
	public boolean duplicateCheckByProductName(String productName) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		String sql = "select product_name from product where product_name = ?";

		try {
			con = DBUtil.getConnection();

			ps = con.prepareStatement(sql);
			ps.setString(1, productName);

			rs = ps.executeQuery();

			if(rs.next()) {
				result = true;
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}

		return result;
	}

	@Override
	public int insert(ProductDTO product) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into product values(product_seq.nextval, ?, ?, ?, sysdate, ?, ?, ?)";

		try {
			con = DBUtil.getConnection();

			ps = con.prepareStatement(sql);
			ps.setInt(1, product.getCategoryCode());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getImage());
			ps.setString(4, product.getProductDetail());
			ps.setInt(5, product.getStock());
			ps.setInt(6, product.getPrice());

			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}

		return result;
	}

	@Override
	public int update(ProductDTO product) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update product set product_name=?, product_detail=?, price=? where product_code=?";

		try {
			con = DBUtil.getConnection();

			ps = con.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductDetail());
			ps.setInt(3, product.getPrice());
			ps.setInt(4, product.getProductCode());

			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}

		return result;
	}

	@Override
	public int updateByProductCode(int productCode, int stock) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update product set stock=? where product_code=?";

		try {
			con = DBUtil.getConnection();

			ps = con.prepareStatement(sql);
			ps.setInt(1, stock);
			ps.setInt(2, productCode);

			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}

		return result;
	}

	@Override
	public int delete(int productCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from product where product_code=?";

		try {
			con = DBUtil.getConnection();

			ps = con.prepareStatement(sql);
			ps.setInt(2, productCode);

			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}

		return result;
	}

	@Override
	public List<ProductDTO> bestProduct() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "select * from (select rownum, product.* from product) where rownum BETWEEN 1 and 8";

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				list.add(new ProductDTO(
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7), 
						rs.getInt(8),
						rs.getInt(9)
						));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<ProductDTO> categoryProduct(int category) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "select * from product where CATEGORY_CODE=?";

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, category);
			rs = ps.executeQuery();

			while(rs.next()) {
				list.add(new ProductDTO(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getInt(7),
						rs.getInt(8)
						));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<ProductDTO> totalBest() throws SQLException {
		//실시간/역대 누적판매 순위 상품
		Connection con = null;
		PreparedStatement ps = null; ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = proFile.getProperty("product.storeBest");

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				list.add(new ProductDTO(
						rs.getInt(4),	//상품코드
						rs.getInt(5),	//카테고리 코드
						rs.getString(6),	//상품이름
						rs.getString(7),	//상품이미지
						rs.getString(8),	//상품생성일
						rs.getString(9),	//상품설명
						rs.getInt(10),	//상품수량
						rs.getInt(11)		//상품가격
				));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

}
