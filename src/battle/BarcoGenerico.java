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
    private ArrayList<Posicion> posicionesBarco=new ArrayList<>();
    private ArrayList<Posicion> posicionesVisitadasFuturas=new ArrayList<>();
    private char letra;
    
    public BarcoGenerico(int largoCasillas,char letra){
        this.largo_casillas=largoCasillas;
        this.letra=letra;
    }
    
    public boolean estaCompletado(){
        if(largo_casillas==posicionesBarco.size()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void setPosicion(int x,int y){
        Posicion p=new Posicion(x, y);
        posicionesBarco.add(p);
    }
    public Posicion getPosicionNuevaModoHunter(TableroRecorrido t){
        if(this.estaCompletado()==false){
            Posicion ultimoDisparo=posicionesBarco.get(posicionesBarco.size()-1);
            int N=t.getN();
            Posicion aux;
            if(ultimoDisparo.getX()+1<N && t.getPosicionXY(ultimoDisparo.getX()+1, ultimoDisparo.getY())=='0'){ //abajo
                return aux=new Posicion(ultimoDisparo.getX()+1, ultimoDisparo.getY());
            }
            if(ultimoDisparo.getX()-1>=0 && t.getPosicionXY(ultimoDisparo.getX()-1, ultimoDisparo.getY())=='0'){ //arriba
                return aux=new Posicion(ultimoDisparo.getX()-1, ultimoDisparo.getY());
            }
            if(ultimoDisparo.getY()+1<N && t.getPosicionXY(ultimoDisparo.getX(), ultimoDisparo.getY()+1)=='0'){ //derecha
                return aux=new Posicion(ultimoDisparo.getX(), ultimoDisparo.getY()+1);
            }
            if(ultimoDisparo.getY()-1>=0 && t.getPosicionXY(ultimoDisparo.getX(), ultimoDisparo.getY()-1)=='0'){ //IZQUIERDA
                return aux=new Posicion(ultimoDisparo.getX(), ultimoDisparo.getY()-1);
            }
        }
        System.out.println("Devolviendo null como posicion !!OJO");
        return null;
    }
}
