
package Vue;

import Controleur.Main;
import Model.Docteur;
import Model.DocteurDAO;
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
    
    private int type; // Type d'employé : 1 = docteur, 2 = infirmier, 3 = malade
    private JTextField in_N;
    private JComboBox in_code;
    private JTextField in_sal;
    private JComboBox in_spec;
    private JComboBox in_rot;
    private JButton in_search;
    private ZModel zModel;
    public SearchPanel search_pan;
    public JPanel pan;
     private AddPanel add_pan;
     private JTable tab;
     private Main controler2;
     private DocteurDAO doc_dao;
   
    public PersonPanel(int _type, Main controler) {
        type = _type;
        this.controler2=controler;
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new BorderLayout()); 
        in_search = new JButton("Rechercher");
        in_search.addActionListener(this);
        this.doc_dao = this.controler2.getDocDAO();
          //if (type == 1)
             //add_pan = new AddPanel("docteurs",controler2);
        //else if (type == 2)
        //  add_pan = new AddPanel("infirmier");
       // else if ( type == 3 )
         //   add_pan = new AddPanel("malade");
        //this.add(add_pan,BorderLayout.SOUTH);
       /** search_pan = new SearchPanel(type);
        search_pan.setBorder(BorderFactory.createTitledBorder("Rechercher"));
        search_pan.setPreferredSize(new Dimension(850,500));
        
        pan = new JPanel();
        //add_pan = new AddPanel();
        pan.setBorder(BorderFactory.createTitledBorder("Ajouter un employé"));
        
        this.add(search_pan);
        this.add(pan);
        **/
       
       
       in_N = new JTextField();
       in_code = new JComboBox ();
       in_N = new JTextField(); 
       in_sal= new JTextField();
       in_rot = new JComboBox ();
       in_spec = new JComboBox ();
       
       if (type ==1)
       {
           add_pan = new AddPanel("docteur",controler2 );
            this.add(add_pan,BorderLayout.SOUTH);
             Object[][] data2 = {  
            {"19","Traumatologue","supp"}};
               // On crée un tableau de JLabel pour l'affichage 
                JLabel[] labels = new JLabel[2];
        
             // On crée un panel pour les input de la recherche
                 JPanel input_pan = new JPanel(new GridLayout(0, 2, 10, 5));
                 labels[0] = new JLabel("N°Docteur :");
                 input_pan.add(labels[0]);
                 input_pan.add(in_N);
                 
                 labels[1]= new JLabel ("Specialité :");
                    in_spec.addItem("--");
                    in_spec.addItem("Anesthesiste");
                    in_spec.addItem("Cardiologue");
                    in_spec.addItem("Orthopediste");
                    in_spec.addItem("Pneumologue");
                    in_spec.addItem("Radiologue");
                    in_spec.addItem("Traumatologue");
                    input_pan.add(labels[1]);
                    input_pan.add(in_spec);
                    input_pan.add(in_search);
                    this.add(input_pan, BorderLayout.NORTH);
                    
                
                    
               String title[] = {"Numero","Spécialité", "Suppression"};
                ZModel zModel = new ZModel(data2, title);
                this.tab= new JTable(zModel);
                this.tab.setRowHeight(20);
                this.add(new JScrollPane(tab), BorderLayout.CENTER);
                this.tab.getColumn("Suppression").setCellEditor(new DeleteButtonEditor(new JCheckBox(),controler2, "docteur"));
       }
        if (type ==2 )
       {
           add_pan = new AddPanel("infirmier",controler2 );
            this.add(add_pan,BorderLayout.SOUTH);
            Object[][] data2 = {  
            {"19","REA", "JOUR","1256.78","supp"}};
            JLabel[] labels = new JLabel[4];
        
             // On crée un panel pour les input de la recherche
                 JPanel input_pan = new JPanel(new GridLayout(0, 4, 10, 5));
                 labels[0] = new JLabel("N°Infirmier :");
                 input_pan.add(labels[0]);
                 input_pan.add(in_N);
                    labels[1]= new JLabel ("Code Service :");
                        in_code.addItem("--");
                        in_code.addItem("CAR");
                        in_code.addItem("CHG");
                        in_code.addItem("REA");
                        input_pan.add(labels[1]);
                        input_pan.add(in_code);
                 labels[2]= new JLabel ("Rotation :");
                    in_rot.addItem("--");
                    in_rot.addItem("Jour");
                    in_rot.addItem("Nuit");
                    input_pan.add(labels[2]);
                    input_pan.add(in_rot);
                labels[3] = new JLabel("Salaires :");
                input_pan.add(labels[3]);
                input_pan.add(in_sal);     
                    input_pan.add(in_search);
                    this.add(input_pan, BorderLayout.NORTH);
                    
                
                    
               String title[] = {"Numero","Code Service", "Rotation"," Salaire ","Suppression"};
                ZModel zModel = new ZModel(data2, title);
                this.tab= new JTable(zModel);
                this.tab.setRowHeight(20);
                this.add(new JScrollPane(tab), BorderLayout.CENTER);
                this.tab.getColumn("Suppression").setCellEditor(new DeleteButtonEditor(new JCheckBox(),controler2, "infirmier"));
       }
   }
       
       
       

    @Override
    public void actionPerformed(ActionEvent ae) {
       if (ae.getSource().equals(in_search)){
           if (type ==1){
               ArrayList<String> strs = new ArrayList<>();
                strs.add(in_N.getText());
                String str2 = in_spec.getSelectedItem().toString();
                if (str2 != "--")
                    strs.add(str2);
                else strs.add("");
              ArrayList<Docteur> strs3 = new ArrayList<>();
              System.out.printf("Numero : " + in_N.getText());
              System.out.printf("Spec : " + str2);
              strs3 = doc_dao.select(strs);
              System.out.printf("Str3 : " + strs3.size());
              for(int i =0; i< strs3.size();i++)
             {
                 Docteur docR = strs3.get(i);
                   int numR = docR.getNum();
                   String numR2 = new String();
                   numR2=String.valueOf(numR);
                   String specR = new String();
                   specR = docR.getSpec();
                   Object[] data = new Object[2];
                    data[0] = numR2; 
                    data[1]= specR;
                 ((ZModel)tab.getModel()).addRow(data);    
             }
           }
       }
    }
    
}
