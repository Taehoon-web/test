package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import member.vo.MemberVo;

@WebServlet("/getxmllist")
public class GetMemberListXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDao      memberDao  =  new MemberDao();
		List<MemberVo> memberList =  memberDao.getMemberList();
		// 조회후 자료수 확인
		if(  memberList.size() == 0  ) {
			System.out.println("조회한 자료가 없습");
			return;
		}
		
				
		String  xml  = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		xml         += "<members>";
		for (MemberVo memberVo : memberList) {
			xml     +=  memberVo.toXML();
		}		
		xml         += "</members>";
		
		response.setContentType("application/xml;charset=UTF-8");
		PrintWriter out  = response.getWriter();
		out.print( xml );
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}









