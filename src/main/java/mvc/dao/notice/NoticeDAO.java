package mvc.dao.notice;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.notice.Notice;


public interface NoticeDAO {

	
	
	//등록
	int insert(Notice notice) throws SQLException;

	
	//수정
	/**
	    * 공지번호에 해당하는 레코드 수정
	    * @return : 1-수정성공 , 0 - 수정실패
	    * */
	int update(Notice notice) throws SQLException;
	
	
	//삭제 // 관리자만 지울 수 있게!!!!!!!!
	
	 /**
	   * 공지번호에 해당하는 레코드 삭제
	   * @return : 1-삭제성공 , 0 - 삭제실패
	   * */
	int delete(int noticeCode) throws SQLException;
	
	
	
	 /**
	   *공지번호에 해당하는 레코드 검색
	   * */
	Notice selectBynoticeCode(int noticeCode) throws SQLException;
	
	
	 /**
	   *베너 체크안하면 0 ->베너X
	   *베너 체크하면 1 -> 배너ㅇ
	   * */
	 List<Notice> selectByBanner() throws SQLException;

	 
	 

	List<Notice> selectAll() throws SQLException;

	 /**
	  * 레코드 전체 검색(페이지처리)
	  * */
  List<Notice> getBoardList(int pageNo) throws SQLException;


	  
	}






	
