<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Carnet d'adresses</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.6.0/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            color: #333;
            padding: 20px;
        }
        h1, h2 {
            color: #007bff;
        }
        form {
            margin-bottom: 20px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #fff;
        }
        input[type="text"], input[type="submit"] {
            margin: 5px 0;
        }
    </style>
</head>
<body>
<div class="container">
    <a href="first.jsp"> <h1>Carnet d'adresses</h1> </a>

    <h2>Enregistrer une adresse</h2>
    <form action="/hello-servlet" method="post">
        <div class="form-group">
            <label >Nom de la personne :</label>
            <input type="text" class="form-control" name="nomPersonne" required>
        </div>
        <div class="form-group">
            <label >Rue :</label>
            <input type="text" class="form-control" name="rue" required>
        </div>
        <div class="form-group">
            <label >Ville :</label>
            <input type="text" class="form-control" name="ville" required>
        </div>
        <input type="hidden" name="action" value="ajouter">
        <input type="hidden" name="idCarnet" value="<%= request.getParameter("id")%>">
        <button type="submit" class="btn btn-primary">Enregistrer</button>
    </form>

    <h2>Supprimer une adresse</h2>
    <form action="/hello-servlet" method="post">
        <div class="form-group">
            <label >Nom de la personne :</label>
            <input type="text" class="form-control" name="nomPersonne" required>
        </div>
        <input type="hidden" name="action" value="supprimer">
        <input type="hidden" name="idCarnet" value="<%= request.getParameter("id") %>">
        <button type="submit" class="btn btn-danger">Supprimer</button>
    </form>

    <h2>Chercher une adresse</h2>
    <form action="/hello-servlet" method="post">
        <div class="form-group">
            <label >Nom de la personne :</label>
            <input type="text" class="form-control" name="nomPersonne" required>
        </div>
        <input type="hidden" name="action" value="chercher">
        <input type="hidden" name="idCarnet" value="<%= request.getParameter("id")%>">
        <button type="submit" class="btn btn-info">Chercher</button>
    </form>

    <h2>Lister toutes les adresses</h2>
    <form action="/hello-servlet" method="post">
        <input type="hidden" name="action" value="lister">
        <input type="hidden" name="idCarnet" value="<%=request.getParameter("id") %>">
        <button type="submit" class="btn btn-secondary">Lister</button>
    </form>
</div>
</body>
</html>