/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;


/**
 *
 * @author Jose Ignacio Alvarado Meneses C20355 Maria Celeste Salazar Ulloa C27159
 */
public class Dado {

    private int valor;
    private boolean tirar;
    private Cara[] carasDado;
    private int posX, posY;

    public Dado(int posX, int posY) throws IOException {
        this.carasDado = new Cara[6];
        this.valor = 6;
        this.tirar = false;
        this.posX = posX;
        this.posY = posY;
        llenarCaras();
    }//constructor

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isTirar() {
        return tirar;
    }

    public void setTirar(boolean tirar) {
        this.tirar = tirar;
    }

    public Cara[] getCarasDado() {
        return carasDado;
    }

    public void setCarasDado(Cara[] carasDado) {
        this.carasDado = carasDado;
    }

    @Override
    public String toString() {
        return "Dado{" + "valor=" + valor + ", tirar=" + tirar + ", carasDado=" + carasDado + '}';
    }
    
    /*
    * Genera un numero aleatoriamente usando un random para depues devolver ese valor
    */
    public int tirarDado() {

        this.valor = (int) (Math.random() * 5 + 0);
        this.tirar = true;
        return this.valor;
    }// tirar dado
    
    /*
    * Recorre el arreglo de caras creando y guardando una nueva cara con su respectiva posicion
    * y dependiendo de la posicion guarda una mosca o una cara de dado
    */
    public void llenarCaras() throws IOException {
        for (int i = 0; i < this.carasDado.length; i++) {
            if (i == 0 || i == this.carasDado.length - 1) {
                this.carasDado[i] = new Mosca(this.posX, this.posY);
            } else {
                this.carasDado[i] = new ColorCara(this.posX, this.posY);
            }
        }
    }//llenarCaras
    
    public void dibujar(Graphics g) {

        if (this.valor == 0 || this.valor == this.carasDado.length - 1) {
            g.drawImage(this.carasDado[0].getImagen(), this.posX+40, this.posY, null);
        } else {
            switch (this.valor) {
                case 1:
                    g.setColor(new Color(255, 102, 0));
                    g.fillRect(this.posX, this.posY, this.carasDado[this.valor].getTam(),
                            this.carasDado[this.valor].getTam());
                    break;
                case 2:
                    g.setColor(new Color(127, 42, 218));
                    g.fillRect(this.posX, this.posY, this.carasDado[this.valor].getTam(),
                            this.carasDado[this.valor].getTam());
                    break;
                case 3:
                    g.setColor(new Color(255, 212, 42));
                    g.fillRect(this.posX, this.posY, this.carasDado[this.valor].getTam(),
                            this.carasDado[this.valor].getTam());
                    break;
                case 4:
                    g.setColor(new Color(255, 0, 102));
                    g.fillRect(this.posX, this.posY, this.carasDado[this.valor].getTam(),
                            this.carasDado[this.valor].getTam());
                    break;
            }//switch
        }//else
    }//dibujar

}// fin clase
