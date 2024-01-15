<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <!-- 년도/월/일 라이브러리 코드 -->
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
	
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script
		  src="https://code.jquery.com/jquery-3.4.1.js"
		  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
		  crossorigin="anonymous">
		</script>
		
	<style>
  a{
  	text-decoration : none;
  }
  table{
 	border-collapse: collapse;
 	width: 1000px;    
 	margin-top : 20px;
 	text-align: center;
  }
  td, th{
  	border : 1px solid black;
  	height: 50px;
  }
  th{
  	font-size : 17px;
  }
  thead{
  	font-weight: 700;
  }
  .table_wrap{
  	margin : 50px 0 0 50px;
  }
  .bno_width{
  	width: 12%;
  }
  .writer_width{
  	width: 20%;
  }
  .regdate_width{
  	width: 15%;
  }
  .updatedate_width{
  	width: 15%;
  }
  .top_btn{
  	font-size: 20px;
    padding: 6px 12px;
    background-color: #fff;
    border: 1px solid #ddd;
    font-weight: 600;
  }
  </style>
</head>
<body>
<h1>목록페이지입니다.</h1>

<div class="table_wrap">
	<a href="/board/enroll" class="top_btn">게시판 등록</a>
	<table>
		<thead>
			<tr>
				<th class="bno_width">번호</th>
				<th class="title_width">제목</th>
				<th class="writer_width">작성자</th>
				<th class="regdate_width">작성일</th>
				<th class="updatedate_width">수정일</th>
			</tr>
		</thead>
		<!-- Controller에서 model.addAttribute("list", bservice.getList()); 의
		 list에 저장된 getList()의 값을 가져온다 -->
			<c:forEach items="${list}" var="list">
            <tr>
                <td><c:out value="${list.bno}"/></td>
                <td>
                <!-- '목록 페이지(list.jsp)'에서 제목을 클릭했을 때 해당 '조회 페이지(get.jsp)' 페이지로 이동할 수 있도록 <a> 태그를 추가 -->
                	
                	<!--
                	<a class="move" href="/board/get?bno=<c:out value="${list.bno}"/>">
				        <c:out value="${list.title}"/>
				    </a>
				    -->
				    <a class="move" href='<c:out value="${list.bno}"/>'>
        				<c:out value="${list.title}"/>
    				</a>
                </td>
                <td><c:out value="${list.writer}"/></td>
                 
                <!-- 기존 코드 -->
                <!-- <td><c:out value="${list.regdate}"/></td>
                <td><c:out value="${list.updateDate}"/></td> -->
 
   				<!-- 년월일 변경 코드, 위에 라이브러리 추가해야함 -->
                <td><fmt:formatDate pattern="yyyy/MM/dd" value="${list.regdate}"/></td>
                <td><fmt:formatDate pattern="yyyy/MM/dd" value="${list.updateDate}"/></td>
            </tr>
        </c:forEach>
	</table>
	<form id="moveForm" method="get"></form>
</div>
		<!-- result에 담긴 값이 아무것도 없을 경우 실행되지 않고,
		값이 있을 경우 어떠한 메시지가 있는지 체크한 뒤 게시판 등록이
		완료되었다는 경고창을 띄우는 로직을 가진 함수를 작성.
		작성한 함수를 호출하고 인자 값으로는 서버로부터 전달받은 값인 reuslt를 부여 -->
		<script>
			$(document).ready(function(){
			    
			    let result = '<c:out value="${result}"/>';
			    
			    checkAlert(result);
			    
			    function checkAlert(result){
			        
			        if(result === ''){
			            reutrn;
			        }
			        
			        if(result === "enroll success"){
			            alert("등록이 완료되었습니다.");
			        }
			        
			        if(result === "modify success"){
			            alert("수정이 완료되었습니다.");
			        }
			        
			        if(result === "delete success"){
			            alert("삭제가 완료되었습니다.");
			        }
			        
			    }    
			    
			});
			
		<!--클릭한 <a>태그 기능 정지  <form> 태그 내부 bno값을 저장하는 <input>태그 생성 <form>태그 action 속성 추가  <form>태그 내부 데이터 서버 전송-->
		       
			let moveForm = $("#moveForm");
			 
			$(".move").on("click", function(e){
				e.preventDefault();
				moveForm.empty();

				moveForm.append("<input type='hidden' name='bno' value='"+ $(this).attr("href")+ "'>");
				moveForm.attr("action", "/board/get");
				moveForm.submit();
				});
	    
		</script>
	</body>
</html>