/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.awt.image.BufferedImage;

/**
 *
 * @author Jose Ignacio Alvarado Meneses C20355 Maria Celeste Salazar Ulloa C27159
 */
public abstract class Cara {
    
        
    protected BufferedImage imagen;
    protected int posX;
    protected int posY;
    private int tam = 50;
    

    public Cara(int posX, int posY) {
        
        this.posX = posX;
        this.posY = posY;   
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }
    
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

    @Override
    public String toString() {
        return "Mosca{" + "moscaImagen=" + imagen + ", posX=" + posX + ", posY=" + posY + '}';
    }
    
}//fin clase
