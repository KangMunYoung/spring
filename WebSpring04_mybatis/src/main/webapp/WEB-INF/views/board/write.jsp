<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글쓰기폼</h1>
<form action="/myhome/writeOk" method="post">
	제목 : <input type="text" name="subject"/><br/>
	글내용: <textarea name="content" cols="50"></textarea>
	<input type="submit" value="글등록">
</form>
</body>
</html>