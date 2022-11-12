<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert header</title>
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/icons/favicon.png"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/slick.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/magnific-popup.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/util.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">	
<!--===============================================================================================-->

</head>
<body>
<!-- Header -->
  
	<header class="header-v2">
		<!-- Header desktop -->
		<div class="container-menu-desktop trans-03">
			<div class="wrap-menu-desktop" style="border-bottom: 1px solid #ededed;">
				<nav class="limiter-menu-desktop">
					<!-- Logo desktop -->		
					<a href="#" class="logo">
						<img src="${pageContext.request.contextPath}/images/IKEA_logo.svg" style="width: 250px;" alt="IMG-LOGO">
					</a>
									
					  <div class="menu-desktop">
						<ul class="main-menu">
						     <li class="active-menu" style="margin-left: 50px">
								<a href="blog.html"><b style="font-size: 22px;">게시글</b></a>
								<ul class="sub-menu">
									<li><a href="blog.html">목록</a></li>
									<li><a href="blog.html">등록</a></li>
									<li><a href="blog-detail.html">수정</a></li>
								</ul>
							</li>
							<li class="active-menu"  style="margin-left: 50px"  >
								<a href="index.html"><b style="font-size: 22px;">상품</b></a>
								<ul class="sub-menu">
									<li><a href="index.html">목록</a></li>
									<li><a href="product.html">등록</a></li>
									
								</ul>
							</li>
							<li class="active-menu" style="margin-left: 50px">
								<a href="index.html"><b style="font-size: 22px;">매출</b></a>
								 <ul class="sub-menu">
									<li><a href="index.html">목록</a></li>
									<li><a href="product.html">등록</a></li>
								
								</ul>
							</li>
						    

	

					
						</ul>
						 <ul class="dropdown-menu">
                                  <li><span class="dropdown-item-text">Dropdown item text</span></li>
                                  <li><a class="dropdown-item" href="#">Action</a></li>
                                  <li><a class="dropdown-item" href="#">Another action</a></li>
                                  <li><a class="dropdown-item" href="#">Something else here</a></li>
                               </ul> 	
					</div>	

					<!-- Icon header -->
					<div class="wrap-icon-header flex-w flex-r-m h-full">
						<ul class="main-menu">
							<li>
								<a href="user.html"><img src="${pageContext.request.contextPath}/images/user.png" style=""></a>
							</li>
							<li>    
						     <c:choose>    								
						       <c:when test="${empty sessionScope.loginAdmin}"> 			  
						        <a href="login.html">로그인</a>	
                               </c:when>
                               <c:otherwise>
                                <p>{sessionScope.loginAdminId} </p>  
                               </c:otherwise> 
                             </c:choose>		
                             </li>
							<li>
								<a href="contact.html">고객센터</a>
							</li>
						</ul>
							
						
													
						<!-- <div class="flex-c-m h-full p-lr-19">
							 <div class="icon-header-item cl2 hov-cl1 trans-04 p-lr-11 js-show-sidebar">
								<i class="zmdi zmdi-menu"></i>
							</div>
						</div> -->
					</div>
				</nav>
			</div>	
		</div>
<!-- HeaderEND -->

<!--*********************************** Mobile ******************************************-->	
 		<!-- Header Mobile -->

		<div class="wrap-header-mobile">
			<!-- Logo moblie -->		
			<div class="logo-mobile">
				<a href="index.html"><img src="${pageContext.request.contextPath}/images/IKEA_logo.svg" alt="IMG-LOGO"></a>
			</div>

			<!-- Icon header -->
			<div class="wrap-icon-header flex-w flex-r-m h-full m-r-15">
				<!-- <div class="flex-c-m h-full p-r-10">
					<div class="icon-header-item cl2 hov-cl1 trans-04 p-lr-11 js-show-modal-search">
						<i class="zmdi zmdi-search"></i>
					</div>
				</div> -->

				<div class="flex-c-m h-full p-lr-10 bor5">
					<div class="icon-header-item">  <!-- data-notify="2" -->
						<img src="${pageContext.request.contextPath}/images/shopping-cart.png" alt="cart" style="width: 24px;">
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
						<li><a href="home-02.html">스토리</a></li>
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
<!--===============================================================================================-->	
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/js/popper.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/js/select2.min.js"></script>
	<script>
		$(".js-select2").each(function(){
			$(this).select2({
				minimumResultsForSearch: 20,
				dropdownParent: $(this).next('.dropDownSelect2')
			});
		})
	</script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/js/moment.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/js/slick.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/slick-custom.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/js/parallax100.js"></script>
	<script>
        $('.parallax100').parallax100();
	</script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/js/jquery.magnific-popup.min.js"></script>
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
	<script src="${pageContext.request.contextPath}/js/isotope.pkgd.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/js/sweetalert.min.js"></script>
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
	<script src="${pageContext.request.contextPath}/js/perfect-scrollbar.min.js"></script>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.js"> </script>  
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
		
</body>
</html>