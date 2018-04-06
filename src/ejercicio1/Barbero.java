///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package ejercicio1;
//
//import java.util.Random;
//
///**
// *
// * @author masanchezdm
// */
//public class Barbero extends Thread{
//    Barberia barberia;
//    
//    public Barbero(Barberia b){        
//        barberia = b;
//    }
//    
//    public void atender() throws InterruptedException{
//        int contador = 0;
//        int longi = barberia.clientes.length;
//        while(!barberia.empty()){
//            int num_silla = barberia.getPrimero();
//            while(num_silla != barberia.getUltimo() && contador < 2 && barberia.clientes[num_silla]!= null){
//                if(barberia.clientes[num_silla].tipo == 2){
//                    System.out.println("Atendiendo especial  "+ barberia.clientes[num_silla].id);    
//                    barberia.atentido(num_silla);
//                }
//                num_silla = (num_silla + 1 + longi) % longi;
//            }
//            if(barberia.clientes[barberia.getPrimero()] != null){
//                System.out.println("Atendiendo  "+ barberia.clientes[num_silla].id);
//            }
//            barberia.setPrimero();
//            barberia.setUltimo();
//        }
//        while(barberia.empty()){
//            Thread.sleep(1000);
//        }
//            
//    }
//     //en run debe estar todo el tiempo atendiendo y haciendo que cliente intente sentarse en barberia.
//    
//}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adriana
 */
public class Barbero extends Thread{

    public synchronized Cliente atender_especial(){
        Cliente c = Barberia.especiales[Barberia.primero_e];
        Barberia.setPrimero();
        Barberia.ocupadas--;
        notifyAll();
        return c;
    }
    
    public synchronized Cliente atender_regular() throws InterruptedException{
        Cliente c = Barberia.regulares[Barberia.primero];
        Barberia.setPrimero();
        Barberia.ocupadas--;
        notifyAll();
        return c;
    }
    
    public void atender() throws InterruptedException{
        if(!Barberia.empy()){
            int especiales = 0;
            if(Barberia.hay_especiales()){
                while(especiales <= 2){
                    this.atender_especial();
                    especiales++;
                }
            }else{
                this.atender_regular();
            }
            Thread.sleep(1000);
        }else{
            wait();
        }
    }
    
    @Override
    public void run(){
        while(true){
            try {
                this.atender();
            } catch (InterruptedException ex) {
                Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
