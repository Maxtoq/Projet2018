
package Vue;

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

   
    private JTextField in_JT1;
    private JTextField in_JT2;
    private JTextField in_JT3;
    private JTextField in_JT4;
    private JTextField in_JT5;
    private JButton ajouter;
    private JPanel input_pan = new JPanel();
    private JComboBox combo = new JComboBox();
    
            
    
   public AddPanel(String S){
       in_JT1 = new JTextField();
       in_JT2 = new JTextField();
       in_JT3 = new JTextField();
       in_JT4 = new JTextField();
       in_JT5 = new JTextField();
       ajouter = new JButton("Ajouter " + S);
       ajouter.addActionListener(this);
       
       combo.setPreferredSize(new Dimension(100, 20));
       
         if(S == "docteurs"){
            JLabel[] labels = new JLabel[6];
            input_pan = new JPanel( new GridLayout(0, 6, 10, 5));
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
            input_pan.add(combo);
            input_pan.add(ajouter);
           }
         if(S == "service")
         {
             JLabel[] labels = new JLabel[4];
             input_pan = new JPanel( new GridLayout(0, 4, 10, 5));
            labels[0] = new JLabel("N°Batiments :");
            input_pan.add(labels[0]);
            input_pan.add(in_JT1);
            labels[1] = new JLabel("Code Batiment :");
            input_pan.add(labels[1]);
            input_pan.add(in_JT2);
            labels[2] = new JLabel("Nom Batiment :");
            input_pan.add(labels[2]);
            input_pan.add(in_JT3);
            labels[3] = new JLabel("Num Directeur :");
            input_pan.add(labels[3]);
            input_pan.add(in_JT4);
            input_pan.add(ajouter);
         }
         this.add(input_pan);
   }
   
   
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource().equals(ajouter))
       {
         System.out.println("TEXT in cases" + in_JT1.getText()+ in_JT2.getText()+
                 in_JT3.getText()+ in_JT4.getText()+ in_JT5.getText()+ combo.getAccessibleContext().toString());
       }
    }
    
    
}
