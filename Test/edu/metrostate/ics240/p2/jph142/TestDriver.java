package edu.metrostate.ics240.p2.jph142;

public class TestDriver {
static int n = 15; // Number of disks 
	
	static Towers game = new Towers(n);
	
	// Java recursive function to solve tower of hanoi puzzle 
    public static void towerOfHanoi(int n, int startPeg, int endPeg, int auxPeg) 
    { 
        if (n == 1) 
        { 
        	game.move(startPeg, endPeg); 
            return; 
        } 
        
        towerOfHanoi(n-1, startPeg, auxPeg, endPeg); 
        game.move(startPeg, endPeg); 
        towerOfHanoi(n-1, auxPeg, endPeg, startPeg); 
    } 
    
    public static void main(String args[]) 
    { 
        
        towerOfHanoi(n, 1, 2, 3);  
        
        System.out.println(game.getRingCount(1));
        System.out.println(game.getRingCount(2));
        System.out.println(game.getRingCount(3));
    }    
   
}
