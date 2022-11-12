package mvc.service.product;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import mvc.dto.product.ProductDTO;

public interface ProductService {

	ProductDTO selectByProductCode(int userCode, int prodcutCode) throws SQLException;

	void insert(ProductDTO product);

	List<ProductDTO> selectAll() throws SQLException;

	boolean duplicateCheckByProductName(String productName);
	
	List<ProductDTO> bestProdcut() throws SQLException;

	/**
	 * 각 카테고리에 해당하는 베스트 상품을 출력
	 */
	Map<String, List<ProductDTO>> totalCategory() throws SQLException;
	
	/**
	 * 실시간/역대 베스트 상품을 출력
	 */
	List<ProductDTO> totalBest() throws SQLException;
}
