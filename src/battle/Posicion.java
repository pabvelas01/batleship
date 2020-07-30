/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle;

/**
 *
 * @author Pablo
 */
public class Posicion {
    private int x; //coresponde a j de segundo for
    private int y; //corresponde a i de primer for
    
    public Posicion(int x,int y){
        setX(x);
        setY(y);
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
}
