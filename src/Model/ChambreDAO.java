
package Model;

import Model.Chambre;
import java.sql.Connection;

/**
 *
 * @author maxim
 */
public class ChambreDAO extends DAO<Chambre> {

    public ChambreDAO(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Chambre obj) {
        
        return true;
    }

    @Override
    public boolean delete(Chambre obj) {
        
        return true;
    }

    @Override
    public boolean update(Chambre obj) {
        
        return true;
    }
    
}
