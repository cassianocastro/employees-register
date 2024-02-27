package controller;

import java.sql.SQLException;
import java.sql.Connection;
import java.text.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.dao.EmployeeDAO;
import model.Employee;
import model.EmployeeFormatter;
import model.Sex;
import model.dao.ConnectionFactory;
import view.EmployeeRegisterView;
import view.EmployeeView;

/**
 *
 */
public class EmployeesController
{

    public void addEmployee()
    {
        String[] dados = new EmployeeRegisterView().getDados();

        if ( dados == null ) return;

        String name   = dados[0];
        String cpf    = dados[1];
        Sex sex       = Sex.valueOf(dados[2]);
        Calendar date = Calendar.getInstance();

        try (Connection connection = new ConnectionFactory().createConnection())
        {
            date.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dados[3]));

            new EmployeeDAO(connection).insert(new Employee(0, name, sex, cpf, date));
        }
        catch ( SQLException | ParseException e )
        {
            System.out.println(e.getMessage());
        }

        new EmployeeView().show("Funcionário cadastrado.");
    }

    public void listEmployees()
    {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().createConnection())
        {
            employees = new EmployeeDAO(connection).getAll();
        }
        catch ( SQLException e )
        {
            System.out.println(e.getMessage());
        }

        if ( ! employees.isEmpty() )
        {
            var msg = new EmployeeFormatter().formatList(employees);
            new EmployeeView().show(msg);

            return;
        }

        new EmployeeView().show("Without registers");
    }

    public void updateEmployee()
    {
        var view = new EmployeeView();
        int id   = Integer.parseUnsignedInt(view.getID());

        try (Connection connection = new ConnectionFactory().createConnection())
        {
            var dao = new EmployeeDAO(connection);

            Employee employee = dao.findByID(id);
            String[] dados    = view.update();

            switch ( dados[0] )
            {
                case "Name":
                    employee.setName(dados[1]);
                    break;
                case "CPF":
                    employee.setCPF(dados[1]);
                    break;
                case "Sex":
                    employee.setSex(Sex.valueOf(dados[1]));
                    break;
                default:
                    Calendar date = Calendar.getInstance();
                    date.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dados[1]));

                    employee.setBirthDate(date);
            }

            dao.update(employee);
            view.show("Registro atualizado.");
        }
        catch ( SQLException | ParseException e )
        {
            System.out.println(e.getMessage());
        }
    }

    public void deleteEmployee()
    {
        var view = new EmployeeView();
        int id   = Integer.parseUnsignedInt(view.getID());

        try (Connection connection = new ConnectionFactory().createConnection())
        {
            var dao = new EmployeeDAO(connection);
            var employee = dao.findByID(id);

            dao.delete(employee);
        }
        catch ( SQLException e )
        {
            System.out.println(e.getMessage());
        }

        view.show("Funcionário excluído");
    }

    public void findEmployee()
    {
        var view = new EmployeeView();
        int id   = Integer.parseUnsignedInt(view.getID());

        try (Connection connection = new ConnectionFactory().createConnection())
        {
            var employee  = new EmployeeDAO(connection).findByID(id);
            var formatted = new EmployeeFormatter().format(employee);

            view.show(formatted);
        }
        catch ( SQLException e )
        {
            System.out.println(e.getMessage());
        }
    }
}