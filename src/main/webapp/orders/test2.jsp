<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript" src="../js/jquery-3.6.1.js"></script>
<script>
	$(function() {
		$("button").click(function() {
			 var IMP = window.IMP; 
			    IMP.init('imp27370044');
			    IMP.request_pay({
			    	pg : "kakaopay", 
			        pay_method : 'card',
			        merchant_uid : 'merchant_' + new Date().getTime(),
			        name : '상품명',
			        amount : 2,	//총판매가격
			        buyer_email : 'soso_hae1994@nave.com',
			        buyer_name : '해원이',
			        buyer_tel : '01036943233',
			        buyer_addr : '경기도 성남시',
			        buyer_postcode : '경기도',
			        m_redirect_url : 'index.jsp'
			    }, function(rsp) {
			        if ( rsp.success ) {
			            var msg = '결제가 완료되었습니다.';
			            
			            $.ajax({
			            	type : "post",
			            	url : "../ajax",
			            	data : {
			            		methodName : 'insert',
			            		key : 'order',
			            		totalPrice : 5000,
			            		orderAdrss : '성남시',
			            	},
			            	success:function(result){
			            		alert(result);
			            	},
			            	error:function(err){
			            		alert(err);
			            	}
			            });
			        } else {
			            var msg = '결제에 실패하였습니다.';
			            rsp.error_msg;
			        }
			    });
		});
	});
</script>
</head>
<body>
		<button>결제하기</button>
</body>
</html>