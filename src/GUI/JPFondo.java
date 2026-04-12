/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jose Ignacio Alvarado Meneses C20355 Maria Celeste Salazar Ulloa C27159
 */
public class JPFondo extends JPanel{
    
    private BufferedImage fondo;

    public JPFondo() {
        this.setSize(1000, 700);
        
        try {
            this.fondo = ImageIO.read(getClass().getResourceAsStream("/paquetederecursos/fondo.jpg"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al Cargar el fondo");
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
            g.drawImage(this.fondo, 0, 0, null);
    }
    
}
