function boardConfirm(){
	if(document.board_frm.mTitle.value.length == 0){
		alert("제목이 공백입니다.");
		board_frm.mTitle.focus();
		return;
	}

	if(document.board_frm.mTitle.value.length < 2){
		alert("제목이 너무 짧습니다.");
		board_frm.mTitle.focus();
		return;
	}
	
	if(document.board_frm.mContent.value.length == 0){
		alert("내용이 공백입니다.");
		board_frm.mContent.focus();
		return;
	}
	
	if(document.board_frm.mContent.value.length < 2){
		alert("내용이 너무 짧습니다.");
		board_frm.mContent.focus();
		return;
	}
	
	document.board_frm.submit();
}