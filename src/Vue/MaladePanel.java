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
    
    
    private MaladeDAO malade_dao2;
    private String[] data;
    private Object T;
    private ArrayList select;
    private ZModel zModel;
    private Main controler2;
    
    
    public MaladePanel(Main _controler){
        
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
       in_nom = new JTextField(15);
       ajout = new JTextField();
    
      Object data[][] = {
            {"0101", "Maxime", "URG","302","supp"},
            {"0102","Clement", "CAR","202","supp"},
            {"0103","Tony","RAD", "102","supp"},};
    
    
    JPanel input_pan = new JPanel(new GridLayout(0, 4, 10, 5));

                JLabel[] labels = new JLabel[5];
        
        // On ajoute tous les composants
        labels[0] = new JLabel("Nom du Malade :");
        input_pan.add(labels[0]);
       input_pan.add(in_nom);
    
        labels[1] = new JLabel("Prenom du Malade :");
        input_pan.add(labels[1]);
       input_pan.add(in_prenom);
    
        labels[2] = new JLabel("Telephone :");
        input_pan.add(labels[2]);
       input_pan.add(in_tel);
       
       labels[3] = new JLabel("Mutuelle :");
       input_pan.add(labels[3]);
        input_pan.add(in_mutuelle);
    
       labels[4] = new JLabel("Adresse :");
       input_pan.add(labels[4]);
        input_pan.add(in_adresse);
       
       input_pan.add(in_search);
       

        this.add(input_pan,BorderLayout.NORTH);
    
    
       String title[] = {"Numero Malade","Nom Patient","Prenom Patient","Telephone","Adresse", "Mutuelle"};
        ZModel zModel2 = new ZModel(data, title);
        this.tab= new JTable(zModel2);
        this.tab.setRowHeight(20);
        this.add(new JScrollPane(tab), BorderLayout.CENTER);
        this.tab.getColumn("Suppression").setCellEditor(new DeleteButtonEditor(new JCheckBox(),controler2));
        
           if(add_pan.getObj() != null ){
            System.out.println("cc");
            System.out.println(add_pan.getObj());
            ((ZModel)tab.getModel()).addRow(add_pan.getObj());
            
            ajouter.addActionListener(this);
      
      this.add(ajouter, BorderLayout.EAST);
      this.add(ajout, BorderLayout.EAST);

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
