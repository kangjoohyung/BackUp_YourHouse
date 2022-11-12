package mvc.service.orders;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.orders.OrdersDTO;

public interface OrdersService {

	List<OrdersDTO> selectAll(int userCode) throws SQLException;
	
	OrdersDTO selectByOrderCode(int orderCode) throws SQLException;
	
	void insert(OrdersDTO order) throws SQLException;
}
