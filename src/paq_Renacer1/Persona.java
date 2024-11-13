package paq_Renacer1;
import java.util.Scanner;
public class Persona {
	protected String nombre;
	protected String apat; //apellido Paterno
	protected String amat; //apellido Materno
	protected int edad;
	protected int dni;
	protected int telefono;
	protected String email;
	
	public Persona() {
		//
	}
	public Persona(String nombre,String apat,String amat, int edad,int dni,int telefono, String email) {
		this.nombre=nombre;
		this.apat=apat;
		this.amat=amat;
		this.edad=edad;
		this.dni=dni;
		this.telefono=telefono;
		this.email=email;
	}
	
	//SETTERS
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public void setApellidoP(String apat) {
		this.apat=apat;
	}
	public void setApellidoM(String amat) {
		this.amat=amat;
	}
	public void setEdad(int edad) {
		this.edad=edad;
	}
	public void setDni(int dni){
		this.dni=dni;
	}
	public void setTelefono(int telefono) {
		this.telefono=telefono;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	//GETTERS
	public String getNombre() {
		return nombre;
	}
	public String getApellidoP() {
		return apat;
	}
	public String getApellidoM() {
		return amat;
	}
	public int getEdad() {
		return edad;
	}
	public int getDni() {
		return dni;
	}
	public int getTelefono() {
		return telefono;
	}
	public String getEmail() {
		return email;
	}
	public void leerPersona() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Ingrese el nombre:");
	    setNombre(scanner.nextLine());

	    System.out.println("Ingrese el apellido paterno:");
	    setApellidoP(scanner.nextLine());

	    System.out.println("Ingrese el apellido materno:");
	    setApellidoM(scanner.nextLine());

	    System.out.println("Ingrese la edad:");
	    setEdad(scanner.nextInt());

	    System.out.println("Ingrese el DNI:");
	    setDni(scanner.nextInt());

	    System.out.println("Ingrese el teléfono:");
	    setTelefono(scanner.nextInt());

	    System.out.println("Ingrese el email:");
	    scanner.nextLine(); // Consumir la línea anterior
	    setEmail(scanner.nextLine());
	}
	public void mostrarPersona() {
	    System.out.println("Nombre: " + getNombre());
	    System.out.println("Apellido Paterno: " + getApellidoP());
	    System.out.println("Apellido Materno: " + getApellidoM());
	    System.out.println("Edad: " + getEdad());
	    System.out.println("DNI: " + getDni());
	    System.out.println("Teléfono: " + getTelefono());
	    System.out.println("Email: " + getEmail());
	}

}
