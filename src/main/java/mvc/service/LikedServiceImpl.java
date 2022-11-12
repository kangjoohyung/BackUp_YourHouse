package mvc.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import mvc.dao.liked.LikedDAO;
import mvc.dao.liked.LikedDAOImpl;
import mvc.dao.story.StoryDAO;
import mvc.dao.story.StoryDAOImpl;
import mvc.dto.liked.Liked;
import mvc.dto.notice.Notice;
import mvc.dto.story.Story;

public class LikedServiceImpl implements LikedService {

	private LikedDAO likedDAO = new LikedDAOImpl();

	@Override
	public boolean isLiked(int userCode, int storyCode) throws SQLException {
		//실패- delete 성공- insert
		boolean result= false;
		Liked liked = likedDAO.isLiked(userCode, storyCode);
		if(liked==null) {
			likedDAO.delete(liked.getLikeCode());

		}else {
			likedDAO.insert(userCode,storyCode);
			result=true;
		}
		return result;
	}

	@Override
	public List<Story> selectByUserCode(int userCode) throws SQLException {
		List<Story> story = likedDAO.selectByUserCode(userCode);

		if(story == null || story.size()==0)
			throw new SQLException("해당 유저검색 실패");

		return story;
	}


}
