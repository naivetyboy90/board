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

<title>게시글 신규작성</title>

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

	// 전송버튼 클릭이벤트
	$("#savebutton").click(function(){
		if(confirm("저장하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			if(validation()) {
				$("#frm").submit();
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

</script>


</head>

<body>
	
	<%@ include file="/layout/header.jsp" %>
	
	<input type="hidden" id="loginId" value="${loginId}">
	
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/layout/left.jsp" %>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				
				<form action="${pageContext.request.contextPath }/replyBoard" method="post" id="frm" enctype="multipart/form-data">
					<h1>${group_seq}</h1>
					<input type="hidden" name="group_seq" value="${group_seq}">
					<input type="hidden" name="pboard_seq" value="${pboard_seq}">
					<input type="hidden" name="category_seq" value="${category_seq}">
					<input type="hidden" name="loginId" value="${loginId}">
					
					<div class="col-sm-5">
						<input type="text" class="form-control" id="boardTitle" name="boardTitle" placeholder="제목"><br>
					</div>
				
					<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;"></textarea> 
					
					<div class="form-group col-sm-10">
						<label class="col-sm-1">첨부화일1</label>
						<input type="file" name="attachFile">
					</div>
					<div class="form-group col-sm-10">
						<label class="col-sm-1">첨부화일2</label>
						<input type="file" name="attachFile">
					</div>
					<div class="form-group col-sm-10">
						<label class="col-sm-1">첨부화일3</label>
						<input type="file" name="attachFile">
					</div>
					<div class="form-group col-sm-10">
						<label class="col-sm-1">첨부화일4</label>
						<input type="file" name="attachFile">
					</div>
					<div class="form-group col-sm-10">
						<label class="col-sm-1">첨부화일5</label>
						<input type="file" name="attachFile">
					</div>
					<div class="form-group col-sm-10">
						<input type="button" id="savebutton" value="작성" />
					</div>
				
				</form>
				
					
			</div>
		</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
