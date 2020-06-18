package grupo3pf;
import java.sql.*;

public class Conexion {
    private static String url = "jdbc:mariadb://localhost:3306/massalud";
    private static String usuario = "root";
    private static String clave = "";

    private static Connection conexion;
    
    public Conexion(){
    }
    
    public Conexion(String url, String usuario, String password){
        this.url = url;
        this.usuario = usuario;
        this.clave = password;
    }
    
    public static Connection get(){
        if(conexion == null){
            try{
                conexion = DriverManager.getConnection(url, usuario, clave);
            } catch (SQLException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return conexion;
    }
}

