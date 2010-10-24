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
		<font color="gray">Free For Download</font>
	</h1>
</center>
<!-- START SNIPPET: treeExampleStaticJsp -->

<script>
    function treeNodeSelected(nodeId) {
        dojo.io.bind({
            url: "<s:url value='/tags/ui/ajax/staticTreeSelectAction.action'/>?nodeId="+nodeId,
            load: function(type, data, evt) {
                var divDisplay = dojo.byId("displayIt");
                divDisplay.innerHTML=data;
            },
            mimeType: "text/html"
        });
    };

    dojo.event.topic.subscribe("treeSelected", this, "treeNodeSelected");
</script>

<div id="displayIt"> 
<font size="2" color="#408080">System's Structure</font> 
</div>
<div id="displayTree">
<s:tree label="Home" id="parentId" theme="ajax" templateCssPath="/struts/tree.css" 
showRootGrid="true" showGrid="true" treeSelectedTopic="treeSelected">
    <s:treenode theme="ajax" label="Online Acmers" id="child1Id">
        <s:treenode theme="ajax" label="User Details" id="grandchild1Id"/>
    </s:treenode>
    <s:treenode theme="ajax" label="F.A.Q" id="child2Id"/>
    <s:treenode theme="ajax" label="Problem List" id="child3Id">
		<s:treenode theme="ajax" label="Problem Details" id="grandchild1Id"/>
	</s:treenode>
    <s:treenode theme="ajax" label="Current Judge Status" id="child4Id">
		<s:treenode theme="ajax" label="Compile Error Info" id="grandchild1Id"/>
		<s:treenode theme="ajax" label="Problem Details" id="grandchild2Id"/>
		<s:treenode theme="ajax" label="Source Code" id="grandchild3Id"/>
		<s:treenode theme="ajax" label="User Details" id="grandchild4Id"/>
	</s:treenode>
    <s:treenode theme="ajax" label="Acmers Ranklist" id="child5Id">
        <s:treenode theme="ajax" label="User Details" id="gChild1Id"/>
    </s:treenode>
    <s:treenode theme="ajax" label="Standard Contest" id="child6Id">
        <s:treenode theme="ajax" label="Standart Contest Details" id="gChild1Id">
			<s:treenode theme="ajax" label="Problems" id="gGChild1Id"/>
			<s:treenode theme="ajax" label="Ranklist" id="gGChild2Id"/>
			<s:treenode theme="ajax" label="Status" id="gGChild3Id"/>
			<s:treenode theme="ajax" label="Statistics" id="gGChild4Id"/>
		</s:treenode>
    </s:treenode>
    <s:treenode theme="ajax" label="DIY Contest" id="child6Id">
        <s:treenode theme="ajax" label="DIY Contest Details" id="gChild1Id">
			<s:treenode theme="ajax" label="Problems" id="gGChild1Id"/>
			<s:treenode theme="ajax" label="Ranklist" id="gGChild2Id"/>
			<s:treenode theme="ajax" label="Status" id="gGChild3Id"/>
			<s:treenode theme="ajax" label="Statistics" id="gGChild4Id"/>
		</s:treenode>
    </s:treenode>
	<s:treenode theme="ajax" label="Download" id="child7Id"/>
	<s:treenode theme="ajax" label="Administration" id="child8Id">
		<s:treenode theme="ajax" label="Such Options" id="gChild1Id"/>
	</s:treenode>
	<s:treenode theme="ajax" label="Forum" id="child9Id"/>
	<s:treenode theme="ajax" label="My Mail Box" id="child10Id"/>
</s:tree>
</div>

<!-- END SNIPPET: treeExampleStaticJsp  -->

<ul>
	<li>
		<s:url id="url" action="downloadapp"/><s:a href="%{url}">click here to download the application</s:a>
	</li>
	<li>
		<s:url id="url" action="downloadfile"/><s:a href="%{url}">click here to download the external file.</s:a> 
	</li>
	<li>
		<s:url id="url" action="downloadsource"/><s:a href="%{url}">click here to download the source</s:a> 
	</li>
</ul>

<br>
<s:debug></s:debug>
<%@ include file="/foot.jsp" %>
</body>
</html>