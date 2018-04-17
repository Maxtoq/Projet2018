package Model;

import java.sql.Connection;

/**
 *
 * @author maxim
 */
public class MaladeDAO extends DAO<Malade> {

    public MaladeDAO(Connection conn) {
        super(conn);
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

}
