package Model;

import java.sql.Connection;

/**
 *
 * @author maxim
 */
public class DocteurDAO extends DAO<Docteur> {

    public DocteurDAO(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Docteur obj) {
        
        return true;
    }

    @Override
    public boolean delete(Docteur obj) {
        
        return true;
    }

    @Override
    public boolean update(Docteur obj) {
        
        return true;
    }

}
