<%@ page language="java"%>
<%@page import="java.net.URLEncoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = "/upload/";//即将下载的文件的相对路径  
	String fileName = (String) request.getParameter("fileName");//下载文件时显示的文件保存名称 
	response.setContentType("application/x-download");//设置为下载application/x-download
	//下载文件时显示的文件保存名称  
	fileName = URLEncoder.encode(fileName, "utf-8");
	response.addHeader("Content-Disposition", "attachment;filename="
			+ fileName);

	try {
		RequestDispatcher dis = application.getRequestDispatcher(path
				+ fileName);
		if (dis != null) {
			dis.forward(request, response);
		}
		response.flushBuffer();
		out.clear();//必须清除out对象，否则会和下载文件流冲突
		out = pageContext.pushBody();
	} catch (Exception e) {
		e.printStackTrace();
	} 
%>

