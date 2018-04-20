
package Controleur;

import Model.*;
import Vue.Fenetre;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class Main {
    
    private Fenetre fen;
    private Connexion connect;
    private ChambreDAO ch_dao;
    private DocteurDAO doc_dao;
    private EmployeDAO emp_dao;
    private HospDAO hosp_dao;
    private InfirmierDAO inf_dao;
    private MaladeDAO mal_dao;
    private ServiceDAO serv_dao;
    
    public Main() {
        // On crée la nouvelle fenêtre
        fen = new Fenetre(this);
        
        // On initialise la connexion avec la database
        initConnexion();
        
        // On crée les DAO, qui nous permettront d'échanger les infos entre notre Model et la DB
        /*ch_dao = new ChambreDAO(connect);
        doc_dao = new DocteurDAO(connect);
        emp_dao = new EmployeDAO(connect);
        hosp_dao = new HospDAO(connect);
        String[] inf_params = { "numero = ", "nom = ", "prenom = ", "adresse = ", "tel = ", "mutuelle = " };
        inf_dao = new InfirmierDAO(connect, inf_params);*/
        String[] mal_params = { "numero = ", "nom = ", "prenom = ", "adresse = ", "tel = ", "mutuelle = " };
        mal_dao = new MaladeDAO(connect, mal_params);
        String[] serv_params = { "code = ", "nom = ", "batiment = ", "directeur = " };
        serv_dao = new ServiceDAO(connect, serv_params);
        
        ArrayList<String> strs = new ArrayList<>();
        strs.add("");
        strs.add("");
        strs.add("A");
        strs.add("");
        serv_dao.select(strs);
        
        ArrayList<String> strmal = new ArrayList<>();
        strmal.add("");
        strmal.add("");
        strmal.add("");
        strmal.add("");
        strmal.add("");
        strmal.add("AG2R");
        mal_dao.select(strmal);
    }
    
    /**
     * Getter pour le ServiceDAO
     * 
     * @return l'objet serv_dao, permettant de faire des requêtes à la db
     */
    public ServiceDAO getServDAO() { return serv_dao; }
    
    public void initConnexion() {
        try {
            connect = new Connexion("hopital", "root", "");
            System.out.println("Connexion réussie");
        }
        catch (SQLException e) {
            System.out.println("SQLException");
        }
        catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        }
    }
    
    
    
    public static void main(String args[]) {
        Main controler = new Main();
        
        
    }
}
