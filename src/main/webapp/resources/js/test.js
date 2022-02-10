function validateForm() {
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

function commas(t) {

    var x = t.value;
    x = x.replace(/,/gi, '');

    var regexp = /^[0-9]*$/;

    if(!regexp.test(x)){
        $(t).val("");
        alert("숫자만 입력 가능합니다.");

    } else {
        x = x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        $(t).val(x);
    }

}