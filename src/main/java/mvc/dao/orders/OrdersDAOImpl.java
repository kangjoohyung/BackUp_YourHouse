package mvc.dao.orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.dto.orders.OrdersDTO;
import mvc.dto.orders.OrdersDetail;
import mvc.util.DBUtil;

public class OrdersDAOImpl implements OrdersDAO {

	@Override
	public List<OrdersDTO> selectAll(int userCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrdersDTO> list = new ArrayList<OrdersDTO>();
		String sql = "select * from orders where user_code = ?";
		
		try {
			con = DBUtil.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, userCode);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new OrdersDTO(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
					));
			}
			
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}

	@Override
	public OrdersDTO selectByOrderCode(int ordersCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		OrdersDTO order = new OrdersDTO();
		String sql = "select * from orders where orders_code = ?";
		
		try {
			con = DBUtil.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, ordersCode);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				order = new OrdersDTO(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
					);
			}
			
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return order;
	}

	public int insert(OrdersDTO order) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into orders values(ORDERS_SEQ.nextval, ?, ?, ?, ?, sysdate+9/24)";
		
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, order.getUserCode());
			ps.setInt(2, order.getTotalPrice());
			ps.setString(3, order.getOrdersAdress());
			ps.setString(4, "결제완료");
			
			result = ps.executeUpdate();
			
			if(result != 0) {
				for(OrdersDetail orderDetail : order.getOrdreDetailList()) {
					result = new OrdersDetailDAOImpl().insert(con, orderDetail);
				}
			}
			
			if(result!=0) {
				con.commit();
			}
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public int update() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
