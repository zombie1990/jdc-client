<%@ page contentType="text/html; charset=GBK" %>
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

<br><br>
<center>
	<h1>
		<font color="gray">Frequently Asked Questions</font>
	</h1>
</center>

<div align="left"><font color="#0080ff" size="4"><font color="blue"><font size="4" face="Comic Sans MS">Q:</font><font color="#000000" face="Arial" size="3"><strong>Which programming languages can I use at Online Judge?</strong></font></font></font><br></div><div align="left"><font color="#0080ff" face="Comic Sans MS" size="4"><font color="#ff0000">A:<font color="#000000"><font size="3" face="Arial"> C, C++, Pascal and Java are currently supported at Online Judge.</font></font></font></font><br><div align="left"><font size="4" face="Comic Sans MS" color="#0080ff"><font color="#ff0000"><font color="#000000"><font size="3" face="Arial"><br></font></font></font></font><font size="4" color="#0080ff"><font color="blue"><font size="4" face="Comic Sans MS">Q:</font><font size="3" face="Arial" color="#000000"><strong>How to write a Java Solution?<br></strong></font></font></font><font size="4" face="Comic Sans MS" color="#0080ff"><font color="#ff0000">A:<font color="#000000"><font size="3" face="Arial"> </font></font></font></font><font size="3" face="Arial">Solutions written in Java must contain a single public class named 
<b><i>Main</i></b> which is </font><font color="red" size="3" face="Arial">case-sensitive</font><font size="3" face="Arial">. This class 
must contain the method &quot;public static void main(String[] args)&quot;. Furthermore, 
the solution may contain any number of nested classes and global non-public 
classes. Here is an example of A + B problem solution:<br></font> </div>
<table bgcolor="#dddddd" width=75%>
<tr><td><font size="3" face="Arial Narrow" color="blue"> 
import java.util.*;<br><br> 
class YouCanUseSuchClasses {}<br> 
public class Main<br> 
{<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; class AndSuchClassesToo {}<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
    public static void main(String args[])<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; {<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Scanner cin = new Scanner(System.in);<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; int a, b;<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        while(cin.hasNextInt())<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; a = cin.nextInt();<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; b = cin.nextInt();<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; System.out.println(a + b);<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; }<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
    }<br> 
}</font><font face="Arial Narrow" color="blue"> 
</font><br>

</td></tr>
</table><br><font size="4" color="#0080ff"><font color="blue"><font size="4" face="Comic Sans MS">Q:</font><font size="3" face="Arial" color="#000000"><strong>How to write a C Solution?<br></strong></font></font></font><font size="4" face="Comic Sans MS" color="#0080ff"><font color="#ff0000">A:<font color="#000000"><font size="3" face="Arial"> </font></font></font></font><font size="3"><font face="Arial">Here is a sample solution for the A+B problem in the C language:</font></font><br>
<table bgcolor="#dddddd" width=75%>
<tr><td><font size="3" face="Arial Narrow" color="blue"> 
#include &lt;stdio.h&gt;<br> 
main()<br> 
{<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; int a, b;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; while(scanf(&quot;%d%d&quot;, &amp;a, &amp;b) != EOF)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;%d\n&quot;, a + b);<br> 
}</font><br>
</td></tr>
</table><br><font size="4" color="#0080ff"><font color="blue"><font size="4" face="Comic Sans MS">Q:</font><font size="3" face="Arial" color="#000000"><strong>How to write a C++ Solution?<br></strong></font></font></font><font size="4" face="Comic Sans MS" color="#0080ff"><font color="#ff0000">A:<font color="#000000"><font size="3" face="Arial"> </font></font></font></font><font size="3"><font face="Arial">Here is a sample solution for the A+B problem in the C++ language:<br></font></font>
<table bgcolor="#dddddd" width="722" height="170">
<tr><td><font size="3" face="Arial Narrow" color="blue">  
#include &lt;iostream&gt;<br>int main()<br> 
{<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; int a, b;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; while(scin &gt;&gt; a &gt;&gt; b)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; cout &lt;&lt; a+b &lt;&lt; endl;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; return 0;<br> 
}</font><br>
</td></tr>
</table><br><font size="4" color="#0080ff"><font color="blue"><font size="4" face="Comic Sans MS">Q:</font><font size="3" face="Arial" color="#000000"><strong>How to write a Pascal Solution?<br></strong></font></font></font><font size="4" face="Comic Sans MS" color="#0080ff"><font color="#ff0000">A:<font color="#000000"><font size="3" face="Arial"> </font></font></font></font><font size="3"><font face="Arial">Here is a sample solution for the A+B problem in the Pascal language:<br></font></font><table width="722" height="170" bgcolor="#dddddd"> 
<tbody><tr><td><font size="3" face="Arial Narrow" color="blue">var i, j : integer;
<br>begin
<br>&nbsp;&nbsp;&nbsp;&nbsp; while not eof do
<br></font><font size="3" face="Arial Narrow" color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font><font size="3" face="Arial Narrow" color="blue">begin
<br></font><font size="3" face="Arial Narrow" color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font><font size="3" face="Arial Narrow" color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font><font size="3" face="Arial Narrow" color="blue">readln(i, j);<br></font><font size="3" face="Arial Narrow" color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font><font size="3" face="Arial Narrow" color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font><font size="3" face="Arial Narrow" color="blue">writeln(i + j);
<br></font><font size="3" face="Arial Narrow" color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font><font size="3" face="Arial Narrow" color="blue">end;
<br>end.</font><br> 
</td></tr> 
</tbody></table><br>
</div>
<%@include file="/foot.jsp"%> 
</body>
</html>