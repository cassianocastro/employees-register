package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 *
 */
public class Employee
{

    private int id;
    private String name;
    private String cpf;
    private Sex sex;
    private Calendar birthDate;

    public Employee(int id, String name, Sex sex, String cpf, Calendar birthDate)
    {
        this.id   = id;
        this.name = name;
        this.sex  = sex;
        this.cpf  = cpf;
        this.birthDate = birthDate;
    }

    public int getID()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public String getCPF()
    {
        return this.cpf;
    }

    public Sex getSex()
    {
        return this.sex;
    }

    public Calendar getBirthDate()
    {
        return this.birthDate;
    }

    public void setID(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCPF(String cpf)
    {
        this.cpf = cpf;
    }

    public void setSex(Sex sex)
    {
        this.sex = sex;
    }

    public void setBirthDate(Calendar birthDate)
    {
        this.birthDate = birthDate;
    }
}