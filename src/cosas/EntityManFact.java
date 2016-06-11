package cosas;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManFact {

	private static EntityManFact instance = null;
	private EntityManagerFactory myEmf;
	
	protected EntityManFact(){
		 myEmf = Persistence.createEntityManagerFactory("myPU");
	}

	public static EntityManFact getInstance() {
		if(instance == null) {
			instance = new EntityManFact();
		}
		return instance;
	}
	
	public EntityManagerFactory getEntityManagerFactory(){
		return myEmf;
	}

}
