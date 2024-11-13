package paq_Renacer1;
import java.util.Scanner;

import paq_ConexionBD.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Usuario extends Persona {
	protected String usuario;
	protected String contra; //Contraseña
	protected Rol rol;
	public enum Rol{
		RECEPCIONISTA, MEDICO, ADMINISTRATIVO 
	}
	public Usuario() {
		//
	}
    public Usuario(String nombre, String apat, String amat, int edad, int dni, int telefono,
            String email, String usuario, String contra, Rol rol) {
    	super(nombre, apat, amat, edad, dni, telefono, email);
		this.usuario = usuario;
		this.contra = contra;
		this.rol = rol;
}
	
	//Setter
	public void setUsuario(String usuario) {
		this.usuario=usuario;
	}
	public void setContra(String contra) {
		this.contra=contra;
	}
	//Getters
	public String getUsuario() {
		return usuario;
	}
	public String getContra() {
		return contra;
	}
	
	public void registrarUsuario() {
	    leerPersona(); // Llama a leerPersona para obtener la información

	    // Leer usuario y contraseña
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Ingrese el nombre de usuario:");
	    setUsuario(scanner.nextLine());

	    System.out.println("Ingrese la contraseña:");
	    setContra(scanner.nextLine());

	    // Almacenar en la base de datos
	    String sql = "INSERT INTO usuarios (nombre, apellido_p, apellido_m, edad, dni, telefono, email, usuario, contrasena, rol) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection connection = ConexionBD.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql)) {

	        statement.setString(1, getNombre());
	        statement.setString(2, getApellidoP());
	        statement.setString(3, getApellidoM());
	        statement.setInt(4, getEdad());
	        statement.setInt(5, getDni());
	        statement.setInt(6, getTelefono());
	        statement.setString(7, getEmail());
	        statement.setString(8, getUsuario());
	        statement.setString(9, getContra());
	        statement.setString(10, rol.name()); // Asumir que el rol es proporcionado

	        statement.executeUpdate();
	        System.out.println("Usuario registrado exitosamente.");
	    } catch (SQLException e) {
	        System.err.println("Error al registrar usuario: " + e.getMessage());
	    }
	}

	public boolean iniciarSesion() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Ingrese el nombre de usuario:");
	    String usuarioInput = scanner.nextLine();

	    System.out.println("Ingrese la contraseña:");
	    String contraInput = scanner.nextLine();

	    String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ?";

	    try (Connection connection = ConexionBD.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql)) {

	        statement.setString(1, usuarioInput);
	        statement.setString(2, contraInput);

	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            System.out.println("Inicio de sesión exitoso. Bienvenido, " + resultSet.getString("nombre") + "!");
	            return true; // Inicio de sesión exitoso
	        } else {
	            System.out.println("Credenciales incorrectas.");
	            return false; // Fallo en el inicio de sesión
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al iniciar sesión: " + e.getMessage());
	        return false; // Error en el proceso
	    }
	}

	
	
	
}
