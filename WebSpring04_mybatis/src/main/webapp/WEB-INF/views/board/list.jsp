<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시판 목록</h2>
<a href="/myhome/write">글쓰기</a>
<ul>
	<c:forEach var="boardVO" items="${list}">
		<li>
			${boardVO.no },
			<a href="/myhome/view?no=${boardVO.no}">${boardVO.subject}</a>,
			${boardVO.userid },
			${boardVO.hit },
			${boardVO.writedate}
		</li>
	</c:forEach>
	
</ul>
</body>
</html>