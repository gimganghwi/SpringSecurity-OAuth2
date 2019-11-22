<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@include file="includes/header.jsp"%>
	<title>Home</title>
	<meta charset="utf-8">
<div class="wrapper">
	<div class="container-fluid">
		<h1 class="mt-4"> Profile</h1>
		<div class="col-sm-6">
		<table class="table table-hover">
            <tr>
              <th scope="col">authorizedClientRegistrationId</th>
              <td>${authorizedClientRegistrationId}</td>
            </tr>
            <tr>
              <th scope="col">name</th>
              <td>${account.name}</td>
            </tr>
            <tr>
              <th scope="col">principal</th>
              <td>${account.principal}</td>
            </tr>
            <tr>
              <th scope="col">regDate</th>
              <td>${account.regDate}</td>
            </tr>
		</table>
		</div>
	</div>
</div>
<%@include file="includes/footer.jsp"%>
