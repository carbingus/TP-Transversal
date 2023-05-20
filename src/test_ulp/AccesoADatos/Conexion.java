package test_ulp.AccesoADatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost/";
    private static final String DB = "universidadGp2";
    private static final String USUARIO = "root";
    private static String PASSWORD = "";
    
    private static Connection connection;
    
    private Conexion(){} // metodo constructor
    
    public static Connection getConexion(){
        if (connection == null){
            try{
                Class.forName("org.mariadb.jdbc.Driver");
                //conectarse a la base de datos
                connection = DriverManager.
                        getConnection(URL+DB+ "?useLegacyDateTimeCode=false&serverTimeZone=UTC"
                                + "&user=" + USUARIO + "%password=" + PASSWORD);
            } catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Error al conectarse a la Base de Datos " + ex.getMessage());
          
            } catch (ClassNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Error al cargar los drivers " + ex.getLocalizedMessage());
            }
        }
    return connection;
    }
    
}
