/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author maxim
 */
public class Service {
    
    private String code;
    private String nom;
    private char bat;
    private String dir;
    
    public Service(String _code, String _nom, char _bat, String _dir) {
        code = _code;
        nom = _nom;
        bat = _bat;
        dir = _dir;
    }
}
