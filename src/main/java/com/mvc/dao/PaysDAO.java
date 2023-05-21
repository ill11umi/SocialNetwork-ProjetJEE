package com.mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.model.Pays;

public class PaysDAO {
    private Connection connection;

    public PaysDAO() {
        connection = ConnexionBDD.getConnection();
    }

    public List<Pays> getAllPays() {
        List<Pays> pays = new ArrayList<Pays>();
        String query = "SELECT * FROM pays";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("idp");
                String nom = rs.getString("nomp");

                Pays pay = new Pays(id, nom);
                pays.add(pay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pays;
    }
}

