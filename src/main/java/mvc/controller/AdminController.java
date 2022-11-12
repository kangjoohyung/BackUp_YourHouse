package mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.dto.admin.AdminDTO;
import mvc.service.AdminService;
import mvc.service.AdminServiceImpl;




public class AdminController implements Controller {
	
	private AdminService adminService = new AdminServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * admin 로그인 기능
	 * */
	public ModelAndView adminLogin(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    
		//두개의 전송되는 값을 받는다.
		String email =request.getParameter("email");
		String password =request.getParameter("password");
		
		//서비스 호출 
		AdminDTO admindbDTO = adminService.adminloginCheck( new AdminDTO(email, password) );
		System.out.println("email : "+email+" , "+"password : "+password);
		
		//로그인성공하면 세션에 정보를 저장 - ${loginAdmin} / ${loginAdminId}
		HttpSession session = request.getSession();
		session.setAttribute("loginAdmin", admindbDTO);
		session.setAttribute("loginAdminId", admindbDTO.getEmail());
		

		//index.jsp이동 - redirect방식
		
		return new ModelAndView("admin/adminIndex.jsp", true);
	}

	/**
	 * admin 로그아웃
	 * */
	public ModelAndView adminlogout(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//모든 세션의정보를 삭제한다.
		request.getSession().invalidate();
		
		return new ModelAndView("admin/adminlogout.jsp", true);
		
	}
}






