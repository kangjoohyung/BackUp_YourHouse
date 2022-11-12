<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="navigation/title.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네가 사는 그 집</title>
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
	table-layout: fixed;
	border: 2px solid #ededed;
	margin-top: 120px;
	padding: 10px 0;
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
	background: #fff;
	width: 100px;
	height: 60px;
	vertical-align: middle;
}

.tab_menu li.on {
	background: #fff;
	color: #f8d115;
}

.tab_menu li+li {
	border-left: none
}

.tab_menu li {
	border: none;
}

.tab_content td {
	width: 150px;
	display: inline-block;
}

.how-i {
	margin-top: 20px;
}
</style>

</head>
<body>

	<div class="cate_tab">

		<ul class="tab_menu">
			<!-- 이미지 이름: [비활성화 상태의 이미지는 _off] | [활성화 상태의 이미지는 _on]  -->
			<li data-tab="tab-1">결제완료<br> <a class="on">1</a>
			</li>
			<li style="width: 20px;"><img
				src="${pageContext.request.contextPath}/images/icons/arrow_right.png"
				alt="" style="width: 10px;"></li>
			<li data-tab="tab-2">배송중<br> <a>2</a>
			</li>
			<li style="width: 20px;"><img
				src="${pageContext.request.contextPath}/images/icons/arrow_right.png"
				alt="" style="width: 10px;"></li>
			<li data-tab="tab-3">배송완료<br> <a>0</a>
			</li>

		</ul>
		<ul class="tab_content">
			<!-- 결제완료 -->
			<li id="tab-1" class="on">
				<table>
					<c:forEach items="${orderlist}" var="order">
						<c:forEach items="${order.ordreDetailList}" var="orderD">
							<tr class="tab_content">
								<td id="tab-1" class="on">
									<div class="how-i">
										<img
											src="${pageContext.request.contextPath}/images/item-cart-02.jpg"
											alt="IMG">
									</div> <input type="hidden" value="" class="789456">
								</td>
								<td class="column-2">${orderD.productName}</td>
								<td class="column-3">${orderD.colorName}</td>
								<td class="column-4">${orderD.orderQty}</td>
								<td class="column-5">${orderD.unitPrice}</td>
								<td class="column-6"><button
										style="color: #96aac1; font-weight: bold;">결제취소</button></td>
							</tr>
						</c:forEach>
					</c:forEach>
				</table>
			</li>


			<li id="tab-2">
				<table>
					<tr class="tab_content">
						<td id="tab-2">
							<div class="how-i">
								<img
									src="${pageContext.request.contextPath}/images/item-cart-03.jpg"
									alt="IMG">
							</div> <input type="hidden" value="" class="789456">
						</td>
						<td class="column-2">상품이름</td>
						<td class="column-3">색상</td>
						<td class="column-4">상품 수량</td>
						<td class="column-5">가격</td>
						<td class="column-6"><button
								style="color: #96aac1; font-weight: bold;">삭제</button></td>
					</tr>
				</table>
			</li>
			<li id="tab-3">
				<table>
					<tr class="tab_content">
						<td id="tab-3">
							<div class="how-i">
								<img
									src="${pageContext.request.contextPath}/images/item-cart-04.jpg"
									alt="IMG">
							</div> <input type="hidden" value="" class="789456">
						</td>
						<td class="column-2">상품이름</td>
						<td class="column-3">색상</td>
						<td class="column-4">상품 수량</td>
						<td class="column-5">가격</td>
						<td class="column-6"><button
								style="color: #96aac1; font-weight: bold;">삭제</button></td>
					</tr>
				</table>
			</li>
		</ul>
	</div>

	<section id="rauchbier" class="tab-panel"></section>
	<section id="dunkles" class="tab-panel"></section>

	<!--===============================================================================================-->
	<script
		src="${pageContext.request.contextPath}/vendor/jquery/jquery-3.2.1.min.js"></script>
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