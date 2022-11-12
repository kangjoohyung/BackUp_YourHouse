package mvc.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Provider.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mvc.controller.Controller;
import mvc.controller.ModelAndView;
import mvc.dto.product.ProductDTO;
import mvc.dto.product.ProductImageDTO;
import mvc.dto.user.UserDTO;
import mvc.service.product.ProductService;
import mvc.service.product.ProductServiceImpl;

public class ProductController implements Controller {
	private ProductService service = new ProductServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//service ==> dao 호출
		List<ProductDTO> list = service.selectAll();

		request.setAttribute("list", list);

		return new ModelAndView("index.jsp");
	}

	public ModelAndView selectByProductCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserDTO user = (UserDTO) request.getSession().getAttribute("loginUser");
		int userCode = user.getUserCode();
		
		String productCode = request.getParameter("productCode");

		//service ==> dao 호출
		ProductDTO product = service.selectByProductCode(userCode, Integer.parseInt(productCode));
		System.out.println(product);

		request.setAttribute("product", product);

		return new ModelAndView("index.jsp");
	}

	/**
	 * 등록하기
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * form에서 enctype="multipart/form-data" 설정되어 있기 때문에
		 * reqest아닌 MultipartRequest로 사용해야한다
		 */

		String saveDir = request.getServletContext().getRealPath("/save");		//저장디렉토리
		int maxSize = 1024*1024*100;		//파일 최대 용량(100mg)
		String encoding = "UTF-8";	//한글인코딩

		MultipartRequest m = new MultipartRequest(request , saveDir , maxSize , encoding , new DefaultFileRenamePolicy());

		// 전송된 데이터 받기
		String categoryCode = m.getParameter("categoryCode");
		String prodcutName = m.getParameter("prodcutName");
		String productDetail = m.getParameter("productDetail");
		String stock = m.getParameter("stock");
		String price = m.getParameter("price");

		ProductDTO product = new ProductDTO(0,
				Integer.parseInt(categoryCode), prodcutName, null, null, productDetail,
				Integer.parseInt(stock), Integer.parseInt(price));
		
		List<ProductImageDTO> imgList = new ArrayList<ProductImageDTO>();

		// 대표이미지 받기
		if(m.getFilesystemName("file")!=null) {
			//파일이름저장
			product.setImage(m.getFilesystemName("file"));
		}
		
		Enumeration fileIter = m.getFileNames();
		
		while(fileIter.hasMoreElements()) {
			String name = (String) fileIter.nextElement();
		}
	
		
		//본문이미지 받기
		if(m.getFilesystemName("imgList")!=null) {
			//파일들 저장
			imgList.add(new ProductImageDTO(0, 0, m.getFilesystemName("imgList")));
		}

		//서비스 호출하고 dao 호출
		service.insert(product);

		return new ModelAndView("front", true);
	}

}
