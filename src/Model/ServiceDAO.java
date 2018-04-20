package Model;

import Controleur.Connexion;
/**
 *
 * @author maxim
 */
public class ServiceDAO extends DAO<Service> {

    public ServiceDAO(Connexion conn, String[] where_params) {
        super(conn, where_params, "service");
    }
    
    @Override
    public boolean create(Service obj) {
        
        return true;
    }

    @Override
    public boolean delete(Service obj) {
        
        return true;
    }

    @Override
    public boolean update(Service obj) {
        
        return true;
    }

    @Override
    public Service getNewTObject(String[] strings) {
        return new Service(strings[0], strings[1], strings[2].charAt(0), Integer.parseInt(strings[3]));
    }
}
