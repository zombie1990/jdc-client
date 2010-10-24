<%@page import="com.jsu.util.WentForth"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div align="center">

	<table width=75% rules="cols" border="1px" cellspacing="0px" style="border-collapse:collapse" bordercolor="#6a9ed2">
		<tr class="menu">
			<td class="select">
				<a href="/contest/welcome.jsp"><b>Home</b></a>
			</td>
			<td class="select">
				<a href="<s:url action="problemlist"/>"><b>Problem List</b></a>
			</td>
			<td  class="select">
				<s:url id="scl" action="contestlist">
					<s:param name="diy">N</s:param>
					<s:param name="status">1</s:param>
					<s:param name="contestPage">1</s:param>
				</s:url>
				<s:a href="%{scl}"><b>Standard Contest</b></s:a>
			</td>
			<td  class="select">
				<a href="<s:url action="admin"/>"><b>Administration</b></a>
			</td>
		</tr>
		<tr class="menu">
			<td class="select">
				<a href="<s:url action="onlineusers"/>"><b>Online Acmers</b></a>
			</td>
			<td class="select">
				<s:url id="sjs" action="showjudgestatus">
					<s:param name="startJudgeStatus">0</s:param>
				</s:url>
				<s:a href="%{sjs}"><b>Current Judge Statust</b></s:a>
			</td>
			<td  class="select">
				<s:url id="dcl" action="contestlist">
					<s:param name="diy">Y</s:param>
					<s:param name="status">1</s:param>
					<s:param name="contestPage">1</s:param>
				</s:url>
				<s:a href="%{dcl}"><b>DIY Contest</b></s:a>
			</td>
			<td  class="select">
				<a href="/contest/chat.jsp"><b>Online Chat</b></a>
			</td>
		</tr>
		<tr class="menu">
			<td class="select">
				<a href="/contest/FAQ.jsp"><b>F.A.Q</b></a>
			</td>
			<td class="select">
				<s:url id="arl" action="acmersranklist">
					<s:param name="startAuthorRanklist">0</s:param>
				</s:url>
				<s:a href="%{arl}"><b>Acmers Ranklist</b></s:a>
			</td>
			<td class="select">
				<a href="/contest/download.jsp"><b>Download</b></a>
			</td>
			<td  class="select">
			</td>
		</tr>

	</table>

<br><br>
<marquee behavior="scroll" width="60%" loop="infinite" direction="left" height="60" scrolldelay="130" onmouseover=stop() onmouseout=start()>
<center>
<font color=#3d67b9 size=5 face="arial">
<%=WentForth.inform %>
</font>
</center>
</marquee>


</div>