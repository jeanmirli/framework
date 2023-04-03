<%@page import="java.util.HashMap"%>
<%@page import="etu002057.framework.Mapping"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    HashMap<String, Mapping> mappingUrls = (HashMap<String, Mapping>) request.getAttribute("mappingUrls");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste</title>
    <style>
        th, td {
            width: 300px;
        }
        table {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Liste des URLs mappées</h1>
    <table>
        <thead>
            <tr>
                <th>URL</th>
                <th>Méthode</th>
                <th>Classe</th>
            </tr>
        </thead>
        <tbody>
            <% for (HashMap.Entry<String, Mapping> entry : mappingUrls.entrySet()) { %>
                <tr>
                    <td><%= entry.getKey() %></td>
                    <td><%= entry.getValue().getMethod() %></td>
                    <td><%= entry.getValue().getClassName() %></td>
                </tr>
            <% } %>

        </tbody>
    </table>
</body>
</html>
