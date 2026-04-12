/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;

/**
 *
 * @author Jose Ignacio Alvarado Meneses C20355 Maria Celeste Salazar Ulloa C27159
 */
public class JIFPortada extends JInternalFrame implements ActionListener {

    private JIFLogin jifLogin;

    private BufferedImage portada;
    private int posX;
    private int posY;
    private JButton jbtJugar;

    public JIFPortada(int posX, int posY, JIFLogin jifLoging) throws IOException {
        this.setSize(1000, 700);
        this.jifLogin = jifLoging;
        this.posX = posX;
        this.posY = posY;
        this.portada = ImageIO.read(getClass().getResourceAsStream("/paquetederecursos/Portada.png"));

        this.jbtJugar = new JButton();
        this.jbtJugar.setIcon(new ImageIcon(portada));
        this.add(this.jbtJugar);
        this.jbtJugar.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.jbtJugar) {
            this.setVisible(false);
            this.jifLogin.setVisible(true);
        }

    }

}//fin clase
