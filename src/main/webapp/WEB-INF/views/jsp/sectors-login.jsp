<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login Page</title>
</head>
<body>
		 <form method="POST" action="${pageContext.request.contextPath}/login1">
                    <center><h1>Đăng nhập vào website</h1></center>
                    <div class="input-box">
                        <i ></i>
                        <input type="text" placeholder="Nhập username" name="userName" value="${user.userName}">
                    </div>
                    <div class="input-box">
                        <i ></i>
                        <input type="password" placeholder="Nhập mật khẩu" name="password" value="${user.password}">
                    </div>
                    <div class="btn-box">
                        <button type="submit">
                            Đăng nhập
                        </button>
                         <p style="color: red;">${errorString}</p>
                    </div>
         </form>
</body>
</html>