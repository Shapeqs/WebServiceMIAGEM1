<%@ page import="com.example.TP2.StaticContext" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulaire</title>
</head>
<body>
<form method='post' action='displayForm'>

    <label for='name'>Entrez un nom :</label>
    <input type='text' id='name' name='name' required>

    <label for='quantity'>Entrez une quantité :</label>
    <input type='number' id='quantity' name='quantity' required>

    <input type='submit' value='Envoyer'>
</form>
</body>
</html>
