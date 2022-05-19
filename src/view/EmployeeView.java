package view;

import javax.swing.*;

/**
 *
 *
 */
public class EmployeeView implements View
{

    @Override
    public int getOption()
    {
        return JOptionPane.showOptionDialog(
            null,
            "Choose an option:",
            "Employee",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            new String[]
            {
                "Insert", "Show", "Search", "Update", "Delete", "Exit"
            },
            null
        );
    }

    @Override
    public String[] insert()
    {
        return new EmployeeRegisterView().getDados();
    }

    @Override
    public void show(CharSequence msg)
    {
        JOptionPane.showMessageDialog(
            null,
            msg,
            "Employees",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    @Override
    public String getID()
    {
        return JOptionPane.showInputDialog("ID:");
    }

    @Override
    public String[] update()
    {
        String attribute = JOptionPane.showInputDialog(
            null,
            "Attribute type:",
            "To alter...",
            JOptionPane.DEFAULT_OPTION,
            null,
            new String[]
            {
                "Name", "CPF", "Sex", "BirthDate"
            },
            null
        ).toString();

        String newData = JOptionPane.showInputDialog(null, attribute + ":");

        return new String[]
        {
            attribute,
            newData
        };
    }
}