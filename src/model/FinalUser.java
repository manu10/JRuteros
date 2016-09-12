package model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import persistencia.FactoryDAO;
@Entity
//@Table //COmentado para probar si es esto lo que hace que se generen 2 tablas en la relacion many to many
@DiscriminatorValue("FU")
public class FinalUser extends User {

	public FinalUser() {
		super();
		done = new ArrayList<Trail>();
		ratings = new ArrayList<Rating>();
		myTrails = new ArrayList<Trail>();
	}

	private Boolean isEnable;

	@ManyToMany//(cascade=CascadeType.ALL)
	@JoinTable(name="USR_TRAIL")
	private List<Trail>  done;
	
//	@OneToMany(mappedBy="rateBy",cascade=CascadeType.REMOVE)
	@OneToMany(mappedBy="rateBy")
	private List<Rating>  ratings;
	
//	@OneToMany(mappedBy="owner",cascade=CascadeType.REMOVE)
	@OneToMany(mappedBy="owner")
	private List<Trail>  myTrails;


	
	public Boolean getsEnable() {
		return isEnable;
	}

	public void setEnable(Boolean value) {
		this.isEnable=value;
	}

	public void puntuarRuta(Trail ruta,int value) {
		Rating rating = new Rating();
		rating.setRateBy(this);
		rating.setTrail(ruta);
		rating.setValue(value);
//		ruta.getRatings().add(rating);
//		FactoryDAO.getTrailDAO().update(ruta);
		FactoryDAO.getRatingDAO().create(rating);
		//ratings.add(rating); Lo volvemos a cargar
		
	}

	public void yoHiceRuta(Trail ruta) {
		done.add(ruta);
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
