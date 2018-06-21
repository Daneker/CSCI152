/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab22.impl;

import lab22.adt.HashTableMap;
import lab22.adt.KeyValuePair;

/**
 *
 * @author Пользователь
 * @param <K>
 * @param <V>
 */
public class BSTHashTableMap<K extends Comparable, V> implements HashTableMap<K, V> {
   
    private TreeNode<KeyValuePair<K, V>>[] buckets;
    private int numBuckets;
    private int size;

    public BSTHashTableMap(int numBuckets) {
        buckets = new TreeNode[numBuckets];
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
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public V getValue(K key) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int getNumberOfBuckets() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
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
