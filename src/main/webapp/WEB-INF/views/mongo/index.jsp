<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <style>
      #list{
        border: 1px solid black;
      }
      th, td {
        border: 1px solid #444444;
      }
    </style>
  </head>
  <body>
    <table id="list">
      <thead>
        <tr>
          <th>TITLE</th>
          <th>WRITER</th>
          <th>COUNT</th>
          <th>DATE</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="item" items="${list}">
          <tr>
            <td><a href="/board/mongo/${item.id}">${item.title}</a></td>
            <td>${item.writer}</td>
            <td>${item.count}</td>
            <td>${item.createTime}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <button type="button" id="write">WRITE</button>
  </body>
</html>

<!-- Jquery -->
<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
<script>
  //게시글 작성 페이지 이동
  $('#write').click(function(){
    location.href = "/board/mongo/post";
  })
</script>
