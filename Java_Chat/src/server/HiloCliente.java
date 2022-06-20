/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author beni-
 */
public class HiloCliente extends Thread {
    
    ArrayList<Socket> conexiones;
    Socket conexion = new Socket();
    
    DataInputStream dataIn;
    DataOutputStream dataOut;
    
    String nombreUsuario;
    String msg = "";
    StringBuilder historial;
   
    public HiloCliente( Socket conexion, ArrayList<Socket> conexiones, StringBuilder historial ) throws IOException {
        this.conexion = conexion;
        this.conexiones = conexiones;
        dataIn = new DataInputStream( conexion.getInputStream() );
        
        this.historial = historial;
        conexionChat();
        
        this.start();
    }//Constructor
    
    private void conexionChat() throws IOException {
        dataIn = new DataInputStream( conexion.getInputStream() );
        
        nombreUsuario = dataIn.readUTF();
        
        if( nombreUsuario.equalsIgnoreCase("Administrador")) {
            dataOut = new DataOutputStream( conexion.getOutputStream() );
            dataOut.writeUTF(historial.toString());
        }
        else {
            conexiones.forEach( con -> {
                try {

                    dataOut = new DataOutputStream( con.getOutputStream() );
                    dataOut.writeUTF(nombreUsuario + " ha entrado en el chat.\n");
                    historial.append(nombreUsuario + " ha entrado en el chat.\n");
                } catch (IOException ex) { System.err.println("Error conexionChat() dataOut: " + ex.toString() ); }
            });//Foreach
        }
        
    }
    
    private void enviarMensajes() {
        conexiones.forEach(con -> {
            try {
                dataOut = new DataOutputStream( con.getOutputStream() );
                dataOut.writeUTF(nombreUsuario+ ": " + conexion.getPort() + " -> " + msg + "\n");
                historial.append(nombreUsuario+ ": " + conexion.getPort() + " -> " + msg + "\n");
            } catch (IOException ex) {  System.err.println("Error dataOut forEach run(): " + ex.toString() ); }
        });//ForEach
    }
   
    private void salirDeSala() {
        conexiones.forEach(con -> {
            try {
                dataOut = new DataOutputStream( con.getOutputStream() );
                dataOut.writeUTF(nombreUsuario + " ha salido del chat.\n");
            } catch (IOException ex) {  System.err.println("Error dataOut forEach run(): " + ex.toString() ); }
        });//ForEach
    }

    public void desconectar() {
        try {
            conexiones.remove(conexion);
            System.err.println("Conexion cerrada: " + conexion.toString());
            dataIn.close();
            dataOut.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
       
        while( !msg.equalsIgnoreCase("**fin**") ) {

            try {
                
                dataIn = new DataInputStream( conexion.getInputStream() );
                msg = dataIn.readUTF();
                

                
                if( !msg.equalsIgnoreCase("**fin**") ) {
                    enviarMensajes();
                }
                else if( msg.equalsIgnoreCase("**fin**") ){
                    salirDeSala();
                    desconectar();
                }
                
            
            } catch (IOException ex) {
                salirDeSala();
                desconectar();
                Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }//while
        
        desconectar();
        
        
    }//run
    
}//Class
