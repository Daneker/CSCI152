package lab23;

import lab23.impl.TowerOfHanoi;

public class HanoiTest {
    
    public static void main(String[] args) {
	int x = 3;
	TowerOfHanoi tow = new TowerOfHanoi(x);
	solve(tow, x, 0, 1, 2);
	if (tow.isFinished()) {
            System.out.println(tow.getNumMoves());
        }
            System.out.println(tow);
            System.out.println(tow.isFinished());
    }

    private static void solve(TowerOfHanoi tow, int x, int a, int b, int c) {
        if (x == 1) {
            try {
                tow.moveDisc(a, c);
            } catch(Exception e) {}
            System.out.println(" from "+"Disk 1"+a+" to "+c);
        } else {
            try {
                solve(tow, x-1, a, c, b);
                tow.moveDisc(a, c);
            } catch(Exception e) {}
            System.out.println("Disk "+x+" from "+a+" to "+c);
            solve(tow, x-1, b, a, c); 
        }
    }
}