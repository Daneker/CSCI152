/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.HashTableMap;
import csci152.adt.KeyValuePair;

/**
 *
 * @author Пользователь
 * @param <K>
 * @param <V>
 */
public class LLQHashTableMap<K extends Comparable, V> implements HashTableMap<K, V> {
    private LinkedListQueue<KeyValuePair<K, V>> []buckets;
    private int numBuckets;
    private int size;
    
    public LLQHashTableMap(int numBuckets){
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
    public void define(K key, V value) {
          KeyValuePair<K, V> newPair = new KeyValuePair(key, value);
          if (getValue(key) == null) {
            int hash = abs(key.hashCode()) % buckets.length;
                
            if (buckets[hash] == null) {
                buckets[hash] = new LinkedListQueue();
                buckets[hash].enqueue(newPair);
            } else {
            buckets[hash].enqueue(newPair);
            }
            size++;
        }
    }

    @Override
    public V getValue(K key) {
           int hash = abs(key.hashCode()) % buckets.length;
        if (size == 0 || buckets[hash] == null) {
            return null;
        } 
      
        for (int i = 0; i < buckets[hash].getSize(); i++) {
            try {
                KeyValuePair<K, V> curr = buckets[hash].dequeue();
                buckets[hash].enqueue(curr);
                if(curr.getKey().equals(key))
                    return curr.getValue();
            } catch (Exception ex) {
                System.out.println(ex);
            }  
        }
        return null;        
        }

    @Override
    public V remove(K key) {
        if (getValue(key) != null) {
            int hash = abs(key.hashCode()) % buckets.length;          
            for (int i = 0; i < buckets[hash].getSize(); i++) {
                try {
                    KeyValuePair<K, V> curr = buckets[hash].dequeue();
                    if (curr.getKey().equals(key)) {
                        size--;
                        return curr.getValue();
                    } else {
                        buckets[hash].enqueue(curr);
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                } 
            }
        }
        return null;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if(size == 0) {
            throw new Exception("empty");
        }
        for(int i = 0; i < buckets.length; i++) {
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


