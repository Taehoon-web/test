package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/openapi1")
public class OpenApi1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		// 넘어온 파라미터 준비
		request.setCharacterEncoding("UTF-8");
		String  courseID = request.getParameter("courseID");
		String  key      = "VVYz4W%2BGHKMfPgAWB%2FNEJ0pWPvbjfbjo2k92wTKBbcYMKQQN566vxUAr3QmK7XErBUhhsfp%2BJKu2O3AYiGjECg%3D%3D"; 
		   // 일반 인증키 (Encoding)
		
		// 호출
		StringBuilder  urlBuilder = new StringBuilder(
			"http://apis.data.go.kr/1360000/TourStnInfoService/getTourStnVilageFcst"); // URL
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")   + "=" + key);
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8")       + "=" + URLEncoder.encode("1", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8")    + "=" + URLEncoder.encode("10", "UTF-8"));
	//	urlBuilder.append("&" + URLEncoder.encode("dataType", "UTF-8")     + "=" + URLEncoder.encode("XML", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("dataType", "UTF-8")     + "=" + URLEncoder.encode("XML", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("CURRENT_DATE", "UTF-8") + "=" + URLEncoder.encode("2019122010", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("HOUR", "UTF-8") + "="   + URLEncoder.encode("24", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("COURSE_ID", "UTF-8") + "=" + URLEncoder.encode(courseID, "UTF-8"));
		
		URL  url   =  new URL( urlBuilder.toString() );
		
		HttpURLConnection  conn = (HttpURLConnection) url.openConnection(); // $.ajax
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/xml");
		System.out.println("Response Code:" + conn.getResponseCode());  // 200, 404, 500
		
		// 도착한 데이터 처리
		BufferedReader   br;
		if( conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300 ) {
			br = new BufferedReader(new InputStreamReader(conn.getInputStream() ));
		} else {
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream() ));			
		}
		
		//  data -> 문자열로 변환
		StringBuilder  sb     = new StringBuilder();
		String         line;
		while( ( line = br.readLine() ) != null ) {
			sb.append( line );
		}
		br.close();
		conn.disconnect();
		System.out.println( sb.toString() );
			
		// 출력
		String xml = sb.toString( );
			
		//response.setContentType("application/json;charset=UTF-8");
		response.setContentType("application/xml;charset=UTF-8");
		PrintWriter  out = response.getWriter();
		out.print(xml);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}










