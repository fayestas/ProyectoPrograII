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

import java.util.ArrayList;
import java.util.Random;
public class TableroLogica {
   Ficha[][] fichas= new Ficha[10][10];
   private Random rand = new Random();
   ArrayList <String> malos =new ArrayList<>();
   ArrayList <String> buenos =new ArrayList<>();
   
   
   boolean colocarFichas(){
       
   
       return true;
   }
   
   void colocarTierra(){
        
        
        int c=rand.nextInt(8)+1;

        fichas[0][c]=new Tierra("malo");
        c=rand.nextInt(8)+1;
        fichas[9][c]=new Tierra("bueno");
        
        //Bombas alrededor malos
        
        fichas[1][c]=new Bomba("malo");
        fichas[0][c+1]=new Bomba("malo");
        fichas[0][c-1]=new Bomba("malo");
        
        malos.add("Tierra");
        malos.add("Bomba");
        malos.add("Bomba");
        malos.add("Bomba");
        
        //Bombas alrededor de los buenos
        
        fichas[8][c]=new Bomba("bueno");
        fichas[9][c+1]=new Bomba("bueno");
        fichas[9][c-1]=new Bomba("bueno");
        buenos.add("Tierra");
        buenos.add("Bomba");
        buenos.add("Bomba");
        buenos.add("Bomba");
    }
   
   
   void ColocarBombasRestantesMalos(){
       //malos
       int c= rand.nextInt(10);
       int f= rand.nextInt(2);
       if(ContarElementos("Bomba",malos)<6){
           if(fichas[f][c]==null){
          fichas[f][c]=new Bomba("malo");
          }
           else{ColocarBombasRestantesMalos();}
       } 
   }
   
    void ColocarBombasRestantesBuenos(){
       //buenos
       int c= rand.nextInt(10);
       int f= rand.nextInt(2)+8;
       if(ContarElementos("Bomba",buenos)<6){
           if(fichas[f][c]==null){
                fichas[f][c]=new Bomba("malo");
            }
           else{ColocarBombasRestantesMalos();}
       } 
   }
      
      
    void ColocarRangosMayores(){
          
          ColocarRango9Malos();
          ColocarRango9Buenos();
          ColocarRango10Malos();
          ColocarRango10Buenos();
          
     }
    
    
    void ColocarRestantes(){
        
       
    
    
    }
    
    
    void ColocarRestantesBuenos(){
    
        
    
    
    }
    
    
    void ColocarRestantesMalos(){
        
        for(int f=0;f<4;f++){
        
            for(int c=0;c<10;c++){
            
                if(fichas[f][c]==null){
                
                    int opc=rand.nextInt(4);
                    
                    switch(opc){
                    
                        case 0:
                        break;
               
                        case 1:
                        break;
                    
                        case 2:
                    
                    }
                
                
                }
            
            }
        
        }
    }
      
    void ColocarRango9Malos(){
      
          int c= rand.nextInt(10);
          int f= 3;
          if(malos.contains("Galactus")){
              return;
          
          }
          else{
              
            if(fichas[f][c]==null){
                fichas[f][c]=new Rango9("malo");
                malos.add("Galactus");

            }
            else{

               ColocarRango9Malos(); 

            }
          }
          
      }
      
    void ColocarRango9Buenos(){  
          int c= rand.nextInt(10);
          int f= 6;
          if(buenos.contains("Captain America")){
          
              return;
          
          }
          else{
          
              if(fichas[f][c]==null){
                  fichas[f][c]=new Rango9("bueno");
                  buenos.add("Captain America");
              }
             else{
                  ColocarRango9Buenos();
              
              }
          }
          
    }
    
    void ColocarRango10Buenos(){  
          int c= rand.nextInt(10);
          int f= 6;
          if(buenos.contains("Mr. Fantastic")){
              return;
          }
          else{
              if(fichas[f][c]==null){
                  fichas[f][c]=new Rango10("bueno");
                  buenos.add("Mr. Fantastic");
              }
             else{
                  ColocarRango10Buenos();          
              }
          }
          
    }
    
    void ColocarRango10Malos(){
          int c= rand.nextInt(10);
          int f= 3;
          if(malos.contains("Dr. Doom")){
              return;
          }
          else{
            if(fichas[f][c]==null){
                fichas[f][c]=new Rango9("malo");
                malos.add("Dr. Doom");
            }
            else{
               ColocarRango9Malos(); 
            }
          }
          
      }
    
    
    
    
    public int ContarElementos(String elemento , ArrayList<String> a){
         int contador=0;
         for(String e: a){
             if (e.equals(elemento)){
                 contador++;
             }                                
        }
       
         return contador;
    }
}