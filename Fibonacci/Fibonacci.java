package csci152.impl;

import csci152.impl.LLQHashTableMap;
import csci152.adt.Map;

public class Fibonacci {

	/////////////////////////
	// Version One
	/////////////////////////
	
	private static int callCount1;
	
	public static long fibCalc1(int n) {
		
	    callCount1++;
		if (n == 0 || n == 1) {
		  return 1;
		}
		else {
		  return fibCalc1(n-1)+fibCalc1(n-2);
		}
	}
	
	
	public static void testFibCalc1(int n) {
		callCount1 = 0;
		System.out.println("fibCalc1("+n+") = " + fibCalc1(n) +
				"; takes " + callCount1 + " calls.");
	}
	
	/////////////////////////
	// Version Two
	/////////////////////////
	
	private static int callCount2;
	
	private static Map<Integer, Long> ansMap = new LLQHashTableMap<Integer, Long>(20);
	
	public static long fibCalc2(int n) {
		
	  long a = 1;
	  callCount2++;
	  if (n == 0 || n == 1) {
	    ansMap.define(n, a);
	    return 1;
	  } 
	  else if (ansMap.getValue(n) == null) {
		long ans = fibCalc2(n-1)+fibCalc2(n-2);
		ansMap.define(n, ans);
		return ans;
	  }
	  else {
		return ansMap.getValue(n);
	  }
	}
	
	
	public static void testFibCalc2(int n) {
		callCount2 = 0;

		System.out.println("fibCalc2("+n+") = " + fibCalc2(n) +
				"; takes " + callCount2 + " calls.");
	}
	
	///////////
	
	public static void main(String[] args) {
		
		for (int x = 0; x < 30; x++) {
			testFibCalc1(x);
		}
		
		for (int x = 0; x < 30; x++) {
			testFibCalc2(x);
		}
		
	}
}
