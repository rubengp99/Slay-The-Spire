/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Random;
/**
 *
 * @author hanzor
 */
public class Entidad {
    private String tipo,imagen,nombre;
    private float vida,maximo;
    private int fuerza, desteza,estamina;
    private Carta mano[];
     //No, no es una nativa, es una clase genérica de Pila.
    private Pila<Carta> cartas;
    private Lista<Efecto> efectos;
    
    private int n;
    
    public Entidad(String tipo){
        //Este random es para escoger el nombre y la imagen del monstruo
        //Si la entidad es de tipo Jugador, estos valores se asignan, mas no se usan
        for(int i = 0; i < 100; i++ ) this.n = (int) (Math.random() * 5);
        
        this.nombre  = (tipo.equals("Jugador")) ? "Jugador" : SlayTheSpire.Monstruo[n];
        this.vida = (tipo.equals("Jugador")) ? 80 : (int) ((Math.random() * (150 - 80)) + 80);
        this.tipo = tipo;
        this.fuerza = 0;
        this.desteza = 0;
        this.maximo = this.vida;
        this.mano = new Carta[5];
        this.imagen = Imagen(tipo);
        this.cartas = new Pila<>();
        this.efectos = new Lista<>();
        this.estamina = 1;
    }
    
    public String Imagen(String tipo){
        Random r = new Random();
        if(tipo.equalsIgnoreCase("Jugador"))
            return "jugador";
        else
            return "monstruo"+n;
    }
    
    public String getImagen(){
        return this.imagen;
    }
    
    public void setNombre(String s){
        this.nombre = s;
    }
    
    public String getNombre(){
        return this.nombre;
    }

    public float getVida() {
        return vida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public void setVida(float vida) {
        float daño = Math.abs(vida - this.vida);
        
        if(this.nombre.contains("dmgT++"))
            daño *= 1.25;
        
        this.vida = this.vida - daño;
    }

    public float getMaximo() {
        return maximo;
    }

    public void setMaximo(float maximo) {
        this.maximo = maximo;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDestreza() {
        return desteza;
    }

    public void setDestreza(int desteza) {
        this.desteza = desteza;
    }

    public Carta[] getMano() {
        return mano;
    }
    
    public int contarMano() {
        int i = 0;
        for (int j = 0; j < this.mano.length; j++) {
            mano[i] = null;
            i++;
        }
        return i;
    }

    public void setMano(int faltantes) {
        Pila<Carta> manoAux = this.getCartas();
        for (int j = 0; j < faltantes; j++) {
            if(this.mano[j] == null){
                mano[j] = manoAux.Desapilar();
            }
            //Actualizamos la baraja
            this.setCartas(manoAux);
        }
    }

    public Pila<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(Pila<Carta> cartas) {
        this.cartas = cartas;
    }
    
    public boolean conVida(){
        return (this.vida > 0);
    }

    public int getEstamina() {
        return estamina;
    }

    
    public void setEstamina(int estamina) {
        this.estamina = estamina;
    }
    
    public Carta accion(int i){
        return this.mano[i];
    }

    public Lista<Efecto> getEfectos() {
        return efectos;
    }

    public void setEfecto(Efecto e) {
        this.efectos.Insertar(e);
    }
    
    public void reponerMano(){
        for (int i = 0; i < mano.length; i++) {
            if(mano[i] == null){
                mano[i] = cartas.Desapilar();
            }
        }
    }
    
    public void usarCarta(int i){
        mano[i] = null;
    }
    
    public String dialogar(Carta jugadas,String s){
        String dialogos = "";
        boolean turnos = (jugadas.getTurnos() > 0);
        String vs = "contra "+s.split(" ")[0];
        if(jugadas.getDireccion()) 
            dialogos = "¡¡ ha usado "+ jugadas.getNombre() 
                            + " "+vs+", daño de "+ jugadas.getDaño() + "pts" 
                            +((turnos)? " por "+ jugadas.getTurnos() +" turnos": "")+" !!";
        else
            dialogos = "¡¡ ha usado "+ jugadas.getNombre() 
                        + ", obtiene un beneficio de "+ jugadas.getPlus() + "pts" 
                        + ((turnos)? " por "+ jugadas.getTurnos() +" turnos" : "")+" !!";
        
        return dialogos;
    }
    
    @Override
    public String toString(){
        return nombre + " - " + vida + "/" + maximo +"HP";
    }

}
