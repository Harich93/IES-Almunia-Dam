/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import clases.Pregunta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author beni-
 */
public class DAOCuestionario {
    
    Connection conexion;
    private static DAOCuestionario dao;
    
    
    
    public static DAOCuestionario getDAOCuestionario(){
        if( dao == null ) dao = new DAOCuestionario();
        return dao; 
    }

    private DAOCuestionario(){
        conexionBD();
    }
    
    private void conexionBD(){
        
        String conexionUrl = 
            "jdbc:sqlserver://DESKTOP-KE2530F\\MSSQLSERVER1.database.windows.net:1433;"
                + "database=TestJava;"
                + "user=harich;"
                + "password=12345;"
                + "encrypt=false;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";

        try {
            this.conexion = DriverManager.getConnection(conexionUrl);

        } catch (Exception e) {
            System.out.println( "Error en la conexion. " + e.toString() );
        }
    }

    public ArrayList<Pregunta> getPreguntas( int dificultad ){
       
        ArrayList<Pregunta> arr = new ArrayList();
        
        try {
            
            
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM Pregunta WHERE dificultad = ?");
            ps.setInt(1,dificultad);
            
            ResultSet rs = ps.executeQuery();
            
            while ( rs.next() ) {
                
                Pregunta p = new Pregunta();
                p.setId(rs.getInt("id"));
                p.setCuestion(rs.getString("cuestion"));
                p.setRespuestaCorrecta(rs.getInt("correcta"));
                p.setDificultad(rs.getInt("dificultad"));
                String[] res = new String[4];
                res[0] = rs.getString("respuesta1");
                res[1] = rs.getString("respuesta2");
                res[2] = rs.getString("respuesta3");
                res[3] = rs.getString("respuesta4");
                
                p.setRespuestas(res);
                
                arr.add(p);
            }
            
            
        } catch (SQLException ex) {
            System.err.println("Error getPreguntas" + ex.toString());
        }
        
        return arr;
    }
    
    public void borrar( Pregunta p ){
        try {
            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM Pregunta where id = ?");
            stmt.setInt(1, p.getId() );
            stmt.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(DAOCuestionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void nueva( Pregunta p )  {  
        
        try {
            PreparedStatement stmt = conexion.prepareStatement("insert into Pregunta (cuestion, respuesta1, respuesta2, respuesta3, respuesta4, correcta, dificultad) values (?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setString(1, p.getCuestion());
            
            String[] r = p.getRespuestas();
            stmt.setString(2, r[0]);
            stmt.setString(3, r[1]);
            stmt.setString(4, r[2]);
            stmt.setString(5, r[3]);
            
            stmt.setInt(6, p.getRespuestaCorrecta());
            stmt.setInt(7, p.getDificultad() );
            
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al agregar nueva pregunta" + ex.toString());
        }
    }
    
    public void modificar( Pregunta p ){

        try {
            PreparedStatement stmt = conexion.prepareStatement("UPDATE Pregunta SET cuestion = ?, respuesta1 = ?, respuesta2 = ?, respuesta3 = ?, correcta = ?, dificultad = ? WHERE id = ?");
            
            stmt.setString(1, p.getCuestion());
            
            String[] r = p.getRespuestas();
            stmt.setString(2, r[0]);
            stmt.setString(3, r[1]);
            stmt.setString(4, r[2]);
            
            stmt.setInt(5, p.getRespuestaCorrecta());
            stmt.setInt(6, p.getDificultad() );
            stmt.setInt(7, p.getId() );
            
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al modificar pregunta." + ex.toString() );;
        }
        
    }

    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCuestionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
