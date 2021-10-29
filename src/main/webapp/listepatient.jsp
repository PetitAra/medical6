<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="medical6.m2i.fr.Patient" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des patients</title>
</head>
<body>

<%@ include file="fragments/header.jsp" %>
<main class="container">

<%ArrayList<Patient> listepatient= new ArrayList<Patient>() ;%>

<table class="table table-stripped">
<thead>"<td>ID</td><td>Nom & prénom</td><td>Date de naissance</td><td>Adresse</td><td>Ville</td><td>Pays</td>"</thead>
<tbody>
<%
listepatient = (ArrayList) request.getAttribute("listepatient");
for (Patient p: listepatient){
%>
<tr>
<td> <%=p.getId() %></td>
<td> <%=p.getNom() + " " +p.getPrenom()%></td>
<td> <%=p.getLocalDatenaissance() %></td>
<td> <%=p.getAdresse() %></td>
<td> <%=p.getPays() %></td>
<td> <%=p.getVille() %></td>
</tr>
<%
}
%>
</tbody>
</table>

</main>
<%@ include file="fragments/footer.jsp" %>


</body>
</html>