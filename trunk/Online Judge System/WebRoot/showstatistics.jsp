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

<s:url action="showdeclaration" id="sdInSst">
	<s:param name="contestId">
	<s:property value="contestId"/>
	</s:param>
</s:url>
<s:url action="showproblems" id="spInSst">
	<s:param name="contestId">
	<s:property value="contestId"/>
	</s:param>
</s:url>
<s:url action="showstatus" id="ssInSst">
	<s:param name="contestId">
	<s:property value="contestId"/>
	</s:param>
</s:url>
<s:url action="showranklist" id="srInSst">
	<s:param name="contestId">
	<s:property value="contestId"/>
	</s:param>
</s:url>
<s:url action="showstatistics" id="sstInSst">
	<s:param name="contestId">
	<s:property value="contestId"/>
	</s:param>
</s:url>

<table align="center" bgcolor="#004080" width="75%" cellspacing="10">
	<tr align="center">
		<td><s:a href="/contest/welcome.jsp"><font color="#ffffff" size="5" face="arial"><b>Home</b></font></s:a></td>
		<td><s:a href="%{sdInSst}"><font color="#ffffff" size="5" face="arial"><b>Declaration</b></font></s:a></td>
		<td><s:a href="%{spInSst}"><font color="#ffffff" size="5" face="arial"><b>Problems</b></font></s:a></td>
		<td><s:a href="%{ssInSst}"><font color="#ffffff" size="5" face="arial"><b>Status</b></font></s:a></td>
		<td><s:a href="%{srInSst}"><font color="#ffffff" size="5" face="arial"><b>Ranklist</b></font></s:a></td>
		<td><s:a href="%{sstInSst}"><font color="#ffffff" size="5" face="arial"><b>Statistics</b></font></s:a></td>
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
<table width=60% border="1px" cellspacing="0px" style="border-collapse:collapse" bordercolor=blue>
	<tr>
		<th></th>
		<th>AC</th>
		<th>PE</th>
		<th>WA</th>
		<th>RE</th>
		<th>TLE</th>
		<th>MLE</th>
		<th>OLE</th>
		<th>CE</th>
		<th>SE</th>
		<th>Total</th>
	</tr>
<s:iterator value="statisticses" status="st">
	<tr align="center" <s:if test="#st.odd">bgcolor=#dddddd</s:if><s:else>bgcolor=#bbbbbb</s:else> >
		<td><s:property value="problemIdInContest + 1000"/></td>
		<td><s:property value="AC"/></td>
		<td><s:property value="PE"/></td>
		<td><s:property value="WA"/></td>
		<td><s:property value="RE"/></td>
		<td><s:property value="TLE"/></td>
		<td><s:property value="MLE"/></td>
		<td><s:property value="OLE"/></td>
		<td><s:property value="CE"/></td>
		<td><s:property value="SE"/></td>
		<td><s:property value="total"/></td>
	</tr>
</s:iterator>
</table>
</div>

<br>
<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>