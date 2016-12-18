/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import logica.TableroLogica;

/**
 *
 * @author miriam trochez
 */
public class Board extends JFrame implements ActionListener
{
    public static TableroLogica tab=new TableroLogica();
    public static boolean bbuenos=true;
    public static boolean bmalos=false;
    Container contenedor;
    public Board(){
         contenedor=getContentPane();
        //estetica del tablero
        Toolkit myFrame = Toolkit.getDefaultToolkit();
        setBounds(25,15,700,660);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("MARVEL™ Stratego");
        MPanel image3 = new MPanel();
        image3.agregarFichas();
        image3.agregaZonas();
        add(image3);
        setResizable(false);
        tab.colocarFichas();
    }  

    @Override
    public void actionPerformed(ActionEvent e)
    {
        dispose();
    }
}
class MPanel extends JPanel implements ActionListener{
    public ArrayList <Ficha> buenos = new ArrayList <Ficha>(40);
    public ArrayList <Ficha> malos = new ArrayList <Ficha>(40);
    JButton corset[][]= new JButton[10][10];
    public MPanel(){
         setLayout(new BorderLayout());
         JLabel starter = new JLabel("VILLANOS");
        starter.setForeground(Color.black);
        starter.setFont(new Font("Bauhaus 93",Font.PLAIN,38));
        starter.setHorizontalTextPosition(JLabel.CENTER);
        starter.setVerticalTextPosition(JLabel.CENTER);
        add(starter,BorderLayout.NORTH);
        JLabel starte = new JLabel("HEROES");
        starte.setForeground(Color.black);
        starte.setFont(new Font("Bauhaus 93",Font.PLAIN,38));
        starte.setHorizontalTextPosition(JLabel.CENTER);
        starte.setVerticalTextPosition(JLabel.CENTER);
        add(starte,BorderLayout.SOUTH);
        JPanel Bpanel2 = new JPanel();
        Border thickBorder = new LineBorder(Color.DARK_GRAY,5);
        //layout cuadricula
        Bpanel2.setLayout(new GridLayout(10,10,5,5));
        MoverPieza ol = new MoverPieza();
        for(int f=0;f<10;f++){
            for(int c=0;c<10;c++){
                 corset[f][c] = new JButton(f+"."+c);
                corset[f][c].addActionListener(ol);
                corset[f][c].setContentAreaFilled(false);
                corset[f][c].setBorder(thickBorder);
                Bpanel2.add(corset[f][c]);
            }
        }
        Bpanel2.setOpaque(false);
        add(Bpanel2,BorderLayout.CENTER);
    }
    public void agregarFichas(){
        for(int f=0;f<4;f++){
            for(int c=0;c<10;c++){
               Ficha villa = new Ficha("VILL",1,"malo");
               malos.add(villa);
               corset[f][c].setIcon(villa.fich);
            }
        }
        for(int f=6;f<10;f++){
            for(int c=0;c<10;c++){
               Ficha bue = new Ficha("HERO",1,"bueno");
               buenos.add(bue);
               corset[f][c].setIcon(bue.fich);;
            }
        }
    }  
    public void agregaZonas(){
        Border thickBorder2 = new LineBorder(Color.RED,5);
        Border thickBorder3 = new LineBorder(Color.BLUE,5);
        for(int f=4;f<6;f++){
            for(int c=2;c<4;c++){
                corset[f][c].setContentAreaFilled(true);
                corset[f][c].setBorder(thickBorder2);
                corset[f][c].setEnabled(false);
            }
        }
        for(int f=4;f<6;f++){
            for(int c=6;c<8;c++){
                corset[f][c].setContentAreaFilled(true);
                corset[f][c].setBorder(thickBorder3);
                corset[f][c].setEnabled(false);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        
    }

}
class MoverPieza implements ActionListener{
  boolean movimientoValido(logica.Ficha inicial, logica.Ficha destino, int f1 , int c1 ,int f2, int c2  ){
  if(inicial instanceof logica.Rango2 && destino==null&&(f2==f1||c2==c1+1))
      return true;
  if((f2==f1+1&& c1==c2)||(f2==f1-1&& c1==c2))
      return true;
  if((f2==f1&&c2==c1+1)||(f2==f1&&c2==c1-1))
      return true;
  return false;
  }
  
  
  int[] comerValido(logica.Ficha inicial, logica.Ficha destino, int f1 , int c1 ,int f2, int c2 ){
      int[] pos={0,0};
      
      if (inicial instanceof logica.Rango1&& destino instanceof logica.Rango10){
       pos[0]=f2;
       pos[1]=c2;
      }
        if(inicial instanceof logica.Rango10 && destino instanceof logica.Rango1) {
        
        pos[0]=f1;
       pos[1]=c1;
        }
        if(destino instanceof logica.Bomba && inicial instanceof logica.Rango3 ){
        pos[0]=f2;
       pos[1]=c2;
        }
      if(inicial.Rango>destino.Rango){
       pos[0]=f2;
       pos[1]=c2;
      }
      if(inicial.Rango < destino.Rango){
      pos[0]=f1;
       pos[1]=c1;
      }
      return pos;
  }
          
    
    
    int parseFila(double coordenada){
   String num=Double.toString(coordenada);
   int tamaño=num.length();
   String coor="";
   for(int i=0 ;i<tamaño ;i++){
   if(num.charAt(i)== '.'){
   break;
   }
    coor=coor+num.charAt(i);
   }
  
   return Integer.parseInt(coor);
  
   }
   
   int parseColumna(double coordenada){
   String num=Double.toString(coordenada);
   int tamaño=num.length();
   boolean punto=false;
   String coor="";
   for(int i=0 ;i<tamaño ;i++){
   if(punto){
      coor=coor+num.charAt(i);
   }
   if(num.charAt(i)== '.'){
   punto=true;
   }
    
   }
   return Integer.parseInt(coor);
   }

   boolean winBuenos(){
       for(int c=0;c<10;c++){
           if(Board.tab.fichas[0][c].Rango==0){
               return false;
           }
       }
       return true;
   
   }
   
   boolean winMalos(){
       for(int c=0;c<10;c++){
           if(Board.tab.fichas[9][c].Rango==0){
               return false;
           }
       }
       return true;
   }
   
   
   
    JButton clickedButton = null;
    public boolean doMove(JButton a, JButton b){
        double coor1 = parseDouble(a.getText());
        double coor2 = parseDouble(b.getText());
        ImageIcon vil = new ImageIcon(getClass().getResource("/proyecto/unnamed1.png"));
        ImageIcon he = new ImageIcon(getClass().getResource("/proyecto/unnamed.png"));
        if(coor2==coor1+0.1 || coor2==coor1-0.1 || coor2==coor1+1 || coor2==coor1-1){
            int f1=parseFila(coor1);
            int f2=parseFila(coor2);
            int c1=parseColumna(coor1);
            int c2=parseColumna(coor2);
            if(Board.bbuenos){
                if(Board.tab.fichas[f1][c1]!=null&&Board.tab.fichas[f1][c1].Tipo.equals("malo")){
                    return false;
                }
            }
            if(Board.bmalos){
                if(Board.tab.fichas[f1][c1]!=null&&Board.tab.fichas[f1][c1].Tipo.equals("bueno")){
                    return false;
                }
            }
            if(b.getIcon()==null){

                if(movimientoValido(Board.tab.fichas[f1][c1],Board.tab.fichas[f2][c2],f1,c1,f2,c2)){
                           Board.tab.fichas[f2][c2]=Board.tab.fichas[f1][c1];
                           Board.tab.fichas[f1][c1]=null;
                           b.setIcon(a.getIcon());
                           a.setIcon(null);
                           return true;
                }
                
            }
            else if(b.getIcon()==a.getIcon()){
                JOptionPane.showMessageDialog(null,"POSICION no disponible");
                return false;
            }
            else{
                 String pieza="";
                if(Board.tab.fichas[f1][c1]==null||Board.tab.fichas[f1][c1].Tipo.equals(Board.tab.fichas[f2][c2].Tipo)){
                    return false;
                }
                if(Board.tab.fichas[f1][c1].Rango==Board.tab.fichas[f2][c2].Rango){
                       pieza=Board.tab.fichas[f1][c1].nombre+" y "+Board.tab.fichas[f2][c2];
                       Board.tab.fichas[f1][c1]=null;
                       Board.tab.fichas[f2][c2]=null;
                       a.setIcon(null);
                       b.setIcon(null);
                       JOptionPane.showMessageDialog(null,"Pieza  Comida "+pieza);
                       return true;
                }
                int[] pos=comerValido(Board.tab.fichas[f1][c1],Board.tab.fichas[f2][c2],f1,c1,f2,c2);
                pieza=Board.tab.fichas[pos[0]][pos[1]].nombre;
                Board.tab.fichas[pos[0]][pos[1]]=null;
                
                if(pos[0]==f1){
                   a.setIcon(null);  
                }
                else{
                    b.setIcon(null);
                }
                
                JOptionPane.showMessageDialog(null,"Pieza  Comida"+pieza);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"POSICION denegada");
            return false;
        }
        return true;
    }    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (clickedButton == null){
        // first button clicked - so remember the button
            clickedButton = (JButton)e.getSource();
        }
        else {
        // second button, so do the 'move'
            JButton secondButton = (JButton)e.getSource();
           if(doMove(clickedButton,secondButton)){
           
               if(Board.bbuenos){
                   Board.bbuenos=false;
                   Board.bmalos=true;
               }
               else{
                   if(Board.bmalos){
                     Board.bmalos=false;
                     Board.bbuenos=true;
                   
                   }
               }
               
               if(winBuenos()){
                   Board.bbuenos=false;
                   Board.bmalos=false;
                   JOptionPane.showMessageDialog(null,"Heroes wins");
               }
               
               if(winMalos()){
                   Board.bbuenos=false;
                   Board.bmalos=false;
                   JOptionPane.showMessageDialog(null,"Villians wins");
               }
           }

        // clear the clickedButton so that we know the next click is a first click
           clickedButton = null;
        }
    }
}

