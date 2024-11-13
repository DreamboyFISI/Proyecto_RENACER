package paq_ConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionBD {
	private static final String URL = "jdbc:mysql://localhost:3306/basedatos_hospital";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.err.println("Error al conectarse a la base de datos: " + e.getMessage());
        }
        return connection;
    }
}
