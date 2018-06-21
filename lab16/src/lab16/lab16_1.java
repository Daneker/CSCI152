/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab16;
import lab16.impl.BSTSet;

public class lab16_1 {
    public static void main(String[] args) {
        BSTSet<Integer> set = new BSTSet();
        
        System.out.println("Adds the integers 5, 12, 3, 6, 14, 2, -6, 8, "
                + "and 0 to the set in that order");
        set.add(5);
        set.add(12);
        set.add(3);
        set.add(6);
        set.add(14);
        set.add(2);
        set.add(-6);
        set.add(8);
        set.add(0);
        System.out.println(set + " and size: " + set.getSize());
        
        System.out.println("\nAttempts to re-add the integers 14, -6, and 5 to the set");
        set.add(14);
        set.add(-6);
        set.add(5);
        System.out.println(set + " and size: " + set.getSize());
       
        System.out.println("\nCalls contains on the integers 12, 7, 2, -8, and 5");
        System.out.println("contains: 12 " + set.contains(12));
        System.out.println("contains: 7 " + set.contains(7));
        System.out.println("contains: 2 " + set.contains(2));
        System.out.println("contains: -8 " + set.contains(-8));
        System.out.println("contains: 5 " + set.contains(5));
        System.out.println(set + " and size: " + set.getSize());
    
        System.out.println("\nClears the set, and print its contents and resulting size");
        set.clear();
        System.out.println(set + " and size: " + set.getSize());
    
        System.out.println("\nAdds the integers 55, 24, 78, and 51 to the set, and print "
                + "its contents and size");    
        set.add(55); 
        set.add(24); 
        set.add(78); 
        set.add(51); 
        System.out.println(set + " and size: " + set.getSize());     
    }
}
