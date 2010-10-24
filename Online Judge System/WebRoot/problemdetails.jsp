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
	<tr align="center"><td>
		<h1><strong><s:property value="problemId"/>&nbsp;<s:property value="title"/></strong></h1>
	</td></tr>
	<tr align="center"><td>
		<font size="2" color="#008040">
			Time Limit:  <s:property value="timeLimit"/>ms / <s:property value="javaTimeLimit"/>ms(for Java)
			<br>
			Memory Limit:  <s:property value="memoryLimit >>> 10"/>KB / <s:property value="javaMemoryLimit >>> 10"/>KB(for Java)
			<br>
			Ratio: <s:property value="accept"/> Acceptions / <s:property value="submit"/> Submissions
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
		<s:property value="author"/>
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
<s:fielderror></s:fielderror>
</center>
<div style="display:none" id="submitCode" align="center">
<s:form action="submitcode" cssStyle="width:75%;">
<s:hidden name="problemId"></s:hidden>
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