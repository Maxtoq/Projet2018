
package Vue;

import Controleur.Main;
import Model.DocteurDAO;
import Model.Hosp;
import Model.HospDAO;
import Model.InfirmierDAO;
import Model.Malade;
import Model.Docteur;
import Model.MaladeDAO;
import Model.Service;
import Model.ServiceDAO;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import Model.Infirmier;

/**
 *
 * @author cleme
 */
public class DeleteButtonEditor extends DefaultCellEditor {
    protected JButton button; 
    private DeleteButtonListener bListener = new DeleteButtonListener();
    private Service obj;
    private ServiceDAO serv_dao3;
    private MaladeDAO mal_dao;     
    private Main controler;
    private String type;
    private Malade mal;
    private Hosp hosp;
    private Infirmier Inf;
    private Docteur doc; 
    private HospDAO hosp_dao;
    private InfirmierDAO inf_dao;
    private DocteurDAO doc_dao;
    
   public DeleteButtonEditor(JCheckBox checkBox, Main _controler, String S) {
      //Par défaut, ce type d'objet travaille avec un JCheckBox
      super(checkBox);
      type = S;
       //On crée à nouveau notre bouton
      button = new JButton();
      button.setOpaque(true);
       //On lui attribue un listener
       button.addActionListener((ActionListener) bListener);
       // on recupere les variables SQL de controleur 
       this.controler = _controler;
       this.serv_dao3 = _controler.getServDAO();
       this.mal_dao =_controler.getMalDAO();
       this.hosp_dao = _controler.getHospDAO();
       this.doc_dao = _controler.getDocDAO();
       this.inf_dao = _controler.getInfDAO();
      //boolen pour emepcher suppression stupid       
      //boolen pour emepcher suppression stupid
      
   }
 
   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
      //On définit le numéro de ligne à notre listener
      bListener.setRow(row);
      //On passe aussi en paramètre le tableau pour des actions potentielles
      bListener.setTable(table);
      //On réaffecte le libellé au bouton
      button.setText( (value ==null) ? "" : value.toString() );
      //On renvoie le bouton
       return button;
   }
    
   class DeleteButtonListener implements ActionListener {
         
        private int row;
        private JTable table;
         //boolen pour emepcher suppression stupid       
      //boolen pour emepcher suppression stupid    
        boolean bool = true;
        //Message dinfo
        private JOptionPane jop1;

        public void setRow(int row){this.row = row;}
        public void setTable(JTable table){this.table = table;}
         
        public void actionPerformed(ActionEvent event) {
            bool = !bool;        
            if(table.getRowCount() > 0){
            //message davertissement 
             bool = !bool;
             jop1 = new JOptionPane();
             jop1.showMessageDialog(null, "Vous allez supprimer une ligne !", "Information", JOptionPane.INFORMATION_MESSAGE);       
            
          
            if(bool = true)
            {
                // Selon le type on recupere les param on cree un object du meme  
                //type avec  du meme type avec ses valeurs et on le supprime 
                // de la bdd 
                if (type == "service"){
                   String str = (String)table.getModel().getValueAt(row , 0);
                   String str2 = (String)table.getModel().getValueAt(row , 1);
                   String str3 = (String)table.getModel().getValueAt(row, 3);
                   int i = Integer.parseInt(str3);
                   String str4 = (String)table.getModel().getValueAt(row , 2);
                   char c = str4.charAt(0);
                   obj = new Service(str,str2,c,i);
                    System.out.println("La valeur de l'objet est " + obj.getCode() +" "+ obj.getNom()+ " " +obj.getBat()+ " " + obj.getDir() );
                   serv_dao3.delete(obj);

                   ((ZModel)table.getModel()).removeRow(this.row);
                }  
               // Selon le type on recupere les param on cree un object du meme  
                //type avec  du meme type avec ses valeurs et on le supprime 
                // de la bdd 
               if (type == "malade"){
                   String str = (String)table.getModel().getValueAt(row , 0);
                   int i = Integer.parseInt(str);
                   String str2 = (String)table.getModel().getValueAt(row , 1);
                   String str3 = (String)table.getModel().getValueAt(row , 2);
                   String str4 = (String)table.getModel().getValueAt(row, 3);
                   String str5 = (String)table.getModel().getValueAt(row, 4);
                   String str6 = (String)table.getModel().getValueAt(row, 5);
                   mal = new Malade(i,str2,str3,str5,str4,str6);
                   mal_dao.delete(mal);
                                    
                  ((ZModel)table.getModel()).removeRow(this.row);
               }
                // Selon le type on recupere les param on cree un object du meme  
                //type avec  du meme type avec ses valeurs et on le supprime
                // de la bdd 
               if (type == "hospitalisation"){
                   String str = (String)table.getModel().getValueAt(row , 0);
                   int i = Integer.parseInt(str);
                   String str2 = (String)table.getModel().getValueAt(row , 1);
                   String str3 = (String)table.getModel().getValueAt(row , 2);
                   int i3 = Integer.parseInt(str3);
                   String str4 = (String)table.getModel().getValueAt(row, 3);
                   int i4 = Integer.parseInt(str4);
                   hosp = new Hosp(i,str2,i3,i4);
                   hosp_dao.delete(hosp);
                                    
                  ((ZModel)table.getModel()).removeRow(this.row);
               }
               // Selon le type on recupere les param on cree un object du meme  
                //type avec  du meme type avec ses valeurs et on le supprime 
               // de la bdd 
                if (type == "infirmier"){
                   String str = (String)table.getModel().getValueAt(row , 0);
                   int i = Integer.parseInt(str);
                   String str2 = (String)table.getModel().getValueAt(row , 1);
                   String str3 = (String)table.getModel().getValueAt(row , 2);
                   String str4 = (String)table.getModel().getValueAt(row, 3);
                   String str5 = (String)table.getModel().getValueAt(row, 4);
                   String str6 = (String)table.getModel().getValueAt(row, 5);
                   String str7 = (String)table.getModel().getValueAt(row, 6);
                   String str8 = (String)table.getModel().getValueAt(row, 7);
      
                   float i8 = Float.parseFloat(str8);
                   Inf = new Infirmier(i,str2,str3,str4,str5,str6,str7,i8);
                   inf_dao.delete(Inf);
                                    
                  ((ZModel)table.getModel()).removeRow(this.row);
               }
               // Selon le type on recupere les param on cree un object du meme  
                //type avec  du meme type avec ses valeurs et on le supprime 
                // de la bdd 
               if (type == "docteur"){
                   String str = (String)table.getModel().getValueAt(row , 0);
                   int i = Integer.parseInt(str);
                   String str2 = (String)table.getModel().getValueAt(row , 1);
                   String str3 = (String)table.getModel().getValueAt(row , 2);
                   String str4 = (String)table.getModel().getValueAt(row, 3);
                   String str5 = (String)table.getModel().getValueAt(row, 4);
                   String str6 = (String)table.getModel().getValueAt(row, 5);
                  
                   doc = new Docteur(i,str2,str3,str4,str5,str6);
                   doc_dao.delete(doc);
                                    
                  ((ZModel)table.getModel()).removeRow(this.row);
               }
             }
      }
   }         
 }
}
