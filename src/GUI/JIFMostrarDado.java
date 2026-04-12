/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

/**
 *
 * @author Jose Ignacio Alvarado Meneses C20355 Maria Celeste Salazar Ulloa C27159
 */
public class JIFMostrarDado extends JInternalFrame implements ActionListener {

    private JPDado JPDado;
    private JButton jbttirarDado;
    private JLabel jlblresultado;
    private JIFMostrarJuego mostrarJuego;
    private int cont;

    public JIFMostrarDado(JIFMostrarJuego mostrarJuego) {
        this.cont = 0;
        this.mostrarJuego = mostrarJuego;
        this.setSize(300, 500);
        this.setLayout(null);

        this.JPDado = new JPDado();
        this.add(this.JPDado);

        this.jbttirarDado = new JButton("Tirar el Dado");
        this.jbttirarDado.setBounds(85, 60, 120, 30);
        this.jbttirarDado.addActionListener(this);
        this.add(this.jbttirarDado);

        this.jlblresultado = new JLabel("El resultado del Dado es:");
        this.jlblresultado.setBounds(85, 170, 300, 30);
        this.add(this.jlblresultado);
    }// connstructor    

    
    /*
    * Este metodo valida la posicion del jugador  y busca dentro del arreglo de casillas
    * la coincidencia con el resultdo del dado para mover el jugador a una casilla que se 
    * encuentre disposponible dependendio del artibuto boolean de cada casilla
    * Y habilita la casilla que dejo para que otro jugador pueda utilizarla
    */
    public void moverJugador(int resultado) {
        int x = 0;
        if(this.mostrarJuego.getJuego().getJugadores()[this.cont].getPosActual() == 0)
            x = 19;
        else 
            x = this.mostrarJuego.getJuego().getJugadores()[this.cont].getPosActual();

        for (int i = x; i >= 0; i--) {

            if (resultado == this.mostrarJuego.getJuego().getTablero().getCasillas()[i].getColor() 
                    && this.mostrarJuego.getJuego().getTablero().getCasillas()[i].isOcupada() == false) {
                
                    this.mostrarJuego.getJuego().getJugadores()[this.cont].getRana().
                            setPosX(this.mostrarJuego.getJuego().getTablero().getCasillas()[i].getPosX());
                    this.mostrarJuego.getJuego().getTablero().getCasillas()[i].setOcupada(true);
                     this.mostrarJuego.getJuego().getJugadores()[this.cont].setPosActual(i);
                break;
            }
        }

    }//moverJugador

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jbttirarDado) {
            moverJugador(this.JPDado.getDado().tirarDado());
            this.repaint();
            this.cont += 1;
            if (this.cont == this.mostrarJuego.getJuego().getJugadores().length)
                this.cont = 0;
            this.mostrarJuego.getJuego().getJlblmostraJugador().
                    setText("El jugador que tiene el turno es: "
                            + this.mostrarJuego.getJuego().getJugadores()[this.cont].getNombre());
            
            this.mostrarJuego.getJuego().repaint();
            
        }
    }

}// fin clase
