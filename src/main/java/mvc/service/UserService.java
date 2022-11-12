 package mvc.service;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.story.Story;
import mvc.dto.user.UserDTO;
import mvc.exception.AuthenticationException;



public interface UserService {

   UserDTO loginCheck(UserDTO userDTO)throws SQLException , AuthenticationException;
   
   UserDTO select(String email) throws SQLException;
   
   UserDTO selectByUserCode(int userCode) throws SQLException;
   
   void insert(UserDTO userDTO)throws SQLException;
   
   void update(UserDTO userDTO)throws SQLException;
   
   List<Story> myPage(int user_code) throws SQLException;
}


