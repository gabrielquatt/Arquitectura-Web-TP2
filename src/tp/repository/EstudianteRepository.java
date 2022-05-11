package tp.repository;

import java.util.List;
import tp.clases.tablas.Estudiante;

public interface EstudianteRepository {

	void InsertarEstudiante(Estudiante e);
	
	List<Estudiante> GetEstudiantes();
	
	Estudiante GetEstudianteById(int id);
	
	List<Estudiante> GetEstudiantesByGenero(String genero);

	List<Estudiante> GetEstudiantesByCiudad(String ciudad, int idCarrera);

}
