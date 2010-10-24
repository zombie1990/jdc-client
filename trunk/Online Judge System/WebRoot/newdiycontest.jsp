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
<tr><td align="center"><h1><b>New DIY Contest</b></h1></td></tr>
<tr><td align="center" >
<s:form action="newdiycontest">
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
<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>