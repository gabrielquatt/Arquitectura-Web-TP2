package tp.repositoryImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import tp.clases.tablas.Estado;
import tp.repository.EstadoRepository;

public class EstadoRepositoryImp implements EstadoRepository{

	private EntityManagerFactory emf;
	private EntityManager em; 
	
	public EstadoRepositoryImp() {
	}
	/**
	 * Crea un entity manager factory y un entity manager
	 */
	private void CreateEntityManager() {
		this.emf  = Persistence.createEntityManagerFactory("Example");
		this.em = emf.createEntityManager();
	}
	/**
	 * Inserta una inscripcion de un estudiante a una carrera
	 * 
	 * @param e {@link tp.clases.tablas.Estado}
	 */
	@Override
	public void InsertEstado(Estado e){
		CreateEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(e);
		this.em.getTransaction().commit();
		this.em.close();
		this.emf.close();
	}

}
