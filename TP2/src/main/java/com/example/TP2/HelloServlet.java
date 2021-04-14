package com.example.TP2;

import java.io.*;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet",
        description = "A simple hello servlet",
        value = "/hello")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String nom = request.getParameter("nom");

        String message = "Bonjour monsieur";
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + " " + nom + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}