<%@ page import="org.amrani.model.Commune" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Commune</title>
</head>
<body>
<% Commune commune = (Commune)request.getAttribute("commune"); %>
<p>Nom: <%=commune.getNom() %></p>
<p>Code Postal: <%=commune.getCodePostal() %></p>


</body>
</html>