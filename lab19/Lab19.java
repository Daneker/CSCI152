package lab19;

import lab19.impl.BSTHashTableSet;
import lab19.impl.LLQHashTableSet;
import lab19.impl.Student;

public class Lab19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LLQHashTableSet<Student> set1_1 = new LLQHashTableSet(10);
        LLQHashTableSet<Student> set1_2 = new LLQHashTableSet(100);
        BSTHashTableSet<Student> set2_1 = new BSTHashTableSet(10);
        BSTHashTableSet<Student> set2_2 = new BSTHashTableSet(100);
        
        // lab19_1
        for (int i = 100; i < 300; i++) {
            set1_1.add(new Student(i, "Bob"));
        }
        System.out.println(set1_1.getLoadFactor());
        System.out.println(set1_1.getBucketSizeStandardDev());
        System.out.println("\n");
        
        
        for (int i = 100; i < 300; i++) {
            set1_2.add(new Student(i, "Bob"));
        }
        System.out.println(set1_2.getLoadFactor());
        System.out.println(set1_2.getBucketSizeStandardDev());
        System.out.println("\n\n");
    
    
        // lab19_2
        for (int i = 100; i < 300; i++) {
            set2_1.add(new Student(i, "Bob"));
        }
        System.out.println(set2_1.getLoadFactor());
        System.out.println(set2_1.getBucketSizeStandardDev());
        System.out.println("\n");   
        
        for (int i = 100; i < 300; i++) {
            set2_2.add(new Student(i, "Bob"));
        }
        System.out.println(set2_2.getLoadFactor());
        System.out.println(set2_2.getBucketSizeStandardDev());
    }
    
}
