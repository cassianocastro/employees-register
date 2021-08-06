package model.dao;

import java.sql.*;

/**
 *
 * @author User
 */
public class ConnectionFactory {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/exercicio", "root", ""
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}