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
    
   
    private JTextField in_chambre;
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
              in_chambre = new JTextField(15);
                      ajout = new JTextField();

              
               Object data[][] = {
            {"1", "REA", "101","1","supp"},
            };


            JPanel input_pan2 = new JPanel(new GridLayout(0, 4, 10, 5));

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
       

        this.add(input_pan2,BorderLayout.NORTH);
        
               //modèle d'affichage spécifique destiné à pallier
      //les bugs d'affichage !
        String title[] = {"Numero Malade","Service ","Numero Chambre ","Numero Lit","Suppression"};
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
                strs.add(in_codeService.getText());
                strs.add(in_chambre.getText());
                strs.add(in_lit.getText());
                
              ArrayList<Hosp> strs2 = new ArrayList<>();
              
              strs2 = hosp_dao2.select(strs);
             for(int i =0; i< strs2.size();i++)
             {
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