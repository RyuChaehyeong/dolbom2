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
<link href="${path }/resources/css/style.css" rel="stylesheet">
<script>

function registerReview() {

    const custId = $("#custId").val();
    const reqId = $("#reqId").val();
    const srvcId = $("#srvcId").val();
    const reviewComment = $("#reviewComment").val();
    const rate = $(":input:radio[name=rateSelect]:checked").val();

    if(rate == null || rate == "" || rate == undefined) {
        alert("별점을 선택해주세요.")
        return false;
    }
    if(reviewComment == null ||reviewComment == "" || reviewComment == undefined) {
        alert("한줄평을 입력해주세요.")
        return false;
    }

    if (!confirm('리뷰 등록을 하시겠습니까?')) {

        return false;
    } else {

        const paramData = {
            custId: custId,
            reqId: reqId,
            srvcId: srvcId,
            rate: rate,
            reviewComment: reviewComment
        }

        const param = JSON.stringify(paramData);
        $.ajax({
            type: 'post',
            url: '/review/register',
            data: param,
            contentType: "application/json; charset=utf-8",
            success: function (result, status, xhr) {
                alert("리뷰가 등록되었습니다.");
                window.open("about:blank", "_self");
                window.close();
            },
            error: function (xhr, status, er) {
                if (error) {
                    error(er);
                }
            }
        });
    }
}

</script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>리뷰등록</title>
    <script src="${path}/resources/js/common.js"></script>
</head>

<body>
    <div class="popup">
        <div class="title">
            <h4>리뷰등록</h4>
        </div>


        <div class="content">
            <div>

                <div class="formGroup">
                    <input type="text" class="form-control" id="srvcId" name="srvcId" value='<c:out value="${quote.srvcId}" />' hidden />
                    <input type="text" class="form-control" id="custId" name="custId" value='<c:out value="${quote.custId}" />' hidden >
                    <input type="text" class="form-control" id="reqId" name="reqId" value='<c:out value="${quote.reqId}" />' hidden >

                    <div class="input-group mb-3">
                        <span class="input-group-text" >서비스이름</span>
                        <input type="text" class="form-control" name="srvcNm" id="srvcNm" value='<c:out value="${srvcNm}" />' readonly ='readonly'/>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" >평점</span>
                        <div style="margin-left: 20px; padding-top: 7px;">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="rateSelect" id="inlineRadio1" value="1">
                                <label class="form-check-label" for="inlineRadio1">1</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="rateSelect" id="inlineRadio2" value="2">
                                <label class="form-check-label" for="inlineRadio2">2</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="rateSelect" id="inlineRadio3" value="3">
                                <label class="form-check-label" for="inlineRadio3">3</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="rateSelect" id="inlineRadio4" value="4">
                                <label class="form-check-label" for="inlineRadio4">4</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="rateSelect" id="inlineRadio5" value="5">
                                <label class="form-check-label" for="inlineRadio5">5</label>
                            </div>
                        </div>

                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" >한줄평</span>
                        <input type="text" class="form-control" name="reviewComment" id="reviewComment">
                    </div>

                    <button class="btn btn-outline-dark" id="reqButton" onclick="registerReview()" style="margin-top: 10px">리뷰등록</button>

                </div>

            </div>
        </div>
    </div>

</body>
