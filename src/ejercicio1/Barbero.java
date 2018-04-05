/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.Random;

/**
 *
 * @author masanchezdm
 */
public class Barbero extends Thread{
    Barberia barberia;
    int primero = 0;
    int ultimo = barberia.clientes.length;

    
    public Barbero(Barberia b){        
        barberia = b;
    }
    
    public void atender(){
        int contador = 0;
        int longi = barberia.clientes.length;
        while(!barberia.empty()){
            while(primero != longi-1 && contador < 2)
                if(barberia.clientes[primero].tipo == 2){
                    System.out.println("Atendiendo especial  "+ barberia.clientes[primero].id);
                    primero ++;
                    ultimo = (ultimo + 1 + longi) % longi;
                }
            primero = (primero +1 + longi) %longi; 
        }
            
    }
    
}
