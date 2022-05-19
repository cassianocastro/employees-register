package model;

import java.util.*;

/**
 *
 *
 */
public class RegistersEmployees implements Repository
{

    private final List<Employee> grupo;

    public RegistersEmployees()
    {
        this.grupo = new LinkedList<>();
    }

    @Override
    public void add(Object object)
    {
        this.grupo.add((Employee) object);
    }

    @Override
    public StringBuilder toStringBuilder()
    {
        if ( !this.grupo.isEmpty() )
        {
            StringBuilder msg = new StringBuilder();
            for ( Employee funcionario : this.grupo )
            {
                msg.append(funcionario.toString());
                msg.append("\n***\n");
            }
            return msg;
        }
        return new StringBuilder("Sem registros");
    }

}
