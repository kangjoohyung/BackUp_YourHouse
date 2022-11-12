package mvc.service;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.reply.Reply;


public interface ReplyService {

	
	
	/**
	 * NoticeDAOImpl의 모든레코드 검색하는 메소드 호출
	 * */
    List<Reply> selectAll(int storyCode) throws SQLException;
    
    
    
	/**
	   * NoticeDAOImpl의 레코드 삽입하는 메소드 호출
	   * */
    Reply insert(Reply reply) throws SQLException;
	 
	  
	 
	   
	   /**
		* NoticeDAOImpl의 공지번호에 해당하는 레코드 삭제 메소드 호출
		* */
		void delete(int replyCode) throws SQLException;



  	Reply selectByReplyCode(int replyCode)throws SQLException;

	
	
}