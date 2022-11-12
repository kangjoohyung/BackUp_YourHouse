package mvc.dto.follow;

public class Follow {
	
	private int followCode; //시퀕스로 
	private int followerCode;//나를 팔로우한 사람
	private int followingCode;// 내가 팔로잉한 사람
	
	public Follow () {}

	public Follow(int followCode, int followerCode, int followingCode) {
		this.followCode = followCode;
		this.followerCode = followerCode;
		this.followingCode = followingCode;
	}

	public int getFollowCode() {
		return followCode;
	}

	public void setFollowCode(int followCode) {
		this.followCode = followCode;
	}

	public int getFollowerCode() {
		return followerCode;
	}

	public void setFollowerCode(int followerCode) {
		this.followerCode = followerCode;
	}

	public int getFollowingCode() {
		return followingCode;
	}

	public void setFollowingCode(int followingCode) {
		this.followingCode = followingCode;
	}
	
	

}
