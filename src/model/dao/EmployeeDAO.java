package model.dao;

import model.Employee;
import model.Sex;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 */
public class EmployeeDAO
{

    private final Connection connection;

    public EmployeeDAO(Connection connection)
    {
        this.connection = connection;
    }

    public void insert(Employee employee) throws SQLException
    {
        final String SQL = "INSERT INTO employee(name, sex, cpf, birthDate) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSex().getDescription());
            statement.setString(3, employee.getCPF());
            statement.setLong(4, employee.getBirthDate().getTimeInMillis());

            statement.executeUpdate();
        }
    }

    public void update(Employee employee) throws SQLException
    {
        final String SQL = "UPDATE employee SET name = ?, sex = ?, cpf = ?, birthDate = ? WHERE PK_ID = ?";

        try (var statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSex().getDescription());
            statement.setString(3, employee.getCPF());
            statement.setLong(4, employee.getBirthDate().getTimeInMillis());
            statement.setInt(5, employee.getID());

            statement.executeUpdate();
        }
    }

    public void delete(Employee employee) throws SQLException
    {
        final String SQL = "DELETE FROM employee WHERE PK_ID = ?";

        try (var statement = this.connection.prepareStatement(SQL))
        {
            statement.setInt(1, employee.getID());

            statement.executeUpdate();
        }
    }

    public List<Employee> getAll() throws SQLException
    {
        final String SQL = "SELECT PK_ID, name, sex, cpf, birthDate FROM employee";

        try (var statement = this.connection.createStatement();
            var rs = statement.executeQuery(SQL))
        {
            List<Employee> list = new ArrayList<>();

            while ( rs.next() )
            {
                int id        = rs.getInt("PK_ID");
                String name   = rs.getString("name");
                String cpf    = rs.getString("cpf");
                Sex sex       = Sex.valueOf(rs.getString("sex"));
                Calendar date = Calendar.getInstance();

                date.setTimeInMillis(rs.getLong("birthDate"));

                list.add(new Employee(id, name, sex, cpf, date));
            }

            return list;
        }
    }

    public Employee findByID(int ID) throws SQLException
    {
        final String SQL = "SELECT name, sex, cpf, birthDate FROM employee WHERE PK_ID = ?";

        try (var statement = this.connection.prepareStatement(SQL))
        {
            statement.setInt(1, ID);

            var rs = statement.executeQuery();

            if ( ! rs.next() )
            {
                throw new SQLException("Employee not found!");
            }

            String name   = rs.getString("name");
            String cpf    = rs.getString("cpf");
            Sex sex       = Sex.valueOf(rs.getString("sex"));
            Calendar date = Calendar.getInstance();

            date.setTimeInMillis(rs.getLong("birthDate"));

            return new Employee(ID, name, sex, cpf, date);
        }
    }
}