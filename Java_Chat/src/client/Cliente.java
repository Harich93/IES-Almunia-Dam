/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.swing.JTextPane;

/**
 *
 * @author beni-
 */
public class Cliente {
    
    int puerto = 90;
    
    Socket cliente;
    
    DataInputStream dataIn;
    DataOutputStream dataOut;
    
    public Cliente ( String usuario, String ip ) throws UnknownHostException, IOException {
        
        cliente = new Socket( ip, puerto );
        
        dataOut = new DataOutputStream( cliente.getOutputStream() );
        dataOut.writeUTF(usuario);
   
    }//Contructor
    
    public Cliente (  String ip, int puerto ) throws UnknownHostException, IOException {
        
        cliente = new Socket( ip, puerto );
        dataOut = new DataOutputStream( cliente.getOutputStream() );
        dataOut.writeUTF("Administrador");
        
    }//Contructor admin
    
    public void enviar( String msg ) throws IOException {
        dataOut.writeUTF(msg);
    }
    
    public void recibir( JTextPane chat ){
        try {
            while( true ) {
                dataIn = new DataInputStream( cliente.getInputStream() );
                String res = dataIn.readUTF();
                
                if( res.equalsIgnoreCase("**baneado**")){
                    dataOut.writeUTF("**fin**");
                }
                else
                    chat.setText( chat.getText() + res );
                
            }
       } catch (IOException ex) { }
    }
    
    public void cerrarConexion(){
        try {
            dataOut.writeUTF("**fin**");
            dataIn.close();
            dataOut.close();
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
