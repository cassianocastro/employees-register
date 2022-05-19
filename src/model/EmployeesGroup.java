package model;

import java.util.*;

/**
 *
 *
 */
public class EmployeesGroup
{

    private final List<Employee> group;

    public EmployeesGroup()
    {
        this.group = new LinkedList<>();
    }

    public void add(Employee employee)
    {
        this.group.add(employee);
    }

    @Override
    public String toString()
    {
        if ( ! this.group.isEmpty() )
        {
            var msg       = new StringBuilder();
            var formatter = new EmployeeFormatter();

            for ( Employee employee : this.group )
            {
                msg
                    .append(formatter.format(employee))
                    .append("\n***\n");
            }
            return msg.toString();
        }
        return "Without registers";
    }
}