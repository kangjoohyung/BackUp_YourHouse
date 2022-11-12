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
 
 
 
 
 <style>
 

 .centers{
 
  width:850px;
  height:400px; 
  margin-top:150px;
  padding-right:0px;
  padding-left:0px;

 }

 .navi{
  width:100%;
  height:50px;
  
  margin-left:0px;
  margin-right:0px;   
 }
 
 
 
  .img_in{
    height:300px;   
    width: 400px;
   
    margin-top:50px; 
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
 
  

  
  $(function() {
	
		    document.
		    getElementById("imgBuff").
	        addEventListener("change",function(e){	
	         
	         let imgEle =document.getElementById("img_in");	 
	        	
	          if(!e.target.files[0]){
	        	  imgEle.src="../images/uploads.jpg" 
	        	  return;
	          }
	        	
	           let divEle  = document.getElementById("img_div")
	                   
	           let imgFile	 =e.target.files[0]; 
	           let url  =URL.createObjectURL(imgFile);  
	           imgEle.src=url;
	      
	        },false); 
 
  })
 

 
 
 
 
 </script>

</head>
<body>
<jsp:include page="header.jsp"/>
   
  <     <form  >
   <div class="centers container ">
   
       <div class="container text-center navi"> 
          <div class="container text-center" style="padding-left: 0px">
              <div class="row row-cols-4" style="padding-left: 0px"  >
                  <div class="col" style="padding-left: 0px">
                     <!-- 셀렉트박스 공지 종류  -->
                      
                      <select id="inputState" name="noticeCategory" class="form-select fon" style="margin-left:0px">
                           <option selected>-공지종류-</option>
                           <option value="공지">공지</option>
                           <option value="이벤트">이벤트</option>
                      </select>
                  </div>
            <div class="col mt-1" style="display:auto" >
                <div style="display:flex;">       
                     <label style="mt-1; font-size: 20px">배너 설정 </label>
                        <div class="form-check"> 
                            <!--      -->
                               <input class="form-check-input" id=""  name="isPrivate"  type="checkbox" value=""  > 
                                </div> 
                                   </div>
                                      </div>
                                          <div class="col-6">
                                             <input class="form-control"  id="imgBuff"   style="width:410px; margin-right:10px" type="file" id="formFileMultiple" multiple>  
                                             
                                              </div>    
                                               <!-- <div class="col"></div> --> 
                                               </div>
                                                   </div>   
                                                     </div> 
    
           <div style="display:flex">
              <div id="img_div" class=" img_in">     
                <!--이미지가 들어갈 div이다 -->  
                <img id="img_in" src="uploads.jpg"class="img_k"  />  
                               
              </div>
              <div class="mt-5 ml-5" style="margin-left:31px">
               <label for="exampleFormControlInput1" class="form-label fon">공지 제목</label>
               <input class="form-control input_setting "  type="text" placeholder="Default input" aria-label="default input example">
               <label for="exampleFormControlTextarea1 " class="form-label fon">공지 내용</label>
               <textarea class="form-control input_setting" id="exampleFormControlTextarea1" rows="3" style="height:190px; width:410px; resize:none "></textarea>
             </div>
         </div>
       
    
    
    
     </div>   
    
    

 </form>
 
 
 
 



</body>
</html>