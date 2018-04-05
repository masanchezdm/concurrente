/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author masanchezdm
 */
public class Barberia {
    
    Cliente [] clientes;
    
    public Barberia(int n){
        this.clientes = new Cliente[n];
        
    }
    
    public synchronized void sentar(Cliente c){
        int lugar = this.hay_silla();
        if(lugar != -1){
            this.clientes[lugar] = c;
        }
        
    }
    
    private int hay_silla(){
        for(int i = 0; i < this.clientes.length; i++ ){
            if(this.clientes[i] == null)
                return i;
        }
        return -1;
    }
    
    public boolean empty(){
        for(int i = 0; i < this.clientes.length; i++){
            if(this.clientes[i] != null)
                return false;
        }
        return true;
    }
    
}
