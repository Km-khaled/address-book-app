<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.*" %>
<%@ page import=" com.example.mid" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Carnets</title>
    <style>
        .table-container {
            width: 80%;
            margin: 0 auto;
        }

        .data-table {
            width: 100%;
            border-collapse: collapse;
        }

        .data-table th, .data-table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        .data-table th {
            background-color: #f2f2f2;
        }

        .data-table tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .data-table tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<h2>Liste des Carnets</h2>
<div class="table-container">
    <table class="data-table">
        <thead>
        <tr>
            <th>Nom</th>
            <th>ID</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            ConnectionClass connection = new ConnectionClass(); // Instantiate your ConnectionClass
            connection.connect(); // Connect to the database

            try {
                String sql = "SELECT * FROM crnt_org";
                PreparedStatement statement = connection.cnnx.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String nomcrnt = resultSet.getString("nom");
                    int id = resultSet.getInt("id");
        %>
        <tr>
            <td><%= nomcrnt %></td>
            <td><%= id %></td>
            <td><a href='index.jsp?id=<%= id %>'>Voir</a></td>
        </tr>
        <%
                }
            } catch (SQLException e) {
                out.println("Error: Unable to fetch data from the database.");
                e.printStackTrace();
            } finally {
                connection.disconnect(); // Disconnect from the database after use
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
