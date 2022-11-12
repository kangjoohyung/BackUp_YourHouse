package mvc.util;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * 파일 업로드시 이름 변경 (중복방지) 클래스
 * -> 기존파일명+생성시간+중복index로 변경
 * 
 * 업로드 파일이름 : 기존파일명_yyyy-MM-dd_hhMMss_sss
 * 중복시 파일이름 : 기존파일명_yyyy-MM-dd_hhMMss_sss(1~9999)
 * 
 * 사용예시1
 * MultipartRequest m = 
 * 		new MultipartRequest(request,saveDir, maxSize, 
 * 					encoding, new FileRenameTimeIndex());
 * 
 * 사용예시2
 * File file = new File(UploadUtil.SAVE + bean.getFileFileName());
 * file = new FileRenameTimeIndex().rename(file);
 * 
 * @author 강주형
 *
 */
public class FileRenameTimeIndex implements FileRenamePolicy {
   
	//파일명 변경 메소드
	/**
	 * 사용예시
	 * File file = new File(UploadUtil.SAVE + bean.getFileFileName());
	 * file = new FileRenameTimeIndex().rename(file);
	 * @param f (파일이름)
	 * @return f (변경후 이름)
	 */
	public File rename(File f) {//File f는 원본 파일
		//if (createNewFile(f)) return f;//생성된 f가 중복되지 않으면 리턴 -> 시간변경으로 사용 안함
     
		String name = f.getName();
		String body = null;
		String ext = null;
	 
		int dot = name.lastIndexOf(".");
		if (dot != -1) {//확장자가 없을때
		  body = name.substring(0, dot);
		  ext = name.substring(dot);
		} else { //확장자가 있을때
			body = name;
			ext = "";
		}
 
		//이름에 붙일 시간 구하기
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //시간 구하기(밀리세컨드까지)
		SimpleDateFormat timeSdf = new SimpleDateFormat ("yyyy-MM-dd_hhMMss_sss"); //포맷변경
		
		if(createNewFile(f)==true) { //중복 없다면 시간만 붙이기
			
			String newNameTime = body + "_" + timeSdf.format(timestamp)+ext; //기존파일명_시간+확장자
			f = new File(f.getParent(), newNameTime);
			
		}else{ //중복된 파일이 있을때 파일이름뒤에 (1~9999)까지 붙이기
			int count=1;
			
			while (!createNewFile(f) && count <= 9999) {
				String newNameIndex = 
						body + "_" + timeSdf.format(timestamp) + "(" + count + ")" + ext;
				f = new File(f.getParent(), newNameIndex);
			}
		}
		 return f;
	}
 
	/**
	 * 중복여부 체크 메소드
	 * @param f
	 * @return 중복없을시 그대로 리턴/중복시 false로 리턴
	 */
	private boolean createNewFile(File f) { 
		try {
			return f.createNewFile(); //존재하는 파일이 아니면
		}catch (IOException ignored) {
			return false;
		}
	
	}
}
