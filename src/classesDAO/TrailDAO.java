package classesDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import cosas.EntityManFact;
import cosas.FactoryDAO;
import model.Activity;
import model.Difficulty;
import model.GeoPoint;
import model.Photo;
import model.Rating;
import model.Trail;

public class TrailDAO extends GenericDAO<Trail> implements interfacesDAO.ITrailDAO{
	private static EntityManagerFactory manFac;	
	static{
		manFac = EntityManFact.getInstance().getEntityManagerFactory(); //TODO: Usar!!!
	}
	public TrailDAO() {
		super(Trail.class);
	}
	//SObreescribimos estos metodos del GenericDAO porque Activity, UserOwner y Difficulty se deberian cargar cuando se recupera
	@Override
	public List<Trail> getAll() {
		EntityManager em;
		em = EntityManFact.getInstance().getEntityManagerFactory().createEntityManager();//Se conecta a la BD
		List<Trail> list = (List<Trail>)(em.createQuery("from "+entityClass.getName())).getResultList();
		
		//TODO: preguntar sobre como hacer eficientemente lo de agregar el atributo Difficulty por ej. 
		
		em.close();

		return list;
	}

	@Override
	public Trail getById(Long id) {
		EntityManager em;
		String hql = "FROM "+entityClass.getName()+"A WHERE A.id=\'"+id+"\'";
		em = EntityManFact.getInstance().getEntityManagerFactory().createEntityManager();//Se conecta a la BD
		Trail trail =(Trail) em.createQuery(hql).getResultList().get(0);
		DifficultyDAO diffDAO = FactoryDAO.getDifficultyDAO();
		trail.setDifficulty(new Difficulty());
		//TODO: MODIFICAR!! SEGURAMENTE SE DEBE HACER TODO AUTOMATICO ESTO!! HAY QUE LEER!!
		//QUiza ni sea necesario este metodo!
		em.close();
		return trail;
	}
	@Override
	public List<Trail> getTrailsByDifficulty(Difficulty difficulty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GeoPoint> getMyGeoPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Photo> getMyPhotos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rating> getMyRatings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rating> getUsersWhoDone() {
		// TODO Auto-generated method stub
		return null;
	}


}
