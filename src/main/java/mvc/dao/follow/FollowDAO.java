package mvc.dao.follow;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.follow.Follow;
import mvc.dto.story.Story;
import mvc.dto.user.UserDTO;

public interface FollowDAO {
	
	//팔로우 하기
	int insert(int followingCode, int followerCode) throws SQLException;
	
	//팔로우 취소
	int delete(int FollowCode) throws SQLException;
	
	

	Follow isFollow(int userCode, int followerCode)throws SQLException;

	
	
	//내가 파로잉한 사람목록 전체보기
	List<Story> selectByUserCode(int userCode)throws SQLException;
	
	//팔로워 사람목록 전체보기
	List<Integer> searchFollower(int userCode)throws SQLException;
	
	//내가 팔로잉한 살 글 전체보기
	List<Story> selectByFollowingCode(int followingCode)throws SQLException;

}
