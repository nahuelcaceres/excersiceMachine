package ar.com.masch.exercise.learning.entity.base;

import java.util.Date;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

@Table(name = "exercise_history")
@Entity(name = "exercise_history")
public class ExerciseHistoryEntity extends BaseEntity{
	
	@Column(name="TIMESTAMP", unique=false, nullable = false)
	private Date timeStamp;
	
	@Column(name="DURATION", unique=false, nullable = false)
	private Date duration;

	@Column(name="VELOCITY", unique=false, nullable = false)
	private Integer velocity;

	public ExerciseHistoryEntity() {
		super();
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public Integer getVelocity() {
		return velocity;
	}

	public void setVelocity(Integer velocity) {
		this.velocity = velocity;
	}

	
	
	
}
