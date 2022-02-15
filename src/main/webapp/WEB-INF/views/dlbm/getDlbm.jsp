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
const regiResult = '${regiResult}';

if (regiResult != '' && regiResult == 'success') {
    alert("돌봄 서비스 등록 완료");
}
if (regiResult != '' && regiResult != 'success') {
    alert("돌봄 서비스 등록 실패 \n관리자에게 문의하세요.");
}

function modify(){
    $('#srvcNmInput').attr('hidden', false);
    $('#animalCtgrCd').attr('disabled', false);
    $('#breedCtgrCd').attr('disabled', false);
    $('#postcdInput').attr('hidden', false);
    $('#loc').attr('readonly', false);
    $('#detailAddress').attr('readonly', false);
    $('#srvcDtl').attr('readonly', false);
    $('#modiDelBtn').attr('hidden', true);
    $('#complModi').attr('hidden', false);

}

function openPopup() {
    window.open(
        '/quote/registerForm?srvcId=${srvc.srvcId}',
        'window_name',
        'width=800,height=600,location=no,status=no,scrollbars=yes');
}

function modifyDlbm(){
    const srvcNm = $("#srvcNm").val();
    const animalCtgrCd = $("#animalCtgrCd").val();
    const breedCtgrCd = $("#breedCtgrCd").val();
    const postcode = $("#postcode").val();
    const loc = $("#loc").val();
    const detailAddress = $("#detailAddress").val();
    const srvcDtl = $("#srvcDtl").val();

    if (srvcNm == null || srvcNm == '') {
        alert("서비스 이름을 입력해주세요.");
        return false;
    }
    if (animalCtgrCd == null || animalCtgrCd == '') {
        alert("동물 종을 선택해주세요.");
        return false;
    }
    if (breedCtgrCd == null || breedCtgrCd == '') {
        alert("품종을 선택해주세요.");
        return false;
    }
    if (postcode == null || postcode == '') {
        alert("우편번호를 선택해주세요.");
        return false;
    }
    if (loc == null || loc == '') {
        alert("주소를 입력해주세요.");
        return false;
    }
    if (detailAddress == null || detailAddress == '') {
        alert("상세주소를 입력해주세요.");
        return false;
    }
    if (srvcDtl == null || srvcDtl == '') {
        alert("서비스 상세를 입력해주세요.");
        return false;
    }


    const paramData = {
        srvcId : $("#srvcId").val(),
        srvcNm : srvcNm,
        animalCtgrCd : animalCtgrCd,
        breedCtgrCd : breedCtgrCd,
        postcode : postcode,
        dlbmLoc : loc,
        detailAddress : detailAddress,
        srvcDtl :srvcDtl,
        lastModifiedBy : $("#lastModifiedBy").val()

    }

    const param = JSON.stringify(paramData);
    $.ajax({
        type : 'post',
        url : '/dlbm/modify',
        data : param,
        contentType : "application/json; charset=utf-8",
        success : function (result, status, xhr) {
            alert("수정이 완료되었습니다.");
            location.reload();
        },
        error : function (xhr, status, er) {
            if (error) {
                error(er);
            }
        }
    })
}


function delConfirm() {
    if (!confirm('해당 돌봄 서비스를 삭제하시겠습니까?')) {
        return false;
    } else {
        const paramData = {
            srvcId : $("#srvcId").val(),
            lastModifiedBy : $("#lastModifiedBy").val()
        }

        const param = JSON.stringify(paramData);
        $.ajax({
            type : 'post',
            url : '/dlbm/delete',
            data : param,
            contentType : "application/json; charset=utf-8",
            success : function (result, status, xhr) {
                alert("돌봄 서비스가 삭제되었습니다.");
                location.href = '/dlbm/getList';
            },
            error : function (xhr, status, er) {
                if (error) {
                    error(er);
                }
            }
        })
    }
}

