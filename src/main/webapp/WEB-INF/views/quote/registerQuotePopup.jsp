<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="${root }/resources/css/style.css" rel="stylesheet">
<script>




</script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>견적 요청하기</title>
    <script src="${path}/resources/js/common.js"></script>
</head>

<body>
    <div class="popup">
        <div class="title">
            <h4>견적 요청하기</h4>
        </div>


        <div class="content">
            <form name="reqRegisterForm" action="${root }/quote/register" method="post" onsubmit="return validateQuoForm()">
                <div class="formGroup">
                    <input type="text" class="form-control" name="srvcId" value='<c:out value="${param.srvcId}" />' hidden />
                    <input type="text" class="form-control" name="extraAddress" id="extraAddress" hidden >
                    <input type="text" class="form-control" name="custId" value='<sec:authentication property="principal.username"/>' hidden >

                    <div class="input-group mb-3">
                        <span class="input-group-text" >서비스이름</span>
                        <input type="text" class="form-control" name="srvcNm" id="srvcNm" value='<c:out value="${srvcNm}" />' readonly ='readonly'/>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" >요청서 제목</span>
                        <input type="text" class="form-control" name="reqTitle" id="reqTitle">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" >우편번호</span>
                        <input type="text" class="form-control" name="postcode" id="postcode">
                        <button onclick="selectPostcode()" type="button" >우편번호 찾기</button>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" >주소</span>
                        <input type="text" class="form-control" name="custLoc" id="loc">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" >상세주소</span>
                        <input type="text" class="form-control" name="detailAddress" id="detailAddress">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">시작날짜</span>
                        <input type="date" class="form-control" name="startDt" id="startDt" onchange="validateStartDt(this)">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">종료날짜</span>
                        <input type="date" class="form-control" name="endDt" id="endDt" onchange="validateEndDt(this)">
                    </div>
                    <div class="input-group">
                        <span class="input-group-text">요청상세</span>
                        <textarea class="form-control" id="reqDtl" name="reqDtl"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary" id="reqButton" style="margin-top: 10px">견적 보내기</button>


                </div>
            <form>
        </div>
    </div>

</body>