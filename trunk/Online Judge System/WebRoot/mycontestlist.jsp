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
		<font color="gray">My Contests</font>
	</h1>
</center>

<s:url id="scheduled" action="mycontestlist">
	<s:param name="status">0</s:param>
	<s:param name="contestPage">1</s:param>
</s:url>
<s:url id="running" action="mycontestlist">
	<s:param name="status">1</s:param>
	<s:param name="contestPage">1</s:param>
</s:url>
<s:url id="ended" action="mycontestlist">
	<s:param name="status">2</s:param>
	<s:param name="contestPage">1</s:param>
</s:url>

<center>
<s:a href="%{scheduled}"><font color="green" size=2><b>Scheduled</b></font></s:a>
<s:a href="%{running}"><font color="red" size=2><b>Running</b></font></s:a>
<s:a href="%{ended}"><font color="#808080" size=2><b>Ended</b></font></s:a>
</center>
<br>
<table align="center" width="75%" border=0 class="item">
	<tr bgcolor=#3d67b9 align="center">
		<th>Type</th>
		<th>Title</th>
		<th>Start Time</th>
		<th>Persist</th>
		<th>Status</th>
		<th>Editor</th>
		<th>Handler</th>
	</tr>
<s:iterator value="contests" status="st">
	<tr align="center" <s:if test="#st.odd">bgcolor=#dddddd</s:if><s:else>bgcolor=#cccccc</s:else> >
		<td>
			<s:if test="password != null"><font color="green">Private</font></s:if>
			<s:else><font color="red">Public</font></s:else>
		</td>
		<td align="left">
			<s:url id="declaration" action="showdeclaration">
				<s:param name="contestId"><s:property value="contestId" /></s:param>
			</s:url>
			<s:a href="%{declaration}"><s:property value="title" /></s:a>
		</td>
		<td><s:property value="startTime.toLocaleString()" /></td>
		<td>
			<s:property value="(endTime.getTime()-startTime.getTime())/3600000" />(h)
			<s:property value="((endTime.getTime()-startTime.getTime())/60000 - (endTime.getTime()-startTime.getTime())/3600000*60)" />(min)
		</td>
		<td>
			<s:if test="status == 0"><font color="green">Scheduled</font></s:if>
			<s:elseif test="status == 1"><font color="red">Running</font></s:elseif>
			<s:else><font color="grey">Ended</font></s:else>
		</td>
		<td>
			<s:url id="ec" action="editcontest">
				<s:param name="contestId"><s:property value="contestId"/></s:param>
				<s:param name="title"><s:property value="title"/></s:param>
				<s:param name="description"><s:property value="description"/></s:param>
				<s:param name="password"><s:property value="password"/></s:param>
				<s:param name="startTime"><s:property value="startTime"/></s:param>
				<s:param name="endTime"><s:property value="endTime"/></s:param>
			</s:url>
			<s:if test="status==0"><s:a href="%{ec}">edit</s:a></s:if>
			<s:else>--</s:else>
		</td>
		<td>
			<s:url id="hc" action="handlecontest">
				<s:param name="contestId"><s:property value="contestId"/></s:param>
			</s:url>
			<s:if test="status==0"><s:a href="%{hc}">enter</s:a></s:if>
			<s:else>--</s:else>
		</td>
	</tr>
</s:iterator>
</table>
<br>
<center>
<s:if test="count>>>4 > 0">
	<s:url id="pp" action="contestlist">
		<s:param name="contestPage"><s:property value="contestPage - 1" /></s:param>
	</s:url>
	<s:if test="contestPage == 1"></s:if>
	<s:else><s:a href="%{pp}"><font size="2"><b>Previous</b></font></s:a></s:else>
	
	<s:url id="start" action="contestlist">
		<s:param name="contestPage">1</s:param>
	</s:url>
	<s:if test="contestPage == 1"><font size="2"><b>1</b></font></s:if>
	<s:else><s:a href="%{start}"><font size="2"><b>1...</b></font></s:a></s:else>
	
	<s:if test="contestPage > 1 && contestPage <= (count>>>4)">
		<s:if test="count%16 == 0"></s:if>
		<s:else><font size="2"><b><s:property value="contestPage" /></b></font></s:else>
	</s:if>
	
	<s:url id="end" action="contestlist">
		<s:param name="contestPage"><s:property value="lastPage" /></s:param>
	</s:url>
	<s:if test="contestPage == lastPage"><font size="2"><b><s:property value="lastPage" /></b></font></s:if>
	<s:else><s:a href="%{end}"><font size="2"><b>...<s:property value="lastPage" /></b></font></s:a></s:else>
	
	<s:url id="np" action="contestlist">
		<s:param name="contestPage"><s:property value="contestPage + 1" /></s:param>
	</s:url>
		<s:if test="contestPage == lastPage"></s:if>
		<s:else><s:a href="%{np}"><font size="2"><b>Next</b></font></s:a></s:else>
</s:if>
</center>

<br>
<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>