package Model;

import Controleur.Connexion;

/**
 *
 * @author maxim
 */
public class EmployeDAO extends DAO<Employe> {

    public EmployeDAO(Connexion conn, String[] where_params) {
        super(conn, where_params, "employe");
    }
    
    @Override
    public boolean create(Employe obj) {
        
        return true;
    }

    @Override
    public boolean delete(Employe obj) {
        
        return true;
    }

    @Override
    public boolean update(Employe obj) {
        
        return true;
    }

    @Override
    public Employe getNewTObject(String[] strings) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
