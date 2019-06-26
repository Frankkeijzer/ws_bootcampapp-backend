package nl.workingspirit.ws_bootcampappbackend.domein;

import org.junit.Test;
import org.junit.Assert;

public class AssignmentTest {
	
	@Test
	public void testAssignment() {
	Assignment sut = makeNewAssignment();
//	Assert.assertEquals("testtest", sut.getDescription());
	}
	
	
	
	public Assignment makeNewAssignment() {
	Assignment assignment = new Assignment();
	assignment.setLevel("3");
	assignment.setDay("1");
	assignment.setVisible(true);
	assignment.setDescription("Dit is jullie eerste opdracht");
	assignment.setTitle("Opdracht 1");
	assignment.setCodeExample("een code example");
	return assignment;
	}

}