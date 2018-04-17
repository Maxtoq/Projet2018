
package Model;

/**
 *
 * @author maxim
 */
public class Malade extends Person {
    
    private String mut;
    
    public Malade(int _num, String _nom, String _prenom, String _tel, String _adresse, String _mut) {
        num = _num;
        nom = _nom;
        prenom = _prenom;
        tel = _tel;
        adresse = _adresse;
        mut = _mut;
    }
    
    public void setMut(String _mut) { mut = _mut; }
    
    public String getMut() { return mut; }
}
