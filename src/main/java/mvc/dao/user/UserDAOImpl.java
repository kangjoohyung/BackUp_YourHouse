package mvc.dao.user;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mvc.dto.story.Story;
import mvc.dto.user.UserDTO;
import mvc.util.DBUtil;


public class UserDAOImpl implements UserDAO {
private Properties proFile = new Properties();
	
	public UserDAOImpl() {
		try {
			//dbQuery를 준비한 ~.properties파일을 로딩해서 Properties 자료구조에 저장한다.
			
			//현재 프로젝트가 런타임(실행)될때, 즉 서버가 실행될때 classes폴더의 위치를
			//동적으로 가져와서 경로를 설정해야한다.
			InputStream is = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
			proFile.load(is);
			
			System.out.println("query.userlogin = " +proFile.getProperty("query.userlogin"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		UserDTO dbDTO =null;
		
		String sql= proFile.getProperty("query.userlogin");//select * from user_s where email=? and password=?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userDTO.getEmail());
			ps.setString(2, userDTO.getPassword());
			
			rs = ps.executeQuery();
			if(rs.next()) {
				dbDTO = new UserDTO(rs.getString(1), rs.getString(2));
			}
			
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return dbDTO;
	}

	public int insert(UserDTO user) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql=
			"INSERT INTO USER_S(USER_CODE,EMAIL,PASSWORD,BIRTH,NICKNAME,PHONE,ADRESS, GENDER, REG_DATE, CATEGORY_CODE) VALUES(USER_S_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate+9/24, ?)";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getBirth());
			ps.setString(4, user.getNickname());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getAdress());
			ps.setString(7, user.getGender());
			ps.setInt(8, user.getCategoryCode());

			
			result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	public int update(UserDTO user) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql=
			"update USER_S set password=?, nickname=?, adress=?, category_code=? where user_code=?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getNickname());
			ps.setString(3, user.getAdress());
			ps.setInt(4, user.getCategoryCode());
			ps.setInt(5, user.getUserCode());

			result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public boolean duplicateCheckByEmail(String email)throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean result=false;
		String sql="SELECT email FROM USER_S WHERE email=?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return result;
	}
	
	@Override
	public boolean duplicateCheckByNickname(String nickname)throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean result=false;
		String sql="SELECT nickname FROM USER_S WHERE nickname=?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, nickname);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return result;
	}
	
	/**
	 * 유저 정보 조회
	 * */
	@Override
	public List<UserDTO> searchUser() throws SQLException {
		 Connection con = null;
		  PreparedStatement ps = null;
		  ResultSet rs = null;
		  List<UserDTO> list = new ArrayList<UserDTO>();
		  try {
		   con = DBUtil.getConnection();
		   ps = con.prepareStatement("select * from USER_S order by nickname");
		   rs  = ps.executeQuery();
		   while(rs.next()){
		    list.add(new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), 
		      rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)
		      , rs.getString(8), rs.getString(9), rs.getInt(10)));
		   }

		  } catch (SQLException e) {
		   e.printStackTrace();
		  } finally {
		   DBUtil.dbClose(con, ps, rs);
		  }
		  return list;
	}

	@Override
	public UserDTO selectByUserCode(String email) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		UserDTO user=null;
		String sql = "select * from user_s where email=?";
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new UserDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getInt(10)
					);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return user;
	}

	@Override
	public UserDTO searchByUserCode(int userCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		UserDTO user=null;
		String sql = "select * from user_s where user_code=?";
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userCode);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new UserDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getInt(10)
					);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return user;
	}

	@Override
	public List<Story> myPage(int userCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Story> list = new ArrayList<Story>();

		//String sql= proFile.getProperty("Story.selectAll");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from Story where user_code=${user}");
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
		return list;
	}
	}
	

