/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import javax.swing.ImageIcon;

/**
 *
 * @author miriam trochez
 */
public class Ficha
{
    String nombre;
    int rango;
    Boolean lado;
    ImageIcon fich;
    public Ficha(String n,int r,String vb){
        nombre=n;
        rango=r;
        fich= new ImageIcon(getClass().getResource("/proyecto/unnamed.png"));
        if(vb.equalsIgnoreCase("malo")){
            fich= new ImageIcon(getClass().getResource("/proyecto/unnamed1.png"));
            lado=false;
        }    
        else{
            fich= new ImageIcon(getClass().getResource("/proyecto/unnamed.png"));
            lado=true;
        }
    }

    public String getNombre()
    {
        return nombre;
    }

    public int getRango()
    {
        return rango;
    }

    public Boolean getLado()
    {
        return lado;
    }
    
    
}
