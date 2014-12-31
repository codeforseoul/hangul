<!DOCTYPE html>
<html>
<head>
<title>Dragon and Crane Labs - Korean Language Learning</title>

<!--  try to get hangul working on JSP: not sure if relevant -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link rel="stylesheet" href="css/styles.css">

<style>


</style>

</head>


<body>

<!--  try to get hangul working on JSP: def is relevant -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.dragoncrane.korean.Prototype" %>
<%@ page import="com.dragoncrane.korean.match.RuleMatch" %>

<!--  this line did the trick -->
<% request.setCharacterEncoding("UTF-8");	%>


<h1>Dragon and Crane Labs</h1>
<h3>한글 Romanizer</h3>


<!--  store text in a session-scoped bean -->
<FORM ACTION="korean.jsp"
	METHOD="POST"> 
Type in some mixed Korean and English text:
<br>

<textarea
	name="hangulText"
	id="textarea"
	cols="40"
	rows="4">
Sample input mixing English and 한글
</textarea>

<!--
<INPUT TYPE="TEXT" NAME="hangulText" VALUE="Sample input mixing English and 한글"><BR>
-->
<INPUT TYPE="SUBMIT"> <!-- Press this to submit form -->
</FORM>


<% if ( request.getParameter( "hangulText" ) != null ) { %>

<% String hangul = request.getParameter( "hangulText" ); %>

<table border="0">
	<tr>
		<td>Original 한글:</td>
		<td><%= request.getParameter( "hangulText" ) %></td>
	</tr>
	<tr>
		<td>Romanized:</td>
		<td><%= Prototype.getInstance().getRomanization( hangul ) %></td>
	</tr>
</table>



<%--
<br>
Mouse over the text below to see the grammar decomposition:
<br>
<%
	Prototype prototype = Prototype.getInstance();
	String roman = prototype.getRomanization( hangul );
	SortedSet<RuleMatch> matches = prototype.matchRules( hangul );
	String asHTML = prototype.encodeHTML( hangul, roman, matches );
%>

<%= Prototype.getInstance().encodeHTML( hangul, roman, matches ) %>
<br>
 --%>



<%-- matches if ( param != null ) ... --%>
<% } %>

<p>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/jquery.qtip-1.0.0-rc3.min.js"></script>
<script type="text/javascript" src="js/tooltips.js"></script>

<noscript>Your browser either does not support JavaScript, or has it turned off.</noscript>
</p>


<hr>

<!--
<h3>Pronunciation Guide</h3>


	<table border="1" cellpadding="7" rules="all" frame="box" style="width: 30%; float: none; text-align: left; vertical-align: top;">
		<tbody>
			<tr>
				<td valign="top" style="width: 50%;"><b>Consonant</b></td>
				<td valign="top" style="width: 50%;"><b>Pronunciation</b></td>
			</tr>
			<tr>
				<td valign="top" style="width: 50%;">ㄱ</td>
				<td valign="top" style="width: 50%;">g</td>
			</tr>
			<tr>
				<td valign="top" style="width: 50%;">ㄴ</td>
				<td valign="top" style="width: 50%;">n</td>
			</tr>
			<tr>
				<td valign="top" style="width: 50%;">ㅁ</td>
				<td valign="top" style="width: 50%;">m</td>
			</tr>
			<tr>
				<td valign="top" style="width: 50%;">ㅅ</td>
				<td valign="top" style="width: 50%;">s</td>
			</tr>
		</tbody>
	</table>
	<br />
</div>
<h1><a name="Base_Vowels:_5" class="toclink" title="Base_Vowels:_5"></a>Base Vowels: 5</h1>
<div>
	<br class="Apple-interchange-newline" />
	<table border="1" cellpadding="7" rules="all" frame="box" style="width: 751px; float: none; vertical-align: top;">
		<tbody>
			<tr>
				<td valign="top" style="width: 111px;"><b>Vowel</b></td>
				<td valign="top" style="width: 110px;">ㅏ</td>
				<td valign="top" style="width: 110px;">ㅓ</td>
				<td valign="top" style="width: 110px;">ㅗ</td>
				<td valign="top" style="width: 110px;">ㅜ</td>
				<td valign="top" style="width: 110px;">ㅣ</td>
			</tr>
			<tr>
				<td valign="top" style="width: 111px;"><b>Pronunciation</b></td>
				<td valign="top" style="width: 110px;">ah</td>
				<td valign="top" style="width: 110px;">uh</td>
				<td valign="top" style="width: 110px;">oh</td>
				<td valign="top" style="width: 110px;">oo</td>
				<td valign="top" style="width: 110px;">ee</td>
			</tr>
		</tbody>
	</table>
	<br />
