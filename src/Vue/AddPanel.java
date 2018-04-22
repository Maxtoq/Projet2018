
package Vue;

import Controleur.Main;
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
    private Main controler;
    private Service obj;
    private Malade mal;
    private MaladeDAO mal_dao;
    
            
    
   public AddPanel(String S,Main controler2){
       in_JT1 = new JTextField();
       in_JT2 = new JTextField();
       in_JT3 = new JTextField();
       in_JT4 = new JTextField();
       in_JT5 = new JTextField();
       in_JT6 = new JTextField();
       ajouter = new JButton("Ajouter " + S);
       ajouter.addActionListener(this);
       this.controler = controler2;
       this.serv_dao3 = controler2.getServDAO();
       this.mal_dao = controler2.getMalDAO();
       S2 = S;
       
       combo.setPreferredSize(new Dimension(100, 20));
       
        
          if(S == "hospitalisation")
         {
             JLabel[] labels = new JLabel[4];
             input_pan = new JPanel( new GridLayout(0, 4, 10, 5));
            labels[0] = new JLabel("N°Malade :");
            input_pan.add(labels[0]);
            input_pan.add(in_JT1);
            labels[1] = new JLabel("Numero lit :");
            input_pan.add(labels[1]);
            input_pan.add(in_JT2);
            labels[2] = new JLabel("Code Service :");
            input_pan.add(labels[2]);
            input_pan.add(in_JT3);
            labels[3] = new JLabel("Nom Patient :");
            input_pan.add(labels[3]);
            input_pan.add(in_JT4);
            input_pan.add(ajouter);
            
         }
          if(S == "service")
         {
             JLabel[] labels = new JLabel[4];
             input_pan = new JPanel( new GridLayout(0, 4, 10, 5));
            labels[1] = new JLabel("Nom :");
            input_pan.add(labels[1]);
            input_pan.add(in_JT1);
            labels[0] = new JLabel("Code Batiment :");
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
         if(S == "docteurs"){
            JLabel[] labels = new JLabel[8];
            input_pan = new JPanel( new GridLayout(0, 8, 10, 5));
            labels[0] = new JLabel("N° :");
            input_pan.add(labels[0]);
            input_pan.add(in_JT1);
            labels[1] = new JLabel("Prénom :");
            input_pan.add(labels[1]);
            input_pan.add(in_JT2);
            labels[2] = new JLabel("Adresse :");
            input_pan.add(labels[2]);
            input_pan.add(in_JT3);
            labels[3] = new JLabel("Nom :");
            input_pan.add(labels[3]);
            input_pan.add(in_JT4);
            labels[4] = new JLabel("Téléphone :");
            input_pan.add(labels[4]);
            input_pan.add(in_JT5);
            labels[5]= new JLabel ("Specialité :");
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
         
         
         if(S == "infirmier")
         {
             JLabel[] labels = new JLabel[8];
             input_pan = new JPanel( new GridLayout(0, 8, 10, 5));
            labels[0] = new JLabel("N° :");
            input_pan.add(labels[0]);
            input_pan.add(in_JT1);
            labels[1] = new JLabel("Nom :");
            input_pan.add(labels[1]);
            input_pan.add(in_JT2);
            labels[2] = new JLabel("Prenom :");
            input_pan.add(labels[2]);
            input_pan.add(in_JT3);
            labels[3] = new JLabel("Telephone :");
            input_pan.add(labels[3]);
            input_pan.add(in_JT4);
            labels[4] = new JLabel("Adresse :");
            input_pan.add(labels[4]);
            input_pan.add(in_JT5);
            labels[5]= new JLabel ("Rotation :");
            combo.addItem("Jour");
            combo.addItem("Nuit");
            input_pan.add(labels[5]);
            input_pan.add(combo);
            labels[6] = new JLabel("Salaire :");
            input_pan.add(labels[6]);
            input_pan.add(in_JT6);
            labels[7]= new JLabel ("Service :");
            combo2.addItem("CAR");
            combo2.addItem("CHG");
            combo2.addItem("REA");
            input_pan.add(labels[7]);
            input_pan.add(combo2);
            input_pan.add(ajouter);
            
         }
        
         
         if(S == "malade")
         {
              JLabel[] labels = new JLabel[6];
             input_pan = new JPanel( new GridLayout(0, 6, 10, 5));
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
       if(ae.getSource().equals(ajouter))
       { if(S2 == "service"){
            String str = in_JT4.getText();
            int i = Integer.parseInt(str);
            String str2 = in_JT3.getText();
            char c = str2.charAt(0);
            obj = new Service(in_JT2.getText(),in_JT1.getText(),c,i);
              System.out.println("La valeur de l'objet est " + obj.getCode() +" "+ obj.getNom()+ " " +obj.getBat()+ " " + obj.getDir() );
            serv_dao3.create(obj);
       }
       
           if(S2 == "malade"){
                String str = in_JT1.getText();
                int i = Integer.parseInt(str);
                mal = new Malade(i, in_JT2.getText(),in_JT3.getText(),in_JT4.getText(),in_JT5.getText(),combo.getActionCommand());
                mal_dao.create(mal);
           }
       }
    }

   
  
}
