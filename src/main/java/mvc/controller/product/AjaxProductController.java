package mvc.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.AjaxController;
import mvc.controller.ModelAndView;
import mvc.dto.product.ProductDTO;
import mvc.service.product.ProductService;
import mvc.service.product.ProductServiceImpl;
import net.sf.json.JSONArray;

public class AjaxProductController implements AjaxController {
	private ProductService service = new ProductServiceImpl();

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	public void selectAll(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		
		//service ==> dao 호출
		List<ProductDTO> list = service.selectAll();
		System.out.println(list);
		
		JSONArray arr = JSONArray.fromObject(list);
		PrintWriter out = response.getWriter();
				
		out.print(arr);
		
	}
	
	public void duplicateCheckByProductName(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String productName = request.getParameter("productName");
		
		PrintWriter out = response.getWriter();
		
		//service ==> dao 호출
		boolean result = service.duplicateCheckByProductName(productName);
		
		if(result) {
			out.print("이미 사용중인 상품명입니다");
		} else {
			out.print("사용가능한 상품명입니다");
		}
	}
}
