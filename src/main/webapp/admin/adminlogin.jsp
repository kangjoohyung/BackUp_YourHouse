<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="jumbotron">
	<h1>Admin Login</h1>
</div>
<c:choose>
	<c:when test="${empty loginAdmin}">
		<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/front">
			<input type="hidden" name="key" value = "admin" /> <!-- Controller를 찾는 정보 -->
			<input type="hidden" name="methodName" value = "adminlogin" />  <!-- 메소드이름 -->
			<fieldset>
				<legend>Admin Login</legend>
				<div class="form-group">
					<label for="adminId" class="col-lg-2 control-label">adminId</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="adminId" name="email"
							placeholder="adminId">
					</div>
				</div>
				<div class="form-group">
					<label for="adminPwd" class="col-lg-2 control-label">adminPwd</label>
					.<div class="col-lg-10">
						<input type="password" class="form-control" id="adminPwd" name="password"
							placeholder="adminPwd">
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-10 col-lg-offset-2">
						<button type="submit" class="btn btn-primary">Submit</button>
						<button class="btn btn-default">Cancel</button>
					</div>
				</div>
			</fieldset>
		</form>
	</c:when>
</c:choose>
