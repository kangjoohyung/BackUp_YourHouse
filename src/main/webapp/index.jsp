<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>
<title>니가 사는그집 로그인</title>
<style type="text/css">

 a{
 text-decoration: none;
 font-size:19px;
 font-weight: 600;
 font-family: Lorem Ipsum Dolor;
 text-align:left;
 margin-top:7px;
}
</style>
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<script type="text/javascript">
	$(function() {
		
    	let state=false;  
    	 
        document.
        loginForm.
        addEventListener("submit", function(e) {
           if($("#mail").val() == "")
        	               state=true;
           if($("#pwd").val() == "")
         	               state=true;
          
            if(state){
        	   
            	alert("이메일,비밀번호 입력되었는지 확인 해주새요");
        	    e.preventDefault();
        		 
             }else{
    
            	let sessType  = $('input:radio[name="sess"]:checked').val();	 
        	    let keyV="";
        	    let methodNameV=""; 
        	    		
        	    if(sessType=="0"){ 
        		      keyV="admin";
        		      methodNameV="adminLogin";  
        		      
        	    }else{  
        		    keyV="user";
         		    methodNameV="login"; 
         		  		  
        	    }
        	   
        	    $('input[name="key"]').val(keyV);
                $('input[name="methodName"]').val(methodNameV);

                e.target.submit();
          }
             
        	
       }, true)
    
     })
  
</script>
</head>
<body>
 <div class="text-center"style="margin-left:auto; margin-right:auto; margin-top:120px;">
   <div>
   <form style="max-width:480px; margin:auto;"name="loginForm" action="front" method="get">
     <img class="mt-5 mb-4" src="images/icons/NIZIP_logo.svg">
        <input type="email" id="mail" name="email" class="form-control mt-3" placeholder="이메일입력" required autofocus style="height:65px" > 
        <input type="password" id="pwd"  name="password" placeholder="비밀번호 입력"  class="form-control" required autofocus style="height:65px">    
       <div style="display:flex; margin-top:20px;">
          <div class="form-check" style="margin-left:120px">
            <input  type="radio" name="sess" id="admin_sess" value="0">
              <label class="form-check-label" for="flexRadioDefault1">
               관리자
              </label>
         </div>
         <div class="form-check" style="margin-left:40px">
           <input  type="radio" name="sess" id="user_sess" checked  value="1">
               <label class="form-check-label" for="flexRadioDefault2">
                 사용자
               </label>
         </div>
       </div>
       <div class="d-grid gap-2" style="margin-top: 10px ">
           <button class="btn btn-primary btn-lg mt-3" style="height:70px" type="submit" id="login" >로그인</button>  
        </div>
   <input type="hidden" name="key" value="">
   <input type="hidden" name="methodName" value="">
  
  </form>
    <section style="margin-top: 60px;">
     <a href="register/updatePass.jsp" style="margin-left:-20px">비밀번호 재설정</a><a href="register/reg.html" style="margin-left:40px">회원가입</a>  
    </section> 
  </div>
 
 </div> 
</body>
</html>