package mvc.service.product;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.product.ReviewDTO;

/**
 * 리뷰 등록, 조회(조회속에 중복체크 있음) Service
 * 
 * 리스트속 인수명-리스트명 : reviewList (arrayList)
 * 변수 이름 : reviewCode, userCode, productCode, rating, reviewContent, createdReg
 * 			possibleCheck(boolean-true/false), avgRating(소수점2자리double) 
 * @author 강주형
 *
 */
public interface ReviewService {
	

	/**
	 * 리뷰 등록(내용생략 가능)
	 * 
	 * 인수로 리뷰 DTO 필요 : userCode(세션), productCode, rating, reviewContent
	 */
	void insertReview (ReviewDTO review) throws SQLException;
	
	/**
	 * 리뷰 전체 조회 출력
	 * 
	 * 리스트속 인수명-리스트명 : reviewList (arrayList)
	 * 변수 이름 : reviewCode, userCode, productCode, rating, reviewContent, createdReg
	 * 			possibleCheck(boolean-true/false), avgRating(소수점2자리double) 
	 */
	public List<ReviewDTO> selectReviewListByProduct (int userCode, int productCode) throws SQLException;

}
