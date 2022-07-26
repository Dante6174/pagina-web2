
package aplicacion;


import java.sql.DriverManager;
import java.sql.Connection;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    //para la conexion con la bases de datos
    public static final String URL = "jdbc:mysql://localhost:3306/escuela ";
    public static final String user = "root";
    public static final String password = "user";
   
   
    // METODO PARA LA CONEXION
    public Connection getConnection(){
        Connection conection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conection = (Connection)DriverManager.getConnection(URL, user, password);
            JOptionPane.showMessageDialog(null, "Conexion Exitosa");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.err.println("Error: "+e);
        }
        return conection;
    }

}