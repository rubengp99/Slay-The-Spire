/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static clases.SlayTheSpire.monstruo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import org.netbeans.lib.awtextra.AbsoluteLayout;
/**
 *
 * @author hanzor
 */
public class Batalla extends javax.swing.JFrame {

    /**
     * Creates new form x
     */
    
    boolean presentacion = false;
    LayoutManager layout;
    Color red = new Color(211, 48, 0);
    Carta[] mano = null;
    boolean varios = false;
    Clip clip;
    int cartaS = -1;
    int monstruoS = -1;
    boolean carta = false;
    boolean task = false;
    
    public Batalla() {
        this.layout = this.getLayout();
        initComponents();
        this.setBackground(Color.black);
        this.dmg.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/dmg--.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.dmg.setVisible(false);
        this.dmgT.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/dmgT++.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.dmgT.setVisible(false);
        this.hp.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/hp++.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.hp.setVisible(false);
        this.def.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/def++.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.def.setVisible(false);
        this.dmg1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/dmg--.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.dmg1.setVisible(false);
        this.dmgT1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/dmgT++.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.dmgT1.setVisible(false);
        this.hp1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/hp++.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.hp1.setVisible(false);
        this.def1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/def++.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.def1.setVisible(false);
        this.dmg2.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/dmg--.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.dmg2.setVisible(false);
        this.dmgT2.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/dmgT++.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.dmgT2.setVisible(false);
        this.hp2.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/hp++.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.hp2.setVisible(false);
        this.def2.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/def++.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.def2.setVisible(false);
        this.panel.setBackground(new Color(0,0,0,0));
        this.panel1.setBackground(new Color(255,255,255,0));
        this.accion.setBackground(new Color(0,0,0,0));
        this.accion.setBorder(null);
        this.panel1.setOpaque(false);
        this.historia.setOpaque(false);
        this.historia.setEditable(false);
        this.historia.setBackground(new Color(255,255,255,0));
        this.historia.setBorder(null);
        this.historia.setContentType("text/html");
        this.historia.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        this.jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.jScrollPane1.setViewportBorder(null);
        this.jScrollPane1.setBorder(null);
        this.jScrollPane1.setOpaque(false);
        this.jScrollPane1.setBackground(new Color(255,255,255,0));
        this.jScrollPane1.getViewport().setBackground(new Color(0, 0, 0, 0));
        this.jScrollPane1.getViewport().setOpaque(false);
        this.jScrollPane1.setViewportBorder(BorderFactory.createEmptyBorder());
        this.jScrollPane1.setOpaque(false);
        this.jScrollPane1.setBackground(new Color(0, 0, 0, 0));
        this.jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
        this.jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        this.jScrollPane2.setViewportBorder(null);
        this.jScrollPane2.setBorder(null);
        this.jScrollPane2.setOpaque(false);
        this.jScrollPane2.setBackground(new Color(255,255,255,0));
        this.jScrollPane2.getViewport().setBackground(new Color(0, 0, 0, 0));
        this.jScrollPane2.getViewport().setOpaque(false);
        this.jScrollPane2.setViewportBorder(BorderFactory.createEmptyBorder());
        this.jScrollPane2.setOpaque(false);
        this.jScrollPane2.setBackground(new Color(0, 0, 0, 0));
        this.jScrollPane2.setBorder(BorderFactory.createEmptyBorder());
        setLocationRelativeTo(null);
        setTitle("Slay The Spire");
        setIconImage(new ImageIcon(getClass().getResource("imagenes/icon.png")).getImage());
        this.vida.setBackground(Color.DARK_GRAY);
        this.vida.setStringPainted(true);
        this.vida.setVisible(false);   
        this.vida.setForeground(red);
        this.vida1.setBackground(Color.DARK_GRAY);
        this.vida1.setStringPainted(true);
        this.vida1.setVisible(false);
        this.vida1.setForeground(red);
        this.vida2.setBackground(Color.DARK_GRAY);
        this.vida2.setStringPainted(true);
        this.vida2.setVisible(false);
        this.vida2.setForeground(red);
        this.estamina.setBackground(Color.DARK_GRAY);
        this.estamina.setVisible(false);
        this.estamina.setStringPainted(true);
        this.estamina.setForeground(new Color(0, 211, 80));
        this.entorno.setIcon(new ImageIcon(getClass().getResource("imagenes/entorno.gif")));
        Image aux = new ImageIcon(getClass().getResource("imagenes/cartas.gif")).getImage().getScaledInstance(table.getWidth(), table.getHeight(), Image.SCALE_DEFAULT);
        this.table.setIcon(new ImageIcon(aux));
        this.separator.setBackground(Color.DARK_GRAY);
        this.seleccionA.setVisible(false);
        this.seleccionB.setVisible(false);
        HTMLEditorKit kit = new HTMLEditorKit();
        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule("html,p {background: rgba(0,0,0,0);text-align:center;font-size:50px;}");
        styleSheet.addRule("font {font-size: 16px;text-align:center;}");
        historia.setEditorKit(kit);
        this.habilidad.setVisible(false);
        this.habilidad2.setVisible(false);
        this.habilidad3.setVisible(false);
        this.ataque1.setVisible(false);
        this.ataque2.setVisible(false);
        this.ataque3.setVisible(false);
        this.daño1.setVisible(false);
        this.daño2.setVisible(false);
        this.daño3.setVisible(false);
    }
    
