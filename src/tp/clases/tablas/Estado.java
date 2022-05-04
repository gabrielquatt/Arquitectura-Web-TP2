package tp.clases.tablas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@ManyToOne
	private Carrera carrera;
	
	@ManyToOne
	private Estudiante estudiante;

	@Column
	private int anios;
	
	@Column
	private boolean recibido;
	
	public Estado() {
		super();
	}

	public Estado(Carrera carrera, Estudiante estudiante, int anios, boolean recibido) {
		super();
		this.carrera = carrera;
		this.estudiante = estudiante;
		this.anios = anios;
		this.recibido = recibido;
	}
	
	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public int getAnios() {
		return anios;
	}

	public void setAnios(int anios) {
		this.anios = anios;
	}

	public boolean isRecibido() {
		return recibido;
	}

	public void setRecibido(boolean recibido) {
		this.recibido = recibido;
	}
	
	@Override
	public String toString() {
		return "Estado [carrera=" + carrera + ", estudiante=" + estudiante + ", anios=" + anios + ", recibido="
				+ recibido + "]";
	}
	
	
}
