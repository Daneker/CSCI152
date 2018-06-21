/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab16;
import lab16.impl.BSTSet;
import lab16.impl.Student;
/**
 *
 * @author Пользователь
 */
public class lab16_2 {
    public static void main(String[] args) {
        BSTSet<Student> set = new BSTSet();
        //////////////////////

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

               

    }

}
    

