<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>


<script>

    function openPopup() {
        window.open(
            '/request/registerRequestPopup?srvcId=${srvc.srvcId}',
            'window_name',
            'width=800,height=600,location=no,status=no,scrollbars=yes');
    }

</script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>로그인</title>
    <script src="${path}/resources/js/test.js"></script>
</head>

<body>
<jsp:include page="/resources/include/header.jsp" />
<div class="container">
    <jsp:include page="/resources/include/sidebar.jsp" />
    <div class="mainbox">

        <div class="title">

            <h4>로그인</h4>
        </div>
        <div class="content">
            <form action="/login" method="post" style="width: 400px; margin-left: 230px; padding: 80px 0px;">
                <div class="form-group">
                    아이디 <input type="text" name="username" class="form-control" />
                </div>
                <div class="form-group">
                    비밀번호 <input type="password" name="password" class="form-control" />
                </div>
                <div id="rememberCheck">
                    <input type="checkbox" name="remember-me"> 자동로그인
                </div>

                <button id="loginBtn" type="submit" class="gap-2 col-6 mx-auto btn btn-primary">로그인</button>

                <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
            </form>
        </div>

    </div>
</div>
<jsp:include page="/resources/include/footer.jsp" />
</body>