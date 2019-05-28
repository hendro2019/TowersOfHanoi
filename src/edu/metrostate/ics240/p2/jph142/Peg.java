/**
 * 
 */
package edu.metrostate.ics240.p2.jph142;

/**
 * @author John
 *
 */
public class Peg {
	// Array for holing diameter of rings of this peg.
	private int[] rings;
	// The number of rings on this peg
	private int numRings;
	
	/**
	 * initializes this Peg to size n
	 * 
	 * @param n The size of this peg.
	 */
	public Peg(int n) {
		rings = new int[n];
	}
	
	/**
	 * Gets the number of rings on this Peg.
	 * 
	 * @return numRings The number of rings on this peg.
	 */
	public int ringCount() {
		return numRings;
	}
	
	/**
	 * Gets the diameter of the top ring on this Peg.
	 * 
	 * @return if numRings is zero, returns zero. Else returns the diameter of the top ring on this Peg.
	 */
	public int diameterOfTop() {
		return (numRings == 0) ? 0 : rings[numRings - 1];
	}
	
	/**
	 * Adds a ring to the top of this Peg.
	 * 
	 * @param diameter The diameter of the ring to be added.
	 */
	public void add(int diameter) {

		rings[numRings] = diameter;
		numRings++;
	}
	
	/**
	 * Removes a ring from the top of this peg.
	 * 
	 * @return The top ring of this peg.
	 */
	// Should not be called if numRings is 0.
	public int remove() {
		numRings--;
		return rings[numRings];
		
	}
	
	/**
	 * Tests if this Peg is empty.
	 * 
	 * @return true if this Peg is empty, else returns false.
	 */
	public boolean isEmpty() {
		return numRings == 0 ;
	}
	
	/**
	 * Loads rings on to this Peg.
	 */
	public void load() {
		
		for (int ring = rings.length; ring > 0; ring--) {
			add(ring);
		}
	}

}
