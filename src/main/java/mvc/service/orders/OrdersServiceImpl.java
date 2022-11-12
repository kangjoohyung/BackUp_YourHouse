package mvc.service.orders;

import java.sql.SQLException;
import java.util.List;

import mvc.dao.orders.OrdersDAO;
import mvc.dao.orders.OrdersDAOImpl;
import mvc.dao.orders.OrdersDetailDAO;
import mvc.dao.orders.OrdersDetailDAOImpl;
import mvc.dao.product.ProductDAO;
import mvc.dao.product.ProductDAOImpl;
import mvc.dto.orders.OrdersDTO;
import mvc.dto.orders.OrdersDetail;
import mvc.dto.product.ProductDTO;

public class OrdersServiceImpl implements OrdersService {
	private OrdersDAO dao = new OrdersDAOImpl();
	private OrdersDetailDAO orderdao = new OrdersDetailDAOImpl();
	private ProductDAO proDAO = new ProductDAOImpl();

	@Override
	public List<OrdersDTO> selectAll(int userCode) throws SQLException {
		List<OrdersDTO> orderlist = dao.selectAll(userCode);
		
		for(OrdersDTO order : orderlist) {
			List<OrdersDetail> list = orderdao.selectAll(order.getOrdersCode());
			order.setOrdreDetailList(list);
		}
		
		return orderlist;
	}

	@Override
	public OrdersDTO selectByOrderCode(int orderCode) throws SQLException {
		OrdersDTO order = dao.selectByOrderCode(orderCode);
		if(order==null) {
			throw new SQLException("정보가 올바르지 않습니다");
		}
		return order;
	}

	@Override
	public void insert(OrdersDTO order) throws SQLException {
		int result = dao.insert(order);
		if(result==0) {
			throw new SQLException("등록 실패 되었습니다");
		}
	}

}
