/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.ArrayList;

/**
 *
 * @author Jorge A. Santos
 */
public class Usuarios extends CrearPlayer{
    ArrayList<CrearPlayer> usuarios = new ArrayList <> ();
    CrearPlayer cp;
   
    public CrearPlayer search(){
        return search(usuario,0);
    }

    private CrearPlayer search(String usuario, int pos) {
        if(pos < usuarios.size()){
            CrearPlayer c = usuarios.get(pos);
            if(c.equals(usuario))
                return c;
            return search(usuario, pos+1);
        }
        return null;
    }
    
    public void addPlayer(){
            if(search()!=null){
            usuarios.add(new CrearPlayer());
            }
            
    }
    
    
    
 
    
    
}
