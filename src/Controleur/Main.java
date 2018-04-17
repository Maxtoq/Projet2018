
package Controleur;

import Vue.Fenetre;

/**
 *
 * @author maxim
 */
public class Main {
    
    private static Fenetre fen;
    
    public Main() {
         fen = new Fenetre(this);
    }
    
    public static void main(String args[]) {
        Main controler = new Main();
    }
}
