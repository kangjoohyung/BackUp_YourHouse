<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===================================================================================-->
<link rel="stylesheet" type="text/css"
   href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
<!--=================================================================================-->
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/css/util.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/css/reset.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/css/style.css">
<!--================================================================================-->
<style type="text/css">
.zipstory {
   color: #fff;
   font-size: 30px;
   font-weight: bold;
   text-shadow: black;
}

.contents {
   display: inline-block;
   width: 600px;
    margin: 20px;
}
</style>

<script type="text/javascript"
   src="${pageContext.request.contextPath}/js/jquery-3.6.1.js"></script>
<script type="text/javascript">
   $(function() {
      $(".fowllowingBTN").click(function() {
         let following = $(this).next().val();
         let fowbtn = $(this).val();
         let fowbtne = $(this);
         
         $.ajax({
            url : "ajax",
            type : "post",
            dataType : "text",
            data : {
               key:'follow',
               methodName :'isFollowCheck',
               followCode : following
            },
            success : function(result) {
               if(fowbtn=="팔로우"){
                  fowbtne.val("팔로잉");
               }else{
                  fowbtne.val("팔로우");
               }
               
            },
            error : function(err) {
               alert(err+"에러 발생했어요.");
            }//error
         });//ajax
      });
   });
</script>

</head>
<body class="animsition">
   <section class="bg-img1 txt-center p-lr-15 p-tb-92"
      style="background-image: url('${pageContext.request.contextPath}/images/storyBG.jpg');">
      <div class="zipstory">그 집 Story</div>
   </section>
   <!-- story -->
   <div class="bg0 m-t-23 p-b-140" style="margin-top: 80px;">
      <div class="container">
         <div>
            <!-- 게시물 -->
            <div>
               <!-- Block2 -->
               <div class="block2">
                  <div class="b_inner">
                     <div class="contents_box">
                        <c:forEach items="${storylist}" var="story">
                           <article class="contents cont01">
                              <header class="top">
                                 <div class="user_container">
                                    <div class="profile_img">
                                       <img
                                          src="${pageContext.request.contextPath}/images/thumb001.jpg"
                                          alt="">
                                    </div>
                                    <div class="user_name">
                                       <div class="nick_name">
                                          <a
                                             href="front?key=user&methodName=selectByUserCode&userCode=${user.userCode}">${story.user.nickname}</a>
                                       </div>
                                       <c:choose>
                                          <c:when test="${story.follow}">
                                             <input type="button" value="팔로잉" class="fowllowingBTN">
                                          </c:when>
                                          <c:otherwise>
                                             <input type="button" value="팔로우" class="fowllowingBTN">
                                          </c:otherwise>
                                       </c:choose>
                                       <input type="hidden" id="${story.user.userCode}" value="${story.user.userCode}">
                                    </div>
                                 </div>
                              </header>

                              <div class="img_section">
                                 <div class="trans_inner">
                                    <div>
                                       <a
                                          href="front?key=story&methodName=selectBystoryCode&storyCode=${story.storyCode }">
                                          <img
                                          src="${pageContext.request.contextPath}/save/${story.storyImage}"
                                          alt="USER001">
                                       </a>
                                    </div>
                                 </div>
                              </div>


                              <div class="bottom_icons">
                                 <div class="left_icons">
                                    <div class="heart_btn">
                                       <c:choose>
                                          <c:when test="${story.like}">
                                             <div class="sprite_heart_icon_outline_red"
                                                data-name="heartbeat"></div>
                                          </c:when>
                                          <c:otherwise>
                                             <div class="sprite_heart_icon_outline"
                                                data-name="heartbeat"></div>
                                          </c:otherwise>
                                       </c:choose>
                                    </div>
                                 </div>

                                 <div class="right_icon"></div>
                              </div>
                              <div class="commet_container"></div>
                           </article>
                        </c:forEach>
                     </div>
                  </div>
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
      <span class="symbol-btn-back-to-top"> <i
         class="zmdi zmdi-chevron-up"></i>
      </span>
   </div>


   <!--======================================================================================-->
   <script
      src="${pageContext.request.contextPath}/vendor/jquery/jquery-3.2.1.min.js"></script>
   <!--========================================================================================-->
   <script
      src="${pageContext.request.contextPath}/vendor/animsition/js/animsition.min.js"></script>

   <!--======================================================================================-->

   <script
      src="${pageContext.request.contextPath}/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
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
<jsp:include page="../common/footer.jsp" />