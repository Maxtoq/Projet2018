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
        return new Hosp(Integer.parseInt(strings[0]), strings[1], Integer.parseInt(strings[2]), Integer.parseInt(strings[3]));
    }

}
