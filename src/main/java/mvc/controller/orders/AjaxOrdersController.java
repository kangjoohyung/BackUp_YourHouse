package mvc.controller.orders;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.AjaxController;
import mvc.controller.Controller;
import mvc.controller.ModelAndView;
import mvc.dto.basket.BasketDTO;
import mvc.dto.orders.OrdersDTO;
import mvc.dto.orders.OrdersDetail;
import mvc.dto.user.UserDTO;
import mvc.service.orders.OrdersService;
import mvc.service.orders.OrdersServiceImpl;

public class AjaxOrdersController implements AjaxController {
	private OrdersService service = new OrdersServiceImpl();

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("넘어옴");
		PrintWriter out = response.getWriter();
		
		//넘오는 파라미터 값 받기
		UserDTO userdto = (UserDTO) request.getSession().getAttribute("loginUser");
		System.out.println("userdto"+userdto);
		List<OrdersDetail> detaillist = new ArrayList<OrdersDetail>();
		int userCode =  userdto.getUserCode();
		System.out.println("userCode"+userCode);
		
		String totalPrice = request.getParameter("totalPrice");
		String orderAdrss = request.getParameter("orderAdrss");
		
		System.out.println("totalPrice" + totalPrice);
		System.out.println("orderAdrss" + orderAdrss);
		
		Map<String, BasketDTO> basketMap = (Map<String, BasketDTO>) request.getSession().getAttribute("basketMap");
		Set<String> keylist = basketMap.keySet();
		
		for(String key : keylist) {
			BasketDTO basket = basketMap.get(key);
			detaillist.add(new OrdersDetail(0, basket.getProduct().getProductCode(), 0, basket.getOdrerQty(), basket.getColorName(), basket.getUnitPrice()));
		}
		
		OrdersDTO order = new OrdersDTO(0, userCode, Integer.parseInt(totalPrice), orderAdrss, null, null);
		order.setOrdreDetailList(detaillist);
		
		service.insert(order);
		
		request.getSession().removeAttribute("basketMap");
		request.getSession().removeAttribute("totalPrice");
		
		out.print("결제완료");
		
	}
}
