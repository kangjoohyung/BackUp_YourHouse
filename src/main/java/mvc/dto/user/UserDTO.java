package mvc.dto.user;

public class UserDTO {

	private int userCode;
	private String email;
	private String password;
	private String birth;
	private String nickname;
	private String phone;
	private String adress;
	private String gender;
	private String regDate;
	private int categoryCode;

	public UserDTO() {}
	public UserDTO(String email, String password) {
		this.email = email;
		this.password = password;

	}
	
	public UserDTO(String email, String password, String nickname) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
	}

	public UserDTO(String email, String password, String birth, String nickname, String phone,
			String adress, String gender, int categoryCode) {
		this.email = email;
		this.password = password;
		this.birth = birth;
		this.nickname = nickname;
		this.phone = phone;
		this.adress = adress;
		this.gender = gender;
		this.categoryCode = categoryCode;

	}


	public UserDTO(int userCode, String email, String password, String birth, String nickname, String phone,
			String adress, String gender, String regDate, int categoryCode) {
		this.userCode = userCode;
		this.email = email;
		this.password = password;
		this.birth = birth;
		this.nickname = nickname;
		this.phone = phone;
		this.adress = adress;
		this.gender = gender;
		this.regDate = regDate;
		this.categoryCode = categoryCode;
	}
	
	public UserDTO(int userCode, String password, String nickname,
			String adress, int categoryCode) {
		this.userCode = userCode;
		this.password = password;
		this.nickname = nickname;
		this.adress = adress;
		this.categoryCode = categoryCode;
	}
	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}


}


