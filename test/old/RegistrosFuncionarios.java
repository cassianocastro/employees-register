package old.Model;

import java.util.*;

/**
 *
 */
public class RegistrosFuncionarios implements Repositorio
{

    private final List<Funcionario> grupo;

    public RegistrosFuncionarios()
    {
        this.grupo = new LinkedList<>();
    }

    @Override
    public void add(Object object)
    {
        this.grupo.add((Funcionario) object);
    }

    @Override
    public StringBuilder toStringBuilder()
    {
        if ( !this.grupo.isEmpty() )
        {
            StringBuilder msg = new StringBuilder();
            for ( Funcionario funcionario : this.grupo )
            {
                msg.append(funcionario.toString());
                msg.append("\n***\n");
            }
            return msg;
        }
        return new StringBuilder("Sem registros");
    }

}
