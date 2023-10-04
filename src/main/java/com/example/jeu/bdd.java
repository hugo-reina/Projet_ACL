package com.example.jeu;

import java.sql.*;

public class bdd {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Étape 1 : Charger le driver SQLite
            Class.forName("org.sqlite.JDBC");

            // Étape 2 : Se connecter à la base de données
            connection = DriverManager.getConnection("jdbc:sqlite:ma_base_de_donnees.db");
            System.out.println("Connexion établie.");

            // Étape 3 : Créer une table (si elle n'existe pas)
            Statement statement = connection.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS ma_table (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nom TEXT, " +
                    "age INTEGER)";
            statement.execute(createTableSQL);
            // Étape 4 : Insérer des données
            String insertDataSQL = "INSERT INTO ma_table (nom, age) VALUES " +
                    "('Alice', 25)";
            statement.execute(insertDataSQL);
            System.out.println("Table créée avec succès.");
            String selectDataSQL = "SELECT * FROM ma_table";
            ResultSet resultSet = statement.executeQuery(selectDataSQL);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                int age = resultSet.getInt("age");
                System.out.println("ID : " + id + ", Nom : " + nom + ", Age : " + age);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
