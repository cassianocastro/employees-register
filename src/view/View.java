package view;

/**
 *
 */
public interface View
{

    public int getOption();

    public String[] insert();

    public void show(CharSequence mensagem);

    public String getID();

    public String[] update();

}
