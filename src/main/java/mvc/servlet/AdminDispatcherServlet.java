package mvc.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.Controller;
import mvc.controller.ModelAndView;

@WebServlet(urlPatterns = { "/admin" }, loadOnStartup = 1)
public class AdminDispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Controller> map;
	private Map<String, Class<?>> clzMap;
	
	@Override
	public void init() throws ServletException {
		ServletContext application = super.getServletContext();
		map = (Map<String, Controller>)application.getAttribute("map");
		clzMap = (Map<String, Class<?>>)application.getAttribute("clzMap");
	}
	
	/**
	 * ��� ����� ��û�� ó���� ������ Controller�� ����
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		String methodName = request.getParameter("methodName");
		System.out.println("Dispatcher key+methodName="+key+methodName);
		if(key==null || key.equals("")) key="adminTongye";
		if(methodName==null || methodName.equals("")) methodName="mainMove";
		
		System.out.println(key+" , " + methodName);
		
		try {
			Controller con = map.get(key);
			Class<?> clz = clzMap.get(key);

			Method method = clz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			ModelAndView mv = (ModelAndView)method.invoke(con, request, response);	//invoke(���� �޼ҵ尡 ȣ���)
			
			if(mv.isRedirect()) {
				response.sendRedirect(mv.getViewName());
			} else {
				request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getCause().getMessage());
			request.getRequestDispatcher("error/adminError.jsp").forward(request, response);

		}
		
	}//service

}//DispatcherServlet