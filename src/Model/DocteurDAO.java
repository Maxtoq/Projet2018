package Model;

import Controleur.Connexion;

/**
 *
 * @author maxim
 */
public class DocteurDAO extends DAO<Docteur> {

    public DocteurDAO(Connexion conn, String[] where_params) {
        super(conn, where_params, "docteur");
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
    public Docteur getNewTObject(String[] strings) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
