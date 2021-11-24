package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.dao.PostDao;
import post.vo.PostVo;

@WebServlet("/getpostlist")
public class GetPostListJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 넘어오는 값
		request.setCharacterEncoding("UTF-8");
		String         dong      =  request.getParameter("dong");
		
		PostDao        postDao   =  new  PostDao(); 
		List<PostVo>   postList	 =  postDao.getPostList( dong );
		
		String         html      =  "";
		html      =  "[";		
		for (int i = 0; i < postList.size(); i++) {
			html     +=  postList.get(i).toJSON() ;
			if( i < postList.size()-1 )
				html     +=  "," ;
		}		
		html     +=  "]";
	
		
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out  = response.getWriter();
		out.print( html );
		out.close();		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}











