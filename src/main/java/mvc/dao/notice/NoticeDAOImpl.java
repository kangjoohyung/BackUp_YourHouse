package mvc.dao.notice;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mvc.paging.PageCnt;
import mvc.dto.notice.Notice;
import mvc.util.DBUtil;

public class NoticeDAOImpl implements NoticeDAO {
	 private Properties proFile = new Properties();

	 /*public NoticeDAOImpl() {
	 
		 try {
				InputStream is = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
				proFile.load(is);
				
				System.out.println("query.select = " +proFile.getProperty("query.select"));
			}catch (Exception e) {
				e.printStackTrace();
			}
	 
	 }
	*/ 

	@Override
	public int insert(Notice notice) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//String sql= proFile.getProperty("notice.insert");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("insert into notice values(NOTICE_SEQ.NEXTVAL,?,?,?,?,sysdate+9/24,?)");
			ps.setString(1, notice.getNoticeCategory());
			ps.setString(2, notice.getIsPrivate());
			ps.setString(3, notice.getNoticeImage());
			ps.setString(4, notice.getSubject());
			ps.setString(5, notice.getNoticContent());
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
			
		}
		return result;
		
		
	}//insert

	@Override
	public int update(Notice notice) throws SQLException {
		
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//String sql= proFile.getProperty("notice.update");//update notice set SUBJECT=?,NOTICE_CONTENT=? where NOTICE_CODE=?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("set IS_PRIVATE=?, SUBJECT=?,NOTICE_CONTENT=? where NOTICE_CODE=?");

			ps.setString(1, notice.getSubject());
			ps.setString(2, notice.getNoticContent());
			ps.setInt(3, notice.getNoticeCode());
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
		
	}//update
	

	@Override
	public int delete(int noticeCode) throws SQLException {

		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//String sql= proFile.getProperty("notice.delete");//delete from notice where NOTICE_CODE = ?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("delete from notice where NOTICE_CODE = ?");

			ps.setInt(1,noticeCode);

			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;

	}//delete


	@Override
	public Notice selectBynoticeCode(int noticeCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Notice notice = null;
		
		//String sql= proFile.getProperty("notice.selectBynoticeCode");//select * from Electronics where model_num=?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from notice where NOTICE_CODE=?");
			ps.setInt(1, noticeCode);
			rs = ps.executeQuery();
			if(rs.next()) {
				notice = new Notice(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return notice;
	}


	@Override
	public  List<Notice> selectByBanner() throws SQLException {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Notice> list = new ArrayList<Notice>();
		
		//String sql= proFile.getProperty("Notice.selectByBanner");//select * from notice where is_private=1
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from notice where is_private=1");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Notice notice = 
				new Notice(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				
			   list.add(notice);
			}
			
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list ;
  }


	@Override
	public List<Notice> selectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Notice> list = new ArrayList<Notice>();
		
		
		//String sql= proFile.getProperty("Notice.selectAll");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from Notice  order by noticeReg desc");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Notice notice = 
				new Notice(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				
			   list.add(notice);
			}
			
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<Notice> getBoardList(int pageNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Notice> list = new ArrayList<Notice>();
		
		//String sql= proFile.getProperty("Notice.pagingSelect");//select * from  (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM Electronics ORDER BY writeday desc) a) where  rnum>=? and rnum <=? 
		try {
			
			
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			
			//전체레코드수를 구한다.
			int totalCount = this.getTotalCount(con);
			int totalPage = totalCount%PageCnt.pagesize==0 ? totalCount/PageCnt.pagesize : (totalCount/PageCnt.pagesize)+1;
			
			PageCnt pageCnt = new PageCnt();
			pageCnt.setPageCnt(totalPage);
			pageCnt.setPageNo(pageNo);
			
			ps = con.prepareStatement("select * from  (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM Notice ORDER BY writeday desc) a) where  rnum>=? and rnum <=? ");
			//? 2개에 set설정
			ps.setInt(1, (pageNo-1) * pageCnt.pagesize +1); //시작
			ps.setInt(2, pageNo * pageCnt.pagesize);//끝
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Notice notice = 
				new Notice(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				
			   list.add(notice);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	/**
	 * 전체레코드 수 검색하기
	 * */
	private int getTotalCount(Connection con) throws SQLException{
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result=0;
		//String sql= proFile.getProperty("Notice.totalCount");//select count(*) from Electronics
		try {
			ps = con.prepareStatement("select count(*) from Electronics");
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}finally {
			DBUtil.dbClose(null, ps, rs);
		}
		return result;
	}

		
		 
		


}//클래스끝
