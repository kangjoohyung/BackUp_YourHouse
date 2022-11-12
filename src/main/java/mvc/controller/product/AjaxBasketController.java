package mvc.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.controller.AjaxController;
import mvc.dto.basket.BasketDTO;
import mvc.service.basket.BasketService;
import mvc.service.basket.BasketServiceImpl;

public class AjaxBasketController implements AjaxController {
	BasketService basketserivce = new BasketServiceImpl();

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//기능없음
	}

	/**
	 * 장바구니에 상품정보 담기
	 */
	public void insert(HttpServletRequest request, HttpServletResponse response)
			throws NumberFormatException, Exception {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println(11);
		Map<String, BasketDTO> basketMap = new HashMap<String, BasketDTO>();

		if(request.getSession().getAttribute("basketMap")!=null) {
			basketMap = (Map<String, BasketDTO>) request.getSession().getAttribute("basketMap");
		}

		int totalprice = 0;

		PrintWriter out = response.getWriter();

		String productCode = request.getParameter("productCode");
		String odrerQty = request.getParameter("odrerQty");
		String colorName = request.getParameter("colorName");

		System.out.println("productCode : " + productCode);
		System.out.println("odrerQty : " + odrerQty);
		System.out.println("colorName : " + colorName);

		if(productCode==null || productCode.equals("") ||
				odrerQty==null || odrerQty.equals("") ||
				colorName==null || colorName.equals("")) {

			out.print("정보를 모두 입력하셔야합니다");
		} else {
			BasketDTO basket = basketserivce.insert(Integer.parseInt(productCode), Integer.parseInt(odrerQty), colorName);
			basketMap.put(productCode, basket);
			System.out.println(basketMap);

			Set<String> keySet = basketMap.keySet();
			for(String key : keySet) {
				BasketDTO basketresult = basketMap.get(key);
				totalprice += basketresult.getUnitPrice();
			}

			HttpSession session = request.getSession();
			session.setAttribute("basketMap", basketMap);
			session.setAttribute("totalprice", totalprice);
			out.print("장바구니에 상품을 담았습니다");
		}
	}

	/**
	 * 장바구니에 있는 상품 지우기
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, BasketDTO> basketMap = new HashMap<String, BasketDTO>();
		basketMap = (Map<String, BasketDTO>) request.getSession().getAttribute("basketMap");

		PrintWriter out = response.getWriter();

		int totalprice = 0;

		String productCode = request.getParameter("productCode");
		if(productCode==null || productCode.equals("")) {
			out.print("정보를 모두 입력하셔야합니다");
		} else {
			basketMap.remove(productCode);

			Set<String> keySet = basketMap.keySet();
			for(String key : keySet) {
				BasketDTO basketresult = basketMap.get(key);
				totalprice += basketresult.getUnitPrice();
			}

			System.out.println(basketMap.size());
			if(basketMap.size()==0) {
				request.getSession().removeAttribute("basketMap");
				request.getSession().setAttribute("totalprice", 0);
				out.print("0");
			} else {
				request.getSession().setAttribute("basketMap", basketMap);
				request.getSession().setAttribute("totalprice", totalprice);
				out.print(totalprice);
			}
		}
	}

	/**
	 * 장바구니에 담겨진 상품 수량 수정하기
	 */
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		Map<String, BasketDTO> basketMap = new HashMap<String, BasketDTO>();
		basketMap = (Map<String, BasketDTO>) request.getSession().getAttribute("basketMap");

		String orderNumqty = request.getParameter("orderNumqty");

		if(orderNumqty==null) {
			out.print("아님");
		} else {	
			int totalprice = 0;

			String productCode = request.getParameter("productCode");
			BasketDTO basket = basketMap.get(productCode);

			basket.setOdrerQty(Integer.parseInt(orderNumqty));

			int uni = Integer.parseInt(orderNumqty) * basket.getProduct().getPrice();
			basket.setUnitPrice(uni);
			
			basketMap.put(productCode, basket);

			Set<String> keySet = basketMap.keySet();
			for(String key : keySet) {
				BasketDTO basketresult = basketMap.get(key);
				totalprice += basketresult.getUnitPrice();
			}

			request.getSession().setAttribute("basketMap", basketMap);
			request.getSession().setAttribute("totalprice", totalprice);
			out.print(totalprice);
		}
	}

}

