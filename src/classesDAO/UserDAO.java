package classesDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import cosas.EntityManFact;
import model.Activity;
import model.User;

public class UserDAO extends GenericDAO<User> implements interfacesDAO.IUserDAO{
	private static EntityManagerFactory manFac;	
	static{
		manFac = EntityManFact.getInstance().getEntityManagerFactory(); //TODO: Usar!!!
	}
	public UserDAO() {
		super(User.class);
	}
	@Override
	public User getUserByUserName(String userName) {
		EntityManager em;
		String hql = "FROM "+this.entityClass+" U WHERE U.userName=\'"+userName+"\'";
		em = manFac.createEntityManager();//Se conecta a la BD
		User usr=(User) em.createQuery(hql).getResultList().get(0);
		em.close();
		return usr;	
	}
	@Override
	public User getUserByUserEmail(String email) {
		EntityManager em;
		String hql = "FROM "+this.entityClass+" U WHERE U.email=\'"+email+"\'";
		em = manFac.createEntityManager();//Se conecta a la BD
		User usr=(User) em.createQuery(hql).getResultList().get(0);
		em.close();
		return usr;	
	}



}
