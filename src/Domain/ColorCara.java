/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;


/**
 *
 * @author Jose Ignacio Alvarado Meneses C20355 Maria Celeste Salazar Ulloa C27159
 */
public class ColorCara extends Cara {

    private int color;
    private int tam;

    public ColorCara(int posX, int posY) {
        super(posX, posY);
        this.tam = 100;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    @Override
    public String toString() {
        return super.toString()+" ColorCara{" + "color=" + color + ", tam=" + tam + '}';
    }
    
    

}//fin clase
