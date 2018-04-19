package Model;

import Controleur.Connexion;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class MaladeDAO extends DAO<Malade> {

    public MaladeDAO(Connexion conn, String[] where_params) {
        super(conn, where_params);
    }
    
    @Override
    public boolean create(Malade obj) {
        
        return true;
    }

    @Override
    public boolean delete(Malade obj) {
        
        return true;
    }

    @Override
    public boolean update(Malade obj) {
        
        return true;
    }

    @Override
    public ArrayList<Malade> select(ArrayList<String> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereStmt(ArrayList<String> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
