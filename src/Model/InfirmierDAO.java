package Model;

import Controleur.Connexion;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class InfirmierDAO extends DAO<Infirmier> {

    public InfirmierDAO(Connexion conn, String[] where_params) {
        super(conn, where_params, "infirmier");
    }
    
    @Override
    public boolean create(Infirmier obj) {
        try {
            conn.getStmt().executeUpdate("insert into " + table + " values ('" + obj.getNum() + "', '" + obj.getServ() + "', '" 
                                            + obj.getRot() + "', '" + obj.getSal() + "')");
            conn.getStmt().executeUpdate("insert into employe values ('" + obj.getNum() + "', '" + obj.getNom() + "', '" 
                                            + obj.getPrenom() + "', '" + obj.getAdresse() + "', '" + obj.getTel() + "')");
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        
        return true;
    }

    @Override
    public boolean delete(Infirmier obj) {
        try {
            conn.getStmt().executeUpdate("delete from " + table + " where numero = '" + obj.getNum() + "'");
            conn.getStmt().executeUpdate("delete from employe where numero = '" + obj.getNum() + "'");
        }
        catch (SQLException e) {
            System.out.println("SQL EXCEPTION");
        }
        
        return true;
    }

    @Override
    public boolean update(Infirmier obj) {
        try {
            conn.getStmt().executeUpdate("update " + table + " set code_service = '" + obj.getServ() + "', rotation = '" + obj.getRot() 
                                            + "', salaire = '" + obj.getSal() + "' where numero = '" + obj.getNum() + "'");
            conn.getStmt().executeUpdate("update employe set nom = '" + obj.getNom() + "', prenom = '" + obj.getPrenom() 
                                            + "', adresse = '" + obj.getAdresse() + "', tel = '" + obj.getTel() + "' where numero = '" 
                                            + obj.getNum() + "'");
        }
        catch (SQLException e) {
            System.out.println("SQL EXCEPTION");
        }
        
        return true;
    }

    @Override
    public Infirmier getNewTObject(String[] strings) {
        String adr = strings[7] + strings[8];
        return new Infirmier(Integer.parseInt(strings[0]), strings[5], strings[6], strings[9], adr, strings[1], strings[2], Float.parseFloat(strings[3]));
    }
    
    @Override
    public String getWhereStmt(ArrayList<String> param) {
        // On regarde s'il n'y a pas de paramètre pour la recherche, auquel cas on select tous les champs (pas de where)
        boolean empty_param = false;
        for (int i = 0; i < param.size(); i++) {
            if ((!param.get(i).equals("")) && (empty_param)) empty_param = true;
            else empty_param = false;
        }
        if (empty_param) return " inner join employe on infirmier.numero = employe.numero";
        
        // On crée la string à insérer dans le "WHERE" de la requête
        String where = " inner join employe on infirmier.numero = employe.numero where ";
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
