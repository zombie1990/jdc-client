<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<s:head />
		<base href="<%=basePath%>" />

		<title>乾城小学</title>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<meta name="robots" content="index, follow" />
		<meta name="googlebot" content="index, follow" />
		<script type="text/javascript" src="editor/ckeditor.js"></script>

		<link rel="stylesheet" type="text/css" href="css/header.css" />
		<link rel="stylesheet" type="text/css" href="css/main.css" />
	</head>

	<body>
		<div>
			<%@ include file="/header.jsp"%>
		</div>


<s:append id="permissionList">
<s:param value="%{mainBoards}" />
</s:append>
<s:append id="blogList">
<s:param value="%{blogs}" />
</s:append>
<s:url id="goEdit" action="goEdit">
	<s:param name="manageType" value="manageType" />
</s:url>
<!-- 学校概况 -->
<s:url id="typeXXJJ" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">xxjj</s:param>
</s:url>
<s:url id="typeLDGH" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">ldgh</s:param>
</s:url>
<s:url id="typeGZZD" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">gzzd</s:param>
</s:url>
<s:url id="typeBXCG" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">bxcg</s:param>
</s:url>
<!-- 新闻频道 -->
<s:url id="typeZHXW" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">zhxw</s:param>
</s:url>
<!-- 教师教学 -->
<s:url id="typeKYDA" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">kyda</s:param>
</s:url>
<s:url id="typeJXSJ" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">jxsj</s:param>
</s:url>
<s:url id="typeSTZX" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">stzx</s:param>
</s:url>
<s:url id="typeJXDJT" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">jxdjt</s:param>
</s:url>
<s:url id="typeJSFC" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">jsfc</s:param>
</s:url>
<!-- 雏鹰起飞 -->
<s:url id="typePKHZ" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">pkhz</s:param>
</s:url>
<s:url id="typeJJZX" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">jjzx</s:param>
</s:url>
<s:url id="typeWDSH" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">wdsh</s:param>
</s:url>
<s:url id="typeWDWZ" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">wdwz</s:param>
</s:url>
<s:url id="typeZWBS" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">zwbs</s:param>
</s:url>
<!-- 图片中心 -->
<s:url id="typeXYTP" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">xytp</s:param>
</s:url>
<s:url id="typeSPWJ" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">spwj</s:param>
</s:url>
<s:url id="typeHDTP" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">hdtp</s:param>
</s:url>
<!-- 资源下载 -->
<s:url id="typeJXRJ" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">jxrj</s:param>
</s:url>
<s:url id="typeJXSCK" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">jxsck</s:param>
</s:url>
<s:url id="typeCYRJ" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">cyrj</s:param>
</s:url>
<s:url id="typeBW" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">bw</s:param>
</s:url>
<s:url id="typeXZWJ" action="showManage">
	<s:param name="manageType" value="manageType" />
	<s:param name="selectType">xzwj</s:param>
