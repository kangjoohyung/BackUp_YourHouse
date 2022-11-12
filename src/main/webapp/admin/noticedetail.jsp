<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 상세페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/jquery-3.6.1.min.js"></script>
 <style type="text/css">
 
  .label_d{
  
   text-align:center;
   margin-top: 8px;
   margin-left:5px;
   margin-right:6px;
  }
 
  .div_E{
   
   margin-left:5px;
   
  }
 
  .shadow{
    box-shadow: 0 4px 5px rgba(1, 1, 1, 0.6);
  }
 
  .update_value{
  
   disabled:true;
  
  }
  
 hr{
 
  border: 1px solid black;
 
 }
 
 .Vdiv{
    margin-bottom:3px;
   
 
 }
 h5{
 
  margin-botton:2px;
 
 }
 
 </style>
 
 
 
   <script type="text/javascript">
     
   
    $(function(){      		
 	   $("#changeBtn").click(function() {
		  
 	       location.href="noticeupdate.jsp";
  
 	   
 	   }) //카테고리 네용 제목
       
 	       
 	     function validTest(){
 		   
 		  if ($("#selec").val()== "")
 			   return false;
 		   
 		   if ($("#title").val()== "")
			   return false;
		   
 		   if ($("#content").val()== "")
			   return false;
		 
 	          return true; // 공지 제목 내용만 수정 가능합니다.
 	   
 	    }
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
 	      
           
    })
     
   </script>
</head>


<body>
  <jsp:include page="header.jsp"/>   
      
    <form class="container" name="updateForm" style="border-radius: 4px ;margin-top:20px; height:300px; margin-bottom:350px;" onsubmit="return validTest()" 
    enctype="multipart/form-data">
     <h1 style="font-family: Verdana, Geneva, Arial, sans-serif; margin-top:30px; margin-bottom:40px ;font-size-adjust: 50px; color:#228B22 ">공지 상세</h1>       
      <div class="mb-3">
       <h5>공지 종류</h5> 
         <select id="selec"  class="form-select" disabled name="noticeCategory"  > 
             <option value="0">--공지 종류--</option>
             <option value="공지" selected>공지</option>
             <option value="이벤트">이벤트</option>  
         </select>
      </div>   
      <div class="mb-3"> 
        <h5>공지 제목</h5>
        <input id="title" name="subject" class="form-control" type="text" disabled    >
      </div>
     <div class="mb-3">
      <h5 >첨부 파일명</h5>
        <div class="mb-3">
           <input class="form-control" name="noticeImage" type="text" placeholder="Default input" disabled>
       </div>
    </div>
    <div style="display:flex;">       
      <h5 >배너 설정</h5>
       <div class="form-check"> 
         <input id="baner"  name="isPrivate"  class="form-check-input" type="checkbox" value="" id="defaultCheck1" style="border:1px solid black" disabled > 
       </div> 
     </div>
    <div class="mb-1 mt-3" style="margin-bottom:3px">
        <h5 style="margin-right:5px">공지 내용</h5>
       <textarea id="content" name="noticeContent" class="form-control update_value" style="border:0.2px solid black; height:200px ;width:1350px ;resize:none" disabled  ></textarea>
   </div>
    <button type="button" id="changeBtn" class="btn btn-outline-success" style="margin-top:0px  ;height:50px; width:100px;  text-align: center; display:block">수정하기</button>
   </form>
 
 
 
   <jsp:include page="footer.jsp"/>   
  
   
  
</body>
</html>