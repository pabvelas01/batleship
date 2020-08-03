/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Pablo
 */
public class Battle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int N=10;
        int NUMERO_JUEGOS=100000;
        Estadisticas e=new Estadisticas();
        Tablero t=new Tablero(N);
        TableroRecorrido tableroAux;
        BarcoGenerico portaAviones;
        BarcoGenerico buque;
        BarcoGenerico submarino;
        BarcoGenerico crucero;
        BarcoGenerico destructor;
        
        for (int h=0;h<NUMERO_JUEGOS;h++){ /**Inicio de calculos de los 100.000 jugadas**/
            t=new Tablero(N);
            //t.Imprimir();
             tableroAux=new TableroRecorrido(N);
             portaAviones= new BarcoGenerico(5,'A');
             buque= new BarcoGenerico(4,'B');
             submarino= new BarcoGenerico(3,'S');
             crucero= new BarcoGenerico(3,'C');
             destructor= new BarcoGenerico(2,'C');
             ArrayList<Character> pilaBarcos=new ArrayList<Character>();
             
             
           for(int i=0;i<100;i++){  /**Inicio de calculos de las 100 casillas 10*10**/
               Posicion p=new Posicion();
               char resultado='l';
               if(pilaBarcos.size()==0){
                    p=tableroAux.getNuevaPosicion();
                  //  System.out.println("mi for i="+i);
               }
               else if(pilaBarcos.size()>0){
                       char barcoEnPila=pilaBarcos.get(0);
                       switch(barcoEnPila){
                                    case 'A': 
                                      p=portaAviones.getPosicionNuevaModoHunter(tableroAux);
                                      
                                       break;
                                    case 'B': 
                                      p=buque.getPosicionNuevaModoHunter(tableroAux);
                                        break;
                                    case 'S': 
                                      p=submarino.getPosicionNuevaModoHunter(tableroAux);
                                        break;
                                    case 'C':
                                       p=crucero.getPosicionNuevaModoHunter(tableroAux);
                                        break;
                                    case 'D': 
                                       p=destructor.getPosicionNuevaModoHunter(tableroAux);
                                        break;
                       }
               }
               
               if(Objects.isNull(p)==true && pilaBarcos.size()!=0){
                    p=tableroAux.getNuevaPosicion();
               }
               
                resultado=t.disparo(p.getX()+1, p.getY()+1);
                //System.out.println(resultado);
                tableroAux.setPosicionVisitada(p.getX(), p.getY(),resultado);
             
                 switch(resultado){
                   case 'A': portaAviones.setPosicion(p.getX(), p.getY());
                             if(pilaBarcos.indexOf('A')==-1){
                                pilaBarcos.add('A');
                             }
                             if(portaAviones.estaCompletado()==true){
                                 pilaBarcos.remove(new Character('A'));
                             }
                              break;
                   case 'B': buque.setPosicion(p.getX(), p.getY());
                             if(pilaBarcos.indexOf('B')==-1){
                                pilaBarcos.add('B');
                             }
                             if(buque.estaCompletado()==true){
                                 pilaBarcos.remove(new Character('B'));
                             }
                               break;
                   case 'S': submarino.setPosicion(p.getX(), p.getY());
                             if(pilaBarcos.indexOf('S')==-1){
                                pilaBarcos.add('S');
                             }
                             if(submarino.estaCompletado()==true){
                                 pilaBarcos.remove(new Character('S'));
                             }
                               break;
                   case 'C': crucero.setPosicion(p.getX(), p.getY());
                             if(pilaBarcos.indexOf('C')==-1){
                                pilaBarcos.add('C');
                             }
                             if(crucero.estaCompletado()==true){
                                 pilaBarcos.remove(new Character('C'));
                             }
                              break;
                   case 'D': destructor.setPosicion(p.getX(), p.getY());
                             if(pilaBarcos.indexOf('D')==-1){
                                pilaBarcos.add('D');
                             }
                             if(destructor.estaCompletado()==true){
                                 pilaBarcos.remove( new  Character('D'));
                             }
                             break;
               }
          
               int ganar=t.ganar();
               if(ganar!=0){
                   e.setResultadoFinalTablero(ganar);
                   break;
               }
           }/**Fin de calculos de las 100 casillas 10*10**/
           // tableroAux.Imprimir();
        } /**termino de calculos de los 100.000 jugadas**/
       
        e.Impresion();
    }
    
}
