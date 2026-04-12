/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.io.IOException;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Ignacio Alvarado Meneses C20355 Maria Celeste Salazar Ulloa C27159
 */
public class JFVentaPrincipal extends JFrame{

    private JDesktopPane desktoPane;
    private  JIFPortada jifPortada;
    
    public JFVentaPrincipal() throws IOException {
        
        this.setTitle("Ranas Saltarinas");
        this.setLocation(90, 30);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1200, 800);     
        
        this.desktoPane = new JDesktopPane();
         this.add(this.desktoPane);
        
        JIFLogin jifLogin = new JIFLogin();
        this.desktoPane.add(jifLogin);

        try {
             this.jifPortada = new JIFPortada(180, 40, jifLogin);
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error en la Ventana Principal");
        }
    this.desktoPane.add(this.jifPortada);
    this.jifPortada.setVisible(true);
 
    }//constructor
    
}//fin clase
