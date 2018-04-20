
package Model;

import Controleur.Connexion;

/**
 *
 * @author maxim
 */
public class ChambreDAO extends DAO<Chambre> {

    public ChambreDAO(Connexion conn, String[] where_params) {
        super(conn, where_params, "chambre");
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
    public Chambre getNewTObject(String[] strings) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
