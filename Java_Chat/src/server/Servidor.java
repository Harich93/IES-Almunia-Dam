/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author beni-
 */
public class Servidor {

    private final int PUERTO = 90;
    private final int PUERTO_ADMIN = 16893;
    private final int MAX_CONEXIONES = 20;
    
    private boolean stop = false;
    private ServerSocket servidor;
    private ServerSocket servidorAdmin;
    private ArrayList<Socket> conexiones;
    private InetAddress ip;
    private StringBuilder historial;
    
    public Servidor() throws UnknownHostException, IOException{
        
        historial = new StringBuilder();
        ip = establecerIp();
        conexiones = new ArrayList<Socket>();
       
        // Escuchando 2 puertos
        servidor = new ServerSocket( PUERTO, MAX_CONEXIONES, ip );
        servidorAdmin = new ServerSocket( PUERTO_ADMIN, 1, ip );
        
        System.err.println("Servidor iniciado... " + servidor.getInetAddress());
        
    }//constructor
    
    public Thread escucharCliente() {
        
        return new Thread() {
            @Override        
            public void run() { 
                while ( !stop ) {

                    try {

                        Socket conexion = servidor.accept();

                        System.err.println("Conexion establecida con: " + conexion.toString() );
                        conexiones.add(conexion);
                       
                        new HiloCliente( conexion, conexiones, historial  );

                    } //while
                    catch (IOException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                try {
                    servidor.close();
                    setStop();
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }//run
        };//Thread 
    }//escucharCliente
   
    public Thread escucharAdministrador(){
        return new Thread() {
            @Override        
            public void run() { 
                while ( !stop ) {

                    try {

                        Socket conexion = servidorAdmin.accept();

                        System.err.println("Conexion establecida con: " + conexion.toString() );
//                        conexiones.addConexion(conexion);
                       
                        new HiloAdministrador( conexion, conexiones );
                        

                    } //while
                    catch (IOException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                try {
                    servidor.close();
                    setStop();
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }//run
        };//Thread 
    }//escucharAdministrador;
    
    public void banear( String socket ) throws IOException {
        
        for( int i = 0; i < conexiones.size(); i++) {
            if( conexiones.get(i).toString().equalsIgnoreCase(socket) ) {
                conexiones.get(i).close();
                conexiones.remove(conexiones.get(i));
            }//if
        }//for
        
        conexiones.forEach( c -> System.err.println( c.toString() ));
        
    }//banear
    
    public void setStop(){
        stop = true;
    }//stop
    
    private InetAddress establecerIp() throws UnknownHostException{
        InetAddress ip = InetAddress.getByName("192.168.1.129");
        String ipString = JOptionPane.showInputDialog(null, "Introduzca ip servidor:", "Ip", 3);
        if( !ipString.equalsIgnoreCase("") ) ip = InetAddress.getByName(ipString);
        return ip;
    }//establecerIp
    
}
