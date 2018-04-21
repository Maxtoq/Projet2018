package Model;

import Controleur.Connexion;
import java.sql.SQLException;

/**
 *
 * @author maxim
 */
public class EmployeDAO extends DAO<Employe> {

    public EmployeDAO(Connexion conn, String[] where_params) {
        super(conn, where_params, "employe");
    }
    
    @Override
    public boolean create(Employe obj) {
        try {
            conn.getStmt().executeUpdate("insert into " + table + " values ('" + obj.getNum() + "', '" + obj.getNom() + "', '" 
                                            + obj.getPrenom() + "', '" + obj.getAdresse() + "', '" + obj.getTel() + "')");
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        
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

    @Override
    public Employe getNewTObject(String[] strings) {
        String adr = strings[3] + strings[4];
        return new Employe(Integer.parseInt(strings[0]), strings[1], strings[2], strings[5], adr);
    }

}
