package model;

/**
 *
 *
 */
public enum Sex
{

    m("m"),
    f("f");

    private final String description;

    private Sex(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return this.description;
    }
}