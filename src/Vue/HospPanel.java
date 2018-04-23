package Vue;

import Controleur.Main;
import Model.Hosp;
import Model.HospDAO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
/*

 */

/**
 *
 * @author Tony
 */
public class HospPanel extends JPanel implements ActionListener {
    
   // On declare tous les composants
    private JTextField in_chambre;
    private AddPanel add_pan;

    private JTextField in_lit;
    private JTextField in_codeService;
    private JTextField in_numMalade;
    private JTable tab;
    private JButton ajouter;
    private JButton in_search;
    private JTextField ajout;
     // Variables pour la connexion SQL
    private HospDAO hosp_dao2;
    private String[] data;
    private Object T;
    private ArrayList select;
    private ZModel zModel;
    private Main controler2;


   
   
    
    public HospPanel(Main _controler)
    {
      
        this.setLayout(new BorderLayout());
        
        // Recupere le controler pour creer le add pan correspondant ainsi
        //que recup hosp_Dao
        this.controler2=_controler;
        add_pan = new AddPanel("hospitalisation",controler2);
        this.add(add_pan,BorderLayout.SOUTH);
        this.hosp_dao2 = this.controler2.getHospDAO();
         // On initialise tous les composants
        in_lit = new JTextField(15);
        in_codeService = new JTextField();
        in_numMalade = new JTextField();
        ajouter = new JButton("Ajouter un malade");
        in_search = new JButton("Rechercher");
        in_search.addActionListener(this);
        in_chambre = new JTextField(15);
                      ajout = new JTextField();

            //Premiere ligne a afficher pour gte.class  
               Object data[][] = {
            {"1", "REA", "101","1","supp"},
            };

            // On crée un panel pour les input de la recherche
            JPanel input_pan2 = new JPanel(new GridLayout(0, 4, 10, 5));
             // On crée un tableau de JLabel pour l'affichage 
            JLabel[] labels = new JLabel[4];
        
        // On ajoute tous les composants
        labels[0] = new JLabel("Numéro du malade :");
        input_pan2.add(labels[0]);
        
       input_pan2.add(in_numMalade);
        labels[1] = new JLabel("Code Service :");
        input_pan2.add(labels[1]);
        
       input_pan2.add(in_codeService);
        labels[2] = new JLabel("N° Chambre :");
        input_pan2.add(labels[2]);
       input_pan2.add(in_chambre);
       
       labels[3] = new JLabel("N° lit :");
       input_pan2.add(labels[3]);
        input_pan2.add(in_lit);
       
       input_pan2.add(in_search);
       
         //on ajoute la pan 
        this.add(input_pan2,BorderLayout.NORTH);
        
       //modèle d'affichage spécifique destiné à pallier
      //les bugs d'affichage !
        String title[] = {"Numero Malade","Service ","Numero Chambre ","Numero Lit","Suppression"};
        // zmodel pour pouvoir modifier les donnes du jtable
        ZModel zModel2 = new ZModel(data, title);
        this.tab= new JTable(zModel2);
        this.tab.setRowHeight(20);
        this.add(new JScrollPane(tab), BorderLayout.CENTER);
        //On définit un éditeur pour la colonne "supprimer"
        this.tab.getColumn("Suppression").setCellEditor(new DeleteButtonEditor(new JCheckBox(), controler2, "hospitalisation"));
        
          
           
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
            //d'Hospitalisation correspondant aux hospitalisations qui ont les meme param que 
            //ceux dans l'array list de string
                ArrayList<String> strs = new ArrayList<>();
                strs.add(in_numMalade.getText());
                strs.add(in_codeService.getText());
                strs.add(in_chambre.getText());
                strs.add(in_lit.getText());
                
              ArrayList<Hosp> strs2 = new ArrayList<>();
              
              strs2 = hosp_dao2.select(strs);
             for(int i =0; i< strs2.size();i++)
             {
                 //Pour chaque hospitalisation dans l'array list on le recupere 
                 // on add ses valeurs dans un iobjet et on se sert de add.Row 
                 Hosp hospR = strs2.get(i);
                         
                    int n_malR =hospR.getNMalade();
                    String n_malR2 = new String();
                    n_malR2 = String.valueOf(n_malR);
                    // int nomR = new int();
                   // nomR = servR.getNMalade();
                   String servR = hospR.getServ();
                   int n_chambreR = hospR.getNChambre();
                   String n_chambreR2 = new String();
                   n_chambreR2 = String.valueOf(n_chambreR);
                   int n_Lit = hospR.getLit();
                   String n_Lit2 = new String();
                   n_Lit2 = String.valueOf(n_Lit);
                   
                    Object[] data = new Object[5];
                        data[0] = n_malR2; 
                        data[1]= servR;
                        data[2] = n_chambreR2;
                        data[3]= n_Lit2;
                    ((ZModel)tab.getModel()).addRow(data);

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