</script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>돌봄 서비스 상세 조회하기</title>
    <script src="${path}/resources/js/common.js"></script>
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
                    <sec:authentication property="principal" var="principal"/>
                    <input class="form-control" id="srvcId" name="srvcId" value='<c:out value="${srvc.srvcId}" />' readonly = "readonly" hidden/>
                    <input type="text" class="form-control" id="dlbmId" name="dlbmId" value='<c:out value="${principal.username}"/>' hidden >
                    <input type="text" class="form-control" id="extraAddress" name="extraAddress" hidden >
                    <input type="text" class="form-control" id="lastModifiedBy" name="lastModifiedBy" value='<c:out value="${principal.username}"/>' hidden  >
                    <input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
                    <input type="hidden" name="pageNum" value='<c:out value="${cri.amount}"/>'>
                </div>
                <div style="margin-bottom: 30px; margin-left: 10px; font-weight: bold">
                    <h3><c:out value="${srvc.srvcNm}"/></h3>
                </div>
                <c:if test="${srvc.rate ne '' or null ne srvc.rate }">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="basic-addon1">별점</span>
                        <input type="text" class="form-control" name="rate"
                               value='<c:out value="${srvc.rate}" />' readonly = "readonly">
                    </div>
                </c:if>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon2">돌봄이ID</span>
                    <input type="text" class="form-control" name="dlbmId"
                           value='<c:out value="${srvc.dlbmId}" />' readonly = "readonly">
                </div>
                <div class="input-group mb-3" id="srvcNmInput" hidden>
                    <span class="input-group-text" >서비스이름</span>
                    <input type="text" class="form-control" value='<c:out value="${srvc.srvcNm}" />' name="srvcNm" id="srvcNm"/>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" >동물 분류</span>
                    <select class="form-select" disabled
                            id="animalCtgrCd" name="animalCtgrCd" style="width: 700px">
                        <option selected><c:out value="${srvc.animalCtgrCd}" /></option>
                        <option value="A01">강아지</option>
                        <option value="A02">고양이</option>
                        <option value="A03">새</option>
                    </select>
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text" >종 분류</span>
                    <select class="form-select" disabled
                            id="breedCtgrCd" name="breedCtgrCd" style="width: 700px">
                        <option selected><c:out value="${srvc.breedCtgrCd}" /></option>
                        <option value="01">푸들</option>
                        <option value="02">시츄</option>
                        <option value="03">불독</option>
                        <option value="04">비글</option>
                        <option value="05">포메라니안</option>
                    </select>
                </div>
                <div class="input-group mb-3" id="postcdInput" hidden>
                    <span class="input-group-text" >우편번호</span>
                    <input type="text" class="form-control" name="postcode" id="postcode">
                    <button onclick="selectPostcode()" type="button" >우편번호 찾기</button>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">돌봄회사 주소</span>
                    <input type="text" aria-label="dlbmLoc" class="form-control" name="dlbmLoc" id="loc" readonly = "readonly"
                           value='<c:out value="${srvc.dlbmLoc}" />'>
                    <input type="text" aria-label="detailedAddr" class="form-control" name="detailAddress" id="detailAddress" readonly = "readonly"
                           value='<c:out value="${srvc.detailAddress}" />'>
                </div>
                <div class="input-group">
                    <span class="input-group-text">서비스 상세</span>
                    <textarea class="form-control" readonly="readonly" name="srvcDtl" id="srvcDtl"><c:out value="${srvc.srvcDtl}" /></textarea>
                </div>

            </div>
        </div>
        <sec:authentication property="principal" var="principal"/>
        <c:if test="${srvc.dlbmId eq principal.username}">
            <div id="modiDelBtn">
                <button type="button" class="btn btn-primary btn-sm" id="modiBtn" onclick="modify()">수정</button>
                <button type="button" class="btn btn-secondary btn-sm" id="delBtn" onclick="delConfirm()">삭제</button>
            </div>
            <button type="submit" class="btn btn-primary btn-sm" id="complModi" style="margin-top: 10px" onclick="modifyDlbm()" hidden>수정 완료</button>
        </c:if>
            <sec:authorize access="hasRole('ROLE_CUSTOMER')">
                <button onclick="openPopup()" class="gap-2 col-6 mx-auto btn btn-primary" type="button"  id="reqButton">견적 요청</button>
            </sec:authorize>
    </div>
</div>
<jsp:include page="/resources/include/footer.jsp" />
</body>