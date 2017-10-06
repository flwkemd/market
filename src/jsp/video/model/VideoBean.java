package jsp.video.model;

public class VideoBean {

	private int vId;
	private String vTitle;
	private String vContent;
	private String vFile;
	
	public VideoBean() {
	}

	public VideoBean(int vId, String vTitle, String vContent, String vFile) {
		this.vId = vId;
		this.vTitle = vTitle;
		this.vContent = vContent;
		this.vFile = vFile;
	}

	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
	}

	public String getvTitle() {
		return vTitle;
	}

	public void setvTitle(String vTitle) {
		this.vTitle = vTitle;
	}

	public String getvContent() {
		return vContent;
	}

	public void setvContent(String vContent) {
		this.vContent = vContent;
	}

	public String getvFile() {
		return vFile;
	}

	public void setvFile(String vFile) {
		this.vFile = vFile;
	}

}