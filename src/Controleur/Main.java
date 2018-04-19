
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
        ch_dao = new ChambreDAO(connect.getConn());
        doc_dao = new DocteurDAO(connect.getConn());
        emp_dao = new EmployeDAO(connect.getConn());
        hosp_dao = new HospDAO(connect.getConn());
        inf_dao = new InfirmierDAO(connect.getConn());
        mal_dao = new MaladeDAO(connect.getConn());
        serv_dao = new ServiceDAO(connect.getConn());
        
        ArrayList<String> strs = new ArrayList<String>();
        strs.add("REA");
        strs.add("");
        strs.add("A");
        strs.add("");
        serv_dao.select(strs);
    }
    
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