</s:url>
												
		<div id="default-font">
			<div id="nav" align="left">
				<%@ include file="/menu.jsp"%>
			</div>
			
			<div>
				<table cellpadding="0" cellspacing="0" style="padding: 20px 0 0 0">
					<tr>
						<td valign="top">
							<table cellpadding="0" cellspacing="0">
								<tr>
									<td id="left-frame3">
										<div align="center">管理列表</div>
										<ul>
											<s:iterator value="%{#permissionList}">
												<s:url id="entryManage" action="showManage">
													<s:param name="manageType" value="permissionId" />
												</s:url>
		     									<li><s:a href="%{entryManage}"><s:property value="permissionName" /></s:a></li>
											</s:iterator>
										</ul>
									</td>
								</tr>
							</table>
						</td>
						<td valign="top">
							<div id="right-frame">
								<div style="font-size: 16px;font-weight: bolder;margin: 10px 10px 10px 10px;color: #888888">
									<s:if test="manageType == 0">学校概况</s:if>
									<s:elseif test="manageType == 1">新闻频道</s:elseif>
									<s:elseif test="manageType == 2">教师教学</s:elseif>
									<s:elseif test="manageType == 3">雏鹰起飞</s:elseif>
									<s:elseif test="manageType == 4">图片中心</s:elseif>
									<s:elseif test="manageType  == 5">资源下载</s:elseif>
									<s:elseif test="manageType == 6">乾小博客</s:elseif>
									<s:else></s:else>
								</div>
								<table cellpadding="10" cellspacing="0">
									<tr bgcolor="#f0f0f0">
										<td width="510">
											<s:if test="manageType == 0">
												<s:a href="%{typeXXJJ}">学校简介</s:a>
												&nbsp;|&nbsp;
												<s:a href="%{typeLDGH}">领导关怀</s:a>
												&nbsp;|&nbsp;
												<s:a href="%{typeGZZD}">规章制度</s:a>
												&nbsp;|&nbsp;
												<s:a href="%{typeBXCG}">办学成果</s:a>
											</s:if>
											<s:elseif test="manageType == 1">
												<s:a href="%{typeZHXW}">综合新闻</s:a>
											</s:elseif>
											<s:elseif test="manageType == 2">
												<s:a href="%{typeKYDA}">科研档案</s:a>
												&nbsp;|&nbsp;
												<s:a href="%{typeJXSJ}">教学设计</s:a>
												&nbsp;|&nbsp;
												<s:a href="%{typeSTZX}">试题中心</s:a>
												&nbsp;|&nbsp;
												<s:a href="%{typeJXDJT}">教学大家谈</s:a>
												&nbsp;|&nbsp;
												<s:a href="%{typeJSFC}">教师风采</s:a>
											</s:elseif>
											<s:elseif test="manageType == 3">
												<s:a href="%{typePKHZ}">贫困互助</s:a>
												&nbsp;|&nbsp;
												<s:a href="%{typeJJZX}">家教在线</s:a>
												&nbsp;|&nbsp;
												<s:a href="%{typeWDSH}">我的书画</s:a>
												&nbsp;|&nbsp;
												<s:a href="%{typeWDWZ}">我的文章</s:a>
												&nbsp;|&nbsp;
												<s:a href="%{typeZWBS}">征文比赛</s:a> 
											</s:elseif>
											<s:elseif test="manageType == 4">
												<s:a href="%{typeXYTP}">校园图片</s:a>
												&nbsp;|&nbsp;
												<s:a href="%{typeSPWJ}">视频文件</s:a>
												&nbsp;|&nbsp;
												<s:a href="%{typeHDTP}">活动图片</s:a>
											</s:elseif>
											<s:elseif test="manageType  == 5">
												<s:a href="%{typeJXRJ}">教学软件</s:a>
												&nbsp;|&nbsp;
												<s:a href="%{typeJXSCK}">教学素材库</s:a>
												&nbsp;|&nbsp;
												<s:a href="%{typeCYRJ}">常用软件</s:a>
											</s:elseif>
											<s:else>
												<s:a href="%{typeBW}">博文</s:a>
												&nbsp;|&nbsp;
												<s:a href="%{typeXZWJ}">校长文集</s:a>
											</s:else>
										</td>
										<td width="100" align="center"><s:a href="%{goEdit}">添加新文章</s:a></td>
									</tr>
									<tr bgcolor="#ABCDF8">
										<td width="510">标题</td>
										<td width="100" align="center">操作</td>
									</tr>
									<s:iterator value="%{#blogList}">
										<s:url id="showBlogContent" action="showContent">
											<s:param name="uuid" value="uuid" />
										</s:url>
										<s:url id="goReEdit" action="goReEdit">
											<s:param name="uuid" value="uuid" />
											<s:param name="manageType" value="manageType" />
										</s:url>
										<s:url id="deleteBlog" action="deleteBlog">
											<s:param name="uuid" value="uuid" />
											<s:param name="manageType" value="manageType" />
										</s:url>
									<tr id="hover-bgcolor">
										<td width="510"><s:a href="%{showBlogContent}"><s:property value="title" /></s:a></td>
										<td width="100" align="center">
											<s:a href="%{goReEdit}">修改</s:a>
											&nbsp;|&nbsp;
											<s:a href="%{deleteBlog}">删除</s:a>
										</td>
									</tr>
									</s:iterator>
								</table>
							</div>
						</td>
					</tr>
				</table>
			</div >
			
			<div id="footer">
				<%@ include file="/footer.jsp"%>
			</div>
		</div>
		
		
		
		
		
		
	</body>
</html>
