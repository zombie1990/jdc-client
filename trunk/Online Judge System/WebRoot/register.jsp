<%@ taglib prefix="s" uri="/struts-tags" %>
<s:head />
<div align="center"><font size="6" face="Comic Sans MS" color="#0080ff">User Registration</font></div>
<br>
<div align="center">
<s:fielderror cssStyle="color:red"></s:fielderror>
</div>
<div align="center">
	<s:form action="register">
		<s:textfield name="username" label="username" cssStyle="font-family:'Verdana'" maxlength="16" required="true"></s:textfield>
		<s:password name="password" label="password" cssStyle="font-family:'Verdana'" maxlength="16" required="true"></s:password>
		<s:password name="repassword" label="re-password" cssStyle="font-family:'Verdana'" maxlength="16" required="true"></s:password>
		<s:textfield name="nickname" label="nickname" cssStyle="font-family:'Verdana'" maxlength="16"></s:textfield>
		<s:textfield name="email" label="E-mail" cssStyle="font-family:'Verdana'" maxlength="40" required="true"></s:textfield>
		<s:textfield name="school" label="school" cssStyle="font-family:'Verdana'" maxlength="20"></s:textfield>
		<s:textfield name="motto" label="motto" cssStyle="font-family:'Verdana'" maxlength="20"></s:textfield>
		<s:submit value=" Join us "></s:submit>
	</s:form>
</div>
