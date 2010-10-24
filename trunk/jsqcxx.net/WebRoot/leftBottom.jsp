<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- xxgk -->
<s:url id="findXZJY" action="findSpecialBlog">
	<s:param name="titleName">xzjy</s:param>
</s:url>

<!-- xxgk -->
<s:url id="findXX" action="findSpecialBlog">
	<s:param name="titleName">xx</s:param>
</s:url>

<ul>
	<li><s:a href="%{findXZJY}">校长寄语</s:a></li>
	<li><s:a href="%{findXX}">校训</s:a></li>
	<li><a href="mailto:lqxkj520@gmail.com">联系我们</a></li>
	<li><a href="http://www.yh8z.com" target="blank">怡海教育</a></li>
</ul>
