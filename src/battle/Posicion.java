/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle;

import java.util.Objects;

/**
 *
 * @author Pablo
 */
public class Posicion {
    private Integer x; //coresponde a j de segundo for
    private Integer y; //corresponde a i de primer for
    
    public Posicion(int x,int y){
        setX(x);
        setY(y);
    }
    public Posicion(){
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void Imprimir(){
        String salida="Posicion x:";
        if(Objects.isNull(x)==true){
            salida+="null";
        }
        else{
            salida+=x;
        }
        salida+=", Posicion y:";
        if(Objects.isNull(y)==true){
            salida+="null";
        }
        else{
            salida+=y;
        }
        System.out.println(salida); 
    }
}
