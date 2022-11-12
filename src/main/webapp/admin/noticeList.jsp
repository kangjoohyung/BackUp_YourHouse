<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</head>
<body>
 <jsp:include page="header.jsp"/>
 <div style="height:600px; margin-top:20px; margin-bottom:30px " >
  <table class="table table-hover container">
        <thead>
          <tr>             
            <th>공지 코드</th>
            <th>카테 고리</th>
            <th>공지 제목</th>
            <th>등록일 </th>
          </tr>
         </thead>
        <tbody>
         
        </tbody>
      </table>
    </div>


<jsp:include page="footer.jsp"/>
</body>
</html>