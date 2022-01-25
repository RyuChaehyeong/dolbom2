<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="${root }/resources/css/style.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>



<script>
    $(document).ready(function (){

    });




</script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>돌봄 서비스 조회하기</title>
    <script src="${path}/resources/js/test.js"></script>
    <link rel="stylesheet" href="${path}/resources/css/style.css">
</head>

<body>
<jsp:include page="/resources/include/header.jsp" />
<div class="container">
    <jsp:include page="/resources/include/sidebar.jsp" />
    <div class="mainbox">
        <div class="title">
            <h4>서비스 상세 조회하기</h4>
        </div>
        <div style="padding: 70px;">

        </div>
    </div>
</div>
<jsp:include page="/resources/include/footer.jsp" />
</body>