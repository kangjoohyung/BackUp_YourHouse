package mvc.service;

import java.sql.SQLException;
import java.util.List;


import mvc.dto.story.Story;

public interface StoryService {



	/**
	 * StoryDAOImpl의 모든레코드 검색하는 메소드 호출
	 * */
	List<Story> selectAll(int user_code) throws SQLException;

	/**
	 * paging처리
	 * */
	//List<Story> selectAll(int pageNo) throws SQLException;

	/**
	 * StoryDAOImpl의 레코드 삽입하는 메소드 호출
	 * */
	void insert(Story story) throws SQLException;


	/**
	 * StoryDAOImpl의 모델번호에 해당하는 레코드 삭제 메소드 호출
	 * */
	void delete(int storyCode, String saveDir) throws SQLException;


	/**
	 * StoryDAOImpl의 모델번호에 해당하는 레코드 수정  메소드 호출
	 * */
	void update(Story story) throws SQLException;
	
	
	//
	List<Story> list(String keyword);
	
	
	/**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 검색하는 메소드 호출
	   * @param : boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가 안함)
	   * */
	
	  Story selectByStoryCode(int storyCode) throws SQLException;
	  
	  
	  List<Story> selectByFollowingCode(int user_code) throws SQLException;
	
	
	  List<Story> selectByUserCode(int userCode) throws SQLException;
}


