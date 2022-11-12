<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="navigation/title.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네가 사는 그 집</title>
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/icons/favicon.png"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/linearicons-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/slick/slick.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/MagnificPopup/magnific-popup.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/util.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tab.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css">
<!--===============================================================================================-->

<style type="text/css">
	#main_container .a_inner{
	    width:900px;
	    position: relative;
	}

    #main_container .a_inner{
        width:initial !important;
        max-width:935px;
    }
    
    .a_inner .contents_box {
        float: none;
    }
    
    .detail .middle {
    	padding: 48px 0;
    }
    
    #main_container {
    padding-top: 30px;
    display: flex;
    justify-content: center;
}
    
</style>

</head>
<body>
<!-- crumb -->
	<div class="container">
		<div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
			<a href="index.html" class="stext-109 cl8 hov-cl1 trans-04">
				마이페이지
				<i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a>

			<a href="product.html" class="stext-109 cl8 hov-cl1 trans-04">
				프로필				
			</a>

		</div>
	</div>
<div>
<section id="my_container">

    <div id="main_container">

        <section class="a_inner">

            <div class="prof_cont">
                <div class="profile_wrap">
                    <div class="profile_img">
                        <img src="${pageContext.request.contextPath}/images/thumb001.jpg" alt="프로필사진">
                    </div>
                </div>

                <div class="detail">
                    <div class="top">
                        <div class="user_name" style="font-family: SCDream4; color: #04348c;">${loginUser.nickname}</div>
                        <a href="profile_edit.html" class="profile_edit">
                        <img src="${pageContext.request.contextPath}/images/icons/gear_thin.svg" 
                        alt="수정" style="width: 20px; padding-right: 5px;">
                        프로필 편집</a>
                        
                    </div>

                    <ul class="middle">
                        <li>
                            <span>사진</span>
                            <span alt="내가 올린 사진 개수">${storylist.size()}</span>
                        </li>
                        <li>
                            <span>팔로워</span>
                            <a class="follower" href="/follower">${followerlist.size()}</a>
                        </li>
                        <li>
                            <span>팔로잉</span>
                             <a class="followee" href="/followee">${followinglist.size()}</a>
                        </li>
                    </ul>                
	                 <p class="about">
	                  <span class="nick_name">사진</span>
	                  <span class="book_mark">좋아요</span>
	                 </p>
                </div>

            </div>

            <div class="mylist_contents contents_container active">
            	<c:forEach items="${storylist}" var="story">
            		<div class="pic">
                   		<a href="${pageContext.request.contextPath}/front?key=story&methodName=selectBystoryCode&storyCode=${story.storyCode}&flag=true" alt="storyDetail로 이동"><img src="${pageContext.request.contextPath}/save/${story.storyImage}" alt="사진"></a>
               		</div>
            	</c:forEach>
            </div>


            <div class="bookmark_contents contents_container">
                <div class="pic">
                    <a href="#"><img src="${pageContext.request.contextPath}/images/img_section/img03.jpg" alt=""></a>
                </div>
                <div class="pic">
                    <a href="#"><img src="${pageContext.request.contextPath}/images/img_section/img01.jpg" alt=""></a>
                </div>
                <div class="pic">
                    <a href="#"> <img src="${pageContext.request.contextPath}/images/img_section/img02.jpg" alt=""></a>
                </div>
                <div class="pic">
                    <a href="#"> <img src="${pageContext.request.contextPath}/images/img_section/img06.jpg" alt=""></a>
                </div>
                <div class="pic">
                    <a href="#"> <img src="${pageContext.request.contextPath}/images/img_section/img05.jpg" alt=""></a>
                </div>
                <div class="pic">
                    <a href="#"> <img src="${pageContext.request.contextPath}/images/img_section/img04.jpg" alt=""></a>
                </div>
                <div class="pic">
                    <a href="#"> <img src="${pageContext.request.contextPath}/images/img_section/img01.jpg" alt=""></a>
                </div>
                <div class="pic">
                    <a href="#"> <img src="${pageContext.request.contextPath}/images/img_section/img02.jpg" alt=""></a>
                </div>
                <div class="pic">
                    <a href="#"> <img src="${pageContext.request.contextPath}/images/img_section/img05.jpg" alt=""></a>
                </div>
            </div>

        </section>
    </div>


</section>
	
</div>
     
    
<!--===============================================================================================-->	
	<script src="${pageContext.request.contextPath}/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/popper.js"></script>
	<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/daterangepicker/moment.min.js"></script>
	<script src="${pageContext.request.contextPath}/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/slick/slick.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/slick-custom.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/parallax100/parallax100.js"></script>
	<script>
        $('.parallax100').parallax100();
	</script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/js/profile.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/isotope/isotope.pkgd.min.js"></script>

<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/js/tab.js"></script>
<!--===============================================================================================-->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>
<jsp:include page="../common/footer.jsp"/>