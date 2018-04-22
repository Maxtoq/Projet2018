
package Vue;

import Controleur.Main;
import Model.HospDAO;
import Model.MaladeDAO;
import Model.ServiceDAO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Fenêtre principale de l'interface graphique, affichant le menu et les panel correspondant à chaque item
 * 
 * @author maxim
 */
public class Fenetre extends JFrame implements ActionListener, WindowListener {
    
    private Main controler;
    private ServicePanel service_pan;
    private JToolBar menu;
    private JButton b_employes;
    private JButton b_malades;
    private JButton b_services;
    private JButton b_hosp;
    private PersonPanel doct_pan;
    private PersonPanel infir_pan;
    private PersonPanel malade_pan;
    private MaladePanel malade_Panel; 
    private HospPanel hosp_pan;
    private JTabbedPane tab_pan;
    private JPanel panel;
    private ServiceDAO servDAO;
    private HospDAO hospDAO;    
    private MaladeDAO malDAO;
    
    public Fenetre(Main _controler) {
        super("Gestion centre hospitalier");
        this.setSize(1500, 1000);
        panel = new JPanel();
        controler = _controler;
        service_pan = new ServicePanel(controler);
        menu = new JToolBar(JToolBar.VERTICAL);
       // malade_Panel = new MaladePanel(controler);//
        hosp_pan = new HospPanel(controler);
        malade_Panel = new MaladePanel(controler);
        servDAO = controler.getServDAO();
        
        hospDAO = controler.getHospDAO();
        
        malDAO = controler.getMalDAO();
        
        
        b_employes = new JButton("-   Employés");
        initButton(b_employes);
        b_malades = new JButton("-   Malades");
        initButton(b_malades);
        b_services = new JButton("-   Services");
        initButton(b_services);
        b_hosp = new JButton("-   Hospitalisations");
        initButton(b_hosp);
        
        b_services.addActionListener(this);
        b_employes.addActionListener(this);
        b_hosp.addActionListener(this);
        b_malades.addActionListener(this);
        
        menu.add(b_employes);
        menu.add(b_malades);
        menu.add(b_services);
        menu.add(b_hosp);
        
        menu.setFloatable(false);
        menu.setBackground(Color.lightGray);
        
        this.add(menu, BorderLayout.WEST);
        
        this.addWindowListener(this);
        
        this.setVisible(true);
    }
    
    private void initButton(JButton b) {
        b.setBackground(Color.lightGray);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setPreferredSize(new Dimension(150,100));
        b.setMargin(new Insets(10,18,10,20));
    }
    
    private void initEmployePan() {
        
            
        doct_pan = new PersonPanel(1);
        infir_pan = new PersonPanel(2);
        malade_pan = new PersonPanel(3);
        JTabbedPane tab_pan = new JTabbedPane();
        tab_pan.addTab("Docteurs", doct_pan);
        tab_pan.addTab("Infirmiers(ères)", infir_pan);
        tab_pan.addTab("Malades",malade_pan);
        
        panel.add(tab_pan);
        this.add(panel,BorderLayout.EAST);
        this.setVisible(true);

       

    }
    
    private void initMaladePan(){
        
        panel.add(malade_Panel);
        this.add(panel,BorderLayout.CENTER);
        this.setVisible(true);


    }
    
    private void initServicePan(){  
        panel.add(service_pan);
        this.add(panel,BorderLayout.CENTER);       
        this.setVisible(true);      
    }
    
   private void initHospPan(){   
       panel.add(hosp_pan, BorderLayout.CENTER);
        this.add(panel);
        this.setVisible(true);
        
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b_employes)) {
            
           
            this.remove(panel);
            panel.removeAll();
          
           
            initEmployePan();
            
            
            
            
            
            
        }
        
 if (e.getSource().equals(b_malades)) {
          /**  initEmployePan();**/
            this.remove(panel);
            panel.removeAll();
            initMaladePan();
 
        }
        
        if (e.getSource().equals(b_services)) {
          /**  initEmployePan();**/
            this.remove(panel);
            panel.removeAll();
            initServicePan();
           
           
           
        }  //Nouveau if avec bouton b_hosp + fonction au dessus + nouvelle classe hospanel + cdc pour l'affichage de cette page
       //
       
       if (e.getSource().equals(b_hosp))  {
          this.remove(panel);
           panel.removeAll();
           initHospPan();
   
       }
       
    } 
    
    @Override
    public void windowOpened(WindowEvent we) {}
    @Override
    public void windowClosing(WindowEvent we) { System.exit(0); }
    @Override
    public void windowClosed(WindowEvent we) {}
    @Override
    public void windowIconified(WindowEvent we) {}
    @Override
    public void windowDeiconified(WindowEvent we) {}
    @Override
    public void windowActivated(WindowEvent we) {}
    @Override
    public void windowDeactivated(WindowEvent we) {}

    
}
