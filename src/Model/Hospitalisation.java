
package Model;

/**
 *
 * @author maxim
 */
public class Hospitalisation {
    
    private int n_malade;
    private String serv;
    private int n_chambre;
    private int lit;
    
    public Hospitalisation(int _n_malade, String _serv, int _n_chambre, int _lit) {
        n_malade = _n_malade;
        serv = _serv;
        n_chambre = _n_chambre;
        lit = _lit;
    }
    
    public void setNMalade(int _n_malade) { n_malade = _n_malade; }
    public void setServ(String _serv) { serv = _serv; }
    public void setNChambre(int _n_chambre) { n_chambre = _n_chambre; }
    public void setLit(int _lit) { lit = _lit; }
    
    public int getNMalade() { return n_malade; }
    public String getServ() { return serv; }
    public int getNChambre() { return n_chambre; }
    public int getLit() { return lit; }
}
