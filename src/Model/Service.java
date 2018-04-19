package Model;

/**
 *
 * @author maxim
 */
public class Service {
    
    private String code;
    private String nom;
    private char bat;
    private int dir;
    
    public Service(String _code, String _nom, char _bat, int _dir) {
        code = _code;
        nom = _nom;
        bat = _bat;
        dir = _dir;
    }
    
    public void setCode(String _code) { code = _code; }
    public void setNom(String _nom) { nom = _nom; }
    public void setBat(char _bat) { bat = _bat; }
    public void setDir(int _dir) { dir = _dir; }
    
    public String getCode() { return code; }
    public String getNom() { return nom; }
    public char getBat() { return bat; }
    public int getDir() { return dir; }
}
