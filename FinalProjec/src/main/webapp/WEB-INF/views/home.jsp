<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="main-content">
<style>

	h1{
		margin-left:20px;
	}
	#container{
		width:70%;
		margin:0 auto;
	}
	ul, li{
		margin:0;
		padding:0;
		list-style:none;
	}
	#searchDiv{
		margin-left:22px;
		height:40px;
		width:900px;
	}
	.mainImg{
		width:250px;
		height:250px;
	}
	#pic{
		display:flex;
		flex-flow: row wrap;
		justify-content:space-around;
		align-items:flex-start;
		
	}
	#pic>ul{
		width:250px;
		height:350px;
	}
	#writeBtn{
		float:right;
		margin-right:20px;
		width:70px;
		height:30px;
		background-color:#6f6bdb;
		color:white;
		border:none;
		border-radius:20px;
		cursor:pointer;
		
	}
	#page{
		display:flex;
		height:50px;
		line-height:50px;
		justify-content:center;
	}
	#page>li{
		margin-right:10px;
	}
</style>
<div id='container'>
<!-- Include Editor style. -->
<link href="https://cdn.jsdelivr.net/npm/froala-editor@latest/css/froala_editor.pkgd.min.css" rel="stylesheet" type="text/css" />

<!-- Create a tag that we will use as the editable area. -->
<!-- You can use a div tag as well. -->
<textarea></textarea>

<!-- Include Editor JS files. -->
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/froala-editor@latest/js/froala_editor.pkgd.min.js"></script>

<!-- Initialize the editor. -->
<script>
  new FroalaEditor('textarea');
</script>
		<h1>인증게시판</h1>
		<div id='searchDiv'><input type='text' id='search' name='search'/></div>
		<div id='pic'>
			<ul>
				<li><img src='../img/20210905.jpg' class='mainImg'/></li>
				<li>북한산뷰맛집</li>
				<li><img src='../img/heart.png'/> 10 <img src='../img/talk.png'/> 2</li>
				<li>닉넴</li>
				<li>2020-12-18 15:33 조회 22</li>
			</ul>
			<ul>
				<li><img src='../img/book.jpg' class='mainImg'/></li>
				<li>서촌갬성</li>
				<li><img src='../img/heart.png'/> 10 <img src='../img/talk.png'/> 2</li>
				<li>닉넴</li>
				<li>2020-12-18 15:33 조회 22</li>
			</ul>
			<ul>
				<li><img src='../img/camera.jpg' class='mainImg'/></li>
				<li>요즘 필름 금값이야..</li>
				<li><img src='../img/heart.png'/> 10 <img src='../img/talk.png'/> 2</li>				
				<li>닉넴</li>
				<li>2020-12-18 15:33 조회 22</li>
			</ul>
			<ul>
				<li><img src='../img/cheeze.jpg' class='mainImg'/></li>
				<li>나빼고 다 고양이 키우지 흑</li>
				<li><img src='../img/heart.png'/> 10 <img src='../img/talk.png'/> 2</li>				
				<li>닉넴</li>
				<li>2020-12-18 15:33 조회 22</li>
			</ul>
			<ul>
				<li><img src='../img/cycle.jpg' class='mainImg'/></li>
				<li>누가버린거냐</li>
				<li><img src='../img/heart.png'/> 10 <img src='../img/talk.png'/> 2</li>				
				<li>닉넴</li>
				<li>2020-12-18 15:33 조회 22</li>
			</ul>
			<ul>
				<li><img src='../img/sunset.jpg' class='mainImg'/></li>
				<li>비행기선셋맛집</li>
				<li><img src='../img/heart.png'/> 10 <img src='../img/talk.png'/> 2</li>				
				<li>닉넴</li>
				<li>2020-12-18 15:33 조회 22</li>
			</ul>
			<ul>
				<li><img src='../img/001.jpg' class='mainImg'/></li>
				<li>세차해야지</li>
				<li><img src='../img/heart.png'/> 10 <img src='../img/talk.png'/> 2</li>				
				<li>닉넴</li>
				<li>2020-12-18 15:33 조회 22</li>
			</ul>
			<ul>
				<li><img src='../img/noosa.jpg' class='mainImg'/></li>
				<li>dk...gkfakfdjqtdj</li>
				<li><img src='../img/heart.png'/> 10 <img src='../img/talk.png'/> 2</li>				
				<li>닉넴</li>
				<li>2020-12-18 15:33 조회 22</li>
			</ul>
		</div>
		
		
		<ul id='page'>
			<li>◁</li>
			<li>1</li>
			<li>2</li>
			<li>3</li>
			<li>▷</li>
		</ul>
		<div>
			<input type='submit' value='글쓰기' id='writeBtn'/>
		</div>
	</div>
