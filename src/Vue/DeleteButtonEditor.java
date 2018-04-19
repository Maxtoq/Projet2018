/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import static com.sun.javafx.fxml.expression.Expression.not;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author cleme
 */
public class DeleteButtonEditor extends DefaultCellEditor {
     protected JButton button; 
     private DeleteButtonListener bListener = new DeleteButtonListener();
    
   public DeleteButtonEditor(JCheckBox checkBox) {
      //Par défaut, ce type d'objet travaille avec un JCheckBox
      super(checkBox);
      
       //On crée à nouveau notre bouton
      button = new JButton();
      button.setOpaque(true);
       //On lui attribue un listener
       button.addActionListener((ActionListener) bListener);
       
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
            //On affiche un message mais vous pourriez faire ce que vous voulez
            System.out.println("bool : "+ (bool));
             bool = !bool;
             jop1 = new JOptionPane();
             jop1.showMessageDialog(null, "Vous allez supprimer une ligne !", "Information", JOptionPane.INFORMATION_MESSAGE);       
            //On affecte un nouveau libellé à une celulle de la ligne
            System.out.println("bool : "+ (bool));
            if(bool = true)
            {((ZModel)table.getModel()).removeRow(this.row);}
             
         }
      }
   }         
}
