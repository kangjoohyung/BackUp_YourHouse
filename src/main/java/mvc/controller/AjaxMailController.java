package mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.util.Mymail;



public class AjaxMailController implements AjaxController {

       Mymail adminMail = Mymail.getInstance();
	 
	
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
   
	
	
   public void sendMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   
	               
	   String email =request.getParameter("email");
       String message ="ssssss";
       adminMail.sendMessage(message, email);
 

 }


   public void  sendAuthCode(   HttpServletRequest request, HttpServletResponse response ) throws Exception {
	 
	    
	   
	     PrintWriter out       =response.getWriter();
         String email      =request.getParameter("email");
	     String authCode   =adminMail.makeAuthCode();     
	     adminMail.sendAuthCode(authCode, email);
	     out.print(authCode);
	     
	     
	     
	         
	         
   
   
   }
   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   // mymail.sendMessage(email,"안녕");
	  
	  
	  
  









}