</div>
<style>
h3{
	border-radius:0px 20px; background : black; color:white;
		width : 120px; text-align:center;
		padding : 10px;
}
#container{
		margin:0 auto;
		padding:10px;
		width:80%;
		overflow:auto;
}
#container>header{
	width:100%;
	height:40px;
	margin:0 auto;
	
	}
#context{
	width:100%;
	height:1000px;
	margin-bottom:20px;
}	
#context2{
	width:100%;
	height:800px;
	border-top:1px solid gray;
	
}
.context3{
	width:100%;
	height:50px;
	
}
#title{
	padding-top:6px;
}
	
#fo{
	
	text-align:right;

}

ul,li{
	list-style-type:none;
	margin: 0;
	padding: 0;
	
}
a{
	text-decoration:none;
}
#title>li, #context3>li{
	float:left; 
	text-align: center;
}


#title>li{
	width:10%;  
	height:30px;
}
#title>li:nth-child(2){
	width:50%;
	height:30px;
}
.context3 li{
	width:10%;
	height:30px;
	float:left;
	text-align: center;
	background:aliceblue; /*aliceblue*/
	padding-bottom:15px;
	border-bottom:1px solid gray;
}

.context3>li:nth-child(2){
	width:50%; 
	height:30px;
}

footer{
	width:100%;
	height:30px;
	display:flex;
}
.num1{
	width:100%;
	height:30px;
	display:flex;
	flex-wrap:nowrap;
	justify-content:space-evenly;
	
}

#button{
	border-radius:20px;
	width:70px;
	text-align: center;
	float:right;
	background: gray;
	color:white;
}

#search1{
	height:20px;
}

</style>

