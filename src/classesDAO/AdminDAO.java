package classesDAO;


import model.Admin;

public class AdminDAO extends GenericDAO<Admin> implements interfacesDAO.IAdminDAO{
//	POR AHORA NO SE USA PERO SI AGREGAMOS METODOS LO VAMOS A TENER QUE USAR, POR ESO LO DEJAMOS
//	private static EntityManagerFactory manFac;	
//	static{
//		manFac = EntityManFact.getInstance().getEntityManagerFactory(); //TODO: Usar!!!
//	}
	public AdminDAO() {
		super(Admin.class);
	}


}
