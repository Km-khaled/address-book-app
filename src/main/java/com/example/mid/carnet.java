package com.example.mid;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class carnet implements carnetDao {
    private String nom;




    public SingletonConnection connection = new SingletonConnection();

    public carnet() {

    }


    @Override
    public synchronized int creerCarnet(String nom) {
        try {
            String sql = "INSERT INTO crnt_org (nom) VALUES (?)";
            PreparedStatement statement = connection.cnnx.prepareStatement(sql);
            statement.setString(1, nom);
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
    public synchronized void listerCarnets(PrintWriter out) {
        try {
            String sql = "SELECT * FROM crnt_org";
            PreparedStatement statement = connection.cnnx.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            out.println("<table>");
            out.println("<tr>");

            out.println("<th>Nom</th>");
            out.println("</tr>");


            while (resultSet.next()) {
                String nomcrnt = resultSet.getString("nom");
                int id2 = resultSet.getInt("id");




                out.println("  <tr>");
                out.println("    <td>");
                out.println("      <a href='index.jsp?id=" + id2 + "'>" + nomcrnt + "</a>");
                out.println("    </td>");
                out.println("  </tr>");



                out.flush();

            }
            out.println("</table>");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    @Override
    public synchronized int supprimerCarnet(String nom) {
        try {
            String sql = "SELECT id FROM crnt_org WHERE nom=?";
            PreparedStatement statement = connection.cnnx.prepareStatement(sql);
            statement.setString(1, nom);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id2 = resultSet.getInt("id");


                String sql3 = "DELETE FROM carnet WHERE id_ch = ?";
                PreparedStatement statement3 = connection.cnnx.prepareStatement(sql3);
                statement3.setInt(1, id2);
                int rowsDeleted2 = statement3.executeUpdate();



                    String sql2 = "DELETE FROM crnt_org WHERE nom = ?";
                    PreparedStatement statement2 = connection.cnnx.prepareStatement(sql2);
                    statement2.setString(1, nom);
                    int rowsDeleted = statement2.executeUpdate();

                    return 1; // Deletion successful

            } else {
                return -1; // Record not found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0; // Error occurred during deletion
        }
    }
    public synchronized String getNom() {
        return nom;
    }

    public synchronized void setNom(String nom) {
        this.nom = nom;
    }

}