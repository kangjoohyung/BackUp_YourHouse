package mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dto.reply.Reply;
import mvc.dto.user.UserDTO;
import mvc.service.ReplyService;
import mvc.service.ReplyServiceImpl;
import net.sf.json.JSONArray;


public class AjaxReplyController implements AjaxController{
	private ReplyService replyService = new ReplyServiceImpl();

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}


	public void insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//전송된 데이터 받기 

		String storyCode = request.getParameter("story_code");
		UserDTO user = (UserDTO) request.getSession().getAttribute("loginUser");
		int userCode = user.getUserCode();
		String replyContent = request.getParameter("reply_content");

		Reply reply = 
				new Reply(0,Integer.parseInt(storyCode), userCode, replyContent, null);


		Reply reply1 = replyService.insert(reply);

		JSONArray json = JSONArray.fromObject(reply1);
		out.print(json);

	}


	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrintWriter out = response.getWriter();
		String replyCode=request.getParameter("replyCode");
		replyService.delete(Integer.parseInt(replyCode));

	}
}
