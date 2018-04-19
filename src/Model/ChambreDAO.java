
package Model;

import Controleur.Connexion;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class ChambreDAO extends DAO<Chambre> {

    public ChambreDAO(Connexion conn) {
        super(conn, 4);
    }
    
    @Override
    public boolean create(Chambre obj) {
        
        return true;
    }

    @Override
    public boolean delete(Chambre obj) {
        
        return true;
    }

    @Override
    public boolean update(Chambre obj) {
        
        return true;
    }

    @Override
    public ArrayList<Chambre> select(ArrayList<String> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereStmt(ArrayList<String> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
