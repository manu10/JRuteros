package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class GeoPoint {

	@Id
	@GeneratedValue //Para que me genere el id automaticamente 
	private long id;
	
	@ManyToOne
	private Trail trail; //TODO: Preguntar por eficiencia... por cada GeoPoint que traigo traigo un User?? Estaria mal!!
	
	private double lon;

	private double lat;

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}



}