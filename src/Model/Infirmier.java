package Model;


/**
 *
 * @author maxim
 */
public class Infirmier extends Employe {
    
    private String serv;
    private String rot;
    private float sal;
    
    public Infirmier(int _num, String _nom, String _prenom, String _tel, String _adresse, String _serv, String _rot, float _sal) {
        super(_num, _nom, _prenom, _tel, _adresse);
        serv = _serv;
        rot = _rot;
        sal = _sal;
    }
    
    public void setServ(String _serv) { serv = _serv; }
    public void setRot(String _rot) { rot = _rot; }
    public void setSal(float _sal) { sal = _sal; }
    
    public String getServ() { return serv; }
    public String getRot() { return rot; }
    public float getSal() { return sal; }
}
