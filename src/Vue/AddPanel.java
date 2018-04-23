
package Vue;

import Controleur.Main;
import Model.Docteur;
import Model.DocteurDAO;
import Model.Hosp;
import Model.HospDAO;
import Model.Infirmier;
import Model.InfirmierDAO;
import Model.Malade;
import Model.MaladeDAO;
import Model.Service;
import Model.ServiceDAO;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author maxim
 */
public class AddPanel extends JPanel implements ActionListener {
    // On declare tous les composants
    private ServiceDAO serv_dao3;
    private JTextField in_JT1;
    private JTextField in_JT2;
    private JTextField in_JT3;
    private JTextField in_JT4;
    private JTextField in_JT5;
    private JTextField in_JT6;
    private JButton ajouter;
    private JPanel input_pan = new JPanel();
    private JComboBox combo = new JComboBox();
    private JComboBox combo2 = new JComboBox();
    private Object[] donnee;
    private String S2;
    // Variables pour la connexion SQL
    private Main controler;
    private Service obj;
    private Malade mal;
    private MaladeDAO mal_dao;
    private Hosp hosp;
    private HospDAO hosp_dao;
    private Docteur doc;
    private DocteurDAO doc_dao;
    private Infirmier inf;
    private InfirmierDAO inf_dao;
    
            
    
   public AddPanel(String S,Main controler2){
       //initialisation des composant
       in_JT1 = new JTextField();
       in_JT2 = new JTextField();
       in_JT3 = new JTextField();
       in_JT4 = new JTextField();
       in_JT5 = new JTextField();
       in_JT6 = new JTextField();
       ajouter = new JButton("Ajouter " + S);
       ajouter.addActionListener(this);
       // on recuperes les valeurs des variables SQL de controller
       this.controler = controler2;
       this.serv_dao3 = controler2.getServDAO();
       this.mal_dao = controler2.getMalDAO();
       this.hosp_dao = controler2.getHospDAO();
       this.doc_dao = controler2.getDocDAO();
       this.inf_dao = controler2.getInfDAO();
       S2 = S;
       
       combo.setPreferredSize(new Dimension(100, 20));
       
        // Selon le type on cree un add panel different 
          if(S == "hospitalisation")
         {
              // On crée un tableau de JLabel pour l'affichage
             JLabel[] labels = new JLabel[4];
             // On crée un panel pour les input de la recherche
             input_pan = new JPanel( new GridLayout(0, 4, 10, 5));
              // On ajoute tous les composants
            labels[0] = new JLabel("N°Malade :");
            input_pan.add(labels[0]);
            input_pan.add(in_JT1);
            labels[1] = new JLabel("Service :");
            input_pan.add(labels[1]);
            input_pan.add(in_JT2);
            labels[2] = new JLabel("N° Chambre :");
            input_pan.add(labels[2]);
            input_pan.add(in_JT3);
            labels[3] = new JLabel("N° lit :");
            input_pan.add(labels[3]);
            input_pan.add(in_JT4);
            input_pan.add(ajouter);
            
         }
          // Selon le type on cree un add panel different 
          if(S == "service")
         {
              // On crée un tableau de JLabel pour l'affichage
             JLabel[] labels = new JLabel[4];
             // On crée un panel pour les input de la recherche
             input_pan = new JPanel( new GridLayout(0, 4, 10, 5));
              // On ajoute tous les composants
            labels[1] = new JLabel("Code Service :");
            input_pan.add(labels[1]);
            input_pan.add(in_JT1);
            labels[0] = new JLabel("Nom Service :");
            input_pan.add(labels[0]);
            input_pan.add(in_JT2);
            labels[2] = new JLabel("Batiment :");
            input_pan.add(labels[2]);
            input_pan.add(in_JT3);
            labels[3] = new JLabel("Num Directeur :");
            input_pan.add(labels[3]);
            input_pan.add(in_JT4);
            input_pan.add(ajouter);
            
         }
          // Selon le type on cree un add panel different 
         if(S == "docteur"){
              // On crée un tableau de JLabel pour l'affichage
            JLabel[] labels = new JLabel[6];
            // On crée un panel pour les input de la recherche
            input_pan = new JPanel( new GridLayout(0, 6, 10, 5));
             // On ajoute tous les composants
            labels[0] = new JLabel("N° :");
            input_pan.add(labels[0]);
            input_pan.add(in_JT1);
            labels[1] = new JLabel("Nom :");
            input_pan.add(labels[1]);
            input_pan.add(in_JT2);
            labels[2] = new JLabel("Prénom :");
            input_pan.add(labels[2]);
            input_pan.add(in_JT3);
            labels[3] = new JLabel("Adresse :");
            input_pan.add(labels[3]);
            input_pan.add(in_JT5);
            labels[4] = new JLabel("Telephone:");
            input_pan.add(labels[4]);
            input_pan.add(in_JT4);
           labels[5]= new JLabel ("Specialité :");
            combo.addItem("--");
            combo.addItem("Anesthesiste");
            combo.addItem("Cardiologue");
            combo.addItem("Orthopediste");
            combo.addItem("Pneumologue");
            combo.addItem("Radiologue");
            combo.addItem("Traumatologue");
            input_pan.add(labels[5]);
            input_pan.add(combo);
            input_pan.add(ajouter);
           }
         // Selon le type on cree un add panel different 
         
         if(S == "infirmier")
         {
              // On crée un tableau de JLabel pour l'affichage
             JLabel[] labels = new JLabel[8];
             // On crée un panel pour les input de la recherche
             input_pan = new JPanel( new GridLayout(0, 8, 10, 5));
              // On ajoute tous les composants
            labels[0] = new JLabel("N° :");
            input_pan.add(labels[0]);
            input_pan.add(in_JT1);
             labels[1] = new JLabel("Nom :");
            input_pan.add(labels[1]);
            input_pan.add(in_JT2);
            labels[2] = new JLabel("Prénom :");
            input_pan.add(labels[2]);
            input_pan.add(in_JT3);
            labels[3] = new JLabel("Adresse :");
            input_pan.add(labels[3]);
            input_pan.add(in_JT5);
            labels[4] = new JLabel("Telephone:");
            input_pan.add(labels[4]);
            input_pan.add(in_JT4);
           labels[5]= new JLabel ("Code Service :");
            combo2.addItem("--");
            combo2.addItem("CAR");
            combo2.addItem("CHG");
            combo2.addItem("REA");
            input_pan.add(labels[5]);
            input_pan.add(combo2);
            labels[6]= new JLabel ("Rotation :");
            combo.addItem("--");
            combo.addItem("Jour");
            combo.addItem("Nuit");
            input_pan.add(labels[6]);
            input_pan.add(combo);
            labels[7] = new JLabel("Salaire :");
            input_pan.add(labels[7]);
            input_pan.add(in_JT6);
            input_pan.add(ajouter);
            
            
         }
        
         // Selon le type on cree un add panel different 
         if(S == "malade")
         {
              // On crée un tableau de JLabel pour l'affichage
              JLabel[] labels = new JLabel[6];
              // On crée un panel pour les input de la recherche
             input_pan = new JPanel( new GridLayout(0, 6, 10, 5));
              // On ajoute tous les composants
            labels[0] = new JLabel("N°Malade :");
            input_pan.add(labels[0]);
            input_pan.add(in_JT1);
            labels[1] = new JLabel("Nom :");
            input_pan.add(labels[1]);
            input_pan.add(in_JT2);
            labels[2] = new JLabel("Prénom :");
            input_pan.add(labels[2]);
            input_pan.add(in_JT3);
            labels[3] = new JLabel("Adresse :");
            input_pan.add(labels[3]);
            input_pan.add(in_JT5);
            labels[4] = new JLabel("Telephone:");
            input_pan.add(labels[4]);
            input_pan.add(in_JT4);
            
            
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
            input_pan.add(ajouter);
         }
         this.add(input_pan);
   }
   
