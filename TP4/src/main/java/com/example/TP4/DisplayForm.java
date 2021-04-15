package com.example.TP4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisplayFormServlet",
        description = "A simple display servlet",
        value = "/displayForm")
public class DisplayForm extends HttpServlet {

    private boolean erreur;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get Data
        erreur = false;
        String nom = request.getParameter("name");
        Integer quantite = Integer.valueOf(request.getParameter("quantity"));

        request.setAttribute("erreurQuantite", validationQuantite(quantite));
        request.setAttribute("erreurNom", validationNom(nom));

        if(!erreur){
            request.setAttribute("resultat", "Votre formulaire a correctement été traité !");
            StaticContext.articles.put(nom, quantite);
        } else {
            request.setAttribute("errors", "Votre formulaire n'a pas été traité");
        }

        request.setAttribute("data", StaticContext.articles);

        // Send back data
        request.getRequestDispatcher("/form.jsp").forward(request, response);
    }

    private String validationQuantite(Integer quantite) {
        boolean e = quantite <= 0;
        if (e) {
            erreur = true;
            System.out.println("Erreur q : " + quantite);
            return "Erreur dans la quantité";
        } else {
            return "";
        }
    }

    private String validationNom(String nom) {
        boolean e = nom.isEmpty() || !nom.matches("^[a-zA-Z\\s]+$");
        if (e) {
            erreur = true;
            System.out.println("Erreur n : " + nom);
            return "Erreur dans le nom";
        } else {
            return "";
        }
    }

    public void destroy() {
    }
}