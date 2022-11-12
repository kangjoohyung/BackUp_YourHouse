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
		function pay() {
			var IMP = window.IMP; 
		    IMP.init('imp27370044');
		    IMP.request_pay({
		    	pg : "kakaopay", 
		        pay_method : 'card',
		        merchant_uid : 'merchant_' + new Date().getTime(),
		        name : '결제',
		        amount : '2',
		        buyer_email : '${loginUser.email}',
		        buyer_name : '${loginUser.nickname}',
		        buyer_tel : '${loginUser.phone}',
		        buyer_addr : '${loginUser.adress}',
		        buyer_postcode : '${loginUser.adress}',
		        m_redirect_url : 'index.jsp'
		    }, function(rsp) {
		        if ( rsp.success ) {
		            var msg = '결제가 완료되었습니다.';
		            location.href='../index.jsp';
		        } else {
		            var msg = '결제에 실패하였습니다.';
		            rsp.error_msg;
		        }
		    });
		}
		pay();
	});
</script>
</head>
<body>
		<button>결제하기</button>
</body>
</html>