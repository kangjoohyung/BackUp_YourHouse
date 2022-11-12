package mvc.dao.reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mvc.dto.reply.Reply;
import mvc.dto.story.Story;
import mvc.util.DBUtil;

public class ReplyDAOImpl implements ReplyDAO {
	private Properties proFile = new Properties();

	@Override
	public List<Reply> selectAll(int storyCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Reply> list = new ArrayList<Reply>();


		String sql= proFile.getProperty("Reply.selectAll");//select * from Electronics  order by writeday desc
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from reply where story_code=? order by created_Reg desc");
			ps.setInt(1, storyCode);
			rs = ps.executeQuery();
			while(rs.next()) {
				Reply reply = 
						new Reply(rs.getInt(1), rs.getInt(2), rs.getInt(3),
								rs.getString(4), rs.getString(5));

				list.add(reply);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int insert(Reply reply) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//String sql= proFile.getProperty("reply.insert");//insert into Electronics values(?,?,?,?,?,sysdate,0,?,?)
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("insert into reply values(reply_SEQ.NEXTVAL, ?,?,?,sysdate+9/24)");
			ps.setInt(1, reply.getStoryCode());
			ps.setInt(2, reply.getUserCode());
			ps.setString(3, reply.getReplyContent());


			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}


	@Override
	public int delete(int replyCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;

		int result=0;
		//String sql= proFile.getProperty("reply.delete");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("delete from reply where reply_code = ?");

			ps.setInt(1, replyCode);
			//ps.setString(2, password) 비밀번호입력 시 삭제... 하고싶은데..

			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public Reply selectByReplyCode(int replyCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Reply reply = null;

		//String sql= proFile.getProperty("Reply.selectByReplyCode");//select * from Electronics where model_num=?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from reply where reply _CODE=?");
			ps.setInt(1, replyCode);

			rs = ps.executeQuery();
			if(rs.next()) {
				reply = new Reply(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getString(4), rs.getString(5));
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return reply;

	}

	@Override
	public Reply serchReplyCode(int userCode, int storyCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Reply reply = null;

		//String sql= proFile.getProperty("Reply.selectByReplyCode");//select * from Electronics where model_num=?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from reply where story_code=? and user_code=? order by created_reg desc");
			ps.setInt(1, storyCode);
			ps.setInt(2, userCode);

			rs = ps.executeQuery();
			if(rs.next()) {
				reply = new Reply(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getString(4), rs.getString(5));
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return reply;

	}
}
