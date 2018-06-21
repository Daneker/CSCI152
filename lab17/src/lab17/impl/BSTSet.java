/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab17.impl;
import lab17.adt.Set;

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
    public boolean remove(T value) {
        if (contains(value)) {
            root = removeHelper(root, value);
            size--;
        }
        return false;
    }

    private TreeNode<T> removeHelper(TreeNode<T> node, T value) {
        if (node.getValue().equals(value)) {
            if (node.getRight() == null) {
                node = node.getLeft();
            } else if (node.getLeft() == null) {
                node = node.getRight();
            } else {
                node = lift(node, value);
            }
        } else {
            if (value.compareTo(node.getValue()) < 0) {
                node.setLeft(removeHelper(node.getLeft(), value));
            } else if (value.compareTo(node.getValue()) > 0) {
                node.setRight(removeHelper(node.getRight(), value));
            }
        }
        return node;

    }

    private TreeNode<T> lift(TreeNode<T> node, T toRemove) {
        if (node.getRight() == null) {
            return node.getLeft();
        }
            node.setRight(lift(node.getRight(), toRemove));
            return node;
        
    }

    @Override
    public T removeAny() throws Exception {
        T result = root.getValue();
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
