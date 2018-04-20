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
        
        return true;
    }

    @Override
    public boolean delete(Infirmier obj) {
        
        return true;
    }

    @Override
    public boolean update(Infirmier obj) {
        
        return true;
    }

    @Override
    public Infirmier getNewTObject(String[] strings) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<Infirmier> select(ArrayList<String> param) {
        // Si le nombre de paramètres donné pour la recherche est mauvais, la requête est rejetée (REMPLACER PAR EXCEPTION, ou enlever)
        if (param.size() != where_params.length) return null;
        
        try {
            // On récupère l'arrayList des résultats de la requête
            ArrayList<String> str_result = conn.remplirChampsRequete("select * from " + table + " where " + getWhereStmt(param));
            
            // On crée le tableau d'objets à retourner
            ArrayList<Infirmier> result = new ArrayList<>();
            
            // Pour chaque strings, on récupère la strings de chaque attribut
            for (int i = 0; i < str_result.size(); i++) {
                String[] strings = str_result.get(i).split(",");
                System.out.println(str_result.get(i));
                
                // On crée un nouvel objet avec ces attributs
                result.add(getNewTObject(strings));
            }
            
            return result;
        }
        catch (SQLException e) {
            System.out.println("SQL EXCEPTION");
        }
        
        return null;
    }
    
    @Override
    public String getWhereStmt(ArrayList<String> param) {
        // On crée la string à insérer dans le "WHERE" de la requête
        String where = "";
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
