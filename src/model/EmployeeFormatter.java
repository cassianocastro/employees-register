package model;

import java.text.SimpleDateFormat;
import java.util.List;

/**
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

    public String formatList(List<Employee> employees)
    {
        var msg = new StringBuilder();

        for ( Employee employee : employees )
        {
            msg.append(this.format(employee)).append("\n***\n");
        }

        return msg.toString();
    }
}