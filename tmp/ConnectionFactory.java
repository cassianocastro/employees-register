package old;

import java.sql.*;

/**
 *
 */
public class ConnectionFactory
{

    public Connection getConnection()
    {
        try
        {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/exercicio",
                "modifier",
                "modifier"
            );
        }
        catch ( SQLException e )
        {
            System.out.println(e.getMessage());
        }

        return null;
    }
}