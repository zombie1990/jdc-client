<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- xxgk -->
<s:url id="findXXJJ" action="findBlogs">
	<s:param name="type">xxjj</s:param>
	<s:param name="section">xxgk</s:param>
</s:url>
<s:url id="findLDGH" action="findBlogs">
	<s:param name="type">ldgh</s:param>
	<s:param name="section">xxgk</s:param>
</s:url>
<s:url id="findGZZD" action="findBlogs">
	<s:param name="type">gzzd</s:param>
	<s:param name="section">xxgk</s:param>
</s:url>
<s:url id="findBXCG" action="findBlogs">
	<s:param name="type">bxcg</s:param>
	<s:param name="section">xxgk</s:param>
</s:url>

<!-- xwpd -->
<s:url id="findZHXW" action="findBlogs">
	<s:param name="type">zhxw</s:param>
	<s:param name="section">xwpd</s:param>
</s:url>

<!-- jsjx -->
<s:url id="findKYDA" action="findBlogs">
	<s:param name="type">kyda</s:param>
	<s:param name="section">jsjx</s:param>
</s:url>
<s:url id="findJXSJ" action="findBlogs">
	<s:param name="type">jxsj</s:param>
	<s:param name="section">jsjx</s:param>
</s:url>
<s:url id="findSTZX" action="findBlogs">
	<s:param name="type">stzx</s:param>
	<s:param name="section">jsjx</s:param>
</s:url>
<s:url id="findJXDJT" action="findBlogs">
	<s:param name="type">jxdjt</s:param>
	<s:param name="section">jsjx</s:param>
</s:url>
<s:url id="findJSFC" action="findBlogs">
	<s:param name="type">jsfc</s:param>
	<s:param name="section">jsjx</s:param>
</s:url>

<!-- cyqf -->
<s:url id="findPKHZ" action="findBlogs">
	<s:param name="type">pkhz</s:param>
	<s:param name="section">cyqf</s:param>
</s:url>
<s:url id="findJJZX" action="findBlogs">
	<s:param name="type">jjzx</s:param>
	<s:param name="section">cyqf</s:param>
</s:url>
<s:url id="findWDSH" action="findBlogs">
	<s:param name="type">wdsh</s:param>
	<s:param name="section">cyqf</s:param>
</s:url>
<s:url id="findWDWZ" action="findBlogs">
	<s:param name="type">wdwz</s:param>
	<s:param name="section">cyqf</s:param>
</s:url>
<s:url id="findZWBS" action="findBlogs">
	<s:param name="type">zwbs</s:param>
	<s:param name="section">cyqf</s:param>
</s:url>

<!-- tpzx -->
<s:url id="findXYTP" action="findBlogs">
	<s:param name="type">xytp</s:param>
	<s:param name="section">tpzx</s:param>
</s:url>
<s:url id="findSPWJ" action="findBlogs">
	<s:param name="type">spwj</s:param>
	<s:param name="section">tpzx</s:param>
</s:url>
<s:url id="findHDTP" action="findBlogs">
	<s:param name="type">hdtp</s:param>
	<s:param name="section">tpzx</s:param>
</s:url>

<!-- zyxz -->
<s:url id="findJXRJ" action="findBlogs">
	<s:param name="type">jxrj</s:param>
	<s:param name="section">zyxz</s:param>
</s:url>
<s:url id="findJXSCK" action="findBlogs">
	<s:param name="type">jxsck</s:param>
	<s:param name="section">zyxz</s:param>
</s:url>
<s:url id="findCYRJ" action="findBlogs">
	<s:param name="type">cyrj</s:param>
	<s:param name="section">zyxz</s:param>
</s:url>

<!-- qxbk -->
<s:url id="findBW" action="findBlogs">
	<s:param name="type">bw</s:param>
	<s:param name="section">qxbk</s:param>
</s:url>
<s:url id="findXZWJ" action="findBlogs">
	<s:param name="type">xzwj</s:param>
	<s:param name="section">qxbk</s:param>
</s:url>
<ul> 
	<li><s:a href="%{findXXJJ}">学校概况</s:a></li> 
	<li><s:a href="%{findZHXW}">新闻频道</s:a></li> 
	<li><s:a href="%{findKYDA}">教师教学</s:a></li> 
	<li><s:a href="%{findPKHZ}">雏鹰起飞</s:a></li> 
	<li><s:a href="%{findXYTP}">图片中心</s:a></li> 
	<li><s:a href="%{findJXRJ}">资源下载</s:a></li> 
	<li><s:a href="%{findBW}">乾小博客</s:a></li> 
</ul>
