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

<s:url action="showdeclaration" id="declaration">
	<s:param name="contestId">
	<s:property value="contestId"/>
	</s:param>
</s:url>
<s:url action="showproblems" id="problems">
	<s:param name="contestId">
	<s:property value="contestId"/>
	</s:param>
</s:url>
<s:url action="showranklist" id="ranklist">
	<s:param name="contestId">
	<s:property value="contestId"/>
	</s:param>
</s:url>
<s:url action="showstatus" id="status">
	<s:param name="contestId">
	<s:property value="contestId"/>
	</s:param>
</s:url>
<s:url action="showstatistics" id="statistics">
	<s:param name="contestId">
	<s:property value="contestId"/>
	</s:param>
</s:url>

<table align="center" bgcolor="#004080" width="75%" cellspacing="10">
	<tr align="center">
		<td><s:a href="/contest/welcome.jsp"><font color="#ffffff" size="5" face="arial"><b>Home</b></font></s:a></td>
		<td><s:a href="%{declaration}"><font color="#ffffff" size="5" face="arial"><b>Declaration</b></font></s:a></td>
		<td><s:a href="%{problems}"><font color="#ffffff" size="5" face="arial"><b>Problems</b></font></s:a></td>
		<td><s:a href="%{ranklist}"><font color="#ffffff" size="5" face="arial"><b>Ranklist</b></font></s:a></td>
		<td><s:a href="%{status}"><font color="#ffffff" size="5" face="arial"><b>Status</b></font></s:a></td>
		<td><s:a href="%{statistics}"><font color="#ffffff" size="5" face="arial"><b>Statistics</b></font></s:a></td>
	</tr>
</table>

<div align=center><font color=red size=5><s:property value="tip"/></font></div><br>
<br>
<center><s:fielderror></s:fielderror></center>

<table align="center" width="75%">
	<tr align="center"><td>
		<h1><strong><s:property value="problemIdInContest"/>&nbsp;<s:property value="problem.title"/></strong></h1>
	</td></tr>
	<tr align="center"><td>
		<font size="2" color="#008040">
			Time Limit:  <s:property value="problem.timeLimit"/>ms / <s:property value="problem.javaTimeLimit"/>ms(for Java)
			<br>
			Memory Limit:  <s:property value="problem.memoryLimit >>> 10"/>KB / <s:property value="problem.javaMemoryLimit >>> 10"/>KB(for Java)
			<br>
	</font>
	</td></tr>
	<tr><td><br>
		<strong>Description:</strong>
	</td></tr>
	<tr bgcolor="#d7ebff"><td><p>
		<s:property value="description" escape="false"/>
	</p></td></tr>
	<tr><td><br>
		<strong>Input:</strong>
	</td></tr>
	<tr bgcolor="#d7ebff"><td><p>
		<s:property value="input" escape="false"/>
	</p></td></tr>
	<tr><td><br>
		<strong>Output:</strong>
	</td></tr>
	<tr bgcolor="#d7ebff"><td><p>
		<s:property value="output" escape="false"/>
	</p></td></tr>
	<tr><td><br>
		<strong>Sample Input:</strong>
	</td></tr>
	<tr bgcolor="#d7ebff"><td><p>
		<s:property value="sampleInput" escape="false"/>
	</p></td></tr>
	<tr><td><br>
		<strong>Sample Output:</strong>
	</td></tr>
	<tr bgcolor="#d7ebff"><td><p>
		<s:property value="sampleOutput" escape="false"/>
	</p></td></tr>
	<s:if test='tips == null || "" eq tips'></s:if>
	<s:else>
	<tr><td><br>
		<strong>Tips:</strong>
	</td></tr>
	<tr bgcolor="#d7ebff"><td><p>
		<s:property value="tips" escape="false"/>
	</p></td></tr>
	</s:else>
	<tr><td><br>
		<strong>Author:</strong>
	</td></tr>
	<tr bgcolor="#d7ebff"><td>
		<s:property value="problem.author"/>
	</td></tr>
</table>
<center>
<s:a href="#" onclick="toggleNew('submitCode');return false;">[Submit Code]</s:a>
</center>
<script type="text/javascript"> 
<!--
    function toggleNew(typeId) {
        var newDiv = document.getElementById(typeId);
        if (newDiv) {
            var display = newDiv.style.display;
            if (display == 'none') {
                newDiv.style.display = 'block';
            } else if (display == 'block') {
                newDiv.style.display = 'none';
            }
        }
    }
-->
</script>
<center>

</center>
<div style="display:none" id="submitCode" align="center">
<s:form action="submitcodeincontest" cssStyle="width:75%;">
<s:hidden name="problemId"></s:hidden>
<s:hidden name="problemIdInContest"></s:hidden>
<s:hidden name="contestId"></s:hidden>
<s:select list="{'GCC', 'G++', 'Java', 'Pascal'}" name="language" cssStyle="font-family:sans-serif;color:red"></s:select>
<s:textarea name="code" cols="120" rows="30" cssStyle="font-family:sans-serif;"></s:textarea>
<s:submit value=" Submit "></s:submit>
</s:form>
</div>

<br>
<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>