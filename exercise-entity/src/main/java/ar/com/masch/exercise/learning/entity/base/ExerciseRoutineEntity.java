package ar.com.masch.exercise.learning.entity.base;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name= "exercise_routine")
@Entity(name= "exercise_routine")
public class ExerciseRoutineEntity extends BaseEntity{
	//TODO: hacer los getters y setters de las entidades
	
	private RoutineEntity routineEntity;
	private ExerciseBaseEntity exerciseBaseEntity;

	public ExerciseRoutineEntity () {
		super();
	}
	
}
