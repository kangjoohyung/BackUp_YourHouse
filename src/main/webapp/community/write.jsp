<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script type="text/javascript" src="${path}/js/jquery-3.6.1.min.js"></script>
 
 
 
 
 <style>
 

 .centers{
 
  margin:auto;
  background-color: red; 
  border:1px solid black;
  height:500px 
  
  
  }

 .navi{

  height:100px;
  background-color: yellow; 
  margin-left:0px;
  margin-right:0px;   
 
  
 }
 
 
 
  .img_in{
    height:500px;   
    width: 532.5px;
   
    margin-top:10px; 
    border-radius: 10px;
    border-radius: 7px;
    
    
      }
  
  .input_setting{
     
    width:410px;
  
  
  }
  
  
  .fon{
  
  font-family: Georgia, "Malgun Gothic", serif;
  font-weight: 400;
  font-family: Lorem Ipsum Dolor;

 
  }
  
   .img_k{
   
   width:100% ;height:100%;
   border-radius: 7px
   
   }
   
  
   
 
  
</style>


 <script type="text/javascript">
 
  

  
  $(function(){
	
		 
	    
	  
	  
	        document.
		    getElementById("imgBuff").
	        addEventListener("input", function(e){	
	         
	           let imgEle =document.getElementById("img_ins");	 
	           let arr= e.target.files
	         
	           
	           
	           if(!e.target.files[0]){
		        	  imgEle.src="../images/uploads.jpg" 
		        	  return;
		          }
	        	
	           let divEle  = document.getElementById("img_div")             
	           let imgFile	=e.target.files[0]; 
	           let url  =URL.createObjectURL(imgFile);  
	           imgEle.src=url;
	      
	        },false); // 이벤트 등록 끝
 
	      		    
		    
		    
		    
		    })//onload
		    
		    
		    
         		    
		    
 
		    
		    
		    
		    
		    
		    
		    
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


  
  
  
  
  
 
 
 
 
 </script>

</head>
<body>
<jsp:include page="../common/header.jsp"/>
   
 <form class="container" name="Form" method="post" enctype="multipart/form-data"  style="margin-left:450px;  margin-top:50px" action= "${path}/front?key=story&methodName=insert"
   onsubmit="return insertStory(this)">
     
  
 
 
                    
                  
            
             <div class="container">
                 <div class="row">             
                    <div class="col-md-5"> 
                       <input class="form-control" id="imgBuff" type="file" id="formFileMultiple" name="storyImage" multiple>    
                        <div id="img_div" class="img_in">     
                             <!--이미지가 들어갈 div이다 -->  
                         <img id="img_ins" src="${path}/images/uploads.jpg"class="img_k"  />                                  
                       </div>
                   </div>             
                   <div class="col-md-5"> 
                 
                      <label for="exampleFormControlTextarea1"  class="form-label fon">사진 설명</label>
                      <textarea class="form-control input_setting" name="storyLiter" id="cid" rows="3" style="height:520px; width:532.5px; resize:none"></textarea>
                   </div> 
               </div>
          
           <button type="submit" style="margin-top:20px" class="btn btn-primary btn-lg">등록하기</button> 
         </div>
                  
 </form>
 
 
 
 <script type="text/javascript">

 
 function insertStory(fr) {
	 
  	  
	      let arr  = fr.storyImage.files
	
	if(if arr.length<0){
	alert("사진을 등록해주세요")	
 	return false;
	}
	
     
    return true;
   
   
   
   
   

	 
	  
  
  
 
 
 }
 
 
 </script>
 



</body>
</html>