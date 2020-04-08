/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author hanzor
 */

//La T indica que es genérico, es decir, aquí normalmente iría la clase de los valores
//Para este proyecto la T tendría valor "Carta" o "Entidad"
public class Pila<T> {
    private Nodo top;
    private Nodo uTop;
    
    public Pila(){
        this.top = null;
    }
    
    public void Apilar(T valor){
        Nodo<T> temp = new Nodo<>(top, valor);
        this.top = temp;
    }
    
    public T Desapilar(){
        Nodo<T> temp = null;
        
        if (Vacia()){
            return null;
        }else{
            temp = top;
            Nodo<T> aux = top.getSiguiente();
            top = null;
            top = aux;
            return temp.getValor();
        }
    }
    
    public boolean Vacia(){
        return (top == null);
    }
    
    
    //Este método solo tiene utilidad si es para contar la pila
    //que contiene la mano de la entidad.
    public int Contar(){
        Nodo aux = top;
        int i = 6;
        while(aux != null){
            i--;
            aux = aux.getSiguiente();
        }
        
        return i;
    }
    
}
