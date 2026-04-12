/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author Jose Ignacio Alvarado Meneses C20355 Maria Celeste Salazar Ulloa C27159
 */
public class Mosca extends Cara{
    
    public Mosca(int posX, int posY) throws IOException {
        super(posX, posY);
        this.imagen = ImageIO.read(getClass().getResourceAsStream("/paquetederecursos/moscadado.png"));
    }//constructor

    public void dibujar(Graphics g){
        g.drawImage(this.imagen, this.posX, this.posY, null);
    }//dibujar
    
      
}//fin clase
