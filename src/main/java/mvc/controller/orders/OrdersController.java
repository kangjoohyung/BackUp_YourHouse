package mvc.controller.orders;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.Controller;
import mvc.controller.ModelAndView;
import mvc.dto.orders.OrdersDTO;
import mvc.dto.user.UserDTO;
import mvc.service.orders.OrdersService;
import mvc.service.orders.OrdersServiceImpl;

public class OrdersController implements Controller {
	private OrdersService service = new OrdersServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		UserDTO userdto = (UserDTO) request.getSession().getAttribute("loginUser");
		int userCode =  userdto.getUserCode();

		List<OrdersDTO> ordersList = service.selectAll(userCode);
		request.setAttribute("ordersList", ordersList);
		return new ModelAndView("index.jsp");
	}

	public ModelAndView selectByUserCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		//넘오는 파라미터 값 받기
		UserDTO userdto = (UserDTO) request.getSession().getAttribute("loginUser");
		int userCode =  userdto.getUserCode();
		
		List<OrdersDTO> orderlist = service.selectAll(userCode);
		
		request.setAttribute("orderlist", orderlist);
		
		return new ModelAndView("mypage/myShopping.jsp");
	}

	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//넘오는 파라미터 값 받기
		UserDTO userdto = (UserDTO) request.getSession().getAttribute("loginUser");
		int userCode =  userdto.getUserCode();

		String totalPrice = request.getParameter("totalPrice");
		String orderAdrss = request.getParameter("orderAdrss");
		String productCode = request.getParameter("productCode");
		String orderQty = request.getParameter("orderQty");
		String colorName = request.getParameter("colorName");
		String unitPrice = request.getParameter("unitPrice");

		OrdersDTO order = new OrdersDTO(0, userCode, Integer.parseInt(totalPrice), orderAdrss, null, null);
		order.setOrdreDetailList(null);
		return null;
	}
}
