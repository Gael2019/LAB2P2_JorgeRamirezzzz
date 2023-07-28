/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2_jorgeramirezz;

/**
 *
 * @author Jorge Ramirez
 */
public class Gerente {
     private String usuario = "gerente";
    private String contrasena = "g3r$nt0";

    // Método para verificar las credenciales del gerente
    public boolean verificarCredenciales(String usuario, String contrasena) {
        return this.usuario.equals(usuario) && this.contrasena.equals(contrasena);
    }
}
