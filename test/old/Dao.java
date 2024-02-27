package old;

import java.sql.SQLException;

/**
 *
 */
public interface Dao
{

    public void create(Object object) throws SQLException;

    public Repositorio read() throws SQLException;

    public void update(Object object) throws SQLException;

    public void delete(Object object) throws SQLException;

    public Object findByThis(int IDinformado) throws SQLException;
}