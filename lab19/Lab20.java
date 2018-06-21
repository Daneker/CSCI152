package lab20;

import lab19.impl.BSTHashTableSet;
import lab19.impl.LLQHashTableSet;
import lab19.impl.Student;
import java.util.Random; 

public class Lab20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LLQHashTableSet<Integer> set1_1 = new LLQHashTableSet(10);
        BSTHashTableSet<Integer> set2_1 = new BSTHashTableSet(10);
        Random rand = new Random(); 
        
 for (int i = 0; i < 499; i+=10) {
            set1_1.add(i);
        }
       
        System.out.println(set1_1.getLoadFactor());
        System.out.println(set1_1.getBucketSizeStandardDev());
        System.out.println("\n");

        for (int i = 0; i <50000; i++) {
            set2_1.add(rand.nextInt());
        }
        System.out.println(set2_1.getLoadFactor());
        System.out.println(set2_1.getBucketSizeStandardDev());
        System.out.println("\n");   
        
    }
    
}
