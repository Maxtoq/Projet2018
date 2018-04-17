/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import javax.swing.*;

/**
 *
 * @author maxim
 */
public class SearchPanel extends JPanel {
    
    private int type; // Type de searchPanel : 1 = docteur, 2 = infirmiers, 3 = malades
    
    private JTextField in_num;
    private JTextField in_nom;
    private JTextField in_prenom;
    private JTextField in_tel;
    private JTextField in_adresse;
    private JComboBox in_spec;
    private JComboBox in_rot;
    private JTextField in_sal;
    private JComboBox in_serv;
    private JComboBox in_mut;
    private JButton in_search;
    
    public SearchPanel(int _type) {
        type = _type;
        
        // On crée les tableaux de string pour initialiser les comboBox
        String[] specStrings = { "  --", "Anesthesiste", "Cardiologue", "Orthopediste", "Pneumologue", "Radiologue", "Traumatologue" };
        String[] rotStrings = { "  --", "JOUR", "NUIT" };
        String[] servStrings = { "  --", "CAR", "CHG", "REA" };
        String[] mutStrings = { "  --", "AG2R", "CCVRP", "CNAMTS", "LMDE", "MAAF", "MAS", "MGEN", "MGSP", "MMA", "MNAM", "MNFTC", "MNH" };
        
        // On initialise tous les composants
        in_num = new JTextField();
        in_nom = new JTextField();
        in_prenom = new JTextField();
        in_tel = new JTextField();
        in_adresse = new JTextField();
        in_spec = new JComboBox(specStrings);
        in_rot = new JComboBox(rotStrings);
        in_sal = new JTextField();
        in_serv = new JComboBox(servStrings);
        in_mut = new JComboBox(mutStrings);
        in_search = new JButton("Rechercher");
        
        // On sélectionne la position par défaut des comboBox
        in_spec.setSelectedIndex(0);
        in_rot.setSelectedIndex(0);
        in_serv.setSelectedIndex(0);
        in_mut.setSelectedIndex(0);
        
        initUI();
        
        this.setVisible(true);
    }
    
    public void initUI() {
        // On crée un tableau de JLabel pour l'affichage 
        /*JLabel
        // On set un SpringLayout
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        
        // On ajoute tous les composants
        this.add(in_num);
        this.add(in_nom);
        this.add(in_prenom);
        this.add(in_tel);
        this.add(in_adresse);
        if (type == 1) this.add(in_spec);
        if (type == 2) {
            this.add(in_rot);
            this.add(in_sal);
            this.add(in_serv);
        }
        if (type == 3) this.add(in_mut);
        this.add(in_search);
        
        // On place les composants dans le panel
        this.add(new JLabel("N° :"));*/
        
    }
}
