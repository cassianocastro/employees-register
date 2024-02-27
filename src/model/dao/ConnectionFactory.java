package model.dao;

import java.sql.*;

/**
 *
 */
public class ConnectionFactory
{

    public Connection createConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:sqlite:src/lib/db.sqlite");
    }
}