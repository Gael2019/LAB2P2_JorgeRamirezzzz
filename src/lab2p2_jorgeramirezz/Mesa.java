/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2_jorgeramirezz;

/**
 *
 * @author Jorge Ramirez
 */
public class Mesa {
    private int numPlatos;
    private int numUtensilios;
    private double precioTotal;
    
    public Mesa(int numPlatos, int numUtensilios, double precioTotal) {
        this.numPlatos = numPlatos;
        this.numUtensilios = numUtensilios;
        this.precioTotal = precioTotal;
    }
    
    public int getNumPlatos() {
        return numPlatos;
    }

    public void setNumPlatos(int numPlatos) {
        this.numPlatos = numPlatos;
    }

    public int getNumUtensilios() {
        return numUtensilios;
    }

    public void setNumUtensilios(int numUtensilios) {
        this.numUtensilios = numUtensilios;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

}
