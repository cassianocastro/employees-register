/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;

/**
 *
 *
 */
public class EmployeeFormatter
{

    public String format(Employee employee)
    {
        return String.format(
            "\nID: %d"
            + "\nName: %s"
            + "\nSex: %s"
            + "\nCPF: %s"
            + "\nBirth Date: %s",
            employee.getID(),
            employee.getName(),
            employee.getSex().getDescription(),
            employee.getCPF(),
            new SimpleDateFormat("dd/MM/yyyy").format(employee.getBirthDate().getTime())
        );
    }
}