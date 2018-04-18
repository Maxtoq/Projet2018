package Vue;

import java.awt.*;
import javax.swing.*;
/*

 */

/**
 *
 * @author Tony
 */
public class HospPanel extends JPanel {
    
    public AddPanel add_pan;
    private JTextField in_lit;
    private JTextField in_codeService;
    private JTextField in_numMalade;
   
    // On initialise tous les objets
    
    public HospPanel()
    {
                add_pan = new AddPanel();
                in_lit = new JTextField(15);
                in_codeService = new JTextField();
               in_numMalade = new JTextField();

                JPanel input_pan = new JPanel(new GridLayout(0, 4, 10, 5));

                JLabel[] labels = new JLabel[3];
        
        // On ajoute tous les composants
        labels[0] = new JLabel("Numéro du malade :");
        input_pan.add(labels[0]);
        
       input_pan.add(in_lit);
        labels[1] = new JLabel("Numéro Lit :");
        input_pan.add(labels[1]);
        
       input_pan.add(in_codeService);
        labels[2] = new JLabel("Code Service :");
        input_pan.add(labels[2]);
       input_pan.add(in_numMalade);
       

        this.add(input_pan);
        this.add(add_pan);

    }
    
     
    
}