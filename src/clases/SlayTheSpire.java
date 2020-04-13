/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.*;


/**
 *
 * @author hanzor
 */
public class SlayTheSpire {

    /**
     * @param args the command line arguments
     */
    
    //TIPOS DE MONSTRUOS
    static String[] Monstruo = {"Spirit","Eyebrow","Sorceress","Cyborg","Witcher"};    
    static Batalla batalla = new Batalla();
    static boolean turno;
    static Entidad jugador;
    static Entidad[] monstruo;
    static Thread thread;
    
    public static void main(String[] args) throws IOException, Exception {

        batalla.reproducir("intro");
        int x = 0;
        jugador = cargarBaraja(new Entidad("Jugador"));
        jugador.setEstamina(3);
        String[] img;
        //Generamos un número aleatoreo
        for(int i = 0;i < 100; i++) 
            x = (int) (Math.random()*101);
       //Si nuestro número es mayor a 50, entonces habrá 2 rivales, sino, solo 1;
       if(x > 50){
           img = new String[3];
           monstruo = new Entidad[2];
           jugador.ajustarVida((float) 1.75);
           for(int i = 0;i < monstruo.length; i++){
               monstruo[i] = cargarBaraja(new Entidad("Monstruo"));
               img[i+1] = monstruo[i].getImagen();
           }
       }else{
           img = new String[2];
           monstruo = new Entidad[1];
           monstruo[0] = cargarBaraja(new Entidad("Monstruo"));
           img[1] = monstruo[0].getImagen();
       }
       img[0] = "jugador";
       //pantalla de entrada, esto lanza un JFrame con un gif
       gif(null, "", "","", false,null,0);
       if(x > 50){
           gif(img, "", "","¡¡ "+monstruo[0].getNombre()+" & "+monstruo[1].getNombre()+" entran al combate !!",true,new Entidad[] {jugador, monstruo[0],monstruo[1]},0);
       }else
           gif(img, "", "","¡¡ "+monstruo[0].getNombre()+" entra al combate !!",true,new Entidad[] {jugador, monstruo[0]},0);
      
       boolean victoria = false;
       //true para el jugador, false para los rivales
       turno = true;
       /*do{
            if(turno){
            
           //gif(new String[]{"inicio"}, "¡Hasta la", "proxima, novato!","", false, null,0);
           }else if(!turno){
                  
            }
            turno = !turno;
            jugador.setEstamina(3);
            if(!jugador.conVida())
                gif(new String[] {"inicio"}, "¡Hasta la", "proxima, novato!","DERROTA", false, null,-1);
            else{
                if (x > 50){
                    if (!monstruo[0].conVida() && !monstruo[1].conVida())
                        victoria = true;
                }else{
                    if (!monstruo[0].conVida())
                        victoria = true;
                }
            }
            if(victoria)
                gif(new String[] {"final"}, "Tú ganas, nos", "volveremos a ver...","VICTORIA", false, null,-1);
       }while(jugador.conVida() && !victoria);
        */
    }
    
    //Este metodo abre un JFRAME con una imagen y un texto de combate
    //Siendo solo consola sería aburrido, pero todo el juego se desenvuelve en la
    //consola.
    public static void gif(String[] image, String a, String b,String c,boolean change, Entidad[] e, int i) throws Exception{
        batalla.setVisible(false);
        if (e != null) {
            batalla.setEntidad(e);
            batalla.nombre(e);
            batalla.setMano(e[0].getMano());
        }
        if (image == null) {
            batalla.setVisible(true);
        }
        batalla.setFondo(image);
        batalla.pack();
        batalla.setResizable(false);
        batalla.setVisible(true);
        Runnable task = () -> {
            for (int x = 0; x < a.length(); x++) {
                try {
                    batalla.setMensaje(a.substring(0, x + 1), "", "", change);
                    Thread.sleep(70);
                } catch (Exception ex) {
                }
            }
            for (int x = 0; x < b.length(); x++) {
                try {
                    batalla.setMensaje("", b.substring(0, x + 1), "", change);
                    Thread.sleep(70);
                } catch (Exception ex) {
                }
            }
            for (int x = 0; x < c.length(); x++) {
                try {
                    batalla.setMensaje("", "", c.substring(0, x + 1), change);
                    Thread.sleep(20);
                } catch (Exception ex) {
                }
            }
            batalla.task = false;
        };

        if (image != null) {
            try {
                thread.stop();
            } catch (Exception ex) {

            }
            thread = new Thread(task);
            thread.start();
        }

    }
    
    public static Entidad cargarBaraja(Entidad entidad) {
        try {
            String baraja[] = new String[n()];
            int i = 0;
            File Cartas = new File("Cartas.in.txt");
            Scanner sc = new Scanner(Cartas);
            while (sc.hasNextLine() && i < n()) {
              baraja[i] = sc.nextLine();         
              i++;
            }
            //Eliminamos el ultimo elemento del Array, por lo general,
            //este seria un "\n" en el archivo
            if(!baraja[baraja.length-1].contains("/"))
                 baraja = Arrays.copyOfRange(baraja, 0, baraja.length-1);
            
            //Guardamos la baraja en la entidad
            Pila<Carta> cartas = new Pila<>();
            for (String iCarta : baraja) {
                String cartaAux[] = iCarta.split("/");
                Carta carta = new Carta();
                carta.setTipo(cartaAux[0]);
                carta.setDaño(Integer.parseInt(cartaAux[1]));
                carta.setEfecto(cartaAux[2]);
                carta.setTurnos(Integer.parseInt(cartaAux[3]));
                carta.setPlus(Integer.parseInt(cartaAux[4]));
                carta.setNombre(cartaAux[5]);
                carta.setCosto(Integer.parseInt(cartaAux[6]));
                //Apilamos la carta
                cartas.Apilar(carta);
            }
            //Actualizamos la baraja
            entidad.setCartas(cartas);
            //Actualizamos la mano
            entidad.setMano(entidad.contarMano());
            
            sc.close();
        }catch(Exception e){
            System.out.println(e);
        }finally{
             return entidad;
        }
       
    }
    
    //Este metodo cuenta la cantidad de lineas que hay en el archivo
    //nos ayudara a cargar las cartas.
    public static int n() throws Exception{
        InputStream is = new BufferedInputStream(new FileInputStream("Cartas.in.txt"));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        }finally {           
           is.close();
        }
    }
    
}
    
