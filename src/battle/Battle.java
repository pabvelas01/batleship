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
             tableroAux=new TableroRecorrido(N);
             portaAviones= new BarcoGenerico(5,'A');
             buque= new BarcoGenerico(4,'B');
             submarino= new BarcoGenerico(3,'S');
             crucero= new BarcoGenerico(3,'C');
             destructor= new BarcoGenerico(2,'C');
           for(int i=0;i<100;i++){  /**Inicio de calculos de las 100 casillas 10*10**/
               Posicion p=tableroAux.getNuevaPosicion();

               char resultado=t.disparo(p.getX()+1, p.getY()+1);
               tableroAux.setPosicionVisitada(p.getX(), p.getY(),resultado);
               switch(resultado){
                   case 'A': portaAviones.setPosicion(p.getX(), p.getY());
                              break;
                   case 'B': buque.setPosicion(p.getX(), p.getY());
                               break;
                   case 'S': submarino.setPosicion(p.getX(), p.getY());
                               break;
                   case 'C': crucero.setPosicion(p.getX(), p.getY());
                               break;
                   case 'D': destructor.setPosicion(p.getX(), p.getY());
                               break;
               }

               int ganar=t.ganar();
               if(ganar!=0){
                   e.setResultadoFinalTablero(ganar);
                   System.out.println(ganar);
                   break;
               }
           }/**Fin de calculos de las 100 casillas 10*10**/
           
        } /**termino de calculos de los 100.000 jugadas**/
        e.Impresion();
    }
    
}
