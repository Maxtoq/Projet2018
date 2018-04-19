package Model;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public abstract class DAO<T> {
    
    protected final Connection conn;
    protected final int nb_param;
    
    public DAO(Connection _conn, int _nb_param) {
        conn = _conn;
        nb_param = _nb_param;
    }
    
    public abstract boolean create(T obj);
    
    public abstract boolean delete(T obj);
    
    public abstract boolean update(T obj);
    
    public abstract boolean select(ArrayList<String> param);
    
    public abstract String getWhereStmt(ArrayList<String> param);
}
