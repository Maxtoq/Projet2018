
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
    // On declare tous les composants
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
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    
    // Variables pour la connexion SQL
    private ServiceDAO servDAO;
    private HospDAO hospDAO;    
    private MaladeDAO malDAO;
    
    public Fenetre(Main _controler) {
        super("Gestion centre hospitalier");
        this.setSize(1500, 1000);
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
                    
            
        // Recupere le controler pour creer le add pan correspondant ainsi que
        //recup les variables de connexions SQL
        controler = _controler;
        
        servDAO = controler.getServDAO();
        
        hospDAO = controler.getHospDAO();
        
        malDAO = controler.getMalDAO();
        // initialise les pannel neccesaire et les comosants
        service_pan = new ServicePanel(controler);
        menu = new JToolBar(JToolBar.VERTICAL);
       
        hosp_pan = new HospPanel(controler);
        malade_Panel = new MaladePanel(controler);
        
        b_employes = new JButton("-   Employés");
        initButton(b_employes);
        b_malades = new JButton("-   Malades");
        initButton(b_malades);
        b_services = new JButton("-   Services");
        initButton(b_services);
        b_hosp = new JButton("-   Hospitalisations");
        initButton(b_hosp);
        
        // Ajoute des actiosn listenner
        b_services.addActionListener(this);
        b_employes.addActionListener(this);
        b_hosp.addActionListener(this);
        b_malades.addActionListener(this);
        
        // Add le tout et le rend visible
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
        //lance la procedure de creation de la fenetres des employes
            
        doct_pan = new PersonPanel(1, controler);
        infir_pan = new PersonPanel(2, controler);
        JTabbedPane tab_pan = new JTabbedPane();
        tab_pan.addTab("Docteurs", doct_pan);
        tab_pan.addTab("Infirmiers(ères)", infir_pan);
        
        // ON l'ajout ensuite au tampon 
        // on ajout ensuite le tampon a la page
        panel1.add(tab_pan);
        this.add(panel1);
        this.repaint();
        this.revalidate();
        this.setVisible(true);

       

    }
    
    private void initMaladePan(){
        // ON ajoute au tampon  le pan dejha cree avant
        // on ajout ensuite le tampon a la page
        panel2.add(malade_Panel);
        this.add(panel2,BorderLayout.CENTER);
        this.repaint();
        this.revalidate();
        this.setVisible(true);


    }
    
    private void initServicePan(){  
       // ON ajoute au tampon  le pan dejha cree avant
        // on ajout ensuite le tampon a la page
        panel3.add(service_pan);
        this.add(panel3,BorderLayout.CENTER);  
        this.repaint();
        this.revalidate();
        
        this.setVisible(true);      
    }
    
   private void initHospPan(){   
       // ON ajoute au tampon  le pan dejha cree avant
        // on ajout ensuite le tampon a la page
        panel4.add(hosp_pan, BorderLayout.CENTER);
        this.add(panel4);
        this.repaint();
        this.revalidate();
        this.setVisible(true);
        
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
      // selon le bouton presse on lance la creation d'une page ou d'une autre 
        if (e.getSource().equals(b_employes)) {
            
           /// Le remoove sert a eviter les pb daffichage 
            this.remove(panel1);
            this.remove(panel2);
            this.remove(panel3);
            this.remove(panel4);
            
            panel1.removeAll();
            panel2.removeAll();
            panel3.removeAll();
            panel4.removeAll();
            
            initEmployePan();
            
            
            
            
            
            
        }
        
 if (e.getSource().equals(b_malades)) {
          /// Le remoove sert a eviter les pb daffichage 
            this.remove(panel1);
            this.remove(panel2);
            this.remove(panel3);
            this.remove(panel4);
            
            panel1.removeAll();
            panel2.removeAll();
            panel3.removeAll();
            panel4.removeAll();
            initMaladePan();
 
        }
        
        if (e.getSource().equals(b_services)) {
           /// Le remoove sert a eviter les pb daffichage 
            this.remove(panel1);
            this.remove(panel2);
            this.remove(panel3);
            this.remove(panel4);
            
            panel1.removeAll();
            panel2.removeAll();
            panel3.removeAll();
            panel4.removeAll();
            
            initServicePan();
           
           
           
        }  
       
       if (e.getSource().equals(b_hosp))  {
          this.remove(panel1);
            this.remove(panel2);
            this.remove(panel3);
            this.remove(panel4);
            
            panel1.removeAll();
            panel2.removeAll();
            panel3.removeAll();
            panel4.removeAll();
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