</div>
<h1><a name="Basic_Combinations:_20" class="toclink" title="Basic_Combinations:_20"></a>Basic Combinations: 20</h1>
<div>
	<table border="1" cellpadding="7" rules="all" frame="box" style="width: 80%; float: none; text-align: left; vertical-align: top;">
		<tbody>
			<tr>
				<td valign="top" style="width: 16.666666666666668%;"><b>Consonant\Vowel</b></td>
				<td valign="top" style="width: 16.666666666666668%;">ㅏ</td>
				<td valign="top" style="width: 16.666666666666668%;">ㅓ</td>
				<td valign="top" style="width: 16.666666666666668%;">ㅗ</td>
				<td valign="top" style="width: 16.666666666666668%;">ㅜ</td>
				<td valign="top" style="width: 16.666666666666668%;">ㅣ</td>
			</tr>
			<tr>
				<td valign="top" style="width: 16.666666666666668%;">ㄱ</td>
				<td valign="top" style="width: 16.666666666666668%;">가 (gah)</td>
				<td valign="top" style="width: 16.666666666666668%;">거 (guh)</td>
				<td valign="top" style="width: 16.666666666666668%;">고 (goh)</td>
				<td valign="top" style="width: 16.666666666666668%;">구 (goo)</td>
				<td valign="top" style="width: 16.666666666666668%;">기 (gee)</td>
			</tr>
			<tr>
				<td valign="top" style="width: 16.666666666666668%;">ㄴ</td>
				<td valign="top" style="width: 16.666666666666668%;">나 (nah)</td>
				<td valign="top" style="width: 16.666666666666668%;">너 (nuh)</td>
				<td valign="top" style="width: 16.666666666666668%;">노 (noh)</td>
				<td valign="top" style="width: 16.666666666666668%;">누 (noo)</td>
				<td valign="top" style="width: 16.666666666666668%;">니 (nee)</td>
			</tr>
			<tr>
				<td valign="top" style="width: 16.666666666666668%;">ㅁ</td>
				<td valign="top" style="width: 16.666666666666668%;">마 (mah)</td>
				<td valign="top" style="width: 16.666666666666668%;">머 (muh)</td>
				<td valign="top" style="width: 16.666666666666668%;">모 (moh)</td>
				<td valign="top" style="width: 16.666666666666668%;">무 (moo)</td>
				<td valign="top" style="width: 16.666666666666668%;">미 (mee)</td>
			</tr>
			<tr>
				<td valign="top" style="width: 16.666666666666668%;">ㅅ</td>
				<td valign="top" style="width: 16.666666666666668%;">사 (sah)</td>
				<td valign="top" style="width: 16.666666666666668%;">서 (suh)</td>
				<td valign="top" style="width: 16.666666666666668%;">소 (soh)</td>
				<td valign="top" style="width: 16.666666666666668%;">수 (soo)</td>
				<td valign="top" style="width: 16.666666666666668%;">시 (s<b><font color="#ff0000">h</font></b>ee)</td>
			</tr>
		</tbody>
	</table>
	<br />
	<h1><a name="Silent_Placeholders:_1_+_1" class="toclink" title="Silent_Placeholders:_1_+_1"></a>Silent Placeholders: 1 + 1</h1>
</div>
<h2><a name="Consonant:_ㅇ" class="toclink" title="Consonant:_ㅇ"></a>Consonant: ㅇ</h2>
<div>
	<br class="Apple-interchange-newline" />
	<table border="1" cellpadding="7" rules="all" frame="box" style="width: 751px; float: none; vertical-align: top;">
		<tbody>
			<tr>
				<td valign="top" style="width: 111px;"><b>Placeholder\Vowel</b></td>
				<td valign="top" style="width: 110px;">ㅏ</td>
				<td valign="top" style="width: 110px;">ㅓ</td>
				<td valign="top" style="width: 110px;">ㅗ</td>
				<td valign="top" style="width: 110px;">ㅜ</td>
				<td valign="top" style="width: 110px;">ㅣ</td>
			</tr>
			<tr>
				<td valign="top" style="width: 111px;">ㅇ</td>
				<td valign="top" style="width: 110px;">아 (ah)</td>
				<td valign="top" style="width: 110px;">어 (uh)</td>
				<td valign="top" style="width: 110px;">오 (oh)</td>
				<td valign="top" style="width: 110px;">우 (oo)</td>
				<td valign="top" style="width: 110px;">이 (ee)</td>
			</tr>
		</tbody>
	</table>
	<br />
</div>
<h2><a name="Vowel:_ㅡ" class="toclink" title="Vowel:_ㅡ"></a>Vowel: ㅡ</h2>
<div>
	<br class="Apple-interchange-newline" />
	<table border="1" cellpadding="7" rules="all" frame="box" style="width: 281px; float: none; vertical-align: top;">
		<tbody>
			<tr>
				<td valign="top" style="width: 126px;"><b>Consonant\Placeholder</b></td>
				<td valign="top" style="width: 125px;"><b>ㅡ</b></td>
			</tr>
			<tr>
				<td valign="top" style="width: 126px;">ㄱ</td>
				<td valign="top" style="width: 125px;">그 (g)</td>
			</tr>
			<tr>
				<td valign="top" style="width: 126px;">ㄴ</td>
				<td valign="top" style="width: 125px;">느 (n)</td>
			</tr>
			<tr>
				<td valign="top" style="width: 126px;">ㅁ</td>
				<td valign="top" style="width: 125px;">므 (m)</td>
			</tr>
			<tr>
				<td valign="top" style="width: 126px;">ㅅ</td>
				<td valign="top" style="width: 125px;">스 (s)<br /><br /></td>
			</tr>
		</tbody>
	</table>
-->

</body></html>
