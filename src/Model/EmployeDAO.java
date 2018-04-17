package Model;

import Model.Employe;
import java.sql.Connection;

/**
 *
 * @author maxim
 */
public class EmployeDAO extends DAO<Employe> {

    public EmployeDAO(Connection conn) {
        super(conn);
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

}
