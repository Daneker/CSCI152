/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab22.impl;

import lab22.adt.KeyValuePair;
import lab22.adt.Map;
import lab22.adt.TreeNode;

/**
 *
 * @author User
 * @param <K>
 * @param <V>
 */
public class BSTMap <K extends Comparable, V> implements Map <K, V> {
    private TreeNode<KeyValuePair<K , V>> root;
    private int size;
    
    public BSTMap () {
        root = null;
        size=0;
    }

    @Override
    public void define(K key, V value) {
        defineHelper(root, key, value);
    }
    private void defineHelper(TreeNode<KeyValuePair<K, V>> node, K key, V value)  {
        if (root==null) {
            root = new TreeNode(new KeyValuePair(key, value));    
            size++;
            return;
        }
        if (node.getValue().getKey().compareTo(key)==0) {
            node.setValue(new KeyValuePair(key, value));
        }
        else if (node.getValue().getKey().compareTo(key)>0){
            if (node.getLeft()==null) {
                node.getLeft().setValue(new KeyValuePair(value, key));
                size++;
                
            }
            else {
                defineHelper(node.getLeft(), key, value);
                
            }
        }
        else if (node.getValue().getKey().compareTo(key)<0) {
            if (node.getRight()==null) {
                node.getRight().setValue(new KeyValuePair(value, key));
                size++;
            }
            else {
                defineHelper(node.getRight(), key, value);
            }
        }
        
    }

    @Override
    public V getValue(K key) { 
        return getValueHelper(root, key);

    }
    
    private V getValueHelper(TreeNode<KeyValuePair<K, V>> node, K key) {
        if (root==null) {
            return null;
        }
        else if (node.getValue().getKey().compareTo(key)>0) {
            if (node.getLeft()==null) {
                return null;
            }
            else {
                return node.getLeft().getValue().getValue();
            }
        }
              
        else if (node.getValue().getKey().compareTo(key)<0) {
            if (node.getRight()==null) {
                return null;
            }
            else {
                return node.getRight().getValue().getValue();
            }
        }
        else if (node.getValue().getKey().compareTo(key)==0) {
            return node.getValue().getValue();
        }
        return null;
    }

    @Override
    public V remove(K key) {
        return removeHelper(root, key);
    }
    
    private V removeHelper(TreeNode<KeyValuePair<K,V>> node, K key){
        if (root==null) {
            return null;
        }
        else if (node.getValue().getKey().compareTo(key)<0){
            if (node.getLeft()==null) {
                return null;
            }
            else {
                return  node.getLeft().getValue().getValue();
              
            }
        }
      return null;  
    }
    
    private TreeNode<KeyValuePair<K, V>> findMin(TreeNode<KeyValuePair<K, V>> node){
        if(node.getLeft() == null){
            return node;
        }
        return findMin(node.getLeft());
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
              if (size == 0) {
    	throw new Exception ("Set is empty!!!");
      }
        KeyValuePair<K, V> result = findMin(root).getValue();
        remove(result.getKey());
        return result;
      }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root=null;
        size=0;
    }
    @Override
    public String toString() {
        return root.toString();
    }
    
}
