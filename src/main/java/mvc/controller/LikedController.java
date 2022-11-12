package mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dto.story.Story;
import mvc.dto.user.UserDTO;
import mvc.service.LikedService;
import mvc.service.LikedServiceImpl;

public class LikedController implements Controller{
	
	private LikedService service = new LikedServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}


	//마이페이지에서 ㅎ회원정보로 좋아요게시글 조회
	public ModelAndView selectByUserCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserDTO user = (UserDTO) request.getSession().getAttribute("loginUser");
		int userCode = user.getUserCode();


		List<Story> list = service.selectByUserCode(userCode);
		
		request.setAttribute("list", list);//뷰에서 ${list}
		System.out.println(list);


		return new ModelAndView("mypage/likedList");
	}



}
