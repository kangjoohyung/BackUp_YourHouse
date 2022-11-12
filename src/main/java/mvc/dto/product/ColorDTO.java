package mvc.dto.product;

public class ColorDTO {
	private int colorCode;
	private int productCode;
	private String colorName;

	public ColorDTO() {}
	
	public ColorDTO(int productCode) {
		super();
		this.productCode = productCode;
	}

	public ColorDTO(String colorName) {
		this.colorName = colorName;
	}
	
	public ColorDTO(int productCode, String colorName) {
		super();
		this.productCode = productCode;
		this.colorName = colorName;
	}
	
	public ColorDTO(int colorCode, int productCode, String colorName) {
		super();
		this.colorCode = colorCode;
		this.productCode = productCode;
		this.colorName = colorName;
	}
	
	public int getColorCode() {
		return colorCode;
	}
	
	public void setColorCode(int colorCode) {
		this.colorCode = colorCode;
	}
	
	public int getProductCode() {
		return productCode;
	}
	
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	
	public String getColorName() {
		return colorName;
	}
	
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
}
