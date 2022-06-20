/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.app.main;

import java.io.IOException;
import javax.swing.JOptionPane;
import admin.Administrador;
import admin.Interfaz;
import client.Cliente;
import server.Servidor;



/**
 *
 * @author beni-
 */
public class AppServidorInterfaz {
    
    public static void main(String[] args) throws IOException {
        
        Administrador administrador = new Administrador( "192.168.1.129" );
        Cliente clienteAdm = new Cliente( "192.168.1.129", 90 );
        
        Interfaz interfaz = new Interfaz( administrador, clienteAdm );
        interfaz.setVisible(true);
        
//        administrador.recibir( interfaz.getChat() ).start(); 
        clienteAdm.recibir( interfaz.getChat() );

        
    }
    
    private static String establecerIp(){
        String ip = JOptionPane.showInputDialog(null, "Introduzca ip servidor:", "Administrador", 3);
        if( ip.equalsIgnoreCase("") ) ip = String.valueOf("192.168.1.129");
        return ip;
    }

}
