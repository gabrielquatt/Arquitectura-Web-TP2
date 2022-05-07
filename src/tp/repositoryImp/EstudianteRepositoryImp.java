package tp.repositoryImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tp.clases.tablas.Estudiante;
import tp.repository.EstudianteRepository;

public class EstudianteRepositoryImp implements EstudianteRepository{

	private EntityManagerFactory emf;
	private EntityManager em; 
	
	public EstudianteRepositoryImp() {
		this.emf  = Persistence.createEntityManagerFactory("Example");
		this.em = emf.createEntityManager();
	}

	@Override
	public void insertarEstudiante(Estudiante e) {
		
		this.emf  = Persistence.createEntityManagerFactory("Example");
		this.em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
