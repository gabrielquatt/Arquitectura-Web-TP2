package tp.clases.tablas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Estudiante {

	@Id 
	private int num_Libreta; 
	
	@Column (nullable = false)
	private int num_doc;
	
	@Column (name = "name")
	private String nombres;

	@Column
	private String apellido;

	@Column 
	private int edad;
	
	@Column (name = "genere")
	private String genero;
	
	@ManyToOne //FK
	private Ciudad residencia;

	public Estudiante() {
		super();
	}
	
	public Estudiante(int num_Libreta, int num_doc, String nombres, String apellido, int edad, String genero,
			Ciudad residencia) {
		super();
		this.num_Libreta = num_Libreta;
		this.num_doc = num_doc;
		this.nombres = nombres;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.residencia = residencia;
	}

	public int getNum_Libreta() {
		return num_Libreta;
	}

	public void setNum_Libreta(int num_Libreta) {
		this.num_Libreta = num_Libreta;
	}

	public int getNum_doc() {
		return num_doc;
	}

	public void setNum_doc(int num_doc) {
		this.num_doc = num_doc;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Ciudad getResidencia() {
		return residencia;
	}

	public void setResidencia(Ciudad residencia) {
		this.residencia = residencia;
	}

	@Override
	public String toString() {
		return "Estudiante [num_Libreta=" + num_Libreta + ", num_doc=" + num_doc + ", nombres=" + nombres
				+ ", apellido=" + apellido + ", edad=" + edad + ", genero=" + genero + ", residencia=" + residencia
				+ "]";
	}
	
}
