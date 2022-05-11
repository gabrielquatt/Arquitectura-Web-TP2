import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class factory {

	private EntityManagerFactory emf;
	private EntityManager em; 
	
	public factory() {
		this.emf  = Persistence.createEntityManagerFactory("Example");
		this.em = emf.createEntityManager();
		
}
	EntityManagerFactory getEmf() {
		if (this.emf == null) {
			this.emf  = Persistence.createEntityManagerFactory("Example");
		}
		
		return this.emf;
	}
	
	EntityManager getEm() {
		if (this.em == null) {
			this.em = emf.createEntityManager();
		}
		
		return this.em;
	}
	
}
