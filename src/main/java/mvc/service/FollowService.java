package mvc.service;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.story.Story;
import mvc.dto.user.UserDTO;

public interface FollowService {


	
	boolean isFollow(int userCode, int followCode)throws SQLException;

	List<UserDTO> selectByUserCode(int userCode)throws SQLException;
	
	List<UserDTO> searchFollower(int userCode)throws SQLException;
	
	List<Story> following(int userCode)throws SQLException;
}
