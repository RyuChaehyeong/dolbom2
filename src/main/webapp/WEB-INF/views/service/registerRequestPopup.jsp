<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="${root }/resources/css/style.css" rel="stylesheet">
<script>
    $(document).ready(function (){

    });

</script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>견적 요청하기</title>
    <script src="${path}/resources/js/test.js"></script>
</head>

<body>
    <div class="popup">
        <div class="title">
            <h4>견적 요청하기</h4>
        </div>
        <div class="content">
            <div class="formGroup">

                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon2">돌봄이ID</span>
                    <input type="text" class="form-control" name="dlbmId">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon3">동물-품종</span>
                    <input type="text" class="form-control" name="dlbmId">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon4">돌봄 지역</span>
                    <input type="text" class="form-control" name="dlbmLoc">
                </div>
                <div class="input-group">
                    <span class="input-group-text">서비스 상세</span>
                    <textarea class="form-control" ></textarea>
                </div>

            </div>
        </div>
    </div>

</body>