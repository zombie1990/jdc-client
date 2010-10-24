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

<table align="center">
<tr><th bgcolor="#bbbbbb">Content</th></tr>
<tr><td bgcolor="#dddddd">
<s:property value="content" escape="false"/>
</td></tr>
</table>
<br>
<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>