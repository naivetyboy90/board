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

<title>게시판 상세화면</title>

<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">

<script>
	$(function(){
		
		$('#changeUse').click(function(){
			$('#frm').attr('action','${pageContext.request.contextPath}/changeUse');
			$('#frm').attr('method','post');
			$('#frm').submit();
		})
		
	})

</script>

</head>

<body>

	<%@ include file="/layout/header.jsp" %>
	
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/layout/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<form id="frm" class="form-horizontal" role="form" method="post">
				
				
					<input type="hidden" name="category_seq" value="${categoryVO.category_seq }">
					<input type="hidden" name="use_yn" value="${categoryVO.use_yn }">
					<div class="form-group">
						<label class="col-sm-2 control-label">게시판 번호</label>
						<div class="col-sm-10">
							<label class="control-label">${categoryVO.category_seq }</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">게시판 이름</label>
						<div class="col-sm-10">
							<label class="control-label">${categoryVO.category_name }</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">만든사람ID</label>
						<div class="col-sm-10">
							<label class="control-label">${categoryVO.reg_id }</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">만든 날짜</label>
						<div class="col-sm-10">
							<label class="control-label">${categoryVO.reg_dt }</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">사용여부</label>
						<div class="col-sm-10">
							<label class="control-label">${categoryVO.use_yn }</label>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="changeUse" class="btn btn-default">사용여부 변경</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
