package tp.app.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import tp.clases.tablas.Carrera;
import tp.clases.tablas.Ciudad;
import tp.clases.tablas.Estado;
import tp.clases.tablas.Estudiante;

public class main {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Ciudad c = new Ciudad("loberia");
		Carrera car = new Carrera("programacion");
		Estudiante es = new Estudiante(1345, 1357, "nombre","apellido", 17, "M", c);
		Estado e = new Estado(car, es, 2, false);
	
		em.persist(c);
		em.persist(car);
		em.persist(es);
		em.persist(e);
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
