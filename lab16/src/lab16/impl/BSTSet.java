package lab16.impl;

import lab16.adt.Set;

import lab16.impl.TreeNode;

public class BSTSet<T extends Comparable<T>> implements Set<T> {

    private TreeNode<T> root;
    private int size;
    
    public BSTSet() {
        root = null;
        size = 0;
    }
    public boolean contains(T value){
		TreeNode<T> current = root;
		while(current != null){
			if(current.getValue().equals(value)){
				return true;
			}else if(current.getValue().compareTo(value) > 0){
				current = current.getLeft();
			}else{
				current = current.getRight();
			}
		}
		return false;
	}
    
    @Override
    public void add(T value){
		TreeNode<T> newNode = new TreeNode<T>(value);
		if(root == null){
			root = newNode;
			size = 1;
		}
		else if (!contains(value)) {
		  size++;
		TreeNode<T> current = root;
		TreeNode<T> parent = null;
		while(true){
			parent = current;
			if(value.compareTo(current.getValue())<0){				
				current = current.getLeft();
				if(current==null){
					parent.setLeft(newNode);
					return;
				}
			}else{
				current = current.getRight();
				if(current==null){
					parent.setRight(newNode);
					return;
				}
			}
		}
    }
    }
    
    @Override
    public boolean remove(T value){
		TreeNode<T> parent = root;
		TreeNode<T> current = root;
		boolean isLeftChild = false;
		while(current.getValue()!=value){
			parent = current;
			if(current.getValue().compareTo(value)>0){
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
	
		if(current.getLeft()==null && current.getRight()==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.setLeft(null);
			}else{
				parent.setRight(null);
			}
		}
		
		else if(current.getRight()==null){
			if(current==root){
				root = current.getLeft();
			}else if(isLeftChild){
				parent.setLeft(current.getLeft());
			}else{
				parent.setRight(current.getLeft());
			}
		}
		else if(current.getLeft()==null){
			if(current==root){
				root = current.getRight();
			}else if(isLeftChild){
				parent.setLeft(current.getRight());
			}else{
				parent.setRight(current.getRight());
			}
		}else if(current.getLeft()!=null && current.getRight()!=null){
			
			TreeNode<T> successor	 = getSuccessor(current);
			if(current==root){
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
	
	public TreeNode<T> getSuccessor(TreeNode<T> deleleNode){
		TreeNode<T> successsor =null;
		TreeNode<T> successsorParent =null;
		TreeNode<T> current = deleleNode.getRight();
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.getLeft();
		}
		
		if(successsor!=deleleNode.getRight()){
			successsorParent.setLeft(successsor.getRight());
			successsor.setRight(deleleNode.getRight());
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

    public String toStringHelper(TreeNode<T> node) {
        if (node == null) {
            return "";
        }
        return toStringHelper(node.getLeft()) + node.getValue() + "\t" + toStringHelper(node.getRight());

    }
}

