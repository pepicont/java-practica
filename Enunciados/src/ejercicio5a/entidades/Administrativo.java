package ejercicio5a.entidades;

public class Administrativo extends Empleado{
	
	private int hsExtra;
	private int hsMes;
	
	public int getHsExtra() {
		return hsExtra;
	}
	public void setHsExtra(int hsExtra) {
		this.hsExtra = hsExtra;
	}
	public int getHsMes() {
		return hsMes;
	}
	public void setHsmEs(int hsmEs) {
		this.hsMes = hsmEs;
	}
	/*public Administrativo() {
		super();
	}*/
	public Administrativo(int dni, String nombre, String apellido, String email, int sueldoBase, int hsExtra, int hsMes) {
		super(dni, nombre, apellido, email, sueldoBase);
		this.hsExtra=hsExtra;
		this.hsMes=hsMes;
	}
	
	public float getSueldo() {
		return  (float) (this.getSueldoBase()*((this.hsExtra * 1.5)+this.hsMes) / this.hsMes);
	}
	
	

}
