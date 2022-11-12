package mvc.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import mvc.controller.Controller;

/**
 * ������ ���۵� �� �� Controller�� ������ü�� �̸� �����ؼ� Map�� ������ ��
 * 	ServletContext������ map�� �����Ѵ�
 */
@WebListener
public class HandlerMappingListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent e)  { 
		// �����ؾ��ϴ� ��ü���� ������ ������ �ִ� ~.properties������ �ε�
		ServletContext application = e.getServletContext();
		String fileName = application.getInitParameter("fileName");
		System.out.println("fileName : "+fileName);
		
		ResourceBundle rb = ResourceBundle.getBundle(fileName);		//actionMapping.properties �ε�

		/**
		 * String�� ���ڿ��� Controller��� ��ü�� �����ؾ��Ѵ�
		 * 		: Class<?>�� ���ü�� ������ �ִ� �ʵ�, ������, �޼ҵ��� ������ �������� ������ �� �ֵ���
		 * 		  �����ִ� ��ü (reflection ����)
		 * 		: reflection ������ �������� , �� ���൵�߿� �ʿ��� ��ü�� �����ϰ� �����ϰ� �� ��ü�� ������ �ִ� �����ڳ� �޼ҵ带 �������� ȣ�� �Ҽ� �ֵ���
		 * 		  �����ִ� �������� reflection�̶�� �Ѵ�
		 * 		  �ڹٿ��� �̷��� ������ ������ ���� API�� Class<?> �̴�
		 */
		try {
			Map<String, Controller> map = new HashMap<String, Controller>();
			Map<String, Class<?>> clzMap = new HashMap<String, Class<?>>();
			
			for(String key : rb.keySet()) {
				String value = rb.getString(key);
				
				Class<?> className = Class.forName(value);
				Controller con = (Controller)className.getDeclaredConstructor().newInstance();
				
				map.put(key, con);
				clzMap.put(key, className);
				
				System.out.println(key+" = "+con+" : "+className);
			}
			
			// ���� ������Ʈ�� ��� �������� map�� ����� �� �ֵ��� ServletContext������ �����Ѵ�
			
			application.setAttribute("map", map);
			application.setAttribute("clzMap", clzMap);
			application.setAttribute("path", application.getContextPath());
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}//method

	public void contextDestroyed(ServletContextEvent sce)  {}

}//class
