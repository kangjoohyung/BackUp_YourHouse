<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>베스트</title>
<!--===============================================================================================-->
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/images/icons/favicon.png" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/fonts/linearicons-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/vendor/slick/slick.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/vendor/MagnificPopup/magnific-popup.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/util.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/tab.css">
<!--===============================================================================================-->
<style>
.tab_menu {
	display: table;
	table-layout: fixed
}

.tab_menu li {
	display: table-cell;
	cursor: pointer
}

.tab_menu li img {
	vertical-align: middle;
	width: 180px;
}

.tab_menu li {
	background: #ededed;
	width: 100px;
	height: 60px;
	vertical-align: middle;
}

.tab_menu li.on {
	background: #1049af;
	color: #fff;
}

.tab_menu li+li {
	border-left: none
}
</style>

</head>
<body>
	<!-- breadcrumb -->
	<div class="container">
		<div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
			<a href="index.html" class="stext-109 cl8 hov-cl1 trans-04"> 스토어
				<i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a> <a href="product.html" class="stext-109 cl8 hov-cl1 trans-04">
				베스트 </a>
		</div>
	</div>

	<div class="cate_tab">

		<ul class="tab_menu">
			<!-- 이미지 이름: [비활성화 상태의 이미지는 _off] | [활성화 상태의 이미지는 _on]  -->
			<li data-tab="tab-1" class="on">실시간 베스트<img src="" alt=""></li>
			<li data-tab="tab-2">역대 베스트<img src="" alt=""></li>

		</ul>
		<ul class="tab_content">

			<!-- 실시간 베스트 -->
			<li id="tab-1" class="on">
				<!-- Product -->
				<div class="bg0 m-t-23 p-b-140">
					<div class="container">
						<div class="flex-w flex-sb-m p-b-52">
							<div class="flex-w flex-l-m filter-tope-group m-tb-10"></div>
						</div>

						<!-- Category Product Tab page -->
						<div class="row isotope-grid">
							<c:forEach items="${list}" var="proR">
								<div
									class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
									<div class="block1">
										<!-- 이미지 -->
										<div class="block1-pic hov-img0">
											<img
												src="${pageContext.request.contextPath}/save/${proR.image}"
												alt="IMG-PRODUCT">
										</div>
										<!-- 상품정보 -->
										<div class="block1-txt flex-w flex-t p-t-14">
											<div class="block2-txt-child1 flex-col-l ">
												<a
													href="${pageContext.request.contextPath}/front?key=store&methodName=productDetail&productCode=${proR.productCode}"
													class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
													${proR.productName} </a> <span class="stext-105 cl3">
													${proR.price} </span>
											</div>

										</div>
									</div>
								</div>
							</c:forEach>
						</div>

					</div>
				</div>
			</li>

			<!-- 역대 베스트 -->
			<li id="tab-2">
				<!-- Product2 -->
				<div class="bg0 m-t-23 p-b-140">
					<div class="container">
						<div class="flex-w flex-sb-m p-b-52">
							<div class="flex-w flex-l-m filter-tope-group m-tb-10"></div>
						</div>

						<!-- Category Product Tab page -->
						<div class="row isotope-grid">
							<c:forEach items="${bestList}" var="proB">
								<div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
									<!-- product-01 -->
									<div class="block2">
										<!-- 이미지 -->
										<div class="block2-pic hov-img0">
											<img
												src="${pageContext.request.contextPath}/save/${proB.image}"
												alt="IMG-PRODUCT">
										</div>

										<!-- 상품정보 -->
										<div class="block2-txt flex-w flex-t p-t-14">
											<div class="block2-txt-child1 flex-col-l ">
												<a href="${pageContext.request.contextPath}/front?key=store&methodName=productDetail&productCode=${proB.productCode}"
													class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
													${proB.productName} </a> <span class="stext-105 cl3">
													${proB.price} </span>
											</div>

										</div>
									</div>
								</div>
							</c:forEach>

						</div>
					</div>
				</div>
			</li>
		</ul>
	</div>

	<section id="rauchbier" class="tab-panel"></section>
	<section id="dunkles" class="tab-panel"></section>

	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/js/jquery-3.6.1.js"></script>
	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap/js/popper.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/vendor/daterangepicker/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/vendor/slick/slick.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/slick-custom.js"></script>
	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/vendor/parallax100/parallax100.js"></script>
	<script>
		$('.parallax100').parallax100();
	</script>
	<!--===============================================================================================-->

	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/vendor/isotope/isotope.pkgd.min.js"></script>

	<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/js/tab.js"></script>
	<!--===============================================================================================-->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>

</body>
</html>
<jsp:include page="../common/footer.jsp" />