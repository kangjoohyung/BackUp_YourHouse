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
.zipfollowing {
	color: #5a8742;
	font-size: 20px;
	font-weight: bold;
	text-shadow: black;
}

.contents {
	max-width: 600px;
}

#main_container {
	padding-top: 70px;
}

.p-b-68, .p-tb-68, .p-all-68 {
	padding-bottom: 30px;
}
</style>

</head>
<body class="animsition">
	<section class="bg-img1 txt-center p-lr-15 p-tb-92"
		style="background-image: url('${pageContext.request.contextPath}/images/storyBG.jpg');">
		<div class="zipfollowing">관심 있는 게시글을 팔로우해보세요!</div>
	</section>

	<section id="container">
		<div id="main_container">
		<c:forEach items="${list}" var="story">
			<section class="c_inner">
				<div class="contents_box">
					<article class="contents cont01">
						<header class="top">
							<div class="user_container">
								
								<!-- 이미지 -->
								<div class="profile_img">
									<img
										src="${pageContext.request.contextPath}/images/thumb001.jpg"
										alt="">
								</div>
								
								<!-- 유저정보 -->
								<div class="user_name">
									<!-- 닉네임 -->
									<div class="nick_name">${story.user.nickname}</div>
									<!-- 팔로우 -->
									<a href=""
										style="text-decoration: none; font-weight: bold; color: #2982ed">
										팔로잉</a>
								</div>
								
							</div>
							<div class="sprite_more_icon"></div>
						</header>

						<div class="img_section">
							<div class="trans_inner">
								<div>
									<img
										src="${pageContext.request.contextPath}/images/story001.jpg"
										alt="">
								</div>
							</div>
						</div>

						<div class="bottom_icons">
							<div class="left_icons">
								<div class="heart_btn">
									<div class="sprite_heart_icon_outline" data-name="heartbeat"
										alt="좋아요"></div>
								</div>
								<div>
									<div class="sprite_bubble_icon" alt="댓글"></div>
								</div>
							</div>
						</div>

						<div class="count_likes">
							좋아요 <span class="count">2,351</span> 개
						</div>

						<div class="commet_container">

							<div class="commet">
								<div class="nick_name">popo213</div>
								<div>네가 사는 그 집입니다. 코멘트 넣어 주세요.</div>
							</div>
						</div>
						<div class="timer"></div>

						<div class="commit_field">
							<input type="text" placeholder="댓글을 입력하세요"
								style="border-bottom: 1px solid #ededed; padding: 0px 10px; width: 598px;">
							<div class="upload_btn">게시버튼</div>
						</div>


					</article>

				</div>

			</section>
		</c:forEach>
			
		</div>
	</section>

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
</html>
<jsp:include page="../common/footer.jsp" />