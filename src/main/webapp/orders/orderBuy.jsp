<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="icon" type="image/svc" href="${pageContext.request.contextPath}/images/icons/favicon.png"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pay.css">

<style type="text/css">
.label-cbx {
  user-select: none;
  cursor: pointer;
  margin-bottom: 0;
}
.label-cbx input:checked + .checkbox {
  border-color: #043794;
}
.label-cbx input:checked + .checkbox svg path {
  fill: #043794;
}
.label-cbx input:checked + .checkbox svg polyline {
  stroke-dashoffset: 0;
}
.label-cbx:hover .checkbox svg path {
  stroke-dashoffset: 0;
}
.label-cbx .checkbox {
  position: relative;
  top: 2px;
  float: left;
  margin-right: 8px;
  width: 20px;
  height: 20px;
  border: 2px solid #fbe444;
  border-radius: 3px;
}
.label-cbx .checkbox svg {
  position: absolute;
  top: -2px;
  left: -2px;
}
.label-cbx .checkbox svg path {
  fill: none;
  stroke: #fbe444;
  stroke-width: 2;
  stroke-linecap: round;
  stroke-linejoin: round;
  stroke-dasharray: 71px;
  stroke-dashoffset: 71px;
  transition: all 0.6s ease;
}
.label-cbx .checkbox svg polyline {
  fill: none;
  stroke: #FFF;
  stroke-width: 2;
  stroke-linecap: round;
  stroke-linejoin: round;
  stroke-dasharray: 18px;
  stroke-dashoffset: 18px;
  transition: all 0.3s ease;
}
.label-cbx > span {
  pointer-events: none;
  vertical-align: middle;
}

.cntr {

  top: 45%;
  left: 0;
  width: 100%;
  text-align: center;
}

.invisible {
 
  z-index: -1;
  width: 0;
  height: 0;
  opacity: 0;
}

.wwbppf {
	font-size: 28px;
	font-weight: bold;
	padding-top: 30px;
	font-family: LotteHappy_Medium;
	color: #043794;
}


.order_title {
	margin: 30px 0px 10px 0px;
	border-bottom: 1px solid #bebebe;
	padding-bottom: 5px;
}

form {
font-family: SCDream4;
}	

</style>

</head>

<body>