    public void setFondo(String[] image) throws Exception{
        try{
            if (image == null){
                presentacion = true;
                this.setLayout(null);
                this.setSize(710, 370);
                this.setPreferredSize(new Dimension(710, 370));  
                this.entorno.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/cartas.gif")).getImage().getScaledInstance(710, 370, Image.SCALE_DEFAULT)));
                this.entorno.setBounds(0, 0, 710, 370);
                this.entorno.setPreferredSize(new Dimension(710,370));
                this.entorno.repaint();
                try{
                    historia("Este proyecto ha sido desarrollado por Rubén D. García.",60, 4000);
                    historia("Puedes ver el repositorio del proyecto en github.com/rubengp99.",60, 4000);
                    historia("El material de ilustración y de audio utilizado en este proyecto no es de mi propiedad.",60,4000);
                    historia("Los créditos irán dirigidos a sus respectivos creadores.",60,4000);
                    historia("...",80,2000);
                    historia("¿Qué sería un juego sin un poco de historia?",80,3000);
                    historia("...",80,2000);
                    historia("Parece el final del mundo... No trates de recordar al sol...",60,3000);
                    historia("Estamos en una era de oscuridad...",60,3000);
                    historia("Con la aparicion de la tribu oscura, el mundo se sumergió en el caos y el terror...",60,3000);
                    historia("Gracias a los esfuerzo de los cazadores, la esperanza aún sigue viva...",60,3000);
                    historia("Tú deber es luchar contra el mal. Hoy comienza tu aventura.",60,3000);
                    historia("Ahora ve, salva al mundo. Héroe.",60,3000);
                }catch(Exception e){
                    
                }
                
                       
                this.repaint();
            }else if(image[0].contains("inicio") || image[0].contains("final")){
                this.setVisible(true);
                System.out.println(this.isVisible());
                presentacion = true;
                this.setSize(500, 300);
                Image aux = new ImageIcon(getClass().getResource("imagenes/"+image[0]+".gif")).getImage().getScaledInstance(entorno.getWidth(), entorno.getHeight(), Image.SCALE_DEFAULT);
                this.entorno.setIcon(new ImageIcon(aux));
                this.entorno.setMaximumSize(new Dimension(500, 300));
                this.entorno.setBounds(0,0, 500, 300);
                this.preparate.setBounds(10,160,190,30);
                this.entorno.repaint();
                this.morir.setBounds(40,170,290,50);
                this.setPreferredSize(new Dimension(500, 300));  
                this.repaint();
            }else{
                this.setLayout(new AbsoluteLayout());
                presentacion = false;
                this.panel1.setVisible(false);
                this.estamina.setVisible(true);
                this.reproducir("batalla");
                this.setSize(680, 565);
                this.setPreferredSize(new Dimension(680, 565));
                Image aux = new ImageIcon(getClass().getResource("imagenes/entorno.gif")).getImage().getScaledInstance(680, 300, Image.SCALE_DEFAULT);
                this.entorno.setIcon(new ImageIcon(aux));
                this.entorno.setMaximumSize(new Dimension(680, 300));
                this.entorno.setBounds(0,0, 680, 300);
                this.entorno.setPreferredSize(new Dimension(680, 300));
                this.preparate.setBounds(10,160,190,30);
                this.preparate.setText("");
                this.morir.setBounds(40,170,290,50);
                this.morir.setText("");
                this.jugador.setIcon(new ImageIcon(getClass().getResource("imagenes/"+image[0]+".gif")));
                this.jugador.setMaximumSize(new Dimension(210, 200));
                this.jugador.setSize(220,200);
                aux = new ImageIcon(getClass().getResource("imagenes/"+image[1]+".gif")).getImage().getScaledInstance(jugador2.getWidth() - 10 ,jugador2.getHeight() - 10, Image.SCALE_DEFAULT);
                this.jugador2.setIcon(new ImageIcon(aux));
                this.jugador2.setMaximumSize(new Dimension(180, 180));
                this.jugador2.setSize(180,180);
                if(image.length > 2){
                    aux = new ImageIcon(getClass().getResource("imagenes/"+image[2]+".gif")).getImage().getScaledInstance(jugador2.getWidth() - 10,jugador2.getHeight() - 10, Image.SCALE_DEFAULT);
                    this.jugador3.setIcon(new ImageIcon(aux));
                    this.jugador3.setMaximumSize(new Dimension(180, 180));
                    this.jugador3.setSize(180,180);
                }else{
                    this.setLayout(null);
                    this.jugador3.setVisible(false);
                    this.dmgT1.setVisible(false);
                    this.dmg1.setVisible(false);
                    this.def1.setVisible(false);
                    this.hp1.setVisible(false);
                    this.vida2.setVisible(false);
                    this.nombre1.setVisible(false);
                    this.daño2.setBounds(daño2.getX() + 80, daño2.getY(), 180, 210);
                    this.habilidad2.setBounds(habilidad2.getX() + 80, habilidad2.getY(), 180, 210);
                    this.seleccionB.setVisible(false);
                    this.dmg.setBounds(dmg.getX() + 80, dmg.getY(), 20, 20);
                    this.dmgT.setBounds(dmgT.getX() + 80, dmgT.getY(), 20, 20);
                    this.def.setBounds(def.getX() + 80, def.getY(), 20, 20);
                    this.hp.setBounds(hp.getX() + 80, hp.getY(), 20, 20);
                    this.vida1.setBounds(vida1.getX() + 80, vida1.getY() , 160, 20);
                    this.nombre2.setBounds(nombre2.getX() + 80, nombre2.getY(), 160, 20);
                    this.jugador2.setBounds(jugador2.getX() + 80, jugador2.getY(), 180, 180);
                    this.seleccionA.setBounds(seleccionA.getX() + 50, seleccionB.getY(), 40, 40);
                }
                aux = new ImageIcon(getClass().getResource("imagenes/seleccion.gif")).getImage().getScaledInstance( 35 , 35, Image.SCALE_DEFAULT);
                this.seleccionA.setIcon(new ImageIcon(aux));
                this.seleccionB.setIcon(new ImageIcon(aux));
            }
            this.revalidate();
            this.validate();
            this.pack();
            this.repaint();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void historia(String historia, int a, int b) throws InterruptedException{
        String f = jScrollPane2.getFont().getFamily();
        for(int i = 0; i < historia.length();i++){
            this.historia.setText("<html><p><b><font face=\""+f+"\" color=\"white\">" +historia.substring(0, i+1)+"</font></b></p></html>");
            this.historia.repaint();
            Thread.sleep(a);
        }
        Thread.sleep(b);
    }
    
    public void setMensaje(String A, String B,String C,boolean dark) throws Exception{
        try{
            if(dark){
                this.preparate.setText("");
                this.morir.setText("");
                this.vida.setVisible(true);
            }
            

            String preparate = A;
            String morir = B;
            String accion = C;
            
            for(int i = 0; i < preparate.length();i++){
                this.preparate.setText(preparate.substring(0, i+1));
                this.accion.repaint();
            }
            
            for(int i = 0; i < morir.length();i++){
                this.morir.setText(morir.substring(0, i+1));
                this.accion.repaint();
            }
            
            if(accion.equals("DERROTA")){
                this.accion.setForeground(red);
            }else if(accion.equals("VICTORIA")){
                this.accion.setForeground(Color.green);
            }
            
            this.accion.setText("");
            for(int i = 0; i < accion.length();i++){
                this.accion.setText(accion.substring(0, i+1));
                this.accion.repaint();
            }
            
             
            if(presentacion)
                this.setVisible(false);
        }catch(Exception e){
            throw e;
        }
    }
    
    public void setEntidad(Entidad[] e) throws Exception{
        this.vida.setMaximum((int) e[0].getMaximo());
        this.vida.setValue((int) e[0].getVida());
        this.estamina.setMaximum(3);
        this.estamina.setValue(e[0].getEstamina());
        this.vida1.setMaximum((int) e[1].getMaximo());
        this.vida1.setValue((int) (e[1].getVida())); 
        this.vida1.setVisible(true);
        if(e.length > 2){
            this.vida2.setMaximum((int) e[2].getMaximo());
            this.vida2.setValue((int) e[2].getVida());
            this.vida2.setVisible(true);
            this.varios = true;
        }else{
            this.seleccionA.setVisible(true);
        }
    }
    
    public void nombre(Entidad[] s){
        for (int i = 0; i < s.length; i++) {
            if(s[i].getNombre().contains("dmgT++"))
                this.dmgT.setVisible(true);
            if(s[i].getNombre().contains("hp++"))
                this.hp.setVisible(true);
            if(s[i].getNombre().contains("def++"))
                this.def.setVisible(true);
            if(s[i].getNombre().contains("dmg--"))
                this.dmg.setVisible(true);
        }
        
        nombre2.setText(s[1].getNombre().split(" ")[0]);
        
        if(s.length > 2)
            nombre1.setText(s[2].getNombre().split(" ")[0]);
        
       
    }
    
    public void setMano(Carta[] cartas){
        this.mano = cartas;
        Image aux;
        if(cartas[0] != null){
            aux = new ImageIcon(getClass().getResource("imagenes/"+cartas[0].getTipo().toLowerCase()+".jpg")).getImage().getScaledInstance( 120 , 160, Image.SCALE_SMOOTH);
            this.carta1.setIcon(new ImageIcon(aux));
            this.carta1.repaint();
            aux = new ImageIcon(getClass().getResource("imagenes/"+cartas[0].getTipo().toLowerCase()+"_carta.gif")).getImage().getScaledInstance( 100 , 85, Image.SCALE_DEFAULT);
            this.imagen1.setIcon(new ImageIcon(aux));    
            this.imagen1.repaint();
            this.cartaN1.setText(cartas[0].getNombre()); 
            this.cartaN1.repaint();
            this.beneficio1.setForeground(new Color(61,61,61));
            this.beneficio1.repaint();
            this.tipo1.setForeground(new Color(61,61,61));
            this.tipo1.repaint();
            this.cartaN1.setForeground(new Color(61,61,61));
            this.cartaN1.repaint();
            this.tipo1.setText(cartas[0].getTipo());
            this.tipo1.repaint();
            this.costo1.setText(""+cartas[0].getCosto());
            this.costo1.repaint();
            this.carta1.setVisible(true);
            this.tipo1.setVisible(true);
            this.costo1.setVisible(true);
            this.cartaN1.setVisible(true);
            this.imagen1.setVisible(true);
            this.beneficio1.setVisible(true);
            switch(cartas[0].getTipo()){
                case "PODER":
                    this.beneficio1.setForeground(new Color(255,255,255));
                    this.beneficio1.repaint();
                    this.tipo1.setForeground(new Color(255,255,255));
                    this.tipo1.repaint();
                    this.cartaN1.setForeground(new Color(255,255,255));
                    this.cartaN1.repaint();
                    switch(cartas[0].getNombre().toUpperCase()){
                        case "AGILIZAR":
                            this.beneficio1.setText("DEX +"+cartas[0].getPlus());
                            this.beneficio1.repaint();
                            break;
                        case "AVIVAR":
                            this.beneficio1.setText("STR +"+cartas[0].getPlus());
                            this.beneficio1.repaint();
                            break;
                    }
                    break;
                case "HABILIDAD":
                    this.beneficio1.setText("HP +"+cartas[0].getPlus());
                    this.beneficio1.repaint();
                    break;
                case "MALDICION":
                    this.beneficio1.setText("ATKx"+cartas[0].getTurnos()+" +"+cartas[0].getDaño());
                    this.beneficio1.repaint();
                    break;
                case "ATAQUE":
                    this.beneficio1.setText("ATK +"+cartas[0].getDaño());
                    this.beneficio1.repaint();
                    break;
            }
            this.carta1.setVisible(true);
            this.carta1.repaint();
        }else{
            this.imagen1.setVisible(false);
            this.imagen1.repaint();
            this.carta1.setVisible(false);
            this.carta1.repaint();
            this.beneficio1.setVisible(false);
            this.beneficio1.repaint();
            this.tipo1.setVisible(false);
            this.tipo1.repaint();
            this.costo1.setVisible(false);
            this.costo1.repaint();
            this.cartaN1.setVisible(false);
            this.cartaN1.repaint();
        }
        
        if(cartas[1] != null){
            aux = new ImageIcon(getClass().getResource("imagenes/"+cartas[1].getTipo().toLowerCase()+".jpg")).getImage().getScaledInstance( 120 , 160, Image.SCALE_SMOOTH);
            this.carta2.setIcon(new ImageIcon(aux));
            this.carta2.repaint();
            aux = new ImageIcon(getClass().getResource("imagenes/"+cartas[1].getTipo().toLowerCase()+"_carta.gif")).getImage().getScaledInstance( 100 , 85, Image.SCALE_DEFAULT);
            this.imagen2.setIcon(new ImageIcon(aux));    
            this.imagen2.repaint();
            this.cartaN2.setText(cartas[1].getNombre()); 
            this.cartaN2.repaint();
            this.beneficio2.setForeground(new Color(61,61,61));
            this.beneficio2.repaint();
            this.tipo2.setForeground(new Color(61,61,61));
            this.tipo2.repaint();
            this.cartaN2.setForeground(new Color(61,61,61));
            this.cartaN2.repaint();
            this.tipo2.setText(cartas[1].getTipo());
            this.tipo2.repaint();
            this.costo2.setText(""+cartas[1].getCosto());
            this.costo2.repaint();
            this.carta2.setVisible(true);
            this.tipo2.setVisible(true);
            this.costo2.setVisible(true);
            this.cartaN2.setVisible(true);
            this.imagen2.setVisible(true);
            this.beneficio2.setVisible(true);
            switch(cartas[1].getTipo()){
                case "PODER":
                    this.beneficio2.setForeground(new Color(255,255,255));
                    this.beneficio2.repaint();
                    this.tipo2.setForeground(new Color(255,255,255));
                    this.tipo2.repaint();
                    this.cartaN2.setForeground(new Color(255,255,255));
                    this.cartaN2.repaint();
                    switch(cartas[1].getNombre().toUpperCase()){
                        case "AGILIZAR":
                            this.beneficio2.setText("DEX +"+cartas[1].getPlus());
                            this.beneficio2.repaint();
                            break;
                        case "AVIVAR":
                            this.beneficio2.setText("STR +"+cartas[1].getPlus());
                            this.beneficio2.repaint();
                            break;
                    }
                    break;
                case "HABILIDAD":
                    this.beneficio2.setText("HP +"+cartas[1].getPlus());
                    this.beneficio2.repaint();
                    break;
                case "MALDICION":
                    this.beneficio2.setText("ATKx"+cartas[1].getTurnos()+" +"+cartas[1].getDaño());
                    this.beneficio2.repaint();
                    break;
                case "ATAQUE":
                    this.beneficio2.setText("ATK +"+cartas[1].getDaño());
                    this.beneficio2.repaint();
                    break;
            }
            this.carta2.setVisible(true);
            this.carta2.repaint();
        }else{
            this.imagen2.setVisible(false);
            this.imagen2.repaint();
            this.carta2.setVisible(false);
            this.carta2.repaint();
            this.beneficio2.setVisible(false);
            this.beneficio2.repaint();
            this.tipo2.setVisible(false);
            this.tipo2.repaint();
            this.costo2.setVisible(false);
            this.costo2.repaint();
            this.cartaN2.setVisible(false);
            this.cartaN2.repaint();
        }
        
        if(cartas[2] != null){
            aux = new ImageIcon(getClass().getResource("imagenes/"+cartas[2].getTipo().toLowerCase()+".jpg")).getImage().getScaledInstance( 120 , 160, Image.SCALE_SMOOTH);
            this.carta3.setIcon(new ImageIcon(aux));
            this.carta3.repaint();
            aux = new ImageIcon(getClass().getResource("imagenes/"+cartas[2].getTipo().toLowerCase()+"_carta.gif")).getImage().getScaledInstance( 100 , 85, Image.SCALE_DEFAULT);
            this.imagen3.setIcon(new ImageIcon(aux));    
            this.imagen3.repaint();
            this.cartaN3.setText(cartas[2].getNombre()); 
            this.cartaN3.repaint();
            this.beneficio3.setForeground(new Color(61,61,61));
            this.beneficio3.repaint();
            this.tipo3.setForeground(new Color(61,61,61));
            this.tipo3.repaint();
            this.cartaN3.setForeground(new Color(61,61,61));
            this.cartaN3.repaint();
            this.tipo3.setText(cartas[2].getTipo());
            this.tipo3.repaint();
            this.costo3.setText(""+cartas[2].getCosto());
            this.costo3.repaint();
            this.carta3.setVisible(true);
            this.tipo3.setVisible(true);
            this.costo3.setVisible(true);
            this.cartaN3.setVisible(true);
            this.imagen3.setVisible(true);
            this.beneficio3.setVisible(true);
            switch(cartas[2].getTipo()){
                case "PODER":
                    this.beneficio3.setForeground(new Color(255,255,255));
                    this.beneficio3.repaint();
                    this.tipo3.setForeground(new Color(255,255,255));
                    this.tipo3.repaint();
                    this.cartaN3.setForeground(new Color(255,255,255));
                    this.cartaN3.repaint();
                    switch(cartas[2].getNombre().toUpperCase()){
                        case "AGILIZAR":
                            this.beneficio3.setText("DEX +"+cartas[2].getPlus());
                            this.beneficio3.repaint();
                            break;
                        case "AVIVAR":
                            this.beneficio3.setText("STR +"+cartas[2].getPlus());
                            this.beneficio3.repaint();
                            break;
                    }
                    break;
                case "HABILIDAD":
                    this.beneficio3.setText("HP +"+cartas[2].getPlus());
                    this.beneficio3.repaint();
                    break;
                case "MALDICION":
                    this.beneficio3.setText("ATKx"+cartas[2].getTurnos()+" +"+cartas[2].getDaño());
                    this.beneficio3.repaint();
                    break;
                case "ATAQUE":
                    this.beneficio3.setText("ATK +"+cartas[2].getDaño());
                    this.beneficio3.repaint();
                    break;
            }
            this.carta3.setVisible(true);
            this.carta3.repaint();
        }else{
            this.imagen3.setVisible(false);
            this.imagen3.repaint();
            this.carta3.setVisible(false);
            this.carta3.repaint();
            this.beneficio3.setVisible(false);
            this.beneficio3.repaint();
            this.tipo3.setVisible(false);
            this.tipo3.repaint();
            this.costo3.setVisible(false);
            this.costo3.repaint();
            this.cartaN3.setVisible(false);
            this.cartaN3.repaint();
        }
        
        if(cartas[3] != null){
            aux = new ImageIcon(getClass().getResource("imagenes/"+cartas[3].getTipo().toLowerCase()+".jpg")).getImage().getScaledInstance( 120 , 160, Image.SCALE_SMOOTH);
            this.carta4.setIcon(new ImageIcon(aux));
            this.carta4.repaint();
            aux = new ImageIcon(getClass().getResource("imagenes/"+cartas[3].getTipo().toLowerCase()+"_carta.gif")).getImage().getScaledInstance( 100 , 85, Image.SCALE_DEFAULT);
            this.imagen4.setIcon(new ImageIcon(aux));    
            this.imagen4.repaint();
            this.cartaN4.setText(cartas[3].getNombre()); 
            this.cartaN4.repaint();
            this.beneficio4.setForeground(new Color(61,61,61));
            this.beneficio4.repaint();
            this.tipo4.setForeground(new Color(61,61,61));
            this.tipo4.repaint();
            this.cartaN4.setForeground(new Color(61,61,61));
            this.cartaN4.repaint();
            this.tipo4.setText(cartas[3].getTipo());
            this.tipo4.repaint();
            this.costo4.setText(""+cartas[3].getCosto());
            this.costo4.repaint();
            this.carta4.setVisible(true);
            this.tipo4.setVisible(true);
            this.costo4.setVisible(true);
            this.cartaN4.setVisible(true);
            this.imagen4.setVisible(true);
            this.beneficio4.setVisible(true);
            switch(cartas[3].getTipo()){
                case "PODER":
                    this.beneficio4.setForeground(new Color(255,255,255));
                    this.beneficio4.repaint();
                    this.tipo4.setForeground(new Color(255,255,255));
                    this.tipo4.repaint();
                    this.cartaN4.setForeground(new Color(255,255,255));
                    this.cartaN4.repaint();
                    switch(cartas[3].getNombre().toUpperCase()){
                        case "AGILIZAR":
                            this.beneficio4.setText("DEX +"+cartas[3].getPlus());
                            this.beneficio4.repaint();
                            break;
                        case "AVIVAR":
                            this.beneficio4.setText("STR +"+cartas[3].getPlus());
                            this.beneficio4.repaint();
                            break;
                    }
                    break;
                case "HABILIDAD":
                    this.beneficio4.setText("HP +"+cartas[3].getPlus());
                    this.beneficio4.repaint();
                    break;
                case "MALDICION":
                    this.beneficio4.setText("ATKx"+cartas[3].getTurnos()+" +"+cartas[3].getDaño());
                    this.beneficio4.repaint();
                    break;
                case "ATAQUE":
                    this.beneficio4.setText("ATK +"+cartas[3].getDaño());
                    this.beneficio4.repaint();
                    break;
            }
            this.carta4.setVisible(true);
            this.carta4.repaint();
        }else{
            this.imagen4.setVisible(false);
            this.imagen4.repaint();
            this.carta4.setVisible(false);
            this.carta4.repaint();
            this.beneficio4.setVisible(false);
            this.beneficio4.repaint();
            this.tipo4.setVisible(false);
            this.tipo4.repaint();
            this.costo4.setVisible(false);
            this.costo4.repaint();
            this.cartaN4.setVisible(false);
            this.cartaN4.repaint();
        }
        
        if(cartas[4] != null){
            aux = new ImageIcon(getClass().getResource("imagenes/"+cartas[4].getTipo().toLowerCase()+".jpg")).getImage().getScaledInstance( 120 , 160, Image.SCALE_SMOOTH);
            this.carta5.setIcon(new ImageIcon(aux));
            this.carta5.repaint();
            aux = new ImageIcon(getClass().getResource("imagenes/"+cartas[4].getTipo().toLowerCase()+"_carta.gif")).getImage().getScaledInstance( 100 , 85, Image.SCALE_DEFAULT);
            this.imagen5.setIcon(new ImageIcon(aux));    
            this.imagen5.repaint();
            this.cartaN5.setText(cartas[4].getNombre()); 
            this.cartaN5.repaint();
            this.beneficio5.setForeground(new Color(61,61,61));
            this.beneficio5.repaint();
            this.tipo5.setForeground(new Color(61,61,61));
            this.tipo5.repaint();
            this.cartaN5.setForeground(new Color(61,61,61));
            this.cartaN5.repaint();
            this.tipo5.setText(cartas[4].getTipo());
            this.tipo5.repaint();
            this.costo5.setText(""+cartas[4].getCosto());
            this.costo5.repaint();
            this.carta5.setVisible(true);
            this.tipo5.setVisible(true);
            this.costo5.setVisible(true);
            this.cartaN5.setVisible(true);
            this.imagen5.setVisible(true);
            this.beneficio5.setVisible(true);
            switch(cartas[4].getTipo()){
                case "PODER":
                    this.beneficio5.setForeground(new Color(255,255,255));
                    this.beneficio5.repaint();
                    this.tipo5.setForeground(new Color(255,255,255));
                    this.tipo5.repaint();
                    this.cartaN5.setForeground(new Color(255,255,255));
                    this.tipo5.repaint();
                    switch(cartas[4].getNombre().toUpperCase()){
                        case "AGILIZAR":
                            this.beneficio5.setText("DEX +"+cartas[4].getPlus());
                            this.beneficio5.repaint();
                            break;
                        case "AVIVAR":
                            this.beneficio5.setText("STR +"+cartas[4].getPlus());
                            this.beneficio5.repaint();
                            break;
                    }
                    break;
                case "HABILIDAD":
                    this.beneficio5.setText("HP +"+cartas[4].getPlus());
                    this.beneficio5.repaint();
                    break;
                case "MALDICION":
                    this.beneficio5.setText("ATKx"+cartas[4].getTurnos()+" +"+cartas[4].getDaño());
                    this.beneficio5.repaint();
                    break;
                case "ATAQUE":
                    this.beneficio5.setText("ATK +"+cartas[4].getDaño());
                    this.beneficio5.repaint();
                    break;
            }
            this.carta5.setVisible(true);
            this.carta5.repaint();
        }else{
            this.imagen5.setVisible(false);
            this.imagen5.repaint();
            this.carta5.setVisible(false);
            this.carta5.repaint();
            this.beneficio5.setVisible(false);
            this.beneficio5.repaint();
            this.tipo5.setVisible(false);
            this.tipo5.repaint();
            this.costo5.setVisible(false);
            this.costo5.repaint();
            this.cartaN5.setVisible(false);
            this.cartaN5.repaint();
        }
        
        this.pack();
        this.revalidate();
        this.validate();
        this.repaint();
        
    }
    
    public void reproducir(String sonido) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        try{
            clip.stop();
        }catch(Exception e){
        }
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sonidos/"+sonido+".wav").getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.stop();
        clip.open(audioInputStream);
        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(-8);
        clip.loop(-1);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        ataque3 = new javax.swing.JLabel();
        ataque2 = new javax.swing.JLabel();
        ataque1 = new javax.swing.JLabel();
        daño1 = new javax.swing.JLabel();
        daño3 = new javax.swing.JLabel();
        daño2 = new javax.swing.JLabel();
        habilidad3 = new javax.swing.JLabel();
        habilidad2 = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        historia = new javax.swing.JTextPane();
        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        accion = new javax.swing.JTextPane();
        dmg = new javax.swing.JLabel();
        hp = new javax.swing.JLabel();
        def = new javax.swing.JLabel();
        dmgT = new javax.swing.JLabel();
        hp2 = new javax.swing.JLabel();
        estamina = new javax.swing.JProgressBar();
        nombre1 = new javax.swing.JLabel();
        dmg2 = new javax.swing.JLabel();
        habilidad = new javax.swing.JLabel();
        preparate = new javax.swing.JLabel();
        vida = new javax.swing.JProgressBar();
        morir = new javax.swing.JLabel();
        vida1 = new javax.swing.JProgressBar();
        dmgT2 = new javax.swing.JLabel();
        def2 = new javax.swing.JLabel();
        jugador = new javax.swing.JLabel();
        vida2 = new javax.swing.JProgressBar();
        nombre2 = new javax.swing.JLabel();
        def1 = new javax.swing.JLabel();
        seleccionA = new javax.swing.JLabel();
        dmgT1 = new javax.swing.JLabel();
        seleccionB = new javax.swing.JLabel();
        dmg1 = new javax.swing.JLabel();
        jugador3 = new javax.swing.JLabel();
        jugador2 = new javax.swing.JLabel();
        hp1 = new javax.swing.JLabel();
        entorno = new javax.swing.JLabel();
        imagen4 = new javax.swing.JLabel();
        imagen5 = new javax.swing.JLabel();
        imagen1 = new javax.swing.JLabel();
        imagen2 = new javax.swing.JLabel();
        imagen3 = new javax.swing.JLabel();
        costo1 = new javax.swing.JLabel();
        costo3 = new javax.swing.JLabel();
        costo5 = new javax.swing.JLabel();
        costo4 = new javax.swing.JLabel();
        cartaN2 = new javax.swing.JLabel();
        cartaN3 = new javax.swing.JLabel();
        cartaN4 = new javax.swing.JLabel();
        cartaN5 = new javax.swing.JLabel();
        tipo3 = new javax.swing.JLabel();
        cartaN1 = new javax.swing.JLabel();
        beneficio2 = new javax.swing.JLabel();
        beneficio3 = new javax.swing.JLabel();
        beneficio4 = new javax.swing.JLabel();
        beneficio5 = new javax.swing.JLabel();
        beneficio1 = new javax.swing.JLabel();
        tipo1 = new javax.swing.JLabel();
        carta1 = new javax.swing.JLabel();
        carta3 = new javax.swing.JLabel();
        costo2 = new javax.swing.JLabel();
        tipo4 = new javax.swing.JLabel();
        tipo5 = new javax.swing.JLabel();
        tipo2 = new javax.swing.JLabel();
        carta2 = new javax.swing.JLabel();
        carta4 = new javax.swing.JLabel();
        carta5 = new javax.swing.JLabel();
        auxiliar = new javax.swing.JLabel();
        table = new javax.swing.JLabel();
        separator = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ataque3.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/ataque.gif")).getImage().getScaledInstance(80, 70, Image.SCALE_DEFAULT)));
        getContentPane().add(ataque3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 70, 60));

        ataque2.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/ataque.gif")).getImage().getScaledInstance(80, 70, Image.SCALE_DEFAULT)));
        getContentPane().add(ataque2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 70, 60));

