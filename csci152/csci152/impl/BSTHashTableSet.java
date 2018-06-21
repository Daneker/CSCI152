/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;
import csci152.adt.HashTableSet;

/**
 *
 * @author Пользователь
 * @param <T>
 */
public class BSTHashTableSet <T extends Comparable >implements HashTableSet<T> {
    private BSTSet<T>[] buckets;
    private int numBuckets;
    private int size;

    public BSTHashTableSet(int numBuckets) {
        buckets = new BSTSet[numBuckets];
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
        int hash = abs(value.hashCode()) % buckets.length;
        if (!this.contains(value)){ 
            if (buckets[hash] == null) {
                buckets[hash] = new BSTSet<>();
                buckets[hash].add(value);
                size++;
            } else {
                buckets[hash].add(value);
                size++;
            }
        }       
    }

    @Override
    public boolean contains(T value) {
        int hash = abs(value.hashCode()) % buckets.length;
        if (buckets[hash] != null) {
            if (buckets[hash].contains(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        int hash = abs(value.hashCode()) % numBuckets;    
        if (buckets[hash].contains(value)) {
            size--;
            return buckets[hash].remove(value);
        }   
        return false; 
    }

    @Override
    public T removeAny() throws Exception {
        if (size > 0) {
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i].getSize() != 0) {
                    try {
                        size--;
                        return buckets[i].removeAny();                       
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        } else {
            throw new Exception("empty!");
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        buckets = new BSTSet[numBuckets];
    }

    @Override
    public int getNumberOfBuckets() {
        return numBuckets;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if (index >= 0 && index < numBuckets) {
            return buckets[index].getSize();
        } else {
            throw new Exception("wrong index");
        }
    }

    @Override
    public double getLoadFactor() {
        return size / buckets.length;
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
        String s = "";
        if (size != 0) {
    	int i = 0;
          while (i < numBuckets) {
        	if (buckets[i] != null)
                	s += buckets[i].toString() + "\n";
                	i++;
              }
        }
        return s + "  " + size + "\n";
    }
    
}
