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
   public Ficha[][] fichas= new Ficha[10][10];
   private Random rand = new Random();
   ArrayList <String> malos =new ArrayList<>();
   ArrayList <String> buenos =new ArrayList<>();
   
   
   void imprimirTablero(){
       colocarFichas();
       System.out.println("Fichas");
       for(int f=0;f<4;f++){
           for(int c=0;c<10;c++){
            System.out.print(fichas[f][c].nombre+"-");
           }
           System.out.println("");
       }
      
    System.out.println("Fichas");
       for(int f=6;f<10;f++){
        for(int c=0;c<10;c++){
             System.out.print(fichas[f][c].nombre+"-");
          }
          System.out.println("");
      }
       
  
   
   }
   
   
   public boolean colocarFichas(){
        colocarTierra();
        ColocarBombasRestantesBuenos();
        ColocarBombasRestantesMalos();
        rellenarRango2();
        ColocarRangosMayores();
        this.RellenarPiezasFaltantes();
   
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
          malos.add("Bomba");
          if(ContarElementos("Bomba",malos)<6){
             ColocarBombasRestantesMalos();
          }
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
                fichas[f][c]=new Bomba("bueno");
                buenos.add("Bomba");
            }
           if(ContarElementos("Bomba",buenos)<6){
               ColocarBombasRestantesBuenos();
           }
           else{ColocarBombasRestantesBuenos();}
       } 
       
   }
      
      
    void ColocarRangosMayores(){
          
          ColocarRango9Malos();
          ColocarRango9Buenos();
          ColocarRango10Malos();
          ColocarRango10Buenos();
          
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
          if(buenos.contains("Capitan America")){
          
              return;
          
          }
          else{
          
              if(fichas[f][c]==null){
                  fichas[f][c]=new Rango9("bueno");
                  buenos.add("Capitan America");
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
  
    public void rellenarRango2(){
        rellenarRango2Buenos();
        rellenarRango2Malos();
    }
     
    public void rellenarRango2Buenos(){
        boolean random= rand.nextBoolean();
            int fil;
            if(random)
                fil=6;
            else
                fil=7;
            int col= rand.nextInt(10);
           String nombre=nombreRango2Buenos();
            if(nombre==null){
                return;
            }
            if(fichas[fil][col]==null){
                fichas[fil][col]= new Rango2("bueno",nombre);
                buenos.add(nombre);
            }
            rellenarRango2Buenos();
          
    }
    
    public String nombreRango2Buenos(){
        if(buenos.contains("Gambit")==false)
            return "Gambit";
        if(buenos.contains("Spider girl")==false)
            return "Spider girl";
        if(buenos.contains("Storm")==false)
            return "Storm";
        if(buenos.contains("iceberg")==false)
            return "iceberg";
         if(buenos.contains("phoenix")==false)
            return "phoenix";
        if(buenos.contains("elektra")==false)
            return "elektra";
        if(buenos.contains("nightcrawler")==false)
            return "nightcrawler";
        if(buenos.contains("dr.strange")==false)
            return "dr.strange";
        return null;
    }
    
    public String nombreRango2Malos(){
        if(malos.contains("Electro")==false)
            return "Electro";
        if(malos.contains("Sentinel")==false)
            return "Sentinel";
        if(malos.contains("Viper")==false)
            return "Viper";
        if(malos.contains("sandman")==false)
            return "sandman";
         if(malos.contains("ultron")==false)
            return "ultron";
        if(malos.contains("Sentinel 2")==false)
            return "Sentinel 2";
        if(malos.contains("mr.sinester")==false)
            return "mr.sinester";
        if(malos.contains("leader")==false)
            return "leader";
        
        return null;
    }
    
    public void rellenarRango2Malos(){
        boolean random= rand.nextBoolean();
            int fil;
            if(random)
                fil=3;
            else
                fil=2;
           int col= rand.nextInt(10);
           String nombre=nombreRango2Malos();
            if(nombre==null){
                return;
            }
            if(fichas[fil][col]==null){
                fichas[fil][col]= new Rango2("malo",nombre);
                malos.add(nombre);
             }
                rellenarRango2Malos();

    }
    
    
    
    
    public boolean rellenarRango1(int fila,int col,String caracteristica){
        if(caracteristica.equalsIgnoreCase("bueno")){
            if(buenos.contains("BlackWidow")==false){
                    fichas[fila][col]=new Rango1(caracteristica);
                    buenos.add("BlackWidow");
                    return true;
            }
        }
        else{
            if(malos.contains("BlackWidow")==false){
                    fichas[fila][col]=new Rango1(caracteristica);
                    malos.add("BlackWidow");
                    return true;
            }   
        }
        return false;
    }
    
    public boolean rellenarRango3(int fila,int col,String caracteristica){
        if(caracteristica.equalsIgnoreCase("bueno")){
            String nombre=nombreRango3Buenos();
            if(nombre!=null){
               fichas[fila][col]=new Rango3(caracteristica,nombre);
               buenos.add(nombre);
               return true; 
            }
        }
        else{
            String nombre=nombreRango3Malos();
            if(nombre!=null){
               fichas[fila][col]=new Rango3(caracteristica,nombre);
               malos.add(nombre);
               return true; 
            } 
        }
        return false;
    }
    public String nombreRango3Buenos(){
        if(buenos.contains("Emma Frost")==false)
            return "Emma Frost";
        if(buenos.contains("She Hulk")==false)
            return "She Hulk";
        if(buenos.contains("Ant-Man")==false)
            return "Ant-Man";
        if(buenos.contains("Beast")==false)
            return "Beast";
        if(buenos.contains("Colosus")==false)
            return "Colosus";
        return null;
    }
    
    public String nombreRango3Malos(){
        if(malos.contains("Lizard")==false)
            return "Lizard";
        if(malos.contains("Mole Man")==false)
            return "Mole Man";
        if(malos.contains("Carnage")==false)
            return "Carnage";
        if(malos.contains("Rhino")==false)
            return "Rhino";
        if(malos.contains("Juggernaut")==false)
            return "Juggernaut";
        return null;
    }
    
    public boolean rellenarRango4(int fila,int col,String caracteristica){
        if(caracteristica.equalsIgnoreCase("bueno")){
            String nombre=nombreRango4Buenos();
            if(nombre!=null){
               fichas[fila][col]=new Rango4(caracteristica,nombre);
               buenos.add(nombre);
               return true; 
            }
        }
        else{
            String nombre=nombreRango4Malos();
            if(nombre!=null){
               fichas[fila][col]=new Rango4(caracteristica,nombre);
               malos.add(nombre);
               return true; 
            }
        }
        return false;
    }
    public String nombreRango4Buenos(){
        if(buenos.contains("Punisher")==false)
            return "Punisher";
       if(buenos.contains("Blade")==false)
            return "Blade";
        if(buenos.contains("Thing")==false)
            return "Thing";
        if(buenos.contains("ghost rider")==false)
            return "ghost rider";
        return null;
    }
    public String nombreRango4Malos(){
      if(malos.contains("sabretooth")==false)
            return "sabretooth";
        if(malos.contains("Black cat")==false)
            return "Black cat";
        if(malos.contains("Thanos")==false)
            return "Thanos";
        if(malos.contains("abomination")==false)
            return "abomination";
        
        return null;
    
    
    }
    public boolean rellenarRango5(int fila,int col,String caracteristica){
        if(caracteristica.equalsIgnoreCase("bueno")){
            String nombre=nombreRango5Buenos();
            if(nombre!=null){
               fichas[fila][col]=new Rango5(caracteristica,nombre);
               buenos.add(nombre);
               return true; 
            }
        }
        else{
            String nombre=nombreRango5Malos();
            if(nombre!=null){
               fichas[fila][col]=new Rango5(caracteristica,nombre);
               malos.add(nombre);
               return true; 
            }
        }
        return false;
    }
    public String nombreRango5Buenos(){
        if(buenos.contains("invisible woman")==false)
            return "invisible woman";
        if(buenos.contains("cyclops")==false)
            return "cyclops";
        if(buenos.contains("human torch")==false)
            return "human torch";
        if(buenos.contains("thor")==false)
            return "thor";
        return null;
    }
    public String nombreRango5Malos(){
      if(malos.contains("deadpool")==false)
            return "deadpool";
        if(malos.contains("dr. octopus")==false)
            return "dr. octopus";
        if(malos.contains("mysterie")==false)
            return "mysterie";
        if(malos.contains("mystique")==false)
            return "mystique";
        
        return null;
    
    
    }
    public boolean rellenarRango6(int fila,int col,String caracteristica){
        if(caracteristica.equalsIgnoreCase("bueno")){
            String nombre=nombreRango6Buenos();
            if(nombre!=null){
               fichas[fila][col]=new Rango6(caracteristica,nombre);
               buenos.add(nombre);
               return true; 
            }
        }
        else{
            String nombre=nombreRango6Malos();
            if(nombre!=null){
               fichas[fila][col]=new Rango6(caracteristica,nombre);
               malos.add(nombre);
               return true; 
            }
        }
        return false;
    }
    public String nombreRango6Buenos(){
        if(buenos.contains("Iron man")==false)
            return "Iron man";
        if(buenos.contains("Hulk")==false)
            return "Hulk";
        if(buenos.contains("Silver surfer")==false)
            return "Silver surfer";
        if(buenos.contains("Daredevil")==false)
            return "Daredevil";
        return null;
    }
    public String nombreRango6Malos(){
      if(malos.contains("Red skull")==false)
            return "Red skull";
        if(malos.contains("onslaught")==false)
            return "onslaught";
        if(malos.contains("omega red")==false)
            return "omega red";
        if(malos.contains("bullseye")==false)
            return "bullseye";
        
        return null;
    
    
    }
      public boolean rellenarRango7(int fila,int col,String caracteristica){
        if(caracteristica.equalsIgnoreCase("bueno")){
            String nombre=nombreRango7Buenos();
            if(nombre!=null){
               fichas[fila][col]=new Rango7(caracteristica,nombre);
               buenos.add(nombre);
               return true; 
            }
        }
        else{
            String nombre=nombreRango7Malos();
            if(nombre!=null){
               fichas[fila][col]=new Rango7(caracteristica,nombre);
               malos.add(nombre);
               return true; 
            }
        }
        return false;
    }
    public String nombreRango7Buenos(){
        if(buenos.contains("hammer")==false)
            return "hammer";
        if(buenos.contains("spiderman")==false)
            return "spiderman";
        if(buenos.contains("wolverine")==false)
            return "wolverine";
       
        return null;
    }
    public String nombreRango7Malos(){
      if(malos.contains("venom")==false)
            return "venom";
        if(malos.contains("green goblin")==false)
            return "green goblin";
        if(malos.contains("apocalypse")==false)
            return "apocalypse";
        
        
        return null;
    
    
}
 public boolean rellenarRango8(int fila,int col,String caracteristica){
        if(caracteristica.equalsIgnoreCase("bueno")){
            String nombre=nombreRango8Buenos();
            if(nombre!=null){
               fichas[fila][col]=new Rango8(caracteristica,nombre);
               buenos.add(nombre);
               return true; 
            }
        }
        else{
            String nombre=nombreRango8Malos();
            if(nombre!=null){
               fichas[fila][col]=new Rango8(caracteristica,nombre);
               malos.add(nombre);
               return true; 
            }
        }
        return false;
    }
    public String nombreRango8Buenos(){
        if(buenos.contains("professor x")==false)
            return "professor x";
        if(buenos.contains("nick fury")==false)
            return "nick fury";
       
        return null;
    }
    public String nombreRango8Malos(){
      if(malos.contains("kingpin")==false)
            return "kingpin";
      if(malos.contains("magneto")==false)
            return "magneto";
        return null;
    }
        
      public void RellenarPiezasFaltantes(){
       
        //buenos
        for(int fila=6; fila< fichas.length;fila++){
            for(int col=0;col<10;col++){
            
                if(fichas[fila][col]==null){
                    randomFicha(fila,col,"bueno");}
            }
        
        }
        
        //malos
         for(int fila=0; fila< 4;fila++){
            for(int col=0;col<10;col++){
            
                if(fichas[fila][col]==null){
                    randomFicha(fila,col,"malo");}
            }
        
        }

    }
    //true
    public void randomFicha(int fila,int col,String caracteristica){
        boolean resp;
        do{
        int opc=rand.nextInt(7)+1;
        switch(opc){

            case 1:
                resp=rellenarRango1(fila,col,caracteristica);
            break;
            case 2:
                resp=rellenarRango3(fila,col,caracteristica);
            break;
            case 3:
                resp=rellenarRango4(fila,col,caracteristica);
            break;
            case 4:
                resp=rellenarRango5(fila,col,caracteristica);
            break;
            case 5:
                resp=rellenarRango6(fila,col,caracteristica);
            break;
            case 6:
                resp=rellenarRango7(fila,col,caracteristica);
            break;
            default:
                resp=rellenarRango8(fila,col,caracteristica);
            break;
        }}while(resp==false);

            
    }
    
    
}









