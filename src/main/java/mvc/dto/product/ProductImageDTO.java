package mvc.dto.product;

public class ProductImageDTO {
	private int imageCode;
	private int productCode;
	private String fileName;
	
	public ProductImageDTO() {}
	
	public ProductImageDTO(int imageCode) {
		super();
		this.imageCode = imageCode;
	}

	public ProductImageDTO(int imageCode, int productCode) {
		super();
		this.imageCode = imageCode;
		this.productCode = productCode;
	}

	public ProductImageDTO(String fileName) {
		this.fileName = fileName;
	}
	
	public ProductImageDTO(int productCode, String fileName) {
		this.productCode = productCode;
		this.fileName = fileName;
	}

	public ProductImageDTO(int imageCode, int productCode, String fileName) {
		this.imageCode = imageCode;
		this.productCode = productCode;
		this.fileName = fileName;
	}

	public int getImageCode() {
		return imageCode;
	}

	public void setImageCode(int imageCode) {
		this.imageCode = imageCode;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
