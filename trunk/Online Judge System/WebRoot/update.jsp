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

<div align="center"><font face="Comic Sans MS"><font size="6" color="#0080ff">User Information Update</font></font></div>
<br>
<div align="center">
<s:fielderror cssStyle="color:red"></s:fielderror>
</div>
<div align="center">
	<s:form action="updateinfo">
		<s:password name="password" label="password" cssStyle="font-family:'Verdana'" maxlength="16" required="true"></s:password>
		<s:password name="repassword" label="re-password" cssStyle="font-family:'Verdana'" maxlength="16" required="true"></s:password>
		<s:textfield name="nickname" label="nickname" cssStyle="font-family:'Verdana'" maxlength="16"></s:textfield>
		<s:textfield name="email" label="E-mail" cssStyle="font-family:'Verdana'" maxlength="40" required="true"></s:textfield>
		<s:textfield name="school" label="school" cssStyle="font-family:'Verdana'" maxlength="20"></s:textfield>
		<s:textfield name="motto" label="motto" cssStyle="font-family:'Verdana'" maxlength="20"></s:textfield>
		<s:submit value=" Confirm "></s:submit>
	</s:form>
</div>

<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>