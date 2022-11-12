package mvc.dto.notice;

import java.util.ArrayList;
import java.util.List;

import mvc.dto.reply.Reply;

public class Notice {
	private int noticeCode;
	private String noticeCategory;
	private String isPrivate;
	private String noticeImage;
	private String subject;
	private String noticeReg;
	private String noticContent;
	
	
	public Notice() {}
	
	private List<Notice> noticeList = new ArrayList<Notice>();
	
	public Notice(int noticeCode, String isPrivate, String subject,String noticContent) {
		this.noticeCode = noticeCode;
		this.isPrivate = isPrivate;
		this.subject = subject;
		this.noticContent = noticContent;
		
		
	}
	
	public Notice(int noticeCode, String noticeCategory, String isPrivate, String noticeImage, String subject,
			String noticeReg, String noticContent) {
		
		this.noticeCode = noticeCode;
		this.noticeCategory = noticeCategory;
		this.isPrivate = isPrivate;
		this.noticeImage = noticeImage;
		this.subject = subject;
		this.noticeReg = noticeReg;
		this.noticContent = noticContent;
	}


	public int getNoticeCode() {
		return noticeCode;
	}
	public void setNoticeCode(int noticeCode) {
		this.noticeCode = noticeCode;
	}
	public String getNoticeCategory() {
		return noticeCategory;
	}
	public void setNoticeCategory(String noticeCategory) {
		this.noticeCategory = noticeCategory;
	}
	public String getIsPrivate() {
		return isPrivate;
	}
	public void setIsPrivate(String isPrivate) {
		this.isPrivate = isPrivate;
	}
	public String getNoticeImage() {
		return noticeImage;
	}
	public void setNoticeImage(String noticeImage) {
		this.noticeImage = noticeImage;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getNoticeReg() {
		return noticeReg;
	}
	public void setNoticeReg(String noticeReg) {
		this.noticeReg = noticeReg;
	}
	public String getNoticContent() {
		return noticContent;
	}
	public void setNoticContent(String noticContent) {
		this.noticContent = noticContent;
	}
	
	}
	

