package Model;

import java.sql.Connection;

/**
 *
 * @author maxim
 */
public class HospDAO extends DAO<Hosp> {

    public HospDAO(Connection conn) {
        super(conn);
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

}
