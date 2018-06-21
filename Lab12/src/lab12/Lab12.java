package lab12;

import lab12.impl.LinkedListSortedQueue;
import lab12.impl.Student;

public class Lab12 {

    public static void main(String[] args) {
        //lab12_1();
        lab12_2();

    }
    
    static void lab12_1(){
        LinkedListSortedQueue<Integer> sq = new LinkedListSortedQueue();
        
        for(int i=90; i>0; i-=10){
            sq.insert(i);
        }
        System.out.println(sq+", size:"+ sq.getSize());
           
        for(int i=0; i<3; i++)
            try {
                sq.dequeue();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        System.out.println(sq+", size:"+ sq.getSize());

        for(int i=100; i<=900; i+=100){
            sq.insert(i);
        }
        System.out.println(sq+", size:"+ sq.getSize());

        for(int i=0; i<4; i++)
            try {
                sq.dequeue();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        System.out.println(sq+", size:"+ sq.getSize());
        
        for(int i=5; i<=915; i+=10){
            sq.insert(i);
        }
        System.out.println(sq+", size:"+ sq.getSize());

        int size = sq.getSize();
        for(int i=0; i<size; i++){
            try {
                sq.dequeue();
            } catch (Exception ex) {
                System.out.println(ex);
            }            
        }
        System.out.println(sq+", size:"+ sq.getSize());

        sq.insert(22);        
        sq.insert(36);
        sq.insert(-13);
        System.out.println(sq+", size:"+ sq.getSize());
       
        sq.clear();
        System.out.println(sq+", size:"+ sq.getSize());
        
        sq.insert(266);        
        sq.insert(-6);
        sq.insert(-33);
        sq.insert(125);

        System.out.println(sq+", size"+ sq.getSize());
    }
    
    static void lab12_2(){
        LinkedListSortedQueue<Student> sortStud = new LinkedListSortedQueue();
        Student st1 = new  Student(2007, "Daneker");
        Student st2 = new  Student(2017, "Daniker");
        Student st3 = new  Student(2015, "Deniker");        
        Student st4 = new  Student(1999, "Denaker");

        sortStud.insert(st1);
        sortStud.insert(st2);
        sortStud.insert(st3);
        sortStud.insert(st4);
        sortStud.insert(st2);

        System.out.println(sortStud);

        for(int i=0; i<2; i++)
            try {
                sortStud.dequeue();
            } catch (Exception e) {
                System.out.println(e);
            }
        System.out.println(sortStud);
    }  
}
