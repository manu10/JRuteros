package interfacesDAO;



import java.util.List;

import model.FinalUser;
import model.Rating;
import model.Trail;

public interface IFinalUserDAO extends IGenericDAO<FinalUser> {
	public List<Trail> getMyTrails();
	public List<Trail> getDoneTrails();
	public List<Rating> getMyRatings();

}
