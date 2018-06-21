
package csci152.impl;

import csci152.adt.Stack;

public class TowerOfHanoi {

	@SuppressWarnings("unchecked")
	private Stack<Integer>[] post = new ArrayStack[3];
	private int numMoves = 0;
	
	public TowerOfHanoi(int numDiscs) {
		
	  post[0] = new ArrayStack<Integer>();
	  post[1] = new ArrayStack<Integer>();
	  post[2] = new ArrayStack<Integer>();
	  
	  for (int i = numDiscs; i >= 1; i--) {
		post[0].push(i);
	  }
	  
	}
	
	public void moveDisc(int from, int to) throws Exception {
		
	  if ((post[from].getSize() == 0) || (from < 0 || from > 2 || to < 0 || to > 2)){
		throw new Exception ("Error!!!");
	  }
	  if (post[to].getSize() == 0) {
		post[to].push(post[from].pop());
		numMoves++;
	  }
	  else {
		  int top1 = post[from].pop();
		  int top2 = post[to].pop();
		  if (top1 < top2) {
			post[to].push(top2);
			post[to].push(top1);
		    numMoves++;
		  }
		  else {
	      post[from].push(top1);
		  post[to].push(top2);
		  throw new Exception ("You cannot move like this!!!");
	      }
	  }
	  }
	
	public boolean isFinished() {
		if (post[0].getSize() == post[1].getSize() && post[0].getSize()==0) {
		  return true;
		  }
		return false;
	}
	
	public int getNumMoves() {
		return numMoves;
	}
	
	public String toString() {
	  String str = "";
		for (int i = 0; i < 3; i++) {
		  str += post[i].toString() + "\n";
		}
		return str;
	}
	
}
