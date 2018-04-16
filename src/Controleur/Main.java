/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
