package Model;

import Controleur.Connexion;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class InfirmierDAO extends DAO<Infirmier> {

    public InfirmierDAO(Connexion conn, String[] where_params) {
        super(conn, where_params);
    }
    
    @Override
    public boolean create(Infirmier obj) {
        
        return true;
    }

    @Override
    public boolean delete(Infirmier obj) {
        
        return true;
    }

    @Override
    public boolean update(Infirmier obj) {
        
        return true;
    }

    @Override
    public ArrayList<Infirmier> select(ArrayList<String> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereStmt(ArrayList<String> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
