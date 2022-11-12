package mvc.service;

import java.sql.SQLException;
import java.util.List;

import mvc.dao.user.UserDAO;
import mvc.dao.user.UserDAOImpl;
import mvc.dto.story.Story;
import mvc.dto.user.UserDTO;
import mvc.exception.AuthenticationException;

public class UserServiceImpl implements UserService {
     private UserDAO userDAO = new UserDAOImpl();
  	
	@Override
	public UserDTO loginCheck(UserDTO user) throws SQLException, AuthenticationException {
		
		//dao호출
		UserDTO dbDTO = userDAO.loginCheck(user);
		if(dbDTO == null) {
			throw new AuthenticationException("정보를 다시 확인해주세요.");
		}
		
		return dbDTO;
	}

	@Override
	public void insert(UserDTO userDTO) throws SQLException {
		int result = userDAO.insert(userDTO);
		if(result==0)throw new SQLException("회원가입 실패");
		
	}
	
	@Override
	public void update(UserDTO userDTO) throws SQLException {
		int result = userDAO.update(userDTO);
		if(result==0)throw new SQLException("회원정보 수정 실패");
		
	}

	@Override
	public UserDTO select(String email) throws SQLException {
		UserDTO user = userDAO.selectByUserCode(email);
		return user;
	}

	@Override
	public UserDTO selectByUserCode(int userCode) throws SQLException {
		UserDTO user = userDAO.searchByUserCode(userCode);
		return user;
	}

	@Override
	public List<Story> myPage(int user_code) throws SQLException {
		
		return null;
	}


	
	
}





