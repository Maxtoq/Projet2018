package Model;

import Controleur.Connexion;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public abstract class DAO<T> {
    
    protected final Connexion conn;
    protected final int nb_param;
    
    public DAO(Connexion _conn, int _nb_param) {
        conn = _conn;
        nb_param = _nb_param;
    }
    
    public abstract boolean create(T obj);
    
    public abstract boolean delete(T obj);
    
    public abstract boolean update(T obj);
    
    public abstract ArrayList<T> select(ArrayList<String> param);
    
    public abstract String getWhereStmt(ArrayList<String> param);
}
