package Model;

import java.sql.Connection;

/**
 *
 * @author maxim
 */
public abstract class DAO<T> {
    
    protected Connection conn = null;
    
    public DAO(Connection _conn) {
        conn = _conn;
    }
    
    public abstract boolean create(T obj);
    
    public abstract boolean delete(T obj);
    
    public abstract boolean update(T obj);
}
