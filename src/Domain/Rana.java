/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Jose Ignacio Alvarado Meneses C20355 Maria Celeste Salazar Ulloa C27159
 */
public class Rana {
    
    private int posX;
    private int posY;
    private BufferedImage ranaSelecionada;
    private Color color;
    
    public Rana(Color color) throws IOException { 
        this.posX = 0;
        this.posY = 0;
        this.ranaSelecionada = ImageIO.read(getClass().getResourceAsStream("/paquetederecursos/rana.png"));
        this.color = color;
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

    public BufferedImage getRanaSelecionada() {
        return ranaSelecionada;
    }

    public void setRanaSelecionada(BufferedImage ranaSelecionada) {
        this.ranaSelecionada = ranaSelecionada;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    
    @Override
    public String toString() {
        return "Rana{" + "posX=" + posX + ", posY=" + posY + ", ranaSelecionada=" + ranaSelecionada + '}';
    }
    
    public void dibujar(Graphics g){
        g.setColor(this.color);
        g.fillRect(this.posX, this.posY, 50, 50); 
        g.drawImage(this.ranaSelecionada, this.posX, this.posY, null);
    }//dibujar
    
}//fin clase
