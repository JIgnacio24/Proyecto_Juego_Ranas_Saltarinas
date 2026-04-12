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
public class Casilla {

    private int posX;
    private int posY;
    private Color colorCasilla;
    private int color;
    private Mosca mosca;
    private boolean ocupada;
    private int tam;

    public Casilla(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.tam = 70;
    }//constructor

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Mosca getMosca() {
        return mosca;
    }

    public void setMosca(Mosca mosca) {
        this.mosca = mosca;
    }

    public int getPosX() {
        return this.posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Color getColorCasilla() {
        return colorCasilla;
    }

    public void setColorCasilla(Color colorCasilla) {
        this.colorCasilla = colorCasilla;
    }

    public int getTam() {
        return this.tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    @Override
    public String toString() {
        return "Casilla{" + "posX=" + posX + ", posY=" + posY + ", colorCasilla=" + colorCasilla + ", mosca=" + mosca + '}';
    }

     /*
    * Este metodo dependiendo de un entero que se le ingresa le asigna un color u otro 
    */
    public void darColor(int color) {

        switch (color) {
            case 1:
                this.colorCasilla = new Color(255, 102, 0);
                break;
            case 2:
                this.colorCasilla = new Color(127, 42, 218);
                break;
            case 3:
                this.colorCasilla = new Color(255, 212, 42);
                break;
            default:
                this.colorCasilla = new Color(255, 0, 102);
                break;
        }//switch
    }//darColor

    public void dibujar(Graphics g) {
        g.setColor(this.colorCasilla);
        g.fillOval(this.posX, this.posY, this.tam, this.tam);
    }//dibujar

}//fin clase
