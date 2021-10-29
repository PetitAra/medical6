<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bonjour, c'est la premiere servlet</title>
</head>

<%@ page import="java.util.Date"%>
<body>

	<form name="test" action="" method="post">

		<input type="text" name="chaine">
		<button type="submit">Valider</button>


	</form>
	<h1>Page bonjour</h1>

	<%!String s = "";%>


<%		s = request.getParameter("chaine");
		if (s != null){
		String [] sSplitted = s.split(" ");
		out.println(sSplitted.length);
		}
		
	%>




	<%-- 	<%!int i = 0; --%>
	<%-- 	int a = 0;%> --%>
	<%-- 	<%!Date d = new Date();%> --%>
	<%-- 	<% --%>
	<%-- 	for (int i = 0; i < 10; i++) {
// 		out.println("Bonjour <br>" + d);
// 	}
<%-- 	%> --%>

	<%-- 	<%=d%> --%>

	<%-- 	<% --%>
	<%-- 	out.println(d);
<%-- 	%> --%>


</body>
</html>