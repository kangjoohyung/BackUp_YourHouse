package mvc.dto.product;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDTO {
	private int categoryCode;
	private String categoryName;
	
	private List<ProductDTO> productList = new ArrayList<ProductDTO>();
	
	public ProductCategoryDTO() {}
	
	public ProductCategoryDTO(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public ProductCategoryDTO(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public ProductCategoryDTO(int categoryCode, String categoryName) {
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<ProductDTO> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductDTO> productList) {
		this.productList = productList;
	}
	
}
