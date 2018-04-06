///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package ejercicio1;
//
///**
// *
// * @author masanchezdm
// */
//public class Barberia {
//    
//    public Cliente [] clientes;
//    public int primero = 0;
//    public int ultimo = 0;
//    private int longi;
//    
//    public Barberia(int n){
//        this.clientes = new Cliente[n];
//        this.longi = n;
//        
//    }
//
//    public int getPrimero() {
//        return primero;
//    }
//
//    public void setPrimero() {
//        this.primero = (primero + 1 + longi) % longi;
//    }
//
//    public int getUltimo() {
//        return ultimo;
//    }
//
//    public void setUltimo() {
//        this.ultimo = (ultimo + 1 + longi) % longi;
//    }
//    
//    public synchronized void sentar(Cliente c){
//        for(int i= 0; i < this.clientes.length; i++){
//            if(clientes[i] != null){
//                clientes[i] = c;
//                this.ultimo = i;
//                return;
//            }           
//        }
//    }    
//    
//    public void atentido(int cliente){
//        this.clientes[cliente] = null;
//    }
//    
//    public boolean empty(){
//        for(int i = 0; i < this.clientes.length; i++){
//            if(this.clientes[i] != null)
//                return false;
//        }
//        return true;
//    }
//    
//}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.Random;

/**
 *
 * @author Adriana
 */
public class Barberia {  

    public int sillas =  new Random().nextInt(15)+ 5;
    private int ocupadas = 0;
    public  Cliente[] especiales = new Cliente[sillas];
    public  Cliente[]  regulares = new Cliente[sillas];
    public int primero = 0;
    public int ultimo = 0;    
    private int longi;
    
    public int getPrimero() {
        return primero;
    }

    public void setPrimero() {
        this.primero = (primero + 1 + longi) % longi;
    }

    public int getUltimo() {
        return ultimo;
    }

    public void setUltimo() {
        this.ultimo = (ultimo + 1 + longi) % longi;
    }
    
    public synchronized void sentar(Cliente c){
        if(ocupadas != sillas){
            if(c.tipo == 1){
                regulares[ultimo] = (c);
                setUltimo();
            }else{
                especiales[ultimo] = (c);
                setUltimo();
            }
        }            
    }
    public Cliente atender_especial(){
        Cliente c = especiales[primero];
        setPrimero();
        return c;
    }
    
    public Cliente atender(){
        Cliente c = regulares[primero];
        setPrimero();
        return c;
    }
    
    public boolean empy(){
        return primero == ultimo;
    }
        
}
