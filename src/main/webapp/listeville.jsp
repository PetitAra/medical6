<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="medical6.m2i.fr.Ville" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des villes</title>
</head>
<main>

<%ArrayList<Ville> listeville= new ArrayList<Ville>() ;%>

<table class="table table-stripped">
<thead>"<td>ID</td><td>Nom</td><td>CodePostale</td>"</thead>
<body>

<%
listeville = (ArrayList) request.getAttribute("listeville");
for (Ville v: listeville){
%>
<tr>
<td> <%=v.getId() %></td>
<td> <%=v.getNom() %></td>
<td> <%=v.getCodepost() %></td>
</tr>
<%
}
%>
</body>
</main>
</html>