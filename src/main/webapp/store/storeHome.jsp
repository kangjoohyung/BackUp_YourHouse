<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
	<!-- Slider -->
	<section class="section-slide">
		<div class="wrap-slick1 rs1-slick1">
			<div class="view_visual">
				<img src="${pageContext.request.contextPath}/images/main-top1.jpg"
					alt="" style="display: none" /> <img
					src="${pageContext.request.contextPath}/images/main-top2.jpg"
					alt="" style="display: none" /> <img
					src="${pageContext.request.contextPath}/images/main-top3.jpg"
					alt="" style="display: none" /> <img
					src="${pageContext.request.contextPath}/images/main-top4.jpg"
					alt="" style="display: none" />
			</div>
		</div>
	</section>

	<!-- Banner -->
	<div class="main_banner">
		<div class="flex-w flex-c-m">
			<div class="size-202 m-lr-auto respon4">
				<!-- Block1 -->
				<div class="block1 wrap-pic-w">
					<img src="${pageContext.request.contextPath}/images/banner-01.jpg"
						alt="IMG-BANNER"> <a href="product.html"
						class="block1-txt ab-t-l s-full flex-col-l-sb p-lr-38 p-tb-34 trans-03 respon3">
						<div class="block1-txt-child1 flex-col-l">
							<span class="block1-name ltext-102 trans-04 p-b-8">
								침대/매트리스 </span> <span class="block1-info stext-102 trans-04">
								Fall 2022 </span>
						</div>
						<div class="block1-txt-child2 p-b-4 trans-05">
							<div class="block1-link stext-101 cl0 trans-09">Shop Now</div>
						</div>
					</a>
				</div>
			</div>

			<div class="size-202 m-lr-auto respon4">
				<!-- Block1 -->
				<div class="block1 wrap-pic-w">
					<img src="${pageContext.request.contextPath}/images/banner-02.jpg"
						alt="IMG-BANNER"> <a href="product.html"
						class="block1-txt ab-t-l s-full flex-col-l-sb p-lr-38 p-tb-34 trans-03 respon3">
						<div class="block1-txt-child1 flex-col-l">
							<span class="block1-name ltext-102 trans-04 p-b-8"> 수납/정리
							</span> <span class="block1-info stext-102 trans-04"> Fall 2022 </span>
						</div>

						<div class="block1-txt-child2 p-b-4 trans-05">
							<div class="block1-link stext-101 cl0 trans-09">Shop Now</div>
						</div>
					</a>
				</div>
			</div>

			<div class="size-202 m-lr-auto respon4">
				<!-- Block1 -->
				<div class="block1 wrap-pic-w">
					<img src="${pageContext.request.contextPath}/images/banner-03.jpg"
						alt="IMG-BANNER"> <a href="product.html"
						class="block1-txt ab-t-l s-full flex-col-l-sb p-lr-38 p-tb-34 trans-03 respon3">
						<div class="block1-txt-child1 flex-col-l">
							<span class="block1-name ltext-102 trans-04 p-b-8"> 조명 </span> <span
								class="block1-info stext-102 trans-04"> Fall 2022 </span>
						</div>

						<div class="block1-txt-child2 p-b-4 trans-05">
							<div class="block1-link stext-101 cl0 trans-09">Shop Now</div>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>


	<!-- Product -->
	<section class="sec-product bg0 p-t-100 p-b-50">
		<div class="container">
			<div class="p-b-32">
				<h3 class="ltext-105 cl5 txt-center respon1">그 집 BETST</h3>
			</div>

			<!-- Tab01 -->
			<div class="tab01">
				<!-- Nav tabs -->

				<!-- Tab panes -->
				<div class="tab-content p-t-50">
					<!-- - -->
					<div class="tab-pane fade show active" id="best-seller"
						role="tabpanel">
						<!-- Slide2 -->
						<div class="wrap-slick2">
							<div class="slick2">

								<c:forEach items="${bestList}" var="product">
									<div class="item-slick2 p-l-15 p-r-15 p-t-15 p-b-15">
										<!-- Best product-01 -->
										<div class="block2">
											<div class="block2-pic hov-img0">
											<!-- 
											
													<img
													src="${pageContext.request.contextPath}/save/${product.image}"
													alt="IMG-PRODUCT">
											 -->
												<img
													src="${pageContext.request.contextPath}/save/${product.image}"
													alt="IMG-PRODUCT">
	
											</div>
											<div class="block2-txt flex-w flex-t p-t-14">
												<div class="block2-txt-child1 flex-col-l ">
													<a
														href="front?key=store&methodName=productDetail&productCode=${product.productCode}"
														class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
														${product.productName} </a> <span class="stext-105 cl3">
														￦${product.price} </span>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>

							</div>
						</div>
					</div>
				</div>
	</section>


	<!-- Blog 커뮤니티 -->
	<section class="sec-blog bg0 p-t-60 p-b-90">
		<div class="container">
			<div class="p-b-66">
				<h3 class="ltext-105 cl5 txt-center respon1">커뮤니티</h3>
			</div>

			<div class="row">
				<c:forEach items="${storylist }" var="story" end="5">
					<div class="col-sm-6 col-md-4 p-b-40">
						<div class="blog-item">
							<div class="hov-img0">
								<a href="${pageContext.request.contextPath}/front?key=story&methodName=selectBystoryCode&storyCode=${story.storyCode}"> <img
									src="${pageContext.request.contextPath}/save/${story.storyImage}"
									alt="IMG-BLOG">
								</a>
							</div>

							<div class="p-t-15">
								<div class="stext-107 flex-w p-b-14">
									<span class="m-r-3"> <span class="cl4"> By </span> <span
										class="cl5"> ${story.user.nickname} </span>
									</span> <span> <span class="cl4"> on </span> <span class="cl5">
											${story.storyReg} </span>
									</span>
								</div>

								<p class="stext-108 cl6">${story.storyLiter}</p>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
</section>
	
<!--===============================================================================================-->
	<script language=javascript src="${pageContext.request.contextPath}/js/jquery-3.6.1.js"> </script>  
	<script language=javascript>
	
		/*MAIN slid*/
		$(document).ready(function(){
		var image = $('.view_visual img');
		var numSlides=image.length;
		var activeImage=0;
		var speed=5000;
		var fade=3000;	
		var timer=setInterval(rotate, speed);
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
			
			if(activeImage==numSlides){
				activeImage= 0;
			}
			image.not(activeImage).fadeOut(fade);
			image.eq(activeImage).fadeIn(fade);
			
		}
		});
	</script>
	<script language=javascript>
		/*MAIN slid*/
		$(document).ready(function() {
			var image = $('.view_visual img');
			var numSlides = image.length;
			var activeImage = 0;
			var speed = 2400;
			var fade = 1400;
			var timer = setInterval(rotate, speed);
			image.eq(activeImage).show();

			$(".view_visual").hover(function() {
				clearInterval(timer);
			}, function() {
				timer = setInterval(rotate, speed);
			});
			function rotate() {
				activeImage++; /* ++=+1 */

				if (activeImage == numSlides) {
					activeImage = 0;
				}
				image.not(activeImage).fadeOut(fade);
				image.eq(activeImage).fadeIn(fade);

			}
		});
	</script>
</body>
</html>
<jsp:include page="../common/footer.jsp" />