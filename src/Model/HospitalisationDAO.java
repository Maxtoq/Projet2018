package Model;

import java.sql.Connection;

/**
 *
 * @author maxim
 */
public class HospitalisationDAO extends DAO<Hospitalisation> {

    public HospitalisationDAO(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Hospitalisation obj) {
        
        return true;
    }

    @Override
    public boolean delete(Hospitalisation obj) {
        
        return true;
    }

    @Override
    public boolean update(Hospitalisation obj) {
        
        return true;
    }

}
