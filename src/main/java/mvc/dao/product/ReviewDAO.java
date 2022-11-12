package mvc.dao.product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import mvc.dto.product.AdminTongyeDTO;
import mvc.dto.product.ColorDTO;
import mvc.dto.product.ProductImageDTO;
import mvc.dto.product.ReviewDTO;

/**
 * 리뷰 등록, 조회, 중복체크 DAO
 * 
 * 리스트속 인수명-리스트명 : reviewList (arrayList)
 * 변수 이름 : reviewCode, userCode, productCode, rating, reviewContent, createdReg
 * 			possibleCheck(boolean-true/false), avgRating(소수점2자리double) 
 * @author 강주형
 *
 */
public interface ReviewDAO {

	/**
	 * 리뷰 등록(내용null인경우랑 2가지경우 필요)
	 * 
	 * 인수로 리뷰 DTO 필요 : userCode, productCode, rating, reviewContent
	 */
	public int insertReview(ReviewDTO review) throws SQLException;
	
	/**
	 * 리뷰 사용 가능한지 체크
	 * 
	 * 사용변수 : possibleCheck (boolean)
	 * ->true : 사용가능 / false : 불가능-등록불가,뷰에서 출력불가
	 */
	public boolean possibleCheck(Connection con, int userCode, int productCode) throws SQLException; 
	
	/**
	 * 리뷰 별점 평균
	 * 
	 * 사용변수 : avgRating (double)
	 * ->소수점 두자리 평점으로 나옴
	 */
	public double avgRating(Connection con, int productCode) throws SQLException;
	
	/**
	 * 리뷰 전체 조회 출력
	 * 
	 * 리스트명 : reviewList (arrayList)
	 * 변수 이름 : reviewCode, userCode, productCode, rating, reviewContent, createdReg 
	 */
	public List<ReviewDTO> selectReviewListByProduct(int userCode, int productCode) throws SQLException;
}
