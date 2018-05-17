<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>로그인페이지</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">
    
    <%@ include file="/include/jquery.jsp" %>
    
    <script>
    	$(function(){
    		
			$("#signinbtn").click(function(){
				$("#frm").submit();
			})
			
    	})
    
	</script>


  </head>

  <body>

    <div class="container">

      <form id="frm" class="form-signin" action="/board/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="userId" class="sr-only">UserId</label>
        <input type="text" id="mem_id" name="mem_id" class="form-control" placeholder="아이디를 입력하세요" required autofocus>
        
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="mem_pass" name="mem_pass" class="form-control" placeholder="비밀번호를 입력하세요" required>

		<button id="signinbtn" class="btn btn-lg btn-primary btn-block" type="button">Sign in</button>
      </form>

    </div>

  </body>
</html>
