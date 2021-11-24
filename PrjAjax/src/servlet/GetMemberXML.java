package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import member.vo.MemberVo;

@WebServlet("/getxml")
public class GetMemberXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String     memid     = request.getParameter("memid"); 
		
		MemberDao  memberDao = new MemberDao();
		MemberVo   memberVo  = memberDao.getMember( memid );   
		// 조회후 자료수 확인
		if(  memberVo == null  ) {
			System.out.println("조회한 자료가 없습");
			response.setContentType("application/xml;charset=UTF-8"); // xml
			PrintWriter  out = response.getWriter();
			out.print("조회한 자료가 없습");
			out.close();
		} else {		
			String     xml       =  memberVo.toXML();
			
			response.setContentType("application/xml;charset=UTF-8"); // xml
			PrintWriter  out = response.getWriter();
			out.print(xml);
			out.close();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}







