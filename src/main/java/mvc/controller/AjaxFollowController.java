package mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dto.user.UserDTO;
import mvc.service.FollowService;
import mvc.service.FollowServiceImpl;
import mvc.service.LikedService;
import mvc.service.LikedServiceImpl;

public class AjaxFollowController implements AjaxController {
	private FollowService service = new FollowServiceImpl();


	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	public void isFollowCheck(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrintWriter out = response.getWriter();

		UserDTO user = (UserDTO) request.getSession().getAttribute("loginUser");
		int userCode = user.getUserCode();
		String followCode = request.getParameter("followCode");

		boolean result = service.isFollow(userCode, Integer.parseInt(followCode));

		if(result) {
			out.print("팔로우 등록");
		}else {
			out.print("팔로우 취소");
		}
	}




}
