/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab21.impl;

import lab21.adt.KeyValuePair;
import lab21.adt.Map;

/**
 *
 * @author Пользователь
 * @param <K>
 * @param <V>
 */
public class LLQueueMap<K, V> implements Map<K, V> {

    private LinkedListQueue<KeyValuePair<K, V>> pairs;

    public LLQueueMap() {
        pairs = new LinkedListQueue();
    }

    @Override
    public void define(K key, V value) {
        KeyValuePair<K, V> newPair = new KeyValuePair(key, value);
        if (getValue(key) == null) {
            pairs.enqueue(newPair);
        } else {
            try {
                for (int i = 0; i < pairs.getSize(); i++) {
                    KeyValuePair<K, V> temp = pairs.dequeue();
                    if (temp.getKey().equals(key)) {
                        pairs.enqueue(newPair);
                    } else {
                        pairs.enqueue(temp);
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public V getValue(K key) {
        if (pairs.getSize() == 0) {
            return null;
        } else {
            for (int i = 0; i < pairs.getSize(); i++) {
                try {
                    KeyValuePair<K, V> temp = pairs.dequeue();
                    pairs.enqueue(temp);
                    if (temp.getKey().equals(key)) {
                        return temp.getValue();
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {

        if (pairs.getSize() == 0) {
            return null;
        } else {
            for (int i = 0; i < pairs.getSize(); i++) {
                try {
                    KeyValuePair<K, V> temp = pairs.dequeue();
                    if (temp.getKey().equals(key)) {
                        return temp.getValue();
                    } else {
                        pairs.enqueue(temp);
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
        if (pairs.getSize() == 0) {
            throw new Exception("map is empty");
        }
        return pairs.dequeue();
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
