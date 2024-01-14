<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		
	</head>
	<body>
	
		<h1>목록페이지입니다.</h1>
		<a href="/board/enroll">게시판 등록</a>
		
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
		        
		    }    
		    
		});
		</script>
	</body>
</html>