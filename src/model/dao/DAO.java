package model.dao;

import java.sql.SQLException;
import model.Repository;

/**
 *
 */
public interface DAO
{

    public void create(Object object) throws SQLException;

    public Repository read() throws SQLException;

    public void update(Object object) throws SQLException;

    public void delete(Object object) throws SQLException;

    public Object findByThis(int IDinformado) throws SQLException;

}
