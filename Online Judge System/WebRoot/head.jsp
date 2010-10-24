<%@ taglib prefix="s" uri="/struts-tags" %>
<%java.util.Date now = new java.util.Date();pageContext.setAttribute("now", now); %>

<s:if test="#session.username!=null">

<s:div>
	<font size="2" face="Comic Sans MS" color="#004080"> Welcome back,&nbsp;&nbsp;[</font>
		<s:url id="mud" action="userdetails.action">
			<s:param name="username"><s:property value="#session.username"/></s:param>
		</s:url>
		<s:a href="%{mud}"><font size="2" face="Comic Sans MS" color="red"><s:property value="#session.username"/></font></s:a>
	<font size="2" face="Comic Sans MS" color="#004080">]&nbsp;&nbsp;from&nbsp;[&nbsp;<s:property value="#session.IP"/>&nbsp;]</font> 
	<font size="2" face="Comic Sans MS" color="#004080">
		,&nbsp;&nbsp;[<a href="<s:url action="logoff.action"/>">Log off</a>]&nbsp;&nbsp;if your want to update information
		please click here:&nbsp;</font>
	<em><font size="2" face="Comic Sans MS" color="#004080"> 
		<a href="/contest/update.jsp">[update]</a></font></em>
<div align="left">
<font size="2" face="Comic Sans MS" color="#c00000" >
<s:date name="#attr.now" />
</font>
</div>
	<hr />
</s:div>
<br>
</s:if>

<s:else>
<s:div>
<form action="login.action" method="post">
<s:textfield name="username" cssStyle="color:black" maxLength="16"><font size="2" color="#400080">username:</font></s:textfield>
<s:password name="password" cssStyle="color:black" maxLength="16"><font size="2" color="#400080">password:</font></s:password>
<input type="submit" value="Login" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<s:a href="/contest/register.jsp"><font size="2" face="Comic Sans MS" color="#c00000" ><b>[Register Now?]</b></font></s:a>
<hr/>
</form>
</s:div>
</s:else>