
package Vue;

import Controleur.Main;
import Model.Docteur;
import Model.DocteurDAO;
import Model.Infirmier;
import Model.InfirmierDAO;
import Model.Service;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Page des items de personnes : Employés (docteurs et infirmiers) et Malades
 * 
 * @author maxim
 */
public class PersonPanel extends JPanel implements ActionListener{
    // On declare tous les composants
    private int type; // Type d'employé : 1 = docteur, 2 = infirmier, 3 = malade
    private JTextField in_N;
    private JComboBox in_code;
    private JTextField in_sal;
    private JComboBox in_spec;
    private JTextField in_nom;
    private JTextField in_prenom;
    private JTextField in_adresse;
    private JTextField in_tel;
    private JComboBox in_rot;
    private JButton in_search;
    private ZModel zModel;
    public SearchPanel search_pan;
    public JPanel pan;
     private AddPanel add_pan;
     private JTable tab;
     private Main controler2;
      // Variables pour la connexion SQL
     private DocteurDAO doc_dao;
     private InfirmierDAO inf_dao;
   
    public PersonPanel(int _type, Main controler) {
        type = _type;
        // Recupere le controler pour creer le add pan correspondant ainsi que recup servDao
        this.controler2=controler;
       
        this.setLayout(new BorderLayout()); 
        in_search = new JButton("Rechercher");
        in_search.addActionListener(this);
        this.doc_dao = this.controler2.getDocDAO();
        this.inf_dao = this.controler2.getInfDAO();
         
       
       // Initialise les composants       
       in_N = new JTextField();
       in_code = new JComboBox ();
       in_N = new JTextField(); 
       in_sal= new JTextField();
       in_tel = new JTextField();
       in_nom = new JTextField();
       in_prenom = new JTextField();
       in_rot = new JComboBox ();
       in_spec = new JComboBox ();
       in_adresse = new JTextField();
       
       
       
       
       
       // test le type pour differencier les deux pages
       
       if (type ==1)
       {
           // cree le add panel correspondant et on l'add
           add_pan = new AddPanel("docteur",controler2 );
            this.add(add_pan,BorderLayout.SOUTH);
            // premiere ligne d'affichage neccessaire pour getclasse de z model
             Object[][] data2 = {  
            {"","","","","","",""}};
               // On crée un tableau de JLabel pour l'affichage 
                JLabel[] labels = new JLabel[6];
        
             // On crée un panel pour les input de la recherche
                 JPanel input_pan = new JPanel(new GridLayout(0, 6, 10, 5));
                    labels[0] = new JLabel("N°Docteur :");
                    input_pan.add(labels[0]);
                    input_pan.add(in_N);
                    labels[1] = new JLabel("Nom :");
                    input_pan.add(labels[1]);
                    input_pan.add(in_nom);
                    labels[2] = new JLabel("Prénom :");
                    input_pan.add(labels[2]);
                    input_pan.add(in_prenom);
                    labels[3] = new JLabel("Téléphone :");
                    input_pan.add(labels[3]);
                    input_pan.add(in_tel);
                    labels[4] = new JLabel("Adresse :");
                    input_pan.add(labels[4]);
                    input_pan.add(in_adresse);
                    labels[5]= new JLabel ("Specialité :");
                    in_spec.addItem("--");
                    in_spec.addItem("Anesthesiste");
                    in_spec.addItem("Cardiologue");
                    in_spec.addItem("Orthopediste");
                    in_spec.addItem("Pneumologue");
                    in_spec.addItem("Radiologue");
                    in_spec.addItem("Traumatologue");
                    input_pan.add(labels[5]);
                    input_pan.add(in_spec);
                    input_pan.add(in_search);
                    this.add(input_pan, BorderLayout.NORTH);
                    
                
                // Titre pour notre Jtable Puis creation de son ZModel pour 
                //modifier ses valeurs et ensuite du JTable en question    
               String title[] = {"Numero","Nom","Prenom ","Adresse","Telephone","Spécialité", "Suppression"};
                ZModel zModel = new ZModel(data2, title);
                this.tab= new JTable(zModel);
                this.tab.setRowHeight(20);
                this.add(new JScrollPane(tab), BorderLayout.CENTER);
                // Cologne de suppresion creation
                this.tab.getColumn("Suppression").setCellEditor(new DeleteButtonEditor(new JCheckBox(),controler2, "docteur"));
       }
        if (type ==2 )
       {
           // cree le add panel correspondant et on l'add
           add_pan = new AddPanel("infirmier",controler2 );
            this.add(add_pan,BorderLayout.SOUTH);
            // premiere ligne d'affichage neccessaire pour getclasse de z model
            Object[][] data2 = {  
           {"","","","","","", "","",""}};
             // On crée un tableau de JLabel pour l'affichage 
            JLabel[] labels = new JLabel[8];
        
             // On crée un panel pour les input de la recherche
                 JPanel input_pan = new JPanel(new GridLayout(0, 8, 10, 5));
                 labels[0] = new JLabel("N°Infirmier :");
                 input_pan.add(labels[0]);
                 input_pan.add(in_N);
                    labels[1] = new JLabel("Nom :");
                    input_pan.add(labels[1]);
                    input_pan.add(in_nom);
                    labels[2] = new JLabel("Prénom :");
                    input_pan.add(labels[2]);
                    input_pan.add(in_prenom);
                    labels[3] = new JLabel("Téléphone :");
                    input_pan.add(labels[3]);
                    input_pan.add(in_tel);
                    labels[4] = new JLabel("Adresse :");
                    input_pan.add(labels[4]);
                    input_pan.add(in_adresse);
                    labels[5]= new JLabel ("Code Service :");
                        in_code.addItem("--");
                        in_code.addItem("CAR");
                        in_code.addItem("CHG");
                        in_code.addItem("REA");
                        input_pan.add(labels[5]);
                        input_pan.add(in_code);
                        
                 labels[6]= new JLabel ("Rotation :");
                    in_rot.addItem("--");
                    in_rot.addItem("Jour");
                    in_rot.addItem("Nuit");
                    input_pan.add(labels[6]);
                    input_pan.add(in_rot);
                labels[7] = new JLabel("Salaire :");
                input_pan.add(labels[7]);
                input_pan.add(in_sal);     
                    input_pan.add(in_search);
                    this.add(input_pan, BorderLayout.NORTH);
                    
                // Titre pour notre Jtable Puis creation de son ZModel pour 
                //modifier ses valeurs et ensuite du JTable en question
                    
               String title[] = {"Numero","Nom","Prenom","Adresse","Telephone ","Code Service", "Rotation"," Salaire ","Suppression"};
                ZModel zModel = new ZModel(data2, title);
                this.tab= new JTable(zModel);
                this.tab.setRowHeight(20);
                this.add(new JScrollPane(tab), BorderLayout.CENTER);
                // Cologne de suppresion creation
                this.tab.getColumn("Suppression").setCellEditor(new DeleteButtonEditor(new JCheckBox(),controler2, "infirmier"));
       }
   }
       
       
       

