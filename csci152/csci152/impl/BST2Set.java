package csci152.impl;

import csci152.adt.Set;

public class BST2Set<T extends Comparable<T>> implements Set<T>{

	private OnOffTreeNode<T> root;
	private int size;
	
	public BST2Set() {
		
		root = null;
		size = 0;		
	}

	public OnOffTreeNode<T> getRoot(){
		return root;
	}
	
	public void setRoot(OnOffTreeNode<T> root) {
		this.root = root;
	}
	
	@Override
	public void add(T value) {
		OnOffTreeNode<T> newTreeNode = new OnOffTreeNode<T>(value);
		size++;
		if (root == null) {
			root = newTreeNode;
		} else {
                    OnOffTreeNode<T> cur = root;
                    while (true) {
			if(value.compareTo(cur.getValue()) < 0){				
                            if(cur.getLeft() == null){
				cur.setLeft(newTreeNode);
				return;
			    }
			    cur = cur.getLeft();
			} else if (value.compareTo(cur.getValue()) > 0){
                            if(cur.getRight() == null){
				cur.setRight(newTreeNode);
				return;
                            }
                            cur = cur.getRight();
                        } else {
                            if (cur.isActive()) {
				size--;
				return;
                            } else {
				cur.setActive(true);
                            }
			}
                    }
		}
	}

	@Override
	public boolean contains(T value) {
		if (root == null) return false;
		OnOffTreeNode<T> curr = root;
		while (true) {
			if (curr.getValue().compareTo(value)>0){
				if (curr.getLeft() == null) return false;
				curr = curr.getLeft();
			}	
			else if(curr.getValue().compareTo(value)<0) {
				if (curr.getRight() == null) return false;
				curr = curr.getRight();
			}
			else {
				return true;
			}
		}
	}

	@Override
	public boolean remove(T value) {
		if (!contains(value)) return false;
		
		OnOffTreeNode<T> current = root;		
		while (true) {
			if (current.getValue().compareTo(value)>0) {
				if (current.getLeft() == null) return false;
				current = current.getLeft();

			} else if (current.getValue().compareTo(value)<0){
				if (current.getRight() == null) return false;
				current = current.getRight();
			
			} else {
				size--;
				current.setActive(false);
				return true;
			}
		}
	}

	@Override
	public T removeAny() throws Exception {
		if (size==0) {
                    throw new Exception("Set is empty!");
		}
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
		return toStringHelper(root)+"Size: "+size;
	}

	private String toStringHelper(OnOffTreeNode<T> node) {
		if (node == null) {
                    return "";
		} else if(node.isActive()) {
                    return toStringHelper(node.getLeft()) + " " + 
                            node.getValue() + " " + 
                            toStringHelper(node.getRight());
                } else {
                    return toStringHelper(node.getLeft()) + " " + 
                            toStringHelper(node.getRight());
		}
	}

}
