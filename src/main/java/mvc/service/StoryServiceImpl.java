package mvc.service;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.dao.follow.FollowDAO;
import mvc.dao.follow.FollowDAOImpl;
import mvc.dao.liked.LikedDAO;
import mvc.dao.liked.LikedDAOImpl;
import mvc.dao.reply.ReplyDAO;
import mvc.dao.reply.ReplyDAOImpl;
import mvc.dao.story.StoryDAO;
import mvc.dao.story.StoryDAOImpl;
import mvc.dao.user.UserDAO;
import mvc.dao.user.UserDAOImpl;
import mvc.dto.follow.Follow;
import mvc.dto.liked.Liked;
import mvc.dto.reply.Reply;
import mvc.dto.story.Story;
import mvc.dto.user.UserDTO;

public class StoryServiceImpl implements StoryService {


	private LikedDAO likedDAO = new LikedDAOImpl();
	private FollowDAO followDAO = new FollowDAOImpl();
	private UserDAO userDAO = new UserDAOImpl();
	private ReplyDAO replyDAO = new ReplyDAOImpl();
	private StoryDAO storyDAO = new StoryDAOImpl();


	@Override
	public List<Story> list(String keyword) {
		return storyDAO.list(keyword);
	}

	@Override
	public List<Story> selectAll(int user_code) throws SQLException {
		List<Story>  list = storyDAO.selectAll();

		for(Story story : list) {
			//팔로우 정보
			Follow fo = followDAO.isFollow(user_code, story.getUserCode());
			if(fo!=null) {
				story.setFollow(true);
			}

			//좋아요 정보
			Liked Li = likedDAO.isLiked(user_code, story.getStoryCode());
			if(Li!=null) {
				story.setLike(true);
			}
			
			UserDTO user = userDAO.searchByUserCode(story.getUserCode());
			story.setUser(user);
		}
		return list;
	}


	@Override
	public void insert(Story story) throws SQLException {
		int result = storyDAO.insert(story);
		if(result==0)throw new SQLException("등록되지 않았습니다.");


	}


	@Override
	public void delete(int storyCode, String saveDir) throws SQLException {
		Story story = storyDAO.selectByStoryCode(storyCode);

		if(story==null) {
			throw new SQLException("게시물번호 오류로 삭제할수 없습니다");
		}

		int result = storyDAO.delete(storyCode);
		if (result==0)throw new SQLException("삭제되지 않았습니다.");

		if(story.getStoryImage()!=null) {
			String fileName = saveDir +"/"+story.getStoryImage();
			new File(fileName).delete();
		}

	}

	@Override
	public void update(Story story) throws SQLException {
		//전달된 비번과 DB에저장된 비번이 일치하는지 먼저 체크한다.
		Story dbStory = storyDAO.selectByStoryCode(story.getStoryCode());

		if(dbStory == null) 
			throw new SQLException("게시물번호 오류로 수정할수 없습니다.");
		/* 비밀번호 일치하는지
		 * }else if(!dbStory.getPassword().equals(electronics.getPassword())) {
					throw new SQLException("비밀번호를 다시 확인해주세요.-수정실패");
				}
		 */

		if(storyDAO.update(story) ==0) 
			throw new SQLException("수정되지않았습니다.^^");

	}
	
	 @Override 
	 public Story selectByStoryCode(int storyCode) throws SQLException{	 
	 Story story = storyDAO.selectByStoryCode(storyCode); 
	 if(story == null) throw
	  new SQLException("상세보기에 오류가 발생했습니다."); 
	 List<Reply> replylist =
	  replyDAO.selectAll(storyCode); story.setReplyList(replylist);
	  
	  
	  
	  return story; 
	  }

	@Override
	public List<Story> selectByFollowingCode(int user_code) throws SQLException {
		List<Story>  list = storyDAO.selectByFollowingCode(user_code);
		for(Story story : list) {
			//팔로우 정보
			Follow fo = followDAO.isFollow(user_code, story.getUserCode());
			if(fo!=null) {
				story.setFollow(true);
			}

			
			UserDTO user = userDAO.searchByUserCode(story.getUserCode());
			story.setUser(user);
		}
		return list;
	}

	@Override
	public List<Story> selectByUserCode(int userCode) throws SQLException {
		List<Story>  list = storyDAO.selectAll(userCode);

		for(Story story : list) {
			//팔로우 정보
			Follow fo = followDAO.isFollow(userCode, story.getUserCode());
			if(fo!=null) {
				story.setFollow(true);
			}

			//좋아요 정보
			Liked Li = likedDAO.isLiked(userCode, story.getStoryCode());
			if(Li!=null) {
				story.setLike(true);
			}
			
			UserDTO user = userDAO.searchByUserCode(story.getUserCode());
			story.setUser(user);
		}
		return list;
	}


	
	/*
	 * @Override public List<Story> selectAll(int pageNo) throws SQLException {
	 * List<Story> list = storyDAO.getBoardList(pageNo);//페이징처리하는 dao호출
	 * 
	 * 
	 * return null; }
	 */


}
