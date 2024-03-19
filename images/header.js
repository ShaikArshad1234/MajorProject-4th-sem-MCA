
<!-- Begin


<!-- NOTE: If you use a ' add a slash before it like this \' -->


/*document.write('<TABLE cellpadding=0 cellspacing=0 border=0 width="1200"" bgcolor="#909099"><tr><td width="15">');
document.write('<IMG SRC="picts/spacer.gif" HEIGHT=10 WIDTH=15 border="0"><BR>');
document.write('</td><td ALIGN="LEFT" VALIGN="CENTER">');
document.write('<nobr><a href="index.html"><img src="picts/logo.gif" border="0"></a></nobr><br>');
document.write('</td><td ALIGN="RIGHT" VALIGN="CENTER">');
document.write('<nobr><SPAN CLASS="slogan"> </span></nobr><br>');
document.write('</td><td width="15">');
document.write('<IMG SRC="picts/spacer.gif" HEIGHT=10 WIDTH=15 border="0"><BR>');


document.write('</td></tr></table>');*/

// START DATE SCRIPT

var showd	= "yes"  	// SHOW THE DATE
var dateLR	= "right"  	// DATE LEFT OR RIGHT
var dateX	= "140"  	// DATE X LOCATION
var dateY	= "175"  	// DATE Y LOCATION
   if (showd == "yes") {
document.write('<div id="date-location" style="'+dateLR+': '+dateX+'px; POSITION: absolute; TOP: '+dateY+'px">');
var d=new Date()
var weekday=new Array("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
var monthname=new Array("January","February","March","April","May","June","July","August","September","October","November","December")
document.write("<span class=\"date-font\"><nobr>" + weekday[d.getDay()] + " ")
document.write(monthname[d.getMonth()] + " ")
document.write(d.getDate() + ". ")
document.write(d.getFullYear())
document.write("</nobr><br></span>")
document.write('</div>');
}
//
//  End -->