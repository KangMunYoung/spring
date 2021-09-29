<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
    $(()=>{
        $('#bx').bxSlider({
            mode:'horizontal',   //화면전환방식: default: 'horizontal' options: 'horizontal', 'vertical', 'fade'
            slideWidth: 800,
            slideHeight: 400,
            speed: 3000, //변환속도
            auto: true,  //자동시작(true, false)
            captions: true, //title 속성값을 설명으로 표시한다.(true, false)
            infiniteLoop: false, //반복여부 설정(true, false)
            hiddenControlOnEnd:true,    //처음과 마지막에 컨트롤러 표시여부 (true, false) infiniteLoop
        });
    });
    $(document).ready(function(){
        $("#checkall").click(function(){
            if($("#checkall").prop("checked")){
                $("input[name=chk]").prop("checked",true);
            }else{
                $("input[name=chk]").prop("checked",false);
            }
        });
    });
    
    $(()=>{
		$("logFrm").submit(function(){
			if($("#userid").val()==""){
				alert("아이디를 입력하세요");
				return false;
			}
			if($("#userpwd").val()==""){
				alert("비밀번호를 입력하세요.");
				return false;
			}
			return true;
		});
	});
</script>
<div class="imgBox">
	<ul id='bx'>
		<li><img src="img/banner1.jpg" title="Seoul Music Festival"></li>
		<li><img src="img/banner2.jpg" title="SIBAC 2019"></li>
		<li><img src="img/banner3.jpg" title="2019 서울전환도시 국제 컨퍼러스"></li>
		<li><img src="img/banner4.jpg" title="2019 다다다 발표대회"></li>
		<li><img src="img/banner5.jpg" title="2019 서울 인공지능챗본론"></li>
		<li><img src="img/banner6.jpg" title="서울차 없는 날"></li>
		<li><img src="img/banner7.jpg" title="Zero 제로페이 미국 캐나다 이벤트"></li>
		<li><img src="img/banner8.jpg" title="2019 우리여행 gogo 페스티벌"></li>
	</ul>
</div>

  
<div id="header">
	<h1>자유게시판</h1>
</div>
<div id="ck">
	<input type="checkbox" name="checkall" id="checkall">전체선택
</div>
<!-- 리스트 -->
<div id="boardFrame">
	<ul id="board">
		<li>&nbsp</li>
		<li>번호</li>
		<li>제목</li>
		<li>글쓴이</li>
		<li>등록일</li>
		<li>조회수</li>
	
		<c:forEach var="vo" items="${list}">
			<li><input type="checkbox" name="chk" id="chk"></li>
			<li>${vo.no}</li>
			<li class="wordCut"><a href="/seoul/boardView?num=1&nowPage=${pVo.nowPage}">${vo.subject}</a></li>
			<li>${vo.userid}</li>
			<li>${vo.writedate}</li>
			<li>${vo.hit}</li>
		</c:forEach>
	</ul>
	<div class="pageBox">
		<ul class="pagination">
			<!-- 이전페이지는 현제페이지가 1페이지보다 클때만 표시한다. -->
			<c:if test="${pVo.nowPage>1}" >
				<li class="page-item"><a href="/seoul/boardList?nowPage=${pVo.nowPage-1}<c:if test='${pVo.searchWord!=null && pVo.searchKey!=null}'>&searchKey=${pVo.searchKey}&searchWord=${pVo.searchWord}</c:if>" class="page-link">Prev</a></li>
			</c:if>
			<c:if test="${pVo.nowPage==1}">
				<li class="page-item"><a href="#" class="page-link">Prev</a></li>
			</c:if>
			<!-- 시작페이지에서부터 5개의 페이지를 출력한다. -->
			<!-- 6,7,8,9,10 -->
			<c:forEach var="i" begin="${pVo.startPage}" end="${pVo.startPage+pVo.onePageNumCount-1}">
				<!-- 출력할 페이지번호 총페이지수보다 작을때만 출력한다. -->
				<c:if test="${i<=pVo.totalPage }">
					<c:if test="${i==pVo.nowPage }">
						<li class='page-item active'>
					</c:if>
					<c:if test="${i!=pVo.nowPage }">
						<li class="page-item">
					</c:if>
						<a href="/seoul/boardList?nowPage=${i}<c:if test='${pVo.searchWord!=null && pVo.searchKey!=null}'>&searchKey=${pVo.searchKey}&searchWord=${pVo.searchWord}</c:if>" class="page-link">${i}</a></li>
				</c:if>
			</c:forEach>
			
			<!-- 다음페이지는 현재페이지가 총 페이지수보다 작으면 다음페이지가 있다.-->
			<c:if test="${pVo.nowPage<pVo.totalPage}">
				<li class="page-item"><a href="/seoul/boardList?nowPage=${pVo.nowPage+1}<c:if test='${pVo.searchWord!=null && pVo.searchKey!=null}'>&searchKey=${pVo.searchKey}&searchWord=${pVo.searchWord}</c:if>" class="page-link">Next</a></li>
			</c:if>
		</ul>
	</div>
</div>