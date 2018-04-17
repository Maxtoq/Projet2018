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
        in_num = new JTextField(15);
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
        JLabel[] labels = new JLabel[8];
        
        // On crée un panel pour les input de la recherche
        JPanel input_pan = new JPanel(new GridLayout(0, 4, 10, 5));
        
        // On ajoute tous les composants
        labels[0] = new JLabel("N° :");
        input_pan.add(labels[0]);
        input_pan.add(in_num);
        labels[1] = new JLabel("Nom :");
        input_pan.add(labels[1]);
        input_pan.add(in_nom);
        labels[2] = new JLabel("Prénom :");
        input_pan.add(labels[2]);
        input_pan.add(in_prenom);
        labels[3] = new JLabel("Téléphone :");
        input_pan.add(labels[3]);
        input_pan.add(in_tel);
        labels[4] = new JLabel("Adresse :");
        input_pan.add(labels[4]);
        input_pan.add(in_adresse);
        if (type == 1) {
            labels[5] = new JLabel("Specialité :");
            input_pan.add(labels[5]);
            input_pan.add(in_spec);
        }
        if (type == 2) {
            labels[5] = new JLabel("Rotation :");
            input_pan.add(labels[5]);
            input_pan.add(in_rot);
            labels[6] = new JLabel("Salaire :");
            input_pan.add(labels[6]);
            input_pan.add(in_sal);
            labels[7] = new JLabel("Service :");
            input_pan.add(labels[7]);
            input_pan.add(in_serv);
        }
        if (type == 3) {
            labels[5] = new JLabel("Mutuelle :");
            input_pan.add(labels[5]);
            input_pan.add(in_mut);
        }
        input_pan.add(in_search);
        
        
        this.add(input_pan);
    }
}
