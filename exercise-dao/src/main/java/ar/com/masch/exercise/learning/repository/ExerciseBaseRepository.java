package ar.com.masch.exercise.learning.repository;

import ar.com.masch.exercise.learning.entity.base.ExerciseBaseEntity;

public interface ExerciseBaseRepository extends BaseRepository<ExerciseBaseEntity, Long> {
	
	public ExerciseBaseEntity findByName(String name);

}
