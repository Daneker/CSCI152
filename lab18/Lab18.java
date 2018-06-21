/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab18;
import lab18.impl.LLQHashTableSet;
/**
 *
 * @author Пользователь
 */
public class Lab18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LLQHashTableSet<Integer> ht_set = new LLQHashTableSet(10);
 
        try { 
            ht_set.removeAny();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        for (int i = 1; i <= 20; i++) {
            ht_set.add(i);
        }
        System.out.println("");
        System.out.println(ht_set); 
        
        for (int i = 2; i <=20 ; i+=2) {
            ht_set.remove(i);
        }
        System.out.println("");
        System.out.println(ht_set); 
        
        System.out.println("");
        System.out.println(ht_set.remove(10));
        System.out.println(ht_set.remove(100));
        System.out.println(ht_set); 
        
        for (int i = 1; i <=30; i++) {
            ht_set.add(i);
        }
        System.out.println("");
        System.out.println(ht_set);    
        
        for (int i = 0; i < 10; i++) {
            try {
                ht_set.removeAny();
                } 
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("");
        System.out.println(ht_set);    
             
        ht_set.clear();
        System.out.println("");
        System.out.println(ht_set);  
        
        for (int i = 51; i <=79; i+=2) {
            ht_set.add(i);
        }
        System.out.println("");
        System.out.println(ht_set);         
    
    }
    
}
