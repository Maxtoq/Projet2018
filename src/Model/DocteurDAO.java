package Model;

import Controleur.Connexion;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class DocteurDAO extends DAO<Docteur> {

    public DocteurDAO(Connexion conn, String[] where_params) {
        super(conn, where_params);
    }
    
    @Override
    public boolean create(Docteur obj) {
        
        return true;
    }

    @Override
    public boolean delete(Docteur obj) {
        
        return true;
    }

    @Override
    public boolean update(Docteur obj) {
        
        return true;
    }

    @Override
    public ArrayList<Docteur> select(ArrayList<String> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereStmt(ArrayList<String> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
