<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Carnets</title>
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
    <h1>Gestion des Carnets</h1>

    <h2>Creer un nouveau carnet</h2>
    <form action="/hello-servlet" method="post">
        <div class="form-group">
            <label >Nom du carnet :</label>
            <input type="text" class="form-control" name="nomCarnet" required>
        </div>
        <input type="hidden" name="action" value="creerCarnet">
        <button type="submit" class="btn btn-primary">Creer</button>
    </form>

    <h2>Supprimer un carnet</h2>
    <form action="/hello-servlet" method="post">
        <div class="form-group">
            <label >Nom du carnet :</label>
            <input type="text" class="form-control" name="nomCarnet" required>
        </div>
        <input type="hidden" name="action" value="supprimerCarnet">
        <button type="submit" class="btn btn-danger">Supprimer</button>
    </form>

    <h2>Afficher les carnets</h2>
    <form action="/hello-servlet" method="post">
        <input type="hidden" name="action" value="listerCarnets">
        <button type="submit" class="btn btn-info">Lister</button>
    </form>
</div>
</body>
</html>