package com.example.mid;

// AdresseDaoImpl.java
import java.io.PrintWriter;
import java.sql.*;

public class AdresseDaoImpl implements AdresseDao {

    public SingletonConnection connection = new SingletonConnection();



    @Override
    public synchronized int enregistrerAdresse(int id_carnet, String nomPersonne, Adresse adresse) {
        try {
            String sql = "INSERT INTO carnet (nom, rue, ville,id_ch) VALUES (?, ?, ?,?) ";
            PreparedStatement statement = connection.cnnx.prepareStatement(sql);
            statement.setString(1, nomPersonne);
            statement.setString(2, adresse.getRue());
            statement.setString(3, adresse.getVille());
            statement.setInt(4, id_carnet);


            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    @Override
    public synchronized int effacerAdresse(int id_carnet, String nomPersonne) {
        try {
            String sql = "DELETE FROM carnet WHERE nom = ? and id_ch=?";
            PreparedStatement statement = connection.cnnx.prepareStatement(sql);
            statement.setString(1, nomPersonne);
            statement.setInt(2, id_carnet);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                return 1;
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0; // Error occurred during deletion
        }
    }

    @Override
    public synchronized Adresse chercherAdresse(int id_carnet, String nomPersonne) {
        Adresse adresse = null;
        try {
            String sql = "SELECT rue, ville FROM carnet WHERE nom = ? AND id_ch=?";
            PreparedStatement statement = connection.cnnx.prepareStatement(sql);
            statement.setString(1, nomPersonne);
            statement.setInt(2, id_carnet);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                adresse = new Adresse(resultSet.getString("rue"), resultSet.getString("ville"), null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adresse;
    }

    @Override
    public synchronized void listerAdresses(int id_carnet, PrintWriter out) {
        try {
            String sql = "SELECT nom, rue, ville FROM carnet WHERE id_ch=?";

            PreparedStatement statement = connection.cnnx.prepareStatement(sql);
            statement.setInt(1, id_carnet);

            ResultSet resultSet = statement.executeQuery();

            // Start table structure outside the loop
            out.println("<table border=\"2px\">");
            out.println("<tr>");
            out.println("<th>Nom</th>");
            out.println("<th>Rue</th>");
            out.println("<th>Ville</th>");
            out.println("</tr>");

            // Iterate through the result set and print each row
            while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getString("nom") + "</td>");
                out.println("<td>" + resultSet.getString("rue") + "</td>");
                out.println("<td>" + resultSet.getString("ville") + "</td>");
                out.println("</tr>");
            }

            // Close the table structure
            out.println("</table>");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}