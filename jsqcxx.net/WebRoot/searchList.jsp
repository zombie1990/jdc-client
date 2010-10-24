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
		<base href="<%=basePath%>" />

		<title>乾城侨心怡海小学</title>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="吉首七小,乾城小学,乾城侨心怡海小学" />
		<meta http-equiv="description" content="湖南吉首市乾城侨心怡海小学，北京实验二小怡海分校" />
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
		
<s:append id="blogList">
<s:param value="%{blogs}" />
</s:append>

		<div id="default-font">
			<div id="nav" align="left">
			  <%@ include file="/menu.jsp"%>
			</div>
			
			<div>
				<table cellpadding="0" cellspacing="0" style="padding: 20px 0 0 0">
					<tr>
						<td valign="top">
							<div id="right-frame">
								<div style="font-size: 16px;font-weight: bolder;margin: 10px 10px 10px 10px;color: #888888;padding:0 0 0 10px;" align="center">搜索结果</div>
								<s:if test="blogs.isEmpty()">
								<br /><br /><br /><br />
								<div align="center">没有搜到任何结果</div>
								<br /><br /><br /><br />
								</s:if>
								<s:else>
								<table cellpadding="0" cellspacing="10">
									<s:iterator value="%{#blogList}">
										<s:url id="showBlogContent" action="showContent">
											<s:param name="uuid" value="uuid" />
										</s:url>
									<tr>
										<td valign="top">
											<table cellpadding="0" cellspacing="0" style="width:410px;margin: 0 0 0 10px;border:#ABCDF8 1px solid;">
												<tr id="hover-bgcolor">
													<td width="100" bgcolor="#f0f0f0">
														<img src="${leftPicURL}" width="100" height="100" />
													</td>
													<td valign="top" align="left">
														<div style="background-color: #808080;padding: 2px 5px 2px 5px;color: white">
															<div align="left">发布时间: <s:property value="postTime.toLocaleString()" /></div>
															<div align="right">浏览次数:<s:property value="clicks" /></div>
														</div>
														<br />
														<div style="padding: 2px 5px 2px 5px;color: #165193;font-size: 14px;">
														<s:a href="%{showBlogContent}" cssStyle="color: #808080">
															<s:property value="title" />
														</s:a>
														</div>
													</td>
												</tr>
											</table>
										</td>
										<td>
											<div style="padding: 0 10px 10px 10px">
											<s:if test="rightPicURL != null">
												<a href="${rightPicURL}">
													<img style="border:#101651 1px solid;" src="${rightPicURL}" width="160" height="120" />
												</a>
											</s:if>
											<s:else></s:else>
											</div>
										</td>
									</tr>
									</s:iterator>
								</table>
								</s:else>
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
