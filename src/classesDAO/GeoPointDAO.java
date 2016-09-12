package classesDAO;

import javax.persistence.EntityManagerFactory;

import model.GeoPoint;
import persistencia.EntityManFact;

public class GeoPointDAO extends GenericDAO<GeoPoint> implements interfacesDAO.IGeoPointDAO{
	private static EntityManagerFactory manFac;	
	static{
		manFac = EntityManFact.getInstance().getEntityManagerFactory(); //TODO: Usar!!!
	}
	public GeoPointDAO() {
		super(GeoPoint.class);
	}


}
