/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Domain.Jugador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Ignacio Alvarado Meneses C20355 Maria Celeste Salazar Ulloa C27159
 */
public class JIFMostrarAsignarTurnos extends JInternalFrame implements ActionListener {

    private JButton[] jbtpalos;
    private JButton jbtncontinuar;
    private JLabel jlblMostrarJugador;
    private Jugador[] jugadoresTurno;
    private int cont;

    public JIFMostrarAsignarTurnos(Jugador[] jugadores) {
        this.setSize(1000, 700);
        this.cont = 0;
        this.setLayout(null);

        this.jugadoresTurno = jugadores;
        this.jbtpalos = new JButton[4];
        botonPalillo();
        mostrarPalillos();

        this.jbtncontinuar = new JButton("Continuar");
        this.jbtncontinuar.setBounds(750, 550, 100, 30);
        this.jbtncontinuar.addActionListener(this);
        this.add(this.jbtncontinuar);
        this.jbtncontinuar.setVisible(false);

        this.jlblMostrarJugador = new JLabel();
        this.jlblMostrarJugador.setBounds(0, 0, 400, 40);
        this.add(this.jlblMostrarJugador);
        this.jlblMostrarJugador.setText("Esta escogiendo el jugador: " + this.jugadoresTurno[this.cont].getNombre());

        try {

            JPAsignarTurnos jpAsignarTurnos = new JPAsignarTurnos(jugadores);

            this.add(jpAsignarTurnos);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error al cargar Los palitos");
        }

    }// constructor
    
    /*
    * Genera la cantidad de botones con la cantidad de jugadores para 
    * crearlos e implementalos al panel
    */

    public void botonPalillo() {
        int posX = 50, posY = 50;
        for (int i = 0; i < this.jbtpalos.length; i++) {
            this.jbtpalos[i] = new JButton();
            this.jbtpalos[i].setBounds(posX, posY, 50, 240);
            this.jbtpalos[i].setBackground(Color.blue);
            this.jbtpalos[i].addActionListener(this);
            this.add(this.jbtpalos[i]);
            this.jbtpalos[i].setVisible(false);
            posX += 100;
        }
    }//botonPalillo

    public void mostrarPalillos() {
        for (int i = 0; i < this.jugadoresTurno.length; i++) {
            this.jbtpalos[i].setVisible(true);
        }

    }

    /*
    * Este metodo ordena los jugadores dentro de su arreglo dependiendo del valor
    * del palillo que escogieron
    */
    public void ordenarJugadores() {
        Jugador temp;
        for (int i = 0; i < this.jugadoresTurno.length - 1; i++) {
            for (int j = 0; j < this.jugadoresTurno.length - 1; j++) {
                if (this.jugadoresTurno[j].getPalilloResultado() < this.jugadoresTurno[j + 1].getPalilloResultado()) {
                    temp = this.jugadoresTurno[j];
                    this.jugadoresTurno[j] = this.jugadoresTurno[j + 1];
                    this.jugadoresTurno[j + 1] = temp;
                }
            }

        }
    }//ordenarJugadores

    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.jbtpalos[0] == e.getSource()) {
            this.jugadoresTurno[this.cont].setPalilloResultado(1);
            this.jbtpalos[0].setVisible(false);
            this.cont++;
            if (this.cont < this.jugadoresTurno.length) {
                this.jlblMostrarJugador.setText("Esta escogiendo el jugador: " + this.jugadoresTurno[this.cont].getNombre());
            }
        }

        if (this.jbtpalos[1] == e.getSource()) {
            this.jugadoresTurno[this.cont].setPalilloResultado(2);
            this.jbtpalos[1].setVisible(false);
            this.cont++;
            if (this.cont < this.jugadoresTurno.length) {
                this.jlblMostrarJugador.setText("Esta escogiendo el jugador: " + this.jugadoresTurno[this.cont].getNombre());
            }
        }

        if (this.jbtpalos[2] == e.getSource()) {
            this.jugadoresTurno[this.cont].setPalilloResultado(3);
            this.jbtpalos[2].setVisible(false);
            this.cont++;
            if (this.cont < this.jugadoresTurno.length) {
                this.jlblMostrarJugador.setText("Esta escogiendo el jugador: " + this.jugadoresTurno[this.cont].getNombre());
            }
        }

        if (this.jbtpalos[3] == e.getSource()) {
            this.jugadoresTurno[this.cont].setPalilloResultado(4);
            this.jbtpalos[3].setVisible(false);
            this.cont++;
            if (this.cont < this.jugadoresTurno.length) {
                this.jlblMostrarJugador.setText("Esta escogiendo el jugador: " + this.jugadoresTurno[this.cont].getNombre());
            }
        }

        if (this.cont == this.jugadoresTurno.length) {
            this.jbtncontinuar.setVisible(true);
        }

        if (this.jbtncontinuar == e.getSource()) {
            ordenarJugadores();
            JIFMostrarJuego mostrarJuego = new JIFMostrarJuego(this.jugadoresTurno);
            JIFMostrarDado mostrarDado = new JIFMostrarDado(mostrarJuego);
            this.getDesktopPane().add(mostrarDado);
            this.getDesktopPane().add(mostrarJuego);
            mostrarDado.setLocation(800, 0);
            mostrarDado.setVisible(true);
            mostrarJuego.setVisible(true);
            this.setVisible(false);
        }

        this.repaint();
    }

}//fin clase
