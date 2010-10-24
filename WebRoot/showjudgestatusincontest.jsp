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

<s:url action="showdeclaration" id="sdInSs">
	<s:param name="contestId">
	<s:property value="contestId"/>
	</s:param>
</s:url>
<s:url action="showproblems" id="spInSs">
	<s:param name="contestId">
	<s:property value="contestId"/>
	</s:param>
</s:url>
<s:url action="showstatus" id="ssInSs">
	<s:param name="contestId">
	<s:property value="contestId"/>
	</s:param>
</s:url>
<s:url action="showranklist" id="srInSs">
	<s:param name="contestId">
	<s:property value="contestId"/>
	</s:param>
</s:url>
<s:url action="showstatistics" id="sstInSs">
	<s:param name="contestId">
	<s:property value="contestId"/>
	</s:param>
</s:url>

<table align="center" bgcolor="#004080" width="75%" cellspacing="10">
	<tr align="center">
		<td><s:a href="/contest/welcome.jsp"><font color="#ffffff" size="5" face="arial"><b>Home</b></font></s:a></td>
		<td><s:a href="%{sdInSs}"><font color="#ffffff" size="5" face="arial"><b>Declaration</b></font></s:a></td>
		<td><s:a href="%{spInSs}"><font color="#ffffff" size="5" face="arial"><b>Problems</b></font></s:a></td>
		<td><s:a href="%{ssInSs}"><font color="#ffffff" size="5" face="arial"><b>Status</b></font></s:a></td>
		<td><s:a href="%{srInSs}"><font color="#ffffff" size="5" face="arial"><b>Ranklist</b></font></s:a></td>
		<td><s:a href="%{sstInSs}"><font color="#ffffff" size="5" face="arial"><b>Statistics</b></font></s:a></td>
	</tr>
</table>

<div align=center><font color=red size=5><s:property value="tip"/></font></div><br>
<br>
<center>
	<h2><strong>
		<s:property value="contest.title" />
	</strong></h2>
	<font size="2" color="green">Start Time:&nbsp;<s:property value="contest.startTime.toLocaleString()"/></font>
&nbsp;
	<font size="2" color="red">End Time:&nbsp;<s:property value="contest.endTime.toLocaleString()"/></font>
<br>
	<font size="2" color="#004080">
		Persist:&nbsp;
		<s:property value="(contest.endTime.getTime()-contest.startTime.getTime())/3600000" />&nbsp;hour(s)
		<s:property value="((contest.endTime.getTime()-contest.startTime.getTime())/60000 - (contest.endTime.getTime()-contest.startTime.getTime())/3600000*60)" />&nbsp;minute(s)
<br>
		Holder:&nbsp;
		<s:url id="ud" action="userdetails">
			<s:param name="username">
				<s:property value="contest.user.username" />
			</s:param>
		</s:url>
		<s:a href="%{ud}">
			<s:property value="contest.user.username"/>
		</s:a>
	</font>
<br>
	<font size="2" color="#004080">
		Status:&nbsp;
	</font>
		<s:if test="contest.status == 0"><font color="green" size="2">Scheduled</font></s:if>
		<s:elseif test="contest.status == 1"><font color="red" size="2">Running</font></s:elseif>
		<s:else><font color="grey" size="2">Ended</font></s:else>
<br><br>
</center>
<div align="center">
<div style="width:75%" align="right">
<form action="searchstatusincontest.action" method="post">
	<s:hidden name="contestId"></s:hidden>
	<s:textfield name="problemIdInContest" size="10" maxlength="8" label="Pro.ID"></s:textfield>
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
		<th>Author(From IP)</th>
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
			<s:url id="cpd" action="contestproblemdetails">
				<s:param name="problemIdInContest"><s:property value="problemIdInContest"/></s:param>
				<s:param name="problemId"><s:property value="problem.problemId" /></s:param>
				<s:param name="contestId"><s:property value="contestId" /></s:param>
			</s:url>
			<s:a href="%{cpd}"><s:property value="problemIdInContest" /></s:a>
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
			(<s:property value="ip"/>)
		</td>
	</tr>
</s:iterator>
</table>
<br>
<center>
<s:url id="pp" action="showstatus">
	<s:param name="JudgeStatusPage"><s:property value="JudgeStatusPage - 16" /></s:param>
</s:url>
<s:if test="JudgeStatusPage == 0"></s:if>
<s:else><s:a href="%{pp}"><font size="2"><b>&lt;&lt;&nbsp;Prev&nbsp;Page</b></font></s:a></s:else>
<font size="2"><b>&nbsp;|&nbsp;</b></font>
<s:url id="np" action="showstatus">
	<s:param name="JudgeStatusPage"><s:property value="JudgeStatusPage + 16" /></s:param>
</s:url>
<s:if test="JudgeStatusPage == (count>>>4<<4)"></s:if>
<s:else><s:a href="%{np}"><font size="2"><b>Next&nbsp;Page&nbsp;&gt;&gt;</b></font></s:a></s:else>
</center>
<br>
<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>