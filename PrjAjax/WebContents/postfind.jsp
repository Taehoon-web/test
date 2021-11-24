<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<%@page import="post.dao.PostDao"%>
<%@page import="post.vo.PostVo"%>
<%@page import="java.util.List"%>
<%  
    request.setCharacterEncoding("utf-8");
	String         dong      =  request.getParameter("dong");
	if( dong != null ) {
		PostDao        postDao   =  new PostDao();
		List<PostVo>   postList  =  postDao.getPostList( dong );
		
		request.setAttribute("postList", postList);	
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  main { text-align: center; }
  select { width : 640px;  }
</style>

<script>
   
   window.onload = function() {
	   var postlist = document.getElementById('postlist');
	   postlist.ondblclick = function(e) {
		   var selidx  = postlist.selectedIndex;  // <select> 
		   var seltext = postlist[selidx].text;   // postlist.options[selidx] : 선택한 option 
		   //alert( seltext ); 
		   // 01234567890 1 23 4 56 7 89 01
		   // [600-123] 부산 남구 대연1동 경성대학교
		   var zipcode = seltext.substring(1, 8); // 1~7
	       var addr1   = seltext.substring(10); // 10 ~ 끝까지
	       // 나를 open 한 브라우저 : window.opener
	       var mfzipcode   = window.opener.document.getElementById('zipcode');
		   mfzipcode.value = zipcode;
	       var mfaddr1     = window.opener.document.getElementById('addr1');
		   mfaddr1.value   = addr1;
	       var mfaddr2     = window.opener.document.getElementById('addr2');
		   mfaddr2.focus();
		   window.close();  // 창닫기
	   }
   }

</script>

</head>
<body>
   <main>
     <p>주소찾기</p>
     <form action="postfind.jsp"  method="POST">
      동명<input type="text" name="dong">
      <input type="submit" value="검색" /><br> 
      <select id= "postlist"  size="16" >
      
      <c:forEach var = "postVo" items="${ postList }">
      <option value="">${ postVo }</option>
      </c:forEach> 
      
      </select>
     </form>
   </main>
</body>
</html>












