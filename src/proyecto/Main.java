/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import javax.swing.JFrame;

/**
 *
 * @author Jorge A. Santos
 */
public class Main {
    public static void main(String[] args) {
        Tablero tab = new Tablero();
        tab.setVisible(true);
        tab.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
