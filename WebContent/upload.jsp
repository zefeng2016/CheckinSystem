<%@ page contentType="text/html;charset=utf-8"%>
<html>
	<head>
		<title>文件上传</title>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
	</head>
	<body>
		<FORM METHOD="POST" ACTION="/Ch24/UploadFile"
			ENCTYPE="multipart/form-data">
			<p>
				请选择要上传的文件
			</p>
			<p>
				<input type="FILE" name="FILE1" size="30">
			</p>
			<p>
				请选择要上传的文件
			</p>
			<p>
				<input type="FILE" name="FILE2" size="30">
			</p>
			<p>
				请选择要上传的文件
			</p>
			<p>
				<input type="FILE" name="FILE3" size="30">
			</p>
				<input type="submit" value="上传">
		</FORM>
	</body>
</html>
