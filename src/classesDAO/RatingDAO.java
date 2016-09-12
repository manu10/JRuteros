package classesDAO;
import javax.persistence.EntityManagerFactory;

import interfacesDAO.IRatingDAO;

import model.Rating;
import model.Trail;
import persistencia.EntityManFact;

public class RatingDAO extends GenericDAO<Rating>implements IRatingDAO{
	private static EntityManagerFactory manFac;	
	static{
		manFac = EntityManFact.getInstance().getEntityManagerFactory(); //TODO: Usar!!!
	}
	public RatingDAO() {
		super(Rating.class);

	}
	@Override
	public Trail getTrail() {
		// TODO IMPLEMENTAR!!!!
		return null;
	}

}
