package mvc.service;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.liked.Liked;
import mvc.dto.story.Story;


public interface LikedService {


	
	boolean isLiked(int userCode, int storyCode)throws SQLException;

	List<Story> selectByUserCode(int userCode)throws SQLException;

}
