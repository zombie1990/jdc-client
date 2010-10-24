<%@ page contentType="text/html; charset=GB2312" %>
<%@page import="com.jsu.hibernate.domains.Problem"%>
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
<s:url id="up" action="adminproblemlist">
	<s:param name="pageNum">1</s:param>
	<s:param name="contestProblem">NO</s:param>
</s:url>
<s:url id="cp" action="adminproblemlist">
	<s:param name="pageNum">1</s:param>
	<s:param name="contestProblem">YES</s:param>
</s:url>
<center>
	<h1>
		<font color="gray">Admin Problem List</font>
	</h1>
<br>
	<s:a href="%{up}"><font color="green" size=2><b>Normal Problems</b></font></s:a>
&nbsp;
	<s:a href="%{cp}"><font color="red" size=2><b>Contest Problems</b></font></s:a>
<br>
</center>
<table width=75% border=0 align="center" cellspacing="10">
<tr><td> 
<strong><font color="#0000ff">Volume:</font></strong>&nbsp; 
<s:iterator value="pages">
	<s:url id="apl" action="adminproblemlist">
		<s:param name="pageNum"><s:property/></s:param>
		<s:param name="contestProblem"><s:property value="contestProblem"/></s:param>
	</s:url>
	<s:a href="%{apl}">[<s:property/>]</s:a>
</s:iterator>
</td></tr>
</table>
<div align="center">
<div style="width:75%" align="right">
<form action="adminsearchproblem.action" method="post">
	<s:hidden name="contestProblem"></s:hidden>
	<s:select list="grades" name="level"></s:select>
	<s:select list="genres" name="type"></s:select>
	<input type="submit" value="search" />
</form>
</div>
</div>
<table width=75% border=0 align="center" class="item">
	<tr bgcolor=#3d67b9 align="center">
		<th>ID</th>
		<th colspan=50>Title</th>
		<th>Ratio</th>
		<th>Content</th>
		<th>TestCase</th>
		<s:if test='contestProblem == "NO"'></s:if>
		<s:else><th>ToNormal</th></s:else>
	</tr>
<s:iterator value="problems" status="st">
	<tr align="center" <s:if test="#st.odd">bgcolor=#dddddd</s:if><s:else>bgcolor=#cccccc</s:else> >
		<td><s:property value="problemId + 999" /></td>
		<td colspan=50 align="left">
			<s:url id="pd" action="problemdetails">
				<s:param name="problemId"><s:property value="problemId + 999" /></s:param>
				<s:param name="title"><s:property value="title" /></s:param>
				<s:param name="description"><s:property value="description" /></s:param>
				<s:param name="input"><s:property value="input" /></s:param>
				<s:param name="output"><s:property value="output" /></s:param>
				<s:param name="sampleInput"><s:property value="sampleInput" /></s:param>
				<s:param name="sampleOutput"><s:property value="sampleOutput" /></s:param>
				<s:param name="tips"><s:property value="tips" /></s:param>
				<s:param name="author"><s:property value="author" /></s:param>
				<s:param name="timeLimit"><s:property value="timeLimit" /></s:param>
				<s:param name="memoryLimit"><s:property value="memoryLimit" /></s:param>
				<s:param name="javaTimeLimit"><s:property value="javaTimeLimit" /></s:param>
				<s:param name="javaMemoryLimit"><s:property value="javaMemoryLimit" /></s:param>
				<s:param name="accept"><s:property value="accept" /></s:param>
				<s:param name="submit"><s:property value="submit" /></s:param>
			</s:url>
			<s:a href="%{pd}"><s:property value="title" /></s:a>
		</td>
		<td>
			<s:if test="submit == 0">0%&nbsp;</s:if>
			<s:else><s:property value="accept*100/submit" />.<s:property value="accept*1000/submit - accept*100/submit*10" /><s:property value="accept*10000/submit - accept*1000/submit*10" />%&nbsp;</s:else>
		</td>
		<td>
			<s:url id="ep" action="editproblem">
				<s:param name="problemId"><s:property value="problemId" /></s:param>
				<s:param name="title"><s:property value="title" /></s:param>
				<s:param name="description"><s:property value="description" /></s:param>
				<s:param name="input"><s:property value="input" /></s:param>
				<s:param name="output"><s:property value="output" /></s:param>
				<s:param name="sampleInput"><s:property value="sampleInput" /></s:param>
				<s:param name="sampleOutput"><s:property value="sampleOutput" /></s:param>
				<s:param name="tips"><s:property value="tips" /></s:param>
				<s:param name="author"><s:property value="author" /></s:param>
				<s:param name="timeLimit"><s:property value="timeLimit" /></s:param>
				<s:param name="memoryLimit"><s:property value="memoryLimit" /></s:param>
				<s:param name="javaTimeLimit"><s:property value="javaTimeLimit" /></s:param>
				<s:param name="javaMemoryLimit"><s:property value="javaMemoryLimit" /></s:param>
				<s:param name="type"><s:property value="type" /></s:param>
			</s:url>
			<s:a href="%{ep}">Edit Problem</s:a>
		</td>
		<td>
			<s:url id="stc" action="showtestcase">
				<s:param name="problemId"><s:property value="problemId + 999" /></s:param>
			</s:url>
			<s:a href="%{stc}">Edit TestCase</s:a>
		</td>
		<s:if test='contestProblem == "NO"'></s:if>
		<s:else>
		<td>
		<s:url id="oktnm" action="onekeytonormal">
			<s:param name="problemId"><s:property value="problemId" /></s:param>
			<s:param name="pageNum"><s:property value="pageNum" /></s:param>
			<s:param name="contestProblem"><s:property value="contestProblem" /></s:param>
		</s:url>
		<s:if test='defunct == "N"'></s:if>
		<s:else><s:a href="%{oktnm}">OneKey</s:a></s:else>
		</td>
		</s:else>
	</tr>
</s:iterator>
</table>

<br>
<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>