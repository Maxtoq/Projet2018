
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
            conn.getStmt().executeUpdate("insert into " + table + " values ('" + obj.getServ() + "', '" + obj.getNum() + "', '" 
                                            + obj.getSurveillant() + "', '" + obj.getNbLits() + "')");
        }
        catch (SQLException e) {
            System.out.println("SQL EXCEPTION");
        }
        
        return true;
    }

    @Override
    public boolean delete(Chambre obj) {
        try {
            conn.getStmt().executeUpdate("delete from " + table + " where no_chambre = '" + obj.getNum() + "' and code_service = '" + obj.getServ() + "'");
        }
        catch (SQLException e) {
            System.out.println("SQL EXCEPTION");
        }
        
        return true;
    }

    @Override
    public boolean update(Chambre obj) {
        try {
            conn.getStmt().executeUpdate("update " + table + " set surveillant = '" + obj.getSurveillant() + "', nb_lits = '" + obj.getNbLits() + "' where code_service = '" 
                                            + obj.getServ() + "' and no_chambre = '" + obj.getNum() + "'");
        }
        catch (SQLException e) {
            System.out.println("SQL EXCEPTION");
        }
        
        return true;
    }

    @Override
    public Chambre getNewTObject(String[] strings) {
        return new Chambre(Integer.parseInt(strings[1]), strings[0], Integer.parseInt(strings[2]), Integer.parseInt(strings[3]));
    }
}
