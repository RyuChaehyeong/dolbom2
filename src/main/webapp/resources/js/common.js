function validateQuoForm() {
    if (reqRegisterForm.reqTitle.value == "" ||reqRegisterForm.reqTitle.value == null) {
        reqRegisterForm.reqTitle.focus();
        alert("요청서 제목을 입력하세요.");
        return false;
    }

    if (reqRegisterForm.postcode.value == "" ||reqRegisterForm.postcode.value == null) {
        reqRegisterForm.postcode.focus();
        alert("오른쪽 버튼을 클릭하여 주소를 검색하여 우편번호를 선택하세요.");
        return false;
    }

    if (reqRegisterForm.custLoc.value == "" ||reqRegisterForm.custLoc.value == null) {
        reqRegisterForm.custLoc.focus();
        alert("주소를 입력하세요.");
        return false;
    }

    if (reqRegisterForm.detailAddress.value == "" ||reqRegisterForm.detailAddress.value == null) {
        reqRegisterForm.detailAddress.focus();
        alert("상세주소를 입력하세요.");
        return false;
    }

    if (reqRegisterForm.startDt.value == "" ||reqRegisterForm.startDt.value == null) {
        reqRegisterForm.startDt.focus();
        alert("시작일을 선택하세요.");
        return false;
    }

    if (reqRegisterForm.endDt.value == "" ||reqRegisterForm.endDt.value == null) {
        reqRegisterForm.endDt.focus();
        alert("종료일을 선택하세요.");
        return false;
    }

    if (reqRegisterForm.reqDtl.value == "" ||reqRegisterForm.reqDtl.value == null) {
        reqRegisterForm.reqDtl.focus();
        alert("상세한 요청 내용을 입력하세요.");
        return false;
    }
}

function validateDlbmForm() {
    if (dlbmRegForm.srvcNm.value == "" ||dlbmRegForm.srvcNm.value == null) {
        dlbmRegForm.srvcNm.focus();
        alert("서비스 이름을 입력하세요.");
        return false;
    }

    if (dlbmRegForm.postcode.value == "" ||dlbmRegForm.postcode.value == null) {
        dlbmRegForm.postcode.focus();
        alert("오른쪽 버튼을 클릭하여 주소를 검색하여 우편번호를 선택하세요.");
        return false;
    }

    if (dlbmRegForm.custLoc.value == "" ||dlbmRegForm.custLoc.value == null) {
        dlbmRegForm.dlbmLoc.focus();
        alert("주소를 입력하세요.");
        return false;
    }

    if (dlbmRegForm.detailAddress.value == "" ||dlbmRegForm.detailAddress.value == null) {
        dlbmRegForm.detailAddress.focus();
        alert("상세주소를 입력하세요.");
        return false;
    }


    if (dlbmRegForm.srvcDtl.value == "" ||dlbmRegForm.srvcDtl.value == null) {
        dlbmRegForm.srvcDtl.focus();
        alert("상세한 서비스 내용을 입력하세요.");
        return false;
    }
}


function validateStartDt(date) {

    const selectedStartDt = date.value;
    const today = getToday();
    const tomorrow = getTomorrow();

    /*시작일은 내일 날짜부터 선택 가능*/
    if (selectedStartDt < today) {
        alert("돌봄 요청은 내일 날짜부터 가능합니다.");
        document.getElementById('startDt').value = tomorrow;
        document.getElementById('endDt').value = tomorrow;
    } else {
        document.getElementById('endDt').value = selectedStartDt;
    }


}

function validateEndDt(date) {
    const selectedEndDt = date.value;
    const selectedStartDt =  document.getElementById('startDt').value;

    if (selectedStartDt > selectedEndDt) {
        alert("돌봄 종료는 시작일부터 가능합니다.");
        document.getElementById('endDt').value = selectedStartDt;
    }
}

function getToday() {
    const todayDt = new Date();
    return getFormatDt(todayDt);
}

function getTomorrow() {
    const now = new Date();
    const tomorrowDt = new Date(now.setDate(now.getDate() + 1));
    return getFormatDt(tomorrowDt);
}

function getFormatDt(obj) {
    return obj.getFullYear() + "-" + ("0"+(obj.getMonth()+1)).slice(-2) + "-" + ("0"+obj.getDate()).slice(-2);
}

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
            document.getElementById("loc").value = addr;
            document.getElementById("detailAddress").focus();

        }
    }).open();
}
