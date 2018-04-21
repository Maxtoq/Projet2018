
package Model;

import Controleur.Connexion;
import java.sql.SQLException;

/**
 *
 * @author maxim
 */
public class ChambreDAO extends DAO<Chambre> {

    public ChambreDAO(Connexion conn, String[] where_params) {
        super(conn, where_params, "chambre");
    }
    
    @Override
    public boolean create(Chambre obj) {
        try {
            conn.getStmt().executeUpdate("insert into chambre values ('" + obj.getServ() + "REA', '100', '20', '5')");
        }
        catch (SQLException e) {
            System.out.println("SQL EXCEPTION");
        }
        
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

    @Override
    public Chambre getNewTObject(String[] strings) {
        return new Chambre(Integer.parseInt(strings[1]), strings[0], Integer.parseInt(strings[2]), Integer.parseInt(strings[3]));
    }
}
