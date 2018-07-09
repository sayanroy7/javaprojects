/**
 * 
 */
package com.sr.tree.binary;

/**
 * @author sayanroy
 *
 */
public class BinaryTreeNode {
	
	private BinaryTreeNode right;
	
	private BinaryTreeNode left;
	
	private int data;
	
	public BinaryTreeNode(int data) {
		this.data = data;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BinaryTreeNode other = (BinaryTreeNode) obj;
		if (data != other.data)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ""+data;
	}
}
