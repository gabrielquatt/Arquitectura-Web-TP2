package tp.repository;

import java.util.List;

import tp.clases.tablas.Estudiante;

public interface EstudianteRepository {

	void insertarEstudiante(Estudiante e);
	
	List<Estudiante> getEstudiantes();
	
	Estudiante getEstudianteById(int id);
	
	List<Estudiante> getEstudiantesByGenero(String genero);

	List<Estudiante> getEstudiantesByCiudad(String ciudad, int idCarrera);

}
