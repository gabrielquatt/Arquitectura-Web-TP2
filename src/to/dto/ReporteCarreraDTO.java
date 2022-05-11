package to.dto;

public class ReporteCarreraDTO {
	
	private int id;
	private String nombre_Carrera;
	private String anio;
	private int incriptos;
	private int egresados;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre_Carrera() {
		return nombre_Carrera;
	}
	public void setNombre_Carrera(String nombre_Carrera) {
		this.nombre_Carrera = nombre_Carrera;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public int getIncriptos() {
		return incriptos;
	}
	public void setIncriptos(int incriptos) {
		this.incriptos = incriptos;
	}
	public int getEgresados() {
		return egresados;
	}
	public void setEgresados(int egresados) {
		this.egresados = egresados;
	}
}