   public Object[] getObj(){
       return donnee;
   }
   
    public void actionPerformed(ActionEvent ae) {
      // Si l'on appuie sur ajouter lance la requet d'ajout
        if(ae.getSource().equals(ajouter))
       { //Selon le type on recupere les valeurs 
           // et l'on cree un objet de ce type avec ces params
           // On cree cet objet dans la bdd
           if(S2 == "service"){
            String str = in_JT4.getText();
            int i = Integer.parseInt(str);
            String str2 = in_JT3.getText();
            char c = str2.charAt(0);
            obj = new Service(in_JT1.getText(),in_JT2.getText(),c,i);
            serv_dao3.create(obj);
       }
       //Selon le type on recupere les valeurs 
           // et l'on cree un objet de ce type avec ces params
           // On cree cet objet dans la bdd
           if(S2 == "malade"){
               
                String str = in_JT1.getText();
                int i = Integer.parseInt(str);
                String str2 = combo.getSelectedItem().toString();
                mal = new Malade(i, in_JT2.getText(),in_JT3.getText(),in_JT4.getText(),in_JT5.getText(), str2);
                mal_dao.create(mal);
           }
           //Selon le type on recupere les valeurs 
           // et l'on cree un objet de ce type avec ces params
           // On cree cet objet dans la bdd
           if(S2 == "hospitalisation"){
                String str = in_JT1.getText();
                int i = Integer.parseInt(str);
                String str2 = in_JT2.getText();
                String str3 = in_JT3.getText();
                int i2 = Integer.parseInt(str3);
                String str4 = in_JT4.getText();
                int i3 = Integer.parseInt(str4);
                hosp = new Hosp (i,str2 ,i2,i3);
                hosp_dao.create(hosp);
           }
           //Selon le type on recupere les valeurs 
           // et l'on cree un objet de ce type avec ces params
           // On cree cet objet dans la bdd
           if(S2 == "docteur"){
               String str = in_JT1.getText();
               int i = Integer.parseInt(str);
               String str2 = in_JT2.getText();
               String str3 = in_JT3.getText();
               String str4 = in_JT4.getText();//tel
               String str5 = in_JT5.getText();//adresse
               String str6 = combo.getSelectedItem().toString();
               doc = new Docteur(i, str2,str3,str4,str5,str6);
               doc_dao.create(doc);
                
               
           }
           //Selon le type on recupere les valeurs 
           // et l'on cree un objet de ce type avec ces params
           // On cree cet objet dans la bdd
            if(S2 == "infirmier"){
               String str = in_JT1.getText();
               int i = Integer.parseInt(str);
               String str2 = in_JT2.getText();
               String str3 = in_JT3.getText();
               String str4 = in_JT4.getText();//tel
               String str5 = in_JT5.getText();//adresse
               String str6 = combo2.getSelectedItem().toString();
               String str7 = combo.getSelectedItem().toString();
               String str8 = in_JT6.getText();
               float f = Float.parseFloat(str8);
               inf = new Infirmier (i, str2,str3,str4,str5,str6,str7,f);
               inf_dao.create(inf);
                
               
           }
       }
    }

   
  
}
