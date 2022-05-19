package controller;

import java.sql.SQLException;
import java.sql.Connection;
import java.text.*;
import java.util.Calendar;
import model.dao.EmployeeDAO;
import model.Employee;
import model.EmployeeFormatter;
import model.Sex;
import view.EmployeeView;
import view.View;

/**
 *
 *
 */
public class EmployeesController
{

    private final EmployeeDAO employeeDAO;
    private final View employeeView;

    public EmployeesController(Connection connection)
    {
        this.employeeDAO  = new EmployeeDAO(connection);
        this.employeeView = new EmployeeView();
    }

    public void caller()
    {
        int option;
        
        while ( true )
        {
            option = this.employeeView.getOption();
            try
            {
                switch ( option )
                {
                    case 0:
                        this.create();
                        break;
                    case 1:
                        this.read();
                        break;
                    case 2:
                        this.search();
                        break;
                    case 3:
                        this.update();
                        break;
                    case 4:
                        this.delete();
                        break;
                    default:
                        System.exit(0);
                }
            } catch (SQLException | ParseException e)
            {
                this.employeeView.show(e.getMessage());
            }
        }
    }

    private void create() throws SQLException, ParseException
    {
        String[] dados = this.employeeView.insert();

        if ( dados == null ) return;

        String name   = dados[0];
        String cpf    = dados[1];
        Sex sex       = Sex.valueOf(dados[2]);
        Calendar date = Calendar.getInstance();

        date.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dados[3]));

        this.employeeDAO.insert(new Employee(0, name, sex, cpf, date));
        this.employeeView.show("Funcionário cadastrado.");
    }

    private void read() throws SQLException
    {
        this.employeeView.show(this.employeeDAO.getAll().toString());
    }

    private void update() throws SQLException, ParseException
    {
        int id = Integer.parseUnsignedInt(this.employeeView.getID());

        Employee employee = this.employeeDAO.findByID(id);
        String[] dados    = this.employeeView.update();

        switch ( dados[0] )
        {
            case "Nome":
                employee.setName(dados[1]);
                break;
            case "CPF":
                employee.setCPF(dados[1]);
                break;
            case "Sexo":
                employee.setSex(Sex.valueOf(dados[1]));
                break;
            default:
                Calendar date = Calendar.getInstance();
                date.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dados[1]));

                employee.setBirthDate(date);
        }
        this.employeeDAO.update(employee);
        this.employeeView.show("Registro atualizado.");
    }

    private void delete() throws SQLException
    {
        int id = Integer.parseUnsignedInt(this.employeeView.getID());

        Employee employee = this.employeeDAO.findByID(id);

        this.employeeDAO.delete(employee);
        this.employeeView.show("Funcionário excluído");
    }

    private void search() throws SQLException
    {
        int id = Integer.parseUnsignedInt(this.employeeView.getID());

        Employee employee = this.employeeDAO.findByID(id);
        String formatted  = new EmployeeFormatter().format(employee);

        this.employeeView.show(formatted);
    }
}