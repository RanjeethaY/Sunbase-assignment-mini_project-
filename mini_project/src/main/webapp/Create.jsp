<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="create"  method="post" "multipart/form-data">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required><br><br>
        <label for="description">Description:</label>
        <textarea id="description" name="content" required></textarea><br><br>
         <label for="date">Date:</label>
         <input type="date" id="date" name="date">
        <label for="video">Select video:</label>
        <input type="file" id="video" name="file"  accept="audio/*,video/*"  required><br><br>
        <button type="submit">Upload</button>
    </form>
</body>
</html>
