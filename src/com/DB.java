package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    final static String DB_URL = "jdbc:mysql://localhost";
    final static String DB_USER = "root";
    final static String DB_PASSWORD = "Lorymessi1!";
    
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        
        try {
            // Carica il driver JDBC di MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Apri la connessione al database
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            // Crea un oggetto Statement per eseguire le query
            statement = connection.createStatement();
            
            // Esempio: Esegui una query
            String sql = "SELECT * FROM your_table";
            // Esegui la query e ottieni i risultati
            // statement.executeQuery(sql);
            
            // Esegui altre operazioni con il database...
            
            System.out.println("Connessione al database MySQL stabilita con successo!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Chiudi le risorse
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}