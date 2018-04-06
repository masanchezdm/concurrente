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

    public static int sillas =  new Random().nextInt(15)+ 5;
    public static volatile int ocupadas = 0;
    public static volatile Cliente[] especiales = new Cliente[sillas];
    public static volatile Cliente[]  regulares = new Cliente[sillas];
    public static int primero = 0;
    public static int ultimo = 0;      
    public static int primero_e = 0;
    public static int ultimo_e = 0;
    public static int longi;
    
    public static int getPrimero() {
        return Barberia.primero;
    }

    public static void setPrimero() {
        Barberia.primero = (Barberia.primero + 1 + Barberia.longi) % Barberia.longi;
    }

    public static int getUltimo() {
        return Barberia.ultimo;
    }

    public static void setUltimo() {
        Barberia.ultimo = (Barberia.ultimo + 1 + Barberia.longi) % Barberia.longi;
    }

    public static int getPrimero_e() {
        return Barberia.primero_e;
    }

    public static void setPrimero_e() {
        Barberia.primero_e = (Barberia.primero_e + 1 + Barberia.longi) % Barberia.longi;
    }

    public static int getUltimo_e() {
        return Barberia.ultimo_e;
    }

    public static void setUltimo_e(int ultimo_e) {
        Barberia.ultimo_e = (Barberia.ultimo_e + 1 + Barberia.longi) % Barberia.longi;
    }
    
    public static boolean empy(){
        return Barberia.ocupadas == 0;
    }
    
    public static boolean hay_especiales(){
        return Barberia.especiales.length != 0;
    }
    
    public static String muestra_sillas(){
        for(int i = Barberia.primero_e; i < Barberia.ultimo_e; i = (i+ 1 + Barberia.longi))        
    }
    
    public static void main(String [] arg){
        Barbero barbero = new Barbero();
        Cliente [] todos = new Cliente[new Random().nextInt(20)+ 7];
        for(int i = 0; i < todos.length; i++){
            todos[i]= new Cliente();   
            todos[i].id = i;
        }
        barbero.start();
        for(int i = 0; i < todos.length; i++){
            todos[i].start();
        }
    }
        
}
