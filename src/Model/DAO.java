package Model;

import Controleur.Connexion;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 * @param <T>
 */
public abstract class DAO<T> {
    
    protected final Connexion conn;
    protected final String[] where_params;
    protected final String table;
    
    public DAO(Connexion _conn, String[] _where_params, String _table) {
        conn = _conn;
        where_params = _where_params;
        table = _table;
    }
    
    /**
     * Envoie une requete pour ajouter un champs dans une table
     * 
     * @param obj Objet à créer dans la db
     * @return 
     */
    public abstract boolean create(T obj);
    
    /**
     * Envoie une requete pour supprimer un champs dans une table
     * 
     * @param obj Objet à supprimer dans la db
     * @return 
     */
    public abstract boolean delete(T obj);
    
    /**
     * Envoie une requete pour modifier un champs dans une table
     * 
     * @param obj Objet à modifier dans la db
     * @return 
     */
    public abstract boolean update(T obj);
    
    /**
     * Renvoie un nouvel objet créé grâce aux strings en paramètre
     * 
     * @param strings attributs du nouvel objet
     * @return nouvel objet
     */
    public abstract T getNewTObject(String[] strings);
    
    /**
     * Envoie une requete pour rechercher des champs dans une table
     * 
     * @param param paramètres de la recherche
     * @return arraylist de tous les objets correspondant à la requête
     */
    public ArrayList<T> select(ArrayList<String> param) {        
        // Si le nombre de paramètres donné pour la recherche est mauvais, la requête est rejetée (REMPLACER PAR EXCEPTION, ou enlever)
        if (param.size() != where_params.length) return null;
        
        try {
            // On récupère l'arrayList des résultats de la requête
            ArrayList<String> str_result = conn.remplirChampsRequete("select * from " + table + getWhereStmt(param));
            
            // On crée le tableau d'objets à retourner
            ArrayList<T> result = new ArrayList<>();
            
            // Pour chaque strings, on récupère la strings de chaque attribut
            for (int i = 0; i < str_result.size(); i++) {
                String[] strings = str_result.get(i).split(",");
                
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
    
    /**
     * Renvoie la partie "where ..." d'une requete select, en fonction des paramètres de la recherche
     * 
     * @param param paramètre de la recherche
     * @return partie "where" de la requête
     */
    public String getWhereStmt(ArrayList<String> param) {
        // On regarde s'il n'y a pas de paramètre pour la recherche, auquel cas on select tous les champs (pas de where)
        boolean empty_param = true;
        for (int i = 0; i < param.size(); i++) {
            if ((!param.get(i).equals("")) && (empty_param)) empty_param = true;
            else empty_param = false;
        }
        if (empty_param) return "";
        
        // On crée la string à insérer dans le "WHERE" de la requête
        String where = " where ";
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
