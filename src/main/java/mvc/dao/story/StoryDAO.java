package mvc.dao.story;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.notice.Notice;
import mvc.dto.story.Story;


public interface StoryDAO {
	
	/**
	   * 조회수를 증가하는 기능
	   * update Electronics set readnum = readnum + 1 where model_num=?
	   * */
	/* int increamentByReadnum(int storyCode) throws SQLException; */
	
	/**
	  * 레코드 전체 검색
	  * */
	  List<Story> selectAll() throws SQLException;
	  
	  /**
	   * 회원기준 게시글 조회
	   */
	  List<Story> selectAll(int userCode) throws SQLException;
	  
	  /**
		  * 레코드 전체 검색(페이지처리)
		  * */
	  List<Story> getBoardList(int pageNo) throws SQLException;
	 
	
	//등록
	int insert(Story story) throws SQLException;

	
	//수정
	/**
	    * 게시물번호에 해당하는 레코드 수정
	    * @return : 1-수정성공 , 0 - 수정실패
	    * */
	int update(Story story) throws SQLException;
	
	
	//삭제 // 관리자만 지울 수 있게!!!!!!!!
	
	 /**
	   * 게시물번호에 해당하는 레코드 삭제
	   * @return : 1-삭제성공 , 0 - 삭제실패
	   * */
	int delete(int storyCode) throws SQLException;
	
	
	
	 /**
	   *게시물번호에 해당하는 레코드 검색
	   * */
	Story selectByStoryCode(int storyCode) throws SQLException;
	
	/**
	 * 조건검색
	 * (검색필드와 검색단어를 전달받아 검색필드에 검색단어를 포함한 레코드 검색)
	 * 
	 *  SELECT * FROM MEMBER WHERE ID LIKE ? 
	 *  SELECT * FROM MEMBER WHERE name LIKE ? 
	 *  SELECT * FROM MEMBER WHERE addr LIKE ? 
	 * 
	 * */
	List<Story> list(String keyword);


	List<Story> selectByFollowingCode(int followCode) throws SQLException;
	
	  
	}






	
