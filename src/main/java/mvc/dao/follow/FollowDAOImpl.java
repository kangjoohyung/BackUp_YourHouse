package mvc.dao.follow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.dto.follow.Follow;
import mvc.dto.liked.Liked;
import mvc.dto.story.Story;
import mvc.dto.user.UserDTO;
import mvc.util.DBUtil;

public class FollowDAOImpl implements FollowDAO {

	@Override
	public int insert(int followingCode, int followerCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//String sql= proFile.getProperty("follow.insert");//insert into liked values(?,?,?)
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("insert into follow values(FOLLOW_SEQ.NEXTVAL, ?,?)");
			ps.setInt(1, followingCode);
			ps.setInt(2, followerCode);
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int delete(int FollowCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//String sql= proFile.getProperty("follow.delete");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("delete from FOLLOW where FOLLOW_CODE = ?");

			ps.setInt(1, FollowCode);
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}


	@Override
	public Follow isFollow(int userCode, int followerCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Follow follow = null;
		
		//String sql= proFile.getProperty("query.selectBymodelNum");//select * from Electronics where model_num=?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from FOLLOW where FOLLOWER_CODE = ?  and user_CODE =?");
			ps.setInt(1, userCode);
			ps.setInt(2, followerCode);

			rs = ps.executeQuery();
			if(rs.next()) {
				follow = new Follow(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return follow;
	}

	//내가 파로잉한 사람목록 전체보기
	@Override
	public List<Story> selectByUserCode(int userCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Story> list = new ArrayList<Story>();
		
		//String sql= proFile.getProperty("Follow.selectByUserCode");//select * from Electronics where model_num=?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select story_code, user_code, story_image, story_liter, created_reg, follow_code, follower_code from story a full join follow b using(user_code) where follower_code = ?");
			ps.setInt(1, userCode);
			rs = ps.executeQuery();
			
			while(rs.next()) {
			   list.add(new Story(
					   rs.getInt(1),
					   rs.getInt(2),
					   rs.getString(3), 
					   rs.getString(4), 
					   rs.getString(5)
				));
			}
			
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list ;
	}

	@Override
	public List<Story> selectByFollowingCode(int followingCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Story> list = new ArrayList<Story>();
		
		//String sql= proFile.getProperty("Follow.selectByFollowingCode");//select * from Electronics where model_num=?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from Story where user_CODE=?");
			ps.setInt(1, followingCode);
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

	@Override
	public List<Integer> searchFollower(int userCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Integer> list = new ArrayList<Integer>();
		
		//String sql= proFile.getProperty("Follow.selectByUserCode");//select * from Electronics where model_num=?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select FOLLOWER_CODE from FOLLOW where FOLLOWER_CODE=?");
			ps.setInt(1, userCode);
			rs = ps.executeQuery();
			
			while(rs.next()) {
		
				
			   list.add(rs.getInt(1));
			}
			
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list ;
	}


}
