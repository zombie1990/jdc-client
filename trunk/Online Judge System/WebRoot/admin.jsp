<%@ page contentType="text/html; charset=GB2312" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<s:head theme="ajax"/>
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

<table width=75% align="center">
<tr align="center" bgcolor="#dddddd"><td>
	<s:form action="inform">
		<s:textarea name="inform" cssStyle="color:red" label="set Inform" cssStyle="font-family:sans-serif"></s:textarea>
		<s:submit value=" Submit "></s:submit>
	</s:form>
</td>
<td>
	<s:form action="userhandle">
		<s:radio list="{'lock', 'unlock', 'admin', 'user'}" name="handler" label="operator" cssStyle="font-family:sans-serif" required="true"></s:radio>
		<s:textfield name="username" cssStyle="color:red" maxLength="16" label="username" cssStyle="font-family:sans-serif" required="true"></s:textfield>
		<s:submit value=" Submit "></s:submit>
	</s:form>
</td></tr>

<tr align="center" bgcolor="#bbbbbb"><td>
	<s:form action="createusers">
		<s:textfield name="start" cssStyle="font-family:sans-serif" label="Create users from" required="true"></s:textfield>
		<s:textfield name="end" cssStyle="font-family:sans-serif" label="to" required="true"></s:textfield>
		<s:password name="passwords" cssStyle="font-family:sans-serif" label="passwords" maxlength="15" required="true"></s:password>
		<s:submit value=" Submit "></s:submit>
	</s:form>
</td>
<td>
	<s:form action="changepassword">
		<s:textfield name="lostUsername" cssStyle="color:red" label="lost username" cssStyle="font-family:sans-serif" required="true"></s:textfield>
		<s:password name="lostPassword" cssStyle="color:red" label="new password" maxlength="15" cssStyle="font-family:sans-serif" required="true"></s:password>
		<s:submit value=" Submit "></s:submit>
	</s:form>
</td></tr>

<tr align="center" bgcolor="#dddddd"><td>
	<s:form action="newgrade">
		<s:textfield name="levelName" cssStyle="font-family:sans-serif" label="new problem level" required="true"></s:textfield>
		<s:submit value=" Submit "></s:submit>
	</s:form>
</td>
<td>
	<s:form action="newgenre">
		<s:textfield name="typeName" cssStyle="color:red" label="new problem type" cssStyle="font-family:sans-serif" required="true"></s:textfield>
		<s:submit value=" Submit "></s:submit>
	</s:form>
</td></tr>

<tr align="center" bgcolor="#bbbbbb"><td>
	<s:a href="#" onclick="toggleNew('newProblem');return false;">make a new problem</s:a>
</td>
<td>
	<s:url id="apl" action="adminproblemlist">
		<s:param name="pageNum">1</s:param>
		<s:param name="contestProblem">NO</s:param>
	</s:url>
	<s:a href="%{apl}">list all problems</s:a>
</td></tr>

<tr align="center" bgcolor="#dddddd"><td>
	<s:a href="#" onclick="toggleNew('newContest');return false;">make a new standard contest</s:a>
</td>
<td>
	<s:url id="lsc" action="mycontestlist">
		<s:param name="status">1</s:param>
		<s:param name="contestPage">1</s:param>
	</s:url>
	<s:a href="%{lsc}">list standard contests</s:a>
</td></tr>
</table>
<br>
<center>
<s:fielderror></s:fielderror>
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

<div style="display:none" id="newProblem">
<br>
<table width=75% align="center" bgcolor="dddddd">
<tr><td align="center"><h1><b>New Problem</b></h1></td></tr>
<tr><td align="center" >
<s:form action="newproblem">
<s:textfield name="title" label="title" size="71" maxlength="70" cssStyle="font-family:sans-serif" required="true"></s:textfield>
<s:textfield name="timeLimit" label="time limit(ms)" cssStyle="font-family:sans-serif" required="true"></s:textfield>
<s:textfield name="memoryLimit" label="memory limit(KB)" cssStyle="font-family:sans-serif" required="true"></s:textfield>
<s:textfield name="javaTimeLimit" label="java time limit(ms)" cssStyle="font-family:sans-serif" required="true"></s:textfield>
<s:textfield name="javaMemoryLimit" label="java memory limit(KB)" cssStyle="font-family:sans-serif" required="true"></s:textfield>
<s:textarea name="description" label="description" cols="80" rows="20" cssStyle="font-family:sans-serif" required="true"></s:textarea>
<s:textarea name="input" label="input" cols="80" rows="20" cssStyle="font-family:sans-serif" required="true"></s:textarea>
<s:textarea name="output" label="output" cols="80" rows="20" cssStyle="font-family:sans-serif" required="true"></s:textarea>
<s:textarea name="sampleInput" label="sample input" cols="80" rows="20" cssStyle="font-family:sans-serif" required="true"></s:textarea>
<s:textarea name="sampleOutput" label="sample output" cols="80" rows="20" cssStyle="font-family:sans-serif" required="true"></s:textarea>
<s:textarea name="tips" label="tips" cols="80" rows="10" cssStyle="font-family:sans-serif"></s:textarea>
<s:textfield name="author" label="author" cssStyle="font-family:sans-serif" required="true"></s:textfield>
<s:select list="grades" name="hardLevel" label="Level" cssStyle="font-family:sans-serif" required="true"></s:select>
<s:select list="genres" name="type" label="type" cssStyle="font-family:sans-serif" required="true"></s:select>
<s:select list="{'NO', 'YES'}" name="contestProblem" label="is a contest problem?" cssStyle="font-family:sans-serif" required="true"></s:select>
<s:submit value=" Submit "></s:submit>
</s:form>
</td></tr>
</table>
<br>
</div>

<div style="display:none" id="newContest">
<br>
<table width=75% align="center" bgcolor="bbbbbb">
<tr><td align="center"><h1><b>New Contest</b></h1></td></tr>
<tr><td align="center" >
<s:form action="newcontest">
<s:textfield name="title" label="title" size="71" maxlength="70" cssStyle="font-family:sans-serif" required="true"></s:textfield>
<s:textarea name="description" label="description" cols="71" rows="10" cssStyle="font-family:sans-serif" required="true"></s:textarea>
<s:datetimepicker label="Start From" name="startDate" toggleType="wipe" required="true"/>
<s:datetimepicker name="startTime" toggleType="wipe" type="time" language="en_US" required="true"/>
<s:datetimepicker label="End To" name="endDate" toggleType="wipe" required="true"/>
<s:datetimepicker name="endTime" toggleType="wipe" type="time" language="en_US" required="true"/>
<s:password name="password" label="password" size="21" maxlength="15" cssStyle="font-family:sans-serif"></s:password>
<s:submit value=" Submit "></s:submit>
</s:form>
</td></tr>
</table>

<br>
</div>

<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>