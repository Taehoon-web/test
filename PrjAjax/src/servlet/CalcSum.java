package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calc.MyCalc;

@WebServlet("/sum")
public class CalcSum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqFunc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqFunc(request, response);
	}

	private void reqFunc(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// request 넘어온 정보
		String req_num = request.getParameter("num");
		int    num     = Integer.parseInt( req_num ); 
		
		MyCalc  calc   = new MyCalc();
		int     sum    = calc.getSum(num);
		
		/*
		String  html = "<b>결과:" + sum + "</b>";
		// response 내보낼 정보, 출력
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out  = response.getWriter();
		out.print( html );
		out.close();
		*/
		
		String  fmt  = "{";
		fmt         += "   \"num\" :  %d,";
		fmt         += "   \"sum\" :  %d";
		fmt         += "}";
		String  html = String.format(fmt, num, sum);
		
		// response 내보낼 정보, 출력
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out  = response.getWriter();
		out.print( html );
		out.close();		
		
	}

}









