package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table
@XmlRootElement
public class GeoPoint {
	static long ids=0;

	public GeoPoint() {
		super();
		this.id = ids++;
		
	}

	@Id
	@GeneratedValue //Para que me genere el id automaticamente 
	@XmlElement
	private long id;
	
	public long getId() {
		return id;
	}

	@ManyToOne
	@XmlTransient//Esto es para que lo ignore el JAX-RS 
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