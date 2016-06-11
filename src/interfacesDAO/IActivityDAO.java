package interfacesDAO;


import model.Activity;

public interface IActivityDAO extends IGenericDAO<Activity> {

	public Activity getActivityByName(String name);
	
	//VER LO DE GENERIC DAO para los llamados genericos
	
}
