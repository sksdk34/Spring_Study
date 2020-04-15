<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
  <sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal.username" />
    <form action="/board/logout" method="POST">
      <button type="submit" name="button">LOGOUT</button>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
  </sec:authorize>
  <sec:authorize access="isAnonymous()">
    <button type="button" id="login">LOGIN</button>
  </sec:authorize>
</body>
</html>

<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
<script>
  $('#login').click(function(){
    location.href="/board/security/login";
  })
</script>
