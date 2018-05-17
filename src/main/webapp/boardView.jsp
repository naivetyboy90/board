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

<title>게시글 목록</title>

<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">

<script>
	$(function(){
		
		//게시글 tr태그 click 이벤트 처리
		$("#boardList tr").click(function(){
			
			var loginId = $('#loginId').val();
			
			if(loginId==null || loginId==""){
				alert("로그인 후 사용해주시기 바랍니다.");
				document.location = "${pageContext.request.contextPath}/login.jsp";
				return;
			}
			
			
			var board_seq = $(this).find("td:eq(0)").text();
			var del_yn = $(this).find("td:eq(4)").text();
			
			if(del_yn=="Y" || del_yn=="y"){
				alert("삭제된 게시물입니다.");
				return;
			}
			$("#board_seq").val(board_seq);
			
			$("#frm").submit();
		});
		
		$("#boardReg").click(function(){
			
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
	
	<form id="frm" method="get" action="${pageContext.request.contextPath }/getBoard">
		<input type="hidden" id="board_seq" name="board_seq">
		<input type="hidden" id="category_seq" name="category_seq" value="${category_seq}">
	</form>
	
	<form id="insertFrm" method="post" action="${pageContext.request.contextPath }/insertBoardForm">
		<input type="hidden" id="category_seq" name="category_seq" value="${category_seq}">
	</form>
	
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/layout/left.jsp" %>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2 class="sub-header">게시글 목록</h2>
					<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th style="display: none">삭제여부</th>
								</tr>
							</thead>
							<tbody id="boardList">
								<c:forEach items="${boardList}" var="boardVO">
									<tr>
										<td>${boardVO.board_seq}</td>
										
										<c:choose>
											<c:when test="${boardVO.del_yn eq 'N' || 'n'}">
												<td>${boardVO.title}</td>
											</c:when>
											<c:otherwise>
												<td>삭제된 게시글입니다.</td>
										    </c:otherwise>
										</c:choose>
										<td>${boardVO.reg_id}</td>
										<td><fmt:formatDate value="${boardVO.reg_dt}" pattern="yyyy-MM-dd"/></td>
										<td style="display: none">${boardVO.del_yn}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					
					<button id="boardReg" type="button" class="btn btn-default">게시글 작성</button>
					
					${pageNav }
					
					
			</div>
		</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
