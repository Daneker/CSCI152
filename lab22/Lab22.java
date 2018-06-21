/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab22;

import lab22.impl.LLQHashTableMap;
import lab22.impl.BSTMap;
import lab22.impl.BSTHashTableMap;

/**
 *
 * @author Пользователь
 */
public class Lab22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LLQHashTableMap<String, Integer> map = new LLQHashTableMap<>();
//        BSTHashTableMap<String, Integer> map = new BSTHashTableMap();
//        BSTMap<String, Integer> map = new BSTMap<>();
         try {
            map.removeAny();
         } catch (Exception e) {
            System.out.println(e.getMessage());
         } 
         
         map.define("Bota", 5);
         map.define("Aizhan", 1);
         map.define("Indira", 2);
         map.define("Nazgul", 3);
         map.define("Zhans", 4);
         System.out.println(map);
         
         map.remove("Bota");
         System.out.println(map);
         
         map.remove("Akbota");
         System.out.println(map);
         
         map.define("Indira", 6);
         map.define("Nazgul", 7);
         System.out.println(map);
         
         map.define("Chris", 6);
         map.define("Eva", 17);
         map.define("Ben", 9);
         System.out.println(map);
         
         try { 
            System.out.println("Removed: " + map.removeAny().getKey());
            System.out.println("Removed: " + map.removeAny().getKey());
            System.out.println(map);
         } catch (Exception ex) {
            System.out.println(ex.getMessage());
         }
         
         map.clear();
         System.out.println(map);
         
         map.define("Dani", 27);
         map.define("Tyler", 38);
         System.out.println(map);
    }
    
}
