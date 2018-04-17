/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author cleme
 */
// Affiche des boutons dans les colonnes de service
public class ButtonRenderer extends JButton implements TableCellRenderer {
     public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus, int row, int col) {

    //On écrit dans le bouton ce que contient la cellule

    setText((value != null) ? value.toString() : "");

    //On retourne notre bouton

    return this;
     }
}