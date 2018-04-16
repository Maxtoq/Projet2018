/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.metal.MetalToolBarUI;
import javax.swing.plaf.synth.SynthToolBarUI;

/**
 *
 * @author maxim
 */
public class Fenetre extends JFrame {
    
    private JToolBar menu;
    private JButton b_employes;
    private JButton b_malades;
    private JButton b_services;
    private JButton b_hosp;
    
    public Fenetre() {
        super("Gestion centre hospitalier");
        this.setSize(1000, 700);
        
        menu = new JToolBar(JToolBar.VERTICAL);
        
        b_employes = new JButton("Employés");
        initButton(b_employes);
        b_malades = new JButton("Malades");
        initButton(b_malades);
        b_services = new JButton("Services");
        initButton(b_services);
        b_hosp = new JButton("Hospitalisations");
        initButton(b_hosp);
        
        menu.add(b_employes);
        menu.add(b_malades);
        menu.add(b_services);
        menu.add(b_hosp);
        
        menu.setFloatable(false);
        menu.setBackground(Color.lightGray);
        
        this.add(menu, BorderLayout.WEST);
        
        this.setVisible(true);
    }
    
    private void initButton(JButton b) {
        b.setBackground(Color.lightGray);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
    }
}
