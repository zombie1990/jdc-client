<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	if(null != session.getAttribute("error")) {
		String scriptHead = "<script type=\"text/javascript\">alert(\'";
		String error = (String) session.getAttribute("error");
		String scriptTail = "\');</script>";
		response.getWriter().print(scriptHead + error + scriptTail);
		session.removeAttribute("error");
	}
%>
<s:url id="managementCenter" action="managementCenter" />
<s:url id="logOff" action="logOff" />
<s:if test="#session.user.username!=null">
	<div class="top" >
    	<table width="800px" cellpadding="0" cellspacing="0">
    		<tr>
    			<td align="left">
					<div style="color: #808080;font-size: 14px;">
					<s:property value="#session.user.username"/>,欢迎回来
					<s:a href="%{logOff}" cssStyle="color:#ff0000">退出</s:a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<s:a href="%{managementCenter}" cssStyle="color:#ff0000">进入管理中心</s:a>
		    		</div>
		    	</td>
		    	<td align="right">
		    		<form class="searchForm" action="search.action" method="post">
						<input class="search" type="text" value="请在这里搜索" />
						<input class="searchButton" type="submit" value="搜索" />
					</form>
		   	 	</td>
		    </tr>
    	</table>
   	</div>
</s:if>
<s:else>
   	<div class="top" >
    	<table width="800px" cellpadding="0" cellspacing="0">
    		<tr>
    			<td align="left" class="loginForm">
				    <form action="login.action" method="post">
				    	<label for="username" style="color: #f0f0f0">帐号</label>
			    		<input class="username" type="text" name="username" />
			    		<label for="password" style="color: #f0f0f0">密码</label>
			    		<input class="password" type="password" name="password" />
			    		<input class="loginButton" type="submit" value="登录" />
			    		<a class="register" href="register.jsp" style="color: #f0f0f0">立即注册</a>
				    </form>
		    	</td>
		    	<td align="right">
		    		<form class="searchForm" action="search.action" method="post">
						<input name="title" class="search" type="text" value="请在这里搜索" />
						<input class="searchButton" type="submit" value="搜索" />
					</form>
		   	 	</td>
		    </tr>
    	</table>
   	</div>
</s:else>