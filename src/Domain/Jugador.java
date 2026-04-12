/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

/**
 *
 * @author Jose Ignacio Alvarado Meneses C20355 Maria Celeste Salazar Ulloa C27159
 */
public class Jugador {
    
    private String nombre;
    private Rana rana;
    private int vueltas;
    private boolean gana;
    private int palilloResultado;
    
    private int posActual;
    private int posInicial;
    
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.vueltas = 0;
    }//constructor

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rana getRana() {
        return rana;
    }

    public void setRana(Rana rana) {
        this.rana = rana;
    }

    public int getVueltas() {
        return vueltas;
    }

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }
    
    public void vueltasRecoridas(){
        this.vueltas++;
    }

    public boolean isGana() {
        return gana;
    }

    public void setGana(boolean gana) {
        this.gana = gana;
    }

    public int getPalilloResultado() {
        return palilloResultado;
    }

    public void setPalilloResultado(int palilloResultado) {
        this.palilloResultado = palilloResultado;
    }

    public int getPosInicial() {
        return posInicial;
    }

    public void setPosInicial(int posInicial) {
        this.posInicial = posInicial;
    } 

    public int getPosActual() {
        return posActual;
    }

    public void setPosActual(int posActual) {
        this.posActual = posActual;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", rana=" + rana + ", vueltas=" + vueltas + ", gana=" + gana + ", palilloResultado=" + palilloResultado + '}';
    }
   
}//fin clase
