package classesDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import cosas.EntityManFact;
import model.FinalUser;
import model.Rating;
import model.Trail;

public class FinalUserDAO extends GenericDAO<FinalUser> implements interfacesDAO.IFinalUserDAO{
	private static EntityManagerFactory manFac;	
	static{
		manFac = EntityManFact.getInstance().getEntityManagerFactory(); //TODO: Usar!!!
	}
	public FinalUserDAO() {
		super(FinalUser.class);
	}
	@Override
	public List<Trail> getMyTrails() {
		// TODO IMPLEMENTAR!!!!
		return null;
	}
	@Override
	public List<Trail> getDoneTrails() {
		// TODO IMPLEMENTAR!!!!
		return null;
	}
	@Override
	public List<Rating> getMyRatings() {
		// TODO IMPLEMENTAR!!!!
		return null;
	}



}
