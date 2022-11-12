<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네가 사는 그 집</title>
<!--===============================================================================================-->	
	<link rel="icon" type="image/svc" href="${pageContext.request.contextPath}/images/icons/logo_thumb.svg"/>
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
<!--===============================================================================================-->

</head>


<body class="animsition">
<!-- Title page -->	
<!-- 			Header 				-->
	<header class="header-v2">
		<!-- Header desktop -->
		<div class="container-menu-desktop trans-03">
			<div class="wrap-menu-desktop">
				<nav class="limiter-menu-desktop p-l-45">
					
					<!-- Logo desktop -->		
					<a href="${pageContext.request.contextPath }/front?key=store&methodName=storeHome" class="logo">
						<img src="${pageContext.request.contextPath}/images/icons/NIZIP_logo.svg" style="width: 250px;" alt="IMG-LOGO">
					</a>

					<!-- Menu desktop -->
					<div class="menu-desktop">
						<ul class="main-menu">
							<li class="label1" data-label1="hot">
								<a href="${pageContext.request.contextPath}/front?key=story&methodName=select"><b style="font-size: 16px;">커뮤니티</b></a>
								<ul class="sub-menu">
									<li><a href="${pageContext.request.contextPath}/front?key=story&methodName=select">홈</a></li>
									<li><a href="${pageContext.request.contextPath}/front?key=follow&methodName=following">팔로잉</a></li>
								    <li><a href="${pageContext.request.contextPath}/community/write.jsp">글쓰기</a></li>
								</ul>
							</li>

							<li class="active-menu">
								<a href="${pageContext.request.contextPath}/front?key=store&methodName=storeHome"><b style="font-size: 16px;">스토어</b></a>
								<ul class="sub-menu">
									<li><a href="${pageContext.request.contextPath}/front?key=store&methodName=storeHome">홈</a></li>
									<li><a href="${pageContext.request.contextPath}/front?key=store&methodName=storeCategory">카테고리</a></li>
									<li><a href="${pageContext.request.contextPath}/front?key=store&methodName=storeBest"">베스트</a></li>
								</ul>
							</li>

						<li class="search">
							 <form class="search-container">
							    <input type="text" id="search-bar" placeholder="통합검색">
							    <a href="#"><img class="search-icon" src="http://www.endlessicons.com/wp-content/uploads/2012/12/search-icon.png"></a>
							  </form>
						</li>

							
						</ul>
					</div>	

					<!-- Icon header -->
					<div class="wrap-icon-header flex-w flex-r-m h-full">
						<ul class="main-menu">
							<li class="active-menu">
								<a href="../mypage/myProfile.jsp"><img src="${pageContext.request.contextPath}/images/icons/user.png" style=""></a>
								<ul class="sub-menu">
									<li><a href="${pageContext.request.contextPath}/mypage/myProfile.jsp">프로필</a></li>
									<li><a href="${pageContext.request.contextPath}/mypage/myShopping.jsp">나의 쇼핑</a></li>
								</ul>
							</li>

							<li>
								<c:choose>
									<c:when test="${empty loginUser}">
										<a href="${pageContext.request.contextPath}/index.jsp">로그인</a>
									</c:when>
									<c:otherwise>
										<a href="${pageContext.request.contextPath}/front?key=user&methodName=myPage">${loginUser.nickname}</a>
									</c:otherwise>
								</c:choose>
							</li>

							<li>
								<c:choose>
									<c:when test="${empty loginUser}">
										<a href="../register/reg.html">회원가입</a>
									</c:when>
									<c:otherwise>
										<a href="${pageContext.request.contextPath}/front?key=user&methodName=logout">로그아웃</a>
									</c:otherwise>
								</c:choose>
							</li>

							<li>
								<a href="contact.html">고객센터</a>
							</li>
						</ul>
							
						<div class="shopingCart">
							
								<a href="${pageContext.request.contextPath}/store/cart.jsp"><img src="${pageContext.request.contextPath}/images/icons/shopping-cart.png" style="width: 30%;"></a>
							</div>
				
						</div>
					</div>
				</nav>
			</div>	
		</div>
<!-- 			HeaderEND 				-->

