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
<link href="${path }/resources/css/style.css" rel="stylesheet">
<script>
function openPopup(reqId) {
    window.open(
        '/review/registerForm?reqId='+reqId,
        'window_name',
        'width=600,height=400,location=no,status=no,scrollbars=yes');
}

</script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>마이페이지</title>
    <script src="${path}/resources/js/common.js"></script>
    <style type="text/css">
        table {
            font-size: 10pt;
            text-align: center;
        }
        #reviewPopup {
            font-size: 10pt;
        }
    </style>
</head>

<body>
<jsp:include page="/resources/include/header.jsp" />
<div class="container">
    <jsp:include page="/resources/include/sidebar.jsp" />
    <div class="mainbox">

        <div class="title">
            <h4>마이페이지</h4>
        </div>
        <div class="content">
            <div  id="dlbmHist" class="section1">
                <h5>돌봄이력</h5>
                    <div  class="section2">
                        <div class="smallTitle">
                            내가 보낸 견적 요청서
                        </div>
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <td>요청서 제목</td>
                                <td>시작일</td>
                                <td>종료일</td>
                                <td>지역</td>
                                <td>대분류</td>
                                <td>소분류</td>
                                <td>상태</td>
                            </tr>
                            </thead>
                            <c:forEach items="${prgrQuoList}" var="prgrQuo">
                                <tr>
                                    <td>
                                        <a href="${path}/quote/get?reqId=${prgrQuo.reqId}"
                                           onclick="window.open(this.href, '_blank', 'width=800, height=600'); return false;">
                                            <c:out value="${prgrQuo.reqTitle}"/>
                                        </a>
                                    </td>
                                    <td><fmt:formatDate value="${prgrQuo.startDt}" pattern="yyyy-MM-dd"/></td>
                                    <td><fmt:formatDate value="${prgrQuo.endDt}" pattern="yyyy-MM-dd"/></td>
                                    <td><c:out value="${prgrQuo.custLoc}"/></td>
                                    <td><c:out value="${prgrQuo.animalCtgrNm}"/></td>
                                    <td><c:out value="${prgrQuo.breedCtgrNm}"/></td>
                                    <td><c:out value="${prgrQuo.reqPrgrStatNm}"/></td>
                                </tr>
                            </c:forEach>
                            <p class="noInfo" hidden>조회된 내역이 없습니다.</p>
                        </table>
                    </div>

                    <div class="section2">
                        <div class="smallTitle">
                            지난 돌봄
                        </div>
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <td>요청서 제목</td>
                                <td>시작일</td>
                                <td>종료일</td>
                                <td>지역</td>
                                <td>대분류</td>
                                <td>소분류</td>
                                <td>상태</td>
                                <td>리뷰</td>
                            </tr>
                            </thead>
                            <c:forEach items="${cmplQuoList}" var="cmplQuo">
                                <tr>
                                    <td>
                                        <a href="${path}/quote/get?reqId=${cmplQuo.reqId}"
                                           onclick="window.open(this.href, '_blank', 'width=800, height=600'); return false;">
                                            <c:out value="${cmplQuo.reqTitle}"/>
                                        </a>
                                    </td>
                                    <td><fmt:formatDate value="${cmplQuo.startDt}" pattern="yyyy-MM-dd"/></td>
                                    <td><fmt:formatDate value="${cmplQuo.endDt}" pattern="yyyy-MM-dd"/></td>
                                    <td><c:out value="${cmplQuo.custLoc}"/></td>
                                    <td><c:out value="${cmplQuo.animalCtgrNm}"/></td>
                                    <td><c:out value="${cmplQuo.breedCtgrNm}"/></td>
                                    <td><c:out value="${cmplQuo.reqPrgrStatNm}"/></td>

                                    <td>
                                        <c:if test="${cmplQuo.reqPrgrStatCd == 50}">
                                            <button id="reviewPopup" class="btn btn-outline-danger btn-sm" onclick="openPopup(${cmplQuo.reqId})">작성</button>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                            <p class="noInfo" hidden>조회된 내역이 없습니다.</p>
                        </table>
                    </div>

                    <div class="section2">
                        <div class="smallTitle">
                            내가 이용한 돌봄 서비스
                        </div>
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <td>서비스명</td>
                                <td>평점</td>
                                <td>누적 돌봄수</td>
                                <td>대분류</td>
                                <td>소분류</td>
                            </tr>
                            </thead>
                            <c:forEach items="${complDlbmList}" var="dlbm">
                                <tr>
                                    <td>
                                        <a href="${path}/dlbm/get?srvcId=${dlbm.srvcId}">
                                            <c:out value="${dlbm.srvcNm}"/>
                                        </a>
                                    </td>
                                    <td><c:out value="${dlbm.rate}"/></td>
                                    <td><c:out value="${dlbm.cnt}"/></td>
                                    <td><c:out value="${dlbm.animalCtgrNm}"/></td>
                                    <td><c:out value="${dlbm.breedCtgrNm}"/></td>
                                </tr>
                            </c:forEach>
                            <p class="noInfo" hidden>조회된 내역이 없습니다.</p>
                        </table>
                    </div>
            </div>

            <div id="myInfo" class="section1">
                <h5>나의 정보</h5>
                <div class="section2">
                    <div class="input-group mb-3">
                        <span class="input-group-text">ID</span>
                        <input type="text" id="userId" name="userId" class="form-control" value='<c:out value="${userInfo.userId}"/>'>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">이름</span>
                        <input type="text" id="userNm" name="userNm" class="form-control" value='<c:out value="${userInfo.userNm}"/>'>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">이메일</span>
                        <input type="email" id="userEmail" name="userEmail" class="form-control" value='<c:out value="${userInfo.userEmail}"/>'>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">휴대폰 번호</span>
                        <input type="number" id="userPhone" name="userPhone" class="form-control" value='<c:out value="${userInfo.userPhone}"/>'>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">비밀번호변경</span>
                        <button type="button" class="btn btn-secondary btn-sm" id="changePwd">변경</button>
                    </div>
                </div>
            </div>

        </div>

    </div>
</div>
<jsp:include page="/resources/include/footer.jsp" />
</body>