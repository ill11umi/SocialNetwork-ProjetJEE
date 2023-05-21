package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.model.Pays;
import com.mvc.model.Ville;

public class VilleDAO {
    private Connection connection;

    public VilleDAO() {
        connection = ConnexionBDD.getConnection();
    }

    public List<Ville> getAllVilles() {
        List<Ville> villes = new ArrayList<Ville>();
        String query = "SELECT ville.idv, ville.nomv, pays.idp, pays.nomp FROM ville INNER JOIN pays ON ville.idp = pays.idp";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("idv");
                String nom = rs.getString("nomv");
                int idPays = rs.getInt("idp");
                String nomPays = rs.getString("nomp");

                Pays pays = new Pays(idPays, nomPays);
                Ville ville = new Ville(id, nom, pays);
                villes.add(ville);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return villes;
    }

    public List<Ville> getVillesByPays(int idPays) {
        List<Ville> villes = new ArrayList<Ville>();
        String query = "SELECT ville.idv, ville.nomv, pays.idp, pays.nomp FROM ville INNER JOIN pays ON ville.idp = pays.idp WHERE pays.idp = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idPays);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idv");
                String nom = rs.getString("nomv");
                String nomPays = rs.getString("nomp");

                Pays pays = new Pays(idPays, nomPays);
                Ville ville = new Ville(id, nom, pays);
                villes.add(ville);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return villes;
    }
}
