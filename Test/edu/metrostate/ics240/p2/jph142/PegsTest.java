package edu.metrostate.ics240.p2.jph142;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PegsTest {

	@Test
	void testPoperties() {
		Peg rod = new Peg(5);
		
		assertEquals(0, rod.diameterOfTop());
		assertEquals(0, rod.remove());
		assertEquals(true, rod.isEmpty());
		
		rod.load();
		
		assertEquals(5, rod.ringCount());
		assertEquals(1, rod.diameterOfTop());
		assertEquals(1, rod.remove());
		assertEquals(false, rod.isEmpty());
		
		
	}

}
