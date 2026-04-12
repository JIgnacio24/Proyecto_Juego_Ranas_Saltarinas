/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Domain.Jugador;
import javax.swing.JInternalFrame;

/**
 *
 * @author Jose Ignacio Alvarado Meneses C20355 Maria Celeste Salazar Ulloa C27159
 */
public class JIFMostrarJuego extends JInternalFrame{
    
    private JPJuego juego;

    public JIFMostrarJuego(Jugador[] jugadores) {
        
        this.setSize(650, 650);
        
         this.juego = new JPJuego(jugadores);
        this.add(juego);       
    }//constructor

    public JPJuego getJuego() {
        return juego;
    }
    
    
    
}//JIFMostrarJuego
