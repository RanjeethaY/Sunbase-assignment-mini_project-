<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update">
        <div class="main">
     Title  <input type="text" name="title">]
     Content  <input type="text" name="content">
     option  <input list="op" name="option">
      <datalist id="op">
        <option value="Audio"></option>
        <option value="Video"></option>
      </datalist>
</div>
<button>SUBMIT</button>
    </form>
</body>
</html>