package classesDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Activity;
import persistencia.EntityManFact;

public class ActivityDAO extends GenericDAO<Activity> implements interfacesDAO.IActivityDAO{
	private static EntityManagerFactory manFac;	
	static{
		manFac = EntityManFact.getInstance().getEntityManagerFactory(); //TODO: Usar!!!
	}
	public ActivityDAO() {
		super(Activity.class);
	}

	@Override
	public Activity getActivityByName(String name) {
		EntityManager em;
		String hql = "FROM model.Activity A WHERE A.name=\'"+name+"\'";
		em = manFac.createEntityManager();//Se conecta a la BD
		Activity act=(Activity) em.createQuery(hql).getResultList().get(0);
		em.close();
		return act;
	}


}
