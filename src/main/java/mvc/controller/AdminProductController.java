package mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mvc.dto.product.AdminTongyeDTO;
import mvc.dto.product.ColorDTO;
import mvc.dto.product.ProductCategoryDTO;
import mvc.dto.product.ProductDTO;
import mvc.dto.product.ProductImageDTO;
import mvc.service.AdminProductService;
import mvc.service.AdminProductServiceImpl;
import mvc.util.FileRenameTimeIndex;

/**
 * 상품관리 컨트롤러
 * 
 * !통합 등록 메소드 사용시 insertTotal 메소드로 사용!
 * !통합 조회 메소드 사용시 selectToTalProductByProductCode 메소드 사용!
 * (각각 개별 등록 메소드도 있음)
 * 
 * 연결 경로 : adminProduct/~~~.jsp
 * 메인(최근 생성일 기준 전체 상품) : admin/prolist.jsp
 * 상품상세(수정/등록 등에사용) : admin/prodetail.jsp
 * 상품별 사진 페이지 : admin/productImageList.jsp
 * 상품별 색상 페이지 : admin/colorList.jsp
 * 카테고리 전체 페이지 : admin/categoryList.jsp
 *-----------------------------------------------
 * 프론트 파라미터 이름 기준 == dto.product패키지의 DTO의 변수이름
 * : 개별값 적용 / DTO에 없는 리스트는 아래 내용 참조

 * !!상품페이지 리스트(DTO에 없는것들)
 * 1) 상품관리 메인페이지(최근생성일 기준 전체 상품 출력) : productList
 *    ->완료후 연결-메인 : admin/prolist.jsp
 * 2) 카테고리 전체 페이지 : categoryList
 *    ->완료후 연결-카테고리 : admin/categoryList.jsp

 * DTO에 있는 리스트는 그대로 사용
 * 3) 상품코드로 사진 조회-상품별 사진 리스트 : productImageList
 *    ->완료후 연결-상품별 사진페이지 : admin/productImageList.jsp
 * 4) 상품코드로 색상 조회-상품별 색상 리스트 : colorList
 *    ->완료후 연결-상품별 색상페이지 : admin/colorList.jsp
 * 
 * @author 강주형
 *
 */
public class AdminProductController implements Controller {

	private AdminProductService adminProductService=new AdminProductServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 통합등록
	 * : 상품+색상1+사진1 (파일 업로드 필요)
	 * 프론트 설정 : enctype="multipart/form-data"
	 * 
	 * 사진(대표이미지 포함) 저장 경로 : /productImages
	 * 
	 * 완료후 연결뷰 : 상품관리 메인페이지
	 * -> admin/prolist.jsp
	 */
	public ModelAndView insertTotalProduct(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("AdminProductController insertTotal확인용");
		//폼에서 파일업로드를 위해 enctype="multipart/form-data" 설정이 되어 있기때문에 
		//request아닌 MultipartRequest로 처리한다. - cos.jar
		String saveDir = request.getServletContext().getRealPath("productImages");
		int maxSize=1024*1024*100; //100MB
		String encoding="UTF-8";
		
		//만든파일 오류나면 이걸로 사용
		DefaultFileRenamePolicy renamePolicy = new DefaultFileRenamePolicy(); 
		
		//직접만든 파일중복처리 클래스 사용->오류발생, 우선 위 파일 사용
		//FileRenameTimeIndex renamePolicy=new FileRenameTimeIndex();

		MultipartRequest m = 
			new MultipartRequest(request,saveDir, maxSize, encoding, renamePolicy);
		
		//전송된 데이터 받기 
		String categoryCode = m.getParameter("categoryCode");
		System.out.println(categoryCode);
		String productName = m.getParameter("productName");
		String productDetail = m.getParameter("productDetail");
		String stock = m.getParameter("stock");
		String price = m.getParameter("price");
		
		AdminTongyeDTO product = 
			new AdminTongyeDTO(Integer.parseInt(categoryCode), productName, productDetail, 
					Integer.parseInt(stock), Integer.parseInt(price));

		//상품-대표이미지(썸네일) 첨부됐을때 파일명 변경하여 저장->if문 조건식은 업그레이드 대비
		//파일이름저장
		product.setImage(m.getFilesystemName("image"));
		
		//색상 등록됐을때
		//null일때 처리필요?? 테스트시 참고
		String colorName = m.getParameter("colorName");
		ColorDTO color = new ColorDTO(colorName);
		System.out.println(color);
		
		//상품이미지 등록됐을때(null아니면) : 파일첨부, 이름 db저장
		//null일때 처리필요?? 테스트시 참고 -> null 담기안됨/ notnull이니 그냥 쓰기
		//!!!!application.getInIt 파일 이름이 fileName인데 안겹치나? 테스트시 주의 (매핑리스너,web.xml)
		String fileName=m.getFilesystemName("fileName");
		ProductImageDTO productImage=new ProductImageDTO(fileName);
		productImage.setFileName(fileName);
		System.out.println(fileName);
		
		adminProductService.insertTotalProduct(product, color, productImage);
		
		return new ModelAndView("admin?key=adminProduct&methodName=selectMainTotalProduct", true);//redicrect
	}
	
