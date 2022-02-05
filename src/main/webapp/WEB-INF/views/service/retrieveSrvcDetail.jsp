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
        '/service/registerRequestPopup?srvcId=${srvc.srvcId}',
        'window_name',
        'width=800,height=600,location=no,status=no,scrollbars=yes');
}

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
        <div class="content">
            <div class="formGroup">
                <div class="form-group">
                    <input class="form-control" name="srvcId" value='<c:out value="${srvc.srvcId}" />' readonly = "readonly" hidden/>
                </div>
                <div style="margin-bottom: 30px; margin-left: 10px; font-weight: bold">
                    <h3><c:out value="${srvc.srvcNm}"/></h3>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon1">별점</span>
                    <input type="text" class="form-control" name="rate"
                           value='<c:out value="${srvc.rate}" />' readonly = "readonly">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon2">돌봄이ID</span>
                    <input type="text" class="form-control" name="dlbmId"
                           value='<c:out value="${srvc.dlbmId}" />' readonly = "readonly">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon3">동물 - 품종</span>
                    <input type="text" class="form-control" name="dlbmId"
                           value='<c:out value="${srvc.animalCtgrCd}" /> - <c:out value="${srvc.breedCtgrCd}" />' readonly = "readonly">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon4">돌봄 지역</span>
                    <input type="text" class="form-control" name="dlbmLoc"
                           value='<c:out value="${srvc.dlbmLoc}" />' readonly = "readonly">
                </div>
                <div class="input-group">
                    <span class="input-group-text">서비스 상세</span>
                    <textarea class="form-control" readonly="readonly"><c:out value="${srvc.srvcDtl}" /></textarea>
                </div>

            </div>
        </div>
        <button onclick="openPopup()" class="gap-2 col-6 mx-auto btn btn-primary" type="button"  id="reqButton">견적 요청</button>
    </div>
</div>
<jsp:include page="/resources/include/footer.jsp" />
</body>