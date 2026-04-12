/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Domain.Jugador;
import Domain.Rana;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTextField;

/**
 *
 * @author Jose Ignacio Alvarado Meneses C20355 Maria Celeste Salazar Ulloa C27159
 */
public class JIFLogin extends JInternalFrame implements ActionListener {

    private JComboBox<Integer> jcbJugadores;
    private JLabel jlblTitulo;
    private JLabel jlblNombreJugador;
    private JLabel jlblColorRana;
    private JLabel jlblNumJugadores;
    private JTextField jtfNombreJugador;
    private JButton jbtRegistrar;
    private JButton jbtcantJugadores;

    private JButton jbtnContinuar;

    private BufferedImage ranaImagen;

    private JButton jbtRana;
    private Color colorRanaSeleccionada;

    private Jugador[] jugadores;

    private int cont;

    public JIFLogin() throws IOException {
        JPFondo fondo = new JPFondo();
        this.cont = 0;

        this.ranaImagen = ImageIO.read(getClass().getResourceAsStream("/paquetederecursos/rana.png"));

        this.setSize(1000, 700);
        this.setLayout(null);

        jlblNombreJugador = new JLabel("Ranas Saltarinas Por Ignacio y Celeste");
        jlblNombreJugador.setBounds(280, 80, 540, 30);
        jlblNombreJugador.setFont(new Font("French Scrip MT", 1, 25));
        this.add(this.jlblNombreJugador);

        jlblNumJugadores = new JLabel("Dijite la cantidad de Jugadores");
        jlblNumJugadores.setBounds(180, 180, 500, 30);
        jlblNumJugadores.setFont(new Font("French Scrip MT", 1, 20));
        this.add(this.jlblNumJugadores);

        jlblColorRana = new JLabel("Dijite el Nombre del Jugador");
        jlblColorRana.setBounds(180, 285, 500, 30);
        jlblColorRana.setFont(new Font("French Scrip MT", 1, 20));
        this.add(this.jlblColorRana);

        jlblTitulo = new JLabel("Seleccione el color de tú Rana");
        jlblTitulo.setBounds(180, 340, 500, 30);
        jlblTitulo.setFont(new Font("French Scrip MT", 1, 20));
        this.add(this.jlblTitulo);

        jtfNombreJugador = new JTextField();
        jtfNombreJugador.setBounds(470, 285, 100, 30);
        this.add(this.jtfNombreJugador);

        jcbJugadores = new JComboBox<>();
        jcbJugadores.setBounds(500, 180, 40, 30);
        jcbJugadores.addItem(2);
        jcbJugadores.addItem(3);
        jcbJugadores.addItem(4);
        this.add(this.jcbJugadores);

        this.jbtRegistrar = new JButton("Registrar");
        this.add(jbtRegistrar);
        this.jbtRegistrar.setBounds(780, 550, 100, 30);
        this.jbtRegistrar.addActionListener(this);

        this.jbtRana = new JButton();
        this.add(jbtRana);
        this.jbtRana.setBackground(Color.GREEN);
        this.jbtRana.setIcon(new ImageIcon(ranaImagen));
        this.jbtRana.setBounds(500, 380, 50, 50);
        this.jbtRana.addActionListener(this);

        this.jbtcantJugadores = new JButton("Seran los jugadores");
        this.jbtcantJugadores.setBounds(550, 180, 150, 30);
        this.add(jbtcantJugadores);
        this.jbtcantJugadores.addActionListener(this);

        this.jbtnContinuar = new JButton("Continuar");
        this.jbtnContinuar.setBounds(780, 550, 100, 30);
        this.jbtnContinuar.addActionListener(this);
        this.add(this.jbtnContinuar);
        this.jbtnContinuar.setVisible(false);
        this.add(fondo);
    }//consturctor

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.jbtcantJugadores) {
            this.jugadores = new Jugador[(Integer) jcbJugadores.getSelectedItem()];
            this.cont = 0;
        }
        if (e.getSource() == this.jbtRana) {
            JColorChooser seleccionado = new JColorChooser();
            this.colorRanaSeleccionada = seleccionado.showDialog(this,
                    "Seleccione el color de una Rana", null);
            this.jbtRana.setBackground(this.colorRanaSeleccionada);

        } else if (e.getSource() == this.jbtRegistrar) {

            if (this.jugadores != null) {
                
                if (!this.jtfNombreJugador.getText().equals("")) {
                    
                    if (!(this.colorRanaSeleccionada == null)) {
                        
                        if (revisarNombre() && revisarRana()) {
                            llenarJugadores();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No se seleccionó el color de la Rana");
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "No se indicó el nombre del Jugador: " + (this.cont + 1));
                }

                if (this.cont >= this.jugadores.length) {
                    this.jbtRegistrar.setVisible(false);
                    this.jbtnContinuar.setVisible(true);
                }

            } else {
                JOptionPane.showMessageDialog(this, "No se indicó la cantidad de Jugadores");
            }

        }
        if (this.jbtnContinuar == e.getSource()) {
            JIFMostrarAsignarTurnos jifRevuelvePalillo = new JIFMostrarAsignarTurnos(this.jugadores);
            this.getDesktopPane().add(jifRevuelvePalillo);
            jifRevuelvePalillo.setVisible(true);
            this.setVisible(false);
        }
        this.repaint();
    }
    
     /*
    * Este metodo revisa lo que este seleccionado en el JTextField y 
    * verifica con los anteriores registros si hay similitud en caso de no haber
    * devuelve un true 
    */

    public boolean revisarNombre() {

        if (this.cont < this.jugadores.length) {
            int verificados = 0;
            if (this.cont != 0) {
                int j = this.cont - 1;
                while (verificados < this.cont) {
                    if (this.jtfNombreJugador.getText().equalsIgnoreCase(this.jugadores[j].getNombre()) && j >= 0 ) {
                        JOptionPane.showMessageDialog(rootPane,
                                "Este nombre no se encuentra disponible", "Error de Nombre", JOptionPane.ERROR_MESSAGE);
                        verificados++;
                        j--;
                        return false;
                    }
                    verificados++;
                    j--;
                }
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Se alcanzó el limite de jugadores", "Limite de Jugadores", ERROR_MESSAGE);
        }
        return true;
    }
    
    /*
    * Este metodo revisa lo que este seleccionado en el JColorChooser y 
    * verifica con los anteriores registros si hay similitud en caso de  no haber
    * devuelve un true 
    */

    public boolean revisarRana() {
        if (this.cont < this.jugadores.length) {
            int verificados = 0;
            if (this.cont != 0) {
                int j = this.cont - 1;
                while (verificados < this.cont) {
                    if (this.colorRanaSeleccionada == this.jugadores[j].getRana().getColor() && j >= 0) {
                        JOptionPane.showMessageDialog(rootPane,
                                "Ese color no se encuentra disponible", "Error de Rana", JOptionPane.ERROR_MESSAGE);
                        verificados++;
                        j--;
                        return false;
                    }
                    verificados++;
                    j--;
                }
                return true;
            }

        }
        return true;
    }
    
    /*
    * Este metodo crea un nuevo Jugador dentro del arreglo tomando el String que este
    * dentro del jTextField y el color guardado con el JColorChooser y añadiendo ese jugador al arreglo
    */

    public void llenarJugadores() {
        if (this.cont < this.jugadores.length) {
            this.jugadores[this.cont] = new Jugador(this.jtfNombreJugador.getText());
            JOptionPane.showMessageDialog(this, "El regisro del jugador #" + (this.cont + 1)
                    + " se completo");
            try {
                this.jugadores[this.cont].setRana(new Rana(this.colorRanaSeleccionada));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, "Error con el registro del Jugador # " + this.cont + 1);
            }
            this.cont++;
        }
    }//llenarJugadores

}//fin clase
