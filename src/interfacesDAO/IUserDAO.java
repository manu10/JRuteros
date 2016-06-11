package interfacesDAO;



import model.User;

public interface IUserDAO extends IGenericDAO<User> {

	public User getUserByUserName(String userName);
	public User getUserByUserEmail(String email);

}
