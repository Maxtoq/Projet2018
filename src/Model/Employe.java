
package Model;

/**
 *
 * @author maxim
 */
public class Employe {
    
    protected int num;
    protected String nom;
    protected String prenom;
    protected String tel;
    protected String adresse;
    
    public Employe(int _num, String _nom, String _prenom, String _tel, String _adresse) {
        num = _num;
        nom = _nom;
        prenom = _prenom;
        tel = _tel;
        adresse = _adresse;
    }
    
    public void setNum(int _num) { num = _num; }
    public void setNom(String _nom) { nom = _nom; }
    public void setPrenom(String _prenom) { prenom = _prenom; }
    public void setTel(String _tel) { tel = _tel; }
    public void setAdresse(String _adresse) { adresse = _adresse; }
    
    public int getNum() { return num; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getTel() { return tel; }
    public String getAdresse() { return adresse; }
}
