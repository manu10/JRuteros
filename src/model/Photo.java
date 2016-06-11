package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mysql.jdbc.Blob;
@Entity
@Table

public class Photo {


	@Id
	@GeneratedValue //Para que me genere el id automaticamente 
	private long id;

	@ManyToOne
	private Trail trail;//TODO Preguntar: Conviene tenerlo aunque no lo habiamos puesto en el UML, Para hacer la relacion.
	//LO mismo pasa con "Activity"
	//ASI ESTA BIEN!!

//	private Blob blob; //TODO: Consultar si esta bien el tipo que importó!!!!

	private String ext; // Es necesario la extension?? O lo solucionamos con el nombre

	private String name;



//	public Blob getBlob() {
//		return blob;
//	}
//
//	public void setBlob(Blob blob) {
//		this.blob = blob;
//	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Trail getTrail() {
		return trail;
	}

	public void setTrail(Trail trail) {
		this.trail = trail;
	}



}