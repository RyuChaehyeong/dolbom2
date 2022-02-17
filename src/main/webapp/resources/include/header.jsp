<%--
  Created by IntelliJ IDEA.
  User: SAMSUNG
  Date: 2022-01-15
  Time: 오후 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link href="${root }/resources/css/style.css" rel="stylesheet">
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <div class="header">

        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <a href="${root }/" target="_blank"><img src="${root }/resources/image/logo.jpg" class="logoPic" /></a>
            <div class="collapse navbar-collapse">
               <ul class="navbar-nav mr-auto mt-2 mt-lg-0">

                   <sec:authorize access="isAnonymous()">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="${root }/login">로그인</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="${root }/member/register">회원가입</a>
                        </li>
                   </sec:authorize>
                   <sec:authorize access="isAuthenticated()">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="${root }/logout">로그아웃</a>
                        </li>
                   </sec:authorize>

                    <sec:authorize access="hasAnyRole('ROLE_DLBM')">
                        <li class="nav-item">
                            <a class="nav-link" href="${root }/dlbm/registerForm">서비스등록</a>
                        </li>
                    </sec:authorize>

                        <li class="nav-item">
                            <a class="nav-link" href="${root }/dlbm/getList">서비스목록</a>
                        </li>

                   <sec:authorize access="isAuthenticated()">
                        <li class="nav-item">
                            <sec:authentication property="principal" var="principal"/>
                            <sec:authorize access="hasAnyRole('ROLE_DLBM')">
                                <a class="nav-link" href="${root }/mypage/info?userId=${principal.username}&auth=DLBM">마이페이지</a>
                            </sec:authorize>
                            <sec:authorize access="hasAnyRole('ROLE_CUSTOMER')">
                                <a class="nav-link" href="${root }/mypage/info?userId=${principal.username}&auth=CUST">마이페이지</a>
                            </sec:authorize>
                        </li>
                   </sec:authorize>
                </ul>
            </div>
        </nav>

    </div>
