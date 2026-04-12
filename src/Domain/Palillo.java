/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Jose Ignacio Alvarado Meneses C20355 Maria Celeste Salazar Ulloa C27159
 */
public class Palillo {

    private int palilloValor;
    private int posX, posY;
    private int largo, ancho;
 
    
    public Palillo(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.ancho = 50;
        this.largo = 50;
    }//constructor
    

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    public int getPalilloValor() {
        return palilloValor;
    }

    public void setPalilloValor(int palilloValor) {
        this.palilloValor = palilloValor;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
    

    @Override
    public String toString() {
        return "Palillo{" + "palilloValor=" + palilloValor + ", posX=" + posX + ", posY=" + posY + '}';
    }

    

    public void dibujar(Graphics g) {       
        g.setColor(Color.blue);
        g.fillRect(this.posX, this.posY, this.ancho, this.largo);
        
    }// dibujar

}//fin clase
