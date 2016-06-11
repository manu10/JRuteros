package interfacesDAO;

import model.Rating;
import model.Trail;

public interface IRatingDAO extends IGenericDAO<Rating> {
	
	public Trail getTrail();
	//public User getUser();// SE DEBE USAR o las puntuaciones desde el trail es anonimo??

}
