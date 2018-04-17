
package Vue;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author cleme
 */
public class ServicePanel extends JFrame{
    //
    private JTable tab;
    private JButton change = new JButton("Changer la taille");
   
   
    public ServicePanel(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("JTable");

        this.setSize(600, 180);


        Object data[][] = {

        };

        String title[] = {"Code","Nom","Batiment","Directeur"};

        this.tab= new JTable(data,title);
        this.tab.setRowHeight(30);
        this.getContentPane().add(new JScrollPane(tab), BorderLayout.CENTER);
        this.tab.getColumn("Code").setCellRenderer(new ButtonRenderer());
        this.tab.getColumn("Nom").setCellRenderer(new ButtonRenderer());
        this.tab.getColumn("Batiment").setCellRenderer(new ButtonRenderer());
        this.tab.getColumn("Directeur").setCellRenderer(new ButtonRenderer());
    }

} 
