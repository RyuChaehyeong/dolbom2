<%--
  Created by IntelliJ IDEA.
  User: SAMSUNG
  Date: 2021-12-22
  Time: 오전 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>반려동물 돌봄</title>
</head>
<body>
돌봄 페이지
<a href="/login">로그인</a>
<form action="/logout" method="post">
    <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
    <button>로그아웃</button>
</form>
</body>
</html>
