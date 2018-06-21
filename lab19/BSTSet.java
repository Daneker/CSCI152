/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab19.impl;
import lab19.adt.Set;

/**
 *
 * @author Пользователь
 */
public class BSTSet<T extends Comparable> implements Set<T> {

    private TreeNode<T> root;
    private int size;
    
    public BSTSet() {
        root = null;
        size = 0;
    }
    
    @Override
    public void add(T value) {
        addHelper(root, value);
    }

    private void addHelper(TreeNode<T> node, T value) {
        if (node == null) {
            root = new TreeNode(value);
            size++;
            return;
        }
        if (value.compareTo(node.getValue()) == 0) {
            return;
        }
        if (value.compareTo(node.getValue()) > 0) {
            if (node.getRight() == null) {
                node.setRight(new TreeNode(value));
                size++;
            } else {
                addHelper(node.getRight(), value);
            }
        } else if (value.compareTo(node.getValue()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new TreeNode(value));
                size++;
            } else {
                addHelper(node.getLeft(), value);
            }
        }
    }

    @Override
    public boolean contains(T value) {
        return containsHelper(root, value);
    }

    private boolean containsHelper(TreeNode<T> node, T value) {
        if (node == null) {
            return false;
        }
        if (value.equals(node.getValue())) {
            return true;
        }
        if (value.compareTo(node.getValue()) < 0) {
            return containsHelper(node.getLeft(), value);
        } else {
            return containsHelper(node.getRight(), value);
        }
    }

     @Override
    public boolean remove(T value){
	TreeNode<T> parent = root;
	TreeNode<T> current = root;
	boolean isLeftChild = false;
	while(current.getValue()!= value){
            parent = current;
            if(value.compareTo(current.getValue()) < 0){
                isLeftChild = true;
                current = current.getLeft();
            }else{
                isLeftChild = false;
                current = current.getRight();
            }
            if(current == null){
                return false;
            }
	}
	//case1: no child
	if(current.getLeft()== null && current.getRight()== null){
            if(current == root){
            	root = null;
            }
            if(isLeftChild == true){
		parent.setLeft(null);
            }else{
                parent.setRight(null);
            }
        }	
	else if(current.getRight()== null){
            if(current == root){
		root = current.getLeft();
            }else if(isLeftChild){
		parent.setLeft(current.getLeft());
            }else{
                parent.setRight(current.getLeft());
            }
	}
	else if(current.getLeft()== null){
            if(current==root){
		root = current.getRight();
            }else if(isLeftChild){
		parent.setLeft(current.getRight());
            }else{
                parent.setRight(current.getRight());
            }
	}
        else if(current.getLeft() != null && current.getRight()!= null){
            TreeNode<T> successor = getSuccessor(current);
            if(current == root){
		root = successor;
            }else if(isLeftChild){
		parent.setLeft(successor);
            }else{
		parent.setRight(successor);
            }			
            successor.setLeft(current.getLeft());
	}		
	
        return true;		
    }
	
    public TreeNode<T> getSuccessor(TreeNode<T> deleteNode){
	TreeNode<T> successsor = null;
	TreeNode<T> successsorParent = null;
	TreeNode<T> current = deleteNode.getRight();
	while(current != null){
		successsorParent = successsor;
		successsor = current;
		current = current.getLeft();
	}
		
	if(successsor != deleteNode.getRight()){
		successsorParent.setLeft(successsor.getRight());
		successsor.setRight(deleteNode.getRight());
	}
	return successsor;
    }

    
    private TreeNode<T> findMin(TreeNode<T> node){
        if(node.getLeft() == null){
            return node;
        }
        return findMin(node.getLeft());
    }
    
    
    @Override
    public T removeAny() throws Exception {
      if (size == 0) {
    	throw new Exception ("Set is empty!!!");
      }
        T result = findMin(root).getValue();
        remove(result);
        return result;
    }

    @Override
    public int getSize() {
       return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }
    
    @Override
    public String toString() {
        return toStringHelper(root);
    }
    
    private String toStringHelper(TreeNode<T> node) {
        if(node == null) {
            return "";
        }
        return toStringHelper(node.getLeft()) + " " + 
                node.getValue() + " " +
                toStringHelper(node.getRight());
    }
    
}
