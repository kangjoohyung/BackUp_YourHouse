package mvc.dto.product;

import java.util.ArrayList;
import java.util.List;

/**
 * 상품
 */
public class ProductDTO {
	private int productCode;
	private int categoryCode;
	private String productName;
	private String image;
	private String createdReg;
	private String productDetail;
	private int stock;
	private int price;
	
	private List<ProductImageDTO> productImageList = new ArrayList<ProductImageDTO>();
	private List<ColorDTO> colorList = new ArrayList<ColorDTO>();
	private List<ReviewDTO> reviewList=new ArrayList<ReviewDTO>();
	
	public List<ReviewDTO> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<ReviewDTO> reviewList) {
		this.reviewList = reviewList;
	}

	public ProductDTO() {}
	
	public ProductDTO(int productCode, int stock) {
		this.productCode = productCode;
		this.stock = stock;
	}

	public ProductDTO(int productCode, int categoryCode, String productName, String image, 
			String productDetail, int stock, int price) {
		this.productCode = productCode;
		this.categoryCode = categoryCode;
		this.productName = productName;
		this.image = image;
		this.productDetail = productDetail;
		this.stock = stock;
		this.price = price;
	}
	
	public ProductDTO(int categoryCode, String productName, String image, 
			String productDetail, int stock, int price) {
		this.categoryCode = categoryCode;
		this.productName = productName;
		this.image = image;
		this.productDetail = productDetail;
		this.stock = stock;
		this.price = price;
	}
	
	public ProductDTO(int productCode, int categoryCode, String productName, 
			String productDetail, int stock, int price) {
		this.productCode = productCode;
		this.categoryCode = categoryCode;
		this.productName = productName;
		this.productDetail = productDetail;
		this.stock = stock;
		this.price = price;
	}
	
	public ProductDTO(int categoryCode, String productName, 
			String productDetail, int stock, int price) {
		this.categoryCode = categoryCode;
		this.productName = productName;
		this.productDetail = productDetail;
		this.stock = stock;
		this.price = price;
	}
	
	public ProductDTO(int productCode, int categoryCode, String productName, String image, String createdReg,
			String productDetail, int stock, int price) {
		this(productCode, stock);
		this.categoryCode = categoryCode;
		this.productName = productName;
		this.image = image;
		this.createdReg = createdReg;
		this.productDetail = productDetail;
		this.price = price;
	}
	
	public int getProductCode() {
		return productCode;
	}
	
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	
	public int getCategoryCode() {
		return categoryCode;
	}
	
	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	public String getCreatedReg() {
		return createdReg;
	}
	public void setCreatedReg(String createdReg) {
		this.createdReg = createdReg;
	}
	public String getProductDetail() {
		return productDetail;
	}
	
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public List<ProductImageDTO> getProductImageList() {
		return productImageList;
	}

	public void setProductImageList(List<ProductImageDTO> productImageList) {
		this.productImageList = productImageList;
	}

	public List<ColorDTO> getColorList() {
		return colorList;
	}

	public void setColorList(List<ColorDTO> colorList) {
		this.colorList = colorList;
	}
}
