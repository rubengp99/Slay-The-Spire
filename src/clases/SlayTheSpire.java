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

/**
 *
 * @author hanzor
 */
public class SlayTheSpire {

    /**
     * @param args the command line arguments
     */
    
    //TIPOS DE MONSTRUOS
    static String[] Monstruo = {"Espíritu","Demonio","Druida","Lobo","Brujo"};    
    
    public static void main(String[] args) throws IOException, Exception {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int x = 0;
        Entidad jugador = cargarBaraja(new Entidad("Jugador"));
        jugador.setEstamina(3);
        Entidad monstruo[] = null;
        //Generamos un número aleatoreo
        for(int i = 0;i < 100; i++) 
            x = (int) (Math.random()*101);
        
       //Si nuestro número es mayor a 50, entonces habrá 2 rivales, sino, solo 1;
       if(x > 50){
           monstruo = new Entidad[2];
           for(int i = 0;i < monstruo.length; i++){
               monstruo[i] = cargarBaraja(new Entidad("Monstruo"));
           }
       }else{
           monstruo = new Entidad[1];
           monstruo[0] = cargarBaraja(new Entidad("Monstruo"));
       }
       //pantalla de entrada, esto lanza un JFrame con un gif
       gif("inicio", "¡Preparate", "para morir!","", false,null);
       for(int i = 0; i < monstruo.length; i++)
           gif(monstruo[i].getImagen(), "", "","¡¡ "+monstruo[i].getNombre()+" entra al combate !!",true,monstruo[i]);
    
       boolean victoria = false;
       //true para el jugador, false para los rivales
       boolean turno = true;
       do{
           boolean imposible;
            if(turno){
                do{
                    imposible = false;
                    if(jugador.conVida()){
                        jugador.reponerMano();
                        jugador = jugador.getEfectos().aplicarEfectos(jugador);
                        Carta mano[] = jugador.getMano();
                        if (!imposible){
                            System.out.println("------------------------------------");
                            System.out.println("Tu turno, "+jugador.getNombre()+".\n");
                            System.out.println("Vida: "+jugador.getVida()+"/"+jugador.getMaximo());
                            System.out.println("Energía: "+jugador.getEstamina());
                            for (int i = 0; i < mano.length; i++) {
                                System.out.println(mano[i].toString(i));
                            }
                            String op;
                            do{
                                System.out.print("Escoge tu carta: ");
                                op = sc.nextLine();

                                if(!op.equals("0") && !op.equals("1") && !op.equals("2") && !op.equals("3") && !op.equals("4"))
                                    System.out.println("\nNo escogiste una carta, vuelve a intentarlo.\n");

                                if( jugador.accion(Integer.parseInt(op)).getCosto() <= jugador.getEstamina()) {
                                    jugador.setEstamina(jugador.getEstamina() - jugador.accion(Integer.parseInt(op)).getCosto());
                                }else{
                                    System.out.println("\nNo tienes suficiente energía, vuelve a intentar.\n");
                                    op = "";
                                    int c = 0;
                                    for (int i = 0; i < mano.length; i++) {
                                        if (mano[i] != null){
                                            if (mano[i].getCosto() > jugador.getEstamina())
                                                c++;
                                            }else{
                                                c++;
                                            }
                                        }
                                    
                                    if (c == 5){
                                        imposible = true;
                                    }
                                }                               
                            }while(!op.equals("0") && !op.equals("1") && !op.equals("2") && !op.equals("3") && !op.equals("4") && !imposible);
                            
                            
                            if(!imposible){
                                Carta aux = null;
                                aux = jugador.accion(Integer.parseInt(op));
                                jugador.usarCarta(Integer.parseInt(op));
                                

                                if(x > 50){
                                    if(aux.getDireccion()){
                                        System.out.println("------------------------------------");
                                        System.out.println("Ahora escoge a que monstruo atacar\n");
                                        for (int i = 0; i < monstruo.length; i++) {
                                            System.out.println(i+"- "+monstruo[i].toString());
                                        }
                                        do{
                                            System.out.print("Atacar a: ");
                                            op = sc.nextLine();
                                            if(!op.equals("0") && !op.equals("1"))
                                                System.out.println("\nNo escogiste un monstruo, vuelve a intentarlo.\n");
                                        }while(!op.equals("0") && !op.equals("1") && !imposible);

                                        int n = (int) (Math.random() * 100);
                                        if (!(n <= monstruo[Integer.parseInt(op)].getDestreza())){
                                            monstruo[Integer.parseInt(op)].setVida(monstruo[Integer.parseInt(op)].getVida() - aux.getDaño());
                                            if(!aux.getEfecto().equalsIgnoreCase("NINGUNO"))
                                                monstruo[Integer.parseInt(op)].getEfectos().Insertar(new Efecto(aux.getEfecto(),aux.getDaño(),aux.getTurnos()));
                                            gif(jugador.getImagen(), "", "",jugador.dialogar(aux,monstruo[Integer.parseInt(op)].getNombre()),true,jugador);
                                        }else{
                                            gif(jugador.getImagen(), "", "","Vaya.../Tu ataque fue bloqueado.",true,jugador);
                                        } 
                                    }else{
                                        if(!aux.getEfecto().equalsIgnoreCase("NINGUNO"))
                                                jugador.getEfectos().Insertar(new Efecto(aux.getEfecto(),aux.getDaño(),aux.getTurnos()));
                                        gif(jugador.getImagen(), "", "",jugador.dialogar(aux,"Jugador"),true,jugador);
                                    }
                                }else{
                                    if(aux.getDireccion()){
                                        int n = (int) (Math.random() * 100);
                                        if (!(n <= monstruo[0].getDestreza())){
                                            monstruo[0].setVida(monstruo[0].getVida() - aux.getDaño());
                                            if(!aux.getEfecto().equalsIgnoreCase("NINGUNO"))
                                                monstruo[0].getEfectos().Insertar(new Efecto(aux.getEfecto(),aux.getDaño(),aux.getTurnos()));
                                            gif(jugador.getImagen(), "", "",jugador.dialogar(aux, monstruo[0].getNombre()),true,jugador);
                                        }else if(!imposible){
                                            gif(jugador.getImagen(), "", "","Vaya.../Tu ataque fue bloqueado.",true,jugador);
                                        } 
                                    }else{
                                        if(!aux.getEfecto().equalsIgnoreCase("NINGUNO"))
                                                jugador.getEfectos().Insertar(new Efecto(aux.getEfecto(),aux.getDaño(),aux.getTurnos()));
                                        gif(jugador.getImagen(), "", "",jugador.dialogar(aux,"Jugador"),true,jugador);
                                    }
                                }
                            }
                        }else{
                            gif("inicio", "¡Hasta la", "proxima, novato!","", false, null);
                        }
                    }   
                }while(jugador.getEstamina() > 0 && !imposible);
           }else if(!turno){
                int n = (int)(Math.random() * 5);
                    
                for (int i = 0; i < monstruo.length; i++) {
                    try{
                        monstruo[i] = monstruo[i].getEfectos().aplicarEfectos(monstruo[i]);
                        //generamos una jugada al alzar para el monstruo
                        for (int j = 0; j < 77; j++)
                            n = (int)(Math.random() * 5); 

                        
                        Carta aux = monstruo[i].accion(n);
                        if(aux.getDireccion()){
                            int bloq = (int) (Math.random() * 100);
                            if (!(bloq <= jugador.getDestreza())){
                                jugador.setVida(jugador.getVida() - aux.getDaño());
                                if(!aux.getEfecto().equalsIgnoreCase("NINGUNO"))
                                    jugador.getEfectos().Insertar(new Efecto(aux.getEfecto(),aux.getDaño(),aux.getTurnos()));
                                    
                                gif(monstruo[i].getImagen(), "", "",monstruo[i].dialogar(aux,"Jugador"),true,monstruo[i]);
                            }else{
                                gif(monstruo[i].getImagen(), "", "","Vaya.../Tu ataque fue bloqueado.",true,monstruo[i]);
                            } 
                        }else{
                            if(!aux.getEfecto().equalsIgnoreCase("NINGUNO"))
                                monstruo[i].getEfectos().Insertar(new Efecto(aux.getEfecto(),aux.getDaño(),aux.getTurnos()));
                                
                            gif(monstruo[i].getImagen(), "", "",monstruo[i].dialogar(aux,monstruo[i].getNombre()),true,monstruo[i]);
                        }
                        
                        monstruo[i].usarCarta(n);
                        monstruo[i].reponerMano();

                    }catch(Exception e){
                        throw e;
                    }        
                }  
            }
            turno = !turno;
            jugador.setEstamina(3);
            if(!jugador.conVida())
                gif("inicio", "¡Hasta la", "proxima, novato!","DERROTA", false, null);
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
                gif("final", "Tú ganas, nos", "volveremos a ver...","VICTORIA", false, null);
       }while(jugador.conVida() && !victoria);
        
    }
    
    //Este metodo abre un JFRAME con una imagen y un texto de combate
    //Siendo solo consola sería aburrido, pero todo el juego se desenvuelve en la
    //consola.
    public static void gif(String image, String a, String b,String c,boolean change, Entidad e) throws Exception{
        Gifs gif = new Gifs();
        if(e != null){
            gif.setEntidad(e);
            gif.nombre(e.getNombre());
        }
        gif.setFondo(image+".gif");
        gif.pack();
        gif.setResizable(false);
        gif.setVisible(true);
        gif.setMensaje(a,b,c,change);      
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
    
