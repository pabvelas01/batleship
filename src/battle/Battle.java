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
        Tablero t=new Tablero(N);
        TableroRecorrido tableroAux=new TableroRecorrido(N);
        BarcoGenerico portaAviones= new BarcoGenerico(5,'A');
        BarcoGenerico buque= new BarcoGenerico(4,'B');
        BarcoGenerico submarino= new BarcoGenerico(3,'S');
        BarcoGenerico crucero= new BarcoGenerico(3,'C');
        BarcoGenerico destructor= new BarcoGenerico(2,'C');
        t.Imprimir();
        System.out.println("/****************/");
        for(int i=0;i<100;i++){
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
            
            System.out.println(t.ganar());
        }
        
        
        t.Imprimir();
        tableroAux.Imprimir();
    }
    
}
