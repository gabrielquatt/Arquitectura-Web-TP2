// allá
package tp.repositoryImp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tp.clases.tablas.Carrera;
import tp.dto.ReporteCarreraDTO;
import tp.repository.CarreraRepository;

public class CarreraRepositoryImp implements CarreraRepository{

	private EntityManagerFactory emf;
	private EntityManager em; 
	
	public CarreraRepositoryImp() {
		this.emf  = Persistence.createEntityManagerFactory("Example");
		this.em = emf.createEntityManager();
	}

	@Override
	public void insertarCarrera(Carrera c) {
		
		this.emf  = Persistence.createEntityManagerFactory("Example");
		this.em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
		emf.close();	
	}

	@Override
	public List<Carrera> getCarreras() {
		this.emf  = Persistence.createEntityManagerFactory("Example");
		this.em = emf.createEntityManager();	
		em.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<Carrera> list = em.createQuery("SELECT c FROM Carrera c JOIN Estado e ON c.id = e.carrera GROUP BY c.id ORDER BY COUNT(*)").getResultList();	
		em.close();
		return list;
	}

	@Override
	public List<ReporteCarreraDTO> ReporteCarrera() {
		this.emf  = Persistence.createEntityManagerFactory("Example");
		this.em = emf.createEntityManager();	
		em.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<ReporteCarreraDTO> list = em.createQuery("SELECT new tp.dto.ReporteCarreraDTO( c.nombre, YEAR(anioIngreso), COUNT(e.anioIngreso), COUNT(e.anioEgreso) ) FROM Carrera c JOIN Estado e ON c.id = e.carrera GROUP BY EXTRACT(YEAR FROM e.anioIngreso), c.nombre ORDER BY 1 ASC, 2 DESC", ReporteCarreraDTO.class).getResultList();	
		em.close();
		return list;
	}
}
