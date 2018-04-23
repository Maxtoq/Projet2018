
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
 * Fenetre qui apparait lorsque l'on clique sur service 
 * 
 * @author cleme
 */
public class ServicePanel extends JPanel implements ActionListener{
   // On declare tous les composants
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
     
      
    public ServicePanel(Main _controler){
        
        
      
        this.setLayout(new BorderLayout());
       // Recupere le controler pour creer le add pan correspondant ainsi que recup servDao
        this.controler2=_controler;
        this.serv_dao2 = this.controler2.getServDAO();
        System.out.println("La valeur de l'objet est"+serv_dao2);
        add_pan = new AddPanel("service",controler2 );
        this.add(add_pan,BorderLayout.SOUTH);
       
        //Premiere ligne a afficher pour gte.class
        Object[][] data2 = {  
            {"REA","Reanimation et Traumatologie","A","19","supp"}
             
    };
        //initialisation des composant
        ajouter = new JButton("Ajouter une ligne");
        in_nom = new JTextField(15);
        in_code = new JTextField();
        in_batiment = new JTextField();
        in_batiment.addActionListener(this);
        in_dir = new JTextField();
        in_search = new JButton("Rechercher");
        in_search.addActionListener(this);
        ajout = new JTextField();
        
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
        
        //on ajoute la pan 
        this.add(input_pan, BorderLayout.NORTH);
        
       
        //modèle d'affichage spécifique destiné à pallier
       //les bugs d'affichage !
        String title[] = {"Code","Nom","Batiment","Directeur", "Suppression"};
        // zmodel pour pouvoir modifier les donnes du jtable
        ZModel zModel = new ZModel(data2, title);
        this.tab= new JTable(zModel);
        this.tab.setRowHeight(20);
        this.add(new JScrollPane(tab), BorderLayout.CENTER);
        
        //On définit un éditeur pour la colonne "supprimer"
        this.tab.getColumn("Suppression").setCellEditor(new DeleteButtonEditor(new JCheckBox(),controler2, "service"));
        
     
      
      
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
            //de service correspondant aux services qui ont les meme param quer 
            //ceux dans l'array list de string
            
                ArrayList<String> strs = new ArrayList<>();
                strs.add(in_code.getText());
                strs.add(in_nom.getText());
                strs.add(in_batiment.getText());
                strs.add(in_dir.getText());
              ArrayList<Service> strs2 = new ArrayList<>();
              
              strs2 = serv_dao2.select(strs);
             for(int i =0; i< strs2.size();i++)
             {
                 //Pour chaque service dans l'array list on le recupere 
                 // on add ses valeurs dans un iobjet et on se sert de add.Row 
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
                   
                

                    
        
          }
            
              
          }
       
    
    }      
    
}

