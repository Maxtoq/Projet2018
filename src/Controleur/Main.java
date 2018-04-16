/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Vue.Fenetre;
import java.awt.event.*;

/**
 *
 * @author maxim
 */
public class Main implements WindowListener {
    
    private static Fenetre fen = new Fenetre();
    
    public Main() {
        fen.addWindowListener(this);
    }
    
    public static void main(String args[]) {
        new Main();
    }

    @Override
    public void windowOpened(WindowEvent we) {}
    @Override
    public void windowClosing(WindowEvent we) { System.exit(0); }
    @Override
    public void windowClosed(WindowEvent we) {}
    @Override
    public void windowIconified(WindowEvent we) {}
    @Override
    public void windowDeiconified(WindowEvent we) {}
    @Override
    public void windowActivated(WindowEvent we) {}
    @Override
    public void windowDeactivated(WindowEvent we) {}
}
