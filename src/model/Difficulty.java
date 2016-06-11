package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Difficulty {
	@Id
	@GeneratedValue //Para que me genere el id automaticamente 
	private long id;
	public String name;

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