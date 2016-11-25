/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge A. Santos
 */
public class Player{
    ArrayList<String> usuarios = new ArrayList <> ();
    CrearPlayer cp;
    Login lg;
   
    public String addPlayer(){
        return addPlayer(cp.usuario,0);
    }

    private String addPlayer(String usuario, int pos) {
        for(String us: usuarios){
            if(us!=null && !usuarios.contains(cp.usuario)){
                try{
                    usuarios.add(new String(cp.usuario));
                }catch(InputMismatchException e){
                    JOptionPane.showMessageDialog(null, "El usuario no puedo ser registrado");
                }
            }
        }
//        if(pos < usuarios.size()){
//            CrearPlayer c = usuarios.get(pos);
//            if(c.equals(usuario))
//                return c;
//            return search(usuario, pos+1);
//        }
     return null;
    }
    
//    public void addPlayer(){
//            if(search()!=null){
//            usuarios.add(new String(cp.usuario));
//            }
//                    
//    }
    
    
    public void login(){
        for(String cP : usuarios){
            if(usuarios.contains(lg.user)){
                MenuPrincipal mp = new MenuPrincipal();
                mp.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "El usuario o la contraseña es incorrecta");
            }
        }
    }
}
