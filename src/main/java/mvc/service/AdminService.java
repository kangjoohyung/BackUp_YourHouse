 package mvc.service;

import java.sql.SQLException;

import mvc.dto.admin.AdminDTO;
import mvc.exception.AuthenticationException;



public interface AdminService {
	/**
	 * admin 로그인 체크
	 * */
   AdminDTO adminloginCheck(AdminDTO adminDTO)throws SQLException , AuthenticationException;
   
}


