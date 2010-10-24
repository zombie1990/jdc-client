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

		<title>吉首市乾城侨心怡海小学</title>
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


<s:append id="commentList">
<s:param value="%{comments}" />
</s:append>

		<div id="default-font">
			<div id="nav" align="left">
			  <%@ include file="/menu.jsp"%>
			</div>
			
			<div>
				<table cellpadding="0" cellspacing="0" style="margin: 20px 0 0 0;border:#e0e0e0 1px solid;" width="800">
					<tr>
						<td valign="top" align="center">
							<font style="font-size: 40px;font-weight: bolder;font-family: 宋体;color: #101651"><s:property value="blog.title" /></font>
						</td>
					</tr>
					<tr><td><br /></td></tr>
					<tr>
						<td valign="top" align="center">
							<font style="font-size: 13px;font-family: 宋体;color: #101651">
								作者:<s:property value="blog.user.username" />&nbsp;&nbsp;&nbsp;&nbsp;
								发布时间:<s:property value="blog.postTime.toLocaleString()" />&nbsp;&nbsp;&nbsp;&nbsp;
								浏览次数:<s:property value="blog.clicks" />
							</font>
						</td>
					</tr>
					<tr><td><hr /></td></tr>
					<tr>
						<td valign="top" height="500">
							<br /><br />
							<div>
								<s:property value="blog.content" escape="false" />
							</div>
						</td>
					</tr>
				</table>
			</div >
			
			<s:if test="blog.type eq 'bw'">
				<br /><br /><br /><br />
				<div style="border-top-width:1px; border-top-style:dotted; border-top-color: #808080;width: 800px">
					<br />
					<s:form action="addComment" method="post">
						<s:textarea name="reply" value="请在这里留言" rows="4" cols="90" />
						<s:hidden name="blogId" value="%{blog.uuid}" />
						<s:submit value="提交" />
					</s:form>
				</div>
				<div style="border-bottom-width:1px; border-bottom-style:dotted; border-bottom-color: #808080;width: 800px">
					<table>
						<tr><td><br /><br /></td></tr>
						<s:iterator value="%{#commentList}">
						<tr>
							<td bgcolor="#e0e0e0" width="800"><s:property value="user.username" />&nbsp;留言于:<s:property value="postTime.toLocaleString()" /></td>
						</tr>
						<tr>
							<td style="padding: 15px 10px 15px 10px;"><s:property value="content" escape="true" /></td>
						</tr>
						</s:iterator>
					</table>
				</div>
			</s:if>
			<s:else>
				<br />
				<div style="border-bottom-width:1px; border-bottom-style:dotted; border-bottom-color: #808080;width: 800px"></div>
			</s:else>
			
			<div id="footer">
				<%@ include file="/footer.jsp"%>
			</div>
		</div>
		
		
		
		
		
		
	</body>
</html>
