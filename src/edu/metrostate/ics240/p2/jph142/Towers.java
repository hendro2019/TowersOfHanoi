/**
 * 
 */
package edu.metrostate.ics240.p2.jph142;

/**
 * Class Towers simulates a game of towers of Hanoi.
 * Each Tower has 3 pegs and n number of rings.
 * 
 * @author John
 *
 */
public class Towers {
	// Holds Pegs
	private Peg[] pegs = new Peg[3];
	

	/**
	 * Initializes this Tower with n rings on the first Peg.
	 * 
	 * @param rings the number of rings in the game
	 */
	public Towers(int rings) {
		if (rings < 1 || rings > 64)
			throw new IllegalArgumentException("rings is out of range (1 - 64): " + rings);

		pegs[0] = new Peg(rings);
		pegs[1] = new Peg(rings);
		pegs[2] = new Peg(rings);

		pegs[0].load();

	}

	/**
	 * Initializes this Tower with 5 rings on the first Peg.
	 */
	public Towers() {
		this(5);
	}

	/**
	 * Gets the number of rings on specified.
	 * 
	 * @param pegNumber the number (1-3), of the specified Peg.
	 * @return the number of rings on specified Peg.
	 */
	public int getRingCount(int pegNumber) {
		if (pegNumber < 1 || pegNumber > 3)
			throw new IllegalArgumentException("pegNumber is out of range (1 - 3): " + pegNumber);

		return pegs[pegNumber - 1].ringCount();
	}
	
	/**
	 * Gets diameter of top ring.
	 * 
	 * @param pegNumber the number (1-3), of the specified.
	 * @return Diameter of top ring.
	 */
	public int getTopDiameter(int pegNumber) {
		if (pegNumber < 1 || pegNumber > 3)
			throw new IllegalArgumentException("pegNumber is out of range (1 - 3): " + pegNumber);

		return pegs[pegNumber - 1].diameterOfTop();

	}
	
	/**
	 * Moves a ring from startPeg to endPeg
	 * 
	 * @param startPeg the number (1-3), of the starting Peg the ring is moved from.
	 * @param endPeg the number (1-3), of the end Peg the ring is moved to.
	 * @return true if the move was legal and executed, else returns false.
	 */
	public boolean move(int startPeg, int endPeg) {

		if (startPeg < 1 || endPeg < 1 || startPeg > 3 || endPeg > 3)
			return false;

		--startPeg;
		--endPeg;

		if (pegs[startPeg].isEmpty() || startPeg == endPeg)
			return false;
		
		if (pegs[startPeg].diameterOfTop() < pegs[endPeg].diameterOfTop() || pegs[endPeg].isEmpty()) {
			int ring = pegs[startPeg].remove();
			pegs[endPeg].add(ring);
			return true;
		}

		else
			return false;

	}

}
