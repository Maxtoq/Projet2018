package Model;

import Controleur.Connexion;

/**
 *
 * @author maxim
 */
public class HospDAO extends DAO<Hosp> {

    public HospDAO(Connexion conn, String[] where_params) {
        super(conn, where_params, "hospitalisation");
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
    public Hosp getNewTObject(String[] strings) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
