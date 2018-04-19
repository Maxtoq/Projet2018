package Model;

import Controleur.Connexion;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class ServiceDAO extends DAO<Service> {

    public ServiceDAO(Connexion conn) {
        super(conn, 4);
    }
    
    @Override
    public boolean create(Service obj) {
        
        return true;
    }

    @Override
    public boolean delete(Service obj) {
        
        return true;
    }

    @Override
    public boolean update(Service obj) {
        
        return true;
    }

    @Override
    public ArrayList<Service> select(ArrayList<String> param) {
        // Si le nombre de paramètres donné pour la recherche est mauvais, la requête est rejetée (REMPLACER PAR EXCEPTION, ou enlever)
        if (param.size() != nb_param) return null;
        
        // On récupère l'arrayList des résultats de la requête
        try {
            ArrayList<String> str_result = conn.remplirChampsRequete("select * from service where " + getWhereStmt(param));
            for (int i = 0; i < str_result.size(); i++) {
                System.out.print(str_result.get(i));
            }
        }
        catch (SQLException e) {
            System.out.println("SLQ EXCEPTION");
        }
        
        // On crée le tableau d'objets à retourner
        ArrayList<Service> result = new ArrayList<>();
        
        //for (int i = 0;)
        
        return result;
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
                switch (i) {
                    case 0: where += "code = ";
                            break;
                    case 1: where += "nom = ";
                            break;
                    case 2: where += "batiment = ";
                            break;
                    case 3: where += "directeur = ";
                            break;
                }
                
                // On ajoute la valeur du paramètre
                where += "'" + param.get(i) + "'";
                
                // On dit qu'il y a déjà eu un paramètre
                par = true;
            }
        }
        
        return where;
    }
    
    
}
