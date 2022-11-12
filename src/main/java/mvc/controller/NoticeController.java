package mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mvc.dto.notice.Notice;
import mvc.service.NoticeService;
import mvc.service.NoticeServiceImpl;

public class NoticeController implements Controller {
	
	private NoticeService notiService = new NoticeServiceImpl();


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 *  전체검색
	 * */
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String pageNo =request.getParameter("noticeCode");
		if(pageNo==null || pageNo.equals("")) {
			  pageNo="1";
		  }
		
	
		List<Notice> list = notiService.selectAll();
		request.setAttribute("noticeList", list);//뷰에서 ${list}
		request.setAttribute("pageNo", pageNo); //뷰에서 ${pageNo}
		System.out.println(list);
		return new ModelAndView("notice/list.jsp"); //forward방식으로 이동
		
	}
	
	
	
	/**
	 * 등록하기
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//폼에서 enctype="multipart/form-data" 설정되어 있기때문에 request아닌 MultipartRequest로 처리한다. - cos.jar
		String saveDir = request.getServletContext().getRealPath("/save"); //
		int maxSize=1024*1024*100; //100M
		String encoding="UTF-8";
		
		MultipartRequest m = 
		 new MultipartRequest(request,saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		//전송된 데이터 받기 
		String noticeCategory = m.getParameter("notice_category");
		String isPrivate = m.getParameter("isPrivate"); //베너
		if(isPrivate==null) {
			isPrivate="0";
			
		}
		String subject = m.getParameter("subject");
		String noticContent = m.getParameter("noticContent");
		
		
		
		Notice notice = 
			new Notice(0,noticeCategory, isPrivate, null, subject, null, noticContent);
		
		//만약, 파일첨부가 되었다면....
		if(m.getFilesystemName("notice_image") != null) {
			//파일이름저장
			notice.setNoticeImage(m.getFilesystemName("notice_image"));	
		}

		
		
		notiService.insert(notice);

	   return new ModelAndView("admin", true);//key=elec&methodName=select 기본으로 설정된다.	
	}
	
	/**
	 * 상세보기 
	 */

	public ModelAndView selectBynoticeCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
	
		String noticeCode=request.getParameter("noticeCode");
		Notice notice = notiService.selectBynoticeCode(Integer.parseInt(noticeCode));
		request.setAttribute("notice", notice);
		
		return new ModelAndView("notice/read.jsp"); //forward방식 
	}
	
	
	
	
	/**
	 *  수정폼
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String noticeCode=request.getParameter("noticeCode");
		
		Notice notice = notiService.selectBynoticeCode(Integer.parseInt(noticeCode));

		request.setAttribute("notice", notice);
		
		return new ModelAndView("notice/update.jsp");//forward방식
	}
	
	/**
	 * 수정완료
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	   //수정할 정보 4개 받기
		String noticeCode = request.getParameter("noticeCode");
		String isPrivate = request.getParameter("isPrivate");
		String subject = request.getParameter("subject");
		String noticContent = request.getParameter("noticContent");
		
		notiService.update( new Notice (Integer.parseInt(noticeCode),isPrivate,subject, noticContent) );
		
		//수정이 완료가 된후....
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin?key=elec&methodName=selectBynoticeCode&noticeCode="+noticeCode);
	    mv.setRedirect(true);
		return mv;
	}
	
	/**
	 * 삭제
	 * 
	 * */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String noticeCode=request.getParameter("noticeCode");
		//String password = request.getParameter("password");
		
		// 첨부된 파일을 삭제하는 경우라면 삭제가 되었을 때 폴더에서 파일도 삭제한다.-- 
		// 이 기능을 service에서 한다
		
		String saveDir = request.getServletContext().getRealPath("/save");
		notiService.delete(Integer.parseInt(noticeCode), saveDir);
		 return new ModelAndView("admin",true);
	
	}
	

}
