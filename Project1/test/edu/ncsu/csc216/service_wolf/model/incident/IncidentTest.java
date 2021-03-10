package edu.ncsu.csc216.service_wolf.model.incident;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
/**
 * tests the incindent class
 * @author edwin
 *
 */
public class IncidentTest {
	/**
	 * resets counter before each test
	 * @throws Exception exception
	 */
	@Before
	public void setUp() throws Exception {
		//Reset the counter at the beginning of every test.
		Incident.setCounter(1);
	}
	/**
	 * tests the Incident constructor
	 */
	@Test
	public void testIncident() {
		Incident i1 = new Incident("title", "caller", "message");
		Incident i2;
		Incident i3;
		Incident i4;
		i2 = null;
		try {
			i2 = new Incident(null, "caller", "message");
			fail();
		}
		catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		i3 = null;
		try {
			i3 = new Incident("title", null, "message");
			fail();
		}
		catch (IllegalArgumentException e) {
			assertNull(i3);
		}
		i4 = null;
		try {
			i4 = new Incident("title", "caller", null);
			fail();
		}
		catch (IllegalArgumentException e) {
			assertNull(i4);
		}
		
		assertEquals(i1.getTitle(), "title");
		assertEquals(i1.getCaller(), "caller");
		assertEquals(i1.getState(), "New");
		assertEquals(i1.getOwner(), "Unowned");
		ArrayList<String> list = new ArrayList<String>();
		list.add("abc");
		Incident i5 = new Incident(1, "New", "title", "caller", 0, "Unowned", Incident.NO_STATUS, list);
		assertEquals(i5.getId(), 1);
		assertEquals(i5.getState(), "New");
		assertEquals(i5.getTitle(), "title");
		assertEquals(i5.getCaller(), "caller");
		assertEquals(i5.getReopenCount(), 0);
		assertEquals(i5.getOwner(), "Unowned");
		assertEquals(i5.getStatusDetails(), Incident.NO_STATUS);
		assertEquals(i5.getIncidentLogMessages(), "- abc\n");
		
	}

	

}
