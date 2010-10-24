<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:head />
<div align="center"><font size="6" face="Comic Sans MS" color="#0080ff">帐号注册</font></div>
<br>
<div align="center">
</div>
<div align="center">
<div style="border:#ABCDF8 1px solid;width: 50%">
	<s:form action="register" method="post">
		<s:textfield name="username" label="用户名" cssStyle="font-family:'Verdana'" maxlength="16" required="true"></s:textfield>
		<s:password name="password" label="密码" cssStyle="font-family:'Verdana'" maxlength="16" required="true"></s:password>
		<s:password name="repassword" label="重复密码" cssStyle="font-family:'Verdana'" maxlength="16" required="true"></s:password>
		<s:textfield name="email" label="邮箱" cssStyle="font-family:'Verdana'" maxlength="40" required="false"></s:textfield>
		<s:textfield name="contact" label="联系方式" cssStyle="font-family:'Verdana'" maxlength="20" required="false"></s:textfield>
		<s:textfield name="question" label="密保问题" cssStyle="font-family:'Verdana'" maxlength="20" required="true"></s:textfield>
		<s:textfield name="answer" label="答案" cssStyle="font-family:'Verdana'" maxlength="20" required="true"></s:textfield>
		<s:token />
		<s:submit value="注册"></s:submit>
	</s:form>
</div>
</div>
