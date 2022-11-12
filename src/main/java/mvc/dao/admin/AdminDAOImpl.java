package mvc.dao.admin;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import mvc.dto.admin.AdminDTO;
import mvc.util.DBUtil;


public class AdminDAOImpl implements AdminDAO {
private Properties proFile = new Properties();
	
	public AdminDAOImpl() {
		try {
			//dbQuery를 준비한 ~.properties파일을 로딩해서 Properties 자료구조에 저장한다.
			
			//현재 프로젝트가 런타임(실행)될때, 즉 서버가 실행될때 classes폴더의 위치를
			//동적으로 가져와서 경로를 설정해야한다.
			InputStream is = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
			proFile.load(is);
			
			System.out.println("query.adminlogin = " +proFile.getProperty("query.adminlogin"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public AdminDTO adminloginCheck(AdminDTO adminDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		AdminDTO dbDTO =null;
		
		String sql= proFile.getProperty("query.adminlogin");//select * from administrator where admin_id=? and admin_pwd=?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, adminDTO.getEmail());
			ps.setString(2, adminDTO.getPassword());
			
			rs = ps.executeQuery();
			if(rs.next()) {
				dbDTO = new AdminDTO(rs.getString(1), rs.getString(2));
			}
			
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return dbDTO;
	}
	
}
