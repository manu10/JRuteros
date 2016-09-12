package classesDAO;

import javax.persistence.EntityManagerFactory;

import model.Difficulty;
import persistencia.EntityManFact;

public class DifficultyDAO extends GenericDAO<Difficulty> implements interfacesDAO.IDifficultyDAO{
	private static EntityManagerFactory manFac;	
	static{
		manFac = EntityManFact.getInstance().getEntityManagerFactory(); //TODO: Usar!!!
	}
	public DifficultyDAO() {
		super(Difficulty.class);
	}

}
