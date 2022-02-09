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

    const result = '${result}';

    if (result == 'success') {
        alert("견적 요청 등록 완료");
    } else {
        alert("견적 요청 등록 실패 \n관리자에게 문의하세요.");
    }

</script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>견적 조회하기</title>
    <script src="${path}/resources/js/test.js"></script>
</head>

<body>
<div class="popup">
    <div class="title">
        <h4>견적 조회하기</h4>
    </div>


    <div class="content">
        <form name="reqRegisterForm">
            <div class="formGroup">
                <input type="text" class="form-control" name="srvcId" value='<c:out value="${req.srvcId}" />' hidden/>
                <input type="text" class="form-control" name="custId" value='<c:out value="${req.custId}"/>' hidden>

                <div class="input-group mb-3">
                    <span class="input-group-text" id="srvcNm">서비스이름</span>
                    <input type="text" class="form-control" name="srvcNm" value='<c:out value="${srvcNm}"/>' readonly ='readonly'/>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="reqTitle">요청서 제목</span>
                    <input type="text" class="form-control" name="reqTitle"  value='<c:out value="${req.reqTitle}"/>' readonly ='readonly'>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" >우편번호</span>
                    <input type="text" class="form-control" name="postcode" id="postcode" value='<c:out value="${req.postcode}"/>' readonly ='readonly'>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" >주소</span>
                    <input type="text" class="form-control" name="custLoc" id="custLoc" value='<c:out value="${req.custLoc}"/>' readonly ='readonly'>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" >상세주소</span>
                    <input type="text" class="form-control" name="detailAddress" id="detailAddress" value='<c:out value="${req.detailAddress}"/>' readonly ='readonly'>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text" id="startDt">시작날짜</span>
                    <input type="text" class="form-control" name="startDt" value='<c:out value="${req.startDt}"/>' readonly ='readonly'>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="endDt">종료날짜</span>
                    <input type="text" class="form-control" name="endDt" value='<c:out value="${req.endDt}"/>' readonly ='readonly'>
                </div>
                <div class="input-group">
                    <span class="input-group-text">요청상세</span>
                    <textarea class="form-control" id="reqDtl" name="reqDtl" readonly ='readonly'><c:out value="${req.reqDtl}"/></textarea>
                </div>


            </div>
            <form>
    </div>
</div>

</body>