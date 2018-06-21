/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab15;
import lab15.impl.Student;
import lab15.adt.Set;
import lab15.impl.QueueSet;
import lab15.impl.StackSet;

public class Lab15 {

    public static void main(String[] args) {
//        lab15_1();
//        lab15_2();
      //  lab15_3();
        lab15_4();
       // lab15_5();
    }
    
    static void lab15_1(){
        Set<Student> set = new QueueSet();
        
        try {
            set.removeAny();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        set.add(new Student(15, "daneker"));
        System.out.println(set+" and size:"+set.getSize());
        set.add(new Student(16, "dani"));
        System.out.println(set+" and size:"+set.getSize());
        set.add(new Student(84, "mark"));
        System.out.println(set+" and size:"+set.getSize());
        set.add(new Student(55, "peter"));
        System.out.println(set+" and size:"+set.getSize());
        set.add(new Student(44, "amanda"));
        System.out.println(set+" and size:"+set.getSize());
        
           
        try {
            set.remove(new Student(84, "mark"));
        } catch (Exception e) {
        }
        System.out.println(set+" and size:"+set.getSize());
        
        try {
            set.remove(new Student(54, "daniel"));
        } catch (Exception e) {
        }
        System.out.println(set+" and size:"+set.getSize());
        
        
        set.add(new Student(15, "daneker"));
        System.out.println(set+" and size:"+set.getSize());
        set.add(new Student(16, "dani"));
        System.out.println(set+" and size:"+set.getSize());
        
       
        set.add(new Student(12, "eva"));
        System.out.println(set+" and size:"+set.getSize());
        set.add(new Student(21, "gulnar"));
        System.out.println(set+" and size:"+set.getSize());
        set.add(new Student(35, "aikumis"));
        System.out.println(set+" and size:"+set.getSize());
        
       
        try {
            System.out.println("removed: "+set.removeAny());
            System.out.println("removed: "+set.removeAny());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(set+" and size:"+set.getSize());
        
        
        set.clear();
        System.out.println(set+" and size:"+set.getSize());
        
        set.add(new Student(20, "Aizhan"));
        System.out.println(set+" and size:"+set.getSize());
        set.add(new Student(25, "Aidana"));
        System.out.println(set+" and size:"+set.getSize());       
        
        
        
        
    }
    
    static void lab15_2(){
        Set<Student> set = new StackSet();
        
        
        try {
            set.removeAny();
            set.removeAny();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        set.add(new Student(1, "daneker"));
        System.out.println(set+" and size:"+set.getSize());
        set.add(new Student(3, "dani"));
        System.out.println(set+" and size:"+set.getSize());
        set.add(new Student(9, "mark"));
        System.out.println(set+" and size:"+set.getSize());
        set.add(new Student(7, "peter"));
        System.out.println(set+" and size:"+set.getSize());
        set.add(new Student(6, "amanda"));
        System.out.println(set+" and size:"+set.getSize());
        
           
        try {
            set.remove(new Student(9, "mark"));
        } catch (Exception e) {
        }
        System.out.println(set+" and size:"+set.getSize());
        
        try {
            set.remove(new Student(5, "daniel"));
        } catch (Exception e) {
        }
        System.out.println(set+" and size:"+set.getSize());
        
        
        set.add(new Student(1, "daneker"));
        System.out.println(set+" and size:"+set.getSize());
        set.add(new Student(3, "dani"));
        System.out.println(set+" and size:"+set.getSize());
        
       
        set.add(new Student(12, "eva"));
        System.out.println(set+" and size:"+set.getSize());
        set.add(new Student(21, "gulnar"));
        System.out.println(set+" and size:"+set.getSize());
        set.add(new Student(35, "aikumis"));
        System.out.println(set+" and size:"+set.getSize());
        
       
        try {
            System.out.println("removed: "+set.removeAny());
            System.out.println("removed: "+set.removeAny());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(set+" and size:"+set.getSize());
        
        
        set.clear();
        System.out.println(set+" and size:"+set.getSize());
        
        set.add(new Student(20, "Aizhan"));
        System.out.println(set+" and size:"+set.getSize());
        set.add(new Student(25, "Aidana"));
        System.out.println(set+" and size:"+set.getSize());       
        
    }
    
    static void lab15_3(){
        SetCheck check = new SetCheck();
        Set<Integer> set1 = new StackSet();
        Set<Integer> set2 = new StackSet();
        for (int i = 0; i < 10; i++) {
           set2.add(i); 
        }
        for (int i = 9; i > 7; i--) {
            set1.add(i);
        }
        System.out.println(set1+" and " +set2);
        System.out.println(check.isSubset(set1, set2));
        System.out.println(set1+" and " +set2);
    }
    
    static void lab15_4(){
        SetCheck check = new SetCheck();
        
        Set<String> set1 = new QueueSet();
        Set<String> set2 = new QueueSet();
        for (int i = 0; i < 10; i++) {
           set2.add(String.valueOf(i)); 
        }
        for (int i = 15; i > 7; i--) {
            set1.add(String.valueOf(i));
        }
           System.out.println(set1+" and " +set2);
        System.out.println(check.union(set1, set2));
           System.out.println(set1+" and " +set2);
    }
    
    static void lab15_5(){
        SetCheck check = new SetCheck();
        
        Set<Integer> set1 = new QueueSet();
        Set<Integer> set2 = new QueueSet();
        for (int i = 0; i < 10; i++) {
           set2.add(i); 
        }
        for (int i = 9; i > 4; i--) {
            set1.add(i);
        }
           System.out.println(set1+" and " +set2);
        System.out.println(check.intersection(set1, set2));
           System.out.println(set1+" and " +set2);
    }
}
 
    