	/**
	 * 상품 통합 리스트 (관리자 상품페이지 첫 화면용)
	 * : 최근 생성일 기준 전체 상품 리스트 화면 출력
	 * -> 전달값 : productList, categoryList
	 *
	 * 완료후 연결뷰 : 상품관리 메인페이지
	 * -> admin/prolist.jsp
	 */
	public ModelAndView selectMainTotalProduct(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<AdminTongyeDTO> productList=adminProductService.selectAllProduct();
		List<ProductCategoryDTO> categoryList=adminProductService.selectAllProductCategory();
		
		request.setAttribute("productList", productList);//뷰에서 ${productList}
		request.setAttribute("categoryList", categoryList);//뷰에서 ${categoryList}

		return new ModelAndView("admin/prolist.jsp"); //forward방식으로 이동
	}
	
	/**
	 * 상품상세 페이지용 조회 메소드
	 * : 상품코드로 통합 상품 조회
	 * 
	 * 전달값 : 상품+상품별색상+상품별사진+카테고리전체
	 * ->product, colorList, productImageList,categoryList
	 * 
	 * 완료후 연결 뷰 : 상품 수정 페이지
	 * -> admin/prodetail.jsp
	 */
	
	public ModelAndView selectDetailTotalProductByProductCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String productCode=request.getParameter("productCode");
			
		AdminTongyeDTO product=adminProductService.selectProductByProductCode(Integer.parseInt(productCode));
		List<ColorDTO> colorList=adminProductService.selectAllColorByProductCode(Integer.parseInt(productCode));
		List<ProductImageDTO> productImageList=adminProductService.selectAllProductImageByProductCode(Integer.parseInt(productCode));
		List<ProductCategoryDTO> categoryList=adminProductService.selectAllProductCategory();
		
		//System.out.println("colorName="+colorList.get(2));
		
		request.setAttribute("product", product);//뷰에서 ${product}
		request.setAttribute("colorList", colorList);//뷰에서 ${colorList}
		request.setAttribute("productImageList", productImageList);//뷰에서 ${productImageList}
		request.setAttribute("categoryList", categoryList);//뷰에서 ${categoryList}

		return new ModelAndView("admin/prodetail.jsp"); //forward방식으로 이동
	}
