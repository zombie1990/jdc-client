<%@ page contentType="text/html; charset=GB2312" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<s:head/>
<title>Welcome to JSU Judge System</title>
<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" media="all" type="text/css" href="/contest/styles/menu.css" />
<link rel="stylesheet" media="all" type="text/css" href="/contest/styles/item.css" />
<link rel="stylesheet" media="all" type="text/css" href="/contest/styles/common.css" />
</head>
<body>


<%@ include file="/head.jsp" %>
<%@ include file="/menu.jsp" %>
<div align=center><font color=red size=5><s:property value="tip"/></font></div><br>


<br>
		<center>
			<h1>
				<font color="gray">Online Acmers</font>
			</h1>
		</center>

<s:append id="userlist">
	<s:param value="%{users}" />
</s:append>
<table width=50% align="center"><tr><td>
<s:iterator value="%{#userlist}">
<s:url id="ud" action="userdetails.action">
<s:param name="username"><s:property /></s:param>
</s:url>
<s:a href="%{ud}">[<s:property />]</s:a>
</s:iterator>
</td></tr></table>
<br><br>
<br>
<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>