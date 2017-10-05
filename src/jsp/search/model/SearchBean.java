package jsp.search.model;

public class SearchBean {

	private int sId;
	private String sTitle;
	private String sContent;
	private String sAddress;
	private String sTime1;
	private String sTime2;
	private String sTime3;
	private String sTime4;
	private String sFile;
	
	public SearchBean() {
	}

	public SearchBean(int sId, String sTitle, String sContent, String sAddress, String sTime1, String sTime2,
			String sTime3, String sTime4, String sFile) {
		this.sId = sId;
		this.sTitle = sTitle;
		this.sContent = sContent;
		this.sAddress = sAddress;
		this.sTime1 = sTime1;
		this.sTime2 = sTime2;
		this.sTime3 = sTime3;
		this.sTime4 = sTime4;
		this.sFile = sFile;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsTitle() {
		return sTitle;
	}

	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}

	public String getsContent() {
		return sContent;
	}

	public void setsContent(String sContent) {
		this.sContent = sContent;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	public String getsTime1() {
		return sTime1;
	}

	public void setsTime1(String sTime1) {
		this.sTime1 = sTime1;
	}

	public String getsTime2() {
		return sTime2;
	}

	public void setsTime2(String sTime2) {
		this.sTime2 = sTime2;
	}

	public String getsTime3() {
		return sTime3;
	}

	public void setsTime3(String sTime3) {
		this.sTime3 = sTime3;
	}

	public String getsTime4() {
		return sTime4;
	}

	public void setsTime4(String sTime4) {
		this.sTime4 = sTime4;
	}

	public String getsFile() {
		return sFile;
	}

	public void setsFile(String sFile) {
		this.sFile = sFile;
	}

}
	