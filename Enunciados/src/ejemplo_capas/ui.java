package ejemplo_capas;

import java.sql.*;
import java.util.LinkedList;

public class ui {

	public static void main(String[] args) {
		Connection conn = null;
		LinkedList<Persona> personas = new LinkedList<>();
		try {
			// crear una conexión
			conn =
		       DriverManager.getConnection("jdbc:mysql://localhost/javaTest","java","himitsu");

			// ejecutar la query
            Statement stmt = conn.createStatement();
            ResultSet rs= stmt.executeQuery("select * from persona");

            // mapear de resultset a objeto
            while(rs.next()) {
            	Persona p=new Persona();
                Documento d=new Documento();
                p.setDocumento(d);

                p.setId(rs.getInt("id"));
                d.setNro(rs.getInt("nro_doc"));
                d.setTipo(rs.getString("tipo_doc"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setHabilitado(rs.getBoolean("estaHabilitado"));

                personas.add(p);

            }
            //cerrar recursos
            if(rs!=null){rs.close();}
            if(stmt!=null){stmt.close();}

		    conn.close();
		    
		    // mostrar info
		    System.out.println("Listado Completo");
		    System.out.println(personas);
		    System.out.println();System.out.println();

		} catch (SQLException ex) {
		    // Manejo de errores
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public static class Persona {
		
		private int id;
		private String nombre;
		private String apellido;
		private boolean habilitado;
		private Documento documento;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
		public boolean isHabilitado() {
			return habilitado;
		}
		public void setHabilitado(boolean habilitado) {
			this.habilitado = habilitado;
		}
		public Documento getDocumento() {
			return documento;
		}
		public void setDocumento(Documento documento) {
			this.documento = documento;
		}
		@Override
		public String toString() {
			return "\nPersona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", habilitado=" + habilitado
					+ ", documento=" + documento + "]";
		}

}
	public static class Documento {

		private String tipo;
		private int nro;
		
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public int getNro() {
			return nro;
		}
		public void setNro(int nro) {
			this.nro = nro;
		}
		@Override
		public String toString() {
			return "Documento [tipo=" + tipo + ", nro=" + nro + "]";
		}
		
		
	}



}
