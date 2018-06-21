package csci152.impl;

public class ArrayListStackTest {

  public static void main(String[] args) {
	ArrayListStack<Integer> s = new ArrayListStack<Integer>();
	try{
	  s.pop();
	}catch(Exception ex) {
	  System.out.println(ex.getMessage());
	}
	for (int i = 0; i < 12; i++) {
	  s.push(i);
	}
	System.out.println(s);
	
	try{
	  s.pop();
	  s.pop();
	  s.pop();
	}catch(Exception ex) {
	  System.out.println(ex.getMessage());
	}
	System.out.println(s);
	
	s.clear();
	System.out.println(s);
	
	for (int i = 0; i < 22; i++) {
	  s.push(i);
	}
	System.out.println(s);
  }

}