</head>
<body>
	<section id="container">
	<header>
		<h3>아무말 대잔치</h3>
	</header>
	
	<section id="context">
		
		<header id="fo">
			
				<form>
					<select name="search1" id="search1">
		                <option value="all">전체</option>
		                 <option value="title">제목</option>
		                 <option value="nick">닉네임</option>
		                  <option value="content">내용</option>
		                 <option value="tiContent">제목+내용</option>
		            </select>
					<input type="text" id="search2" name="search"/>
					<input type="button" id="btn" value="검색"/>
				</form> 
			
		</header>	
		<br/>
		<section id="context2">
			<ul id="title">
				<li>NO</li>
				<li>제목</li>
				<li>작성자</li>
				<li>등록일</li>
				<li>조회수</li>
				<li>댓글수</li>
			</ul>
			<hr/>
			<ul class="context3">
				<li>90</li>
				<li>오늘날씨 너무 좋네요<br/>#캠핑#서울#캠핑장</li>
				<li>캠프요정(camprider)</li>
				<li>2021-07-01</li>
				<li>102</li>
				<li>5</li>
			</ul>	
			
			<ul class="context3">
				<li>91</li>
				<li>오늘날씨 너무 좋네요<br/>#캠핑#서울#캠핑장</li>
				<li>캠프요정(camprider)</li>
				<li>2021-07-01</li>
				<li>102</li>
				<li>5</li>
			</ul>
			
			<ul class="context3">
				<li>92</li>
				<li>오늘날씨 너무 좋네요<br/>#캠핑#서울#캠핑장</li>
				<li>캠프요정(camprider)</li>
				<li>2021-07-01</li>
				<li>102</li>
				<li>5</li>
			</ul>
			
			<ul class="context3">
				<li>93</li>
				<li>오늘날씨 너무 좋네요<br/>#캠핑#서울#캠핑장</li>
				<li>캠프요정(camprider)</li>
				<li>2021-07-01</li>
				<li>102</li>
				<li>5</li>
			</ul>
			
			<ul class="context3">
				<li>94</li>
				<li>오늘날씨 너무 좋네요<br/>#캠핑#서울#캠핑장</li>
				<li>캠프요정(camprider)</li>
				<li>2021-07-01</li>
				<li>102</li>
				<li>5</li>
			</ul>
			
			<ul class="context3">
				<li>95</li>
				<li>오늘날씨 너무 좋네요<br/>#캠핑#서울#캠핑장</li>
				<li>캠프요정(camprider)</li>
				<li>2021-07-01</li>
				<li>102</li>
				<li>5</li>
			</ul>
			
			<ul class="context3">
				<li>96</li>
				<li>오늘날씨 너무 좋네요<br/>#캠핑#서울#캠핑장</li>
				<li>캠프요정(camprider)</li>
				<li>2021-07-01</li>
				<li>102</li>
				<li>5</li>
			</ul>
			
			<ul class="context3">
				<li>97</li>
				<li>오늘날씨 너무 좋네요<br/>#캠핑#서울#캠핑장</li>
				<li>캠프요정(camprider)</li>
				<li>2021-07-01</li>
				<li>102</li>
				<li>5</li>
			</ul>
			
			<ul class="context3">
				<li>98</li>
				<li>오늘날씨 너무 좋네요<br/>#캠핑#서울#캠핑장</li>
				<li>캠프요정(camprider)</li>
				<li>2021-07-01</li>
				<li>102</li>
				<li>5</li>
			</ul>
			
			<ul class="context3">
				<li>99</li>
				<li>오늘날씨 너무 좋네요<br/>#캠핑#서울#캠핑장</li>
				<li>캠프요정(camprider)</li>
				<li>2021-07-01</li>
				<li>102</li>
				<li>5</li>
			</ul>
			
			<ul class="context3">
				<li>100</li>
				<li>오늘날씨 너무 좋네요<br/>#캠핑#서울#캠핑장</li>
				<li>캠프요정(camprider)</li>
				<li>2021-07-01</li>
				<li>102</li>
				<li>5</li>
			</ul>
			
			<ul class="context3">
				<li>101</li>
				<li>오늘날씨 너무 좋네요<br/>#캠핑#서울#캠핑장</li>
				<li>캠프요정(camprider)</li>
				<li>2021-07-01</li>
				<li>102</li>
				<li>5</li>
			</ul>
			
			<ul class="context3">
				<li>102</li>
				<li>오늘날씨 너무 좋네요<br/>#캠핑#서울#캠핑장</li>
				<li>캠프요정(camprider)</li>
				<li>2021-07-01</li>
				<li>102</li>
				<li>5</li>
			</ul>
			
			<ul class="context3">
				<li>103</li>
				<li>오늘날씨 너무 좋네요<br/>#캠핑#서울#캠핑장</li>
				<li>캠프요정(camprider)</li>
				<li>2021-07-01</li>
				<li>102</li>
				<li>5</li>
			</ul>
			
			<ul class="context3">
				<li>104</li>
				<li>오늘날씨 너무 좋네요<br/>#캠핑#서울#캠핑장</li>
				<li>캠프요정(camprider)</li>
				<li>2021-07-01</li>
				<li>102</li>
				<li>5</li>
			</ul>
			
		</section>
	<br/>
	<footer>
		<ul class="num1">
				<li><a href="#">◀</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">▶</a></li>
		</ul>
		
		<div>
			<input type="button" id="button" value="작성"/>
		</div>
	
	</footer>
	
</section>	
