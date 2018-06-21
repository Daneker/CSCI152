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
 * @param <T> applicable for all types
 */

public class LLQHashTableSet<T> implements Set<T> {
    private LinkedListQueue<T> []buckets;
    private int numBuckets;
    private int size;
    
    public LLQHashTableSet(int numBuckets){
        buckets = new LinkedListQueue[numBuckets];
        size = 0;
        this.numBuckets = numBuckets;
    }

    public int abs(int val) {
        if(val >= 0) {
            return val;
        } else {
            return -val;
        }
    }
    @Override
    public void add(T value) {
        if(!contains(value)) {
            int hash = abs(value.hashCode()) % numBuckets;
                
            if (buckets[hash] == null) {
                buckets[hash] = new LinkedListQueue();
                buckets[hash].enqueue(value);
            } else {
            buckets[hash].enqueue(value);
            }
            size++;
        }
          }

    @Override
    public boolean contains(T value) {
        int hash = abs(value.hashCode()) % numBuckets;
        if (size == 0 || buckets[hash] == null) {
            return false;
        } 
      
        for (int i = 0; i < buckets[hash].getSize(); i++) {
            try {
                T curr = buckets[hash].dequeue();
                buckets[hash].enqueue(curr);
                if(curr.equals(value))
                    return true;
            } catch (Exception ex) {
                System.out.println(ex);
            }  
        }
        return false;    
    }

    @Override
    public boolean remove(T value) {
//        if(contains(value)) {
//            int hash = abs(value.hashCode()) % numBuckets;
//            T curr = null;        
//            while(!value.equals(curr)){
//                try {
//                   curr = buckets[hash].dequeue();
//                } catch (Exception e) {
//                    System.out.println(e);
//                }  
//                buckets[hash].enqueue(curr);
//            }        
//            size--;
//            return true; 
//        } else {
//            return false;   
//        }
        if (contains(value)) {
            int hash = abs(value.hashCode()) % numBuckets;          
            for (int i = 0; i < buckets[hash].getSize(); i++) {
                try {
                    T curr = buckets[hash].dequeue();
                    if (curr.equals(value)) {
                        size--;
                        return true;
                    } else {
                        buckets[hash].enqueue(curr);
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                } 
            }
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        if(size == 0) {
            throw new Exception("empty");
        }
        for (int i = 0; i < numBuckets; i++) {
            if(buckets[i].getSize() != 0) {
                size--;
                return buckets[i].dequeue();
            }
        }
        return null;
       }

    @Override
    public int getSize() {
        return size;
    } 

    @Override
    public void clear() {
         buckets = new LinkedListQueue[numBuckets];
         size = 0;
     }

    @Override
    public String toString() {    
        String result = "";
        for(int i = 0; i < numBuckets; i++){
              result +=  buckets[i] + " ";
            }
        result += "Size: " +  size;
        return result;
    }
    
}


