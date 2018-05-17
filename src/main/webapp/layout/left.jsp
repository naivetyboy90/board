<%@page import="category.service.CategoryService"%>
<%@page import="category.service.CategoryServiceInf"%>
<%@page import="category.model.CategoryVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-3 col-md-2 sidebar">

	<ul class="nav nav-sidebar">
		<li><a href="${pageContext.request.contextPath}/manageCategory">게시판관리</a></li>
		<c:forEach items="${categoryList }" var="CategoryVO">
			<c:if test="${CategoryVO.use_yn == 'y'}" >
				<li><a href="${pageContext.request.contextPath}/boardView?category_seq=${CategoryVO.category_seq}">${CategoryVO.category_name }</a></li>
			</c:if>
		</c:forEach>
	</ul>
	
</div>