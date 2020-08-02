/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle;

import static battle.Tablero.generator;

/**
 *
 * @author Pablo
 */
public class TableroRecorrido {
     private char [][] t;
     private int n=10;
     private int intentos=0;
     public TableroRecorrido(int n){
         this.n=n;
         t=new char[n][n];
         for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                 t[i][j]='0';
             }
         }
     }
     
    public Posicion getNuevaPosicion(){
         int x,y;
            x = generator.nextInt(n);
            y = generator.nextInt(n);
            while(t[x][y]!='0'){
                x = generator.nextInt(n);
                y = generator.nextInt(n);
            }
            Posicion p =new Posicion(x, y);
            //setPosicionVisitada(x,y);
           // System.out.println("get nueva posicion x,y es "+x+","+y);
            return p;
         }
    
    public void setPosicionVisitada(int x,int y,char contenido){
        if(contenido=='0'){
        contenido='X';
        }
        if(contenido!='X'){
        t[x][y]=contenido;
        
        intentos++;
        }
    }
    
    public char getPosicionXY(int x,int y){
        return t[x][y];
    }
    
    public int getN(){
        return n;
    }
    
     public void Imprimir(){
        System.out.println("battle.TableroRecorrido.Imprimir()");    
        for(int i=0;i<n;i++){
        for(int j=0;j<n;j++)
        System.out.print(t[i][j] + " ");
        System.out.println("");
    }
  }
}
