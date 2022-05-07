package tp.repositoryImp;

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

}