    @Override
    public void actionPerformed(ActionEvent ae) {
       // Si on clic sur search lance la procedure de requete search 
        if (ae.getSource().equals(in_search)){
          Object[][] data2 = {  
            {"","","","","","",""}};
         // ((ZModel)tab.getModel()).addRow(data2);
           // for (int y =1; y < tab.getModel().getRowCount()-2 ;y++){
             //   ((ZModel)tab.getModel()).removeRow(y);
                 //   }
           // selon le type on effectue une recherche d'infirmier ou de docteur
            if (type ==1){
               // On recupere un array list de string des param de la recherche
            // pour recuperer un array list
            //de docteur correspondant aux docteurs qui ont les meme param quer 
            //ceux dans l'array list de string
            
               ArrayList<String> strs = new ArrayList<>();
                strs.add(in_N.getText());
                strs.add(in_nom.getText());
                strs.add(in_prenom.getText());
                strs.add(in_tel.getText());
                strs.add(in_adresse.getText()); 
                String str2 = in_spec.getSelectedItem().toString();
                if (str2 != "--")
                    strs.add(str2);
                else strs.add("");
              ArrayList<Docteur> strs3 = new ArrayList<>();
              strs3 = doc_dao.select(strs);
              
              for(int i =0; i< strs3.size();i++)
             {
                  //Pour chaque docteurs dans l'array list on le recupere 
                 // on add ses valeurs dans un iobjet et on se sert de add.Row 
                 Docteur docR = strs3.get(i);
                   int numR = docR.getNum();
                   String numR2 = new String();
                   numR2=String.valueOf(numR);
                   String nomR = docR.getNom();
                   String prenomR = docR.getPrenom();
                   String adresseR = docR.getAdresse();
                   String telR = docR.getTel();
                   String specR = new String();
                   specR = docR.getSpec();
                   Object[] data = new Object[7];
                    data[0] = numR2; 
                    data[1]= nomR;
                    data[2]= prenomR;
                    data[3]= adresseR;
                    data[4]= telR;
                    data[5]= specR;
               
                 ((ZModel)tab.getModel()).addRow(data);    
             }
              // Boucle pour enlever les lignes qui ne sont pas notre recherche
              //On se place a la ligne d'indice Nb de ligne - le nb de ligne que
              // lon a ajouté que si le nb de ligne initial est supêrieur a deux
              if( tab.getModel().getRowCount()>2)
                for (int y =tab.getModel().getRowCount() - strs3.size() ; y > 0 ;y--){
                   ((ZModel)tab.getModel()).removeRow(y);
                    }
            }
           if (type ==2){
               // On recupere un array list de string des param de la recherche
            // pour recuperer un array list
            //de infirmier correspondant aux infirmier qui ont les meme param quer 
            //ceux dans l'array list de string
               ArrayList<String> strs = new ArrayList<>();
                strs.add(in_N.getText());
                strs.add(in_nom.getText());
                strs.add(in_prenom.getText());
                strs.add(in_tel.getText());
                strs.add(in_adresse.getText()); 
                String str2 = in_code.getSelectedItem().toString();
                 if (str2 != "--")
                    strs.add(str2);
                else strs.add(" ");
                String str4 = in_rot.getSelectedItem().toString();
                if (str4 != "--")
                    strs.add(str4);
                else strs.add(" ");
                strs.add(in_sal.getText());
                ArrayList<Infirmier> strs3 = new ArrayList<>();
                strs3 = inf_dao.select(strs);
                for(int i =0; i< strs3.size();i++)
             {
                 //Pour chaque infirmier dans l'array list on le recupere 
                 // on add ses valeurs dans un iobjet et on se sert de add.Row 
                 Infirmier InfR = strs3.get(i);
                   int numR = InfR.getNum();
                   
                   String numR2 = new String();
                   numR2=String.valueOf(numR);
                   String nomR = InfR.getNom();
                   String prenomR = InfR.getPrenom();
                   String adresseR = InfR.getAdresse();
                   String telR = InfR.getTel();
                   String codeR = new String();
                   codeR = InfR.getServ();
                   String rotR = new String();
                   rotR = InfR.getRot();
                   float salR = InfR.getSal();
                   String salR2 = String.valueOf(salR);
                   System.out.printf("num : "+ numR2);
                   Object[] data = new Object[8];
                    data[0] = numR2; 
                    data[1]= nomR;
                    data[2]= prenomR;
                    data[3]= adresseR;
                    data[4]= telR;
                    data[5]= codeR;
                    data[6] = rotR;
                    data[7]= salR2;
                    
                 ((ZModel)tab.getModel()).addRow(data);    
             }
                 // Boucle pour enlever les lignes qui ne sont pas notre recherche
              //On se place a la ligne d'indice Nb de ligne - le nb de ligne que
              // lon a ajouté que si le nb de ligne initial est supêrieur a deux
             // if( tab.getModel().getRowCount()>2)
               // for (int y =tab.getModel().getRowCount() - strs3.size() ; y > 0 ;y--){
                 //  ((ZModel)tab.getModel()).removeRow(y);
                   // }
            }
           }
       }
    }
    



