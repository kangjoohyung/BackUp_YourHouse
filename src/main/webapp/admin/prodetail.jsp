<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script type="text/javascript" src="../jquery-3.2.1.min.js"></script>
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
  
 
 </style>
 

</head>


<body>
  <jsp:include page="header.jsp"/>   
    
    <form class="container" name="updateForm" style="border-radius: 4px ;margin-top:50px; height:400px; margin-bottom:270px" onsubmit="return check()" >
     <h1 style="font-family: Verdana, Geneva, Arial, sans-serif; margin-top:30px; margin-bottom:40px ;font-size-adjust: 50px; ">상품 상세</h1>
     <div style="display:flex; text-align:center; margin-top:8px"> 
       <label class="label_d">카테고리:</label>
       <input class="form-control update_value" type="text"  aria-label="default input example" style="width:190px;" disabled>  
       <label class="label_d">상품명:</label>
       <input class="form-control update_value"    type="text" aria-label="default input example" style="width:190px;" disabled     >
       <label class="label_d">가격:</label>
       <input class="form-control update_value" type="text"  aria-label="default input example" style="width:190px;" disabled value="1000원" > 
       <label class="label_d">재고량:</label>
       <input class="form-control update_value" type="text"  aria-label="default input example" style="width:190px;" disabled>  
        <label class="label_d">색상:</label>
          <div class="form-floating">  
            <select class="form-select update_value" id="colorChoose" aria-label="Floating label select example" style="height:40px; width:160px;">
                 <option selected>Open this select menu</option>
                 <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
          </select> 
        </div> 
       </div>
      
    <div class="mb-3" style="margin-left:5px" >
          <label for="formFileMultiple" class="form-label" style="font-size:18px; margin-top:5px;  ">대표 이미지</label>
          <input class="form-control update_value" style="border:1px solid black;"  type="file" id="formFileMultiple" disabled>
   </div>
   <div class="mb-3" style="margin-left:5px; margin-bottom: 5px">
          <label for="formFileMultiple" class="form-label" style="font-size:18px; margin-top:5px">추가 이미지</label>
          <input class="form-control update_value" style="border:1px solid black;" type="file" id="formFileMultiple" disabled>
   </div>
   <div class="mb-5" style="margin-left:5px; margin-bottom:3px ">
     <label for="exampleFormControlTextarea1" class="form-label" style="font-size:18px">상품 상세설명</label>
     <textarea class="form-control update_value" style="border:0.2px solid black;" id="exampleFormControlTextarea1" rows="5" style="margin-bottom:10px" disabled ></textarea>
   </div>
    <button type="button" id="ableBtn" class="btn btn-outline-success" style="margin-top:0px  ;height:50px; width:100px;  text-align: center; display:block"  >수정하기</button>
    <button type="submit" id="updateBtn" class="btn btn-outline-primary" style="display:none; height:50px; width:100px">수정완료</button>
    </form>
 
 
   
 
   
 
 
 
 
   <jsp:include page="footer.jsp"/>   
  
   <script type="text/javascript">
    
   $("#ableBtn").click(function() {  
	   $(".update_value").attr("disabled",false);
       $("h1").html("상품 수정"); 
       $("h1").css("color","blue")
       $(this).hide();
       $("#updateBtn").css("display", "block");   
    
   
   
   })
   
   function validCheck(){
	   
	   
	   
	   
   }
   
   
   
   
   
   
   
   
   </script>
  
  
</body>
</html>