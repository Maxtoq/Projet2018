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
import Model.MaladeDAO;
import Model.Service;
import Model.ServiceDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tony
 */
public class MaladePanel extends JPanel implements ActionListener {
    
    public AddPanel add_pan;
    private JTextField in_nom;
    private JTextField in_prenom;
    private JTextField in_mutuelle;
    private JTextField in_tel;
    private JTextField in_adresse;
    private JButton ajouter;
    private JTable tab;
    private JButton in_search;
    private JTextField ajout;
    private JComboBox combo = new JComboBox();
    private JTextField in_num;
    private MaladeDAO malade_dao2;
    private String[] data;
    private Object T;
    private ArrayList select;
    private ZModel zModel;
    private Main controler2;
    
    
    public MaladePanel(Main _controler){
        
        this.setLayout(new BorderLayout());
        this.controler2 = _controler;
        add_pan = new AddPanel("malade",controler2);
        this.add(add_pan,BorderLayout.SOUTH);
        this.malade_dao2 = this.controler2.getMalDAO();


       in_nom = new JTextField(15);
       in_prenom = new JTextField();
       in_mutuelle = new JTextField();
       in_adresse = new JTextField();
       in_tel = new JTextField();
       ajouter = new JButton("Ajouter un malade");
       in_search = new JButton("Rechercher");
       in_search.addActionListener(this);
       in_num = new JTextField(15);
       ajout = new JTextField();
    
      Object[][] data = {{"1","Querrey","Sam","43 rue Vauvenargues 78000 Versailles","01 52 53 23 82","MNAM","supp"}
      
          };
    
    
    JPanel input_pan = new JPanel(new GridLayout(0, 6, 10, 5));

         JLabel[] labels = new JLabel[6];
        
        // On ajoute tous les composants
        labels[0] = new JLabel("Numéro Malade :");
        input_pan.add(labels[0]);
       input_pan.add(in_num);
       
        labels[1] = new JLabel("Nom du Malade :");
        input_pan.add(labels[1]);
       input_pan.add(in_nom);
    
        labels[2] = new JLabel("Prenom du Malade :");
        input_pan.add(labels[2]);
       input_pan.add(in_prenom);
    
        labels[3] = new JLabel("Telephone :");
        input_pan.add(labels[3]);
       input_pan.add(in_tel);
       
        
       labels[4] = new JLabel("Adresse :");
       input_pan.add(labels[4]);
        input_pan.add(in_adresse);
       
        labels[5]= new JLabel ("Mutuelle :");
            combo.addItem("--");
            combo.addItem("AG2R");
            combo.addItem("CCVRP");
            combo.addItem("CNAMTS");
            combo.addItem("MAAF");
            combo.addItem("MAS");
            combo.addItem("MGEN");
            combo.addItem("MGSP");
            combo.addItem("MMA");
            combo.addItem("MNAM");
            combo.addItem("MNFTC");
            combo.addItem("MNH");
            input_pan.add(labels[5]);
            input_pan.add(combo);
            
       input_pan.add(in_search);
       

        this.add(input_pan,BorderLayout.NORTH);
    
    
       String title[] = {"Numero Malade","Nom Patient","Prenom Patient","Adresse","Telephone", "Mutuelle", "Suppression"};
        ZModel zModel2 = new ZModel(data, title);
        this.tab= new JTable(zModel2);
        this.tab.setRowHeight(20);
        this.add(new JScrollPane(tab), BorderLayout.CENTER);
        this.tab.getColumn("Suppression").setCellEditor(new DeleteButtonEditor(new JCheckBox(),controler2,"malade"));
        
           if(add_pan.getObj() != null ){
            System.out.println("cc");
            System.out.println(add_pan.getObj());
            ((ZModel)tab.getModel()).addRow(add_pan.getObj());
            
         
      
   

    }
    
    }
    
                 public void setValue(Object[] donnee){
        ((ZModel)tab.getModel()).addRow(donnee);
                 }
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
