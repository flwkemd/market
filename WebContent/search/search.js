function boardConfirm(){
	if(document.board_frm.sTitle.value.length == 0){
		alert("제목이 공백입니다.");
		board_frm.sTitle.focus();
		return;
	}

	if(document.board_frm.sTitle.value.length < 2){
		alert("제목이 너무 짧습니다.");
		board_frm.sTitle.focus();
		return;
	}
	
	if(document.board_frm.sContent.value.length == 0){
		alert("내용이 공백입니다.");
		board_frm.sContent.focus();
		return;
	}
	
	if(document.board_frm.sContent.value.length < 2){
		alert("내용이 너무 짧습니다.");
		board_frm.sContent.focus();
		return;
	}
	if(document.board_frm.sAddress.value.length == 0){
		alert("위치가 공백입니다.");
		board_frm.sAddress.focus();
		return;
	}
	if(document.board_frm.sAddress.value.length < 2){
		alert("위치가 너무 짧습니다.");
		board_frm.sAddress.focus();
		return;
	}
	if(document.board_frm.sTime1.value.length != 2){
		alert("운영시간1이 잘못 입력 되었습니다.");
		board_frm.sTime1.focus();
		return;
	}
	if(document.board_frm.sTime2.value.length != 2){
		alert("운영시간2가 잘못 입력 되었습니다.");
		board_frm.sTime2.focus();
		return;
	}
	if(document.board_frm.sTime3.value.length != 2){
		alert("운영시간3이 잘못 입력 되었습니다.");
		board_frm.sTime3.focus();
		return;
	}
	if(document.board_frm.sTime4.value.length != 2){
		alert("운영시간4가 잘못 입력 되었습니다.");
		board_frm.sTime4.focus();
		return;
	}

	
	document.board_frm.submit();
}

