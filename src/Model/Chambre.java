
package Model;

/**
 *
 * @author maxim
 */
public class Chambre {
    
    private int num;
    private String serv;
    private int surveillant;
    private int nb_lits;
    
    public Chambre(int _num, String _serv, int _surv, int _nb_lits) {
        num = _num;
        serv = _serv;
        surveillant = _surv;
        nb_lits = _nb_lits;
    }
    
    public void setNum(int _num) { num = _num; }
    public void setServ(String _serv) { serv = _serv; }
    public void setSurveillant(int _surv) { surveillant = _surv; }
    public void setNbLits(int _nb_lits) { nb_lits = _nb_lits; }
    
    public int getNum() { return num; };
    public String getServ() { return serv; };
    public int getSurveillant() { return surveillant; };
    public int getNbLits() { return nb_lits; };
}
