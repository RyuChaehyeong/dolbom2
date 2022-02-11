<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

const regiResult = '${regiResult}';
const modiResult = '${modiResult}';
const insertPriceResult = '${insertPriceResult}';

if (regiResult != '' && regiResult == 'success') {
    alert("견적 요청 등록 완료");
}
if (regiResult != '' && regiResult != 'success') {
    alert("견적 요청 등록 실패 \n관리자에게 문의하세요.");
}

if (modiResult != '' && modiResult == 'success') {
    alert("견적 요청 수정 완료");
}
if (modiResult != '' && modiResult != 'success'){
    alert("견적 요청 수정 실패 \n관리자에게 문의하세요.");
}
if (insertPriceResult != '' && insertPriceResult == 'success') {
    alert("견적 금액 등록 완료");
}
if (insertPriceResult != '' && insertPriceResult != 'success'){
    alert("견적 금액 등록 실패 \n관리자에게 문의하세요.");
}

function modify() {
    $('#reqTitle').attr('readonly', false);
    $('#postcode').attr('readonly', false);
    $('#custLoc').attr('readonly', false);
    $('#detailAddress').attr('readonly', false);
    $('#startDt').attr('readonly', false);
    $('#endDt').attr('readonly', false);
    $('#reqDtl').attr('readonly', false);
    $('#modiDelBtn').attr('hidden', true);
    $('#complModi').attr('hidden', false);
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
        <form name="reqRegisterForm" action="${root }/request/modifyRequest" method="post" onsubmit="return validateForm()">
            <div class="formGroup">
                <input type="text" class="form-control" name="reqId" value='<c:out value="${req.reqId}" />' hidden/>
                <input type="text" class="form-control" name="srvcId" value='<c:out value="${req.srvcId}" />' hidden/>
                <input type="text" class="form-control" name="custId" value='<c:out value="${req.custId}"/>' hidden>

                <div class="input-group mb-3">
                    <span class="input-group-text" id="srvcNm">서비스이름</span>
                    <input type="text" class="form-control" name="srvcNm" value='<c:out value="${srvcNm}"/>' readonly ='readonly'/>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">요청서 제목</span>
                    <input type="text" class="form-control" name="reqTitle" id="reqTitle"
                           value='<c:out value="${req.reqTitle}"/>' readonly ='readonly'>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">우편번호</span>
                    <input type="text" class="form-control" name="postcode" id="postcode"
                           value='<c:out value="${req.postcode}"/>' readonly ='readonly'>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">주소</span>
                    <input type="text" class="form-control" name="custLoc" id="custLoc"
                           value='<c:out value="${req.custLoc}"/>' readonly ='readonly'>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">상세주소</span>
                    <input type="text" class="form-control" name="detailAddress" id="detailAddress"
                           value='<c:out value="${req.detailAddress}"/>' readonly ='readonly'>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">시작날짜</span>
                    <input type="date" class="form-control" name="startDt" id="startDt" value='<fmt:formatDate value="${req.startDt}" pattern="yyyy-MM-dd"/>'
                         readonly ='readonly' onchange="validateStartDt(this)">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">종료날짜</span>
                    <input type="date" class="form-control" name="endDt" id="endDt" value='<fmt:formatDate value="${req.endDt}" pattern="yyyy-MM-dd"/>'
                          readonly ='readonly' onchange="validateEndDt(this)">
                </div>
                <div class="input-group">
                    <span class="input-group-text">요청상세</span>
                    <textarea class="form-control" name="reqDtl" id="reqDtl" readonly ='readonly'><c:out value="${req.reqDtl}"/></textarea>
                </div>

                <c:if test="${req.reqPrgrStatCd == 10}">
                    <div id="modiDelBtn">
                        <button type="button" class="btn btn-primary btn-sm" onclick="modify()">수정</button>
                        <button type="button" class="btn btn-secondary btn-sm">삭제</button>
                    </div>
                </c:if>
                <button type="submit" class="btn btn-primary btn-sm" id="complModi" style="margin-top: 10px" hidden>수정 완료</button>

                <c:if test="${req.reqPrgrStatCd >= 30}">
                    <div class="input-group mb-3" style="margin-top: 15px">
                        <span class="input-group-text">확정견적금액</span>
                        <input type="number" class="form-control" name="savedQuoPrice" id="savedQuoPrice" value='<c:out value="${req.quoPrice}"/>' readonly ='readonly' >
                    </div>
                </c:if>
            </div>
        </form>

        <c:if test="${req.reqPrgrStatCd == 20}">
            <form name="insertQuoPrice" action="${root }/request/insertQuoPrice" method="post">
                <input type="text" class="form-control" name="lastModifiedBy" value='<sec:authentication property="principal.username"/>' hidden>
                <input type="text" class="form-control" name="reqId" value='<c:out value="${req.reqId}" />' hidden/>
                    <div class="input-group mb-3" style="margin-top: 15px">
                        <span class="input-group-text">견적금액</span>
                        <input type="number" class="form-control" name="quoPrice" id="quoPrice">
                    </div>

                <button type="submit" class="btn btn-primary btn-sm" id="insertQuo" style="margin-top: 10px">견적금액 등록</button>
            </form>
        </c:if>
    </div>
</div>

</body>