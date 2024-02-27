package old;

/**
 *
 */
public enum Sexo
{
    m("m"), f("f");

    private final String descricao;

    private Sexo(String descricao)
    {
        this.descricao = descricao;
    }

    public String getDescricao()
    {
        return this.descricao;
    }
}