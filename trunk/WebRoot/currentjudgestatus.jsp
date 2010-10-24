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
		<font color="gray">Current Status</font>
	</h1>
</center>
<div align="center">
<div style="width:75%" align="right">
<form action="searchstatus.action" method="post">
	<s:textfield name="problemId" size="10" maxlength="8" label="Pro.ID"></s:textfield>
	<s:textfield name="author" size="10" label="Author"></s:textfield>
	<s:select list="{'All', 'GCC', 'G++', 'Java', 'Pascal'}" name="language"></s:select>
	<s:select list="{'All', 'Accepted', 'Presentation Error', 'Time Limit Exceeded', 'Memory Limit Exceeded', 'Wrong Answer', 'Compilation Error', 'Runtime Error'}" name="result"></s:select>
	<input type="submit" value="search" />
</form>
</div>
</div>
<table width=75% border=0 align="center" class="item">
	<tr bgcolor=#3d67b9 align="center">
		<th>Date</th>
		<th>Status</th>
		<th>Problem ID</th>
		<th>Language</th>
		<th>Time</th>
		<th>Memory</th>
		<th>Code.Len</th>
		<th>Author</th>
	</tr>
<s:iterator value="solutions" status="st">
	<tr align="center" <s:if test="#st.odd">bgcolor=#dddddd</s:if><s:else>bgcolor=#cccccc</s:else> >
		<td><s:property value="date.toLocaleString()" /></td>
		<td>
			<s:url id="srci" action="showcompileerrorinfo">
				<s:param name="solutionId"><s:property value="id" /></s:param>
			</s:url>
			<s:if test="status == 0"><font color="#ffff00">Judging</font></s:if>
			<s:elseif test="status == 1"><font color="#cc0000">Accepted</font></s:elseif>
			<s:elseif test="status == 2"><font color="#008000">Presentation Error</font></s:elseif>
			<s:elseif test="status == 3"><font color="#008000">Time Limit Exceeded</font></s:elseif>
			<s:elseif test="status == 4"><font color="#008000">Memory Limit Exceeded</font></s:elseif>
			<s:elseif test="status == 5"><font color="#008000">Wrong Answer</font></s:elseif>
			<s:elseif test="status == 7"><font color="#008000">Runtime Error</font></s:elseif>
			<s:elseif test="status == 8"><font color="#008000">System Error</font></s:elseif>
			<s:elseif test="status == 9"><font color="#008000">No Test Case</font></s:elseif>
			<s:else>
				<s:a href="%{srci}">Compilation Error</s:a>
			</s:else>
		</td>
		<td>
			<s:url id="pd" action="problemdetails">
				<s:param name="problemId"><s:property value="problem.problemId + 999" /></s:param>
				<s:param name="title"><s:property value="problem.title" /></s:param>
				<s:param name="description"><s:property value="problem.description" /></s:param>
				<s:param name="input"><s:property value="problem.input" /></s:param>
				<s:param name="output"><s:property value="problem.output" /></s:param>
				<s:param name="sampleInput"><s:property value="problem.sampleInput" /></s:param>
				<s:param name="sampleOutput"><s:property value="problem.sampleOutput" /></s:param>
				<s:param name="tips"><s:property value="problem.tips" /></s:param>
				<s:param name="author"><s:property value="problem.author" /></s:param>
				<s:param name="timeLimit"><s:property value="problem.timeLimit" /></s:param>
				<s:param name="memoryLimit"><s:property value="problem.memoryLimit" /></s:param>
				<s:param name="javaTimeLimit"><s:property value="problem.javaTimeLimit" /></s:param>
				<s:param name="javaMemoryLimit"><s:property value="problem.javaMemoryLimit" /></s:param>
				<s:param name="accept"><s:property value="problem.accept" /></s:param>
				<s:param name="submit"><s:property value="problem.submit" /></s:param>
			</s:url>
			<s:a href="%{pd}"><s:property value="problem.problemId+999" /></s:a>
		</td>
		<td>
			<s:if test="language == 0">GCC</s:if>
			<s:elseif test="language == 1">G++</s:elseif>
			<s:elseif test="language == 2">Java</s:elseif>
			<s:else>Pascal</s:else>
		</td>
		<td>
			<s:if test="useTime == null">--</s:if>
			<s:else><s:property value="useTime"/>(ms)</s:else>
		</td>
		<td>
			<s:if test="useMemory == null">--</s:if>
			<s:else><s:property value="useMemory >> 10"/>(KB)</s:else>
		</td>
		<td>
			<s:url id="ssc" action="showsourcecode">
				<s:param name="solutionId"><s:property value="id" /></s:param>
			</s:url>
			<s:if test="#session.username == user.username">
				<s:a href="%{ssc}"><s:property value="codeLength"/></s:a>
			</s:if>
			<s:else><s:property value="codeLength"/></s:else>(B)
		</td>
		<td>
			<s:url id="ud" action="userdetails.action">
				<s:param name="username"><s:property value="user.username"/></s:param>
			</s:url>
			<s:a href="%{ud}"><s:property value="user.username"/></s:a>
		</td>
	</tr>
</s:iterator>
</table>
<br>
<center>
<s:url id="pp" action="showjudgestatus">
	<s:param name="startJudgeStatus"><s:property value="startJudgeStatus - 16" /></s:param>
</s:url>
<s:if test="startJudgeStatus == 0"></s:if>
<s:else><s:a href="%{pp}"><font size="2"><b>&lt;&lt;&nbsp;Prev&nbsp;Page</b></font></s:a></s:else>
<font size="2"><b>&nbsp;|&nbsp;</b></font>
<s:url id="np" action="showjudgestatus">
	<s:param name="startJudgeStatus"><s:property value="startJudgeStatus + 16" /></s:param>
</s:url>
<s:if test="startJudgeStatus == (count>>>4<<4)"></s:if>
<s:else><s:a href="%{np}"><font size="2"><b>Next&nbsp;Page&nbsp;&gt;&gt;</b></font></s:a></s:else>
</center>
<br>
<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>