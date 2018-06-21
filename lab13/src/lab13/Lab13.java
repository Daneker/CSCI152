package lab13;

import lab13.adt.Deque;
import lab13.impl.LinkedListDeque;

public class Lab13 {

    public static void main(String[] args) {
    
        LinkedListDeque<Integer> deque = new LinkedListDeque();
 
        try { deque.popFromBack();
            deque.popFromFront();}
        catch (Exception e) {
            System.out.println(e);}
        
        for (int i = 0; i < 5; i++) {deque.pushToFront(i);
        System.out.println(deque);}
        
      
        for (int i = 0; i < 5; i++) {
            try {deque.popFromFront();
            System.out.println(deque);} 
            catch (Exception e) {System.out.println(e);}}
        
           
        for (int i = 0; i < 6; i++) {deque.pushToFront(i);
        System.out.println(deque);        }
        System.out.println(deque);    
        
        for (int i = 0; i < 6; i++) {
            try {deque.popFromBack();
            System.out.println(deque);} 
            catch (Exception e) {System.out.println(e);}}
        System.out.println(deque);    
             
           
        for (int i = 0; i < 7; i++) {deque.pushToBack(i);
        System.out.println(deque);    }
        System.out.println(deque);        
     
        for (int i = 0; i < 7; i++) {
            try {deque.popFromBack();
            System.out.println(deque);    } 
            catch (Exception e) {System.out.println(e);}}
        System.out.println(deque);  
        
        for (int i = 0; i < 8; i++) {deque.pushToBack(i);
        System.out.println(deque);    }
        System.out.println(deque);        
     
        for (int i = 0; i < 8; i++) {
            try {deque.popFromFront();
            System.out.println(deque);    } 
            catch (Exception e) {System.out.println(e);}}
        System.out.println(deque);  
          
        for (int i = 0; i < 10; i++) {
            deque.pushToFront(i);
            deque.pushToBack(i);
        System.out.println(deque);    }
        System.out.println(deque);        
     
        for (int i = 0; i < 8; i++) {
            try {deque.popFromFront();
                deque.popFromBack();
            System.out.println(deque);    } 
            catch (Exception e) {System.out.println(e);}}
        System.out.println(deque);  
        
        deque.clear();
        System.out.println(deque); 
    
        
        for (int i = 0; i < 10; i++) {
            deque.pushToBack((int)(Math.random()*100));
        }
        System.out.println("initially:\n"+deque);
        
        System.out.println("finally:\n"+mergeSort(deque));
      
    }
    
    public static Deque<Integer> merge(Deque<Integer> d1, Deque<Integer> d2) { 
        Deque<Integer> result = new LinkedListDeque<>(); 
            try { 
                while (d1.getSize()>0 && d2.getSize()>0) { 
                    int a=d1.popFromFront(), b=d2.popFromFront(); 
                    if (a<=b) { 
                        result.pushToBack(a); 
                        d2.pushToFront(b); 
                    } else { 
                        result.pushToBack(b); 
                        d1.pushToFront(a); 
                    } 
                } 
                while (d1.getSize()!=0) { 
                    int a=d1.popFromFront(); 
                    result.pushToBack(a); 
                } 
                while (d2.getSize()!=0) { 
                    int b=d2.popFromFront(); 
                    result.pushToBack(b); 
                } 
            } catch (Exception ex) { 
                System.out.println(ex.getMessage()); 
            } 
            return result; 
           
    }
 
    public static Deque<Integer> mergeSort(Deque<Integer> deq) {
         int size = deq.getSize();
         if(size <= 1) return deq;
         else{
             int mid = (deq.getSize()/ 2);
             Deque<Integer> d1 = new LinkedListDeque();
             for (int i = 0; i < mid; i++) {
                try {d1.pushToBack(deq.popFromFront());} 
                catch (Exception e) {System.out.println(e);}
             }
             
             Deque<Integer> d2 = new LinkedListDeque();
             for (int i = mid; i < size; i++) {
                try {d2.pushToBack(deq.popFromFront());} 
                catch (Exception e) {System.out.println(e);}
             }
             
             d1 = mergeSort(d1);
             d2 = mergeSort(d2);       
             return merge(d1, d2);     
         }
    }  
}
