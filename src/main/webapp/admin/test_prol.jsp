<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.min.js"></script>
<script type="text/javascript" src="js/jquery.form.min.js"></script>
<script>
//////////////////////////////////////////////////

$(document).ready(function(){
	// 라디오버튼 클릭시 이벤트 발생
	$("input:radio[name=range]").click(function(){

		if($("input[name=range]:checked").val() == "0"){
			// 텍스트,셀렉트 비활성화
			$("input:text[name=productCode]").attr("disabled",true);
			$("select:[name=categoryCode]").attr("disabled",true);
		} else if($("input[name=range]:checked").val() == "1"){
			// 텍스트 비활성화/ 셀렉트 활성화
			$("input:text[name=productCode]").attr("disabled",true);
			$("select:[name=categoryCode]").attr("disabled",false);
		} else if($("input[name=range]:checked").val() == "2"){
			// 텍스트 비활성화/ 셀렉트 활성화
			$("input:text[name=productCode]").attr("disabled",false);
			$("select:[name=categoryCode]").attr("disabled",true);
		}
	});
});

//////////////////////////////////////////////////
</script>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</head>

<jsp:include page="header.jsp"/>
<body>
----------------------------------------------------------------------------
<form>
<div style="width:200px;">
  &nbsp;&nbsp;<h2>정산, 통계 조회 범위</h2>
  &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="range" id="r1" value="0"><label for="r1">매출정산</label>
&nbsp;&nbsp;&nbsp;
  <input type="radio" name="range" id="r2" value="1" checked><label for="r2">카테고리 선택</label>
     <div class="form-floating">
         <select class="form-select" name="categoryCode" id="floatingSelect"    aria-label="Floating label select example" style="height:40px; width:220px; "> 
          <c:forEach items="${categoryList}" var="cat">
             <option value="${cat.categoryCode}"> ${cat.categoryName} </option> 
          </c:forEach> 
        </select>
       </div>&nbsp;&nbsp;&nbsp;
  <input type="radio" name="range" id="r3" value="2" checked><label for="r3">상품번호(숫자)입력</label>
      <input type="text" name="productCode">
</div>
<div style="width:200px;">
</div>
<input type="submit" value="조회하기"></input>
</form>
----------------------------------------------------------------------------
  <div style="height:600px; margin-top:20px; margin-bottom:30px " >
  <table class="table table-hover container">
        <thead>
          <tr>             
            <th>상품 카테고리</th>
            <th>상품코드</th>
            <th>상품명</th>
            <th>등록일</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Rahul</td>
            <td>Tyagi</td>
            <td>rahul.1992.tyagi@gmail.com</td>
            <td>70</td>
          </tr>
        </tbody>
      </table>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>