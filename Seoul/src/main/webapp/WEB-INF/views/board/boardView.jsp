<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
	$(function(){
		//해당게시물을 댓글목록구하기
		function replyList(){
			var rParam = "no=${vo.no}";
			var rUrl = "/myapp/replyList";
			$.ajax({
				url		: rUrl,
				data	: rParam,
				success	: function(result){
					var $result = $(result);
					var tag = "";
					$result.each(function(idx, vo){
						tag += "<li><div>"+vo.userid+"("+vo.writedate+")";
						
						if(vo.userid=='${logid}'){	//자신이 쓴 댓글일때
							//수정 삭제 <br/>";
							tag += "<input type='button' value='수정'/>";
							tag += "<input type='button' value='삭제' title='"+vo.num+"'/><br/>";
							tag += vo.coment + "</div>";
							//수정폼
							
							tag += "<div style='display:none'>";
							tag += "<form method='post'>"
							tag += "<textarea name='coment'>" + vo.coment + "</textarea>";
							tag += "<input type='submit' value='Edit'/>";
							tag += "<input type='hidden' name='num' value='"+vo.num+"'/>"; //댓글의 일련번호
							tag += "</form></div></li>"
								console.log(tag);
						}else{	//자신이 안쓴 댓글일때
							tag += "<br/>"+vo.coment+"</div></li>";
						}
					});
					console.log(tag);
					$("#replyList").html(tag);
				},error	: function(){
					console.log("댓글목록선택에러");
				}
			});
		}
		
		//댓글쓰기 
		
		$("#reply").click(()=>{
			//-- 댓글을 입력하지 않은 경우
			if($("#coment").val()==""){
				alert("댓글을 입력후 등록하세요..");
			}else{
				//서버에 댓글을 등록하는 ajax호출
				//폼의 데이터를 전송데이터로 변환해주는 함수
				var params = $("#replyFrm").serialize();
				$.ajax({
					url		: "/myapp/replyWrite",
					type	: "POST",	//"POST" , "GET"
					data	: params,	//coment = 값=&no=23;
					success	: function(result){
						if(result==0){
							alert("댓글등록실패하였습니다.");
						}else{
							//목록을 다시 선택한다.
							replyList();
							//이전 댓글 지우기
							$("#coment").val("");
						}
					},error:function(){
						console.log("댓글쓰기 에러");
					}
				});
			}
		});
		
		//댓글 수정버튼 선택하면
		$(document).on('click','#replyList input[value=수정]',function(){
			console.log('나와라제발');
			//댓글정보 숨기고
			$(this).parent().css("display", "none");
			//댓글수정폼은 보이고
			$(this).parent().next().css("display", "block");
		});
		
		//Edit버튼 선택시 댓글 수정실행
		$(document).on('submit','#replyList form', function(){
			var url = "/myapp/replyEditOk";
			var params = $(this).serialize();	//coment=문자&num=숫자
			$.ajax({
				url		: url,
				data	: params,
				type	: "POST",
				success	: function(result){
					replyList();
				}
			});
			return false;	//submit은 action으로 이도하여 페이지가 실행되는 것을 차단한다.
		});
		//댓글 삭제
		$(document).on('click','#replyList input[value=삭제]',function(){
			if(confirm('댓글을 삭제하시겠습니까?')){
				var params = "num="+ $(this).attr("title");
				$.ajax({
					url		: "/myapp/replyDel",
					data	: params,
					success	: function(result){
						replyList();
					}
				});
			}
		});
		//댓글목록
		replyList();
	});
</script>
<h1>글내용보기</h1>
<ul>
  <li>번호 : ${vo.no}</li>
  <li>작성자 : ${vo.userid}</li>
  <li>작성일 : ${vo.writedate}, 조회수 : ${vo.hit}</li>
  <li>제목 : ${vo.subject}</li>
  <li>${vo.content}</li>
  <li>
    수정
    삭제
    <a href="/myapp/boardList?nowPage=${pVo.nowPage}">목록</a>
  </li>
</ul>
<hr>
<!-- 로그인이 된경우 댓글쓰기 폼을 보여준다. -->
<c:if test="${logStatus=='Y' }">
	<form method="post" id="replyFrm" >
		<textarea name="coment" id="coment" cols="50"></textarea>
		<input type='button' id="reply" value="댓글쓰기"/>
		<input type="hidden" name="no" value="${vo.no}">
	</form>
</c:if>
<style>
	#replyList>li{
	border-bottom:1px solid gray;
	}
</style>
<ul id="replyList">
	<li>goguma (2021-10-10) 수정 삭제<br/>
		댓글내용
	</li>
</ul>
