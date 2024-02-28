package view;

import javax.swing.*;

/**
 *
 */
public class EmployeeView
{

    public void show(CharSequence msg)
    {
        JOptionPane.showMessageDialog(
            null,
            msg,
            "Employees",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public String getID()
    {
        return JOptionPane.showInputDialog("ID:");
    }

    public String[] update()
    {
        String attribute = JOptionPane.showInputDialog(
            null,
            "Attribute type:",
            "To alter...",
            JOptionPane.DEFAULT_OPTION,
            null,
            new String[] { "Name", "CPF", "Sex", "BirthDate" },
            null
        ).toString();

        String newData = JOptionPane.showInputDialog(null, attribute + ":");

        return new String[] { attribute, newData };
    }
}