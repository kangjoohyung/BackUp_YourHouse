<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.6.1.js"></script>
<script type="text/javascript">
	$(function() {
		$(".btn").click(function() {
			let art = "#"+$(this).val();
			
			$.ajax({
				url : "../ajax", // 서버의 주소
				type : "get", // 요청방식(method방식 = post, get, put, delete 등등)
				dataType : "text", // 서버가 보내온 데이터타입(디폴트 text, html, xml, json)
				data : {
					productCode : $(this).val(),
					key : $("#key").val(),
					methodName : $("#methodName").val()
				}, // 서버에게 보낼 parameter 정보
				success : function(result) {
					if(result=="0") {
						$("#all").remove();
						$("body").text("장바구니에 상품이 없습니다");
					} else {
						$(art).remove();
					}
				},
				error : function(err) {
					// 서버의 요청결과가 실패했을 때 콜백함수	
				}
			});
		});
	});
</script>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.loginUser == null}">
			회원전용 화면입니다
		</c:when>
		<c:otherwise>
			<div>
				<input type="checkbox"> 모두선택
			</div>
			<ul>
				<c:choose>
					<c:when test="${sessionScope.basketMap==null}">
						장바구니에 상품이 없습니다
					</c:when>
					<c:otherwise>
						<input type="hidden" id="key" value="basket">
						<input type="hidden" id="methodName" value="delete">
						<c:forEach items="${sessionScope.basketMap}" var="map">
							<li id="all">
								<ul>
									<li id="${map.key}">
										<div>
											<h1>네가 사는 그집 배송</h1>
											<input type="checkbox"> <a href="#">
												<div>
													<img alt="${map.key}" src="">
												</div>
												<div>${map.key}</div>
											</a>
											<button class="btn" value="${map.key}">X</button>
											<ul>
												<li>
													<div>
														<h2>${map.value.colorName}</h2>
														<button class="btn_option" value="${map.value.colorName}">X</button>
														<div>
															<select id="colorOption">
																<c:forEach var="i" begin="1" end="9">
																	<option value="${i}">${i}</option>
																</c:forEach>
															</select>
														</div>
														<div id="totaltext"></div>
													</div>
												</li>
											</ul>
										</div>
									</li>
								</ul>
							</li>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</ul>
		</c:otherwise>
	</c:choose>
	<a href="../orders/orders.jsp">결제하기</a>
</body>
</html>