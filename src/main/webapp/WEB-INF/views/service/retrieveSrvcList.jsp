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
        $.ajax({
            type : "get",
            url : "${root }/service/getList",
            success : function (data) {
                console.log(data);
                for (var i in data) {
                    console.log(data[i]);
                    var table = "<tbody><tr>";
                        table += "<td>" + data[i].dlbmId + "</td>";
                        table += "<td><a href = '${path}/service/retrieveSrvcDetail?srvcId=" + data[i].srvcId + "'>" + data[i].srvcNm + "</a></td>";
                        table += "<td>" + data[i].dlbmLoc + "</td>";
                        table += "<td>" + data[i].animalCtgrCd + "</td>";
                        table += "<td>" + data[i].breedCtgrCd + "</td>";
                        table += "</tr></tbody>"
                    $('table').append(table);
                }
            },
            error : function () {
                alert("실패");
            }
        })
    });

</script>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>돌봄 서비스 조회하기</title>
    <script src="${path}/resources/js/test.js"></script>
</head>

<body>
<jsp:include page="/resources/include/header.jsp" />
<div class="container">
    <jsp:include page="/resources/include/sidebar.jsp" />
    <div class="mainbox">
        <div class="title">
            <h4>서비스 조회하기</h4>
        </div>
        <div class="content">
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
                </table>

        <div>
    </div>
</div>
<jsp:include page="/resources/include/footer.jsp" />
</body>