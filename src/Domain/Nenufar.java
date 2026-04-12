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
public class Nenufar {
    
    private int posX;
    private int posY;
    private int tam;
    private Color colorNenufar;

    public Nenufar(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.tam = 40;
    }//constructor

    public int getPosX() {
        return posX;
    }
    // xd si  lee esto

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public Color getColorNenufar() {
        return colorNenufar;
    }

    public void setColorNenufar(Color colorNenufar) {
        this.colorNenufar = colorNenufar;
    }

    @Override
    public String toString() {
        return "Nenufar{" + "posX=" + posX + ", posY=" + posY + ", tam=" + tam + ", colorNenufar=" + colorNenufar + '}';
    }
    
    public void dibujar(Graphics g){     
        g.setColor(this.colorNenufar);
        g.fillOval(this.posX, this.posY, this.tam, this.tam);
    }//dibujar
    
}//fin clase
