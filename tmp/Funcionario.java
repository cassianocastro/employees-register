package old;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class Funcionario
{

    private String nome;
    private String cpf;
    private int ID;
    private Sexo sexo;
    private Date data_nascimento;

    public Funcionario(int ID, String nome, Sexo sexo, String cpf, Date data_nascimento)
    {
        this.ID = ID;
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
    }

    @Override
    public String toString()
    {
        return "\nID: " + this.ID
            + "\nNome: " + this.nome
            + "\nSexo: " + this.sexo.getDescricao()
            + "\nCPF: " + this.cpf
            + "\nData de Nascimento: " + new SimpleDateFormat("dd/MM/yyyy")
                .format(this.data_nascimento);
    }

    public String getNome()
    {
        return this.nome;
    }

    public String getSexo()
    {
        return this.sexo.getDescricao();
    }

    public String getCpf()
    {
        return this.cpf;
    }

    public int getID()
    {
        return this.ID;
    }

    public Date getData_nascimento()
    {
        return this.data_nascimento;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public void setSexo(Sexo sexo)
    {
        this.sexo = sexo;
    }

    public void setData_nascimento(Date data_nascimento)
    {
        this.data_nascimento = data_nascimento;
    }
}