package Model;

import Controleur.Connexion;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class MaladeDAO extends DAO<Malade> {

    public MaladeDAO(Connexion conn) {
        super(conn, 6);
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
    public boolean select(ArrayList<String> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereStmt(ArrayList<String> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
