package mvc.dao.orders;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import mvc.dto.orders.OrdersDetail;

public interface OrdersDetailDAO {
	
	List<OrdersDetail> selectAll(int orderCode) throws SQLException;
	
	OrdersDetail selectByOrderDetailCode(int orderDetailCode) throws SQLException;

	int insert(Connection con, OrdersDetail orderDetail) throws SQLException;
}
