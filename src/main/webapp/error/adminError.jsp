<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<script src="/controller/resources/js/jquery.form.min.js"></script>


<div class="container">
	<div class="col-lg-8 col-lg-offset-2 text-center">
		<div class="logo">
			<h1>Admin Error Page</h1>
		</div>
		<p class="lead text-muted">${errorMsg} </p>
		<div class="clearfix"></div>
		<br />
		<c:choose>
		  <c:when test="${empty loginAdmin}">
		      <div class="col-lg-6  col-lg-offset-3">
			<div class="btn-group btn-group-justified">
				<a href="${pageContext.request.contextPath}/admin/adminlogin.jsp" class="btn btn-primary">login</a>
				<a href="${pageContext.request.contextPath}" class="btn btn-success">index</a>
				<a href="javascript:history.back()" class="btn btn-success">back</a>
			</div>

		    </div>
		  </c:when>
		  <c:otherwise>
		      <div class="col-lg-6  col-lg-offset-3">
			<div class="btn-group btn-group-justified">
				<a href="javascript:history.back()" class="btn btn-primary">back</a>
				<a href="${pageContext.request.contextPath}" class="btn btn-success">index</a>
			</div>
		</div>
		  </c:otherwise>
		</c:choose>	
	</div>
</div>