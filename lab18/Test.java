/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab18.impl;
import lab18.adt.Set;

/**
 *
 * @author Пользователь
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
     Set<Integer> set = new LLQHashTableSet(5000);

     System.out.println("Starting timing tests...");
     long time1, time2, duration;
     time1 = System.currentTimeMillis();
      
     for (int i = 0; i < 500000; i++) {
          set.add(i);
     }
   
     time2 = System.currentTimeMillis();
     duration = time2 - time1;

     System.out.println("Time taken in ms: " + duration);
}      
}


