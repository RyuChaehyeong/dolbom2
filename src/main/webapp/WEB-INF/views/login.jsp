<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>로그인 페이지</title>
</head>
<body>
<h1>로그인</h1>
<h2><c:out value="${error }"/></h2>
<h2><c:out value="${logout }"/></h2>
<div class="container">
    <form action="/login" method="post">
        <div class="form-group">
            아이디 <input type="text" name="username" class="form-control" />
        </div>
        <div class="form-group">
            비밀번호 <input type="password" name="password" class="form-control" />
        </div>

        <div>
            <button id="loginBtn" type="submit">로그인</button>
        </div>

        <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
    </form>
</div>
</body>
</html>