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
		<base href="<%=basePath%>" />

		<title>首页 吉首市乾城侨心怡海小学</title>
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
		<!-- 
		<META HTTP-EQUIV="Refresh" CONTENT="0;URL=index.action">
		 -->
	</head>
	<body background="images/bg-color.png">
		<div align="center">
			<%@ include file="/header.jsp"%>
		</div>
		<br />
		
<map name="map1">
	<area alt="校长" shape="rect" coords="18,310,138,410" href="images/xiaozhang.jpg" target="blank" />
	<area alt="校长寄语" shape="rect" coords="160,326,360,386" href="findSpecialBlog.action?titleName=xzjy" target="blank" />
</map>
<map name="map2" style="border: none;float: left">
	<area shape="rect" coords="15,30,368,286" href="images/home_right_top.jpg" target="blank" />
	<area shape="rect" coords="15,340,368,460" href="images/home_right_bottom.jpg" target="blank" />
</map>
		
		<div id="homePage">
		
			<div id="home-menu">
				<%@ include file="/menu.jsp"%>
			</div>

			<div id="default-font">
				<div id="left">
					<img src="images/body-inner-left.png" width="379" height="473" usemap="#map1" style="border: none;float: left" />
				</div>
				<div id="right">
					<img src="images/body-inner-right.png" width="380" height="473" usemap="#map2" style="border: none;float: left" />
				</div>
			</div>
			
			<div id="footer0">
				<div class="size" align="right">
					版权所有&copy;乾城侨心怡海小学&nbsp;|&nbsp;
					地址:吉首市新建路14号&nbsp;|&nbsp;
					邮编:416007&nbsp;|&nbsp;
					校友交流群:1231241231
				</div>
			</div>
		
		</div>
		
		<br />
	</body>
</html>
