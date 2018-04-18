package Vue;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tony
 */
public class HospPanel extends JPanel {
    
    private JTable tab;
    private JButton change = new JButton("Changer la taille");
    
    private JTextField in_lit;
    private JTextField in_codeService;
    private JTextField in_numMalade;
   
    // On initialise tous les objets
    
    public HospPanel()
    {
                JPanel input_pan = new JPanel(new GridLayout(0, 4, 10, 5));

                JLabel[] labels = new JLabel[3];
        
        // On ajoute tous les composants
        labels[0] = new JLabel("Numéro du malade :");
        input_pan.add(labels[0]);
        
        input_pan.add(in_lit);
        labels[1] = new JLabel("Numéro Lit :");
        input_pan.add(labels[1]);
        
        input_pan.add(in_codeService);
        labels[2] = new JLabel("Code Service :");
        input_pan.add(labels[2]);
        input_pan.add(in_numMalade);
       

        this.add(input_pan);

    }
    
     
    
}

