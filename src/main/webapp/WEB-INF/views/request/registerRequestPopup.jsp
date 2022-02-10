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


function selectPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("extraAddress").value = extraAddr;

            } else {
                document.getElementById("extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("custLoc").value = addr;
            document.getElementById("detailAddress").focus();

        }
    }).open();
}


</script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>견적 요청하기</title>
    <script src="${path}/resources/js/test.js"></script>
</head>

<body>
    <div class="popup">
        <div class="title">
            <h4>견적 요청하기</h4>
        </div>


        <div class="content">
            <form name="reqRegisterForm" action="${root }/request/registerRequest" method="post" onsubmit="return validateForm()">
                <div class="formGroup">
                    <input type="text" class="form-control" name="srvcId" value='<c:out value="${param.srvcId}" />' hidden />
                    <input type="text" class="form-control" name="extraAddress" id="extraAddress" hidden >
                    <input type="text" class="form-control" name="custId" value='<sec:authentication property="principal.username"/>' hidden >

                    <div class="input-group mb-3">
                        <span class="input-group-text" >서비스이름</span>
                        <input type="text" class="form-control" name="srvcNm" id="srvcNm" value='<c:out value="${srvcNm}" />' />
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" >요청서 제목</span>
                        <input type="text" class="form-control" name="reqTitle" id="reqTitle">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" >우편번호</span>
                        <input type="text" class="form-control" name="postcode" id="postcode">
                        <button onclick="selectPostcode()" type="button" >우편번호 찾기</button>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" >주소</span>
                        <input type="text" class="form-control" name="custLoc" id="custLoc">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text" >상세주소</span>
                        <input type="text" class="form-control" name="detailAddress" id="detailAddress">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">시작날짜</span>
                        <input type="date" class="form-control" name="startDt" id="startDt" onchange="validateStartDt(this)">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">종료날짜</span>
                        <input type="date" class="form-control" name="endDt" id="endDt" onchange="validateEndDt(this)">
                    </div>
                    <div class="input-group">
                        <span class="input-group-text">요청상세</span>
                        <textarea class="form-control" id="reqDtl" name="reqDtl"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary" id="reqButton" style="margin-top: 10px">견적 보내기</button>


                </div>
            <form>
        </div>
    </div>

</body>