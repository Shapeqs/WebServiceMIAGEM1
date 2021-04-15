<%@ page import="com.example.TP4.StaticContext" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulaire</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
     <h1>Inventaire : </h1>
    <form method='post' action='displayForm' class="justify-content-md-center">
        <div class="form-group">
            <label for='name'>Entrez un nom :</label>
            <input type='text' class="form-control" id='name' name='name' required>
            <% if (request.getAttribute("erreurNom") != null
                    && request.getAttribute("erreurNom") != "") { %>
            <div class="alert alert-danger"><%= request.getAttribute("erreurNom") %>
            </div>
            <% } %>
        </div>
        <div class="form-group">
            <label for='quantity'>Entrez une quantité :</label>
            <input type='number' class="form-control" id='quantity' name='quantity' required>
            <% if (request.getAttribute("erreurQuantite") != null
                    && request.getAttribute("erreurQuantite") != "") { %>
            <div class="alert alert-danger">
                <%= request.getAttribute("erreurQuantite") %>
            </div>
            <% } %>
        </div>
        <input type='submit' class="btn btn-primary" value='Envoyer'>
        </br>
        <% if (request.getAttribute("resultat") != null) { %>
        <div class="alert alert-success" style="margin-top: 20px">
            <%= request.getAttribute("resultat") %>
        </div>
        <% } %>
        <% if (request.getAttribute("errors") != null) { %>
        <div class="alert alert-danger" style="margin-top: 20px">
            <%= request.getAttribute("errors") %>
        </div>
        <% } %>
    </form>
    <div>
        <ul>
            <%
                if (request.getAttribute("data") != null) {
                    Map<String, String> data = (Map<String, String>) request.getAttribute("data");
                    if (!data.isEmpty()) {
                        for (Map.Entry<String, String> d : data.entrySet()) {
            %>
            <li>
                <%=d.getKey() %> - <%=String.valueOf(d.getValue())%>

                <% } %>
            </li>
            <%
                        }
                    }
            %>
        </ul>
    </div>
</div>
</body>
</html>
