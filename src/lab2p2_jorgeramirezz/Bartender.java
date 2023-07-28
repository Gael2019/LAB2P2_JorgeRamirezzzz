/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2_jorgeramirezz;

/**
 *
 * @author Jorge Ramirez
 */
public class Bartender {
    private String nombre;
    private int edad;
    private String turno;
    private double sueldo;
    private int numLicoresDisponibles;
    
    public Bartender(String nombre, int edad, String turno, double sueldo, int numLicoresDisponibles) {
        this.nombre = nombre;
        this.edad = edad;
        this.turno = turno;
        this.sueldo = sueldo;
        this.numLicoresDisponibles = numLicoresDisponibles;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getNumLicoresDisponibles() {
        return numLicoresDisponibles;
    }

    public void setNumLicoresDisponibles(int numLicoresDisponibles) {
        this.numLicoresDisponibles = numLicoresDisponibles;
    }
    
}
