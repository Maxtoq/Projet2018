
package Controleur;

import Vue.Fenetre;
import java.sql.SQLException;

/**
 *
 * @author maxim
 */
public class Main {
    
    private Fenetre fen;
    private Connexion conn;
    
    public Main() {
        fen = new Fenetre(this);
        
        initConnexion();
    }
    
    public void initConnexion() {
        try {
            conn = new Connexion("hopital", "root", "");
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
