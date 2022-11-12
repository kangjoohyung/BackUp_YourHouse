package mvc.service.basket;

import java.sql.SQLException;

import mvc.dto.basket.BasketDTO;

public interface BasketService {
	BasketDTO insert(int productCode, int odrerQty, String colorName) throws Exception;
}
