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
	
	private void CreateEntityManager() {
		this.emf  = Persistence.createEntityManagerFactory("Example");
		this.em = emf.createEntityManager();
	}

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
