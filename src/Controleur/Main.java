package Controleur;

import Model.*;
import Vue.Fenetre;
import java.sql.SQLException;

/**
 *
 * @author maxim
 */
public class Main {
    
    private final Fenetre fen;
    private Connexion connect;
    private final ChambreDAO ch_dao;
    private final DocteurDAO doc_dao;
    private final EmployeDAO emp_dao;
    private final HospDAO hosp_dao;
    private final InfirmierDAO inf_dao;
    private final MaladeDAO mal_dao;
    private final ServiceDAO serv_dao;
    
    public Main() { 
        // On initialise la connexion avec la database
        initConnexion();
        
        // On crée les DAO, qui nous permettront d'échanger les infos entre notre Model et la DB
        String[] ch_params = { "code_service = ", "no_chambre = ", "surveillant = ", "nb_lits = " };
        ch_dao = new ChambreDAO(connect, ch_params);
        String[] doc_params = { "employe.numero = ", "employe.nom = ", "employe.prenom = ", "employe.adresse = ",
                                "employe.tel = ", "docteur.specialite = " };
        doc_dao = new DocteurDAO(connect, doc_params);
        String[] emp_params = { "numero = ", "nom = ", "prenom = ", "adresse = ", "tel = " };
        emp_dao = new EmployeDAO(connect, emp_params);
        String[] hosp_params = { "no_malade = ", "code_service = ", "no_chambre = ", "lit = " };
        hosp_dao = new HospDAO(connect, hosp_params);
        String[] inf_params = { "employe.numero = ", "employe.nom = ", "employe.prenom = ", 
                                "employe.adresse = ", "employe.tel = ", "infirmier.code_service = ", 
                                "infirmier.rotation = ", "infirmier.salaire = " };
        inf_dao = new InfirmierDAO(connect, inf_params);
        String[] mal_params = { "numero = ", "nom = ", "prenom = ", "adresse = ", "tel = ", "mutuelle = " };
        mal_dao = new MaladeDAO(connect, mal_params);
        String[] serv_params = { "code = ", "nom = ", "batiment = ", "directeur = " };
        serv_dao = new ServiceDAO(connect, serv_params);
        
        // On crée la nouvelle fenêtre
        fen = new Fenetre(this);
        
    }
    
    /**
     * Getter pour le ServiceDAO
     * 
     * @return l'objet serv_dao, permettant de faire des requêtes à la db
     */
    public ServiceDAO getServDAO() { return serv_dao; }
    /**
     * Getter pour le ChambreDAO
     * 
     * @return l'objet ch_dao, permettant de faire des requêtes à la db
     */
    public ChambreDAO getChDAO() { return ch_dao; }
    /**
     * Getter pour le DocteurDAO
     * 
     * @return l'objet doc_dao, permettant de faire des requêtes à la db
     */
    public DocteurDAO getDocDAO() { return doc_dao; }
    /**
     * Getter pour le EmployeDAO
     * 
     * @return l'objet emp_dao, permettant de faire des requêtes à la db
     */
    public EmployeDAO getEmpDAO() { return emp_dao; }
    /**
     * Getter pour le HospDAO
     * 
     * @return l'objet hosp_dao, permettant de faire des requêtes à la db
     */
    public HospDAO getHospDAO() { return hosp_dao; }
    /**
     * Getter pour le InfirmierDAO
     * 
     * @return l'objet inf_dao, permettant de faire des requêtes à la db
     */
    public InfirmierDAO getInfDAO() { return inf_dao; }
    /**
     * Getter pour le MaladeDAO
     * 
     * @return l'objet mal_dao, permettant de faire des requêtes à la db
     */
    public MaladeDAO getMalDAO() { return mal_dao; }
    
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
