<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네가 사는 그 집</title>
</head>
<body class="animsition">
	<!-- 			Header 				-->
	<div class="container-menu-desktop trans-03">
		<div class="wrap-menu-desktop" style="margin-top: 45px; text-align: center;">
			<nav class="limiter-menu-desktop p-l-45">

				<!-- Menu desktop -->
				<div class="menu-desktop">
					<ul class="main-menu">
						<li class="active-menu"><a href="#"><b
								style="font-size: 16px;">프로필</b></a>
							<ul class="sub-menu">
								<li><a href="#">사진</a></li>
								<li><a href="#">좋아요</a></li>
							</ul></li>

						<li class="active-menu"><a href="#"><b
								style="font-size: 16px;">나의 쇼핑</b></a>
							<ul class="sub-menu">
								<li><a href="${pageContext.request.contextPath}/front?key=order&methodName=selectByUserCode">주문배송내역 조회</a></li>
								<li><a href="#">고객센터</a></li>
							</ul></li>

						<li class="active-menu"><a href="#"><b
								style="font-size: 16px;">나의 리뷰</b></a>
							<ul class="sub-menu">
								<li><a href="#">리뷰쓰기</a></li>
								<li><a href="#">내가 작성한 리뷰</a></li>
							</ul></li>
					</ul>
				</div>
			
			</nav>
		</div>
	</div>
</body>
</html>