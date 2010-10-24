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
<table align="center" width="75%">
<tr><th align="center" bgcolor="#bbbbbb" width="30%">INPUTS</th><th align="center" bgcolor="#bbbbbb" width="30%">OUTPUTS</th></tr>
<tr><td align="center" bgcolor="#dddddd">
<s:iterator value="inputFilesName">
	<s:url id="stcc" action="showtestcasecontent">
		<s:param name="inputFilesName"><s:property /></s:param>
		<s:param name="problemId"><s:property value="problemId"/></s:param>
	</s:url>
	<s:a href="%{stcc}"><s:property /></s:a>
	&nbsp;&nbsp;&nbsp;
	<s:url id="dtc" action="deletetestcase">
		<s:param name="inputFilesName"><s:property /></s:param>
		<s:param name="problemId"><s:property value="problemId"/></s:param>
	</s:url>
	<s:a href="%{dtc}">[delete]</s:a><br><hr>
</s:iterator>
</td>
<td align="center" bgcolor="#dddddd">
<s:iterator value="outputFilesName">
	<s:url id="stcc" action="showtestcasecontent">
		<s:param name="outputFilesName"><s:property /></s:param>
		<s:param name="problemId"><s:property value="problemId"/></s:param>
	</s:url>
	<s:a href="%{stcc}"><s:property /></s:a>
	&nbsp;&nbsp;&nbsp;
	<s:url id="dtc" action="deletetestcase">
		<s:param name="outputFilesName"><s:property /></s:param>
		<s:param name="problemId"><s:property value="problemId"/></s:param>
	</s:url>
	<s:a href="%{dtc}">[delete]</s:a><br><hr>
</s:iterator>
</td></tr>
</table>
<table width="75%" align="center">
<tr><td align="center">
<s:form action="upload" method="post" enctype="multipart/form-data">
	<s:hidden name="problemId"></s:hidden>
	<s:radio list="{'inputs', 'outputs'}" name="inOrOut" cssStyle="font-family:sans-serif" required="true" label="Direction"></s:radio>
	<s:file name="file" label="File" required="true"></s:file>
	<s:submit value=" Submit "></s:submit>
</s:form>
</td></tr>
</table>

<br>
<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>