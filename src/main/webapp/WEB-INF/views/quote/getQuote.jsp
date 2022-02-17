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

if (regiResult != '' && regiResult == 'success') {
    alert("견적 요청 등록 완료");
}
if (regiResult != '' && regiResult != 'success') {
    alert("견적 요청 등록 실패 \n관리자에게 문의하세요.");
}

function modify(){
    $('#reqTitle').attr('readonly', false);
    $('#postcode').attr('readonly', false);
    $('#custLoc').attr('readonly', false);
    $('#detailAddress').attr('readonly', false);
    $('#startDt').attr('readonly', false);
    $('#endDt').attr('readonly', false);
    $('#reqDtl').attr('readonly', false);
    $('#modiDelBtn').attr('hidden', true);
    $('#complModi').attr('hidden', false);
    $('#searchPostcode').attr('hidden', false);
};

function delConfirm() {
    if (!confirm('해당 견적 요청을 취소 하시겠습니까?')) {
        return false;
    } else {
        const paramData = {
            reqId : $("#reqId").val(),
            lastModifiedBy : $("#lastModifiedBy").val()
        }

        const param = JSON.stringify(paramData);
        $.ajax({
            type : 'post',
            url : '/quote/delete',
            data : param,
            contentType : "application/json; charset=utf-8",
            success : function (result, status, xhr) {
                alert("견적 요청이 삭제되었습니다.");;
                window.open("about:blank","_self");
                window.close();
            },
            error : function (xhr, status, er) {
                if (error) {
                    error(er);
                }
            }
        })
    }
}

