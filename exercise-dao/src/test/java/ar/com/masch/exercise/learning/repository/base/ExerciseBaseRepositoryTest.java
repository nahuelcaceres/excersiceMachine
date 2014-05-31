package ar.com.masch.exercise.learning.repository.base;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.masch.exercise.learning.entity.base.ExerciseBaseEntity;
import ar.com.masch.exercise.learning.repository.CRUDRepositoryBaseTest;
import ar.com.masch.exercise.learning.repository.ExerciseBaseRepository;

public class ExerciseBaseRepositoryTest extends CRUDRepositoryBaseTest<ExerciseBaseEntity> {

	@Autowired
	private ExerciseBaseRepository exerciseBaseRepository;	
	
	@Override
	public void fillElementsSamples() {
		ArrayList<ExerciseBaseEntity> elementsSamples = new ArrayList<ExerciseBaseEntity>();
		
		for (int i = 0; i < 5; ++i) {
			ExerciseBaseEntity exerciseBaseEntity1 = new ExerciseBaseEntity(null, "exerciseBaseName" + i, i, i);
			ExerciseBaseEntity exerciseBaseEntity2 = new ExerciseBaseEntity(null, "exerciseBaseName" + i+1, i+1, i+1);
			
			elementsSamples.add(exerciseBaseEntity1);
			elementsSamples.add(exerciseBaseEntity2);
			
		}

		this.addSamples(elementsSamples);
		
	}

	@Override
	public void searchElements() {
		
		ArrayList<ExerciseBaseEntity> elementsSearchedByName = new ArrayList<ExerciseBaseEntity>();
		
		//Find By Name
		for (ExerciseBaseEntity exerciseBaseEntity : this.getElementsSamples()) {
			ExerciseBaseEntity elementSearchedByName = this.exerciseBaseRepository.findByName(exerciseBaseEntity.getName());
			assertNotNull(elementSearchedByName);
			elementsSearchedByName.add(elementSearchedByName);
		}
		this.addSearched(elementsSearchedByName);
		
	}
	
	@Override
	public void assertValues(ExerciseBaseEntity obj1, ExerciseBaseEntity obj2) {
		super.assertNotEqualsValuesBase(obj1, obj2);
		
		//assertEquals(obj1.getId(), obj2.getId());
		assertEquals(obj1.getName(), obj2.getName());
		assertEquals(obj1.getDuration(), obj2.getDuration());
		assertEquals(obj1.getVelocity(), obj2.getVelocity());
		
	}

	public void doTest() {

		super.doTest(this.exerciseBaseRepository);

	}	
	
}
