<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

    String  id = request.getParameter("id");
    String  html = "";
	if ( id == null || id.equals("") || id.equals( "sky")  ) {
		html = "<b class='red'>사용불가능한 아이디 입니다</b>"; 
	} else {
		html = "<b class='green'>사용 가능한 아이디 입니다</b>";
	}
	
	out.print(html);

%>