        ataque1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/ataque.gif")).getImage().getScaledInstance(80, 70, Image.SCALE_DEFAULT)));
        getContentPane().add(ataque1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 70, 60));

        daño1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/ataque2.gif")).getImage().getScaledInstance(180, 210, Image.SCALE_DEFAULT)));
        getContentPane().add(daño1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 40, 180, 210));

        daño3.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/ataque2.gif")).getImage().getScaledInstance(180, 210, Image.SCALE_DEFAULT)));
        getContentPane().add(daño3, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 40, 180, 210));

        daño2.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/ataque2.gif")).getImage().getScaledInstance(180, 210, Image.SCALE_DEFAULT)));
        getContentPane().add(daño2, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 40, 180, 210));

        habilidad3.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/habilidad.gif")).getImage().getScaledInstance(180, 200, Image.SCALE_DEFAULT)));
        getContentPane().add(habilidad3, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 40, 180, 200));

        habilidad2.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/habilidad.gif")).getImage().getScaledInstance(180, 200, Image.SCALE_DEFAULT)));
        getContentPane().add(habilidad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 40, 180, 200));

        panel1.setBorder(null);
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setViewportView(historia);

        panel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 480, 90));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 680, 190));

        panel.setBorder(null);
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        accion.setFont(new java.awt.Font("Yrsa SemiBold", 1, 21)); // NOI18N
        accion.setForeground(java.awt.Color.white);
        jScrollPane1.setViewportView(accion);

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, -4, 620, 50));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 680, 50));
        getContentPane().add(dmg, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 20, 20));
        getContentPane().add(hp, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 20, 20));
        getContentPane().add(def, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 20, 20));
        getContentPane().add(dmgT, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 20, 20));
        getContentPane().add(hp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 20, 20));

        estamina.setBackground(java.awt.Color.black);
        estamina.setFont(new java.awt.Font("Yrsa SemiBold", 1, 15)); // NOI18N
        estamina.setForeground(java.awt.Color.white);
        estamina.setMaximum(3);
        estamina.setToolTipText("");
        estamina.setValue(100);
        estamina.setString(estamina.getValue()+" / "+estamina.getMaximum());
        estamina.setStringPainted(true);
        getContentPane().add(estamina, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 220, 20));

        nombre1.setBackground(java.awt.Color.white);
        nombre1.setFont(new java.awt.Font("Yrsa SemiBold", 1, 20)); // NOI18N
        nombre1.setForeground(java.awt.Color.white);
        nombre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 160, 20));
        getContentPane().add(dmg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 20, 20));

        habilidad.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagenes/habilidad.gif")).getImage().getScaledInstance(220, 200, Image.SCALE_DEFAULT)));
        getContentPane().add(habilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 40, 220, 200));

        preparate.setFont(new java.awt.Font("Yrsa SemiBold", 1, 24)); // NOI18N
        preparate.setForeground(java.awt.Color.white);
        getContentPane().add(preparate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 140, 30));

        vida.setBackground(java.awt.Color.darkGray);
        vida.setFont(new java.awt.Font("Yrsa SemiBold", 1, 15)); // NOI18N
        vida.setForeground(java.awt.Color.red);
        vida.setValue(60);
        vida.setStringPainted(true);
        getContentPane().add(vida, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 20));

        morir.setFont(new java.awt.Font("Yrsa SemiBold", 1, 24)); // NOI18N
        morir.setForeground(java.awt.Color.white);
        getContentPane().add(morir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 190, 50));

        vida1.setBackground(java.awt.Color.black);
        vida1.setFont(new java.awt.Font("Yrsa SemiBold", 1, 15)); // NOI18N
        vida1.setForeground(java.awt.Color.white);
        vida1.setValue(100);
        vida1.setStringPainted(true);
        getContentPane().add(vida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 160, 20));
        getContentPane().add(dmgT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 20, 20));
        getContentPane().add(def2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 20, 20));

        jugador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 220, 200));

        vida2.setBackground(java.awt.Color.black);
        vida2.setFont(new java.awt.Font("Yrsa SemiBold", 1, 15)); // NOI18N
        vida2.setForeground(java.awt.Color.white);
        vida2.setValue(100);
        vida2.setStringPainted(true);
        getContentPane().add(vida2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 160, 20));

        nombre2.setBackground(java.awt.Color.white);
        nombre2.setFont(new java.awt.Font("Yrsa SemiBold", 1, 20)); // NOI18N
        nombre2.setForeground(java.awt.Color.white);
        nombre2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 160, 20));
        getContentPane().add(def1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 20, 20));
        getContentPane().add(seleccionA, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 40, 40));
        getContentPane().add(dmgT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 20, 20));
        getContentPane().add(seleccionB, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 40, 40));
        getContentPane().add(dmg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 20, 20));

        jugador3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugador3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jugador3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jugador3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jugador3MouseExited(evt);
            }
        });
        getContentPane().add(jugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 180, 180));

        jugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugador2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jugador2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jugador2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jugador2MouseExited(evt);
            }
        });
        getContentPane().add(jugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 180, 180));
        getContentPane().add(hp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 20, 20));
        getContentPane().add(entorno, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 710, 300));
        getContentPane().add(imagen4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 100, 90));
        getContentPane().add(imagen5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 100, 90));
        getContentPane().add(imagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 100, 90));
        getContentPane().add(imagen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 100, 90));
        getContentPane().add(imagen3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 100, 90));

        costo1.setFont(new java.awt.Font("Yrsa SemiBold", 1, 25)); // NOI18N
        costo1.setForeground(java.awt.Color.white);
        costo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        costo1.setText("1");
        getContentPane().add(costo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 35, 35));

        costo3.setFont(new java.awt.Font("Yrsa SemiBold", 1, 25)); // NOI18N
        costo3.setForeground(java.awt.Color.white);
        costo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        costo3.setText("1");
        getContentPane().add(costo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 35, 35));

        costo5.setFont(new java.awt.Font("Yrsa SemiBold", 1, 25)); // NOI18N
        costo5.setForeground(java.awt.Color.white);
        costo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        costo5.setText("1");
        getContentPane().add(costo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, 35, 35));

        costo4.setFont(new java.awt.Font("Yrsa SemiBold", 1, 25)); // NOI18N
        costo4.setForeground(java.awt.Color.white);
        costo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        costo4.setText("1");
        getContentPane().add(costo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 35, 35));

        cartaN2.setFont(new java.awt.Font("Yrsa SemiBold", 1, 13)); // NOI18N
        cartaN2.setForeground(java.awt.Color.white);
        cartaN2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cartaN2.setText("Nombre");
        getContentPane().add(cartaN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 447, 100, -1));

        cartaN3.setFont(new java.awt.Font("Yrsa SemiBold", 1, 13)); // NOI18N
        cartaN3.setForeground(java.awt.Color.white);
        cartaN3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cartaN3.setText("Nombre");
        getContentPane().add(cartaN3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 447, 100, -1));

        cartaN4.setFont(new java.awt.Font("Yrsa SemiBold", 1, 13)); // NOI18N
        cartaN4.setForeground(java.awt.Color.white);
        cartaN4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cartaN4.setText("Nombre");
        getContentPane().add(cartaN4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 447, 100, -1));

        cartaN5.setFont(new java.awt.Font("Yrsa SemiBold", 1, 13)); // NOI18N
        cartaN5.setForeground(java.awt.Color.white);
        cartaN5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cartaN5.setText("Nombre");
        getContentPane().add(cartaN5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 447, 100, -1));

        tipo3.setFont(new java.awt.Font("Yrsa SemiBold", 1, 14)); // NOI18N
        tipo3.setForeground(java.awt.Color.white);
        tipo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipo3.setText("Nombre");
        getContentPane().add(tipo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 345, 100, -1));

        cartaN1.setFont(new java.awt.Font("Yrsa SemiBold", 1, 13)); // NOI18N
        cartaN1.setForeground(java.awt.Color.white);
        cartaN1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cartaN1.setText("Nombre");
        getContentPane().add(cartaN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 447, 100, -1));

        beneficio2.setFont(new java.awt.Font("Yrsa SemiBold", 1, 18)); // NOI18N
        beneficio2.setText("ATK + 3");
        getContentPane().add(beneficio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, 70, -1));

        beneficio3.setFont(new java.awt.Font("Yrsa SemiBold", 1, 18)); // NOI18N
        beneficio3.setText("ATK + 3");
        getContentPane().add(beneficio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, 70, -1));

        beneficio4.setFont(new java.awt.Font("Yrsa SemiBold", 1, 18)); // NOI18N
        beneficio4.setText("ATK + 3");
        getContentPane().add(beneficio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, 70, -1));

        beneficio5.setFont(new java.awt.Font("Yrsa SemiBold", 1, 18)); // NOI18N
        beneficio5.setText("ATK + 3");
        getContentPane().add(beneficio5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 470, 70, -1));

        beneficio1.setFont(new java.awt.Font("Yrsa SemiBold", 1, 18)); // NOI18N
        beneficio1.setText("ATK + 3");
        getContentPane().add(beneficio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 70, -1));

        tipo1.setFont(new java.awt.Font("Yrsa SemiBold", 1, 14)); // NOI18N
        tipo1.setForeground(java.awt.Color.white);
        tipo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipo1.setText("Nombre");
        getContentPane().add(tipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 345, 100, -1));

        carta1.setBorder(null);
        carta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                carta1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                carta1MouseExited(evt);
            }
        });
        getContentPane().add(carta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 120, 170));

        carta3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                carta3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                carta3MouseExited(evt);
            }
        });
        getContentPane().add(carta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 120, 170));

        costo2.setFont(new java.awt.Font("Yrsa SemiBold", 1, 25)); // NOI18N
        costo2.setForeground(java.awt.Color.white);
        costo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        costo2.setText("1");
        getContentPane().add(costo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 35, 35));

        tipo4.setFont(new java.awt.Font("Yrsa SemiBold", 1, 14)); // NOI18N
        tipo4.setForeground(java.awt.Color.white);
        tipo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipo4.setText("Nombre");
        getContentPane().add(tipo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 345, 100, -1));

        tipo5.setFont(new java.awt.Font("Yrsa SemiBold", 1, 14)); // NOI18N
        tipo5.setForeground(java.awt.Color.white);
        tipo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipo5.setText("Nombre");
        getContentPane().add(tipo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 345, 100, -1));

        tipo2.setFont(new java.awt.Font("Yrsa SemiBold", 1, 14)); // NOI18N
        tipo2.setForeground(java.awt.Color.white);
        tipo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipo2.setText("Nombre");
        getContentPane().add(tipo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 345, 100, -1));

        carta2.setBorder(null);
        carta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                carta2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                carta2MouseExited(evt);
            }
        });
        getContentPane().add(carta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 120, 170));

        carta4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                carta4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                carta4MouseExited(evt);
            }
        });
        getContentPane().add(carta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 120, 170));

        carta5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                carta5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                carta5MouseExited(evt);
            }
        });
        getContentPane().add(carta5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 120, 170));

        auxiliar.setFont(new java.awt.Font("Yrsa SemiBold", 1, 25)); // NOI18N
        auxiliar.setForeground(java.awt.Color.white);
        auxiliar.setText("                                                    Juega una carta");
        auxiliar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(auxiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 680, 30));
        getContentPane().add(table, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 305, 680, 230));
        getContentPane().add(separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 680, 5));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carta1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta1MouseEntered
            this.carta1.setVerticalAlignment(SwingConstants.CENTER);
            this.carta1.setSize(carta1.getWidth() + 8, carta1.getHeight()  - 8);
            this.carta1.repaint();
            this.carta1.setBorder(new CompoundBorder( // sets two borders
                BorderFactory.createLineBorder(Color.WHITE, 2, true), // outer border
                BorderFactory.createLineBorder(red, 2, true))
            ); 
    }//GEN-LAST:event_carta1MouseEntered

    private void carta1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta1MouseExited
        this.carta1.setVerticalAlignment(SwingConstants.CENTER);
        this.carta1.setSize(carta1.getWidth() - 8, carta1.getHeight() + 8);
        this.carta1.repaint();
        this.carta1.setBorder(null); 
    }//GEN-LAST:event_carta1MouseExited

    private void carta2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta2MouseEntered
        this.carta2.setVerticalAlignment(SwingConstants.CENTER);
        this.carta2.setSize(carta2.getWidth() + 8, carta2.getHeight() - 8);
        this.carta2.repaint();
        this.carta2.setBorder(new CompoundBorder( // sets two borders
            BorderFactory.createLineBorder(Color.WHITE, 2, true), // outer border
            BorderFactory.createLineBorder(red, 2, true))
        ); 
    }//GEN-LAST:event_carta2MouseEntered

    private void carta2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta2MouseExited
        this.carta2.setVerticalAlignment(SwingConstants.CENTER);
        this.carta2.setSize(carta2.getWidth() - 8, carta2.getHeight() + 8);
        this.carta2.repaint();
        this.carta2.setBorder(null); 
    }//GEN-LAST:event_carta2MouseExited

    private void carta3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta3MouseEntered
        this.carta3.setVerticalAlignment(SwingConstants.CENTER);
        this.carta3.setSize(carta3.getWidth() + 8, carta3.getHeight() - 8);
        this.carta3.repaint();
        this.carta3.setBorder(new CompoundBorder( // sets two borders
            BorderFactory.createLineBorder(Color.WHITE, 2, true), // outer border
            BorderFactory.createLineBorder(red, 2, true))
        ); 
    }//GEN-LAST:event_carta3MouseEntered

    private void carta3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta3MouseExited
        this.carta3.setVerticalAlignment(SwingConstants.CENTER);
        this.carta3.setSize(carta3.getWidth() - 8, carta3.getHeight() + 8);
        this.carta3.repaint();
        this.carta3.setBorder(null); 
    }//GEN-LAST:event_carta3MouseExited

    private void carta4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta4MouseEntered
        this.carta4.setVerticalAlignment(SwingConstants.CENTER);
        this.carta4.setSize(carta4.getWidth() + 8, carta4.getHeight() - 8);
        this.carta4.repaint();
        this.carta4.setBorder(new CompoundBorder( // sets two borders
            BorderFactory.createLineBorder(Color.WHITE, 2, true), // outer border
            BorderFactory.createLineBorder(red, 2, true))
        ); 
    }//GEN-LAST:event_carta4MouseEntered

    private void carta4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta4MouseExited
        this.carta4.setVerticalAlignment(SwingConstants.CENTER);
        this.carta4.setSize(carta4.getWidth() - 8, carta4.getHeight() + 8);
        this.carta4.repaint();
        this.carta4.setBorder(null); 
    }//GEN-LAST:event_carta4MouseExited

    private void carta5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta5MouseEntered
        this.carta5.setVerticalAlignment(SwingConstants.CENTER);
        this.carta5.setSize(carta5.getWidth() + 8, carta5.getHeight() - 8);
        this.carta5.repaint();
        this.carta5.setBorder(new CompoundBorder( // sets two borders
            BorderFactory.createLineBorder(Color.WHITE, 2, true), // outer border
            BorderFactory.createLineBorder(red, 2, true))
        ); 
    }//GEN-LAST:event_carta5MouseEntered

    private void carta5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta5MouseExited
        this.carta5.setVerticalAlignment(SwingConstants.CENTER);
        this.carta5.setSize(carta5.getWidth() - 8, carta5.getHeight() + 8);
        this.carta5.repaint();
        this.carta5.setBorder(null); 
    }//GEN-LAST:event_carta5MouseExited

    private void carta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta1MouseClicked
        if(this.mano[0] != null && SlayTheSpire.turno && mano[0].getCosto() <= SlayTheSpire.jugador.getEstamina() && !SlayTheSpire.thread.isAlive()){
            this.carta1.setBorder(new CompoundBorder( // sets two borders
                BorderFactory.createLineBorder(red, 2, true), // outer border
                BorderFactory.createLineBorder(Color.WHITE, 2, true))
            ); 
            this.seleccionA.setVisible(true);
            if (varios && mano[0].getDireccion()){
                carta = true;
                cartaS = 0;
                crearDialogo("Ahora selecciona un enemigo...");
                //
            }else{
                ataque(0,0);
                this.carta1.setVisible(false);
                this.imagen1.setVisible(false);
            }        
        }else if(mano[0] == null){
            crearDialogo("Esta carta ya ha sido usada...");
        }else if (!SlayTheSpire.thread.isAlive()){
            crearDialogo("No tienes suficiente energía, prueba con otra carta.");
            
        }
    }//GEN-LAST:event_carta1MouseClicked

    private void jugador3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jugador3MouseEntered
        if(carta){
            this.seleccionA.setVisible(false);
            this.seleccionB.setVisible(true);
        }
            
    }//GEN-LAST:event_jugador3MouseEntered

    private void jugador3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jugador3MouseExited
        if(carta){
            this.seleccionB.setVisible(false);
        }
    }//GEN-LAST:event_jugador3MouseExited

    private void jugador2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jugador2MouseEntered
        if(carta){
            this.seleccionA.setVisible(true);
            this.seleccionB.setVisible(false);
        }
    }//GEN-LAST:event_jugador2MouseEntered

    private void jugador2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jugador2MouseExited
        if(carta){
            this.seleccionA.setVisible(false);
        }
    }//GEN-LAST:event_jugador2MouseExited

    private void carta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta2MouseClicked
        if(this.mano[1] != null && SlayTheSpire.turno && mano[1].getCosto() <= SlayTheSpire.jugador.getEstamina() && !SlayTheSpire.thread.isAlive()){
            this.carta2.setBorder(new CompoundBorder( // sets two borders
                BorderFactory.createLineBorder(red, 2, true), // outer border
                BorderFactory.createLineBorder(Color.WHITE, 2, true))
            ); 
            this.seleccionA.setVisible(true);
            if (varios && mano[1].getDireccion()){
                carta = true;
                cartaS = 1;
                crearDialogo("Ahora selecciona un enemigo...");
                //
            }else{
                ataque(1,0);
                this.carta2.setVisible(false);
                this.imagen2.setVisible(false);
            }        
        }else if(mano[1] == null){
            crearDialogo("Esta carta ya ha sido usada...");
        }else if (!SlayTheSpire.thread.isAlive()){
            crearDialogo("No tienes suficiente energía, prueba con otra carta.");
            
        }
    }//GEN-LAST:event_carta2MouseClicked

    private void carta3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta3MouseClicked
        if(this.mano[2] != null && SlayTheSpire.turno && mano[2].getCosto() <= SlayTheSpire.jugador.getEstamina() && !SlayTheSpire.thread.isAlive()){
            this.carta3.setBorder(new CompoundBorder( // sets two borders
                BorderFactory.createLineBorder(red, 2, true), // outer border
                BorderFactory.createLineBorder(Color.WHITE, 2, true))
            ); 
            this.seleccionA.setVisible(true);
            if (varios && mano[2].getDireccion()){
                carta = true;
                cartaS = 2;
                crearDialogo("Ahora selecciona un enemigo...");
                //
            }else{
                ataque(2,0);
                this.carta3.setVisible(false);
                this.imagen3.setVisible(false);
            }        
        }else if(mano[2] == null){
            crearDialogo("Esta carta ya ha sido usada...");
        }else if (!SlayTheSpire.thread.isAlive()){
            crearDialogo("No tienes suficiente energía, prueba con otra carta.");
            
        }
    }//GEN-LAST:event_carta3MouseClicked

    private void carta4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta4MouseClicked
        if(this.mano[3] != null && SlayTheSpire.turno && mano[3].getCosto() <= SlayTheSpire.jugador.getEstamina() && !SlayTheSpire.thread.isAlive()){
            this.carta4.setBorder(new CompoundBorder( // sets two borders
                BorderFactory.createLineBorder(red, 2, true), // outer border
                BorderFactory.createLineBorder(Color.WHITE, 2, true))
            ); 
            this.seleccionA.setVisible(true);
            if (varios && mano[3].getDireccion()){
                carta = true;
                cartaS = 3;
                crearDialogo("Ahora selecciona un enemigo...");
                //
            }else{
                ataque(3,0);
                this.carta4.setVisible(false);
                this.imagen4.setVisible(false);
            }        
        }else if(mano[3] == null){
            crearDialogo("Esta carta ya ha sido usada...");
        }else if(!SlayTheSpire.thread.isAlive()){
            crearDialogo("No tienes suficiente energía, prueba con otra carta.");
            
        }
    }//GEN-LAST:event_carta4MouseClicked

    private void carta5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta5MouseClicked
        if(this.mano[4] != null && SlayTheSpire.turno && mano[4].getCosto() <= SlayTheSpire.jugador.getEstamina() && !SlayTheSpire.thread.isAlive()){
            this.carta5.setBorder(new CompoundBorder( // sets two borders
                BorderFactory.createLineBorder(red, 2, true), // outer border
                BorderFactory.createLineBorder(Color.WHITE, 2, true))
            ); 
            this.seleccionA.setVisible(true);
            if (varios && mano[4].getDireccion()){
                carta = true;
                cartaS = 4;
                crearDialogo("Ahora selecciona un enemigo...");
                //
            }else{
                ataque(4,0);
                this.carta5.setVisible(false);
                this.imagen5.setVisible(false);
            }        
        }else if(mano[4] == null){
            crearDialogo("Esta carta ya ha sido usada...");
        }else if(!SlayTheSpire.thread.isAlive()){
            crearDialogo("No tienes suficiente energía, prueba con otra carta.");
            
        }
    }//GEN-LAST:event_carta5MouseClicked

    private void jugador3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jugador3MouseClicked
        if (varios) {
            if (monstruo[1].conVida()) {
                if (cartaS != -1 && carta) {
                    ataque(cartaS, 1);
                } else if (varios) {
                    crearDialogo("Debes seleccionar una carta primero...");
                }
            } else {
                crearDialogo("Este enemigo está muerto, escoge otro...");
            }
        }
    }//GEN-LAST:event_jugador3MouseClicked

    private void jugador2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jugador2MouseClicked
         if(monstruo[0].conVida()){
             if(cartaS != -1 && carta && varios)
               ataque(cartaS,0);
            else if(varios)
               crearDialogo("Debes seleccionar una carta primero...");
         }else{
                crearDialogo("Este enemigo está muerto, escoge otro...");
         }   
    }//GEN-LAST:event_jugador2MouseClicked
    
    private void aplicarEfectos(Entidad[] s){
        switch(s[0].getTipo().toUpperCase()){
            case "JUGADOR":
                SlayTheSpire.jugador = SlayTheSpire.jugador.getEfectos().aplicarEfectos(SlayTheSpire.jugador);
                if(s[0].getNombre().contains("dmgT++"))
                    this.dmgT2.setVisible(true);
                else
                    this.dmgT2.setVisible(false);
                if(s[0].getNombre().contains("hp++"))
                    this.hp2.setVisible(true);
                else
                    this.hp2.setVisible(false);
                if(s[0].getNombre().contains("def++"))
                    this.def2.setVisible(true);
                else
                    this.def2.setVisible(false);
                if(s[0].getNombre().contains("dmg--"))
                    this.dmg2.setVisible(true);
                else
                    this.dmg2.setVisible(false);
                this.dmgT2.repaint();
                this.dmg2.repaint();
                this.hp2.repaint();
                this.def2.repaint();
                this.vida.setValue((int) SlayTheSpire.jugador.getVida());
                break;
            case "MONSTRUO":
                monstruo[0] = monstruo[0].getEfectos().aplicarEfectos(monstruo[0]);
                if(s[0].getNombre().contains("dmgT++"))
                    this.dmgT.setVisible(true);
                else
                     this.dmgT.setVisible(false);
                if(s[0].getNombre().contains("hp++"))
                    this.hp.setVisible(true);
                else
                     this.hp.setVisible(false);
                if(s[0].getNombre().contains("def++"))
                    this.def.setVisible(true);
                else
                     this.def.setVisible(false);
                if(s[0].getNombre().contains("dmg--"))
                    this.dmg.setVisible(true);
                else
                     this.dmg.setVisible(false);
                this.dmgT.repaint();
                this.dmg.repaint();
                this.hp.repaint();
                this.def.repaint();
                this.vida1.setValue((int)monstruo[0].getVida());
                this.vida1.repaint();
                if(monstruo.length > 1){
                    monstruo[1] = monstruo[1].getEfectos().aplicarEfectos(monstruo[1]);
                    if(s[1].getNombre().contains("dmgT++"))
                        this.dmgT1.setVisible(true);
                    else
                        this.dmgT1.setVisible(false);
                    if(s[1].getNombre().contains("hp++"))
                        this.hp1.setVisible(true);
                    else
                        this.hp1.setVisible(false);
                    if(s[1].getNombre().contains("def++"))
                        this.def1.setVisible(true);
                    else
                        this.def1.setVisible(false);
                    if(s[1].getNombre().contains("dmg--"))
                        this.dmg1.setVisible(true);
                    else
                        this.dmg1.setVisible(false);
                    this.dmgT1.repaint();
                    this.dmg.repaint();
                    this.hp1.repaint();
                    this.def1.repaint();
                    this.vida2.setValue((int)monstruo[1].getVida());
                    this.vida2.repaint();
                }
        }
            
        
    }
    
    private void ataque(int i, int j){
        if(SlayTheSpire.turno && SlayTheSpire.jugador.conVida()){
            monstruoS = j;
            crearDialogo("Tu turno ha comenzado.");
            SlayTheSpire.jugador.reponerMano();
            setMano(SlayTheSpire.jugador.getMano());
            this.aplicarEfectos(new Entidad[] {SlayTheSpire.jugador});        
            if(mano[i].getDireccion()){
                int n = (int) (Math.random() * 100);
                if (!(n <= monstruo[j].getDestreza())){
                    this.ataque1.setVisible(true);
                    monstruo[j].setVida(monstruo[j].getVida() - (mano[i].getDaño() + SlayTheSpire.jugador.getFuerza()));
                    if(j == 2){
                        vida2.setValue((int) monstruo[j].getVida());
                        this.vida2.repaint();
                    }else{
                        vida1.setValue((int) monstruo[j].getVida());
                        this.vida1.repaint();
                    }
                    if(!mano[i].getEfecto().equalsIgnoreCase("NINGUNO"))
                        monstruo[j].getEfectos().Insertar(new Efecto(mano[i].getEfecto(),mano[i].getDaño(),mano[i].getTurnos()));
                    crearDialogo(SlayTheSpire.jugador.dialogar(mano[i],monstruo[j].getNombre()));
                }else{
                   crearDialogo("Vaya... Tu ataque fue bloqueado.");
                } 
            }else{
                this.habilidad.setVisible(true);
                if(!mano[i].getEfecto().equalsIgnoreCase("NINGUNO"))
                    SlayTheSpire.jugador.getEfectos().Insertar(new Efecto(mano[i].getEfecto(),mano[i].getDaño(),mano[i].getTurnos()));
                crearDialogo(SlayTheSpire.jugador.dialogar(mano[i], SlayTheSpire.jugador.getNombre()));        
                
            }
            cobrarCarta(i);
        }
        boolean enemigos = true;
        if(monstruo.length > 2){
            if(!monstruo[0].conVida() && !!monstruo[1].conVida()){
                enemigos = false;
            }
            
            if(!monstruo[0].conVida()){
                jugador2.setIcon(new ImageIcon(new ImageIcon("images/tumba.gif").getImage().getScaledInstance(jugador2.getWidth(), jugador2.getHeight(), Image.SCALE_DEFAULT)));
                jugador2.repaint();
            }
            
            if(!monstruo[1].conVida()){
                jugador3.setIcon(new ImageIcon(new ImageIcon("images/tumba.gif").getImage().getScaledInstance(jugador2.getWidth(), jugador2.getHeight(), Image.SCALE_DEFAULT)));
                jugador3.repaint();
            }
        }else{
            if(!monstruo[0].conVida()){
                enemigos = false;
                if(!monstruo[0].conVida()){
                    jugador2.setIcon(new ImageIcon(new ImageIcon("images/tumba.gif").getImage().getScaledInstance(jugador2.getWidth(), jugador2.getHeight(), Image.SCALE_DEFAULT)));
                }
            }
               
        }
            
        if(!SlayTheSpire.turno && SlayTheSpire.jugador.conVida() && enemigos){
            this.aplicarEfectos(monstruo);
            int n = (int)(Math.random() * 5);     
                for (int x = 0; x < monstruo.length; x++) {
                    try{
                        monstruo[x] = monstruo[x].getEfectos().aplicarEfectos(monstruo[x]);
                        //generamos una jugada al alzar para el monstruo
                        for (int y = 0; y < 77; y++)
                            n = (int)(Math.random() * 5); 

                        
                        Carta aux = monstruo[x].accion(n);
                        if(aux.getDireccion()){
                            int bloq = (int) (Math.random() * 100);
                            if (!(bloq <= SlayTheSpire.jugador.getDestreza())){
                                SlayTheSpire.jugador.setVida( SlayTheSpire.jugador.getVida() - (aux.getDaño() + monstruo[x].getFuerza()));
                                this.vida.setValue((int) SlayTheSpire.jugador.getVida());
                                if(!aux.getEfecto().equalsIgnoreCase("NINGUNO"))
                                     SlayTheSpire.jugador.getEfectos().Insertar(new Efecto(aux.getEfecto(),aux.getDaño(),aux.getTurnos()));
                                    
                                Thread thread = new Thread(HiloMonstruo(x));
                                thread.start();
                            }else{
                                //crearDialogo("Vaya... El ataque de "+monstruo[x].getNombre()+" fue bloqueado.");
                            } 
                        }else{
                            if(!aux.getEfecto().equalsIgnoreCase("NINGUNO"))
                                monstruo[x].getEfectos().Insertar(new Efecto(aux.getEfecto(),aux.getDaño(),aux.getTurnos()));
                            //crearDialogo(monstruo[x].dialogar(aux,monstruo[x].getNombre()));
                            if (x == 0) {
                                this.habilidad2.setVisible(true);
                            } else {
                                this.habilidad3.setVisible(true);
                            }
                            Thread thread = new Thread(HiloMonstruo(x));
                            thread.start();                
                        }
                        
                        monstruo[x].usarCarta(n);
                        monstruo[x].reponerMano();
                            
                    }catch(Exception e){
                        throw e;
                    }        
                }
            SlayTheSpire.turno = true;          
        }  
        if (!SlayTheSpire.jugador.conVida()) {
            try {
                Thread thread = new Thread(() -> {
                    try {
                        this.reproducir("derrota");
                        this.setVisible(false);
                        Resultado r = new Resultado();
                        r.setFondo("cartas", false);
                    } catch (UnsupportedAudioFileException ex) {
                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(Batalla.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                thread.start();

            } catch (Exception ex) {
            }
        }
        if (!enemigos) {
            Thread thread = new Thread(() -> {
                //this.reproducir("victoria");
                this.setVisible(false);
                Resultado r = new Resultado();
                r.setFondo("final", true);
            });
            thread.start();
        }
        carta = false;
        cartaS = -1;
    }
    
    private void cobrarCarta(int i){
        SlayTheSpire.jugador.setEstamina(SlayTheSpire.jugador.getEstamina() - mano[i].getCosto());
        actualizarEstamina(mano[i].getCosto());
        this.mano[i] = null;
        setMano(this.mano);
        SlayTheSpire.turno = jugadaImposible();
    }
    
    private void actualizarEstamina(int i){
        this.estamina.setValue(this.estamina.getValue() - i);
        this.estamina.setString(this.estamina.getValue() +" / " + this.estamina.getMaximum());
        this.estamina.repaint();
    }
    
    private boolean jugadaImposible(){
        int c = 0;
        for (int i = 0; i < mano.length; i++) {
            if (mano[i] != null) {
                if (mano[i].getCosto() > SlayTheSpire.jugador.getEstamina()) {
                    c++;
                }
            } else {
                c++;
            }
        }
        if (c == 5){
            //crearDialogo("Parece que no puedes costear ninguna jugada, tu turno ha terminado...");
            actualizarEstamina(-3);
            SlayTheSpire.jugador.setEstamina(3);
            return false;
        }else{
            return true;
        }
    }
    
    private void crearDialogo(String aux){
        Runnable tarea = Hilo(aux);
        SlayTheSpire.thread = new Thread(tarea);
        SlayTheSpire.thread.start();
        task = true;
    }
    
    private Runnable HiloMonstruo(int x){
        Runnable tarea = () -> {
            if(!SlayTheSpire.jugador.conVida())
                Thread.currentThread().interrupt();
            if (this.habilidad2.isVisible()) {
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                this.habilidad2.setVisible(false);
            } else if (this.habilidad3.isVisible()) {
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                this.habilidad3.setVisible(false);
            }
            //runner
            int lenght = (x == 0) ? (Math.abs(jugador.getX() - this.ataque2.getX()) + 20) : (Math.abs(jugador.getX() - this.ataque3.getX())+30) ;
            int y = 10;
            if(monstruo.length == 1) lenght-= 40;
            int yy = 6;
            if (x == 0) {
                try {
                    Thread.currentThread().sleep(1500);
                    this.ataque2.setVisible(true);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            } else {
                try {
                    Thread.currentThread().sleep(1500);
                    this.ataque3.setVisible(true);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
            if (this.ataque2.isVisible()) {
                for (int i = 0; i < lenght; i += 6) {
                    if(!SlayTheSpire.jugador.conVida())
                        Thread.currentThread().interrupt();
                    try {

                        if (y == 0) {
                            yy = 0;
                        }
                        y--;
                        this.ataque2.setBounds(this.ataque2.getX() - 6, this.ataque2.getY() + yy, 70, 60);
                        Thread.currentThread().sleep(5);
                    } catch (Exception ex) {
                        Thread.currentThread().interrupt(); // very important
                        break;
                    }
                }
            } else if (this.ataque3.isVisible()) {
                for (int i = 0; i < lenght; i += 6) {
                    if(!SlayTheSpire.jugador.conVida())
                        Thread.currentThread().interrupt();
                    try {

                        if (y == 0) {
                            yy = 0;
                        }
                        y--;
                        this.ataque3.setBounds(this.ataque3.getX() - 6, this.ataque3.getY() + yy, 70, 60);
                        Thread.currentThread().sleep(1);
                    } catch (Exception ex) {
                        Thread.currentThread().interrupt(); // very important
                        break;
                    }
                }
            }
            if (x == 0 && ataque2.isVisible()) {
                this.ataque2.setVisible(false);
                this.ataque2.setBounds(390, 60, 70, 60);
                this.daño1.setVisible(true);
                try {
                    Thread.currentThread().sleep(1500);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                this.daño1.setVisible(false);
            } else if(ataque3.isVisible()) {
                this.ataque3.setVisible(false);
                this.ataque3.setBounds(590, 60, 70, 60);
                this.daño1.setVisible(true);
                try {
                    Thread.currentThread().sleep(1500);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                this.daño1.setVisible(false);
            }
            monstruoS = -1;
            Thread.currentThread().interrupt();
        };
        return tarea;
    }
    
    private Runnable Hilo(String aux){
        Runnable tarea = () -> { 
            
            for (int i = 0; i < aux.length(); i++) {
                if(!SlayTheSpire.jugador.conVida())
                    Thread.currentThread().interrupt();
                try {
                    setMensaje("", "", aux.substring(0, i + 1), false);
                    Thread.currentThread().sleep(10);
                } catch (Exception ex) {
                    Thread.currentThread().interrupt(); // very important
                    break;
                }               
            }  
            if(this.habilidad.isVisible() && !this.ataque1.isVisible()){
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                this.habilidad.setVisible(false);
            }
            //runner
            int lenght = 0;
            
            switch(monstruoS ){
                case 0:
                    lenght = Math.abs(jugador2.getX() - ataque1.getX());
                    break;
                case 1:
                    lenght = Math.abs(jugador3.getX() - ataque1.getX() - 10);
                    break;
            }
            int y = 8;
            int yy = 6;
            if(this.ataque1.isVisible()){
                for (int i = 0; i < lenght; i+=6) {
                    if(!SlayTheSpire.jugador.conVida())
                        Thread.currentThread().interrupt();
                    try {
                        
                        if (y == 0){
                            yy = 0;
                        }
                        y--;
                        this.ataque1.setBounds(this.ataque1.getX() + 6, this.ataque1.getY() + yy, 70, 60);
                        Thread.currentThread().sleep(5);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt(); // very important
                        break;
                    }               
                }
                if(monstruo.length < 2){
                    this.ataque1.setVisible(false);
                    this.ataque1.setBounds(20, 60, 70, 60);
                    this.daño2.setVisible(true);
                    try {
                        Thread.currentThread().sleep(1500);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    this.daño2.setVisible(false);
                }else{
                    this.ataque1.setVisible(false);
                    this.ataque1.setBounds(20, 60, 70, 60);
                    if(monstruoS == 0){
                        this.daño2.setVisible(true);
                        try {
                            Thread.currentThread().sleep(1500);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        this.daño2.setVisible(false);
                    }else{
                        this.daño3.setVisible(true);
                        try {
                            Thread.currentThread().sleep(1500);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        this.daño3.setVisible(false);
                    }
                }
         
            }
            
            task = false;
            Thread.currentThread().interrupt();
        };
        return tarea;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Batalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Batalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Batalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Batalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Batalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane accion;
    private javax.swing.JLabel ataque1;
    private javax.swing.JLabel ataque2;
    private javax.swing.JLabel ataque3;
    private javax.swing.JLabel auxiliar;
    private javax.swing.JLabel beneficio1;
    private javax.swing.JLabel beneficio2;
    private javax.swing.JLabel beneficio3;
    private javax.swing.JLabel beneficio4;
    private javax.swing.JLabel beneficio5;
    private javax.swing.JLabel carta1;
    private javax.swing.JLabel carta2;
    private javax.swing.JLabel carta3;
    private javax.swing.JLabel carta4;
    private javax.swing.JLabel carta5;
    private javax.swing.JLabel cartaN1;
    private javax.swing.JLabel cartaN2;
    private javax.swing.JLabel cartaN3;
    private javax.swing.JLabel cartaN4;
    private javax.swing.JLabel cartaN5;
    private javax.swing.JLabel costo1;
    private javax.swing.JLabel costo2;
    private javax.swing.JLabel costo3;
    private javax.swing.JLabel costo4;
    private javax.swing.JLabel costo5;
    private javax.swing.JLabel daño1;
    private javax.swing.JLabel daño2;
    private javax.swing.JLabel daño3;
    private javax.swing.JLabel def;
    private javax.swing.JLabel def1;
    private javax.swing.JLabel def2;
    private javax.swing.JLabel dmg;
    private javax.swing.JLabel dmg1;
    private javax.swing.JLabel dmg2;
    private javax.swing.JLabel dmgT;
    private javax.swing.JLabel dmgT1;
    private javax.swing.JLabel dmgT2;
    private javax.swing.JLabel entorno;
    private javax.swing.JProgressBar estamina;
    private javax.swing.JLabel habilidad;
    private javax.swing.JLabel habilidad2;
    private javax.swing.JLabel habilidad3;
    private javax.swing.JTextPane historia;
    private javax.swing.JLabel hp;
    private javax.swing.JLabel hp1;
    private javax.swing.JLabel hp2;
    private javax.swing.JLabel imagen1;
    private javax.swing.JLabel imagen2;
    private javax.swing.JLabel imagen3;
    private javax.swing.JLabel imagen4;
    private javax.swing.JLabel imagen5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel jugador;
    private javax.swing.JLabel jugador2;
    private javax.swing.JLabel jugador3;
    private javax.swing.JLabel morir;
    private javax.swing.JLabel nombre1;
    private javax.swing.JLabel nombre2;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel1;
    private javax.swing.JLabel preparate;
    private javax.swing.JLabel seleccionA;
    private javax.swing.JLabel seleccionB;
    private javax.swing.JPanel separator;
    private javax.swing.JLabel table;
    private javax.swing.JLabel tipo1;
    private javax.swing.JLabel tipo2;
    private javax.swing.JLabel tipo3;
    private javax.swing.JLabel tipo4;
    private javax.swing.JLabel tipo5;
    private javax.swing.JProgressBar vida;
    private javax.swing.JProgressBar vida1;
    private javax.swing.JProgressBar vida2;
    // End of variables declaration//GEN-END:variables
}
