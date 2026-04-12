/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Domain.Jugador;
import Domain.Nenufar;
import Domain.Tablero;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jose Ignacio Alvarado Meneses C20355 Maria Celeste Salazar Ulloa
 * C27159
 */
public class JPJuego extends JPanel {

    private Jugador[] jugadores;
    private Tablero tablero;
    private Nenufar nenufares[];
    private JLabel jlblmostraJugador;
    private int cont;

    public JPJuego(Jugador[] jugadores) {
        this.cont = 0;
        this.setSize(650, 650);
        this.jugadores = jugadores;

        this.jlblmostraJugador = new JLabel();
        this.jlblmostraJugador.setBounds(0, 0, 400, 40);
        this.add(this.jlblmostraJugador);
        this.jlblmostraJugador.setText("El jugador que tiene el turno es: " + this.jugadores[this.cont].getNombre());

        try {
            this.tablero = new Tablero();
            this.tablero.repartirMoscas();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error con el Tablero");
        }
        asignarPosicionesRana();
        añadirNenufares();
    }//constructor

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Nenufar[] getNenufares() {
        return nenufares;
    }

    public void setNenufares(Nenufar[] nenufares) {
        this.nenufares = nenufares;
    }

    public JLabel getJlblmostraJugador() {
        return jlblmostraJugador;
    }

    public void setJlblmostraJugador(JLabel jlblmostraJugador) {
        this.jlblmostraJugador = jlblmostraJugador;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    /*
    * Este metodo busca el color de cada jugador y crea su nenufar 
    *con su respectivo color y posicion en X y en Y
     */
    public void añadirNenufares() {
        this.nenufares = new Nenufar[this.jugadores.length];

        for (int i = 0; i < this.nenufares.length; i++) {

            switch (i) {
                case 0:
                    this.nenufares[i] = new Nenufar(this.jugadores[i].getRana().getPosX() + 120,
                            this.jugadores[i].getRana().getPosY() + 60);
                    this.nenufares[i].setColorNenufar(this.jugadores[i].getRana().getColor());

                    break;
                case 1:
                    this.nenufares[i] = new Nenufar(this.jugadores[i].getRana().getPosX() - 120,
                            this.jugadores[i].getRana().getPosY() - 80);
                    this.nenufares[i].setColorNenufar(this.jugadores[i].getRana().getColor());
                    break;
                case 2:
                    this.nenufares[i] = new Nenufar(this.jugadores[i].getRana().getPosX() + 70,
                            this.jugadores[i].getRana().getPosY() - 120);
                    this.nenufares[i].setColorNenufar(this.jugadores[i].getRana().getColor());
                    break;
                case 3:
                    this.nenufares[i] = new Nenufar(this.jugadores[i].getRana().getPosX() - 70,
                            this.jugadores[i].getRana().getPosY() + 120);
                    this.nenufares[i].setColorNenufar(this.jugadores[i].getRana().getColor());
                    break;
                default:
                    throw new AssertionError();
            }

        }

    }

    /*
    * Dependiendo de la cantidad de jugadores les asigna una posicion dentro del tablero
    * y guarda la posicion inicial en la que cada jugador se encuentra
    */
    public void asignarPosicionesRana() {

        if (this.jugadores.length == 2) {
            this.jugadores[0].getRana().setPosX(this.tablero.getCasillas()[0].getPosX() + 10);
            this.jugadores[0].getRana().setPosY(this.tablero.getCasillas()[0].getPosY() + 10);
            this.jugadores[0].setPosInicial(0);
            this.jugadores[0].setPosActual(this.jugadores[0].getPosInicial());

            this.jugadores[1].getRana().setPosX(this.tablero.getCasillas()[10].getPosX() + 10);
            this.jugadores[1].getRana().setPosY(this.tablero.getCasillas()[10].getPosY() + 10);
            this.jugadores[1].setPosInicial(10);
            this.jugadores[1].setPosActual(this.jugadores[1].getPosInicial());

        } else if (this.jugadores.length == 3) {
            this.jugadores[0].getRana().setPosX(this.tablero.getCasillas()[0].getPosX() + 10);
            this.jugadores[0].getRana().setPosY(this.tablero.getCasillas()[0].getPosY() + 10);
            this.jugadores[0].setPosInicial(0);
            this.jugadores[0].setPosActual(this.jugadores[0].getPosInicial());

            this.jugadores[1].getRana().setPosX(this.tablero.getCasillas()[10].getPosX() + 10);
            this.jugadores[1].getRana().setPosY(this.tablero.getCasillas()[10].getPosY() + 10);
            this.jugadores[1].setPosInicial(10);
            this.jugadores[1].setPosActual(this.jugadores[1].getPosInicial());

            this.jugadores[2].getRana().setPosX(this.tablero.getCasillas()[5].getPosX() + 10);
            this.jugadores[2].getRana().setPosY(this.tablero.getCasillas()[5].getPosY() + 10);
            this.jugadores[2].setPosInicial(5);
            this.jugadores[2].setPosActual(this.jugadores[2].getPosInicial());

        } else if (this.jugadores.length == 4) {
            this.jugadores[0].getRana().setPosX(this.tablero.getCasillas()[0].getPosX() + 10);
            this.jugadores[0].getRana().setPosY(this.tablero.getCasillas()[0].getPosY() + 10);
            this.jugadores[0].setPosInicial(0);
            this.jugadores[0].setPosActual(this.jugadores[0].getPosInicial());

            this.jugadores[1].getRana().setPosX(this.tablero.getCasillas()[10].getPosX() + 10);
            this.jugadores[1].getRana().setPosY(this.tablero.getCasillas()[10].getPosY() + 10);
            this.jugadores[1].setPosInicial(10);
            this.jugadores[1].setPosActual(this.jugadores[1].getPosInicial());

            this.jugadores[2].getRana().setPosX(this.tablero.getCasillas()[5].getPosX() + 10);
            this.jugadores[2].getRana().setPosY(this.tablero.getCasillas()[5].getPosY() + 10);
            this.jugadores[2].setPosInicial(5);
            this.jugadores[2].setPosActual(this.jugadores[2].getPosInicial());

            this.jugadores[3].getRana().setPosX(this.tablero.getCasillas()[15].getPosX() + 10);
            this.jugadores[3].getRana().setPosY(this.tablero.getCasillas()[15].getPosY() + 10);
            this.jugadores[3].setPosInicial(15);
            this.jugadores[3].setPosActual(this.jugadores[3].getPosInicial());

        }

    }//asignarPosiciones

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 650, 650);

