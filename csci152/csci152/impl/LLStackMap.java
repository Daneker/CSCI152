 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.KeyValuePair;
import csci152.adt.Map;

/**
 *
 * @author Пользователь
 * @param <K>
 * @param <V>
 */
public class LLStackMap<K, V> implements Map<K, V> {
    
    private LinkedListStack<KeyValuePair<K, V>> pairs;
    
    public LLStackMap() {
        pairs = new LinkedListStack();
    }

    @Override
    public void define(K key, V value) {
        KeyValuePair<K, V> newPair = new KeyValuePair(key, value);
        if (getValue(key) == null) {
            pairs.push(newPair);
        } else {
        try {
            LinkedListStack<KeyValuePair<K, V>> temp = new LinkedListStack();
            int size = pairs.getSize();
            for(int i = 0; i < size; i++) {
                KeyValuePair<K, V> current = pairs.pop();
                if(key.equals(current.getKey())) {
                    temp.push(newPair);
                } else {
                    temp.push(current);
                }
            }
            
            for(int i = 0; i < temp.getSize(); i++) {
                pairs.push(temp.pop());
            }     
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        }
    }
    

    @Override
    public V getValue(K key) {
        try { 
            LinkedListStack<KeyValuePair<K, V>> temp = new LinkedListStack();
            int size = pairs.getSize();
            for(int i = 0; i < size; i++) {
                KeyValuePair<K, V> current = pairs.pop();
                temp.push(current);
                if(current.getKey().equals(key)) {
                    return current.getValue();
                }
            }
            for(int i = 0; i < temp.getSize(); i++) {
                pairs.push(temp.pop());
            }
        } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        return null;
    }

    @Override
    public V remove(K key) {
        if (pairs.getSize() == 0) {
            return null;
        } else {
        try {
            LinkedListStack<KeyValuePair<K, V>> temp = new LinkedListStack();
            int size = pairs.getSize();
            for(int i = 0; i < size; i++) {
                KeyValuePair<K, V> current = pairs.pop();   
                if(current.getKey().equals(key)) {
                    return current.getValue();
                } else {
                    temp.push(current);
                }
            }
            for(int i = 0; i < temp.getSize(); i++) {
                pairs.push(temp.pop());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null; 
        }
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if(pairs.getSize() == 0) {
            throw new Exception("map is empty");
        }    
        return pairs.pop();   
    }

    @Override
    public int getSize() {
        return pairs.getSize();
    }
    
    @Override
    public void clear() {
         pairs.clear();
    }
    
    @Override
    public String toString() {
        return pairs.toString() + "Size: " + pairs.getSize();
    }
}
