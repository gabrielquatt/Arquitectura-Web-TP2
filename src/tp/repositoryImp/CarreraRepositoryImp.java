package tp.repositoryImp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import tp.clases.tablas.Carrera;
import tp.clases.tablas.Estudiante;
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
<<<<<<< HEAD
	public List<Carrera> getCarrerasByInscriptos() {
=======
	public List<Carrera> getCarreras() {
		this.emf  = Persistence.createEntityManagerFactory("Example");
		this.em = emf.createEntityManager();	
		em.getTransaction().begin();		
		@SuppressWarnings("unchecked");
		List<Carrera> list = em.createQuery("SELECT c FROM Carrera c JOIN Estado e ON c.id = e.carrera GROUP BY c.id ORDER BY COUNT(*)").getResultList();	
		em.close();
		return list;
	}
}
