package mvc.dto.product;

/**
 * 통계에서 쓰기위해
 * 편의상 통합 정보용 DTO 새로 만듦
 * 최대 4join 사용
 * 
 * @author 강주형
 */
public class AdminTongyeDTO {
	//각각 중복값 제외+통계 조회시 필요없는 내용 삭제
	
	//rownum
	private int rownum; //행번호(베스트메뉴 등등)
	
	//합계출력 
	private int sumPrice; //매출금액
	private int sumQty; //매출수량
	
	//상품정보들
	private int productCode;
	private int categoryCode;
	private String productName;
	private String image;
	private String createdReg;
	private String productDetail;
	private int stock;
	private int price;
	
	//카테고리 정보
	private String categoryName;
	

	//기간입력
	private String startDate;
	private String lastDate;

	public AdminTongyeDTO() {
	}

	public AdminTongyeDTO(int rownum, int sumPrice, int sumQty, int productCode, int categoryCode, String productName,
			String image, String createdReg, String productDetail, int stock, int price, String categoryName) {
		super();
		this.rownum = rownum;
		this.sumPrice = sumPrice;
		this.sumQty = sumQty;
		this.productCode = productCode;
		this.categoryCode = categoryCode;
		this.productName = productName;
		this.image = image;
		this.createdReg = createdReg;
		this.productDetail = productDetail;
		this.stock = stock;
		this.price = price;
		this.categoryName = categoryName;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	/**
	 * @param 
	 * int productCode 또는 int categoryCode 사용
	 * startDate, lastDate사용
	 * 
	 */
	public AdminTongyeDTO(int productCode, String startDate, String lastDate) {
		super();
		this.productCode = productCode;
		this.startDate = startDate;
		this.lastDate = lastDate;
	}
	
	/**
	 * 
	 * @param productCode 또는 categoryCode
	 */
	public AdminTongyeDTO(int productCode) {
		super();
		this.productCode = productCode;
	}

	public AdminTongyeDTO(int sumPrice, int sumQty) {
		super();
		this.sumPrice = sumPrice;
		this.sumQty = sumQty;
	}

	public AdminTongyeDTO(String startDate, String lastDate) {
		super();
		this.startDate = startDate;
		this.lastDate = lastDate;
	}

	public AdminTongyeDTO(int sumPrice, int sumQty, String startDate, String lastDate) {
		super();
		this.sumPrice = sumPrice;
		this.sumQty = sumQty;
		this.startDate = startDate;
		this.lastDate = lastDate;
	}

	public AdminTongyeDTO(int productCode, int categoryCode, String productName, String image,
			String createdReg, String productDetail, int stock, int price, String categoryName,
			String startDate, String lastDate) {
		super();
		this.productCode = productCode;
		this.categoryCode = categoryCode;
		this.productName = productName;
		this.image = image;
		this.createdReg = createdReg;
		this.productDetail = productDetail;
		this.stock = stock;
		this.price = price;
		this.categoryName = categoryName;
		this.startDate = startDate;
		this.lastDate = lastDate;
	}
	
	public AdminTongyeDTO(int sumPrice, int sumQty, int productCode, int categoryCode, String productName, String image,
			String createdReg, String productDetail, int stock, int price, String categoryName,
			String startDate, String lastDate) {
		super();
		this.sumPrice = sumPrice;
		this.sumQty = sumQty;
		this.productCode = productCode;
		this.categoryCode = categoryCode;
		this.productName = productName;
		this.image = image;
		this.createdReg = createdReg;
		this.productDetail = productDetail;
		this.stock = stock;
		this.price = price;
		this.categoryName = categoryName;
		this.startDate = startDate;
		this.lastDate = lastDate;
	}
	
	public AdminTongyeDTO(int sumPrice, int sumQty, int productCode, int categoryCode, String productName, String image,
			String createdReg, String productDetail, int stock, int price, String categoryName) {
		super();
		this.sumPrice = sumPrice;
		this.sumQty = sumQty;
		this.productCode = productCode;
		this.categoryCode = categoryCode;
		this.productName = productName;
		this.image = image;
		this.createdReg = createdReg;
		this.productDetail = productDetail;
		this.stock = stock;
		this.price = price;
		this.categoryName = categoryName;
	}

	public AdminTongyeDTO(int productCode, int categoryCode, String productName, String image, String createdReg,
			String productDetail, int stock, int price, String categoryName) {
		super();
		this.productCode = productCode;
		this.categoryCode = categoryCode;
		this.productName = productName;
		this.image = image;
		this.createdReg = createdReg;
		this.productDetail = productDetail;
		this.stock = stock;
		this.price = price;
		this.categoryName = categoryName;
	}

	public AdminTongyeDTO(int productCode, int categoryCode, String productName, String image, String createdReg,
			String productDetail, int stock, int price) {
		super();
		this.productCode = productCode;
		this.categoryCode = categoryCode;
		this.productName = productName;
		this.image = image;
		this.createdReg = createdReg;
		this.productDetail = productDetail;
		this.stock = stock;
		this.price = price;
	}

	public AdminTongyeDTO(int categoryCode, String productName, String productDetail, int stock, int price) {
		super();
		this.categoryCode = categoryCode;
		this.productName = productName;
		this.productDetail = productDetail;
		this.stock = stock;
		this.price = price;
	}

	public AdminTongyeDTO(int productCode, int categoryCode, String productName, String productDetail, int stock,
			int price) {
		super();
		this.productCode = productCode;
		this.categoryCode = categoryCode;
		this.productName = productName;
		this.productDetail = productDetail;
		this.stock = stock;
		this.price = price;
	}

	public int getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}

	public int getSumQty() {
		return sumQty;
	}

	public void setSumQty(int sumQty) {
		this.sumQty = sumQty;
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	
}
