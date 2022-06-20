/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.app.main;

import java.io.IOException;
import server.Servidor;

/**
 *
 * @author beni-
 */
public class AppServidor {
    
    public static void main(String[] args ) throws IOException {
        Servidor servidor = new Servidor();
        servidor.escucharCliente().start();
        servidor.escucharAdministrador().start();
    }
}
