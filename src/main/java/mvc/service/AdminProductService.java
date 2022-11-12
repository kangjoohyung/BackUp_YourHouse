package mvc.service;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.product.AdminTongyeDTO;
import mvc.dto.product.ColorDTO;
import mvc.dto.product.ProductCategoryDTO;
import mvc.dto.product.ProductImageDTO;


/**
 * 관리자 상품관리 service (상품상세페이지 관리)
 * 
 * @author 강주형
 *
 */
public interface AdminProductService {
	
	/**
	 * 상품 통합 등록
	 */
	void insertTotalProduct(AdminTongyeDTO product, ColorDTO color, ProductImageDTO productImage) throws SQLException;
	
	/**
	 * 상품만 등록
	 */
	void insertProduct(AdminTongyeDTO product) throws SQLException;
	
	/**
	 * 상품사진 등록
	 */
	void insertColor(ColorDTO color) throws SQLException; 
	
	/**
	 * 색상 등록
	 */
	void insertProductImage(ProductImageDTO productImage) throws SQLException;

	/**
	 * 카테고리 등록(버젼업시 생성)
	 */
	void insertProductCategory(ProductCategoryDTO productCategory) throws SQLException;
	
	//////////////////////////////////////////
	/**
	 * 상품코드에 해당하는 상품+보조사진 수정(색상은 수정 없음)
	 * 썸네일(대표이미지) 변경시 이전 파일은 삭제
	 */
	void updateProductByProductCode(AdminTongyeDTO product, ProductImageDTO productImage, String saveDir) throws SQLException;
	
	/**
	 * 상품 업데이트 : 대표이미지(썸네일) 값 없을때->우선 보류중 작동안됨(위 코드로 통합사용)
	 * 
	 */
	void updateProductNullImageByProductCode(AdminTongyeDTO product, String saveDir) throws SQLException;
	
	
	/**
	 * 상품코드에 해당하는 재고량 수정(상품정보만)
	 * -> 재고량 수정 / 품절로 변경(0) / 판매중단으로 변경(-1)
	 */
	void updateProductStockByProductCode(int productCode, int stock) throws SQLException;
	
	//////////////////////////////////////////
	
	/**
	 * 색상코드로 색상 삭제
	 */
	void deleteColorByColorCode(int colorCode) throws SQLException;
	
	/**
	 * 상품사진코드로 상품사진정보 삭제
	 * 저장 서버에서의 사진도 삭제한다
	 */
	void deleteProductImageByProductImageCode(int productImageCode, String saveDir) throws SQLException;
	
	/**
	 * 카테고리코드로 카테고리 삭제
	 */
	void deleteCategoryByCategoryCode(int categoryCode) throws SQLException;
	
	//////////////////////////////////////////
	/**
	 * 상품리스트 출력 : 최근 생성일 맨 앞으로
	 * 등록,수정등 성공후 연결 페이지
	 * categoryName 도 뽑아올수있게 join 사용
	 */
	List<AdminTongyeDTO> selectAllProduct() throws SQLException;
	
	/**
	 * 상품코드에 해당하는 상품만 조회+categoryName 도 뽑아올수있게 join 사용
	 */
	AdminTongyeDTO selectProductByProductCode(int productCode) throws SQLException;
	
	/**
	 * 사진코드로 사진 조회
	 */
	ProductImageDTO selectProductImageByProductImageCode(int productImageCode) throws SQLException;
	
	/**
	 * 상품코드에 해당하는 상품사진 조회
	 */
	List<ProductImageDTO> selectAllProductImageByProductCode(int productCode) throws SQLException;

	
	/**
	 * 색상코드로 색상 조회
	 */
	ColorDTO selectColorByColorCode(int colorCode) throws SQLException;
	
	/**
	 * 상품코드에 해당하는 색상 조회
	 */
	List<ColorDTO> selectAllColorByProductCode(int productCode) throws SQLException;
	
	/**
	 * 카테고리 코드로 카테고리 조회
	 */
	ProductCategoryDTO selectProductCategoryByCategoryCode(int productCategoryCode) throws SQLException;
	
	/**
	 * 카테고리 전체 조회
	 */
	List<ProductCategoryDTO> selectAllProductCategory() throws SQLException;
	
	/**
	 * 카테고리 코드로 카테고리 수정(버젼업시 생성)
	 */
	void updateProductCategoryByCategoryCode(int productCategoryCode) throws SQLException;
}
