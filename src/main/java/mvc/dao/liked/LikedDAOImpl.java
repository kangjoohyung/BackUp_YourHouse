package mvc.dao.liked;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mvc.dto.follow.Follow;
import mvc.dto.liked.Liked;
import mvc.dto.notice.Notice;
import mvc.dto.story.Story;
import mvc.util.DBUtil;

public class LikedDAOImpl implements LikedDAO {
	private Properties proFile = new Properties();


	@Override
	public int insert(int userCode, int storyCode) throws SQLException {
		
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//String sql= proFile.getProperty("liked.insert");//insert into liked values(?,?,?)
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("insert into liked values(NOTICE_SEQ.NEXTVAL, ?,?)");
			ps.setInt(1, userCode);
			ps.setInt(2, storyCode);
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;

	}
	@Override
	public int delete(int likeCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//String sql= proFile.getProperty("liked.delete");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("delete from liked where LIKED_CODE = ?");

			ps.setInt(1, likeCode);
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public Liked isLiked(int userCode, int storyCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Liked liked = null;
		
		//String sql= proFile.getProperty("liked.isLiked");//select * from Electronics where model_num=?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(" select * from liked where USER_CODE=?  and STORY_CODE=?");
			ps.setInt(1, userCode);
			ps.setInt(2, storyCode);

			rs = ps.executeQuery();
			if(rs.next()) {
				liked = new Liked(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return liked;

		
	}
	@Override
	public List<Story> selectByUserCode(int userCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Story> list = new ArrayList<Story>();
		
		//String sql= proFile.getProperty("liked.selectByUserCode");//select * from Electronics where model_num=?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from user_s where user_code = ?");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Story story = 
				new Story(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5));
				
			   list.add(story);
			}
			
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list ;
	}
		
}
