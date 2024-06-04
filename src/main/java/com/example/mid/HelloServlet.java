package com.example.mid;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private carnetDao carnetDao;
    private AdresseDao adresseDao;
    private Map<String, carnet> carnets;

    public void init() throws ServletException {
        carnetDao = new carnet();
        adresseDao = new AdresseDaoImpl();
        carnets = new HashMap<>();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomCarnet = request.getParameter("nomCarnet");
        if (nomCarnet != null && carnets.containsKey(nomCarnet)) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/carnet.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "ajouter":
                    String nomPersonne = request.getParameter("nomPersonne");
                    String rue = request.getParameter("rue");
                    String ville = request.getParameter("ville");
                    int idCarnet = Integer.parseInt(request.getParameter("idCarnet"));
                    Personne personne = new Personne(nomPersonne);
                    Adresse adresse = new Adresse(rue, ville, personne);
                    int insertionResult = adresseDao.enregistrerAdresse(idCarnet, nomPersonne, adresse);

                    if (insertionResult == 1) {
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();
                        out.println("Congratulation data are saved correctly");
                    } else {
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();
                        out.println("Failed to save address. Please try again.");
                    }
                    break;
                case "supprimer":
                    String nomPersonneSupprimer = request.getParameter("nomPersonne");
                    int idCarnet2 = Integer.parseInt(request.getParameter("idCarnet")); // Get the carnet name
                    int deletionResult = adresseDao.effacerAdresse(idCarnet2, nomPersonneSupprimer);

                    if (deletionResult == 1) {
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();
                        out.println("Adresse supprimée avec succès");
                    } else if (deletionResult == -1) {
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();
                        out.println("Aucune adresse trouvée à supprimer.");
                    } else {
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();
                        out.println("Erreur lors de la suppression de l'adresse. Veuillez réessayer.");
                    }
                    break;
                case "chercher":
                    String nomPersonneChercher = request.getParameter("nomPersonne");
                    int idCarnet3 = Integer.parseInt(request.getParameter("idCarnet")); // Get the carnet name
                    Adresse adresseCherchee = adresseDao.chercherAdresse(idCarnet3, nomPersonneChercher);
                    response.setContentType("text/html");
                    PrintWriter out2 = response.getWriter();
                    if (adresseCherchee != null) {
                        out2.println("Adresse trouvée : " + adresseCherchee.getRue() + ", " + adresseCherchee.getVille());
                    } else {
                        out2.println("Aucune adresse trouvée pour " + nomPersonneChercher);
                    }
                    break;
                case "lister":
                    int idCarnet4 = Integer.parseInt(request.getParameter("idCarnet")); // Get the carnet name
                    response.setContentType("text/html");
                    PrintWriter out3 = response.getWriter();
                    out3.println("Liste des adresses :<br>");
                    adresseDao.listerAdresses(idCarnet4, out3);
                    break;
                case "creerCarnet":
                    String nomCarnetCreer = request.getParameter("nomCarnet");
                    int creationResult = carnetDao.creerCarnet(nomCarnetCreer);

                    if (creationResult == 1) {
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();
                        out.println("Le carnet '" + nomCarnetCreer + "' a été créé avec succès.");
                    } else {
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();
                        out.println("Échec de la création du carnet '" + nomCarnetCreer + "'. Veuillez réessayer.");
                    }
                    break;
                case "supprimerCarnet":
                    String nomCarnetSupprimer2 = request.getParameter("nomCarnet");
                    int deletionCarnetResult = carnetDao.supprimerCarnet(nomCarnetSupprimer2);

                    if (deletionCarnetResult == 1) {
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();
                        out.println("Le carnet '" + nomCarnetSupprimer2 + "' a été supprimé avec succès.");
                    } else if (deletionCarnetResult == -1) {
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();
                        out.println("Aucun carnet nommé '" + nomCarnetSupprimer2 + "' n'a été trouvé.");
                    } else {
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();
                        out.println("Erreur lors de la suppression du carnet '" + nomCarnetSupprimer2 + "'. Veuillez réessayer.");
                    }
                    break;
                case "listerCarnets":
                    response.setContentType("text/html");
                    PrintWriter out = response.getWriter();
                    out.println("Liste des carnets :<br>");
                    carnetDao.listerCarnets(out);
                    break;
                default:
                    response.setContentType("text/html");
                    PrintWriter writer = response.getWriter();
                    writer.println("Action non valide");
            }
        } else {
            response.getWriter().append("Aucune action spécifiée");
        }
    }

    public void destroy() {
    }
}