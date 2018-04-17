
package Vue;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author cleme
 */
public class ServicePanel extends JPanel{
    //
    private JTable tab;
    private JButton change = new JButton("Changer la taille");
   
   
    public ServicePanel(){
        
        String[] tri = {"Code","Nom","Batiment","Directeur"};
        JComboBox boxtri = new JComboBox(tri);
        boxtri.setSelectedIndex(3);
        
        

        Object data[][] = {

        };

        String title[] = {"Code","Nom","Batiment","Directeur"};

        this.tab= new JTable(data,title);
        this.tab.setRowHeight(30);
        this.add(boxtri);
        this.add(new JScrollPane(tab), BorderLayout.CENTER);
        this.tab.getColumn("Code").setCellRenderer(new ButtonRenderer());
        this.tab.getColumn("Nom").setCellRenderer(new ButtonRenderer());
        this.tab.getColumn("Batiment").setCellRenderer(new ButtonRenderer());
        this.tab.getColumn("Directeur").setCellRenderer(new ButtonRenderer());
    }

} 
