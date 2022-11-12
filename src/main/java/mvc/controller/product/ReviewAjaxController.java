package mvc.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.AjaxController;
import mvc.dto.product.ReviewDTO;
import mvc.dto.user.UserDTO;
import mvc.service.product.ReviewService;
import mvc.service.product.ReviewServiceImpl;
import net.sf.json.JSONArray;

/**
 * 아작스 컨트롤러 : 리뷰 등록, 조회(조회속에 중복체크 있음)
 * 
 * 리스트속 인수명-리스트명 : reviewList (arrayList)
 * 변수 이름 : reviewCode, userCode, productCode, rating, reviewContent, createdReg
 * 			possibleCheck(boolean-true/false), avgRating(소수점2자리double) 
 * @author 강주형
 *
 */
public class ReviewAjaxController implements AjaxController {

	private ReviewService reviewService=new ReviewServiceImpl();
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 리뷰 등록(내용생략 가능)
	 * 
	 * 인수로 리뷰 DTO 필요 : userCode(세션), productCode, rating, reviewContent
	 */
	public void insertReview(HttpServletRequest request, HttpServletResponse response)
		throws Exception{
		response.setContentType("text/html;charset=UTF-8");

		UserDTO user = (UserDTO) request.getSession().getAttribute("loginUser");
		int userCode = user.getUserCode();
		String productCode=request.getParameter("productCode");
		String rating=request.getParameter("rating");
		String reviewContent=request.getParameter("reviewContent");
		
		ReviewDTO review=new ReviewDTO(userCode, Integer.parseInt(productCode), Integer.parseInt(rating), reviewContent);
		reviewService.insertReview(review);
		
		PrintWriter out = response.getWriter();
		out.print("11");
}
	
	/**
	 * 리스트속 인수명-리스트명 : reviewList (arrayList)
	 * 변수 이름 : reviewCode, userCode, productCode, rating, reviewContent, createdReg
	 * 			possibleCheck(boolean-true/false), avgRating(소수점2자리double) 
	 */
	public void selectReviewListByProduct(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		response.setContentType("text/html;charset=UTF-8");   

		UserDTO user = (UserDTO) request.getSession().getAttribute("loginUser");
		int userCode = user.getUserCode();
		String productCode=request.getParameter("productCode");
		List<ReviewDTO> rList=reviewService.selectReviewListByProduct(userCode, Integer.parseInt(productCode));
		
		JSONArray reviewList = JSONArray.fromObject(rList);
		PrintWriter out = response.getWriter();
		out.print(reviewList);
	}
}
