package com.example.TP2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "DisplayFormServlet",
        description = "A simple display servlet",
        value = "/displayForm")
public class DisplayForm extends HttpServlet {

    /*public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get Data
        String nom = request.getParameter("name");
        Integer quantite = Integer.valueOf(request.getParameter("quantity"));
        StaticContext.articles.put(nom, quantite);
        System.out.println("Added : " + nom + " - " + quantite);

        ArrayList<String> data = new ArrayList<>();

        // Set Display data
        for (Map.Entry<String, Integer> entry : StaticContext.articles.entrySet()) {
            data.add(entry.getKey() + " - " + entry.getValue());
        }

        // Send back data
        request.setAttribute("data", data);
        request.getRequestDispatcher("/form.jsp").forward(request, response);
    }*/

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get Data
        String nom = request.getParameter("name");
        Integer quantite = Integer.valueOf(request.getParameter("quantity"));
        StaticContext.articles.put(nom, quantite);

        // Set Display data
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Formulaire Result</title></head>");
        out.println("<body>");
        out.println("<form action='displayForm' method='post'>");
        out.println("<label for='name'>Entrez un nom :</label>");
        out.println("<input type='text' id='name' name='name' required>");
        out.println("<label for='quantity'>Entrez une quantité :</label>");
        out.println("<input type='number' id='quantity' name='quantity' required>");
        out.println("<input type='submit' value='Envoyer'>");
        out.println("</form>");
        out.println("<div>");
        for (Map.Entry<String, Integer> entry : StaticContext.articles.entrySet()) {
            response.getWriter().println(entry.getKey() + " - " + entry.getValue() + "<br>");
        }
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }

    public void destroy() {
    }
}