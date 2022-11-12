package mvc.dao.liked;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.follow.Follow;
import mvc.dto.liked.Liked;
import mvc.dto.notice.Notice;
import mvc.dto.story.Story;

public interface LikedDAO {
	


	//삭제 // 관리자만 지울 수 있게!!!!!!!!
	
	 /**
	   *좋아요번호에 해당하는 레코드 삭제
	   * @return : 1-삭제성공 , 0 - 삭제실패
	   * */
	int delete(int LikeCode) throws SQLException;
	
	
	
	Liked isLiked(int userCode, int storyCode)throws SQLException;




	int insert(int userCode, int storyCode) throws SQLException;
	
	
	
	List<Story> selectByUserCode(int userCode)throws SQLException;
	

}
