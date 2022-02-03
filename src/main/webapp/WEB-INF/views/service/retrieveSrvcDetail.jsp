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
    $(document).ready(function (){

    });


</script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>돌봄 서비스 상세 조회하기</title>
    <script src="${path}/resources/js/test.js"></script>
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
            <div class="form-group">
                <label></label> <input class="form-control" name="srvcId"
                    value='<c:out value="${srvc.srvcId}" />' readonly = "readonly"/>
            </div>
            <div class="form-group">
                <label></label> <input class="form-control" name="srvcNm"
                                       value='<c:out value="${srvc.srvcNm}" />' readonly = "readonly"/>
            </div>
            <div class="form-group">
                <label></label> <input class="form-control" name="dlbmId"
                                       value='<c:out value="${srvc.dlbmId}" />' readonly = "readonly"/>
            </div>
            <div class="form-group">
                <label></label> <input class="form-control" name="dlbmLoc"
                                       value='<c:out value="${srvc.dlbmLoc}" />' readonly = "readonly"/>
            </div>
            <div class="form-group">
                <label></label> <input class="form-control" name="srvcDtl"
                                       value='<c:out value="${srvc.srvcDtl}" />' readonly = "readonly"/>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/resources/include/footer.jsp" />
</body>