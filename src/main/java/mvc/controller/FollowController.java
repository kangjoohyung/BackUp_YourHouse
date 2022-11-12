package mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dto.story.Story;
import mvc.dto.user.UserDTO;
import mvc.service.FollowService;
import mvc.service.FollowServiceImpl;

public class FollowController implements Controller {

	private FollowService service = new FollowServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public ModelAndView selectByUserCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserDTO user = (UserDTO) request.getSession().getAttribute("loginUser");
		int userCode = user.getUserCode();


		List<UserDTO> list = service.selectByUserCode(userCode);

		request.setAttribute("list", list);//뷰에서 ${list}
		System.out.println(list);


		return new ModelAndView("mypage/followList");

	}
	
	public ModelAndView following(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserDTO user = (UserDTO) request.getSession().getAttribute("loginUser");
		int userCode = user.getUserCode();


		List<Story> list = service.following(userCode);

		request.setAttribute("list", list);//뷰에서 ${list}
		System.out.println(list);


		return new ModelAndView("community/following.jsp");

	}
	
	
}
