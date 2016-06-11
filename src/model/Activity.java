package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Activity {
	@Id
	@GeneratedValue //Para que me genere el id automaticamente 
	private long id;
	private String name;

	/**
	 * 
	 * @element-type Trail
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}

}