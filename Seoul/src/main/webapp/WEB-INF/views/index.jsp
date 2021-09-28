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
                // randomStart: true,   //시작 슬라이드 랜덤(true, false)
                captions: true, //title 속성값을 설명으로 표시한다.(true, false)
                // ticker: true,   //자막처럼 움직임.(true, false)
                infiniteLoop: false, //반복여부 설정(true, false)
                // adaptiveHeight: false,   //이미지크기에 따라 높이 조절 (true, false)
                hiddenControlOnEnd:true,    //처음과 마지막에 컨트롤러 표시여부 (true, false) infiniteLoop

                //easing
                useCSS: false,//easing사용여부(true: 사용안함, false: 사용함함
                easing: 'easeOutElastic',

            });
        });
    </script>
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