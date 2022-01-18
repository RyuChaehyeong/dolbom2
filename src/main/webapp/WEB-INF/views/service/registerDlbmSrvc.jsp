<%--
  Created by IntelliJ IDEA.
  User: SAMSUNG
  Date: 2022-01-14
  Time: 오후 3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="${root }/resources/css/all.min.css" rel="stylesheet">
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>



<script>
$(document).ready(function (){
    //ajax 통신으로 codeVOList db 조회 해오기
});

</script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>돌봄 서비스 등록하기</title>
    <script src="${path}/resources/js/test.js"></script>
    <link rel="stylesheet" href="${path}/resources/css/style.css">
</head>

<body>
<jsp:include page="/resources/include/header.jsp" />
<div class="container">
    <jsp:include page="/resources/include/sidebar.jsp" />
    <div class="mainbox">
       <div class="title">
         <h4>서비스 등록하기</h4>
       </div>
        <div style="padding: 70px;">
            <form>
                <div class="mb-3">
                    <label for="srvcNm" class="form-label">서비스 이름</label>
                    <input type="text" class="form-control" id="srvcNm">
                </div>
                <div class="mb-3">
                    <label for="srvcDtl" class="form-label">서비스 상세</label>
                    <input type="text" class="form-control" id="srvcDtl">
                </div>

                <%--카테고리 코드, 주소, 로그인한 아이디--%>

                <div class="mb-3">
                    <select id="animalType" name="animalType">
                        <option value="">선택</option>
                        <c:forEach var="result" items="${codeVOList}">
                            <option value="${result.cdId}">${result.cdNm}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-3">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>
<jsp:include page="/resources/include/footer.jsp" />
</body>