package ar.com.masch.exercise.learning.entity.base;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

@Table(name = "exercise_base")
@Entity(name = "exercise_base")
public class ExerciseBaseEntity extends NameBaseEntity {
		
	@Column(name="DURATION", unique=false, nullable = true)
	private Integer duration;

	@Column(name="VELOCITY", unique=false, nullable = true)
	private Integer velocity;
	
	public ExerciseBaseEntity() {
		super();
	}
	
	public ExerciseBaseEntity(Long id, String name, Integer duration, Integer velocity) {
		super(id, name);
		this.duration = duration;
		this.velocity = velocity;
	}

	@Override
	public String toString() {
		String result = "\nExerciseBaseEntity-> " + super.toString() +
				        "\nDuration: " + this.duration +
				        "\nVelocity: " + this.velocity;
		
		return result;
	}
	
	public Integer getDuration() {
		return duration;
	}
	
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	public Integer getVelocity() {
		return velocity;
	}
	
	public void setVelocity(Integer velocity) {
		this.velocity = velocity;
	}

}
