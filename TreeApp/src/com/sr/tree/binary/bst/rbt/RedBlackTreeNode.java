/**
 * 
 */
package com.sr.tree.binary.bst.rbt;

import com.sr.tree.binary.BinarySearchTreeNode;

/**
 * @author sayanroy
 *
 */
public class RedBlackTreeNode extends BinarySearchTreeNode {
	
	private RedBlackTreeNode parent;
	
	private boolean color;

	public RedBlackTreeNode(int data, boolean color) {
		super(data);
		this.color = color;
	}

	public RedBlackTreeNode getParent() {
		return parent;
	}

	public void setParent(RedBlackTreeNode parent) {
		this.parent = parent;
	}

	public boolean getColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}
}
