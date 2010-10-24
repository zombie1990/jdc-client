var focus_width = 243
var focus_height = 230
var text_height = 0
var swf_height = focus_height + text_height

var pics = '/qcxx/images/a.jpg|/qcxx/images/b.jpg|/qcxx/images/c.jpg|/qcxx/images/d.jpg|/qcxx/images/e.jpg'
var links = '/qcxx/images/a.jpg|/qcxx/images/b.jpg|/qcxx/images/c.jpg|/qcxx/images/d.jpg|/qcxx/images/e.jpg'

var texts = '||||| '

document
		.write('<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="'
				+ focus_width + '" height="' + swf_height + '">');
document
		.write('<param name="allowScriptAccess" value="sameDomain"><param name="movie" value="/qcxx/images/pixviewer.swf"><param name="quality" value="high"><param name="bgcolor" value="#ffffff">');
document
		.write('<param name="menu" value="false"><param name=wmode value="opaque">');
document
		.write('<param name="FlashVars" value="pics=' + pics + '&links='
				+ links + '&texts=' + texts + '&borderwidth=' + focus_width
				+ '&borderheight=' + focus_height + '&textheight='
				+ text_height + '">');
document
		.write('<embed src="/qcxx/images/pixviewer.swf" wmode="opaque" FlashVars="pics='
				+ pics
				+ '&links='
				+ links
				+ '&texts='
				+ texts
				+ '&borderwidth='
				+ focus_width
				+ '&borderheight='
				+ focus_height
				+ '&textheight='
				+ text_height
				+ '" menu="false" bgcolor="#ffffff" quality="high" width="'
				+ focus_width
				+ '" height="'
				+ focus_height
				+ '" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />');
document.write('</object>');
