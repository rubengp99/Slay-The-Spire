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
public class Carta {
    private String tipo,efecto,nombre;
    private int daño, turnos, plus,costo;
    //esto define si aplica al jugador o al rival
    private boolean direccion;

    public Carta() {
        this.tipo = "";
        this.efecto = "";
        this.daño = 0;
        this.turnos = 0;
        this.plus = 0;
    }
    
    public String getNombre() {
        return nombre.toUpperCase();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTipo() {
        return tipo.toUpperCase();
    }

    public String getEfecto() {
        return efecto;
    }

    public int getDaño() {
        return daño;
    }

    public int getTurnos() {
        return turnos;
    }

    public int getPlus() {
        return plus;
    }

    public boolean getDireccion(){
        return this.direccion; 
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo.toUpperCase();
        this.setDireccion(tipo);
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto.toUpperCase();
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public void setPlus(int plus) {
        this.plus = plus;
    }
    
    public void setDireccion(String tipo){
        this.direccion = (tipo.equalsIgnoreCase("MALDICION") || tipo.equalsIgnoreCase("ATAQUE"));    
    }
    
    
    public String toString(int index){
        return index+" - "+"Carta: "+this.nombre + " - Tipo: "+this.tipo
                +"\nEfecto: "+this.efecto+" - Turnos: "+this.turnos
                +"\nEfecto por turno: "+this.plus+"pts"+" - COSTO: "+ costo
                +"\n--------------------------------------------------";  
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
   
}
