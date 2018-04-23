package Model;

import Controleur.Connexion;
import java.sql.SQLException;

/**
 *
 * @author maxim
 */
public class HospDAO extends DAO<Hosp> {

    public HospDAO(Connexion conn, String[] where_params) {
        super(conn, where_params, "hospitalisation");
    }
    
    @Override
    public boolean create(Hosp obj) {
        try {
            conn.getStmt().executeUpdate("insert into " + table + " values ('" + obj.getNMalade() + "', '" + obj.getServ() + "', '" 
                                            + obj.getNChambre() + "', '" + obj.getLit() + "')");
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        
        return true;
    }

    @Override
    public boolean delete(Hosp obj) {
        try {
            conn.getStmt().executeUpdate("delete from " + table + " where no_malade = '" + obj.getNMalade()+ "'");
        }
        catch (SQLException e) {
            System.out.println("SQL EXCEPTION");
        }
        
        return true;
    }

    @Override
    public boolean update(Hosp obj) {
        try {
            conn.getStmt().executeUpdate("update " + table + " set code_service = '" + obj.getServ() + "', no_chambre = '" + obj.getNChambre() 
                                            + "', lit = " + obj.getLit() + "' where no_malade = '" + obj.getNMalade()+ "'");
        }
        catch (SQLException e) {
            System.out.println("SQL EXCEPTION");
        }
        
        return true;
    }

    @Override
    public Hosp getNewTObject(String[] strings) {
        return new Hosp(Integer.parseInt(strings[0]), strings[1], Integer.parseInt(strings[2]), Integer.parseInt(strings[3]));
    }

}
