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
public class Estadisticas {
    private int numero_invocacion=0;
    private double sumatoria_intento=0;
    
    public void setResultadoFinalTablero(int intentos){
        this.sumatoria_intento+=intentos;
        this.numero_invocacion++;
    }
    
    private double getPromedio(){
        return this.sumatoria_intento/this.numero_invocacion;
    }
    
    public void Impresion(){
        System.out.println("/*****************************************/");
        System.out.println("/*****    Resultado              *********/");
        System.out.println("/***** Numero intentos:  "+this.numero_invocacion+"     *********/");
        System.out.println("/***** Promedio disparos:  "+this.getPromedio()+"    *********/");
        System.out.println("/*****************************************/");
    }
}
