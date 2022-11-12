package mvc.dto.liked;

public class Liked {
	private int likeCode;
	private int userCode;
	private int storyCode;
	
	public Liked() {}

	public Liked(int likeCode, int userCode, int storyCode) {
		super();
		this.likeCode = likeCode;
		this.userCode = userCode;
		this.storyCode = storyCode;
	}

	public int getLikeCode() {
		return likeCode;
	}

	public void setLikeCode(int likeCode) {
		this.likeCode = likeCode;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public int getStoryCode() {
		return storyCode;
	}

	public void setStoryCode(int storyCode) {
		this.storyCode = storyCode;
	}
	
	
	
}