        g.setColor(new Color(85, 153, 255));
        g.fillRect(30, 30, 550, 550);

        for (int i = 0; i < this.tablero.getCasillas().length; i++) {
            this.tablero.getCasillas()[i].dibujar(g);
            if (this.tablero.getCasillas()[i].getMosca() != null) {
                this.tablero.getCasillas()[i].getMosca().dibujar(g);
            }
        }

        switch (this.jugadores.length) {
            case 2:
                this.jugadores[0].getRana().dibujar(g);
                this.jugadores[1].getRana().dibujar(g);
                this.nenufares[0].dibujar(g);
                this.nenufares[1].dibujar(g);

                break;
            case 3:
                this.jugadores[0].getRana().dibujar(g);
                this.jugadores[1].getRana().dibujar(g);
                this.jugadores[2].getRana().dibujar(g);
                this.nenufares[0].dibujar(g);
                this.nenufares[1].dibujar(g);
                this.nenufares[2].dibujar(g);

                break;
            case 4:
                this.jugadores[0].getRana().dibujar(g);
                this.jugadores[1].getRana().dibujar(g);
                this.jugadores[2].getRana().dibujar(g);
                this.jugadores[3].getRana().dibujar(g);
                this.nenufares[0].dibujar(g);
                this.nenufares[1].dibujar(g);
                this.nenufares[2].dibujar(g);
                this.nenufares[3].dibujar(g);

                break;

        }
    }

}//fin clase
