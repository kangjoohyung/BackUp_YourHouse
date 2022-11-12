package mvc.dao.product;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mvc.dto.product.AdminTongyeDTO;
import mvc.util.DBUtil;

public class AdminTongyeDAOImpl implements AdminTongyeDAO {

	private Properties proFile = new Properties();
	
	public AdminTongyeDAOImpl() {

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
	public List<AdminTongyeDTO> selectTongyeMain() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<AdminTongyeDTO> tongyeList=new ArrayList<AdminTongyeDTO>();
		
		String sql=proFile.getProperty("selectTongyeMain");
		//select rownum, dd.* from (select sum(unit_price*order_qty) sum_price, sum(order_qty) sum_qty, product_code, category_code, product_name, image, created_reg, product_detail, stock, price, category_name from product a full join product_category b using(category_code) full join orders_detail c using(product_code) full join orders c using(orders_code) where orders_reg >= (sysdate+9/24-30) and orders_reg < (sysdate+1+9/24) group by category_name, product_code, category_code, product_name, image, created_reg, product_detail, stock, price order by sum_qty desc, created_reg desc) dd where rownum<=10
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				AdminTongyeDTO tongye = new AdminTongyeDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10),
						rs.getInt(11), rs.getString(12));
				
				tongyeList.add(tongye);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return tongyeList;
	
		
	}

	@Override
	public List<AdminTongyeDTO> selectTongyePrAllSum(String startDate, String lastDate) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<AdminTongyeDTO> tongyeList = new ArrayList<AdminTongyeDTO>();
		
		String sql= proFile.getProperty("selectTongyePrAllSum");//total col : 2, 11 / int : 1, 2, 3, 4, 9, 10
		//select sum(unit_price*order_qty) sum_price, sum(order_qty) sum_qty from product a full join product_category b using(category_code) full join orders_detail c using(product_code) full join orders c using(orders_code) where orders_reg >= to_date(?, 'yyyymmdd') and orders_reg < to_date(?+1, 'yyyymmdd')
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, startDate);
			ps.setString(2, lastDate);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				AdminTongyeDTO tongye = new AdminTongyeDTO(rs.getInt(1), rs.getInt(2));
				
				tongyeList.add(tongye);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return tongyeList;
	}

	@Override
	public List<AdminTongyeDTO> selectTongyePrAllPro(String startDate, String lastDate) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<AdminTongyeDTO> tongyeList = new ArrayList<AdminTongyeDTO>();
		
		String sql= proFile.getProperty("selectTongyePrAllPro");//total col : 2, 11 / int : 1, 2, 3, 4, 9, 10
		//select sum(unit_price*order_qty) sum_price, sum(order_qty) sum_qty, product_code, category_code, product_name, image, created_reg, product_detail, stock, price, category_name from product a full join product_category b using(category_code) full join orders_detail c using(product_code) full join orders c using(orders_code) where orders_reg >= to_date(?, 'yyyymmdd') and orders_reg < to_date(?+1, 'yyyymmdd') group by category_name, product_code, category_code, product_name, image, created_reg, product_detail, stock, price order by sum_qty desc, sum_price desc
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, startDate);
			ps.setString(2, lastDate);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				AdminTongyeDTO tongye = new AdminTongyeDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9),
						rs.getInt(10), rs.getString(11));
				
				tongyeList.add(tongye);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return tongyeList;
	}

	@Override
	public List<AdminTongyeDTO> selectTongyeCaAllSum(int categoryCode, String startDate, String lastDate)
			throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<AdminTongyeDTO> tongyeList = new ArrayList<AdminTongyeDTO>();
		
		String sql= proFile.getProperty("selectTongyeCaAllSum");//total col : 2, 11 / int : 1, 2, 3, 4, 9, 10
		//select sum(unit_price*order_qty) sum_price, sum(order_qty) sum_qty from product a full join product_category b using(category_code) full join orders_detail c using(product_code) full join orders c using(orders_code) where orders_reg >= to_date(?, 'yyyymmdd') and orders_reg < to_date(?+1, 'yyyymmdd') and category_code = ?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, startDate);
			ps.setString(2, lastDate);
			ps.setInt(3, categoryCode);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				AdminTongyeDTO tongye = new AdminTongyeDTO(rs.getInt(1), rs.getInt(2));
				
				tongyeList.add(tongye);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return tongyeList;
	}

	@Override
	public List<AdminTongyeDTO> selectTongyeCaAllPro(int categoryCode, String startDate, String lastDate)
			throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<AdminTongyeDTO> tongyeList = new ArrayList<AdminTongyeDTO>();
		
		String sql= proFile.getProperty("selectTongyeCaAllPro");//total col : 2, 11 / int : 1, 2, 3, 4, 9, 10
		//select sum(unit_price*order_qty) sum_price, sum(order_qty) sum_qty, product_code, category_code, product_name, image, created_reg, product_detail, stock, price, category_name from product a full join product_category b using(category_code) full join orders_detail c using(product_code) full join orders c using(orders_code) where orders_reg >= to_date(?, 'yyyymmdd') and orders_reg < to_date(?+1, 'yyyymmdd') and category_code = ? group by category_name, product_code, category_code, product_name, image, created_reg, product_detail, stock, price order by sum_qty desc, sum_price desc
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, startDate);
			ps.setString(2, lastDate);
			ps.setInt(3, categoryCode);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				AdminTongyeDTO tongye = new AdminTongyeDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9),
						rs.getInt(10), rs.getString(11));
				
				tongyeList.add(tongye);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return tongyeList;
	}

	@Override
	public List<AdminTongyeDTO> selectTongyeProdSum(int productCode, String startDate, String lastDate)
			throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<AdminTongyeDTO> tongyeList = new ArrayList<AdminTongyeDTO>();
		
		String sql= proFile.getProperty("selectTongyeProdSum");//total col : 2, 11 / int : 1, 2, 3, 4, 9, 10
		//select sum(unit_price*order_qty) sum_price, sum(order_qty) sum_qty from product a full join product_category b using(category_code) full join orders_detail c using(product_code) full join orders c using(orders_code) where orders_reg >= to_date(?, 'yyyymmdd') and orders_reg < to_date(?+1, 'yyyymmdd') and product_code = ?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, startDate);
			ps.setString(2, lastDate);
			ps.setInt(3, productCode);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				AdminTongyeDTO tongye = new AdminTongyeDTO(rs.getInt(1), rs.getInt(2));
				
				tongyeList.add(tongye);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return tongyeList;
	}

	@Override
	public List<AdminTongyeDTO> selectTongyeProdPro(int productCode, String startDate, String lastDate)
			throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<AdminTongyeDTO> tongyeList = new ArrayList<AdminTongyeDTO>();
		
		String sql= proFile.getProperty("selectTongyeProdPro");//total col : 2, 11 / int : 1, 2, 3, 4, 9, 10
		//select sum(unit_price*order_qty) sum_price, sum(order_qty) sum_qty, product_code, category_code, product_name, image, created_reg, product_detail, stock, price, category_name from product a full join product_category b using(category_code) full join orders_detail c using(product_code) full join orders c using(orders_code) where orders_reg >= to_date(?, 'yyyymmdd') and orders_reg < to_date(?+1, 'yyyymmdd') and product_code = ? group by category_name, product_code, category_code, product_name, image, created_reg, product_detail, stock, price order by sum_qty desc, sum_price desc
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, startDate);
			ps.setString(2, lastDate);
			ps.setInt(3, productCode);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				AdminTongyeDTO tongye = new AdminTongyeDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9),
						rs.getInt(10), rs.getString(11));
				
				tongyeList.add(tongye);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return tongyeList;
	}

}
