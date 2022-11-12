package mvc.service.product;

import java.sql.SQLException;
import java.util.List;

import mvc.dao.product.ReviewDAO;
import mvc.dao.product.ReviewDAOImpl;
import mvc.dto.product.ReviewDTO;

public class ReviewServiceImpl implements ReviewService {

	private ReviewDAO reviewDAO=new ReviewDAOImpl();
	
	@Override
	public void insertReview(ReviewDTO review) throws SQLException {
		int result = reviewDAO.insertReview(review);
		if(result==0)throw new SQLException("등록에 실패했습니다");
		
		
	}

	@Override
	public List<ReviewDTO> selectReviewListByProduct(int userCode, int productCode) throws SQLException {
		List<ReviewDTO> reviewList=reviewDAO.selectReviewListByProduct(userCode, productCode);
		
		if(reviewList==null) throw new SQLException("리뷰 정보가 없습니다");
		
		return reviewList;
	}

}
