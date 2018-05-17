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

<title>게시물 상세보기</title>


<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "${pageContext.request.contextPath }/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});

	// 수정버튼 클릭이벤트
	$("#modifyBoard").click(function(){
		if(confirm("수정하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			if(validation()) {
				$("#frm").submit();
				$('#frm').attr('action', '${pageContext.request.contextPath}/modifyBoard');
				$('#frm').attr('mothod', 'post');
				$('#frm').submit();
			}
		}
	})
});

// 필수값 Check
function validation(){
	var contents = $.trim(oEditors[0].getContents());
	var title = $("#boardTitle").val();
	title = $.trim(title);
	
	if(title == '' || title == null){
		alert("제목을 입력하세요.");
		return false;
	}
	
	
	if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
		oEditors.getById['smarteditor'].exec('FOCUS');
		alert("내용을 입력하세요.");
		return false;
	}

	return true;
}




$(function(){
		
		
	$('#deleteBoard').click(function(){
		$('#frm').attr('action', '${pageContext.request.contextPath}/deleteBoard');
		$('#frm').attr('mothod', 'post');
		$('#frm').submit();
	})
		
		
	$('#insertReply').click(function(){
			
		var loginId = $('#loginId').val();
			
		if(loginId==null || loginId==""){
			alert("로그인 후 사용해주시기 바랍니다.");
			document.location = "${pageContext.request.contextPath}/login.jsp";
			return;
		}
			
		$('#frm').attr('action', '${pageContext.request.contextPath}/insertReply');
		$('#frm').attr('mothod', 'post');
		$('#frm').submit();
	})
	
	$("#replyBoard").click(function(){
			
			var loginId = $('#loginId').val();
			
			if(loginId==null || loginId==""){
				alert("로그인 후 사용해주시기 바랍니다.");
				document.location = "${pageContext.request.contextPath}/login.jsp";
				return;
			}
			
			$('#replyFrm').attr('action', '${pageContext.request.contextPath}/insertBoardForm');
			$('#replyFrm').attr('mothod', 'post');
			$("#replyFrm").submit();
			
	});
	
		
	$('[id^=deleteReply]').click(function(){
			
		var id = $(this).attr("id");
		var delSeq = id.replace("deleteReply", "");
			
		$("#comment_seq").val(delSeq);
			
		$('#frm').attr('action', '${pageContext.request.contextPath}/deleteReply');
		$('#frm').attr('mothod', 'post');
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
			
				<form id="replyFrm" class="form-horizontal" role="form" method="post" action="">
					<input type="hidden" id="loginId" value="${loginId}"> 
					<input type="hidden" name="board_seq" value="${boardVO.board_seq}">
					<input type="hidden" name="category_seq" value="${category_seq}">
					<input type="hidden" id="group_seq" name="group_seq" value="${boardVO.group_seq}">
					<input type="hidden" id="pboard_seq" name="pboard_seq" value="${boardVO.board_seq}">
				</form>
			
				<form id="frm" class="form-horizontal" role="form" method="post" action="">
					<input type="hidden" id="loginId" value="${loginId}"> 
					<input type="hidden" name="board_seq" value="${boardVO.board_seq}">
					<input type="hidden" name="category_seq" value="${category_seq}">
					
					<div class="form-group">
						<label class="col-sm-2 control-label">게시글 번호</label>
						<div class="col-sm-10">
							<label class="control-label">${boardVO.board_seq}</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<c:choose>
								<c:when test="${loginId==boardVO.reg_id}">
									<input type="text" size="100px" name="boardTitle" id="boardTitle" value="${boardVO.title}">
								</c:when>
								<c:otherwise>
									<label class="control-label">${boardVO.title}</label>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">작성자</label>
						<div class="col-sm-10">
							<label class="control-label">${boardVO.reg_id}</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">작성일</label>
						<div class="col-sm-10">
							<label class="control-label"><fmt:formatDate
									value="${boardVO.reg_dt}" pattern="yyyy-MM-dd" /></label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">내용</label>
						<div class="col-sm-10 col-sm-offset-2">
							
							<c:choose>
								<c:when test="${loginId==boardVO.reg_id}">
									<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;">${boardVO.content}</textarea>
								</c:when>
								<c:otherwise>
									<label class="control-label">${boardVO.content}</label>
								</c:otherwise>
							</c:choose>
						
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10 col-sm-offset-2">
							<c:forEach items="${attachList}" var="attachVO">
								<a href="${pageContext.request.contextPath }/attachDown?fileName=${attachVO.attach_route }">${attachVO.attach_route }</a><br>
							</c:forEach>
						</div>
					</div>

					<c:choose>
						<c:when test="${loginId==boardVO.reg_id}">
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-10">
									<button type="button" id="modifyBoard" class="btn btn-default">수정</button>
									<button type="button" id="deleteBoard" class="btn btn-default">삭제</button>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-10">
									<button type="button" id="replyBoard" class="btn btn-default">답글작성</button>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
					
					<h1>댓글</h1>
					<div class="table-responsive">
					
					
					<table class="table table-hover" style="width: 100%; height: auto;" >
						<thead style="text-align: center;">
							<tr>
								<th>내용</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>삭제</th>
							<tr>
						</thead>
						<tbody id="replyList">
						<c:forEach items="${replyList}" var="replyVO">
					
							<c:choose>
								<c:when test="${replyVO.del_yn eq 'N' || 'n'}">
										<tr>
											<c:choose>
												<c:when test="${replyVO.reg_id eq loginId}">
													<td>${replyVO.content}</td>
													<td>${replyVO.reg_id}</td>
													<td><fmt:formatDate value="${replyVO.reg_dt}" pattern="yyyy-MM-dd" /></td>
													<td><button type="button" id="deleteReply${replyVO.comment_seq}" class="btn btn-default">삭제</button></td>
												</c:when>
												<c:otherwise>
													<td>${replyVO.content}</td>
													<td>${replyVO.reg_id}</td>
													<td colspan="2"><fmt:formatDate value="${replyVO.reg_dt}" pattern="yyyy-MM-dd" /></td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:when>
								<c:otherwise>
									<tr>
										<td colspan="4">삭제된 댓글입니다.</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					
						</tbody>
					</table>
					</div>
					
					<div class="form-group">
						<div class="col-sm-10">
							<input type="text" class="form-control" id="replyContent" name="replyContent" placeholder="댓글 내용을 입력해주세요">
							<button type="button" id="insertReply" class="btn btn-default">등록</button>
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
