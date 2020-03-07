
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class ConexionBD {
    
    public static Connection getConexion(){
        Connection cn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost/bdbiblioteca","root","");  
            JOptionPane.showMessageDialog(null,"Se conecto la base de datos");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Nooooooo conecto la base de datos");
        }
        return cn;
    }

    public static void main(String[] args) {
        getConexion();
    }
}