<!--*********************************** Mobile ******************************************-->	
 		<!-- Header Mobile -->

		<div class="wrap-header-mobile">
			<!-- Logo moblie -->		
			<div class="logo-mobile">
				<a href="index.html"><img src="${pageContext.request.contextPath}/images/icons/NIZIP_logo.svg" alt="IMG-LOGO"></a>
			</div>

			<!-- Icon header -->
			<div class="wrap-icon-header flex-w flex-r-m h-full m-r-15">

				<div class="flex-c-m h-full p-lr-10 bor5">
					<div class="icon-header-item">  <!-- data-notify="2" -->
						<img src="${pageContext.request.contextPath}/images/icons/shopping-cart.png" alt="cart" style="width: 24px;">
					</div>
				</div>
			</div>

			<!-- Button show menu -->
			<div class="btn-show-menu-mobile hamburger hamburger--squeeze">
				<span class="hamburger-box">
					<span class="hamburger-inner"></span>
				</span>
			</div>
		</div>


		<!-- Menu Mobile -->
		<div class="menu-mobile">
			<ul class="main-menu-m">
				<li>
					<a href="index.html">커뮤니티</a>
					<ul class="sub-menu-m">
						<li><a href="index.html">홈</a></li>
						<li><a href="#">팔로잉</a></li>
						<li><a href="#">글쓰기</a></li>
					</ul>
					<span class="arrow-main-menu-m">
						<i class="fa fa-angle-right" aria-hidden="true"></i>
					</span>
				</li>

				<li>
					<a href="product.html">스토어</a>
				</li>

				<li>
					<a href="shoping-cart.html">로그인</a>
				</li>

				<li>
					<a href="blog.html">회원가입</a>
				</li>

				<li>
					<a href="about.html">고객센터</a>
				</li>

			</ul>
		</div>

	</header>
<!--*********************************** MobileEnd ******************************************-->

<!--===============================================================================================-->	
	<script src="${pageContext.request.contextPath}/js/jquery-3.6.1.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/popper.js"></script>
	<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/select2/select2.min.js"></script>
	<script>
		$(".js-select2").each(function(){
			$(this).select2({
				minimumResultsForSearch: 20,
				dropdownParent: $(this).next('.dropDownSelect2')
			});
		})
	</script>
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
	<script src="${pageContext.request.contextPath}/vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
	<script>
		$('.gallery-lb').each(function() { // the containers for all your galleries
			$(this).magnificPopup({
		        delegate: 'a', // the selector for gallery item
		        type: 'image',
		        gallery: {
		        	enabled:true
		        },
		        mainClass: 'mfp-fade'
		    });
		});
	</script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/isotope/isotope.pkgd.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/sweetalert/sweetalert.min.js"></script>
	<script>
		$('.js-addwish-b2').on('click', function(e){
			e.preventDefault();
		});

		$('.js-addwish-b2').each(function(){
			var nameProduct = $(this).parent().parent().find('.js-name-b2').html();
			$(this).on('click', function(){
				swal(nameProduct, "is added to wishlist !", "success");

				$(this).addClass('js-addedwish-b2');
				$(this).off('click');
			});
		});

		$('.js-addwish-detail').each(function(){
			var nameProduct = $(this).parent().parent().parent().find('.js-name-detail').html();

			$(this).on('click', function(){
				swal(nameProduct, "is added to wishlist !", "success");

				$(this).addClass('js-addedwish-detail');
				$(this).off('click');
			});
		});

		/*---------------------------------------------*/

		$('.js-addcart-detail').each(function(){
			var nameProduct = $(this).parent().parent().parent().parent().find('.js-name-detail').html();
			$(this).on('click', function(){
				swal(nameProduct, "is added to cart !", "success");
			});
		});
	</script>
<!--===============================================================================================-->
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
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.1.js"> </script>  
	<script type="text/javascript">
	
		/*MAIN slid*/
		$(document).ready(function(){
		var image = $('.view_visual img');
		var numSlides=image.length;
		var activeImage= 0;
		var speed=2000;
		var fade= 1200;	
		var timer= setInterval(rotate, speed);
		image.eq(activeImage).show();
		
		$(".view_visual").hover(
				function(){
					clearInterval(timer);
				}, function(){
					timer=setInterval(rotate,speed);
				}
				);
		function rotate(){
			activeImage++; /* ++=+1 */
			
			if(activeImage== numSlides){
				activeImage= 0;
			}
			image.not(activeImage).fadeOut(fade);
			image.eq(activeImage).fadeIn(fade);
			
		}
		});


	</script>

<!--===============================================================================================-->


</body>
</html>