package mvc.controller.store;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.Controller;
import mvc.controller.ModelAndView;
import mvc.dto.product.ProductDTO;
import mvc.dto.story.Story;
import mvc.dto.user.UserDTO;
import mvc.service.StoryService;
import mvc.service.StoryServiceImpl;
import mvc.service.product.ProductService;
import mvc.service.product.ProductServiceImpl;

public class StoreController implements Controller {
	private ProductService proService = new ProductServiceImpl();
	private StoryService storyService = new StoryServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	

	/**
	 * 스토어홈 화면에 출력해아하는 정보
	 */
	public ModelAndView storeHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		//회원정보 받기
		UserDTO user = (UserDTO) request.getSession().getAttribute("loginUser");
		int userCode = user.getUserCode();
		
		// 베스트 상품
		List<ProductDTO> list = proService.bestProdcut();
		request.setAttribute("bestList", list);
		
		//베스트 커뮤니티
		List<Story> storylist = storyService.selectAll(userCode);
		request.setAttribute("storylist", storylist);
		
		return new ModelAndView("store/storeHome.jsp");
	}
	

	/**
	 * 상품 상세페이지
	 */
	public ModelAndView productDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setContentType("text/html;charset=UTF-8");
		
		String url="error/signupError.jsp";
		String errMsg="상품이 없습니다";

		// 넘어오는 값 받기
		UserDTO user = (UserDTO) request.getSession().getAttribute("loginUser");
		int userCode = user.getUserCode();
		
		String productCode = request.getParameter("productCode");

		if (productCode.equals("") || productCode == null) {
			request.setAttribute("errMsg", errMsg);
		} else {
			ProductDTO prdocut = proService.selectByProductCode(userCode, Integer.parseInt(productCode));
			request.setAttribute("prodocut", prdocut);
			url="store/productDetail.jsp";
		}
		return new ModelAndView(url);
	}
	

	/**
	 * 카테고리 페이지
	 */
	public ModelAndView storeCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		

		// 카테고리 전체 정보
		Map<String, List<ProductDTO>> totalCategory = proService.totalCategory();
		

		List<ProductDTO> category1 = totalCategory.get("1");
		List<ProductDTO> category2 = totalCategory.get("2");
		List<ProductDTO> category3 = totalCategory.get("3");
		List<ProductDTO> category4 = totalCategory.get("4");
		List<ProductDTO> category5 = totalCategory.get("5");
		
		

		request.setAttribute("category1", category1);
		request.setAttribute("category2", category2);
		request.setAttribute("category3", category3);
		request.setAttribute("category4", category4);
		request.setAttribute("category5", category5);
	

		return new ModelAndView("store/storeCategory.jsp");
	}
	

	/**
	 * 베스트페이지
	 */
	public ModelAndView storeBest(HttpServletRequest request, HttpServletResponse
	response) throws ServletException, IOException, SQLException {
		// 베스트에 대한 전체 정보
		List<ProductDTO> addlist = proService.bestProdcut();
		request.setAttribute("bestList", addlist);
		
		List<ProductDTO> list = proService.totalBest();
		request.setAttribute("list", list);
		return new ModelAndView("store/storeBest.jsp");
	}

}
