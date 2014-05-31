package ar.com.masch.exercise.learning.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.com.masch.exercise.learning.repository.base.ExerciseBaseRepositoryTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ctx/exercise-repository-test-context.xml")
public class RunnableCRUDRepositoryBaseTest<T> {
	
	@Autowired
	private ExerciseBaseRepositoryTest exerciseBaseRepositoryTest;
	
	@Test
	public void testAuthorRepository() {

		this.exerciseBaseRepositoryTest.doTest();

	}
	
}
