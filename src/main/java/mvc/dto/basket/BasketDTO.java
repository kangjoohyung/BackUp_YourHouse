package mvc.dto.basket;

import java.util.ArrayList;
import java.util.List;

import mvc.dto.product.ProductDTO;
import mvc.dto.user.UserDTO;

public class BasketDTO {
	private int unitPrice;
	private int odrerQty;
	private String colorName;
	private ProductDTO product = new ProductDTO();
	
	public BasketDTO() {}

	public BasketDTO(int unitPrice, int odrerQty, String colorName, ProductDTO product) {
		this.unitPrice = unitPrice;
		this.odrerQty = odrerQty;
		this.colorName = colorName;
		this.product = product;
	}

	public int getOdrerQty() {
		return odrerQty;
	}

	public void setOdrerQty(int odrerQty) {
		this.odrerQty = odrerQty;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
}
