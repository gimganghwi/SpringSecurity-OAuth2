<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@include file="includes/header.jsp"%>

	<div class="container-fluid">
        <h1 class="mt-4">스프링 시큐리티 소셜로그인</h1>
        <a href="https://docs.google.com/document/d/1ao_RHiaLdZZIc2Y3vw5SlQ4HfZIvIDnK1gTEKl75Fnw/edit?usp=sharing">https://docs.google.com/document/d/1ao_RHiaLdZZIc2Y3vw5SlQ4HfZIvIDnK1gTEKl75Fnw/edit?usp=sharing</a>
        <h2 class="mt-4">뷰 설명</h2>
        <h4 class="mt-1">/profile</h4>
        <p>
         - 인증된 유저만 접근할 수 있다.<br>
         - 인증된 경우 콘텍스트의 인증 정보를 가지고 데이터를 질의한 결과를 출력한다.<br>
         - 자신의 데이터를 수정할 수 있다.(미구현)<br>
        </p>
        <h4 class="mt-1">/members</h4>
        <p>
         - 가입한 사람들 목록을 출력<br>
         - ADMIN 권한이 있으면 가입 정보를 지울 수 있다.(미구현)<br>
        </p>
        <h2 class="mt-4">정보 유지</h2>
         - 최초 로그인시에 인증 정보와 시간을 기록한다.<br>
         - 그 다음번 로그인인 경우에는 테이블에 저장된 인증 정보를 확인한다.<br>
        </div>

<%@include file="includes/footer.jsp"%>
