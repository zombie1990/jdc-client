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
<table width=75% border=0 align="center">
<tr><td> 
<strong><font color="#0000ff">Volume:</font></strong>&nbsp; 
<s:iterator value="pages">
	<s:url id="pl" action="problemlist">
		<s:param name="pageNum"><s:property/></s:param>
	</s:url>
	<s:a href="%{pl}">[<s:property/>]</s:a>
</s:iterator>
</td></tr>
</table>
<div align="center">
<div style="width:75%" align="right">
<form action="searchproblem.action" method="post">
	<s:textfield name="searchKey"></s:textfield>
	<s:select list="{'ID', 'Title'}" name="searchType"></s:select>
	<input type="submit" value="search" />
</form>
</div>
</div>
<table width=75% border=0 align="center" class="item">
	<tr bgcolor=#3d67b9 align="center">
		<th>ID</th>
		<th colspan=50>Title</th>
		<th>Ratio (accept / submit)</th>
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
			(<s:property value="accept" />&nbsp;/&nbsp;<s:property value="submit" />)
		</td>
	</tr>
</s:iterator>
</table>

<br>
<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>