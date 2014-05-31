package ar.com.masch.exercise.learning.repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.apache.log4j.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

import org.springframework.data.repository.CrudRepository;

public abstract class CRUDRepositoryBaseTest<T> {
	
	private static Logger logger = Logger.getLogger(CRUDRepositoryBaseTest.class);
	
	private List<T> elementsCreated = new ArrayList<T>();
	private List<ArrayList<T>> elementsSamples = new ArrayList<ArrayList<T>>();
	private List<ArrayList<T>> elementsSearched = new ArrayList<ArrayList<T>>();
	
	public abstract void fillElementsSamples();
	public abstract void searchElements();
	public abstract void assertValues(T obj1, T obj2);

	public abstract void doTest();
	
	protected boolean created;
	
	public List<T> getElementsSamples() {
		return this.elementsSamples.get(0);
	}
	
	public List<T> getElementsCreated() {
		return this.elementsCreated;
	}
	
	protected void addSamples(ArrayList<T> samples) {
		this.elementsSamples.add(samples);
	}
	
	protected void addSearched(ArrayList<T> searched) {
		this.elementsSearched.add(searched);
	}	
	
	protected void reloadSampleElementes() {

		logger.debug("\tCleaning elements samples...");
		this.elementsSamples.clear();
		
		logger.debug("\tFilling elements samples - second time ...");
		this.fillElementsSamples();

	}
	
	public void doTest(CrudRepository<T, Long> repository) {
		
		if (!this.created) {
			logger.debug("Entering doTest ...");
	
			this.elementsCreated.clear();
			this.elementsSearched.clear();		
			
			logger.debug("\tFilling elements samples - fist time ...");
			this.fillElementsSamples();
			
			logger.debug("\tCreating elements samples ...");
			this.createElments(repository);
			
			this.reloadSampleElementes();
			
			logger.debug("\tSearcing elements ...");
			this.searchElements();
			
			logger.debug("\tAsserting search elements ...");
			this.assertElementsList(this.elementsSamples, this.elementsSearched);
			
			logger.debug("\tAsserting created elements ...");
			this.assertElements(this.elementsSamples.get(0), this.elementsCreated);		
			
			//NOTA: Lo llamo 2 veces para que se creen otros objetos ejemplos.
			this.reloadSampleElementes();
			
			logger.debug("Exiting doTest ...");
			this.created = true;
		}

	}
	
	public void createElments(CrudRepository<T, Long> repository) {
		
		logger.debug("Entering create elements ...");
		
		for (T element : this.elementsSamples.get(0)) {
			logger.debug("\tSaving element ...");
			T authorEntityCreated = repository.save(element);

			logger.debug("\tFinish element created...");
			assertNotNull(authorEntityCreated);

			this.elementsCreated.add(authorEntityCreated);
		}

		logger.debug("Exiting create elements ...");
	}
	
	public void assertNotNullBase(T obj1, T obj2) {
		
		assertNotNull(obj1);
		assertNotNull(obj2);

	}
	
	public void assertNotNullBase(List<T> obj1, List<T> obj2) {
		
		assertNotNull(obj1);
		assertNotNull(obj2);

	}	
	
	public void assertNotNullBase(Set<T> obj1, Set<T> obj2) {
		
		assertNotNull(obj1);
		assertNotNull(obj2);

	}	
	
	public void assertNotEqualsValuesBase(T obj1, T obj2) {
		
		assertNotNullBase(obj1, obj2);
		assertNotEquals(obj1, obj2);

	}
	
	public void assertEqualsValuesBase(T obj1, T obj2) {
		
		assertNotNullBase(obj1, obj2);
		assertEquals(obj1, obj2);

	}
	
	public void assertEqualsValuesBase(List<T> objList1, List<T> objList2) {
		
		assertNotNullBase(objList1, objList2);
		assertEquals(objList1, objList2);

	}
	
	public void assertEqualsValuesBase(Set<T> objList1, Set<T> objList2) {
		
		assertNotNullBase(objList1, objList2);
		assertEquals(objList1, objList2);

	}
	
	public void assertElements(List<T> elementsSamples, List<T> elementsCompare) {
		
		logger.debug("Entering assertElements ...");
		
		assertNotNull(elementsSamples);
		assertNotNull(elementsCompare);
		assertEquals(elementsSamples.size(), elementsCompare.size());
		
		for (int i = 0; i < elementsSamples.size(); i++) {
			logger.debug("\tEntering assert element sample " + i + " ...");

			logger.debug("\t\tEntering assert value created " + i + " ...");
			assertValues(elementsSamples.get(i), elementsCompare.get(i));
			logger.debug("\t\tFinish assert value created " + i + " ...");
			
			logger.debug("\tFinish assert element sample " + i + " ...");
		}
		
	}
		
	private void assertElementsList(List<ArrayList<T>> elementsSampleList, List<ArrayList<T>> elementsSearchedList) {
		logger.debug("Entering assertElements ...");
		
		assertNotNull(elementsSampleList);
		assertNotNull(elementsSearchedList);
		assertEquals(elementsSampleList.size(), elementsSearchedList.size());
		
		for (int i = 0; i < elementsSampleList.size(); i++) {
			logger.debug("\tEntering assert element sample " + i + " ...");
			
			ArrayList<T> elementsSampleElements = elementsSampleList.get(0);
			ArrayList<T> elementsSearchedElements = elementsSearchedList.get(0);
			
			for (int j = 0; j < elementsSampleElements.size(); j++) {
				
				logger.debug("\t\t\tEntering assert value searced " + j + " ...");
				assertValues(elementsSampleElements.get(i), elementsSearchedElements.get(i));
				logger.debug("\t\t\tFinish assert value searced " + j + " ...");
			}

			logger.debug("\tFinish assert element sample " + i + " ...");
		}
		
	}

}
