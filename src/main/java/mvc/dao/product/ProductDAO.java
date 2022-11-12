package mvc.dao.product;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.product.ProductDTO;

public interface ProductDAO {

	/**
	 * 상품 전체 검색
	 */
	List<ProductDTO> selectAll() throws SQLException;

	/**
	 * 상품 전체 검색(페이지처리)
	 */
	List<ProductDTO> selectAllPage(int pageNo) throws SQLException;

	/**
	 * 상품코드에 해당하는 상품 검색(또는 상세보기)
	 */
	ProductDTO selectByProductCode(int productCode) throws SQLException;

	/**
	 * 상품명 중복체크
	 * 
	 * @return : true = 중복O, false = 중복X
	 */
	boolean duplicateCheckByProductName(String productName) throws SQLException;

	/**
	 * 상품삽입
	 * 
	 * @return : 1 = 삽입성공 / 0 = 삽입실패
	 */
	int insert(ProductDTO product) throws SQLException;

	/**
	 * 상품코드에 해당하는 상품 수정
	 * 
	 * @return : 1 = 수정성공 / 0 = 수정실패
	 */
	int update(ProductDTO product) throws SQLException;

	/**
	 * 상품코드에 해당하는 상품의 재고량 수정
	 * 
	 * @return : 1 = 수정성공 / 0 = 수정실패
	 */
	int updateByProductCode(int productCode, int stock) throws SQLException;

	/**
	 * 상품코드에 해당하는 상품 삭제
	 * 
	 * @return : 1 = 삭제성공 / 0 = 삭제실패
	 */
	int delete(int productCode) throws SQLException;

	/**
	 * 판매누적순위상품
	 */
	List<ProductDTO> bestProduct() throws SQLException;

	/**
	 * 카테고리 누적순위 상품
	 */
	List<ProductDTO> categoryProduct(int category) throws SQLException;

	/**
	 * 실시간 누적판매 순위 상품
	 */
	List<ProductDTO> totalBest() throws SQLException;
}
