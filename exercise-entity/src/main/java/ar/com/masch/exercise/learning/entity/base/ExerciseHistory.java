package ar.com.masch.exercise.learning.entity.base;

import java.util.Date;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

@Table(name = "exercise_history")
@Entity(name = "exercise_history")
public class ExerciseHistory extends BaseEntity{
	//TODO: hacer los getters y setters
	
	@Column(name="TIMESTAMP", unique=false, nullable = false)
	private Date timeStamp;
	
	@Column(name="DURATION", unique=false, nullable = false)
	private Date duration;

	@Column(name="VELOCITY", unique=false, nullable = false)
	private Integer velocity;

	public ExerciseHistory() {
		super();
	}
	
	
}
