/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author beni-
 */
public class HiloAdministrador extends Thread {
    
    ArrayList<Socket> conexiones;
    Socket conexion;

    
    DataInputStream dataIn;
    DataOutputStream out;
    
    String nombreUsuario;
    String msg = "";
  
   
    public HiloAdministrador( Socket conexion, ArrayList<Socket> conexiones ) throws IOException {
        
        this.conexion = conexion;
        this.conexiones = conexiones;  
        
        out = new DataOutputStream( conexion.getOutputStream() );
        dataIn = new DataInputStream( conexion.getInputStream() );
        
        enviarListaConexiones();
        this.start();
    }//Constructor
    

    public void banear( String puerto ) throws IOException {
        
        for( int i = 0; i < conexiones.size(); i++ ){
           
            String port = String.valueOf(conexiones.get(i).getPort());
           
            if( port.equalsIgnoreCase(puerto)){
                conexiones.forEach( con -> {
                    try {
                        out = new DataOutputStream( con.getOutputStream() );
                        out.writeUTF(puerto + ": ha sido baneado\n");
                    } catch (IOException ex) {
                        Logger.getLogger(HiloAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                });//forEach
                out = new DataOutputStream( conexiones.get(i).getOutputStream() );
                out.writeUTF("**baneado**");
                break;
            }//if
            
        }//for
        
        out = new DataOutputStream( conexion.getOutputStream() );
        
    }
    
    private void desconexion() {
         try {
            conexiones.remove(conexion);
            System.err.println("Conexion cerrada: " + conexion.toString());
            dataIn.close();
            out.close();
            conexion.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void enviarListaConexiones() throws IOException  {

        String o = socketToString();
        out.writeUTF( o );
    }
    
    private String socketToString(){
        
        StringBuilder arr = new StringBuilder();
        
        for( int i = 0; i < conexiones.size(); i++ )
            arr.append(conexiones.get(i).toString());
        
        
        return arr.toString();
    }
    
    @Override
    public void run() {
       
        while( !msg.equalsIgnoreCase("**fin**") ) {

            try {
                
                msg = dataIn.readUTF().toString();
                
                if( msg.equalsIgnoreCase("**getLista**") ){
                    enviarListaConexiones();
                }
                else {
                    banear( msg );
                }
               
            
            } catch (IOException ex) {
                desconexion();
                Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }//while
        
       desconexion();
        
        
    }//run
    
}
