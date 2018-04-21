package Model;

import Controleur.Connexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maxim
 */
public class DocteurDAO extends DAO<Docteur> {

    public DocteurDAO(Connexion conn, String[] where_params) {
        super(conn, where_params, "docteur");
    }
    
    @Override
    public boolean create(Docteur obj) {
        try {
            conn.getStmt().executeUpdate("insert into " + table + " values ('" + obj.getNum() + "', '" + obj.getSpec() + "')");
            conn.getStmt().executeUpdate("insert into employe values ('" + obj.getNum() + "', '" + obj.getNom() + "', '" 
                                            + obj.getPrenom() + "', '" + obj.getAdresse() + "', '" + obj.getTel() + "')");
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        
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

    @Override
    public Docteur getNewTObject(String[] strings) {
        String adr = strings[5] + strings[6];
        return new Docteur(Integer.parseInt(strings[0]), strings[3], strings[4], strings[7], adr, strings[1]);
    }

    @Override
    public String getWhereStmt(ArrayList<String> param) {
        // On crée la string à insérer dans le "WHERE" de la requête
        String where = " inner join employe on docteur.numero = employe.numero where ";
        boolean par = false;
        
        // On remplit where en fonction des paramètres
        // Pour chaque paramètre possible
        for (int i = 0; i < param.size(); i++) {
            // S'il y a une valeur à rechercher
            if (!param.get(i).equals("")) {
                // S'il y a déjà eu un paramètre, on ajoute " and " à la requête
                if (par) where += " and ";
                // On ajoute "*nom du paramètre* = *valeur du paramètre*" à la requête 
                where += where_params[i];
                
                // On ajoute la valeur du paramètre
                where += "'" + param.get(i) + "'";
                
                // On dit qu'il y a déjà eu un paramètre
                par = true;
            }
        }
        
        return where;
    }
}
