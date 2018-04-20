package Model;

import Controleur.Connexion;

/**
 *
 * @author maxim
 */
public class InfirmierDAO extends DAO<Infirmier> {

    public InfirmierDAO(Connexion conn, String[] where_params) {
        super(conn, where_params, "infirmier");
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
    public Infirmier getNewTObject(String[] strings) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
