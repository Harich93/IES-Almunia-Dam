/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import client.Cliente;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author beni-
 */
public class Administrador {
    int puerto = 16893;
    
    Socket cliente;
    
    DataOutputStream dataOut;
    DataInputStream dataIn;
  
    
    public Administrador (  String ip  ) throws UnknownHostException, IOException {
        
        cliente = new Socket( ip, puerto );
        
        dataOut = new DataOutputStream( cliente.getOutputStream() );
        
   
    }//Contructor
    
    public void banear( String socket) throws IOException, ClassNotFoundException {
        String port = getPort(socket);
        dataOut.writeUTF(port);
    }
    
    public void enviar( String msg ) throws IOException {
        dataOut.writeUTF(msg);
    }
    
    public List<String> getConexiones() throws IOException, ClassNotFoundException {
        dataOut.writeUTF("**getLista**");
        dataIn = new DataInputStream(  cliente.getInputStream() );

        
        return toList( dataIn.readUTF() );
    }
    
    private List<String> toList( String cadena ) {
	List<String> list = new ArrayList<String>( Arrays.asList(cadena.split("Socket") )); 
        return list;
    }
    
    private String getPort( String socket) {
        String regEx= "(?<=port=)[0-9]+(?=,)";
        Pattern p=Pattern.compile(regEx);
        Matcher m=p.matcher(socket);
        boolean result=m.find();
        return m.group();
    }

    public void cerrarConexion(){
        try {
            dataOut.writeUTF("**fin**");
            dataOut.close();
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