////////////////////////////////////////////////////////////////////////
	
	/**
	 * 색상 한개 등록
	 * 
	 * 완료후 연결 경로 : 조회된 상품상세페이지
	 */
	public ModelAndView insertColor(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String productCode=request.getParameter("productCode");
		String colorName=request.getParameter("colorName");
		ColorDTO color=new ColorDTO(Integer.parseInt(productCode),colorName);
		
		adminProductService.insertColor(color);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=adminProduct&methodName=selectProductByProductCode&productCode="+productCode);
	    mv.setRedirect(true);
		return mv;
	}
	
	/*
	//여러개 동시 추가대비->나중
	public ModelAndView insertColorS(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String productCode=request.getParameter("productCode");
		String colorName=request.getParameter("colorNameS");
		ColorDTO color=new ColorDTO(Integer.parseInt(productCode),colorName);
		
		request.getParameterValues(colorNameS);
		
		adminProductService.insertColor(color);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=adminProduct&methodName=selectProductByProductCode&productCode="+productCode);
	    mv.setRedirect(true);
		return mv;
	}*/
	
	/**
	 * 상품사진만 1개 등록 (파일 업로드 필요)
	 * 프론트 설정 : enctype="multipart/form-data"
	 * 
	 * 완료후 연결 경로 : 조회된 상품상세페이지
	 */
	public ModelAndView insertProductImage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//폼에서 파일업로드를 위해 enctype="multipart/form-data" 설정이 되어 있기때문에 
		//request아닌 MultipartRequest로 처리한다. - cos.jar
		String saveDir = request.getServletContext().getRealPath("productImages");
		int maxSize=1024*1024*100; //100MB
		String encoding="UTF-8";
		
		//만든파일 오류나면 이걸로 사용
		//DefaultFileRenamePolicy renamePolicy = new DefaultFileRenamePolicy(); 
		
		//직접만든 파일중복처리 클래스 사용
		FileRenameTimeIndex renamePolicy=new FileRenameTimeIndex();

		MultipartRequest m = 
			new MultipartRequest(request,saveDir, maxSize, encoding, renamePolicy);
		
		//상품이미지 등록됐을때(null아니면) : 파일첨부, 이름 db저장
		
		//!!!!application.getInIt 파일 이름이 fileName인데 안겹치나? 테스트시 주의 (매핑리스너,web.xml)
		//if(m.getFilesystemName("fileName") != null) {
		
		String fileName=m.getFilesystemName("fileName");
		String productCode=m.getParameter("productCode");
		ProductImageDTO productImage=new ProductImageDTO(Integer.parseInt(productCode), fileName);
		//}
		
		adminProductService.insertProductImage(productImage);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=adminProduct&methodName=selectProductByProductCode&productCode="+productCode);
	    mv.setRedirect(true);
		return mv;
	}

	/**
	 * 카테고리 등록(버젼업시 생성)
	 * 
	 * 완료후 연결뷰 : 관리 메인페이지
	 * -> admin/categoryList.jsp
	 */
	public ModelAndView insertProductCategory(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String categoryName=request.getParameter("categoryName");
		ProductCategoryDTO productCategory=new ProductCategoryDTO(categoryName);
		
		adminProductService.insertProductCategory(productCategory);
		
		return new ModelAndView("admin/categoryList.jsp", true);//redicrect
	}
	
	//////////////////////////////////////////
	/*
	 * //상품이미지 등록됐을때(null아니면) : 파일첨부, 이름 db저장
		//null일때 처리필요?? 테스트시 참고 -> null 담기안됨/ notnull이니 그냥 쓰기
		//!!!!application.getInIt 파일 이름이 fileName인데 안겹치나? 테스트시 주의 (매핑리스너,web.xml)
		String fileName=m.getFilesystemName("fileName");
		ProductImageDTO productImage=new ProductImageDTO(fileName);
		productImage.setFileName(fileName);
		System.out.println(fileName);
	 */
	
	/**
	 * 상품코드에 해당하는 상품+보조이미지 수정(색상은 수정 없음)
	 * 
	 * 상품 수정시에도 파일 업로드 필요(대표이미지-썸네일)
	 * 프론트 설정 : enctype="multipart/form-data"
	 * 
	 * 사진 저장 경로 : /productImages
	 * 등록할때처럼 파일 업로드 기능 넣을것
	 * 
	 * 변경시 기존 파일 삭제(서비스에서)
	 *
	 * 완료후 연결뷰 : 상품관리 상세페이지(상품코드 가지고감)
	 * -> admin?key=adminProduct&methodName=selectDetailTotalProductByProductCode&productCode="+productCode
	 */
	public ModelAndView updateProductByProductCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//폼에서 파일업로드를 위해 enctype="multipart/form-data" 설정이 되어 있기때문에 
		//request아닌 MultipartRequest로 처리한다. - cos.jar
		String saveDir = request.getServletContext().getRealPath("/productImages");
		int maxSize=1024*1024*100; //100MB
		String encoding="UTF-8";
		
		//만든파일 오류나면 이걸로 사용
		DefaultFileRenamePolicy renamePolicy = new DefaultFileRenamePolicy(); 
		
		//직접만든 파일중복처리 클래스 사용->오류생김, 우선 위 파일로 사용
		//FileRenameTimeIndex renamePolicy=new FileRenameTimeIndex();

		MultipartRequest m = 
			new MultipartRequest(request,saveDir, maxSize, encoding, renamePolicy);
		
		//전송된 데이터 받기 
		String productCode = m.getParameter("productCode");
		String categoryCode = m.getParameter("categoryCode");
		String productName = m.getParameter("productName");
		String productDetail = m.getParameter("productDetail");
		String stock = m.getParameter("stock");
		String price = m.getParameter("price");
		AdminTongyeDTO product = 
			new AdminTongyeDTO(Integer.parseInt(productCode), Integer.parseInt(categoryCode), productName, productDetail, 
					Integer.parseInt(stock), Integer.parseInt(price));
		//파일이름저장
		product.setImage(m.getFilesystemName("image"));

		
		//상품-대표이미지(썸네일) 첨부됐을때 파일명 변경하여 저장->if문 조건식은 업그레이드 대비
		/* 조건문 안먹혀서 DAO쪽에서 구분하는것으로 변경
		 if(m.getFilesystemName("image") != null) {
			//파일이름저장
			product.setImage(m.getFilesystemName("image"));

			adminProductService.updateProductByProductCode(product, saveDir);
			
		} else {
		//else if(m.getFilesystemName("image").equals(m.getParameter("image"))==true) {
			
			adminProductService.updateProductNullImageByProductCode(product, saveDir);
		} */
		
		//사진받기
		String imageCode=m.getParameter("imageCode");
		ProductImageDTO productImage=new ProductImageDTO(Integer.parseInt(imageCode), Integer.parseInt(productCode), m.getFilesystemName("fileName"));

		adminProductService.updateProductByProductCode(product, productImage, saveDir);
		
		
		return new ModelAndView("admin?key=adminProduct&methodName=selectDetailTotalProductByProductCode&productCode="+productCode, true);//redicrect
	}
	
	/**
	 * 카테고리 코드로 카테고리 수정(버젼업시 생성)
	 * 
	 * 완료후 연결뷰 : 관리 메인페이지
	 * -> admin/categoryList.jsp
	 */
	public ModelAndView updateProductCategoryByProductCategoryCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String categoryCode=request.getParameter("categoryCode");
	
		adminProductService.updateProductCategoryByCategoryCode(Integer.parseInt(categoryCode));
		
		return new ModelAndView("admin/categoryList.jsp", true);//redicrect
	}
	
	
	/**
	 * 상품코드에 해당하는 재고량 수정(상품정보만)
	 * -> 재고량 수정 / 품절로 변경(0) / 판매중단으로 변경(-1)
	 * 
	 * 연결 경로 : 조회된 상품상세페이지
	 */
	public ModelAndView updateProductStockByProductCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String productCode=request.getParameter("productCode");
		String stock=request.getParameter("stock"); 

		adminProductService.updateProductStockByProductCode(Integer.parseInt(productCode),Integer.parseInt(stock));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=adminProduct&methodName=selectProductByProductCode&productCode="+productCode);
	    mv.setRedirect(true);
		return mv;
	}
	
	//////////////////////////////////////////
	
	/**
	 * 색상코드로 색상 삭제
	 * 
	 * 연결 경로 : 조회된 상품상세페이지
	 */
	public ModelAndView deleteColorByColorCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String colorCode=request.getParameter("colorCode");
		String productCode=request.getParameter("productCode");

		adminProductService.deleteColorByColorCode(Integer.parseInt(colorCode));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=adminProduct&methodName=selectProductByProductCode&productCode="+productCode);
	    mv.setRedirect(true);
		return mv;
	}
	
	/**
	 * 사진코드로 사진 삭제
	 * 
	 * 사진 저장 경로 : /productImages
	 * 
	 * 파일 삭제는 service에서
	 * 
	 * 연결 경로 : 조회된 상품상세페이지
	 */
	public ModelAndView deleteProductImageByProductImageCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String productCode=request.getParameter("productCode");
		String saveDir = request.getServletContext().getRealPath("/productImages");
		String imageCode=request.getParameter("imageCode");

		adminProductService.deleteProductImageByProductImageCode(Integer.parseInt(imageCode), saveDir);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=adminProduct&methodName=selectProductByProductCode&productCode="+productCode);
	    mv.setRedirect(true);
		return mv;
	}
	
	//////////////////////////////////////////
	
	/**
	 * 상품코드에 해당하는 사진 조회(List)
	 * 
	 * 완료후 연결뷰 : 이미지 등록, 수정 페이지
	 * -> admin/productImageList.jsp
	 */
	public ModelAndView selectAllProductImageByProductCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String productCode=request.getParameter("productCode");
		
		List<ProductImageDTO> productImageList=adminProductService.selectAllProductImageByProductCode(Integer.parseInt(productCode));
		
		//뷰에서 ${adminProductImageList}
		request.setAttribute("productImageList", productImageList);
		
		return new ModelAndView("admin/productImageList.jsp"); //forward방식으로 이동
	}
	
	/**
	 * 상품코드에 해당하는 색상 조회(List)
	 * 
	 * 완료후 연결뷰 : 색상 등록,수정 페이지
	 * -> admin/colorList.jsp
	 */
	public ModelAndView selectAllColorByProductCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String productCode=request.getParameter("productCode");
		
		List<ColorDTO> colorList=adminProductService.selectAllColorByProductCode(Integer.parseInt(productCode));
		
		//뷰에서 ${colorList}
		request.setAttribute("colorList", colorList);
		
		return new ModelAndView("admin/colorList.jsp"); //forward방식으로 이동
	}
	
	/**
	 * 카테고리 전체 조회(List)
	 *
	 * 완료후 연결뷰 : 카테고리 관리 메인페이지
	 * -> admin/prowrite.jsp
	 */
	public ModelAndView selectAllProductCategory(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		List<ProductCategoryDTO> categoryList=adminProductService.selectAllProductCategory();
		
		//뷰에서 ${categoryList}
		request.setAttribute("categoryList", categoryList);
		
		return new ModelAndView("admin/prowrite.jsp"); //forward방식으로 이동
	}

	/**
	 * 카테고리 코드로 카테고리 조회 -> 사용할일 없을듯?
	 * 
	 * 연결 뷰 : adminProduct/adminProductCategory.jsp
	 */
	public ModelAndView selectProductCategoryByCategoryCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String categoryCode =request.getParameter("categoryCode");
		
		ProductCategoryDTO productCategory=adminProductService.selectProductCategoryByCategoryCode(Integer.parseInt(categoryCode));
		
		//뷰에서 ${productCategory}
		request.setAttribute("productCategory", productCategory);
		
		return new ModelAndView("adminProduct/adminProductCategory.jsp"); //forward방식으로 이동
	}
}
