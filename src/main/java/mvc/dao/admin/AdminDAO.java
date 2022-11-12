package mvc.dao.admin;

import java.sql.SQLException;

import mvc.dto.admin.AdminDTO;




public interface AdminDAO {
	
	/**
	 * admin 로그인 기능
	 * select * from administrator where admin_id=? and admin_pwd=?
	 **/
	AdminDTO adminloginCheck(AdminDTO adminDTO)throws SQLException;
	
}









