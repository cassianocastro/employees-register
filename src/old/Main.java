package old;

import old.Model.dao.ConnectionFactory;
import old.Controll.FuncionarioController;
import java.sql.*;
import javax.swing.*;

/**
 *
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try (Connection connection = new ConnectionFactory().getConnection())
        {
            new FuncionarioController(connection).caller();
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