<form>
<div class="container">
	<div class="row">
		<div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
			<div class="m-l-25 m-r--38 m-lr-0-xl">					
				<div class="wwbppf">주문/결제</div>		
				<!-- 배송지 -->
				<section class="addr_default">
					<div style="display: block;">
						<div class="order_title">배송지</div>											
						<div class="user_name" style="padding-bottom: 10px;">					
							<div style="float: left; margin-right: 10px;">받는 사람</div>
							<input class="deftext" type="text" name="buy_name" placeholder="이름"
							style="border: 1px solid #ededed; padding-left: 5px; display: inline-block;">
						</div>	
						<div class="user_addr" style="padding-bottom: 10px;">					
							<div style="float: left; margin-right: 37px;">주소</div>
							<input class="deftext_addr1" type="text" name="buy_name" placeholder="기본주소" maxlength="20">
							
						</div>	
						<!-- <div class="give_name" style="padding-bottom: 10px;">					
							<div style="float: left; margin-right: 10px;">받는사람</div>
							<input class="deftext" type="text" name="buy_name" placeholder="받는 사람"
							style="border: 1px solid #ededed; padding-left: 5px; display: inline-block;">
						</div> -->
					</div>
				</section>
					
				<!-- 주문자 -->
				<hr>					
				<section class="user_info">
					<div style="display: block;">
						<div class="order_title">주문자</div>											
						<div class="user_name" style="padding: 10px 0px 20px 0px;">					
							<div style="float: left; margin-right: 40px; padding: 2.2px 0px">이름</div>
							<input class="deftext" type="text" name="buy_name" placeholder="이름"
							style="border: 1px solid #ededed; padding: 2px 5px; display: inline-block;">
						</div>	
						<div class="user_addr" style="padding: 10px 0px 20px 0px;">					
							<div style="float: left; margin-right: 28px; padding: 2.2px 0px">이메일</div>
							<input class="deftext" type="text" name="user_addr" placeholder="이메일"
							style="border: 1px solid #ededed; padding: 2px 5px; display: inline-block;">
						</div>
						<div class="give_name" style="padding: 10px 0px 20px 0px;">					
							<div style="float: left; margin-right: 14px; padding: 2.2px 0px">휴대전화</div>
							<input class="deftext" type="text" name="buy_name" placeholder="휴대전화"
							style="border: 1px solid #ededed; padding: 2px 5px; display: inline-block;">
						</div>	
					</div>
				</section>
					<hr>

				<!--주문상품정보-->
				<section class="order_product">
					<div class="order_title">주문 상품</div>
				<div class="order_product_wrap">
					<div class="user_orders">
						<div class="product_thumb" style="float: left; width: 150px; hight:150px;">
							<picture style="argin-right: 50px;">
								<img src="${pageContext.request.contextPath}/images/product-06.jpg" alt="My Image" style="width: 100px; height:100px;">
							</picture>
						</div>
					</div>
					<div class="user_product">
						<ul>
							<li style="font-size: 14px; padding:10px 0px;">상품명</li>
							<li style="list-style: none; font-size: 14px; padding-bottom: 10px;">색상정보</li>
						</ul>
						<div style="float: left; display: flex; font-size: 14px; color: ">
							<span>가격</span>
							<span style="padding: 0px 10px;">|</span>
							<span>0개</span>
						</div>
					</div>
					
				</div>
			</section>
				<hr>

				<section class="orderBuy">
					<div class="userPay">
						<div class="order_title">결제수단</div>											
							<div>
								<button type="button" class="kakaopay">
								<div class="pay_btn"">
								<img alt="카카오페이결제" src="${pageContext.request.contextPath}/images/icons/kakaopay_ci.png" 
								style="width: 12%; float: left;">
								</button>
								<form>
								<div class="cntr">
								    <label for="cbx" class="label-cbx">
								      <input id="cbx" type="checkbox" class="invisible">
								      <div class="checkbox">
								        <svg width="20px" height="20px" viewBox="0 0 20 20">
								          <path d="M3,1 L17,1 L17,1 C18.1045695,1 19,1.8954305 19,3 L19,17 L19,17 C19,18.1045695 18.1045695,19 17,19 L3,19 L3,19 C1.8954305,19 1,18.1045695 1,17 L1,3 L1,3 C1,1.8954305 1.8954305,1 3,1 Z"></path>
								          <polyline points="4 11 8 15 16 6"></polyline>
								        </svg>
								      </div>
								      <span style="float: left; font-family: SCDream5">카카오페이</span>
								    </label>
								  </div>
								</form>
								</div>								
							</div>	
						</div>		
					</section>	
				</div>
			</div>
		</div>


	<!-- 주문 결제 영역 -->
	<div class="col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">
					<div class="bor10 p-lr-40 p-t-30 p-b-40 m-l-63 m-r-40 m-lr-0-xl p-lr-15-sm">
						<h4 class="mtext-109 cl2 p-b-30">
							결제금액
						</h4>

						<div class="flex-w flex-t bor12 p-b-13">
							<div class="size-208">
								<span class="stext-110 cl2">
									총 상품금액:
								</span>
							</div>

							<div class="size-209">
								<span class="mtext-110 cl2">
									35,700 원
								</span>
							</div>
						</div>

						

						<div class="flex-w flex-t p-t-27 p-b-33">
							<div class="size_font" style="font-family: SCDream6;">
								<div class="paytext" style="font-family: SCDream6; font-size: 18px; color: #000;">
									최종 결제 금액: 
								</div>
								<div class="paytext" style="font-family: SCDream4; color: #000;">
									<b style="font-family: SCDream6; color: #0f42e9; font-size: 20px;">35,700</b>원
								</div>
							</div>
							
						</div>

						<button class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer"
						style="font-family: SCDream4; font-size: 18px;">
							결제하기
						</button>
					</div>
				</div>
		

</form>
</body>
</html>
<jsp:include page="../common/footer.jsp"/>