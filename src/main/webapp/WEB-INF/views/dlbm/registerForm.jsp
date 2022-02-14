
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

<script>
$(document).ready(function (){

});

</script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>돌봄 서비스 등록하기</title>
    <script src="${path}/resources/js/common.js"></script>
</head>

<body>
<jsp:include page="/resources/include/header.jsp" />
<div class="container">
    <jsp:include page="/resources/include/sidebar.jsp" />
    <div class="mainbox">
       <div class="title">
         <h4>서비스 등록하기</h4>
       </div>
        <div class="content">
            <form name="dlbmRegForm" action="${root }/dlbm/register" method="post" onsubmit="return validateDlbmForm()">
                <div class="formGroup">
                    <input type="text" class="form-control" name="srvcId" value='<c:out value="${param.srvcId}" />' hidden />
                    <input type="text" class="form-control" name="extraAddress" id="extraAddress" hidden >
                    <input type="text" class="form-control" name="dlbmId" value='<sec:authentication property="principal.username"/>' hidden >
                    <input type="text" class="form-control" name="lastModifiedBy" value='<sec:authentication property="principal.username"/>' hidden >
                    <div class="input-group mb-3">
                        <span class="input-group-text" >서비스이름</span>
                        <input type="text" class="form-control" name="srvcNm" id="srvcNm" />
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text" >우편번호</span>
                        <input type="text" class="form-control" name="postcode" id="postcode">
                        <button onclick="selectPostcode()" type="button" >우편번호 찾기</button>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" >주소</span>
                        <input type="text" class="form-control" name="dlbmLoc" id="loc">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" >상세주소</span>
                        <input type="text" class="form-control" name="detailAddress" id="detailAddress">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" >동물 분류</span>
                        <select class="form-select" aria-label="Default select example" id="animalCtgrCd" name="animalCtgrCd" style="width: 700px">
                            <option selected>동물분류 선택</option>
                            <option value="A01">강아지</option>
                            <option value="A02">고양이</option>
                            <option value="A03">새</option>
                        </select>
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text" >종 분류</span>
                        <select class="form-select" aria-label="Default select example" id="breedCtgrCd" name="breedCtgrCd" style="width: 700px">
                            <option selected>종 선택</option>
                            <option value="01">푸들</option>
                            <option value="02">시츄</option>
                            <option value="03">불독</option>
                            <option value="04">비글</option>
                            <option value="05">포메라니안</option>
                        </select>
                    </div>

                    <div class="input-group">
                        <span class="input-group-text">서비스 상세</span>
                        <textarea class="form-control" id="srvcDtl" name="srvcDtl"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary" id="reqButton" style="margin-top: 10px">견적 보내기</button>
    </div>
</div>
<jsp:include page="/resources/include/footer.jsp" />
</body>