function boardConfirm(){
	if(document.board_frm.eTitle.value.length == 0){
		alert("제목이 공백입니다.");
		board_frm.eTitle.focus();
		return;
	}
	if(document.board_frm.eTitle.value.length < 2){
		alert("제목이 너무 짧습니다.");
		board_frm.eTitle.focus();
		return;
	}
	if(document.board_frm.eAddress.value.length == 0){
		alert("위치가 공백입니다.");
		board_frm.eAddress.focus();
		return;
	}
	if(document.board_frm.eAddress.value.length < 2){
		alert("위치가 너무 짧습니다.");
		board_frm.eAddress.focus();
		return;
	}
	if(document.board_frm.eTime1.value.length != 2){
		alert("운영시간1이 잘못 입력 되었습니다.");
		board_frm.eTime1.focus();
		return;
	}
	if(document.board_frm.eTime2.value.length != 2){
		alert("운영시간2가 잘못 입력 되었습니다.");
		board_frm.eTime2.focus();
		return;
	}
	if(document.board_frm.eTime3.value.length != 2){
		alert("운영시간3이 잘못 입력 되었습니다.");
		board_frm.eTime3.focus();
		return;
	}
	if(document.board_frm.eTime4.value.length != 2){
		alert("운영시간4가 잘못 입력 되었습니다.");
		board_frm.eTime4.focus();
		return;
	}

	document.board_frm.submit();
}

