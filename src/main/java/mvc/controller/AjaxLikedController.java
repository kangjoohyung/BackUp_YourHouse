package mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dto.story.Story;
import mvc.dto.user.UserDTO;
import mvc.service.LikedService;
import mvc.service.LikedServiceImpl;

public class AjaxLikedController implements AjaxController {

	private LikedService service = new LikedServiceImpl();

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	
	public void isLikeCheck(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrintWriter out = response.getWriter();
		
		UserDTO user = (UserDTO) request.getSession().getAttribute("loginUser");
		int userCode = user.getUserCode();
		String storyCode = request.getParameter("storyCode");
		
		boolean result = service.isLiked(userCode, Integer.parseInt(storyCode));
		
		if(result) {
			out.print("좋아요 등록");
		}else {
			out.print("좋아요 취소");
		}
	}
	

}
