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

<table width=75% border=0 align="center" class="item">
	<tr bgcolor=#3d67b9 align="center">
		<th>Problem ID</th>
		<th colspan=30>Problem Title</th>
		<th>Operation</th>
	</tr>
<s:iterator value="statisticses" status="st">
	<tr align="center" <s:if test="#st.odd">bgcolor=#dddddd</s:if><s:else>bgcolor=#cccccc</s:else> >
		<td><s:property value="problemIdInContest + 1000"/></td>
		<td colspan=30 align="left">
			<s:url id="cpd" action="contestproblemdetails">
				<s:param name="problemIdInContest"><s:property value="problemIdInContest + 1000"/></s:param>
				<s:param name="problemId"><s:property value="problem.problemId" /></s:param>
				<s:param name="contestId"><s:property value="contestId" /></s:param>
				<s:param name="accept"><s:property value="AC" /></s:param>
				<s:param name="submit"><s:property value="total" /></s:param>
			</s:url>
			<s:a href="%{cpd}"><s:property value="problem.title" /></s:a>
		</td>
		<td>
			<s:url id="deletep" action="deleteproblem">
				<s:param name="id"><s:property value="id" /></s:param>
				<s:param name="contestId"><s:property value="contestId" /></s:param>
			</s:url>
			<s:a href="%{deletep}">delete</s:a>
		</td>
	</tr>
</s:iterator>
</table>
<br>
<center>
<font color="#0000a0" size="2">Input a problem ID as your contest problem</font><br>
<font color="#ff0000" size="2">(For example: 2776)</font>
<s:form action="addproblem">
	<s:fielderror></s:fielderror>
	<s:hidden name="contestId"></s:hidden>
	<input type="text" name="problemId" size="6" maxlength="6">
	<input type="submit" value="Submit">
</s:form>
</center>
<br>
<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>