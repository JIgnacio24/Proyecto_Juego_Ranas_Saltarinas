/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.io.IOException;

/**
 *
 * @author Jose Ignacio Alvarado Meneses C20355 Maria Celeste Salazar Ulloa C27159
 */
public class Tablero {

    private Nenufar[] nenufares;
    private Casilla[] casillas;
    private int cont = 0;
    private int numCirculosLado;
    private int margen;
    private int sepCirculos;

    public Tablero() throws IOException {

        this.casillas = new Casilla[20];
        this.margen = 30;
        this.sepCirculos = 70 + 10;
        this.numCirculosLado = 7;
        calcularCoordenadasCirculos();
        darColor();

    }//constructor

    public Nenufar[] getNenufares() {
        return nenufares;
    }

    public void setNenufares(Nenufar[] nenufares) {
        this.nenufares = nenufares;
    }

    public Casilla[] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[] casillas) {
        this.casillas = casillas;
    }

    @Override
    public String toString() {
        return "Tablero{" + "nenufares=" + nenufares + ", casillas=" + casillas + ", moscasCasilla=" + '}';
    }

    /*
    *genera 8 numeros aleatorios y crea una mosca en las posiciones de la casilla
    *correspondiente al numero del random
    */
    public void repartirMoscas() throws IOException {

        int hayMosca, contMoscas = 0;

        while (contMoscas < 8) {
            hayMosca = (int) (Math.random() * 19 + 0);
            if (hayMosca == 0) {
                if (this.casillas[hayMosca + 1].getMosca() != null) {
                    this.casillas[0].setMosca(new Mosca(this.casillas[0].getPosX() + 20,
                            this.casillas[0].getPosY() + 20));
                    contMoscas++;
                }
            } else if (hayMosca == this.casillas.length - 1) {
                if (this.casillas[hayMosca - 1] != null) {
                    this.casillas[hayMosca].setMosca(new Mosca(this.casillas[0].getPosX() + 20,
                            this.casillas[hayMosca].getPosY() + 20));
                    contMoscas++;
                }
            } else if (hayMosca == this.casillas.length - 1 && this.casillas[hayMosca - 1].getMosca() == null) {
                this.casillas[hayMosca].setMosca(new Mosca(this.casillas[hayMosca].getPosX() + 20,
                        this.casillas[hayMosca].getPosY() + 20));
            } else if (this.casillas[hayMosca].getMosca() == null && this.casillas[hayMosca - 1].getMosca()
                    == null && this.casillas[hayMosca + 1].getMosca() == null) {
                this.casillas[hayMosca].setMosca(new Mosca(this.casillas[hayMosca].getPosX() + 20,
                        this.casillas[hayMosca].getPosY() + 20));
                contMoscas++;
            }

        }//while
    }//repartirMoscas

    /*
    *Genera las posiciones en X y Y de las casillas por cada lado
    * calculando la distancia y la separacion con las anteriores
    * cada for se encarga de generar cada lado con sus casillas
    */
    private void calcularCoordenadasCirculos() {

        for (int i = 1; i < numCirculosLado - 1; i++) {
            int posX = margen;
            int posY = margen + i * sepCirculos;
            this.casillas[this.cont] = new Casilla(posX, posY);
            this.cont++;

        }//for izquierda
        
        for (int i = 1; i < numCirculosLado - 1; i++) {
            int posX = margen + i * sepCirculos;
            int posY = margen + (numCirculosLado - 1) * sepCirculos;
            this.casillas[this.cont] = new Casilla(posX, posY);
            this.cont++;
        }//for inferior
        
        for (int i = numCirculosLado - 2; i >= 1; i--) {
            int posX = margen + (numCirculosLado - 1) * sepCirculos;
            int posY = margen + i * sepCirculos;
            this.casillas[this.cont] = new Casilla(posX, posY);
            this.cont++;

        }//for derecha        
       
         for (int i = numCirculosLado - 2; i >= 1; i--) {
            int posX = margen + i * sepCirculos;
            int posY = margen;
            this.casillas[this.cont] = new Casilla(posX, posY);
            this.cont++;
        }//for superior

    }//calcular ordenadas

    /*
    * Este metodo da color a cada cara dependiendo del resultado del random
    * y verifica que no sean repetidos
    */
    public void darColor() {
        int colorNum = (int) (Math.random() * 4 + 1), cont = 1;
        this.casillas[0].darColor(colorNum);
        this.casillas[0].setColor(colorNum);
        colorNum = 0;
        while (cont <= 19) {
            colorNum = (int) (Math.random() * 4 + 1);

            if (colorNum != this.casillas[cont - 1].getColor()) {
                this.casillas[cont].setColor(colorNum);
                this.casillas[cont].darColor(colorNum);
                cont++;
            }
        }//darColor
    }

}//fin clase



