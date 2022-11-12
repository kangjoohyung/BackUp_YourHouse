package mvc.util;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

  public class Mymail  {
 	 
	  Properties p = System.getProperties();
	  Authenticator auth=new AdminAuthentication();
      Session session = Session.getDefaultInstance(p, auth);
      static  Mymail  adminMail= new Mymail(); 
      
      
	  private Mymail(){
		  
		   p.put("mail.smtp.starttls.enable","true");     // gmail�� true ����
	       p.put("mail.smtp.host","smtp.naver.com");      // smtp ���� �ּ�
	       p.put("mail.smtp.auth","true");                 // gmail�� true ����
	       p.put("mail.smtp.port","465");                 // ���̹� ��Ʈ
	       p.put("mail.smtp.ssl.protocols", "TLSv1.2"); //�ڵ� �߰� ����
	       p.put("mail.smtp.ssl.enable", "true"); 
	      
	   
	   }
	  
	 public static Mymail getInstance() {
		 
		 return adminMail;
	 }
	  
	 class AdminAuthentication extends Authenticator{    
		    PasswordAuthentication pa;	
		   //관리자 정보를 가진 인증		    
		    AdminAuthentication(){   
	      	 pa= new PasswordAuthentication("test_haewon1994@naver.com","!naver29+");
		    } //생성자
		 
		    public PasswordAuthentication getPasswordAuthentication() {
		        return pa;
		    
		    }
		    
		 
		 }   
	  

	  
	  
	  public String makeAuthCode(){
	   
		Random random = new Random();		//랜덤 함수 선언
		int createNum = 0;  			//1자리 난수
		String ranNum = ""; 			//1자리 난수 형변환 변수
        	int letter    = 6;			//난수 자릿수:6
		String resultNum = "";  		//결과 난수		
		for (int i=0; i<letter; i++) { 
            		
			createNum = random.nextInt(9);		//0부터 9까지 올 수 있는 1자리 난수 생성
			ranNum =  Integer.toString(createNum);  //1자리 난수를 String으로 형변환
			resultNum += ranNum;			//생성된 난수(문자열)을 원하는 수(letter)만큼 더하며 나열
		}	
        	
         return  resultNum;
	}
	  
	 
	 public  void sendMessage(String message, String email) throws Exception{
		
		   InternetAddress from = new InternetAddress("test<test_haewon1994@naver.com>");
		   InternetAddress to = new InternetAddress(email); 	
		   MimeMessage msg =new MimeMessage(session);
		   msg.setSentDate(new Date());
		   msg.setFrom(from);
		   msg.setRecipient(Message.RecipientType.TO, to);
		   msg.setSubject("니가 사는 그집에서 보낸 메일입니다", "UTF-8");
		   msg.setText(message, "UTF-8");
		   msg.setHeader("content-Type", "text/html");
		   javax.mail.Transport.send(msg, msg.getAllRecipients());
			 
	 }
    
     
	
  
          
	 public void sendAuthCode(String authCode, String email) throws Exception{
			
		   InternetAddress from = new InternetAddress("test<test_haewon1994@naver.com>");
		   InternetAddress to = new InternetAddress(email); 	
		   MimeMessage msg =new MimeMessage(session);
		   msg.setSentDate(new Date());
		   msg.setFrom(from);
		   msg.setRecipient(Message.RecipientType.TO, to);
		   msg.setSubject("니가 사는 그집에서 회원 가입 인증 메일입니다", "UTF-8");
		  
		   StringBuilder sb = new StringBuilder();
		   sb.append("인증코드는 :");
		   sb.append(authCode);
		   sb.append(" 입니다");
		   
		   msg.setText(sb.toString(), "UTF-8");
		   msg.setHeader("content-Type", "text/html");
		   javax.mail.Transport.send(msg, msg.getAllRecipients());
			 
	 }
       
    
   
 
	 
	 
  
   
     
  
	 
	  
 











}
