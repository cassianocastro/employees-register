package view;

/**
 *
 *
 */
public interface View
{

    public String[] insert();

    public String[] update();

    public String getID();

    public int getOption();

    public void show(CharSequence msg);

}