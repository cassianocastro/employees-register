/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.EmployeesController;
import java.sql.Connection;
import java.sql.SQLException;
import model.dao.ConnectionFactory;

/**
 *
 *
 */
public class App
{

    public void start()
    {
        try (Connection connection = new ConnectionFactory().getConnection())
        {
            new EmployeesController(connection).caller();
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}