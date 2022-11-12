<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===================================================================================-->
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
<!--=================================================================================-->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/util.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<!--================================================================================-->
<style type="text/css">
.zipstory {
   color: #fff; font-size: 30px; font-weight: bold; text-shadow: black;
}
</style>

</head>
<body class="animsition">   
<section class="bg-img1 txt-center p-lr-15 p-tb-92" 
style="background-image: url('${pageContext.request.contextPath}/images/storyBG.jpg');">
   <div class="zipstory">
      그 집 Story
   </div>
</section>
   <!-- story -->
   <div class="bg0 m-t-23 p-b-140" style="margin-top: 80px;">
      <div class="container">
         <div class="row isotope-grid">
            <!-- 게시물 -->
            <div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
               <!-- Block2 -->
               <div class="block2">
                  <section class="b_inner">
                     <div class="contents_box">
                         <article class="contents cont01">
                             <header class="top">
                                 <div class="user_container">
                                     <div class="profile_img">
                                         <img src="${pageContext.request.contextPath}/images/thumb001.jpg" alt="">
                                     </div>
                                     <div class="user_name">
                                         <div class="nick_name">닉네임1ww23</div> 
                                         <a href="" 
                                         style="text-decoration: none; font-weight: bold; color:#2982ed">
                                         팔로우</a>
                                     </div>
                                 </div>
                                
                             </header>

                             <div class="img_section">
                                 <div class="trans_inner">
                                     <div><img src="${pageContext.request.contextPath}/images/story001.jpg" alt=""></div>
                                 </div>
                             </div>


                             <div class="bottom_icons">
                                 <div class="left_icons">
                                     <div class="heart_btn">
                                         <div class="sprite_heart_icon_outline" data-name="heartbeat"></div>
                                     </div>
                                 </div>

                                 <div class="right_icon">
                                     
                                 </div>
                             </div>
                     <div class="commet_container">

                        <div class="commet">
                            <div class="nick_name">
                                popo213
                            </div>
                             <div class="commet" style="margin: 0 10px;">
                                네가 사는 그 집입니다.
                                코멘트 넣어 주세요.
                           </div>
                        </div>

                    </div>
                      </article>

                     </div>

                    </section>
            
            </div>
         </div>
            <!-- 게시물END -->
            
            
      <!--게시물 - 1 END -->

      <!--게시물 - 2 END -->
         </div>
      </div>
   </div>
      
   <!-- Back to top -->
   <div class="btn-back-to-top" id="myBtn">
      <span class="symbol-btn-back-to-top">
         <i class="zmdi zmdi-chevron-up"></i>
      </span>
   </div>
            

<!--======================================================================================-->   
   <script src="${pageContext.request.contextPath}/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--========================================================================================-->
   <script src="${pageContext.request.contextPath}/vendor/animsition/js/animsition.min.js"></script>

<!--======================================================================================-->

   <script src="${pageContext.request.contextPath}/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
   <script>
      $('.js-pscroll').each(function(){
         $(this).css('position','relative');
         $(this).css('overflow','hidden');
         var ps = new PerfectScrollbar(this, {
            wheelSpeed: 1,
            scrollingThreshold: 1000,
            wheelPropagation: false,
         });

         $(window).on('resize', function(){
            ps.update();
         })
      });
   </script>
<!--===================================================================================-->
   <script src="${pageContext.request.contextPath}/js/main.js"></script>

</body>

</body>
</html>
<jsp:include page="../common/footer.jsp"/>