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
<div align="center">

<font color="#004080" size="12" face="Arial Black">
	<s:property value="user.username"/>
</font>
<br><br>
<font color="#004080" size="2">
	registered on&nbsp;&nbsp;&nbsp;<font color="#800000"><s:property value="user.registerTime.toLocaleString()"/></font>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	from: &nbsp;&nbsp;&nbsp;<font color="#800000"><s:property value="school"/></font>
<br>
last access on&nbsp;&nbsp;&nbsp;<font color="#800000"><s:property value="user.accessTime.toLocaleString()"/></font>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
e-mail:&nbsp;&nbsp;&nbsp;<font color="#800000"><s:property value="user.email"/></font>
<br><br>
motto:
<br>
<font color="#800000"><s:property value="motto"/></font>
<br>
</font>
<br><br>
<table width=25% border="1px" cellspacing="0px" style="border-collapse:collapse;color=#004080;font-size=14" bordercolor=blue>
	<tr>
		<td align="left">Rank:</td>
		<td align="right" style="color=#800000"><s:property value="rank"/></td>
	</tr>
	<tr>
		<td align="left">Problems Submitted:</td>
		<td align="right" style="color=#800000"><s:property value="user.solved + user.unSolved"/></td>
	</tr>
	<tr>
		<td align="left">Problems Solved:</td>
		<td align="right" style="color=#800000"><s:property value="user.solved"/></td>
	</tr>
	<tr>
		<td align="left">Submissions:</td>
		<td align="right" style="color=#800000"><s:property value="user.submit"/></td>
	</tr>
	<tr>
		<td align="left">Accepted:</td>
		<td align="right" style="color=#800000"><s:property value="user.accept"/></td>
	</tr>
</table>
<br><br>
<font color="#004080" size="3">solved problems</font>
<br>
<table width=50%><tr><td>
<s:iterator value="solvedProblems">
	<s:url action="searchsolved" id="searchS">
		<s:param name="solvedProblemId"><s:property value="problemId"/></s:param>
		<s:param name="username"><s:property value="user.username"/></s:param>
	</s:url>
	<s:a href="%{searchS}">[<s:property value="problemId+999"/>]</s:a>
</s:iterator>

</td></tr></table>
</div>
<br>
<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>