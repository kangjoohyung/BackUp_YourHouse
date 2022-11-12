package mvc.dao.orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.dto.orders.OrdersDetail;
import mvc.util.DBUtil;

public class OrdersDetailDAOImpl implements OrdersDetailDAO {

	@Override
	public List<OrdersDetail> selectAll(int orderCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrdersDetail> list = new ArrayList<OrdersDetail>();
		String sql = "select product_Name, a.* from orders_detail a join product b on (a.product_code=b.product_code) where orders_code = ?";
		
		try {
			con = DBUtil.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderCode);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new OrdersDetail(
						rs.getInt(2),
						rs.getInt(3),
						rs.getInt(4), 
						rs.getInt(5), 
						rs.getString(6), 
						rs.getInt(7),
						rs.getString(1)
					));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public OrdersDetail selectByOrderDetailCode(int orderDetailCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		OrdersDetail orderDetail = null;
		String sql = "select * from orders_detail where detail_code = ?";
		
		try {
			con = DBUtil.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderDetailCode);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				orderDetail =new OrdersDetail(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3), 
						rs.getInt(4), 
						rs.getString(5), 
						rs.getInt(6)
					);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return orderDetail;
	}

	@Override
	public int insert(Connection con, OrdersDetail orderDetail) throws SQLException {
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into orders_detail values(ORDERS_DETAIL_SEQ.nextval, ?, ORDERS_SEQ.currval, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderDetail.getProductCode());
			ps.setInt(2, orderDetail.getOrderQty());
			ps.setString(3, orderDetail.getColorName());
			ps.setInt(4, orderDetail.getUnitPrice());
			
			result = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(null, ps);
		}
		
		return result;
	}

}
