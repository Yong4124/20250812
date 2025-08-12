package dto;

public class TinyDTO {
	private int num;
	private String content;
	
	public TinyDTO(int num, String content) {
		this.num = num;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "TinyDTO [num=" + num + ", content=" + content + "]";
	}
	
	

}
