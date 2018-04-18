package Model;

import java.sql.Connection;

/**
 *
 * @author maxim
 */
public class ServiceDAO extends DAO<Service> {

    public ServiceDAO(Connection conn) {
        super(conn);
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
}
