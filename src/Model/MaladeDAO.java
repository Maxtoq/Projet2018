package Model;

import Controleur.Connexion;

/**
 *
 * @author maxim
 */
public class MaladeDAO extends DAO<Malade> {

    public MaladeDAO(Connexion conn, String[] where_params) {
        super(conn, where_params, "malade");
    }
    
    @Override
    public boolean create(Malade obj) {
        
        return true;
    }

    @Override
    public boolean delete(Malade obj) {
        
        return true;
    }

    @Override
    public boolean update(Malade obj) {
        
        return true;
    }

    @Override
    public Malade getNewTObject(String[] strings) {
        return new Malade(Integer.parseInt(strings[0]), strings[1], strings[2], strings[3], strings[4], strings[5]);
    }

}
