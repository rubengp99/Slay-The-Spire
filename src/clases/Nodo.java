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
public class Nodo<T> {
    private Nodo siguiente;
    private T valor;

    public Nodo(Nodo siguiente, T valor) {
        this.siguiente = siguiente;
        this.valor = valor;
    }    
    
    public Nodo getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public T getValor() {
        return this.valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
    
    
}
