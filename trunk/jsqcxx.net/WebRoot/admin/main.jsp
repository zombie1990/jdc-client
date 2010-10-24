<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<s:head />
		<base href="<%=basePath%>" />

		<title>乾城小学</title>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<meta name="robots" content="index, follow" />
		<meta name="googlebot" content="index, follow" />
		<script type="text/javascript" src="editor/ckeditor.js"></script>

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
				<table cellpadding="0" cellspacing="0" style="padding: 20px 0 0 0">
					<tr>
						<td valign="top">
							<table cellpadding="0" cellspacing="0">
								<tr>
									<td id="left-frame3">
										<div align="center">管理列表</div>
										<ul>
											<s:iterator value="%{#permissionList}">
												<s:url id="entryManage" action="showManage">
													<s:param name="manageType" value="permissionId" />
												</s:url>
		     									<li><s:a href="%{entryManage}"><s:property value="permissionName" /></s:a></li>
											</s:iterator>
										</ul>
									</td>
								</tr>
							</table>
						</td>
						<td valign="top">
							<div id="right-frame">
								<%@ include file="/admin/gl_gerenxinxi.jsp"%>
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
