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
	<h1>
		<font color="gray">Acmers RankList</font>
	</h1>
</center>
<div align="center">
<div style="width:75%" align="right">
<form action="searchuser.action" method="post">
	<s:textfield name="name" label="Author"></s:textfield>
	<input type="submit" value="search" />
</form>
</div>
</div>
<table align="center" width="75%" class="item" border=0>
	<tr bgcolor=#3d67b9 align="center">
		<th>Rank</th>
		<th>Author</th>
		<th colspan="50">Motto</th>
		<th>Solved</th>
		<th>Ratio (Accepted / Submitted)</th>
	</tr>

<s:iterator value="users" status="st">
	<tr align="center" <s:if test="#st.odd">bgcolor=#dddddd</s:if><s:else>bgcolor=#cccccc</s:else> >
		<td><s:property value="#st.index+startAuthorRanklist+1" /></td>
		<td>
			<s:url id="ud" action="userdetails">
				<s:param name="username">
					<s:property value="username" />
				</s:param>
				<s:param name="rank">
					<s:property value="#st.index+startAuthorRanklist+1" />
				</s:param>
			</s:url>
			<s:a href="%{ud}">
				<s:property value="username" />
			</s:a>
		</td>
		<td colspan="50"><s:property value="motto" /></td>
		<td><s:property value="solved" /></td>
		<td>
			<s:if test="submit == 0">0%&nbsp;</s:if>
			<s:else><s:property value="accept*100/submit" />.<s:property value="accept*1000/submit - accept*100/submit*10" /><s:property value="accept*10000/submit - accept*1000/submit*10" />%&nbsp;</s:else>
			(<s:property value="accept" />&nbsp;/&nbsp;<s:property value="submit" />)
		</td>
	</tr>
</s:iterator>
</table>
<br>
<center>
<s:url id="pp" action="acmersranklist">
	<s:param name="startAuthorRanklist"><s:property value="startAuthorRanklist - 32" /></s:param>
</s:url>
<s:if test="startAuthorRanklist == 0"></s:if>
<s:else><s:a href="%{pp}"><font size="2"><b>&lt;&lt;&nbsp;Prev&nbsp;Page</b></font></s:a></s:else>
<font size="2"><b>&nbsp;|&nbsp;</b></font>
<s:url id="np" action="acmersranklist">
	<s:param name="startAuthorRanklist"><s:property value="startAuthorRanklist + 32" /></s:param>
</s:url>
<s:if test="startAuthorRanklist == (count>>>5<<5)"></s:if>
<s:else><s:a href="%{np}"><font size="2"><b>Next&nbsp;Page&nbsp;&gt;&gt;</b></font></s:a></s:else>
</center>
<br>
<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>