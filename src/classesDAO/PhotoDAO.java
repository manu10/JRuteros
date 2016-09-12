package classesDAO;

import javax.persistence.EntityManagerFactory;

import model.Photo;
import persistencia.EntityManFact;

public class PhotoDAO extends GenericDAO<Photo> implements interfacesDAO.IPhotoDAO{
	private static EntityManagerFactory manFac;	
	static{
		manFac = EntityManFact.getInstance().getEntityManagerFactory(); //TODO: Usar!!!
	}
	public PhotoDAO() {
		super(Photo.class);
	}


}
