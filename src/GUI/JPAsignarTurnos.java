/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Domain.Jugador;
import Domain.Palillo;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.swing.JPanel;

/**
 *
 * @author Jose Ignacio Alvarado Meneses C20355 Maria Celeste Salazar Ulloa C27159
 */
public class JPAsignarTurnos extends JPanel {

    private Jugador[] jugadoresTurno;
    private Palillo[] palitos;
    public JPAsignarTurnos(Jugador[] jugadores) throws IOException {

        this.jugadoresTurno = jugadores;
        
        this.setSize(1000, 700);
        this.setLayout(null);
       
        this.palitos = new Palillo[this.jugadoresTurno.length];
        llenarPalillos();
        
    }//constructor

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 1000, 700);

        for (int i = 0; i < this.palitos.length; i++) {
            this.palitos[i].dibujar(g);
        }
    }
 
    /*
    * Este metodo crea cada palillo dandole su respectiva posicion tanto en x como en y
    */
    public void llenarPalillos() {
        int posX = 50, posY = 50;
        int largo = 60;
        for (int i = 0; i < this.palitos.length; i++) {
            this.palitos[i] = new Palillo(posX, posY);
            this.palitos[i].setLargo(largo);
            largo += 50;
            posX += 100;
        }
    }//llenarPalillos

        
    
}//fin clase
