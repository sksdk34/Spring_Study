<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>
    <form action="posts" method="post">
      <table>
        <tr>
          <td><label>Title</label></td>
          <td><input type="text" name="title"></td>
        </tr>
        <tr>
          <td><label>Content</label></td>
          <td><input type="text" name="content"></td>
        </tr>
        <tr>
          <td> <button type="submit">WRITE</button> </td>
        </tr>
      </table>
    </form>
  </body>
</html>

<!-- Jquery -->
<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
