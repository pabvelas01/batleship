/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle;

import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
public class BarcoGenerico {
    private int largo_casillas;
    private ArrayList<Posicion> posiciones=new ArrayList<>();
    private char letra;
    
    public BarcoGenerico(int largoCasillas,char letra){
        this.largo_casillas=largoCasillas;
        this.letra=letra;
    }
    
    public boolean estaCompletado(){
        if(largo_casillas==posiciones.size()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void setPosicion(int x,int y){
        Posicion p=new Posicion(x, y);
        posiciones.add(p);
    }
}
