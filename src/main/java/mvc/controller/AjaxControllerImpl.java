package mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dao.user.UserDAO;
import mvc.dao.user.UserDAOImpl;
import mvc.dto.user.UserDTO;


public class AjaxControllerImpl implements AjaxController {

	private UserDAO dao = new UserDAOImpl();
	 
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	
	public void duplicateCheckByEmail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		 String mail = request.getParameter("email");
         boolean result = dao.duplicateCheckByEmail(mail);
          response.getWriter().println(result);

	}
	
	public void duplicateCheckByNickname(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		String nickname = request.getParameter("nickname");
		boolean result = dao.duplicateCheckByNickname(nickname);
		 response.getWriter().println(result);
	
	}

}
