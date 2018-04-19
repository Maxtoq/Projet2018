package Model;

import Controleur.Connexion;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public abstract class DAO<T> {
    
    protected final Connexion conn;
    protected final String[] where_params;
    
    public DAO(Connexion _conn, String[] _where_params) {
        conn = _conn;
        where_params = _where_params;
    }
    
    public abstract boolean create(T obj);
    
    public abstract boolean delete(T obj);
    
    public abstract boolean update(T obj);
    
    public abstract ArrayList<T> select(ArrayList<String> param);
    
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
                /*switch (i) {
                    case 0: where += "code = ";
                            break;
                    case 1: where += "nom = ";
                            break;
                    case 2: where += "batiment = ";
                            break;
                    case 3: where += "directeur = ";
                            break;
                }*/
                
                // On ajoute la valeur du paramètre
                where += "'" + param.get(i) + "'";
                
                // On dit qu'il y a déjà eu un paramètre
                par = true;
            }
        }
        
        return where;
    }
}
