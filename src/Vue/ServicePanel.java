
package Vue;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author cleme
 */
public class ServicePanel extends JPanel{
    //
    private JTable tab;
    private JButton change = new JButton("Changer la taille");
    private JTextField in_code;
    private JTextField in_batiment;
    private JTextField in_dir;
    private JTextField in_nom;
    private JButton in_search;
    private JComboBox in_filt;
    
     // On initialise tous les composants
      
    public ServicePanel(){
        

       
        

        String[] tri = {"Code","Nom","Batiment","Directeur"};
        JComboBox boxtri = new JComboBox(tri);
        boxtri.setSelectedIndex(3);

        
        
        // On crée le tableau de string pour initialiser la comboBox
        String[] filt = {  "Nom Directeur", "N°Batiment", "Nom Service" };
        in_nom = new JTextField(15);
        in_code = new JTextField();
        in_batiment = new JTextField();
        in_dir = new JTextField();
        in_search = new JButton("Rechercher");
        in_filt = new JComboBox(filt);
        in_filt.setSelectedIndex(0);

        Object data[][] = {

        };
        // On crée un tableau de JLabel pour l'affichage 
        JLabel[] labels = new JLabel[5];
        
        // On crée un panel pour les input de la recherche
        JPanel input_pan = new JPanel(new GridLayout(0, 4, 10, 5));
        
        // On ajoute tous les composants
        labels[0] = new JLabel("N°batiment :");
        input_pan.add(labels[0]);
        input_pan.add(in_batiment);
        labels[1] = new JLabel("Nom Directeur :");
        input_pan.add(labels[1]);
        input_pan.add(in_dir);
        labels[2] = new JLabel("Code Batiment :");
        input_pan.add(labels[2]);
        input_pan.add(in_code);
        labels[3] = new JLabel("Nom de Batiment :");
        input_pan.add(labels[3]);
        input_pan.add(in_nom);
        labels[4] = new JLabel("Filtrer par :");
        input_pan.add(labels[4]);
        input_pan.add(in_filt);
        
        this.add(input_pan);

        String title[] = {"Code","Nom","Batiment","Directeur"};
        
        this.tab= new JTable(data,title);
        this.tab.setRowHeight(30);
        this.add(new JScrollPane(tab), BorderLayout.CENTER);
        this.tab.getColumn("Code").setCellRenderer(new ButtonRenderer());
        this.tab.getColumn("Nom").setCellRenderer(new ButtonRenderer());
        this.tab.getColumn("Batiment").setCellRenderer(new ButtonRenderer());
        this.tab.getColumn("Directeur").setCellRenderer(new ButtonRenderer());
        
    }

} 
