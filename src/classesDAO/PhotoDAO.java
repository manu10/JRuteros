package classesDAO;

import javax.persistence.EntityManagerFactory;

import cosas.EntityManFact;
import model.Photo;

public class PhotoDAO extends GenericDAO<Photo> implements interfacesDAO.IPhotoDAO{
	private static EntityManagerFactory manFac;	
	static{
		manFac = EntityManFact.getInstance().getEntityManagerFactory(); //TODO: Usar!!!
	}
	public PhotoDAO() {
		super(Photo.class);
	}


}
