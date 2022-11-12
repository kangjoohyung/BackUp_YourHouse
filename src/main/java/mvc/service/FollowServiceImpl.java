package mvc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.dao.follow.FollowDAO;
import mvc.dao.follow.FollowDAOImpl;
import mvc.dao.liked.LikedDAO;
import mvc.dao.liked.LikedDAOImpl;
import mvc.dao.user.UserDAO;
import mvc.dao.user.UserDAOImpl;
import mvc.dto.follow.Follow;
import mvc.dto.liked.Liked;
import mvc.dto.story.Story;
import mvc.dto.user.UserDTO;

public class FollowServiceImpl implements FollowService {

	private FollowDAO followDAO = new FollowDAOImpl();
	private UserDAO userDAO = new UserDAOImpl();


	@Override
	public boolean isFollow(int userCode, int followerCode) throws SQLException {
		//실패- delete 성공- insert
		boolean result= false;
		Follow follow = followDAO.isFollow(userCode, followerCode);
		if(follow!=null) {
			followDAO.delete(follow.getFollowCode());

		}else {
			followDAO.insert(userCode,followerCode);
			result=true;
		}
		return result;
	}

	@Override
	public List<UserDTO> selectByUserCode(int userCode) throws SQLException {
		List<Story> userCodeList = followDAO.selectByUserCode(userCode);

		List<UserDTO> followList = new ArrayList<UserDTO>();

		for(Story i : userCodeList) {
			UserDTO user = userDAO.searchByUserCode(i.getUserCode());
			followList.add(user);
		}
		return followList;
	}


	@Override
	public List<UserDTO> searchFollower(int userCode) throws SQLException {
		List<Story> userCodeList = followDAO.selectByUserCode(userCode);

		List<UserDTO> followerList = new ArrayList<UserDTO>();

		for(Story i : userCodeList) {
			UserDTO user = userDAO.searchByUserCode(i.getUserCode());
			followerList.add(user);
		}
		return followerList;
	}

	@Override
	public List<Story> following(int userCode) throws SQLException {
		List<Story> list = followDAO.selectByUserCode(userCode);
		
		for(Story story : list) {
			UserDTO user = userDAO.searchByUserCode(story.getUserCode());
			story.setUser(user);
		}

		return list;
	}

}
