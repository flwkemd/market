package jsp.store.model;

public class StoreBean {

	private int eId;
	private String eTitle;
	private String eContent;
	private String eAddress;
	private String eTime1;
	private String eTime2;
	private String eTime3;
	private String eTime4;
	private String eFile;
	
	public StoreBean() {
	}

	public StoreBean(int eId, String eTitle, String eContent, String eAddress, String eTime1, String eTime2,
			String eTime3, String eTime4, String eFile) {
		this.eId = eId;
		this.eTitle = eTitle;
		this.eContent = eContent;
		this.eAddress = eAddress;
		this.eTime1 = eTime1;
		this.eTime2 = eTime2;
		this.eTime3 = eTime3;
		this.eTime4 = eTime4;
		this.eFile = eFile;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteTitle() {
		return eTitle;
	}

	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}

	public String geteContent() {
		return eContent;
	}

	public void seteContent(String eContent) {
		this.eContent = eContent;
	}

	public String geteAddress() {
		return eAddress;
	}

	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}

	public String geteTime1() {
		return eTime1;
	}

	public void seteTime1(String eTime1) {
		this.eTime1 = eTime1;
	}

	public String geteTime2() {
		return eTime2;
	}

	public void seteTime2(String eTime2) {
		this.eTime2 = eTime2;
	}

	public String geteTime3() {
		return eTime3;
	}

	public void seteTime3(String eTime3) {
		this.eTime3 = eTime3;
	}

	public String geteTime4() {
		return eTime4;
	}

	public void seteTime4(String eTime4) {
		this.eTime4 = eTime4;
	}

	public String geteFile() {
		return eFile;
	}

	public void seteFile(String eFile) {
		this.eFile = eFile;
	}

}
