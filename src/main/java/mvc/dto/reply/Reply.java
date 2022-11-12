package mvc.dto.reply;

import mvc.dto.user.UserDTO;

public class Reply {


	
	private int replyCode;
	private int storyCode;
	private int userCode;
	private String replyContent;
	private String createdReg;
	
	private UserDTO user;
	
	public Reply(){}
	
	public Reply(int replyCode, int storyCode, int userCode, String replyContent, String createdReg) {
		this.replyCode = replyCode;
		this.storyCode = storyCode;
		this.userCode = userCode;
		this.replyContent = replyContent;
		this.createdReg = createdReg;
	}

	public int getReplyCode() {
		return replyCode;
	}

	public void setReplyCode(int replyCode) {
		this.replyCode = replyCode;
	}

	public int getStoryCode() {
		return storyCode;
	}

	public void setStoryCode(int storyCode) {
		this.storyCode = storyCode;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getCreatedReg() {
		return createdReg;
	}

	public void setCreatedReg(String createdReg) {
		this.createdReg = createdReg;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
	
}
