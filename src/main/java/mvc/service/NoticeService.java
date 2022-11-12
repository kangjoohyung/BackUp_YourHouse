package mvc.service;

import java.sql.SQLException;
import java.util.List;


import mvc.dto.notice.Notice;

public interface NoticeService {
	
	
	/**
	 * NoticeDAOImpl의 모든레코드 검색하는 메소드 호출
	 * */
    List<Notice> selectAll() throws SQLException;
    
    
    /**
	 * paging처리
	 * */
    List<Notice> selectAll(int pageNo) throws SQLException;
	  
	
	
	/**
	   * NoticeDAOImpl의 레코드 삽입하는 메소드 호출
	   * */
	  void insert(Notice notice) throws SQLException;
	 
	  
	 	  
	  
	  /**
	   * NoticeDAOImpl의 공지번호에 해당하는 레코드 수정  메소드 호출
	   * */
	   void update(Notice notice) throws SQLException;

	   
	   
	   /**
		* NoticeDAOImpl의 공지번호에 해당하는 레코드 삭제 메소드 호출
		* */
		void delete(int noticeCode, String saveDir) throws SQLException;

	
		
		/**
		   * NoticeDAOImpl의 공지번호에 해당하는 레코드 검색하는 메소드 호출
		 * */
		Notice selectBynoticeCode(int noticeCode) throws SQLException;
	

}//클래스
