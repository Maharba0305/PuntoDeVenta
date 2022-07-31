
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    public final String URL = "jdbc:mysql://localhost:3306/Ferreteria?AutoReconnet=true&useSSL=false";
    public final String usuario = "root";
    public final String paswor="1234";
    
    public Connection cadena;
    public static Conexion instancia;
    //-------------------contructor----------------
    private Conexion(){
        this.cadena = null;
    }
    
    //----------------metodo conectar------------------
    public Connection conectar(){
    
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                this.cadena = DriverManager.getConnection(URL,usuario,paswor);
            } catch (ClassNotFoundException |SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                System.exit(0);
            }
            return this.cadena;
}
    //-----------Metodo Desconectar----------
    public void  desconectar(){
        try {
            this.cadena.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            
        }
    }    
    //-----------instancia---------
    public synchronized static Conexion getInstancia(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
}
