

$("#registerBtn").on("click", function () {
    const userId = $("#userId").val();
    const userPwd = $("#userPwd").val();
    const userPwdCheck = $("#userPwdCheck").val();
    const userNm = $("#userNm").val();
    const userEmail = $("#userEmail").val();
    const userPhone = $("#userPhone").val();
    const userTypeCd = $(":input:radio[name=userTypeCd]:checked").val();

    if (userTypeCd == null || userTypeCd == "" || userTypeCd == undefined) {
        alert("회원 유형을 선택해주세요.");
        return false;
    }

    if(userId == null || userId == "" || userId == undefined) {
        alert("ID를 입력해주세요.")
        return false;
    }
    if(userPwd == null ||userPwd == "" || userPwd == undefined) {
        alert("비밀번호를 입력해주세요.")
        return false;
    }
    if(userPwdCheck == null ||userPwdCheck  == "" || userPwdCheck == undefined) {
        alert("비밀번호 확인을 입력해주세요.")
        return false;
    }
    if(userNm == null || userNm == "" || userNm == undefined) {
        alert("이름을 입력해주세요.")
        return false;
    }
    if(userEmail== null || userEmail == "" ||userEmail  == undefined) {
        alert("이메일을 입력해주세요.")
        return false;
    }
    if(userPhone == null || userPhone == "" ||userPhone  == undefined) {
        alert("휴대폰 번호를 입력해주세요.")
        return false;
    }
    const idCheck = $("#idCheck").val();
    const pwdCheck = $("#pwdCheck").val();
    const pwdCheckCheck = $("#pwdCheckCheck").val();
    const nameCheck = $("#nameCheck").val();
    const emailCheck = $("#emailCheck").val();


    if (
        (idCheck != "" && idCheck != null) ||
        (pwdCheck != "" && pwdCheck != null) ||
        (pwdCheckCheck != "" && pwdCheckCheck != null) ||
        (nameCheck  != "" && nameCheck != null) ||
        (emailCheck  != "" && emailCheck != null)
    ) {
        alert("양식을 다시 확인해주세요.")
        return false;
    }

    if (!confirm('회원가입 하시겠습니까?')) {

        return false;
    } else {
        const memInfo = {
            userId : userId,
            userNm : userNm,
            userPwd : userPwd,
            userEmail : userEmail,
            userPhone : userPhone,
            userTypeCd : userTypeCd,
            createdBy : userId,
            lastModifiedBy : userId
        }


        const paramData = {
            memInfo : memInfo
        }

        const param = JSON.stringify(paramData);
        $.ajax({
            type : 'post',
            url : '/member/register',
            data : param,
            contentType : "application/json; charset=utf-8",
            success : function (result, status, xhr) {
                alert("회원가입이 완료되었습니다.");
                location.href = '/';
            },
            error : function (xhr, status, er) {
                if (error) {
                    error(er);
                }
            }
        });
    }
});

$("#userId").blur(function() {
    const idt = /^[a-z]+[a-z0-9]{4,12}$/;
    const id = $('#userId').val();

    $.ajax({
        url : '/member/checkId?id=' + id,
        type : 'get',
        success : function(data) {

            if (data === '1') {
                $('input[id=idCheck]').attr('value', "중복된 아이디입니다.");
            } else {
                if (idt.test(id)) {
                    $('input[id=idCheck]').attr('value', "");
                } else if (id === "") {
                    $('input[id=idCheck]').attr('value', "아이디를 입력하세요.");
                } else {
                    $('input[id=idCheck]').attr('value', "아이디는 소문자와 숫자 4~12자리만 가능합니다.");
                }
            }
            return false;
        },
        error : function() {

        }
    });
});

$("#userPwd").blur(function() {
    var pw1 = $('#userPwd').val();
    var pwt = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/;

    if (pwt.test(pw1)) {
        $('input[id=pwdCheck]').attr('value', "");
    } else if(pw1 == "") {
        $('input[id=pwdCheck]').attr('value', "비밀번호를 입력하세요");
    } else {
        $('input[id=pwdCheck]').attr('value', "비밀번호는 영문,숫자, 특수문자~`!@#$%\^&*()-+=를 조합하여 8자 이상으로 입력하세요.");
    }
});

$("#userPwdCheck").blur(function() {
    var pw1 = $('#userPwd').val();
    var pw2 = $('#userPwdCheck').val();

    if (pw2 == ''){
        $('input[id=pwdCheckCheck]').attr('value', "비밀번호 확인을 입력하세요");
    }

    if (pw1 == pw2) {
        $('input[id=pwdCheckCheck]').attr('value', "");
    } else {
        $('input[id=pwdCheckCheck]').attr('value', "비밀번호가 일치하지 않습니다.");
    }
});

$("#userNm").blur(function() {
    var namet = /^[가-힣]{2,6}$/;
    var name = $('#userNm').val();

    if (namet.test(name)) {
        $('input[id=nameCheck]').attr('value', "");
    } else if(name == "") {
        $('input[id=nameCheck]').attr('value', "이름을 입력하세요.");
    } else {
        $('input[id=nameCheck]').attr('value', "한글로 이루어진 2~6자리의 이름만 사용가능합니다.");
    }
});

$("#userEmail").blur(function() {
    var emailt = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    var email = $('#userEmail').val();

    $.ajax({
        url : '/member/checkEmail?email=' + email,
        type : 'get',
        success : function(data) {

            if (data === '1') {
                $('input[id=emailCheck]').attr('value', "사용중인 이메일 입니다.");
            } else {
                if (emailt.test(email)) {
                    $('input[id=emailCheck]').attr('value', "");
                } else if (email === "") {
                    $('input[id=emailCheck]').attr('value', "이메일을 입력해주세요.");
                } else {
                    $('input[id=emailCheck]').attr('value', "잘못된 형식입니다.");
                }
            }
        },
        error : function() {

        }
    });
});