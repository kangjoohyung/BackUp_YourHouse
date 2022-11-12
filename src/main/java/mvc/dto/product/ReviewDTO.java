package mvc.dto.product;

import mvc.dto.user.UserDTO;

/**
 * 리뷰 DTO -> 상품에 ReviewList있음
 * 
 * @author 강주형
 *
 */
public class ReviewDTO {
	private int reviewCode;
	private int userCode;
	private int productCode;
	private int rating;
	private String reviewContent;
	private String createdReg;
	
	private double avgRating;
	private boolean possibleCheck;
	
	private int countOne;
	private int countTwo;
	
	private UserDTO user;
	
	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewDTO(int userCode, int productCode, int rating, String reviewContent) {
		super();
		this.userCode = userCode;
		this.productCode = productCode;
		this.rating = rating;
		this.reviewContent = reviewContent;
	}

	public ReviewDTO(int reviewCode, int userCode, int productCode, int rating, String reviewContent, String createdReg,
			double avgRating, boolean possibleCheck, int countOne, int countTwo) {
		super();
		this.reviewCode = reviewCode;
		this.userCode = userCode;
		this.productCode = productCode;
		this.rating = rating;
		this.reviewContent = reviewContent;
		this.createdReg = createdReg;
		this.avgRating = avgRating;
		this.possibleCheck = possibleCheck;
		this.countOne = countOne;
		this.countTwo = countTwo;
	}

	public boolean isCheck() {
		return possibleCheck;
	}

	public void setCheck(boolean possibleCheck) {
		this.possibleCheck = possibleCheck;
	}

	public int getCountOne() {
		return countOne;
	}

	public void setCountOne(int countOne) {
		this.countOne = countOne;
	}

	public int getCountTwo() {
		return countTwo;
	}

	public void setCountTwo(int countTwo) {
		this.countTwo = countTwo;
	}

	public ReviewDTO(int userCode, int productCode, int rating, String reviewContent, String createdReg) {
		super();
		this.userCode = userCode;
		this.productCode = productCode;
		this.rating = rating;
		this.reviewContent = reviewContent;
		this.createdReg = createdReg;
	}

	public ReviewDTO(int userCode, int productCode, int rating, String reviewContent, String createdReg,
			double avgRating, boolean possibleCheck) {
		super();
		this.userCode = userCode;
		this.productCode = productCode;
		this.rating = rating;
		this.reviewContent = reviewContent;
		this.createdReg = createdReg;
		this.avgRating = avgRating;
		this.possibleCheck = possibleCheck;
	}

	public ReviewDTO(int reviewCode, int userCode, int productCode, int rating, String reviewContent, String createdReg,
			boolean possibleCheck) {
		super();
		this.reviewCode = reviewCode;
		this.userCode = userCode;
		this.productCode = productCode;
		this.rating = rating;
		this.reviewContent = reviewContent;
		this.createdReg = createdReg;
		this.possibleCheck = possibleCheck;
	}

	public ReviewDTO(int userCode, int productCode) {
		super();
		this.userCode = userCode;
		this.productCode = productCode;
	}
	
	public int getReviewCode() {
		return reviewCode;
	}

	public void setReviewCode(int reviewCode) {
		this.reviewCode = reviewCode;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getCreatedReg() {
		return createdReg;
	}

	public void setCreatedReg(String createdReg) {
		this.createdReg = createdReg;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public boolean isPossibleCheck() {
		return possibleCheck;
	}

	public void setPossibleCheck(boolean possibleCheck) {
		this.possibleCheck = possibleCheck;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
}
