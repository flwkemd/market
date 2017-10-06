function boardConfirm(){
	if(document.board_frm.vTitle.value.length == 0){
		alert("제목이 공백입니다.");
		board_frm.vTitle.focus();
		return;
	}
	
	document.board_frm.submit();
}
