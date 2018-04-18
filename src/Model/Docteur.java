package Model;

/**
 *
 * @author maxim
 */
public class Docteur extends Employe {
    
    private String spec;
    
    public Docteur(int _num, String _nom, String _prenom, String _tel, String _adresse, String _spec) {
        super(_num, _nom, _prenom, _tel, _adresse);
        spec = _spec;
    }
    
    public void setSpec(String _spec) { spec = _spec; }
    
    public String getSpec() { return spec; }
}
