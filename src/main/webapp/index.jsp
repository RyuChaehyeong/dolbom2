<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

<sec:authorize access="isAnonymous()">
    <a href="${root }/login">로그인</a>
</sec:authorize>


<sec:authorize access="isAuthenticated()">
    <form action="${root }/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
        <button>로그아웃</button>
    </form>
</sec:authorize>
<div>
    <a href="${root }/service/registerDlbmSrvc">돌봄서비스 등록하기</a>
</div>
</body>
</html>
