/**
 * 
 */
package com.sr.tree.binary.bst.avl;

import com.sr.tree.binary.BinarySearchTreeNode;

/**
 * @author sayanroy
 *
 */
public class AVLTreeNode extends BinarySearchTreeNode {
	
	private int height;

	public AVLTreeNode(int data) {
		super(data);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
