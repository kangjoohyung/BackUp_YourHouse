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

import mvc.controller.AjaxController;
import mvc.controller.Controller;

/**
 *  사용자의 모든 AJAX 요청을 처리할 진입점 Controller이다(FrontController의 역할한다)
 */

@WebServlet(urlPatterns = "/ajax" , loadOnStartup = 1)
public class AjaxDispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private Map<String, AjaxController> map;
    private Map<String, Class<?>> clzMap;
 	@Override
	public void init() throws ServletException {
		//map = (Map<String, Controller>)super.getServletContext().getAttribute("map");
		
		ServletContext application = super.getServletContext();
		Object obj = application.getAttribute("ajaxMap");
		map = (Map<String, AjaxController>)obj;
		clzMap = (Map<String, Class<?>>)super.getServletContext().getAttribute("ajaxClzMap");
		
	}//ServletException end
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key"); //customer
		String methodName = request.getParameter("methodName"); //idCheck , insert , selectAll
		
		System.out.println("key = " + key+", methodName = " + methodName);
		try {
			Class<?> clz = clzMap.get(key);
			System.out.println(clz);
			Method method = clz.getMethod(methodName, HttpServletRequest.class , HttpServletResponse.class);

			System.out.println(method);
			AjaxController controller = map.get(key);

			method.invoke(controller, request , response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//service end

}









