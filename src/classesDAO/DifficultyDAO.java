package classesDAO;

import javax.persistence.EntityManagerFactory;

import cosas.EntityManFact;
import model.Difficulty;

public class DifficultyDAO extends GenericDAO<Difficulty> implements interfacesDAO.IDifficultyDAO{
	private static EntityManagerFactory manFac;	
	static{
		manFac = EntityManFact.getInstance().getEntityManagerFactory(); //TODO: Usar!!!
	}
	public DifficultyDAO() {
		super(Difficulty.class);
	}

}
