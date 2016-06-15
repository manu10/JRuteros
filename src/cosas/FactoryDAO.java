package cosas;

import classesDAO.ActivityDAO;
import classesDAO.AdminDAO;
import classesDAO.DifficultyDAO;
import classesDAO.FinalUserDAO;
import classesDAO.GeoPointDAO;
import classesDAO.PhotoDAO;
import classesDAO.RatingDAO;
import classesDAO.TrailDAO;
import classesDAO.UserDAO;
import interfacesDAO.IActivityDAO;

public class FactoryDAO {
	private static ActivityDAO activityDAO = new ActivityDAO();
	private static AdminDAO adminDAO = new AdminDAO();
	private static DifficultyDAO difficultyDAO= new DifficultyDAO();
	private static FinalUserDAO finalUserDAO = new FinalUserDAO();
	private static GeoPointDAO geoPointDAO= new GeoPointDAO();
	
	private static PhotoDAO photoDAO= new PhotoDAO();
	private static RatingDAO ratingDAO = new RatingDAO();
	private static TrailDAO trailDAO= new TrailDAO();
	private static UserDAO userDAO = new UserDAO();
	
	public static IActivityDAO getActivityDAO(){
		return activityDAO; 
	}

	public static UserDAO getUserDAO() {
		return userDAO;
	}

	public static AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public static FinalUserDAO getFinalUserDAO() {
		return finalUserDAO;
	}

	public static RatingDAO getRatingDAO() {
		return ratingDAO;
	}

	public static GeoPointDAO getGeoPointDAO() {
		return geoPointDAO;
	}

	public static DifficultyDAO getDifficultyDAO() {
		return difficultyDAO;
	}

	public static PhotoDAO getPhotoDAO() {
		return photoDAO;
	}

	public static TrailDAO getTrailDAO() {
		return trailDAO;
	}

}
