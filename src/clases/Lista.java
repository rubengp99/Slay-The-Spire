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

//LA T INDICA QUE ES GENERICO, AQUI VA EL TIPO DE DATO QUE GUARDAN LOS NODOS
public class Lista<T> {
    Nodo<T> cabeza;
    Nodo<T>  cola;
    
    public Lista(){
        cabeza = null;
        cola = null;
    }
    
    private boolean isVacia(){
        return(cabeza == null);
    }
    
    public void Insertar(T valor){
        Nodo temp = new Nodo(null, valor);
        
        if(isVacia()){
            cabeza = temp;
            cola = temp;
        }else{
            cola.setSiguiente(temp);
            cola = temp;
        }
    }
    
    public Entidad aplicarEfectos(Entidad e){
        Nodo<T> temp = cabeza;
        while(temp != null){
            Efecto ef = (Efecto) temp.getValor();
            switch(ef.getNombre().toUpperCase()){
                case "DEBILITAR":
                    if (ef.getTurnos() > 0){
                        e.setVida(e.getVida() - ef.getDaño());
                        ef.setTurnos(ef.getTurnos()-1);
                        if(!e.getNombre().contains(" (dmg--)"))
                            e.setNombre(e.getNombre() + " (dmg--)");
                    }else{
                        e.setNombre(e.getNombre().replace(" (dmg--)", ""));
                    }
                    break;
                case "VULNERABLE":
                    if (ef.getTurnos() > 0){
                        e.setVida(e.getVida() - ef.getDaño());
                        ef.setTurnos(ef.getTurnos()-1);
                        if(!e.getNombre().contains(" (dmgT++)"))
                            e.setNombre(e.getNombre() + " (dmgT++)");
                    }else{
                        e.setNombre(e.getNombre().replace(" (dmgT++)", ""));
                    }
                    break;
                case "BLOQUEO":
                    if (ef.getTurnos() > 0){
                        ef.setTurnos(ef.getTurnos()-1);
                        if(!e.getNombre().contains(" (def++)"))
                            e.setNombre(e.getNombre() + " (def++)");
                    }else{
                        e.setNombre(e.getNombre().replace(" (def++)", ""));
                    }
                    break;
                case "CURACION":
                    if (ef.getTurnos() > 0){
                        e.setVida(e.getVida() + 3);
                        ef.setTurnos(ef.getTurnos()-1);
                        if(!e.getNombre().contains(" (hp++)"))
                            e.setNombre(e.getNombre() + " (hp++)");
                    }else{
                        e.setNombre(e.getNombre().replace(" (hp++)", ""));
                    }
                    break;
                case "AVIVAR":
                    if (ef.getTurnos() > 0){
                        ef.setTurnos(ef.getTurnos()-1);
                        e.setFuerza(e.getFuerza() + ef.getDaño());
                    }
                    break;
                case "FORTALECER":
                    if (ef.getTurnos() > 0){
                        ef.setTurnos(ef.getTurnos()-1);
                        e.setDestreza(e.getDestreza()+ ef.getDaño());
                    }
                    break;
                case "AUMENTO DE ENERGIA":
                    if (ef.getTurnos() > 0){
                        ef.setTurnos(ef.getTurnos()-1);
                        e.setEstamina(e.getEstamina() + ef.getDaño());
                    }
                    break;
            }
            
            temp = temp.getSiguiente();
        }
        
        return e;
    }
}
