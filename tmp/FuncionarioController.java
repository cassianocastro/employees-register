package old;

import java.sql.SQLException;
import java.sql.Connection;
import java.text.*;
import java.util.Date;

/**
 *
 */
public class FuncionarioController
{

    private final Dao funcionarioDAO;
    private final View funcionarioView;

    public FuncionarioController(Connection connection)
    {
        this.funcionarioDAO  = new FuncionarioDAO(connection);
        this.funcionarioView = new FuncionarioView();
    }

    public void caller()
    {
        int opcao;

        while ( true )
        {
            opcao = this.funcionarioView.getOption();

            try
            {
                switch ( opcao )
                {
                    case 0:
                        create();
                        break;
                    case 1:
                        read();
                        break;
                    case 2:
                        search();
                        break;
                    case 3:
                        update();
                        break;
                    case 4:
                        delete();
                        break;
                    default:
                        System.exit(0);
                }
            }
            catch ( SQLException | ParseException e )
            {
                this.funcionarioView.show(e.getMessage());
            }
        }
    }

    private void create() throws SQLException, ParseException
    {
        String[] dados = this.funcionarioView.insert();

        if ( dados == null )
        {
            return;
        }

        String nome = dados[0];
        String cpf  = dados[1];
        Sexo sexo   = Sexo.valueOf(dados[2]);
        Date date   = new SimpleDateFormat("dd/MM/yyyy").parse(dados[3]);

        this.funcionarioDAO.create(new Funcionario(0, nome, sexo, cpf, date));

        this.funcionarioView.show("Funcionário cadastrado.");
    }

    private void read() throws SQLException
    {
        this.funcionarioView.show(
            this.funcionarioDAO.read().toStringBuilder()
        );
    }

    private void update() throws SQLException, ParseException
    {
        int ID = Integer.parseUnsignedInt(this.funcionarioView.getID());

        Funcionario funcionario = (Funcionario) this.funcionarioDAO.findByThis(ID);

        if ( funcionario == null )
        {
            this.funcionarioView.show("Funcionário não encontrado.");

            return;
        }

        String[] dados = this.funcionarioView.update();

        switch ( dados[0] )
        {
            case "Nome":
                funcionario.setNome(dados[1]);
                break;
            case "CPF":
                funcionario.setCpf(dados[1]);
                break;
            case "Sexo":
                funcionario.setSexo(Sexo.valueOf(dados[1]));
                break;
            default:
                funcionario.setData_nascimento(
                    new SimpleDateFormat("dd/MM/yyyy").parse(dados[1])
                );
        }

        this.funcionarioDAO.update(funcionario);
        this.funcionarioView.show("Registro atualizado.");
    }

    private void delete() throws SQLException
    {
        int ID = Integer.parseUnsignedInt(this.funcionarioView.getID());

        Object funcionario = this.funcionarioDAO.findByThis(ID);

        if ( funcionario == null )
        {
            this.funcionarioView.show("Funcionário não encontrado.");

            return;
        }

        this.funcionarioDAO.delete(funcionario);
        this.funcionarioView.show("Funcionário excluído");
    }

    private void search() throws SQLException
    {
        int ID = Integer.parseUnsignedInt(this.funcionarioView.getID());

        Object funcionario = this.funcionarioDAO.findByThis(ID);

        if ( funcionario == null )
        {
            this.funcionarioView.show("Funcionário não encontrado.");

            return;
        }

        this.funcionarioView.show(funcionario.toString());
    }
}