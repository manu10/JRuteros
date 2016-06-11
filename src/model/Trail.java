package model;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
//@Table //COmentado para probar si es esto lo que hace que se generen 2 tablas en la relacion many to many
public class Trail {
	@Id
	@GeneratedValue //Para que me genere el id automaticamente 
	private long id;
	
	private String name;

	private String description;

	private Boolean isPublic;

	private Integer doneByCount;

	private Integer length;

	private Integer duration;

	private String date;

	private Boolean isCircular;

	private float rateAvg;

	@OneToMany(mappedBy="trail")
	private List<Photo>  photos;
	
	@OneToMany(mappedBy="trail") 
	private List<GeoPoint>  points;
	
	@ManyToOne
	private Difficulty difficulty;
	
	@ManyToOne		//	@ManyToOne(optional = false)
	private Activity activity;
	
	@ManyToMany(mappedBy="done")
	private List<FinalUser>  done_by;
	
	@OneToMany(mappedBy="trail")
	private List<Rating>  ratings;

	@ManyToOne
	private FinalUser owner;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Integer getDoneByCount() {
		return doneByCount;
	}

	public void setDoneByCount(Integer doneByCount) {
		this.doneByCount = doneByCount;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Boolean getIsCircular() {
		return isCircular;
	}

	public void setIsCircular(Boolean isCircular) {
		this.isCircular = isCircular;
	}

	public float getRateAvg() {
		return rateAvg;
	}

	public void setRateAvg(float rateAvg) {
		this.rateAvg = rateAvg;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public List<GeoPoint> getPoints() {
		return points;
	}

	public void setPoints(List<GeoPoint> points) {
		this.points = points;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public List<FinalUser> getDone_by() {
		return done_by;
	}

	public void setDone_by(List<FinalUser> done_by) {
		this.done_by = done_by;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public FinalUser getOwner() {
		return owner;
	}

	public void setOwner(FinalUser owner) {
		this.owner = owner;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

}
