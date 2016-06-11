package classesDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import cosas.EntityManFact;
import interfacesDAO.IGenericDAO;
import model.Activity;

public class GenericDAO<T> implements IGenericDAO<T>{
	private static EntityManagerFactory manFac;	
	protected Class<T> entityClass;
	
	static{
		manFac = EntityManFact.getInstance().getEntityManagerFactory(); //TODO: Usar!!!
	}
	
	public GenericDAO(Class<T> mClass) {
		this.entityClass = mClass;
	}
	@Override
	public List<T> getAll() {
		EntityManager em;
		em = EntityManFact.getInstance().getEntityManagerFactory().createEntityManager();//Se conecta a la BD
		List<T> list = (List<T>)(em.createQuery("from "+entityClass.getName())).getResultList();
		em.close();

		return list;
	}

	@Override
	public T getById(Long id) {
		EntityManager em;
		String hql = "FROM "+entityClass.getName()+"A WHERE A.id=\'"+id+"\'";
		em = EntityManFact.getInstance().getEntityManagerFactory().createEntityManager();//Se conecta a la BD
		Object obj =(T) em.createQuery(hql).getResultList().get(0);
		em.close();
		return (T)obj;
	}

	@Override
	public void create(T obj) {
		EntityManager em;
		EntityTransaction etx;
		em = GenericDAO.manFac.createEntityManager();//Se conecta a la BD
		etx = em.getTransaction();

		etx.begin();
		em.persist(obj);//
		etx.commit();
		em.close();

	}

	@Override
	public void update(T obj) {
		
		EntityTransaction etx;
		EntityManager em;
		em = EntityManFact.getInstance().getEntityManagerFactory().createEntityManager();//Se conecta a la BD
		etx = em.getTransaction();
		etx.begin();
		em.merge(obj); //Update!! en el test tenemos que ver si hay que ejecutar edit o save
		etx.commit();
		em.close();

	}

	@Override
	public void delete(T obj) {
		EntityManager em;
		EntityTransaction etx;
		em = EntityManFact.getInstance().getEntityManagerFactory().createEntityManager();//Se conecta a la BD
		etx = em.getTransaction();
		etx.begin();//Para que lo haga inmediatamente  ES LA FORMA CORRECTA?
		obj=em.merge(obj);//Sincroniza los ultimos cambios, para poder eliminar, porque sino el act estaba detached
		em.remove(obj);
		etx.commit();//Para que lo haga inmediatamente
		em.close();
		//COMO FUNCIONA LO SIGUIENTE?? 	
		//etx.commit(); sin el begin.
		//em.flush();
	}
		
	
	
		

}
