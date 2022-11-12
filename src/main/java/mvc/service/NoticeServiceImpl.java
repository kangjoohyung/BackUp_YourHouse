package mvc.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import mvc.dao.notice.NoticeDAO;
import mvc.dao.notice.NoticeDAOImpl;
import mvc.dto.notice.Notice;

public class NoticeServiceImpl implements NoticeService {
	private NoticeDAO notDAO = new NoticeDAOImpl();

	
	
	@Override
	public List<Notice> selectAll() throws SQLException {
		List<Notice>  list = notDAO.selectAll();
		return list;
	}

	@Override
	public List<Notice> selectAll(int pageNo) throws SQLException {
		List<Notice>  list =notDAO.getBoardList(pageNo);//페이징처리하는 dao호출
				return null;
	}


	
	@Override
	public void insert(Notice notice) throws SQLException {
		int result = notDAO.insert(notice);
		if(result==0)throw new SQLException("등록되지 않았습니다.");


	}

	@Override
	public void update(Notice notice) throws SQLException {

		Notice noti = notDAO.selectBynoticeCode(notice.getNoticeCode());
				
				if(noti == null) {
					throw new SQLException("공지번호 오류로 수정할 수 없습니다.");
								}
				
				if(notDAO.update(notice) ==0) {
					throw new SQLException("수정되지않았습니다.^^");
				}

	}

	@Override
	public void delete(int noticeCode, String saveDir) throws SQLException {
		Notice noti = notDAO.selectBynoticeCode(noticeCode);
		
		if(noti==null) {
			throw new SQLException("공지번호 오류로 삭제할수 없습니다");
				}
			
		int result = notDAO.delete(noticeCode);
		if (result==0)throw new SQLException("삭제되지 않았습니다.");
		
		if(noti.getNoticeImage()!=null) {
			String fileName = saveDir +"/"+noti.getNoticeImage();
			new File(fileName).delete();
		}
	}

	@Override
	public Notice selectBynoticeCode(int noticeCode) throws SQLException {
		
		Notice notice = notDAO.selectBynoticeCode(noticeCode);
		
		if(notice == null)
			throw new SQLException("상세보기에 오류가 발생했습니다.");
		
		return notice;
	}



}
