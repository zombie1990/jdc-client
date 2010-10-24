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

<table align="center" bgcolor="#004080" width="75%" cellspacing="10">
	<tr align="center">
		<td><s:a href="/contest/welcome.jsp"><font color="#ffffff" size="5" face="arial"><b>Home</b></font></s:a></td>
		<td><font color="#ffffff" size="5" face="arial"><b>Declaration</b></font></td>
		<td><font color="#ffffff" size="5" face="arial"><b>Problems</b></font></td>
		<td><font color="#ffffff" size="5" face="arial"><b>Ranklist</b></font></td>
		<td><font color="#ffffff" size="5" face="arial"><b>Status</b></font></td>
		<td><font color="#ffffff" size="5" face="arial"><b>Statistics</b></font></td>
	</tr>
</table>

<div align=center><font color=red size=5><s:property value="tip"/></font></div><br>
<br>
<center>
<font color="#004080" size="2" face="arial">Please input the contest password for entry.</font>
<s:form action="logincontest">
	<s:password name="contestPassword"></s:password>
	<s:hidden name="contestId"></s:hidden>
	<s:submit value="Enter"></s:submit>
</s:form>
</center>
<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>