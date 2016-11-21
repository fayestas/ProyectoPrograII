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
public class Bomba extends Ficha {

    public Bomba(String Tipo) {
        super(11, Tipo, (Tipo.equals("malo")?"Pumpkin Bomb":"Nova Blast"));
    }
}
