<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@include file="includes/header.jsp"%>

	<div class="container-fluid">
        <h1 class="mt-4">Login</h1>
		<div class="col-sm-6 mt-4">
        <c:forEach items="${urls}" var="url">
        	<a href="${url.value}" class="btn btn-outline-secondary btn-block btn-lg">${url.key} 계정으로 로그인</a>
        </c:forEach>
        </div>
    </div>

<%@include file="includes/footer.jsp"%>
