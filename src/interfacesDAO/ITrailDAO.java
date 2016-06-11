package interfacesDAO;

import java.util.List;

import model.Difficulty;
import model.GeoPoint;
import model.Photo;
import model.Rating;
import model.Trail;

public interface ITrailDAO extends IGenericDAO<Trail>{

	public List<Trail>getTrailsByDifficulty(Difficulty difficulty);
	//TODO: ANALIZAR consultas de busquedas por mas de un criterio. para que se mas eficiente 
	
	
	public List<GeoPoint>getMyGeoPoints();
	public List<Photo>getMyPhotos();
	public List<Rating>getMyRatings();
	public List<Rating>getUsersWhoDone();//QUIZA NO DEBERIA IR.
	
	
	//Activity, UserOwner y Difficulty se deberian cargar cuando se recupera
	
	
	
}
