
package Vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import Controleur.*;
import Model.Service;
import Model.ServiceDAO;

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
    private JButton ajouter= new JButton("Ajouter Service");
    private JTextField ajout;
    private Main controler2;
    private ServiceDAO serv_dao2;
    private ZModel zModel;
     // On initialise tous les composants
      
    public ServicePanel(Main _controler){
        

       
        this.controler2=_controler;
        this.serv_dao2 = this.controler2.getServDAO();
        

        String[] tri = {"Code","Nom","Batiment","Directeur"};
        JComboBox boxtri = new JComboBox(tri);
        boxtri.setSelectedIndex(3);

        
        
        // On crée le tableau de string pour initialiser la comboBox
        ajouter = new JButton("Ajouter une ligne");
        in_nom = new JTextField(15);
        in_code = new JTextField();
        in_batiment = new JTextField();
        in_batiment.addActionListener(this);
        in_dir = new JTextField();
        in_search = new JButton("Rechercher");
        in_search.addActionListener(this);
        ajout = new JTextField();
        Object data[][] = {
            {"0101", "Toquebim", "1","Poncho","supp"},
            {"0102","Pec", "3","Nino","supp"},
            {"0103","Fronto","2", "Chico","supp"}, 
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
        
        
        this.add(input_pan, BorderLayout.NORTH);
        this.add(ajouter, BorderLayout.EAST);
        this.add(ajout, BorderLayout.EAST);
         //modèle d'affichage spécifique destiné à pallier
      //les bugs d'affichage !
        String title[] = {"Code","Nom","Batiment","Directeur", "Suppression"};
        ZModel zModel = new ZModel(data, title);
        this.tab= new JTable(zModel);
        this.tab.setRowHeight(20);
        this.add(new JScrollPane(tab), BorderLayout.CENTER);
        //this.tab.getColumn("Code").setCellRenderer(new ButtonRenderer());
        //this.tab.getColumn("Nom").setCellRenderer(new ButtonRenderer());
        //this.tab.getColumn("Batiment").setCellRenderer(new ButtonRenderer());
        //this.tab.getColumn("Directeur").setCellRenderer(new ButtonRenderer());
        //On définit un éditeur pour la colonne "supprimer"
        this.tab.getColumn("Suppression").setCellEditor(new DeleteButtonEditor(new JCheckBox()));
        
      /*   
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tab.getModel());
        tab.setRowSorter(sorter);
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);

     */
      ajouter.addActionListener(this);
      
      
      
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
          if (ae.getSource().equals(in_search)) {
                ArrayList<String> strs = new ArrayList<>();
                strs.add(in_code.getText());
                strs.add(in_nom.getText());
                strs.add(in_batiment.getText());
                strs.add(in_dir.getText());
              ArrayList<Service> strs2 = new ArrayList<>();
              
              strs2 = serv_dao2.select(strs);
             for(int i =0; i< strs2.size();i++)
             {
                 Service servR = strs2.get(i);
                         
                    String codeR = new String();
                    codeR = servR.getCode();
                    String nomR = new String();
                    nomR = servR.getNom();
                    char batR = servR.getBat();
                    int dirR = servR.getDir();
             zModel.setValueAt(codeR,i++,1);
             zModel.setValueAt(nomR,i++,2);
             zModel.setValueAt(batR,i++,3);
             zModel.setValueAt(dirR,i++,4);
                    
        
          }
          if (ae.getSource().equals(ajouter))
          {
               Object[] donnee = new Object[]
            {"0102", "Rennais", "4", ajout.getText(), "supp"};
               ((ZModel)tab.getModel()).addRow(donnee);
          }
              
          }
       
    
    }      
    
}

