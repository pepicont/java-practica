package ejercicio5a.entidades;

public class Empleado {
	
	private int dni;
	private String nombre;
	private String apellido;
	private String email;
	private int sueldoBase;
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSueldoBase() {
		return sueldoBase;
	}
	public void setSueldoBase(int sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	/*public Empleado() {
		
	}*/
	
	
	public Empleado(int dni, String nombre, String apellido, String email, int sueldoBase) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.sueldoBase = sueldoBase;
	}
	
	public float getSueldo() {
		return 0;
	}
	
	
	
	
}