function modifyQuo(){

    const paramData = {
       reqId : $("#reqId").val(),
       reqTitle : $("#reqTitle").val(),
       postcode : $("#postcode").val(),
       custLoc : $("#loc").val(),
       detailAddress : $("#detailAddress").val(),
       startDt : $("#startDt").val(),
       endDt : $("#endDt").val(),
       reqDtl : $("#reqDtl").val(),
       lastModifiedBy : $("#lastModifiedBy").val()
   }

    const param = JSON.stringify(paramData);
   $.ajax({
       type : 'post',
       url : '/quote/modify',
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
};

function addQuoPrice() {

    const insertedPrice = $("#quoPrice").val();

    if (insertedPrice == null || insertedPrice == '') {
        alert("견적금액을 입력해주세요.");
        return false;
    }

    if (!confirm('견적 금액 등록 후에는 변경하실 수 없습니다.')) {
        return false;
    } else {
        const paramData = {
            reqId : $("#reqId").val(),
            custId : $("#custId").val(),
            quoPrice : insertedPrice,
            lastModifiedBy : $("#lastModifiedBy").val()
        }

        const param = JSON.stringify(paramData);
        $.ajax({
            type : 'post',
            url : '/quote/addQuoPrice',
            data : param,
            contentType : "application/json; charset=utf-8",
            success : function (result, status, xhr) {
                alert("견적 금액이 등록되었습니다.");
                location.reload();
            },
            error : function (xhr, status, er) {
                if (error) {
                    error(er);
                }
            }
        });
    }


}

function acceptQuo() {
    if (!confirm('해당 금액으로 돌봄을 성사하시겠습니까?')) {
        return false;
    } else {
        const paramData = {
            reqId : $("#reqId").val(),
            srvcId: $("#srvcId").val(),
            lastModifiedBy : $("#lastModifiedBy").val()
        }

        const param = JSON.stringify(paramData);
        $.ajax({
            type : 'post',
            url : '/quote/acceptQuo',
            data : param,
            contentType : "application/json; charset=utf-8",
            success : function (result, status, xhr) {
                alert("돌봄이 수락되었습니다. \n돌봄이가 확인중이니, 잠시만 기다려주세요!");
                window.open("about:blank","_self");
                window.close();
            },
            error : function (xhr, status, er) {
                if (error) {
                    error(er);
                }
            }
        })
    }
}

function signQuo()  {
    if (!confirm('해당 요청을 진행하시겠습니까?')) {
        return false;
    } else {
        const paramData = {
            reqId : $("#reqId").val(),
            lastModifiedBy : $("#lastModifiedBy").val(),
            srvcId : $("#srvcId").val()
        }

        const param = JSON.stringify(paramData);
        $.ajax({
            type : 'post',
            url : '/quote/signQuo',
            data : param,
            contentType : "application/json; charset=utf-8",
            success : function (result, status, xhr) {
                alert("돌봄이 성사되었습니다.\n돌봄 상세 내용과 고객정보가 메일로 발송되었습니다.");
                window.open("about:blank","_self");
                window.close();
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
    <title>견적 조회하기</title>
    <script src="${path}/resources/js/common.js"></script>
</head>

<body>
<div class="popup">
    <div class="title">
        <h4>견적 조회하기</h4>
    </div>


    <div class="content">
            <div class="formGroup">
                <input type="text" class="form-control" id="reqId" name="reqId" value='<c:out value="${req.reqId}" />' hidden/>
                <input type="text" class="form-control" id="srvcId" name="srvcId" value='<c:out value="${req.srvcId}" />' hidden/>
                <input type="text" class="form-control" id="custId" name="custId" value='<c:out value="${req.custId}"/>' hidden>
                <input type="text" class="form-control" id="extraAddress" name="extraAddress" hidden >
                <sec:authentication property="principal" var="principal"/>
                <input type="text" class="form-control" id="lastModifiedBy" name="lastModifiedBy" value='<c:out value="${principal.username}"/>' hidden  >
                <div style="margin-bottom: 15px">
                    <h5>견적서 상태 : ${req.reqPrgrStatNm}</h5>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">서비스이름</span>
                    <input type="text" class="form-control" id="srvcNm" name="srvcNm" value='<c:out value="${srvcNm}"/>' readonly ='readonly'/>
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
                    <button onclick="selectPostcode()" type="button" id="searchPostcode" hidden>우편번호 찾기</button>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">주소</span>
                    <input type="text" class="form-control" name="custLoc" id="loc"
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

                <c:if test="${req.reqPrgrStatCd >= 30}">
                    <div class="input-group mb-3" style="margin-top: 15px">
                        <span class="input-group-text">확정견적금액</span>
                        <input type="number" class="form-control" name="savedQuoPrice" id="savedQuoPrice" value='<c:out value="${req.quoPrice}"/>' readonly ='readonly' >
                    </div>
                </c:if>

                <sec:authorize access="hasRole('ROLE_DLBM')">
                    <c:if test="${req.reqPrgrStatCd == 20}">
                        <div class="input-group mb-3" style="margin-top: 15px">
                            <span class="input-group-text">견적금액</span>
                            <input type="number" class="form-control" name="quoPrice" id="quoPrice">
                        </div>
                        <button class="btn btn-primary btn-sm" id="addPrice" style="margin-top: 10px" onclick="addQuoPrice()">견적금액 등록</button>
                    </c:if>
                </sec:authorize>

                <sec:authorize access="hasRole('ROLE_CUSTOMER')">
                    <c:if test="${req.reqPrgrStatCd == 10}">
                        <div id="modiDelBtn">
                            <button type="button" class="btn btn-primary btn-sm" id="modiBtn" onclick="modify()">수정</button>
                        </div>
                    </c:if>

                    <c:if test="${req.reqPrgrStatCd != 50}">
                        <div id="modiDelBtn">
                            <button type="button" class="btn btn-secondary btn-sm" onclick="delConfirm()">취소</button>
                        </div>
                    </c:if>

                    <button type="submit" class="btn btn-primary btn-sm" id="complModi" style="margin-top: 10px" onclick="modifyQuo()" hidden>수정 완료</button>
                </sec:authorize>

                <c:if test="${req.reqPrgrStatCd == 30}">
                    <sec:authorize access="hasRole('ROLE_CUSTOMER')">
                        <button class="btn btn-primary btn-sm" id="accQuo" style="margin-top: 10px" onclick="acceptQuo()">수락</button>
                    </sec:authorize>
                </c:if>

                <c:if test="${req.reqPrgrStatCd == 40}">
                    <sec:authorize access="hasRole('ROLE_CUSTOMER')">
                        <p class="comment">
                            돌봄이 수락되었습니다.
                            <br>돌봄이가 확인 후, 메일로 돌봄 상세 내용과 돌봄이의 연락처가 메일로 발송됩니다.
                        </p>
                    </sec:authorize>


                    <sec:authorize access="hasRole('ROLE_DLBM')">
                        <button class="btn btn-primary btn-sm" id="signed" style="margin-top: 10px" onclick="signQuo()">성사</button>
                        <p class="comment">
                            고객이 돌봄을 수락하였습니다. 돌봄 시작일자 이전에 성사버튼을 눌러주세요.
                            <br> 성사 버튼을 누르면, 돌봄 상세 내용과 고객의 연락처가 메일로 발송됩니다.
                        </p>
                    </sec:authorize>
                </c:if>

                <c:if test="${req.reqPrgrStatCd == 50}">
                    <sec:authorize access="hasRole('ROLE_CUSTOMER')">
                        <p class="comment">
                            돌봄이 성사되었습니다.
                            <br>돌봄 상세 내용과 돌봄이의 연락처가 메일로 발송되었습니다.
                        </p>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_DLBM')">
                        <p class="comment">
                            돌봄이 성사되었습니다.
                            <br>돌봄 상세 내용과 고객의 연락처가 메일로 발송되었습니다.
                        </p>
                    </sec:authorize>
                </c:if>
            </div>

    </div>
</div>

</body>