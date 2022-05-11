package tp.repository;

import java.util.List;

import tp.clases.tablas.Carrera;
import tp.dto.ReporteCarreraDTO;

public interface CarreraRepository {

	void InsertarCarrera(Carrera c);
	
	List<Carrera> GetCarrerasOrderByInscriptos();

	List<ReporteCarreraDTO> ReporteCarrera();
}
	
