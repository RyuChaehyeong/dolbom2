<%--
  Created by IntelliJ IDEA.
  User: SAMSUNG
  Date: 2022-01-14
  Time: 오후 3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>



<script>

</script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
        .checkComment {
            font-style: oblique;
            color: darkred;
            margin-top: 2px;
            border-style: hidden;
            font-size: 7px;
            width: 300px;
            background-color: #f7f7f7;
        }
        .form-group {
            margin-top: 5px;
        }
        .checkComment:focus {
            outline: none;
        }

        #joinForm {
            padding: 35px;
        }
        .form-control {
            width: 85%;
        }
    </style>
    <title>회원가입</title>
    <link rel="stylesheet" href="${path}/resources/css/style.css">
</head>

<body>
<jsp:include page="/resources/include/header.jsp" />
<div class="container">
    <jsp:include page="/resources/include/sidebar.jsp" />
    <div class="mainbox">
        <div class="title">
            <h4>회원가입</h4>
        </div>
        <div class="content">
            <div id="joinForm">

                <div class="form-group">
                    <label>ID</label>
                    <input type="text" id="userId" name="userId" class="form-control" placeholder="ID를 입력해주세요">
                </div>
                    <input class="checkComment" id="idCheck" tabindex="-1">
                <div class="form-group">
                    <label>비밀번호</label>
                    <input type="password" id="userPwd" name="userPwd" class="form-control" placeholder="비밀번호 입력">
                </div>
                    <input class="checkComment" id="pwdCheck" tabindex="-1">
                <div class="form-group">
                    <label>비밀번호 확인</label>
                    <input type="password" id="userPwdCheck" name="userPwdCheck" class="form-control" placeholder="비밀번호 확인 입력">
                </div>
                    <input class="checkComment" id="pwdCheckCheck" tabindex="-1">
                <div class="form-group">
                    <label>이름</label>
                    <input type="text" id="userNm" name="userNm" class="form-control" placeholder="이름을 입력해주세요">
                </div>
                    <input class="checkComment" id="nameCheck" tabindex="-1">
                <div class="form-group">
                    <label>이메일</label>
                    <input type="email" id="userEmail" name="userEmail" class="form-control" placeholder="이메일을 입력해주세요">
                </div>
                    <input class="checkComment" id="emailCheck" tabindex="-1">
                <div class="form-group">
                    <label >휴대폰 번호</label>
                    <input type="number" id="userPhone" name="userPhone" class="form-control" placeholder="휴대폰번호를 입력해주세요. (-를 제외하고 숫자만 입력)">
                </div>
                <div class="form-group">
                    <label >회원 유형</label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="userTypeCd" id="roleDlbm" checked value="10">
                        <label class="form-check-label" for="roleDlbm">
                            돌봄이회원
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="userTypeCd" id="roleCust" value="20">
                        <label class="form-check-label" for="roleCust">
                            고객회원
                        </label>
                    </div>

                </div>

                <div style="text-align: center">
                    <button type="submit" class="btn btn-primary" id="registerBtn">회원가입</button>
                </div>
            </div>
        </div>
    </div>
    <script src="${path}/resources/js/joinCheck.js"></script>
</div>
<jsp:include page="/resources/include/footer.jsp" />
</body>