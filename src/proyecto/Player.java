/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge A. Santos
 */
public class Player {
    int cont =0;
    
    public boolean addPlayer(String user, String pass){
        try{
          ObjectOutputStream crear = new ObjectOutputStream(new FileOutputStream(user));  
          crear.writeObject(user);
          crear.writeObject(pass);
          cont++;
          JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
          return true;
        }catch(IOException e){
            System.out.println("Error: "+e);
            return false;
        }
    }
    
    
    
    public boolean look(String user, String pass) {
        try{
            ObjectInputStream login = new ObjectInputStream(new FileInputStream(user));  
            Object us =login.readObject();
            Object ps =login.readObject();
            
            if(user.equalsIgnoreCase(us.toString()) && pass.equalsIgnoreCase(ps.toString())){
                    cont++;
                    return true;   
            }else{
                JOptionPane.showMessageDialog(null,"El Usuario o la contraseña son erroneas");   
            }
        }catch(IOException e){
            e.getMessage();
        }catch(ClassNotFoundException e){
            e.getMessage();
         }
        return false;
    }
    
 
}
