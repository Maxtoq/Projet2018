package Model;

import Controleur.Connexion;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class ServiceDAO extends DAO<Service> {

    public ServiceDAO(Connexion conn, String[] where_params) {
        super(conn, where_params);
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
        if (param.size() != where_params.length) return null;
        
        try {
            // On récupère l'arrayList des résultats de la requête
            ArrayList<String> str_result = conn.remplirChampsRequete("select * from service where " + getWhereStmt(param));
            
            // On crée le tableau d'objets à retourner
            ArrayList<Service> result = new ArrayList<>();
            
            // Pour chaque strings, on récupère la strings de chaque attribut
            for (int i = 0; i < str_result.size(); i++) {
                String[] strings = str_result.get(i).split(",");
                System.out.println(str_result.get(i));
                
                // On crée un nouvel objet avec ces attributs
                result.add(new Service(strings[0], strings[1], strings[2].charAt(0), Integer.parseInt(strings[3])));
            }
            
            return result;
        }
        catch (SQLException e) {
            System.out.println("SLQ EXCEPTION");
        }
        
        return null;
    }  
}
