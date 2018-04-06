/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author masanchezdm
 */
public class Cliente extends Thread {
    int tipo = new Random().nextInt(2)+ 1;
    int id;
    
    
    public synchronized void sentar() throws InterruptedException{
        System.out.println("entro  " + this.toString());
        if(Barberia.ocupadas != Barberia.sillas){
            if(this.tipo == 1){
                Barberia.regulares[Barberia.ultimo] = this;
                Barberia.setUltimo();
            }else{
                Barberia.especiales[Barberia.ultimo_e] = this;
                Barberia.setUltimo();
            }
            Barberia.ocupadas++;
            notifyAll();
        }else{
            wait();
        }            
    }
    public String toString(){
        return "Cliente "+ id + " tipo " + tipo;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                this.sentar();
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
