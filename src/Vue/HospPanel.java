package Vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/*

 */

/**
 *
 * @author Tony
 */
public class HospPanel extends JPanel implements ActionListener {
    
    public AddPanel add_pan;
        private JTextField in_nom;

    private JTextField in_lit;
    private JTextField in_codeService;
    private JTextField in_numMalade;
    private JTable tab;
    private JButton ajouter;
    private JButton in_search;
        private JTextField ajout;


   
    // On initialise tous les objets
    
    public HospPanel()
    {
                add_pan = new AddPanel();
                in_lit = new JTextField(15);
                in_codeService = new JTextField();
               in_numMalade = new JTextField();
               ajouter = new JButton("Ajouter un malade");
              in_search = new JButton("Rechercher");
              in_search.addActionListener(this);
              in_nom = new JTextField(15);
                      ajout = new JTextField();

              
               Object data[][] = {
            {"0101", "Maxime", "URG","302","supp"},
            {"0102","Clement", "CAR","202","supp"},
            {"0103","Tony","RAD", "102","supp"},};


                JPanel input_pan = new JPanel(new GridLayout(0, 4, 10, 5));

                JLabel[] labels = new JLabel[4];
        
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
       
       labels[3] = new JLabel("Nom du patient :");
       input_pan.add(labels[3]);
        input_pan.add(in_nom);
       
       input_pan.add(in_search);
       

        this.add(input_pan);
        
               //modèle d'affichage spécifique destiné à pallier
      //les bugs d'affichage !
        String title[] = {"Numero Malade","Nom Patient","Code Service","Numero Lit","Suppression"};
        ZModel zModel = new ZModel(data, title);
        this.tab= new JTable(zModel);
        this.tab.setRowHeight(20);
        this.add(new JScrollPane(tab), BorderLayout.CENTER);
        this.tab.getColumn("Suppression").setCellEditor(new DeleteButtonEditor(new JCheckBox()));
            ajouter.addActionListener(this);
      
      this.add(ajouter, BorderLayout.EAST);
      this.add(ajout, BorderLayout.EAST);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     
    
}