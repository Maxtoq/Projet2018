package Model;

import Controleur.Connexion;
import java.sql.SQLException;

/**
 *
 * @author maxim
 */
public class MaladeDAO extends DAO<Malade> {

    public MaladeDAO(Connexion conn, String[] where_params) {
        super(conn, where_params, "malade");
    }
    
    @Override
    public boolean create(Malade obj) {
        try {
            conn.getStmt().executeUpdate("insert into " + table + " values ('" + obj.getNum() + "', '" + obj.getNom() + "', '" 
                                            + obj.getPrenom() + "', '" + obj.getAdresse() + "', '" + obj.getTel() + "', '" 
                                            + obj.getMut() + "')");
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        
        return true;
    }

    @Override
    public boolean delete(Malade obj) {
        try {
            conn.getStmt().executeUpdate("delete from " + table + " where numero = '" + obj.getNum() + "'");
        }
        catch (SQLException e) {
            System.out.println("SQL EXCEPTION");
        }
        
        return true;
    }

    @Override
    public boolean update(Malade obj) {
        try {
            conn.getStmt().executeUpdate("update " + table + " set nom = '" + obj.getNom() + "', prenom = '" + obj.getPrenom() 
                                            + "', adresse = '" + obj.getAdresse() + "', tel = '" + obj.getTel() + "', mutuelle = '" 
                                            + obj.getMut() + "' where numero = '" + obj.getNum() + "'");
        }
        catch (SQLException e) {
            System.out.println("SQL EXCEPTION");
        }
        
        return true;
    }

    @Override
    public Malade getNewTObject(String[] strings) {
        String adr = strings[3] + strings[4];
        return new Malade(Integer.parseInt(strings[0]), strings[1], strings[2], adr, strings[5], strings[6]);
    }

}
