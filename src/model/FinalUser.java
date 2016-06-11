package model;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
//@Table //COmentado para probar si es esto lo que hace que se generen 2 tablas en la relacion many to many
@DiscriminatorValue("FU")
public class FinalUser extends User {

	private Boolean isEnable;

	@ManyToMany
	@JoinTable(name="USR_TRAIL")
	private List<Trail>  done;
	
	@OneToMany(mappedBy="rateBy")
	private List<Rating>  ratings;
	
	@OneToMany(mappedBy="owner")
	private List<Trail>  myTrails;


	public Boolean getsEnable() {
		return isEnable;
	}

	public void setEnable(Boolean value) {
		this.isEnable=value;
	}

	public void puntuarRuta(Trail ruta) {
	}

	public void yoHiceRuta(Trail ruta) {
	}

	public void newTrail() {
	}

	public List<Trail> getDone() {
		return done;
	}

	public void setDone(List<Trail> done) {
		this.done = done;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Trail> getMyTrails() {
		return myTrails;
	}

	public void setMyTrails(List<Trail> myTrails) {
		this.myTrails = myTrails;
	}

}
