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


$(document).ready(function (){
    const actionForm = $("#actionForm");
    $(".paginate_btn a").on("click", function (e) {
        e.preventDefault();
        console.log("click");
        actionForm.find("input[name='pageNum']").val($(this).attr("href"));
        actionForm.submit();
    });

    $(".move").on("click", function (e){
       e.preventDefault();
       actionForm.append("<input type='hidden' name='srvcId' value='" + $(this).attr("href")+"'>");
       actionForm.attr("action", "/dlbm/get");
       actionForm.submit();
    });
});
</script>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>돌봄 서비스 조회하기</title>
    <script src="${path}/resources/js/common.js"></script>
    <style type="text/css">
        table {
            font-size: 12pt;
        }
    </style>
</head>

<body>
<jsp:include page="/resources/include/header.jsp" />
<div class="container">
    <div class="mainbox">
        <div class="title">
            <h4>서비스 조회하기</h4>
        </div>
        <div class="content">
            <form id="actionForm" action="/dlbm/getList" method="get">
                <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
                <input type="hidden" name="amount" value="${pageMaker.cri.amount}">
            </form>
                <table class="table">
                    <thead class="table-light">
                        <tr>
                            <td>돌봄이 ID</td>
                            <td>서비스 이름</td>
                            <td>돌봄 지역</td>
                            <td>동물</td>
                            <td>품종</td>
                        </tr>
                    </thead>
                    <c:forEach items="${dlbmList}" var="dlbm">
                        <tr>
                            <td><c:out value="${dlbm.dlbmId}"/></td>
                            <td>
                                <a class="move" href='<c:out value="${dlbm.srvcId}"/>'>
                                    <c:out value="${dlbm.srvcNm}"/>
                                </a>
                            </td>
                            <td><c:out value="${dlbm.dlbmLoc}"/></td>
                            <td><c:out value="${dlbm.animalCtgrCd}"/></td>
                            <td><c:out value="${dlbm.breedCtgrCd}"/></td>
                        </tr>
                    </c:forEach>
                </table>

            <nav aria-label="Page navigation" style="margin: 20px;">
                <ul class="pagination justify-content-center">
                    <c:if test="${pageMaker.prev}">
                        <li class="paginate_btn previous">
                            <a href="${pageMaker.startPage -1}" class="page-link">Previous</a>
                        </li>
                    </c:if>
                    <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                        <li class="paginate_btn ${pageMaker.cri.pageNum == num ? "active" : ""} "><a class="page-link" href="${num}">${num}</a></li>
                    </c:forEach>
                    <c:if test="${pageMaker.next}">
                        <li class="paginate_btn next">
                            <a href="${pageMaker.endPage +1}" class="page-link">Next</a>
                        </li>
                    </c:if>
                </ul>
            </nav>

        <div>
    </div>
</div>
<jsp:include page="/resources/include/footer.jsp" />
</body>