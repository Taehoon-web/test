<%@page import="member.vo.MemberVo"%>
<%@page import="member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
     String     memid        = request.getParameter("memid");
     System.out.println( "넘어온값:" + memid );
     String     result    = "<b class='red'>사용불가능한 아이디입니다</b>";
 	 if( memid != null ) {
 	     MemberDao  memberDao = new MemberDao();
 	     MemberVo   memberVo  = memberDao.getMember(memid);
 	     
 	     System.out.println( memberVo );
 	     
 	     if(memberVo == null ) { // 조회된 자료가 없다
    		result = "<b class='green'>사용가능한 아이디입니다</b>";
 	     } else {
	        result = "<b class='red'>사용 불가능한 아이디입니다</b>";	        
 	     }
 	 }
 %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    main { text-align: center;  }
   .green {color:green;}
   .red   {color:red;}
</style>
<script>
   window.onload = function() {
	   var btnClose   = document.getElementById('btnClose');
	   var mfuserid   = window.opener.document.getElementById('userid');
	   var mfidresult = window.opener.document.getElementById('idresult');
	  // alert(mfidresult)
	   btnClose.onclick = function() {
		   var btag = document.getElementsByTagName("b")[0];
		   console.dir(btag);		   
		   if( btag.className == "green"  ) 
		      mfuserid.value     =  '<%=memid%>';
		   mfidresult.innerHTML  =  "<%=result %>";		   
		   window.close();
	   }
   }
</script>
</head>
<body>
  <main>
    <p>아이디 중복확인</p>
    <form action="idcheck.jsp" method="POST">
    아이디<input type="text"  name="memid" value="<%=memid%>"/>
    <input type="submit" value="중복확인"><br>
    <div id="result"><%=result %></div>
    <input type="button" id="btnClose" value="Close" />
    </form>
  </main>
</body>
</html>








