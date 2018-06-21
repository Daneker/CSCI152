package csci152.impl;

import java.util.HashSet;
import java.util.Set;

public class BSTSetTest {

	public static void main(String[] args) {
		Set<Integer> bsts = new HashSet<Integer>();

		bsts.add(5);
		bsts.add(12);
		bsts.add(3);
		bsts.add(6);
		bsts.add(14);
		bsts.add(2);
		bsts.add(-6);
		bsts.add(8);
		bsts.add(0);
		
		System.out.println(bsts);
		
		bsts.add(14);
		bsts.add(-6);
		bsts.add(5);
		bsts.add(55);
		
		System.out.println(bsts);
		
		System.out.println(bsts.contains(12)+" - (12)");
		System.out.println(bsts);
		
		System.out.println(bsts.contains(7)+" - (7)");
		System.out.println(bsts);
		
		System.out.println(bsts.contains(2)+" - (2)");
		System.out.println(bsts);
		
		System.out.println(bsts.contains(-8)+" - (-8)");
		System.out.println(bsts);
		
		System.out.println(bsts.contains(5)+" - (5)");
		System.out.println(bsts);
		
		bsts.add(0);
		bsts.add(6);
		bsts.add(3);
		
		System.out.println(bsts);
		
		bsts.add(6);
		bsts.add(13);
		bsts.add(99);
		bsts.add(11);
		
		System.out.println(bsts);
		
		bsts.remove(12);
		System.out.println(bsts);
		
		bsts.remove(5);
		System.out.println(bsts);
		
		bsts.clear();
		System.out.println(bsts);
		
		bsts.add(55);
		bsts.add(24);
		bsts.add(78);
		bsts.add(51);
		
		bsts.remove(78);
		System.out.println(bsts);
	}
}
