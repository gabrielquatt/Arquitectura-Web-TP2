package tp.repository;
import java.util.List;

import tp.clases.tablas.Carrera;
import tp.dto.ReporteCarreraDTO;

public interface CarreraRepository {

	void insertarCarrera(Carrera c);
	List<Carrera> getCarreras();

	List<ReporteCarreraDTO> ReporteCarrera();
}
	
