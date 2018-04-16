/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author maxim
 */
public class EmployePanel extends JPanel {
    
    private JPanel search_pan;
    private JPanel add_pan;
    
    public EmployePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        search_pan = new JPanel();
        search_pan.setBorder(BorderFactory.createTitledBorder("Rechercher"));
        search_pan.setPreferredSize(new Dimension(850,500));
        
        add_pan = new JPanel();
        add_pan.setBorder(BorderFactory.createTitledBorder("Ajouter un employé"));
        
        this.add(search_pan);
        this.add(add_pan);
        
        this.setVisible(true);
    }
}
