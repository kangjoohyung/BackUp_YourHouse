package mvc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * UserSession 체크용 필터 (밑의 사용 key로 이동시 필터로 세션을 체크한다)
 * session사용 인수명 : loginUser
 * 
 * 매핑 프로퍼티에 사용되는 key
 * : product, ~
 * -> 생성,변경시 주석,조건문 변경해주세요
 * 
 * key주소로 접근시 세션이 비어있다면 
 * errorMsg 인수 사용
 * 현재 경로 error/userError.jsp 페이지로 이동한다
 * (뷰 생성하여 변경필요시 주석과 경로 수정해주세요)
 */
//@WebFilter("/front")
public class UserSessionCheckFilter implements Filter {
	public void destroy() {}

    public UserSessionCheckFilter() {
    	System.out.println("UserSessionCheckFilter 생성됨...");
    }
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("UserSessionCheck....");
		//사전처리 -> 인증여부를 체크한다.
	
		
		String key = request.getParameter("key");
		if(key==null || key.equals("")) {//조건식에 진입하는 key 넣기-Dispatcher서블릿에 입력된 그대로
			
			//인증된 사용자만 해라...
			HttpServletRequest req = (HttpServletRequest)request;
			HttpSession session = req.getSession();
			if(session.getAttribute("loginUser") ==null) {
				req.setAttribute("errorMsg", "로그인후 이용해주세요");
				req.getRequestDispatcher("error/userError.jsp").forward(request, response);
				return ;//함수를 빠져나가라
			}
		}
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
