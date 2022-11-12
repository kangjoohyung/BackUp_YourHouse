package mvc.dto.story;

import java.util.ArrayList;
import java.util.List;

import mvc.dto.reply.Reply;
import mvc.dto.user.UserDTO;

public class Story {
	
	private int storyCode;
	private int userCode;	//글쓴이
	private String storyImage;
	private String storyLiter;
	private String storyReg;
	
	private boolean follow;
	private boolean like;
	
	private UserDTO user;	//글쓴이에 대한 정보
	
	private List<Reply> replyList = new ArrayList<Reply>();

	public Story() {}
	
	public Story(int storyCode, String storyLiter) {
		this.storyCode = storyCode;
		this.storyLiter = storyLiter;
	}
	
	public Story(int storyCode, int userCode, String storyImage, String storyLiter, String storyReg) {
		this(storyCode, storyReg);
		this.userCode = userCode;
		this.storyImage = storyImage;
		this.storyLiter = storyLiter;
	}

	public int getStoryCode() {
		return storyCode;
	}

	public void setStoryCode(int storyCode) {
		this.storyCode = storyCode;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String getStoryImage() {
		return storyImage;
	}

	public void setStoryImage(String storyImage) {
		this.storyImage = storyImage;
	}

	public String getStoryLiter() {
		return storyLiter;
	}

	public void setStoryLiter(String storyLiter) {
		this.storyLiter = storyLiter;
	}

	public String getStoryReg() {
		return storyReg;
	}

	public void setStoryReg(String storyReg) {
		this.storyReg = storyReg;
	}

	public boolean isFollow() {
		return follow;
	}

	public void setFollow(boolean follow) {
		this.follow = follow;
	}

	public boolean isLike() {
		return like;
	}

	public void setLike(boolean like) {
		this.like = like;
	}

	public List<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	
}
