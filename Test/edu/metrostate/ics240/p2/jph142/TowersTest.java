package edu.metrostate.ics240.p2.jph142;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TowersTest {


	@Test
	void testPoperties() {
		Towers t = new Towers();
		Towers t2 = new Towers(3);

		assertEquals(5, t.getRingCount(1));
		assertEquals(0, t.getRingCount(2));
		assertEquals(0, t.getRingCount(3));

		assertEquals(3, t2.getRingCount(1));
		assertEquals(0, t2.getRingCount(2));
		assertEquals(0, t2.getRingCount(3));

		assertEquals(1, t.getTopDiameter(1));
		assertEquals(0, t.getTopDiameter(2));
		assertEquals(0, t.getTopDiameter(3));
	}

	@Test
	void testMove() {
		Towers t2 = new Towers(3);
		assertEquals(true, t2.move(1, 2));
		assertEquals(true, t2.move(1, 3));
		assertEquals(true, t2.move(2, 3));
		assertEquals(true, t2.move(1, 2));
		assertEquals(true, t2.move(3, 1));
		assertEquals(true, t2.move(3, 2));
		assertEquals(true, t2.move(1, 2));
		
		// assert startPeg is not empty and startPeg != endPeg
		assertEquals(false, t2.move(1, 2));
		assertEquals(false, t2.move(2, 2));
		assertEquals(false, t2.move(3, 3));
		assertEquals(false, t2.move(3, 1));
		
		//assert 0<peg<4
		assertEquals(false, t2.move(0, 4));
		assertEquals(false, t2.move(4, 0));
		assertEquals(false, t2.move(0, 0));
		assertEquals(false, t2.move(4, 4));
		assertEquals(false, t2.move(0, 2));
		assertEquals(false, t2.move(4, 3));
		assertEquals(false, t2.move(1, 4));
		assertEquals(false, t2.move(1, 0));
		
		//assert that diameter of startPeg < diameter of endPeg
		assertEquals(true, t2.move(2, 1));
		assertEquals(true, t2.move(2, 3));
		assertEquals(false, t2.move(2, 3));
		assertEquals(false, t2.move(2, 1));
		
		
		
	}
	
	@Test
	void testExceptions() {
		assertThrows(IllegalArgumentException.class, ()->{ new Towers(0);});
		assertThrows(IllegalArgumentException.class, ()->{ new Towers(65);});
		
		Towers t2 = new Towers(3);
		assertThrows(IllegalArgumentException.class, ()->{ t2.getRingCount(0);});
		assertThrows(IllegalArgumentException.class, ()->{ t2.getRingCount(4);});
		
		assertThrows(IllegalArgumentException.class, ()->{ t2.getTopDiameter(0);});
		assertThrows(IllegalArgumentException.class, ()->{ t2.getTopDiameter(4);});
	}
}
