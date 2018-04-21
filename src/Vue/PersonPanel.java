
package Vue;

import java.awt.*;
import javax.swing.*;

/**
 * Page des items de personnes : Employés (docteurs et infirmiers) et Malades
 * 
 * @author maxim
 */
public class PersonPanel extends JPanel {
    
    private int type; // Type d'employé : 1 = docteur, 2 = infirmier, 3 = malade
    
    public SearchPanel search_pan;
    public JPanel pan;
    
    public PersonPanel(int _type) {
        type = _type;
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        search_pan = new SearchPanel(type);
        search_pan.setBorder(BorderFactory.createTitledBorder("Rechercher"));
        search_pan.setPreferredSize(new Dimension(850,500));
        
        pan = new JPanel();
        //add_pan = new AddPanel();
        pan.setBorder(BorderFactory.createTitledBorder("Ajouter un employé"));
        
        this.add(search_pan);
        this.add(pan);
        
        this.setVisible(true);
    }
}
