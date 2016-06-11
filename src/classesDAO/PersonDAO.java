package classesDAO;

import javax.persistence.EntityManagerFactory;


import cosas.EntityManFact;

import model.Person;

public class PersonDAO extends GenericDAO<Person> implements interfacesDAO.IPersonDAO{
//	POR AHORA NO SE USA PERO SI AGREGAMOS METODOS LO VAMOS A TENER QUE USAR, POR ESO LO DEJAMOS
//	private static EntityManagerFactory manFac;	
//	static{
//		manFac = EntityManFact.getInstance().getEntityManagerFactory(); //TODO: Usar!!!
//	}
	public PersonDAO() {
		super(Person.class);
	}
	
	

	

}
