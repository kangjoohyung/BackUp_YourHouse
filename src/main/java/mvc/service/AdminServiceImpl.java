package mvc.service;

import java.sql.SQLException;

import mvc.dao.admin.AdminDAO;
import mvc.dao.admin.AdminDAOImpl;
import mvc.dto.admin.AdminDTO;
import mvc.exception.AuthenticationException;

public class AdminServiceImpl implements AdminService {
     private AdminDAO adminDAO = new AdminDAOImpl();
  	
	@Override
	public AdminDTO adminloginCheck(AdminDTO admin) throws SQLException, AuthenticationException {
		
		//dao호출
		AdminDTO dbDTO = adminDAO.adminloginCheck(admin);
		if(dbDTO == null) {
			throw new AuthenticationException("정보를 다시 확인해주세요.");
		}
		
		return dbDTO;
	}
}





