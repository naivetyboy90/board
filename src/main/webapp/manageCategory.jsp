<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<%@ include file="/include/jquery.jsp" %>    
<%@ include file="/include/commonCss.jsp" %> 

<title>게시판 관리</title>

<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">

<script>
	$(function(){
		
		//게시판 tr태그 click 이벤트 처리
		$("#categoryList tr").click(function(){
			
			var loginId = $('#loginId').val();
			
			if(loginId==null || loginId==""){
				alert("로그인 후 사용해주시기 바랍니다.");
				document.location = "${pageContext.request.contextPath}/login.jsp";
				return;
			}
			
			var category_seq = $(this).find("td:eq(0)").text();
			$("#category_seq").val(category_seq);
			$("#frm").submit();
		});
		
		//게시판 등록버튼 click 이벤트 처리
		$("#categoryReg").click(function(){
			
			var loginId = $('#loginId').val();
			
			if(loginId==null || loginId==""){
				alert("로그인 후 사용해주시기 바랍니다.");
				document.location = "${pageContext.request.contextPath}/login.jsp";
				return;
			}
			
			$("#insertFrm").submit();
		});
		
		
		
	})

</script>

</head>

<body>

	<%@ include file="/layout/header.jsp" %>
	<input type="hidden" id="loginId" value="${loginId}">
	
	<form id="frm" method="get" action="${pageContext.request.contextPath }/getCategory">
		<input type="hidden" id="category_seq" name="category_seq">
	</form>
	
	<form id="insertFrm" method="post" action="${pageContext.request.contextPath }/categoryForm">
	</form>
	
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/layout/left.jsp" %>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2 class="sub-header">게시판 리스트</h2>
					<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>게시판 번호</th>
									<th>게시판 이름</th>
									<th>만든사람ID</th>
									<th>만든 날짜</th>
									<th>사용여부</th>
								</tr>
							</thead>
							<tbody id="categoryList">
								<c:forEach items="${categoryList }" var="categoryVO">
									<tr>
										<td>${categoryVO.category_seq }</td>
										<td>${categoryVO.category_name }</td>
										<td>${categoryVO.reg_id }</td>
										<td><fmt:formatDate value="${categoryVO.reg_dt}" pattern="yyyy-MM-dd"/></td>
										<td>${categoryVO.use_yn }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					
					<button id="categoryReg" type="button" class="btn btn-default">게시판 등록</button>
					
					<!-- pageNavigation -->
					<%-- ${pageNav } --%>
					
					
			</div>
		</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
