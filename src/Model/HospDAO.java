package Model;

import Controleur.Connexion;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class HospDAO extends DAO<Hosp> {

    public HospDAO(Connexion conn) {
        super(conn, 4);
    }
    
    @Override
    public boolean create(Hosp obj) {
        
        return true;
    }

    @Override
    public boolean delete(Hosp obj) {
        
        return true;
    }

    @Override
    public boolean update(Hosp obj) {
        
        return true;
    }

    @Override
    public ArrayList<Hosp> select(ArrayList<String> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereStmt(ArrayList<String> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
