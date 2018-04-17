package Model;

import java.sql.Connection;

/**
 *
 * @author maxim
 */
public class InfirmierDAO extends DAO<Infirmier> {

    public InfirmierDAO(Connection conn) {
        super(conn);
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

}
