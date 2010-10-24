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
<s:fielderror cssStyle="color:red"></s:fielderror>
</center>
<table width=75% align="center" bgcolor="dddddd">
<tr><td align="center"><h1><b>Update Problem</b></h1></td></tr>
<tr><td align="center" >
<s:form action="updateproblem">
<s:hidden name="problemId"></s:hidden>
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
<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>