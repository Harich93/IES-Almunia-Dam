/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.app.main;

import client.Cliente;
import client.Interfaz;
import java.io.IOException;
import java.net.InetAddress;
import javax.swing.JOptionPane;

/**
 *
 * @author beni-
 */
public class AppCliente {
    
    static int usuario = 0;
    
    public static void main(String[] args) throws IOException {
        
        String nombreUsuario = establecerUsuario();
        String ip = establecerIp();
        
        Cliente cliente = new Cliente( nombreUsuario, ip );
       
        Interfaz interfaz = new Interfaz(nombreUsuario, cliente);
        interfaz.setVisible(true);
        
        cliente.recibir( interfaz.getTxtChat() );

    }
    
    private static String establecerUsuario(){
        String nombreUsuario = JOptionPane.showInputDialog(null, "Introduzca nombre:", "Usuario", 3);
        if( nombreUsuario.equalsIgnoreCase("") ) nombreUsuario = String.valueOf("Ususario: " + (usuario + 1) );
        return nombreUsuario;
    }
    
    private static String establecerIp(){
        String ip = JOptionPane.showInputDialog(null, "Introduzca ip servidor:", "Ip", 3);
        if( ip.equalsIgnoreCase("") ) ip = String.valueOf("192.168.1.129");
        return ip;
    }
}
