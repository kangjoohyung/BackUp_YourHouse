<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
 <script type="text/javascript" src="../js/jquery-3.6.1.min.js"></script>

<style type="text/css">
 h5{

   text-align: center; 
  
  
 
 
 
 
 } 
</style>


</head>
<body>
 
 <jsp:include page="../common/header.jsp"/>
 
 
 <div class="container" style="width:500px; height:500px; margin-top:100px; margin-left: auto; margin-right:auto ">  
    <div>
    <h5>가입한 이메일 주소를 입력해 주세요</h5>
    </div>
    <form  class="form-floating mt-3">
      <input type="email" class="form-control is-invalid" id="floatingInputInvalid" placeholder="name@example.com">
       <div class="d-grid gap-2" style="margin-top:14px" >
        <button type="button" class="btn btn-info btn-lg" style="height:55px">이메일로 인증코드 받기</button>   
          <input type="hidden" name="key"  value="" >    
          <input type="hidden" name="methodName" value="">
      </div>
    </form>
 </div>







</body>
</html>