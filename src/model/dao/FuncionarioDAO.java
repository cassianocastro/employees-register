package model.dao;

import model.RegistrosFuncionarios;
import model.Funcionario;
import model.Repositorio;
import model.Sexo;
import java.sql.*;

/**
 *
 * @author User
 */
public class FuncionarioDAO implements Dao{
    private Connection connection;
    
    public FuncionarioDAO(Connection connection){
        this.connection = connection;
    }
    
    @Override
    public void create(Object object) throws SQLException {
        Funcionario funcionario = (Funcionario) object;
        String SQL = "INSERT INTO funcionarios " +
                     "( nome, sexo, cpf, data_nasc ) " +
                     "VALUES " +
                     "( ?, ?, ?, ? )";
        try(PreparedStatement statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getSexo());
            statement.setString(3, funcionario.getCpf());
            statement.setDate  (4, new Date(funcionario.getData_nascimento().getTime()));
            statement.executeUpdate();
        }
    }

    @Override
    public Repositorio read() throws SQLException {
        Repositorio repositorio = new RegistrosFuncionarios();
        String SQL = "SELECT * FROM funcionarios";
        try( PreparedStatement statement = this.connection.prepareStatement(SQL);
             ResultSet rs = statement.executeQuery() )
        {
            while ( rs.next() ){
                int ID      = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String cpf  = rs.getString("cpf");
                Sexo sexo   = Sexo.valueOf(
                              rs.getString("sexo"));
                java.util.
                Date data   = rs.getDate("data_nasc");
                repositorio.add(new Funcionario(ID, nome, sexo, cpf, data));
            }
        }
        return repositorio;
    }

    @Override
    public void update(Object object) throws SQLException {
        Funcionario funcionario = ( Funcionario ) object;
        String SQL = "UPDATE funcionarios SET " +
                     "nome = ?, " +
                     "sexo = ?, " +
                     "cpf = ?, " +
                     "data_nasc = ? " +
                     "WHERE codigo = ?";
        try(PreparedStatement statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getSexo());
            statement.setString(3, funcionario.getCpf());
            statement.setDate  (4, new Date(funcionario.getData_nascimento().getTime()));
            statement.setInt   (5, funcionario.getID());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Object object) throws SQLException {
        Funcionario funcionario = ( Funcionario ) object;
        String SQL = "DELETE FROM funcionarios WHERE codigo = ?";
        try(PreparedStatement statement = this.connection.prepareStatement(SQL))
        {
            statement.setInt(1, funcionario.getID());
            statement.executeUpdate();
        }
    }
    
    @Override
    public Object findByThis(int IDinformado) throws SQLException {
        String SQL = "SELECT * FROM funcionarios WHERE codigo = ?";

        try(PreparedStatement statement = this.connection.prepareStatement(SQL))
        {
            statement.setInt(1, IDinformado);
            try ( ResultSet rs = statement.executeQuery() ){
                while ( rs.next() ){
                    int ID      = rs.getInt("codigo");
                    String nome = rs.getString("nome");
                    String cpf  = rs.getString("cpf");
                    Sexo sexo   = Sexo.valueOf(rs.getString("sexo"));
                    Date data   = rs.getDate("data_nasc");
                    return new Funcionario(ID, nome, sexo, cpf, data);
                }
            }
        }
        return null;
    }
}
