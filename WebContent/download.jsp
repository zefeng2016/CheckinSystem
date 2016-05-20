<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>下载页面</title>
</head>
<body>
	<form action="/Ch24/DownFile" method="post">
		<input type="hidden" name="filename" value="test.txt"/>
		<input type="submit" value="下载" />
	</form>
	
	<a href="./FileDown.jsp?fileName=test.txt">链接下载</a>
</body>
</html>