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
import Model.Malade;
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
    // On declare tous les composants
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
     // Variables pour la connexion SQL
    private MaladeDAO malade_dao2;
    private String[] data;
    private Object T;
    private ArrayList select;
    private ZModel zModel;
    private Main controler2;
    
    
    
    public MaladePanel(Main _controler){
        
        this.setLayout(new BorderLayout());
        // Recupere le controler pour creer le add pan correspondant
        //ainsi que recup malade_Dao
        this.controler2 = _controler;
        add_pan = new AddPanel("malade",controler2);
        this.add(add_pan,BorderLayout.SOUTH);
        this.malade_dao2 = this.controler2.getMalDAO();

          // On initialise tous les composants
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
    
        //Premiere ligne a afficher pour gte.class
        Object[][] data = {{"1","Querrey","Sam","01 52 53 23 82", "43 rue Vauvenargues 78000 Versailles","MNAM","supp"}
      
          };
    
    
        JPanel input_pan = new JPanel(new GridLayout(0, 6, 10, 5));
         // On crée un tableau de JLabel pour l'affichage 
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
       
         //on ajoute la pan 
        this.add(input_pan,BorderLayout.NORTH);
    
        //modèle d'affichage spécifique destiné à pallier
       //les bugs d'affichage !
       String title[] = {"Numero Malade","Nom Patient","Prenom Patient","Telephone","Adresse", "Mutuelle", "Suppression"};
       // zmodel pour pouvoir modifier les donnes du jtable 
       ZModel zModel2 = new ZModel(data, title);
        this.tab= new JTable(zModel2);
        this.tab.setRowHeight(20);
        this.add(new JScrollPane(tab), BorderLayout.CENTER);
       //On définit un éditeur pour la colonne "supprimer"
        this.tab.getColumn("Suppression").setCellEditor(new DeleteButtonEditor(new JCheckBox(),controler2,"malade"));
        
         
      
   

    
    
    }
    // set la valeur d'une ligne du tab a partir d'un object[]
                 public void setValue(Object[] donnee){
        ((ZModel)tab.getModel()).addRow(donnee);
                 }
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
     // Si on clic sur search lance la procedure de requete search 
        if (ae.getSource().equals(in_search)) {
                 // On recupere un array list de string des param de la recherche
            // pour recuperer un array list
            //de Malade correspondant aux malades qui ont les meme param que 
            //ceux dans l'array list de string
                ArrayList<String> strs = new ArrayList<>();
                if (in_num.getText() != null )
                strs.add(in_num.getText());
                else  strs.add("");
                if (in_nom.getText() != null)
                strs.add(in_nom.getText());
                else  strs.add("");
                if(in_prenom.getText() != null)
                strs.add(in_prenom.getText());
                else  strs.add("");
                if (in_adresse.getText() != null)
                strs.add(in_adresse.getText());
                else  strs.add("");
                if (in_tel.getText() != null)
                strs.add(in_tel.getText());
                else strs.add("");
                String str2 = combo.getSelectedItem().toString();
                if (str2 != "--")
                    strs.add(str2);
                else strs.add("");
                
              ArrayList<Malade> strs2 = new ArrayList<>();
              strs2 = malade_dao2.select(strs);
              //System.out.println("size strs2 "+ strs2.size());
              for(int i =0; i< strs2.size();i++)
             {
                 //Pour chaque malade dans l'array list on le recupere 
                 // on add ses valeurs dans un iobjet et on se sert de add.Row 
                    Malade mal = strs2.get(i);
                         
                    int codeR = mal.getNum();
                    String codeR2 = new String();
                    codeR2 = String.valueOf(codeR);
                    System.out.println("codeR "+codeR);
                    String nomR = new String();
                    nomR = mal.getNom();
                    System.out.println("nomR "+nomR);
                    String prenomR = mal.getPrenom();
                    System.out.println("prenomR "+prenomR);
                    String adresseR = new String();
                    adresseR = mal.getAdresse();
                    String telR = new String();
                    telR = mal.getTel();
                    String mutuelleR = new String();
                    mutuelleR= mal.getMut();
                    System.out.println("dirR "+mutuelleR);
                    Object[] data = new Object[7];
                    data[0] = codeR2; 
                    data[1]= nomR;
                    data[2] = prenomR;
                    data[3]= adresseR;
                    data[4]= telR;
                    data[5] = mutuelleR;
                ((ZModel)tab.getModel()).addRow(data);
                 //Object[][] data2 ={codeR, nomR , batR,dirR,"supp"};   
             }
        }
    
    
    }
}
