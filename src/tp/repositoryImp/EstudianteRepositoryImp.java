package tp.repositoryImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


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

	@Override
	public List<Estudiante> getEstudiantes() {	
		this.emf  = Persistence.createEntityManagerFactory("Example");
		this.em = emf.createEntityManager();	
		em.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<Estudiante> list = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.num_Libreta DESC").getResultList();	
		em.close();
		emf.close();
		return list;
	}

	@Override
	public Estudiante getEstudianteById(int id) {
		this.emf  = Persistence.createEntityManagerFactory("Example");
		this.em = emf.createEntityManager();	
		em.getTransaction().begin();			
		Estudiante e =	em.find(Estudiante.class, id);;
		em.close();
		emf.close();	
		return e;
	}

	@Override
	public List<Estudiante> getEstudiantesByGenero(String genero) {
		this.emf  = Persistence.createEntityManagerFactory("Example");
		this.em = emf.createEntityManager();	
		em.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<Estudiante> list = em.createQuery("SELECT e FROM Estudiante e WHERE e.genero = ?1").setParameter(1, genero).getResultList();	
		em.close();
		emf.close();
		return list;
	}

	@Override
	public List<Estudiante> getEstudiantesByCiudad(String ciudad, int idCarrera) {
		this.emf  = Persistence.createEntityManagerFactory("Example");
		this.em = emf.createEntityManager();	
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT e.name FROM Estudiante e WHERE e.residencia LIKE ?1 AND e.num_Libreta IN (SELECT es.e FROM Estado es WHERE (es.c = ?2))");
		query.setParameter(1, ciudad);
		query.setParameter(2, idCarrera);		
		@SuppressWarnings("unchecked")
		List<Estudiante> list = query.getResultList();
		em.close();
		emf.close();
		return list;	
	}

}
