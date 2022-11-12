package mvc.dao.reply;



import java.sql.SQLException;
import java.util.List;



import mvc.dto.reply.Reply;


public interface ReplyDAO {

	/**
	 * 레코드 전체 검색
	 * */
	List<Reply> selectAll(int storyCode) throws SQLException;

	/**
	 * 레코드 전체 검색(페이지처리)
	 * */
	// List<List> getBoardList(int storyCode) throws SQLException;



	//등록
	int insert(Reply reply) throws SQLException;




	//삭제 // 관리자만 지울 수 있게!!!!!!!!

	/**
	 * 공지번호에 해당하는 레코드 삭제
	 * @return : 1-삭제성공 , 0 - 삭제실패
	 * */
	int delete(int replyCode) throws SQLException;

	
	
	
	Reply selectByReplyCode(int replyCode)throws SQLException;



	Reply serchReplyCode(int userCode, int storyCode)throws SQLException;


}



