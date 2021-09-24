<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
$(()=>{
	//문자열 비동기식으로 가져오기
	$("#str").click(function(){
		$.ajax({
			url: "/home/ajaxStr",
			data: "num=23&name=이순신",
			success: function(result){
				$("#view").append(result)
			}
		});
	});
	//서버에서 List 컬렉션 객체 비동기시으로 가져오기
	$("#lst").on('click', function(){
		var url = "/home/ajaxList";
		var params = "num=100&nick=고구마";
		$.ajax({
			url : url,
			data : params,
			success:function(r){
				var rr = $(r);
				rr.each(function(idx, vo){
					$("#view").append("<hr/>"+idx+"--->"+vo.num+":"+vo.userid+":"+vo.nick);
				});
				
			},error:function(e){
				console.log("List전송 에러발생함", e.responseText);
			}
		});
	});
	//서버에서 비동기식으로 Object 가져오기\
	$(document).on('click','#obj',function(){
		$.ajax({
			url:"/home/ajaxObject",
			success:function(result){
				$("#view").append("<hr/>num="+result.num+", userid="+result.userid+", nick="+result.nick);
			}
		});
	});
	//서버에서 비동기식으로 Map객체 가져오기
	$(document).on('click','#map',function(){
		$.ajax({
			url:"/home/ajaxMap",
			success:function(result){
				//						  key vo.num
				var tag = "번호=" + result.k1.num +", userid=" + result.k1.userid + ", nick=" + result.k1.nick+"<br/>";
				tag += "번호=" + result.k2.num +", userid=" + result.k2.userid + ", nick=" + result.k2.nick+"<br/>";
				tag += "번호=" + result.k3.num +", userid=" + result.k3.userid + ", nick=" + result.k3.nick+"<br/>";
				
				$("#view").append(tag);
			}
		});
	});
	//서버에서 비동기식으로 json정보를 문자열로 가져와 json 객체로 파싱하여 정보를 사용하기
	$("#json").click(function(){
		$.ajax({
			url:"/home/ajaxJson",
			success:function(result){
				//문자열을 전송받아 json으로 파싱한다
				var jsonParsing = JSON.parse(result);
				console.log(jsonParsing);
				$("#view").append("no"+jsonParsing.no+", username"+jsonParsing.username+", tel"+jsonParsing.tel+", addr"+jsonParsing.addr);
			}
		});
	})
	
});
</script>
</head>
<body>
AjaxTestPage

<input type="button" id="str" value="ajax(문자열)"/>
<input type="button" id="lst" value="ajax(List)"/>
<input type="button" id="obj" value="ajax(Object)"/>
<input type="button" id="map" value="ajax(map)"/>
<input type="button" id="json" value="ajax(Json)"/>
<hr/>
<div id="view"></div>
</body>
</html>