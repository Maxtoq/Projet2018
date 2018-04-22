package Vue;

import Controleur.Main;
import Model.Hosp;
import Model.HospDAO;
import Model.Service;
import Model.ServiceDAO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/*

 */

/**
 *
 * @author Tony
 */
public class HospPanel extends JPanel implements ActionListener {
    
   
    private JTextField in_nom;
    private AddPanel add_pan;

    private JTextField in_lit;
    private JTextField in_codeService;
    private JTextField in_numMalade;
    private JTable tab;
    private JButton ajouter;
    private JButton in_search;
    private JTextField ajout;
    
    private HospDAO hosp_dao2;
    private String[] data;
    private Object T;
    private ArrayList select;
    private ZModel zModel;
    private Main controler2;


   
    // On initialise tous les objets
    
    public HospPanel(Main _controler)
    {
      
        this.setLayout(new BorderLayout());
        
        
        this.controler2=_controler;
        add_pan = new AddPanel("hospitalisation",controler2);
        this.add(add_pan,BorderLayout.SOUTH);
        this.hosp_dao2 = this.controler2.getHospDAO();
        
                in_lit = new JTextField(15);
                in_codeService = new JTextField();
               in_numMalade = new JTextField();
               ajouter = new JButton("Ajouter un malade");
              in_search = new JButton("Rechercher");
              in_search.addActionListener(this);
              in_nom = new JTextField(15);
                      ajout = new JTextField();

              
               Object data[][] = {
            {"0101", "Maxime", "URG","302","supp"},
            {"0102","Clement", "CAR","202","supp"},
            {"0103","Tony","RAD", "102","supp"},};


            JPanel input_pan2 = new JPanel(new GridLayout(0, 4, 10, 5));

            JLabel[] labels = new JLabel[4];
        
        // On ajoute tous les composants
        labels[0] = new JLabel("Numéro du malade :");
        input_pan2.add(labels[0]);
        
       input_pan2.add(in_lit);
        labels[1] = new JLabel("Numéro Lit :");
        input_pan2.add(labels[1]);
        
       input_pan2.add(in_codeService);
        labels[2] = new JLabel("Code Service :");
        input_pan2.add(labels[2]);
       input_pan2.add(in_numMalade);
       
       labels[3] = new JLabel("Nom du patient :");
       input_pan2.add(labels[3]);
        input_pan2.add(in_nom);
       
       input_pan2.add(in_search);
       

        this.add(input_pan2,BorderLayout.NORTH);
        
               //modèle d'affichage spécifique destiné à pallier
      //les bugs d'affichage !
        String title[] = {"Numero Malade","Nom Patient","Code Service","Numero Lit","Suppression"};
        ZModel zModel2 = new ZModel(data, title);
        this.tab= new JTable(zModel2);
        this.tab.setRowHeight(20);
        this.add(new JScrollPane(tab), BorderLayout.CENTER);
        this.tab.getColumn("Suppression").setCellEditor(new DeleteButtonEditor(new JCheckBox(), controler2, "hospitalisation"));
        
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
          if (ae.getSource().equals(in_search)) {
                ArrayList<String> strs = new ArrayList<>();
                strs.add(in_numMalade.getText());
                strs.add(in_nom.getText());
                strs.add(in_lit.getText());
                strs.add(in_codeService.getText());
                
              ArrayList<Hosp> strs2 = new ArrayList<>();
              
              strs2 = hosp_dao2.select(strs);
             for(int i =0; i< strs2.size();i++)
             {
                 Hosp servR = strs2.get(i);
                         
                    String codeR = new String();
                    codeR = servR.getServ();
                   // int nomR = new int();
                   // nomR = servR.getNMalade();
                    int n_Lit = servR.getLit();
                    int dirR = servR.getNChambre();
             zModel.setValueAt(codeR,i++,1);
            // zModel.setValueAt(nomR,i++,2);
             zModel.setValueAt(n_Lit,i++,3);
             zModel.setValueAt(dirR,i++,4);
                    
        
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