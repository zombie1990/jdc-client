<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div
	style="font-size: 16px; font-weight: bolder; margin: 10px 10px 10px 10px; color: #888888"
	align="center">
	修改密码
</div>
<div align="center">
	<div style="border: #ABCDF8 1px solid; width: 50%">
		<s:form action="changePswd" method="post" cssStyle="font-size: 12px;font-family: 宋体;">
			<s:password name="oldPassword" label="原始密码" maxlength="16"
				required="true"></s:password>
			<s:password name="newPassword" label="新密码" maxlength="16"
				required="true"></s:password>
			<s:password name="reNewPassword" label="重复新密码" maxlength="16"
				required="true"></s:password>
			<s:token />
			<s:submit value="修改"></s:submit>
		</s:form>
	</div>
	<br />
	<br />
	<br />
	<div
		style="font-size: 16px; font-weight: bolder; margin: 10px 10px 10px 10px; color: #888888"
		align="center">
		找回密码
	</div>
	<div align="center">
		<div style="border: #ABCDF8 1px solid; width: 50%">
			<s:form action="retrievePswd" method="post" cssStyle="font-size: 12px;font-family: 宋体;">
				<br />
				<div style="font-size: 12px; color: red" align="center">提示问题:<s:property value="#session.user.question" /></div>
				<br />
				<br />
				<s:textfield name="answer" label="答案" maxlength="16" required="true"></s:textfield>
				<s:password name="newPassword1" label="新密码" maxlength="16"
					required="true"></s:password>
				<s:password name="reNewPassword1" label="重复新密码" maxlength="16"
					required="true"></s:password>
				<s:token />
				<s:submit value="重置"></s:submit>
			</s:form>
		</div>
	</div>
	<br />
	<br />
	<br />
	<s:if test="#session.user.permission eq 11111111">
	<div
		style="font-size: 16px; font-weight: bolder; margin: 10px 10px 10px 10px; color: #888888"
		align="center">
		用户权限管理
	</div>
	<div align="center">
		<div style="border: #ABCDF8 1px solid; width: 50%">
			<s:form action="addPermission" method="post" cssStyle="font-size: 12px;font-family: 宋体;">
				<s:select list="{'乾小博客','学校概况','校园新闻','教师教学','雏鹰起飞','图片中心','资源下载'}" name="newPermission" label="选择添加权限" required="true"></s:select>
				<s:textfield name="newPermissionUsername" label="选择用户名" maxlength="16" required="true"></s:textfield>
				<s:token />
				<s:submit value="添加"></s:submit>
			</s:form>
		</div>
	</div>
	<br />
	<br />
	<br />
	</s:if>
</div>
<s:token />