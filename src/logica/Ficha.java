/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Frances
 */
public abstract class Ficha {
    public int Rango;
    public String Tipo;
    public String nombre;

    public Ficha(int Rango, String Tipo, String nombre) {
        this.Rango = Rango;
        this.Tipo = Tipo;
        this.nombre = nombre;
    }
    
    
    
    
}
