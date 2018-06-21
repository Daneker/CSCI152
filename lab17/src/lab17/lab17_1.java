/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab17;
import lab17.adt.Set;
import lab17.impl.BSTSet;

/**
 *
 * @author Пользователь
 */
public class lab17_1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Set<Integer> set = new BSTSet();
        
        //////////////////////
        System.out.println("Add the integers 5, 12, 3, 6, 14, 2, -6, 8, and 0 to the set in that order");
        set.add(5); 
        set.add(12); 
        set.add(3); 
        set.add(6); 
        set.add(14); 
        set.add(2); 
        set.add(-6); 
        set.add(8); 
        set.add(0);         
        System.out.println(set+" and size:"+set.getSize());
     
        System.out.println("\nRemove the integers 0, 6, and 3 in that order, and print the set’s contents and size afterwards"); 
        set.remove(0);
        set.remove(6);
        set.remove(3);
        System.out.println(set+" and size:"+set.getSize());
        
        System.out.println("\nAdd the integers 6, 13, 99 and 11 to the set in that order");
        set.add(6);
        set.add(13);
        set.add(99);
        set.add(11);
        System.out.println(set+" and size:"+set.getSize());
        
        System.out.println("\nRemove the integer 12 from the set, and print the set’s contents and size");
        set.remove(12);
        System.out.println(set+" and size:"+set.getSize());
       
        System.out.println("\nRemove the integer 5 from the set (the root!), and print the set’s contents and size");
        set.remove(5);
        System.out.println(set+" and size:"+set.getSize());
        
        System.out.println("\nCall removeAny three times, and print the set’s contents and size");
        for (int i = 0; i < 3; i++) {
            try {
                 System.out.println("removed:"+set.removeAny());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println(set+" and size:"+set.getSize());

        ///////////
        System.out.println("\nAttempt to re-add the integers 14, -6, and 5 to the set");
        set.add(14); 
        set.add(-6); 
        set.add(5); 
        System.out.println(set+" and size:"+set.getSize());
      
        /////////////
        System.out.println("\nCall contains on the integers 12, 7, 2, -8, and 5, and verify that the returned results are correct");
        System.out.println("constains: 12 "+set.contains(12));
        System.out.println("constains: 7 "+set.contains(7));
        System.out.println("constains: 2 "+set.contains(2));
        System.out.println("constains: -8 "+set.contains(-8));
        System.out.println("constains: 5 "+set.contains(5));

        ////////////
        System.out.println("\nClear the set, and print its contents and resulting size");
        set.clear();
        System.out.println(set+" and size:"+set.getSize());
        
        //////
        System.out.println("\nFinally, add the integers 55, 24, 78, and 51 to the set, and print the set’s    ");    
        set.add(55); 
        set.add(24); 
        set.add(78); 
        set.add(51); 
        System.out.println(set+" and size:"+set.getSize());
                       
    }
}