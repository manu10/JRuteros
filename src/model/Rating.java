package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Rating {
	@Id
	@GeneratedValue //Para que me genere el id automaticamente 
	private long id;
	private Integer value;

	@ManyToOne
	private FinalUser rateBy;
	
	@ManyToOne 
	private Trail trail;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public FinalUser getRateBy() {
		return rateBy;
	}

	public void setRateBy(FinalUser rateBy) {
		this.rateBy = rateBy;
	}

	public Trail getTrail() {
		return trail;
	}

	public void setTrail(Trail trail) {
		this.trail = trail;
	}

}
