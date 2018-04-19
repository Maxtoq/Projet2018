
package Vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author cleme
 */
public class ServicePanel extends JPanel implements ActionListener{
    //
    private JTable tab;
    private JButton change = new JButton("Changer la taille");
    private JTextField in_code;
    private JTextField in_batiment;
    private JTextField in_dir;
    private JTextField in_nom;
    private JButton in_search;
   
    
     // On initialise tous les composants
      
    public ServicePanel(){
        

       
        

        String[] tri = {"Code","Nom","Batiment","Directeur"};
        JComboBox boxtri = new JComboBox(tri);
        boxtri.setSelectedIndex(3);

        
        
        // On crée le tableau de string pour initialiser la comboBox
      
        in_nom = new JTextField(15);
        in_code = new JTextField();
        in_batiment = new JTextField();
        in_batiment.addActionListener(this);
        in_dir = new JTextField();
        in_search = new JButton("Rechercher");
        in_search.addActionListener(this);
       
        Object data[][] = {
            {"0101", "Toquebim", "1","Poncho"},
            {"0102","Pec", "3","Nino"},
            {"0103","Fronto","2", "Chico"}, 
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
        input_pan.add(in_search);
        
        
        this.add(input_pan);

        String title[] = {"Code","Nom","Batiment","Directeur"};
        
        this.tab= new JTable(data,title);
        this.tab.setRowHeight(30);
        this.add(new JScrollPane(tab), BorderLayout.CENTER);
        this.tab.getColumn("Code").setCellRenderer(new ButtonRenderer());
        this.tab.getColumn("Nom").setCellRenderer(new ButtonRenderer());
        this.tab.getColumn("Batiment").setCellRenderer(new ButtonRenderer());
        this.tab.getColumn("Directeur").setCellRenderer(new ButtonRenderer());
        
        
         
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tab.getModel());
        tab.setRowSorter(sorter);
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);

    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
          if (ae.getSource().equals(in_search)) {
              if (in_batiment.getAccessibleContext().toString()== "Pecresse")
                    JOptionPane.showMessageDialog(null,"alert");
              
              
          }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

