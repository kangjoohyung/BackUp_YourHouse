package mvc.dao.orders;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.orders.OrdersDTO;

public interface OrdersDAO {

	List<OrdersDTO> selectAll(int userCode) throws SQLException;
	
	/**
	 * 상세페이지에 들어가면 나오는 리뷰게시글
	 */
	
	int update() throws SQLException;

	OrdersDTO selectByOrderCode(int ordersCode) throws SQLException;

	int insert(OrdersDTO order) throws SQLException;
}
