/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Fenêtre principale de l'interface graphique, affichant le menu et les panel correspondant à chaque item
 * 
 * @author maxim
 */
public class Fenetre extends JFrame implements ActionListener, WindowListener {
    
    private Main controler;
    
    private JToolBar menu;
    private JButton b_employes;
    private JButton b_malades;
    private JButton b_services;
    private JButton b_hosp;
    private EmployePanel employe_pan;
    
    public Fenetre(Main _controler) {
        super("Gestion centre hospitalier");
        this.setSize(1000, 700);
        
        controler = _controler;
        
        menu = new JToolBar(JToolBar.VERTICAL);
        
        b_employes = new JButton("-   Employés");
        initButton(b_employes);
        b_malades = new JButton("-   Malades");
        initButton(b_malades);
        b_services = new JButton("-   Services");
        initButton(b_services);
        b_hosp = new JButton("-   Hospitalisations");
        initButton(b_hosp);
        
        b_employes.addActionListener(this);
        
        menu.add(b_employes);
        menu.add(b_malades);
        menu.add(b_services);
        menu.add(b_hosp);
        
        menu.setFloatable(false);
        menu.setBackground(Color.lightGray);
        
        this.add(menu, BorderLayout.WEST);
        
        this.addWindowListener(this);
        this.setVisible(true);
    }
    
    private void initButton(JButton b) {
        b.setBackground(Color.lightGray);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setPreferredSize(new Dimension(150,100));
        b.setMargin(new Insets(10,18,10,20));
    }
    
    private void initEmployePan() {
        employe_pan = new EmployePanel();
        
        this.add(employe_pan, BorderLayout.CENTER);
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b_employes)) {
            System.out.println("Employes");
            initEmployePan();
        }
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
