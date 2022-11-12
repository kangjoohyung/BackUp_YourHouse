package mvc.service.basket;

import java.sql.SQLException;

import mvc.dao.product.ProductDAO;
import mvc.dao.product.ProductDAOImpl;
import mvc.dto.basket.BasketDTO;
import mvc.dto.product.ProductDTO;
import mvc.exception.AuthenticationException;

public class BasketServiceImpl implements BasketService {
	ProductDAO dao = new ProductDAOImpl();

	@Override
	public BasketDTO insert(int productCode, int odrerQty, String colorName) throws Exception {
		//dao 호출
		ProductDTO product = dao.selectByProductCode(productCode);
		if(product==null) {
			throw new SQLException("상품 정보를 다시 확인해주세요");
		}
		
		int price = product.getPrice();
		int unitPrice = price*odrerQty;
		
		BasketDTO basket = new BasketDTO(unitPrice, odrerQty, colorName, product);
		if(basket==null) {
			throw new Exception("상품 정보를 다시 확인해주세요");
		}
		return basket;
	}

}
