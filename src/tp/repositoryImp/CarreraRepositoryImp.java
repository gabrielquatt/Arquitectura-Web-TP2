package tp.repositoryImp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import tp.clases.tablas.Carrera;
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
	public List<Carrera> getCarrerasByInscriptos() {
		this.emf  = Persistence.createEntityManagerFactory("Example");
		this.em = emf.createEntityManager();	
		em.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<Carrera> list = em.createQuery("SELECT carr.nombre, COUNT(est) as cantidad FROM Estado est INNER JOIN Carrera carr ON carr.id = est.carrera_id GROUP BY est.carrera ORDER BY cantidad ASC", Carrera.class).getResultList();
		em.close();
		emf.close();
		return list;
	}

}
