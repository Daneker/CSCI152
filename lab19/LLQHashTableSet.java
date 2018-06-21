/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab19.impl;
import lab19.adt.HashTableSet;

/**
 *
 * @author Пользователь
 * @param <T> applicable for all types
 */

public class LLQHashTableSet<T> implements HashTableSet<T> {
    private LinkedListQueue<T> []buckets;
    private int numBuckets;
    private int size;
    
    public LLQHashTableSet(int numBuckets){
        buckets = new LinkedListQueue[numBuckets];
        size = 0;
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
            int hash = abs(value.hashCode()) % buckets.length;
                
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
        int hash = abs(value.hashCode()) % buckets.length;
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
        if (contains(value)) {
            int hash = abs(value.hashCode()) % buckets.length;          
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
        for (int i = 0; i < buckets.length; i++) {
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
    public int getNumberOfBuckets() {
        return buckets.length;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if(abs(index) > numBuckets){
            throw new Exception ("wrong index");
        } else {
            return buckets[index].getSize();
        }
    }

    @Override
    public double getLoadFactor() {
        return size/buckets.length;
    }

    @Override
    public double getBucketSizeStandardDev() {
     int mean , sum = 0;
        for (int i = 0; i < buckets.length; i++) {
            if(buckets[i] != null)
            sum += buckets[i].getSize();
        }
        mean = sum/buckets.length;
        
        int sumOfSquares = 0;
        
        for (int i = 0; i < buckets.length; i++) {
            int s = 0;
            if(buckets[i]!= null) {
                s = buckets[i].getSize();
            } 
            sumOfSquares += Math.pow(s - mean , 2);
        }
        
        return Math.sqrt(sumOfSquares/buckets.length);

    }

    @Override
    public String bucketsToString() {
        String result = "";
        for(int i = 0; i < buckets.length; i++){
              result += i + ":" + buckets[i] + "  ";
            }
        result += "Size: " +  size;
        return result;
    }
    
}


