package csci152.impl;

import csci152.impl.TowerOfHanoi;

public class HanoiTest {

  private static void solve(TowerOfHanoi pazl, int n, int a, int b, int c) {
    
    if (n == 1) {
      try {
        pazl.moveDisc(a, c);
        }
      catch(Exception ex) {
          System.out.println(ex.getMessage());
        }
      System.out.println("Disk 1" + " from " + a + " to " + c);
	}
	else {
      solve(pazl, n-1, a, c, b);
      try {
        pazl.moveDisc(a, c);
      }
      catch(Exception ex) {}
      System.out.println("Disk " + n + " from " + a + " to " + c);
      solve(pazl, n-1, b, a, c); 
	}
  }
  
  public static void main(String[] args) {

	int n=3;
	TowerOfHanoi pazl = new TowerOfHanoi(n);
	solve(pazl, n, 0, 1, 2);
	if (pazl.isFinished())
    System.out.println(pazl.getNumMoves());
	System.out.print(pazl);
	System.out.println(pazl.isFinished());
}
}