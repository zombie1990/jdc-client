<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
Copyright (c) 2003-2010, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
-->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />

		<title>乾城小学</title>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<meta name="robots" content="index, follow" />
		<meta name="googlebot" content="index, follow" />
		<script type="text/javascript" src="<%=basePath%>/editor/ckeditor.js"></script>

		<link rel="stylesheet" type="text/css" href="css/header.css" />
		<link rel="stylesheet" type="text/css" href="css/main.css" />
	</head>

	<body>
		<div>
			<%@ include file="/header.jsp"%>
		</div>


<s:append id="permissionList">
<s:param value="%{mainBoards}" />
</s:append>

		<div id="default-font">
			<div id="nav" align="left">
			  <%@ include file="/menu.jsp"%>
			</div>
			
			<div>
				<table cellpadding="0" cellspacing="0" style="margin: 20px 0 0 0;">
					<tr>
						<td valign="top" id="edit-right-frame" width="800">
							<div>
							<s:form action="doUpload" method="post" enctype="multipart/form-data">
								<s:hidden name="manageType" value="%{manageType}"></s:hidden>
								<s:label for="uploadFile" value="上传文件(图片、视频、资源):" />
								<input id="uploadFile" type="file" name="upload" />
								<input type="submit" value="上传" />
							</s:form>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" id="edit-right-frame" width="800">
							<div id="alerts">
								<noscript>
									<p>
										<strong>CKEditor requires JavaScript to run</strong>. In a browser with no JavaScript
										support, like yours, you should still see the contents (HTML data) and you should
										be able to edit it normally, without a rich editor interface.
									</p>
								</noscript>
							</div>
							<div>
							<s:form action="changeBlog" method="post">
								<s:hidden name="manageType" value="%{manageType}"></s:hidden>
								<s:hidden name="uuid" value="%{uuid}"></s:hidden>
								<s:textfield label="标题" name="title" size="60" labelposition="top" value="%{blog.title}" />
								<s:textfield label="标题图片" name="leftPicURL" size="30" labelposition="top" value="%{blog.leftPicURL}" />
								<s:textfield label="选显图片" name="rightPicURL" size="30" labelposition="top" value="%{blog.rightPicURL}" />
								<s:select list="types" name="type" label="文章类型" labelposition="top" value="%{blog.type}" />
								<label for="editor1">内容:</label>
								<textarea class="ckeditor" name="content"><s:property value="blog.content" escape="false" /></textarea>
								<s:submit value="提交" align="left" />
							</s:form>
							</div>
						</td>
					</tr>
				</table>
			</div >
			
			<div id="footer">
				<%@ include file="/footer.jsp"%>
			</div>
		</div>
		
		
		
		
		
		
	</body>
</html>
