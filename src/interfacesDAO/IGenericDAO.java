package interfacesDAO;

import java.util.List;

import model.Activity;

public interface IGenericDAO<T> {

	public List<T> getAll();
	public T getById(Long id);
	public void create(T obj);
	public void update(T obj);
	public void delete(T obj);
	
}
