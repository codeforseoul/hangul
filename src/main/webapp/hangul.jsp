<!DOCTYPE html>
<html>
<head>
<title>Dragon and Crane Hangul Romanization</title>

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
<%@ page import="com.dragoncrane.hangul.HangulUtil" %>

<!--  this line did the trick -->
<%
	request.setCharacterEncoding("UTF-8");
%>


<h3>한글 Romanizer</h3>


<!--  store text in a session-scoped bean -->
<FORM ACTION="hangul.jsp"
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


<%
	if ( request.getParameter( "hangulText" ) != null ) {
%>

<%
	String hangul = request.getParameter( "hangulText" );
%>

<table border="0">
	<tr>
		<td>Original 한글:</td>
		<td><%=request.getParameter( "hangulText" )%></td>
	</tr>
	<tr>
		<td>Romanized:</td>
		<td><%=HangulUtil.getInstance().romanize( hangul )%></td>
	</tr>
</table>





<%-- matches if ( param != null ) ... --%>
<% } %>

<p>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/jquery.qtip-1.0.0-rc3.min.js"></script>
<script type="text/javascript" src="js/tooltips.js"></script>

<noscript>Your browser either does not support JavaScript, or has it turned off.</noscript>
</p>


<hr>

</body>

</html>
