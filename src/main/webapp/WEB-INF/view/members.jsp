<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@include file="includes/header.jsp"%>
	<title>Home</title>
	<meta charset="utf-8">
<div class="wrapper">
	<div class="container-fluid">
		<h1 class="mt-4"> Members</h1>
		<table class="table table-hover">
		<thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">name</th>
              <th scope="col">principal name</th>
              <th scope="col">regDate</th>
              <th scope="col">management</th>
            </tr>
        </thead>
		<c:forEach items="${accounts}" var="account">
		    <tr>
		        <td><c:out value="${account.id}"/></td>
		        <td><c:out value="${account.name}"/></td>
		        <td><c:out value="${account.principal}"/></td>
		        <td><c:out value="${account.regDate}"/></td>
		        <td>
		            <a href="#" class="btn btn-primary" role="button">delete</a>
		        </td>
		    </tr>
		</c:forEach>
		</table>
	</div>
</div>
<%@include file="includes/footer.jsp"%>
