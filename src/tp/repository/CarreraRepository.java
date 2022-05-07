package tp.repository;
import java.util.List;
import tp.clases.tablas.Carrera;

public interface CarreraRepository {

	void insertarCarrera(Carrera c);
	List<Carrera> getCarrerasByInscriptos();
	
}
