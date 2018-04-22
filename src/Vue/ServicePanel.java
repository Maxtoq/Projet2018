
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
    private AddPanel add_pan;
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
    // Variables pour la connexion SQL
    private ServiceDAO serv_dao2;
    private String[] data;
    
    private ArrayList select;
    private ZModel zModel;
     // On initialise tous les composants
      
    public ServicePanel(Main _controler){
        
        
      
        this.setLayout(new BorderLayout());
      
        this.controler2=_controler;
        this.serv_dao2 = this.controler2.getServDAO();
        System.out.println("La valeur de l'objet est"+serv_dao2);
        add_pan = new AddPanel("service",controler2 );
        this.add(add_pan,BorderLayout.SOUTH);
       

        String[] tri = {"Code","Nom","Batiment","Directeur"};
        JComboBox boxtri = new JComboBox(tri);
        boxtri.setSelectedIndex(3);

        Object[][] data2 = {  
            {"REA","Reanimation et Traumatologie","A","19","supp"}
             
    };
        // ESsaie de recuperer lobjets associe 
       // String data[] = {"REA","Reanimation et Traumatologie","A","19"};
        //this.serv_dao2.getNewTObject(data);
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
        
        
        ArrayList<Service> select = new ArrayList();
        
        
        ArrayList<String> strs = new ArrayList<>();
        strs.add("REA");
        strs.add("Reanimation et Traumatologie");
        strs.add("A");
        strs.add("19");
        //select = serv_dao2.select(strs);
        
        //////// };
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
        
        //this.add(ajouter, BorderLayout.EAST);
        //this.add(ajout, BorderLayout.EAST);
         //modèle d'affichage spécifique destiné à pallier
      //les bugs d'affichage !
        String title[] = {"Code","Nom","Batiment","Directeur", "Suppression"};
        ZModel zModel = new ZModel(data2, title);
        this.tab= new JTable(zModel);
        this.tab.setRowHeight(20);
        this.add(new JScrollPane(tab), BorderLayout.CENTER);
        //this.tab.getColumn("Code").setCellRenderer(new ButtonRenderer());
        //this.tab.getColumn("Nom").setCellRenderer(new ButtonRenderer());
        //this.tab.getColumn("Batiment").setCellRenderer(new ButtonRenderer());
        //this.tab.getColumn("Directeur").setCellRenderer(new ButtonRenderer());
        //On définit un éditeur pour la colonne "supprimer"
        this.tab.getColumn("Suppression").setCellEditor(new DeleteButtonEditor(new JCheckBox(),controler2, "service"));
        
        
        if(add_pan.getObj() != null ){
            System.out.println("cc");
            System.out.println(add_pan.getObj());
            ((ZModel)tab.getModel()).addRow(add_pan.getObj());
        }
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
    
    public void setValue(Object[] donnee){
        ((ZModel)tab.getModel()).addRow(donnee);
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
                    System.out.println("codeR "+codeR);
                    String nomR = new String();
                    nomR = servR.getNom();
                    System.out.println("nomR "+nomR);
                    char batR = servR.getBat();
                    System.out.println("batR "+batR);
                    String batR2 = new String();
                    batR2 = String.valueOf(batR);
                    int dirR = servR.getDir();
                    String diR2 = new String();
                    diR2 = String.valueOf(dirR);
                    System.out.println("dirR "+dirR);
                    Object[] data = new Object[5];
                    data[0] = codeR; 
                    data[1]= nomR;
                    data[2] = batR2;
                    data[3]= diR2;
                ((ZModel)tab.getModel()).addRow(data);
                 //Object[][] data2 ={codeR, nomR , batR,dirR,"supp"};   
                

                    
        
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

