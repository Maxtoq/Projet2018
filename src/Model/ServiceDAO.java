package Model;

import Controleur.Connexion;
import java.sql.SQLException;
/**
 *
 * @author maxim
 */
public class ServiceDAO extends DAO<Service> {

    public ServiceDAO(Connexion conn, String[] where_params) {
        super(conn, where_params, "service");
    }
    
    @Override
    public boolean create(Service obj) {
        try {
            conn.getStmt().executeUpdate("insert into "+ table + " values ('" + obj.getCode() + "', '" + obj.getNom() + "', '" 
                                            + obj.getBat() + "', '" + obj.getDir() + "')");
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        
        return true;
    }

    @Override
    public boolean delete(Service obj) {
        try {
            conn.getStmt().executeUpdate("delete from " + table + " where code = '" + obj.getCode() + "'");
        }
        catch (SQLException e) {
            System.out.println("SQL EXCEPTION");
        }
        
        return true;
    }

    @Override
    public boolean update(Service obj) {
        try {
            conn.getStmt().executeUpdate("update " + table + " set nom = '" + obj.getNom() + "', batiment = '" + obj.getBat() 
                                            + "', directeur = '" + obj.getDir() + "' where code = '" + obj.getCode() + "'");
        }
        catch (SQLException e) {
            System.out.println("SQL EXCEPTION");
        }
        
        return true;
    }

    @Override
    public Service getNewTObject(String[] strings) {
        return new Service(strings[0], strings[1], strings[2].charAt(0), Integer.parseInt(strings[3]));
    }
}
