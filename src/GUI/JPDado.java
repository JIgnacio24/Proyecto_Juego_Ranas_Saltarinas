/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Domain.Dado;
import java.awt.Graphics;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jose Ignacio Alvarado Meneses C20355 Maria Celeste Salazar Ulloa C27159
 */
public class JPDado extends JPanel{
    private Dado dado;
    
    public JPDado(){
       
        this.setSize(300, 500);
        try {
            this.dado = new Dado(100,250);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error con el Dado");
        }  
    }

    public Dado getDado() {
        return dado;
    }

    @Override
    public void paintComponent (Graphics g){
        this.dado.dibujar(g);
    }
    
    
}//fin clase
